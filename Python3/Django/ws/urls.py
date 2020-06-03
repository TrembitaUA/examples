from django.conf.urls import url
from django.contrib import admin
from django.urls import path
from spyne.server.django import DjangoView

from soapservice.views import application

urlpatterns = [
    path('admin/', admin.site.urls),
    url(r'^trembita/', DjangoView.as_view(application=application)),
]
