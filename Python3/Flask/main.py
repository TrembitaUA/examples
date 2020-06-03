#!/usr/bin/env python3
import logging

from spyne.server.wsgi import WsgiApplication
from werkzeug.middleware.dispatcher import DispatcherMiddleware

from apps.flasked import app
from apps.soap_app import soap

my_apps = {
    '/trembita': WsgiApplication(soap(app)),
}

app.wsgi_app = DispatcherMiddleware(app.wsgi_app, my_apps)

llevel = logging.DEBUG if app.config.get('DEBUG') else logging.INFO

soap_hendler = logging.FileHandler('./logs/standart.log')
soap_hendler.setFormatter(logging.Formatter(
    '[%(asctime)s] [%(process)d] [%(levelname)s] %(name)s: %(message)s'
))

app.logger.setLevel(llevel)
app.logger.addHandler(soap_hendler)

logging.getLogger('spyne.protocol.xml').setLevel(llevel)

if __name__ == '__main__':
    app.run(host=app.config.get('APP_HOST'),
            port=app.config.get('APP_PORT'),
            )
