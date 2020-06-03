<?php
$db_conn_string = "host=127.0.0.1 port=5432 dbname=dbtest user=uxptraining password=uxptraining";
class GetPersonInfoMethods {    
    // Члени класу для збереження вхідних SOAP-заголовків
    private $clientHeader;
    private $serviceHeader;
    private $userIdHeader;
    private $idHeader;
    private $protocolVersionHeader;
    // Метод GetPersonInfo. Найменування функції повинно відповідати наступним WSDL елементам:
    // 1) <wsdl:portType><wsdl:operation name="getPersonInfo">
    // 2) <wsdl:binding><wsdl:operation name="getPersonInfo">
    // 3) <wsdl:binding><wsdl:operation><soap:operation soapAction="getPersonInfo">
    public function getPersonInfo($request) {
        global $db_conn_string;
        $inn = $request->inn;
        if( preg_match ('/^[0-9]{8,10}$/', $inn) == 0)
        throw new SoapFault("-4", "Wrong parameters.");
        // Перевіряємо навність UXP-заголовків та виводимо параметри виклику до лог-файлу
        if(isset ($this->serviceHeader)) {
            error_log(LOG_ID." SOAP REQUEST [xRoadInstance=".$this->serviceHeader->xRoadInstance
            ."; memberClass=".$this->serviceHeader->memberClass
            ."; memberCode=".$this->serviceHeader->memberCode
            ."; subsystemCode=".$this->serviceHeader->subsystemCode
            ."; serviceCode=".$this->serviceHeader->serviceCode
            ."] "."inn=".$inn);
        } else {
            error_log(LOG_ID." SOAP REQUEST [NO HEADER] "."inn=".$inn);
        }

        // Створюємо з'єднання до СУБД
        $dbconn = pg_connect($db_conn_string);
        if(!$dbconn)
        throw new SoapFault("-1","Database connect error.");
        // Формуємо SQL запит до БД
        $query = "select * from people where inn = '" . $inn . "'";
        // Виконуємо SQL запит
        $result = pg_query($dbconn, $query);
        // Якщо запит невдалий - повертаємо помилку
        if(!$result)
        throw new SoapFault("-2","Query execution error.");
        // Отримуємо перший результат
        $person = pg_fetch_object($result);
        // Якщо результат пустий - повертаємо помилку
        if (!$person) {
            throw new SoapFault("-3", "Person was not found in database.");
        }
        // Формуємо відповідь з даними по клієнту
        else {
            $resp = new GetPersonInfoResponse();
            $resp->inn = $person->inn;
            $resp->passport_num = $person->passport_num;
            $resp->passport_ser = $person->passport_ser;
            $resp->birthdate = $person->birthdate;
            $resp->surname = $person->surname;
            $resp->firstname = $person->firstname;
            // Повертаємо результат виконання SOAP-сервісу
            return $resp;
        }
        return false;
    }
    // Функції для обробки вхідних заголовків SOAP-запиту від UXP
    // Коли PHP SOAP extension зустрічає заголовок, спочатку визиваються функції класу-обробника
    // з тим самим найменуванням,
    // якщо вони існують в класу-обробнику запиту
    // Зберігаємо заголовки для мети логування вхідних запитів
    public function client($clientHeader) {
        $this->clientHeader = $clientHeader;
    }
    public function service($serviceHeader) {
        $this->serviceHeader = $serviceHeader;
    }
    public function userId($userIdHeader) {
        $this->userIdHeader = $userIdHeader;
    }
    public function id($idHeader) {
        $this->idHeader = $idHeader;
    }
    public function protocolVersion($protocolVersionHeader) {
        $this->protocolVersionHeader = $protocolVersionHeader;
    }
}
// Клас, що визначає структуру вихідного повідомлення (інформаційної частини).
// Заголовки UXP (копія вхідних) сервер додає автоматично.
class getPersonInfoResponse {
    public $passport_num;
    public $passport_ser;
    public $birthdate;
    public $surname;
    public $firstname;
    public $inn;
}
