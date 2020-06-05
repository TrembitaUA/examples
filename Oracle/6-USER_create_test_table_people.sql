-- Условия для тестирования триггера
-- Создаем таблицу
CREATE TABLE "C##UXPCLIENT"."PEOPLE" 
   (	"INN" VARCHAR2(10) NOT NULL ENABLE, 
	"FIRSTNAME" VARCHAR2(64), 
	"SURNAME" VARCHAR2(64), 
	"PATRONYMIC" VARCHAR2(64), 
	"BIRTHDATE" DATE, 
	"PASSPORT_SER" VARCHAR2(5), 
	"PASSPORT_NUM" VARCHAR2(10), 
	 CONSTRAINT "PEOPLE_PK" PRIMARY KEY ("INN")
    );

-- Создаем триггер для таблицы people
CREATE OR REPLACE
TRIGGER INN_IU_TRIGGER
BEFORE INSERT OR UPDATE 
ON people
FOR EACH ROW

DECLARE
    getPersonInfoPy people%rowtype;
    noserch EXCEPTION;
BEGIN
    WITH xml AS (
    SELECT uxp_client.UXP_CALL('getPersonInfoPy', CURSOR (SELECT 'personId' item, :NEW.inn value FROM dual)) responce FROM dual
    )
    SELECT x.* INTO getPersonInfoPy
    FROM xml
    CROSS JOIN xmltable('/*:Envelope/*:Body/*:getPersonInfoPyResponse/*:getPersonInfoPyResult'
           PASSING responce
           COLUMNS INN          VARCHAR2(10) path '*:inn' , 
                   FIRSTNAME    VARCHAR2(64) path '*:firstname', 
                   SURNAME      VARCHAR2(64) path '*:surname', 
                   PATRONYMIC   VARCHAR2(64) path '*:patronymic', 
                   BIRTHDATE    DATE         path '*:birthdate', 
                   PASSPORT_SER VARCHAR2(5)  path '*:passport_ser', 
                   PASSPORT_NUM VARCHAR2(10) path '*:passport_num'       
        ) x;
    
    IF getPersonInfoPy.inn IS NULL THEN 
        RAISE noserch;
    END IF;

    :NEW.FIRSTNAME      := getPersonInfoPy.FIRSTNAME;
    :NEW.SURNAME        := getPersonInfoPy.SURNAME;
    :NEW.PATRONYMIC     := getPersonInfoPy.PATRONYMIC;
    :NEW.BIRTHDATE      := getPersonInfoPy.BIRTHDATE;
    :NEW.PASSPORT_SER   := getPersonInfoPy.PASSPORT_SER;
    :NEW.PASSPORT_NUM   := getPersonInfoPy.PASSPORT_NUM;

EXCEPTION
    WHEN noserch THEN
        raise_application_error(-20001, 'No search UXP service');
END;
/

COMMIT;
quit;
