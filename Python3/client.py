
# Импорт пакета https://github.com/AndreyShapovalovVN/pyxroad.git
from XRoad.Client import XClient

# Подключение к сервису Требиты
x = XClient(
    'http://192.168.1.52',
    client='SEVDEIR-TEST/GOV/11110012/MONITORING',
    service='SEVDEIR-TEST/GOV/11110012/MONITORING/getPersonInfoPy',
)

# Присвоение значения атрибута <Header><userId>
x.userId = '0123456789'
# Обращение к методу <getPersonInfoPy>
# с необязательным атрибутом 'xroad_id' который будет передан в <Header><id>
# Ответ содержит объект типа OrderDict

for inn in ('12345670', '12345671', '12345672')
    response = x.request(personId=inn)
    print(response)


response = x.request(xroad_id='1234sfdgtr', personId='12345678')

body = response.get('body')
service = x._default_soapheaders.get('service').get('serviceCode')
if body:
    response = dict(body.get('%sResult' % service))

print(response)
