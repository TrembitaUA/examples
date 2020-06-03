import psycopg2
from spyne import Application, rpc, ServiceBase, String, Date
from spyne.model.complex import ComplexModel
from spyne.protocol.soap import Soap11
from spyne.util.etreeconv import *


class UserDefinedContext(object):
    def __init__(self, flask_app):
        self.config = flask_app.config
        self.logger = flask_app.logger


class ServiceDateResult(ComplexModel):
    inn = String()
    firstname = String()
    surname = String()
    patronymic = String()
    birthdate = Date()
    passport_ser = String()
    passport_num = String()


class Soap(ServiceBase):
    @rpc(String, _returns=ServiceDateResult)
    def getPersonInfoPy(ctx, personId):
        ctx.udc.logger.info('-' * 100)
        ctx.udc.logger.info("Request inn: %s" % personId)

        header = root_etree_to_dict(
            etree_strip_namespaces(ctx.in_document)
        )['Envelope'][0]['Header'][0]
        if header:
            ctx.udc.logger.info("UXP Heades information:")
            client = header['client'][0]
            service = header['service'][0]
            for k in client.keys():
                ctx.udc.logger.info('client %s = %s' % (k, client[k][0]))
            for k in service.keys():
                ctx.udc.logger.info('service %s = %s' % (k, service[k][0]))
            ctx.udc.logger.info("id = %s" % header['id'][0])
            ctx.udc.logger.info("userId = %s" % header['userId'][0])
        else:
            ctx.udc.logger.info("Not UXP Heades")

        sql = "select * from people where inn = '%s'" % personId
        ctx.udc.logger.info("Query: %s" % sql)

        conn = psycopg2.connect(
            dbname='dbtest', host='192.168.122.181',
            user='uxptraining', password='uxptraining',
        )
        cursor = conn.cursor()
        cursor.execute(sql)
        if cursor.rowcount > 0:
            personInfo = dict(zip(
                [column[0] for column in cursor.description],
                cursor.fetchone()
            ))
            cursor.close()
        else:
            personInfo={}
        conn.close()

        ctx.udc.logger.info(personInfo)
        ctx.udc.logger.info("Save result")

        res = ServiceDateResult()
        if personInfo:
            res.inn = personInfo.get('inn')
            res.firstname = personInfo.get('firstname')
            res.surname = personInfo.get('surname')
            res.patronymic = personInfo.get('patronymic')
            res.birthdate = personInfo.get('birthdate')
            res.passport_ser = personInfo.get('passport_ser')
            res.passport_num = personInfo.get('passport_num')

        ctx.udc.logger.info('*' * 100)
        return res


def soap(flask_app):
    application = Application(
        [Soap],
        tns=flask_app.config.get('NAMESPACE'),
        name='getPersonInfoPy',
        in_protocol=Soap11(validator='lxml'),
        out_protocol=Soap11()
    )

    def _flask_conf_context(ctx):
        ctx.udc = UserDefinedContext(flask_app)

    application.event_manager.add_listener('method_call', _flask_conf_context)

    return application
