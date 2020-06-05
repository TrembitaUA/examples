set echo on
set pagesize 0 embedded on
set linesize 5000
ALTER SESSION SET NLS_NUMERIC_CHARACTERS=', ';
ALTER SESSION SET NLS_DATE_FORMAT = 'DD.MM.YYYY';
COLUMN tab NEW_VALUE tab NOPRINT
SELECT CHR(9) tab FROM DUAL;
SET COLSEP ';'

-- Тестирование триггера

-- если если UXPсервис вернет нормальные значения
INSERT INTO people (inn) VALUES ('12345671');
INSERT INTO people (inn) VALUES ('12345672');
COMMIT;
select * from people;
update people set inn='12345679' where inn='12345671';
COMMIT;
select * from people;

-- если UXPсервис вернет ошибку или не найдет
INSERT INTO people (inn) VALUES ('10345672');

quit
