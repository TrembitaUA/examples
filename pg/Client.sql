CREATE ROLE uxpclient WITH CREATEDB LOGIN PASSWORD 'uxpclient';

CREATE DATABASE dbtest OWNER uxpclient;

\c uxpclient uxpclient

-----------------------------------------------------------------------------------------------
-- Создаем таблицу для упрощения конфигурации доступа к сервисам
CREATE TABLE public.uxp_config (
	id varchar(50) NOT NULL,
	value varchar(255) NOT NULL,
	CONSTRAINT uxp_config_pk PRIMARY KEY (id)
);

-- адрес нашего Секьюрити сервера "Трембиты"
INSERT INTO public.uxp_config (id, value)
VALUES('SS', 'http://192.168.1.52');

-- Адрес нашей подсистемы в формате "Трембиты" 
INSERT INTO public.uxp_config (id, value)
VALUES('Client', 'SEVDEIR-TEST/GOV/11110012/MONITORING');

-- Адреса вебсервисов "Трембиты" может быть много
-- Адрес сервиса "GetMinWage"
INSERT INTO public.uxp_config (id, value)
VALUES('GetMinWage', 'SEVDEIR-TEST/GOV/11110012/MONITORING/GetMinWage');

-- Адрес сервиса "getPersonInfoPy"
INSERT INTO public.uxp_config (id, value)
VALUES('getPersonInfoPy', 'SEVDEIR-TEST/GOV/11110012/MONITORING/getPersonInfoPy');

-----------------------------------------------------------------------------------------------
-- Триггерная функция доступа к сервисам "Трембиты" на диалекте Pl/Python
-- Необходимо: 
--  установить Python 3.6 и старше
--  установить модуль pip install git+https://github.com/AndreyShapovalovVN/pyxroad.git
--  установить и зарегистрировать диалект Pl/Python в PostresQL (plpython3u)
-- !!! Внимание в теле функции синтаксис Python !!!

CREATE OR REPLACE FUNCTION public.before_people()
	RETURNS trigger
	LANGUAGE plpython3u
AS $function$

from XRoad.Client import XClient

config = "select value from uxp_config where id='%s'"

x = XClient(
    plpy.execute(config %'SS')[0]['value'],
    client=plpy.execute(config %'Client')[0]['value'],
    service=plpy.execute(config %'getPersonInfoPy')[0]['value'],
)

ok = 'ERROR'
response = x.request(personId=TD['new']['inn'])
body = response.get('body')

if body:
    getPersonInfoPy = dict(body.get('getPersonInfoPyResult'))

    TD['new']['firstname'] = getPersonInfoPy.get('firstname')
    TD['new']['surname'] = getPersonInfoPy.get('surname')
    TD['new']['patronymic'] = getPersonInfoPy.get('patronymic')
    TD['new']['birthdate'] = getPersonInfoPy.get('birthdate')
    TD['new']['passport_ser'] = getPersonInfoPy.get('passport_ser')
    TD['new']['passport_num'] = getPersonInfoPy.get('passport_num')
    ok = 'MODIFY'

return ok
$function$;
;

-----------------------------------------------------------------------------------------------
-- Создаем таблицу рабочую таблицу и регистрируем триггер

CREATE TABLE public.people (
	inn bpchar(10) NOT NULL,
	firstname bpchar(64) NULL,
	surname bpchar(64) NULL,
	patronymic bpchar(64) NULL,
	birthdate date NULL,
	passport_ser bpchar(5) NULL,
	passport_num bpchar(10) NULL,
	CONSTRAINT people_pk PRIMARY KEY (inn)
);

create trigger before_people BEFORE insert OR update
    ON public.people for each row execute function before_people();

-----------------------------------------------------------------------------------------------
-- Проверяем работоспособность.
INSERT INTO people (inn) VALUES ('12345671');
INSERT INTO people (inn) VALUES ('12345672');
INSERT INTO people (inn) VALUES ('12345673');
INSERT INTO people (inn) VALUES ('12345674');
INSERT INTO people (inn) VALUES ('12345675');
COMMIT;
select * from people;

update people set inn='12345679' where inn='12345671';
COMMIT;
select * from people;

INSERT INTO people (inn) VALUES ('012345675');

-- Вуаля
----------------------------------------------------------------------------------------------
