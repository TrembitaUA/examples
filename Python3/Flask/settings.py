import os

DEBUG = True

BIND = os.environ.get('BIND') or '0.0.0.0:8060'
APP_PORT = int(BIND.split(':')[1])
APP_HOST = BIND.split(':')[0]

NAMESPACE = 'http://trembita.gov.ua'
