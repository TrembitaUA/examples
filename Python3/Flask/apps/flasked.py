from flask import Flask, make_response, request

app = Flask(__name__)

app.config.from_object('settings')

page_home = 'Доступны следующие сервисы:'
page_home += '<br> <a href="http://{h}:{p}/trembita/?wsdl">WSDL URL</a>\n'
page_home = page_home.format(h=app.config.get('APP_HOST'),
                             p=app.config.get('APP_PORT')
                             )


@app.route('/')
def home():
    response = make_response(page_home.encode('utf_8'))
    response.headers['Content-Type'] = 'text/html; charset=utf-8'
    return response
