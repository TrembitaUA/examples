CREATE ROLE uxptraining WITH CREATEDB LOGIN PASSWORD 'uxptraining';

CREATE DATABASE dbtest OWNER uxptraining;

\c dbtest uxptraining 

CREATE TABLE people (
  id SERIAL PRIMARY KEY,
  inn CHAR(10),
  firstname CHAR(64),
  surname CHAR(64),
  patronymic CHAR(64),
  birthdate DATE,
  passport_ser CHAR(5),
  passport_num CHAR(10));
  
INSERT INTO people (inn, surname, firstname, patronymic, birthdate, passport_ser, passport_num)
  VALUES ('12345671', 'Конанов', 'Эдуард', 'Петович', '10.12.1993', 'ВК', '332211');
INSERT INTO people (inn, surname, firstname, patronymic, birthdate, passport_ser, passport_num)
  VALUES ('12345672', 'Васюк', 'Виктор', 'Валентинович', '01.01.1963', 'ВС', '223311');
INSERT INTO people (inn, surname, firstname, patronymic, birthdate, passport_ser, passport_num)
  VALUES ('12345673', 'Николаева', 'Ирина', 'Степановна', '05.02.1985', 'ВН', '112233');
INSERT INTO people (inn, surname, firstname, patronymic, birthdate, passport_ser, passport_num)
  VALUES ('12345674', 'Петров', 'Петр', 'Петрович', '08.03.1987', 'ВС', '221133');
INSERT INTO people (inn, surname, firstname, patronymic, birthdate, passport_ser, passport_num)
  VALUES ('12345675', 'Звонарева', 'Ирина', 'Викторовна', '01.11.1967', 'ВБ', '441133');
INSERT INTO people (inn, surname, firstname, patronymic, birthdate, passport_ser, passport_num)
  VALUES ('12345676', 'Иванов', 'Михаил', 'Иванович', '09.09.1978', 'ВБ', '442211');
INSERT INTO people (inn, surname, firstname, patronymic, birthdate, passport_ser, passport_num)
  VALUES ('12345677', 'Резноренко', 'Михайло', 'Тимофійович', '12.08.1952', 'ВО', '441155');
INSERT INTO people (inn, surname, firstname, patronymic, birthdate, passport_ser, passport_num)
  VALUES ('12345678', 'Харламов', 'Валерий', 'Борисович', '01.10.1998', 'ВА', '441188');
INSERT INTO people (inn, surname, firstname, patronymic, birthdate, passport_ser, passport_num)
  VALUES ('12345679', 'Михайлов', 'Николай', 'Алексеевич', '08.08.1988', 'ВН', '441199');
INSERT INTO people (inn, surname, firstname, patronymic, birthdate, passport_ser, passport_num)
  VALUES ('12345670', 'Токарева', 'Анна', 'Николаевна', '03.03.1989', 'АН', '441100');

CREATE TABLE address (
  id SERIAL PRIMARY KEY,
  inn CHAR(10),
  address CHAR(128));

INSERT INTO address (inn, address)
  VALUES ('12345671', 'Киев, б. Шевченко 1а');
INSERT INTO address (inn, address)
  VALUES ('12345672', 'Винница, Соборная 2');
INSERT INTO address (inn, address)
  VALUES ('12345673', 'Харьков, Сумская 8');
INSERT INTO address (inn, address)
  VALUES ('12345674', 'Днепропетровск, Дорожная 8б');
INSERT INTO address (inn, address)
  VALUES ('12345675', 'Харьков, ул. Строителей 254');
INSERT INTO address (inn, address)
  VALUES ('12345676', 'Донецк, Независимости 54в');
INSERT INTO address (inn, address)
  VALUES ('12345677', 'Бахмут, вул. Леваневського 1, кв 1');
INSERT INTO address (inn, address)
  VALUES ('12345678', 'Одесса, Набережная 11');
INSERT INTO address (inn, address)
  VALUES ('12345679', 'Львов, Базарная 3а');
INSERT INTO address (inn, address)
  VALUES ('12345670', 'Конотоп, Киевска 11');

CREATE TABLE auto (
  id SERIAL PRIMARY KEY,
  inn CHAR(10),
  model CHAR(32),
  reg_num CHAR(12));

INSERT INTO auto (inn, model, reg_num)
  VALUES ('12345671', 'Mersedes', 'AA 1234 HI');
INSERT INTO auto (inn, model, reg_num)
  VALUES ('12345672', 'BMW', 'AA 4321 PA');
INSERT INTO auto (inn, model, reg_num)
  VALUES ('12345673', 'Audi', 'AR 5678 BA');
INSERT INTO auto (inn, model, reg_num)
  VALUES ('12345674', 'Nissan', 'AB 5739 AK');
INSERT INTO auto (inn, model, reg_num)
  VALUES ('12345675', 'VW', 'AM 8365 KK');
INSERT INTO auto (inn, model, reg_num)
  VALUES ('12345676', 'Toyota', 'AI 6209 MA');
INSERT INTO auto (inn, model, reg_num)
  VALUES ('12345677', 'Cadilac', 'CA 6302 AC');
INSERT INTO auto (inn, model, reg_num)
  VALUES ('12345678', 'ВАЗ', 'АН 3792 КC');
INSERT INTO auto (inn, model, reg_num)
  VALUES ('12345679', 'Nissan', 'ВВ 7382 ВВ');
INSERT INTO auto (inn, model, reg_num)
  VALUES ('12345670', 'Opel', 'ВС 1374 СА');

CREATE TABLE photo (
  id SERIAL PRIMARY KEY,
  inn CHAR(10),
  photo CHAR(128));
  
INSERT INTO photo (inn, photo)
  VALUES ('12345671', '12345671.jpg');
INSERT INTO photo (inn, photo)
  VALUES ('12345672', '12345672.jpg');
INSERT INTO photo (inn, photo)
  VALUES ('12345673', '12345673.jpg');
INSERT INTO photo (inn, photo)
  VALUES ('12345674', '12345674.jpg');
INSERT INTO photo (inn, photo)
  VALUES ('12345675', '12345675.jpg');
INSERT INTO photo (inn, photo)
  VALUES ('12345676', '12345676.jpg');
INSERT INTO photo (inn, photo)
  VALUES ('12345677', '12345677.jpg');
INSERT INTO photo (inn, photo)
  VALUES ('12345678', '12345678.jpg');
INSERT INTO photo (inn, photo)
  VALUES ('12345679', '12345679.jpg');
INSERT INTO photo (inn, photo)
  VALUES ('12345670', '12345670.jpg');

CREATE OR REPLACE FUNCTION insert_info(_inn TEXT, _surname TEXT, _firstname TEXT, _patronymic TEXT, _birthdate DATE, _passport_ser TEXT, _passport_num TEXT, _address TEXT) RETURNS TEXT AS $$
DECLARE retval TEXT;
BEGIN
INSERT INTO people (inn, surname, firstname, patronymic, birthdate, passport_ser, passport_num)
  VALUES ($1, $2, $3, $4, $5, $6, $7);
INSERT INTO address (inn, address)
  VALUES ($1, $8);
SELECT concat('INSERTED: ', TRIM(inn), ' ', TRIM(surname), ' ', TRIM(firstname)) INTO retval FROM people WHERE inn = $1;
RETURN retval;
END
$$ LANGUAGE plpgsql;
