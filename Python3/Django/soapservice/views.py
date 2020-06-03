import logging

from django.db import connection
from spyne import Application, rpc, ServiceBase, String, Date
from spyne.model.complex import ComplexModel
from spyne.protocol.soap import Soap11
from spyne.util.etreeconv import *

logger = logging.getLogger(__name__)


class ServiceDateResult(ComplexModel):
    inn = String()
    firstname = String()
    surname = String()
    birthdate = Date()
    passport_ser = String()
    passport_num = String()


class Soap(ServiceBase):
    @rpc(String, _returns=ServiceDateResult)
    def getPersonInfoPy(ctx, personId):
        print('-' * 100)
        print("Request inn: %s" % personId)

        header = root_etree_to_dict(
            etree_strip_namespaces(ctx.in_document)
        )['Envelope'][0]['Header'][0]
        if header:
            print("UXP Heades information:")
            client = header['client'][0]
            service = header['service'][0]
            for k in client.keys():
                print('client %s = %s' % (k, client[k][0]))
            for k in service.keys():
                print('service %s = %s' % (k, service[k][0]))
            print("id = %s" % header['id'][0])
            print("userId = %s" % header['userId'][0])
        else:
            print("Not UXP Heades")

        sql = "select * from people where inn = '%s'" % personId
        print("Query: %s" % sql)

        cursor = connection.cursor()
        cursor.execute(sql)
        personInfo = dict(zip(
            [column[0] for column in cursor.description],
            cursor.fetchone()
        ))

        print(personInfo)
        print("Save result")

        res = ServiceDateResult()
        if personInfo:
            res.inn = personInfo.get('inn')
            res.firstname = personInfo.get('firstname')
            res.surname = personInfo.get('surname')
            res.birthdate = personInfo.get('birthdate')
            res.passport_ser = personInfo.get('passport_ser')
            res.passport_num = personInfo.get('passport_num')

        print('*' * 100)
        return res


application = Application(
    [Soap],
    tns='http://trembita.gov.ua',
    name='getPersonInfoPy',
    in_protocol=Soap11(validator='lxml'),
    out_protocol=Soap11()
)

# hello_app = csrf_exempt(DjangoApplication(application))
