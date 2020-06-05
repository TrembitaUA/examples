-- Заполняем таблицу конфигурации тестовыми данными
-- адрес нашего Секьюрити сервера "Трембиты"
INSERT INTO uxp_config (id, value)
VALUES('SS', 'http://192.168.1.52');

-- Адрес нашей подсистемы в формате "Трембиты" 
INSERT INTO uxp_config (id, value)
VALUES('Client', 'SEVDEIR-TEST/GOV/11110012/MONITORING');

-- Адреса вебсервисов "Трембиты" может быть много
-- Адрес сервиса "getPersonInfoPy" и XML для запраса
INSERT INTO uxp_config (id, value, XML_REQUEST) VALUES(
'getPersonInfoPy', 
'SEVDEIR-TEST/GOV/11110012/MONITORING/getPersonInfoPy', 
xmltype('<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
                           xmlns:xro="http://x-road.eu/xsd/xroad.xsd" 
                           xmlns:iden="http://x-road.eu/xsd/identifiers" 
                           xmlns:trem="http://trembita.gov.ua">
  <soapenv:Header>
    <xro:client iden:objectType="MEMBER">
      <iden:xRoadInstance>?</iden:xRoadInstance>
      <iden:memberClass>?</iden:memberClass>
      <iden:memberCode>?</iden:memberCode>
      <iden:subsystemCode>?</iden:subsystemCode>
    </xro:client>
    <xro:service iden:objectType="SERVICE">
      <iden:xRoadInstance>?</iden:xRoadInstance>
      <iden:memberClass>?</iden:memberClass>
      <iden:memberCode>?</iden:memberCode>
      <iden:subsystemCode>?</iden:subsystemCode>
      <iden:serviceCode>?</iden:serviceCode>
    </xro:service>
    <xro:userId>?</xro:userId>
    <xro:id>?</xro:id>
    <xro:protocolVersion>?</xro:protocolVersion>
  </soapenv:Header>
  <soapenv:Body>
    <trem:getPersonInfoPy>
      <trem:personId>?</trem:personId>
    </trem:getPersonInfoPy>
  </soapenv:Body>
</soapenv:Envelope>
'));

commit;
quit