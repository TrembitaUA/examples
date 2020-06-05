set echo on
set pagesize 0 embedded on
set linesize 5000
ALTER SESSION SET NLS_NUMERIC_CHARACTERS=', ';
ALTER SESSION SET NLS_DATE_FORMAT = 'DD.MM.YYYY';
COLUMN tab NEW_VALUE tab NOPRINT
SELECT CHR(9) tab FROM DUAL;
SET COLSEP ';'

WITH xml AS (
SELECT uxp_client.UXP_CALL('getPersonInfoPy', CURSOR (SELECT 'personId' item, '12345672' value FROM dual)) responce FROM dual
)
SELECT x.*
FROM xml
CROSS JOIN xmltable('/*:Envelope/*:Body/*:getPersonInfoPyResponse/*:getPersonInfoPyResult'
       PASSING responce
       COLUMNS INN       VARCHAR2(10) path '*:inn' , 
               FIRSTNAME VARCHAR2(64) path '*:firstname', 
               SURNAME   VARCHAR2(64) path '*:surname', 
               PATRONYMIC VARCHAR2(64) path '*:patronymic', 
               BIRTHDATE DATE path '*:birthdate', 
               PASSPORT_SER VARCHAR2(5) path '*:passport_ser', 
               PASSPORT_NUM VARCHAR2(10) path '*:passport_num'       
    ) x;

quit;
