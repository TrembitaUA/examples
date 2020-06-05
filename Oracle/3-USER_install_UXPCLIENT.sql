 
-----------------------------------------------------------------------------------------------
-- Создаем таблицу для упрощения конфигурации доступа к сервисам
  CREATE TABLE "C##UXPCLIENT"."UXP_CONFIG" 
   ("ID" VARCHAR2(50) NOT NULL ENABLE, 
    "VALUE" VARCHAR2(255) NOT NULL ENABLE, 
    "XML_REQUEST" "XMLTYPE", 
     CONSTRAINT "UXP_CONFIG_PK" PRIMARY KEY ("ID"));

----------------------------------------------------------------------------------------------------------
-- Создание пакета 
CREATE OR REPLACE package "C##UXPCLIENT".uxp_client as 

-- функция возвращающая URL для получения WSDL
    FUNCTION get_url_wsdl(service IN varchar2) RETURN VARCHAR2;

-- Функция запроса к сервису Трембиты
-- service - значение должно совпадать с полем id таблицы uxp_config
-- soap_request - курсор в первом атрибуте имя атрибута запроса во втором значение
--      CURSOR (SELECT 'personId' item, '12345672' value FROM dual)
-- возвращает ответ в формате XML
    FUNCTION uxp_call(service IN varchar2, soap_request IN SYS_REFCURSOR) RETURN xmltype;

end uxp_client;
/

-- Создание тела пакета
CREATE OR REPLACE package body "C##UXPCLIENT".uxp_client as

    FUNCTION split_uxp_url(uxp in varchar2) RETURN SYS_REFCURSOR
    IS       
        v_sql     varchar(4000);
        my_cursor SYS_REFCURSOR;
    BEGIN
        v_sql := ' 
        with test as    
        (select uxp_config.value MY_STRING from uxp_config where uxp_config.id='''||uxp||''')
        select case when rownum=1 then ''xRoadInstance''
                    when rownum=2 then ''memberClass''
                    when rownum=3 then ''memberCode''
                    when rownum=4 then ''subsystemCode''
                    when rownum=5 then ''serviceCode''
                    when rownum=6 then ''version''
               end key,
               regexp_substr(MY_STRING, ''[^/]+'', 1, rownum) value
          from test
        connect by level <= length (regexp_replace(MY_STRING, ''[^/]+''))  + 1';        
        open my_cursor for v_sql;
        RETURN my_cursor;
    END;

  FUNCTION get_url_wsdl(service IN varchar2) RETURN VARCHAR2
    IS
        wsdl_url  VARCHAR2(250);
        uxp_url   varchar2(250);
        my_cursor SYS_REFCURSOR;
        key       VARCHAR2(15);
        value     VARCHAR2(25);
    BEGIN
        select value into wsdl_url from uxp_config where id='SS';
        wsdl_url := wsdl_url||'/wsdl?';
        my_cursor := split_uxp_url(service);
        loop            
            FETCH my_cursor INTO key, value;
            EXIT WHEN my_cursor%NOTFOUND;
            wsdl_url := wsdl_url||key||'='||value||'&';
        end loop;
        
        RETURN SUBSTR(wsdl_url, 1, length(wsdl_url)-1) ;
    END get_url_wsdl;
    
    FUNCTION creat_request(
        service IN varchar2,
        request IN SYS_REFCURSOR
        ) RETURN xmltype 
    IS 
        servic  SYS_REFCURSOR;
        hclient SYS_REFCURSOR;
        xml     xmltype;
        key     VARCHAR2(15);
        value   VARCHAR2(25);
    BEGIN        
        SELECT XML_REQUEST INTO xml FROM UXP_CONFIG WHERE id=service;

        hclient := split_uxp_url('Client');
        LOOP
            FETCH hclient INTO key, value;
            EXIT WHEN hclient%NOTFOUND;
          
            SELECT updatexml(xml, '/*:Envelope/*:Header/*:client/*:'||TRIM(KEY)||'/text()', TRIM(value)) 
            INTO xml
            FROM dual;
            IF KEY = 'subsystemCode' THEN 
                SELECT updatexml(xml, '/*:Envelope/*:Header/*:userId/text()', TRIM(value)) 
                INTO xml
                FROM dual;
            END IF;             
        END LOOP;

        servic := split_uxp_url(service);
        LOOP
            FETCH servic INTO key, value;
            EXIT WHEN servic%NOTFOUND;
            IF trim(key) = 'version' THEN
                NULL;
            ELSE
                SELECT updatexml(xml, '/*:Envelope/*:Header/*:service/*:'||TRIM(KEY)||'/text()', TRIM(value)) 
                INTO xml
                FROM dual;
            END IF;
        END LOOP;     
       
        SELECT updatexml(xml, '/*:Envelope/*:Header/*:protocolVersion/text()', '4.0') 
        INTO xml
        FROM dual;
    
        SELECT updatexml(xml, '/*:Envelope/*:Header/*:id/text()', SYS_GUID()) 
        INTO xml 
        FROM dual;
    
        LOOP
            FETCH request INTO key, value;
            EXIT WHEN request%NOTFOUND;
        
            SELECT updatexml(xml, '/*:Envelope/*:Body/*:'||service||'/*:'||TRIM(KEY)||'/text()', TRIM(value)) 
            INTO xml
            FROM dual;
        END LOOP;
    
        RETURN xml;    
   END creat_request;
  
  PROCEDURE send(po_data_request  IN xmltype,
                 po_data_response IN OUT xmltype) IS
    url                 varchar2(255); 
    V_SOAP_REQUEST      XMLTYPE := po_data_request;
    V_SOAP_REQUEST_TEXT CLOB := V_SOAP_REQUEST.getClobVal();
    V_REQUEST           UTL_HTTP.REQ;
    V_RESPONSE          UTL_HTTP.RESP;
    V_BUFFER            VARCHAR2(4000);
  BEGIN
    select value into url from uxp_config where id='SS';

    V_REQUEST := UTL_HTTP.BEGIN_REQUEST(URL => url, METHOD => 'POST');
  
    UTL_HTTP.SET_HEADER(V_REQUEST, 'Accept-Encoding', 'gzip,deflate');
    UTL_HTTP.SET_HEADER(V_REQUEST, 'Content-Type',    'text/xml;charset=UTF-8');
    UTL_HTTP.SET_HEADER(V_REQUEST, 'Content-Length',  DBMS_LOB.GETLENGTH(V_SOAP_REQUEST_TEXT));
    UTL_HTTP.SET_HEADER(V_REQUEST, 'User-Agent',      'Mozilla/4.0');
  
    UTL_HTTP.WRITE_TEXT(V_REQUEST, V_SOAP_REQUEST_TEXT);
  
    V_RESPONSE := UTL_HTTP.GET_RESPONSE(V_REQUEST);
    
    utl_http.read_text(V_RESPONSE, V_BUFFER);
    po_data_response := xmltype(V_BUFFER);
  
    UTL_HTTP.END_RESPONSE(V_RESPONSE);
  EXCEPTION
    WHEN UTL_HTTP.END_OF_BODY THEN
      UTL_HTTP.END_RESPONSE(V_RESPONSE);
    WHEN OTHERS THEN
      UTL_HTTP.END_RESPONSE(V_RESPONSE);
  END;

    FUNCTION uxp_call(
        service IN varchar2,
        soap_request IN SYS_REFCURSOR
        ) RETURN xmltype 
    IS
        soap_responce xmltype;
    BEGIN
        send(CREAT_REQUEST(service, soap_request), soap_responce);
        RETURN soap_responce;
    END;

end uxp_client;
/

quit;
