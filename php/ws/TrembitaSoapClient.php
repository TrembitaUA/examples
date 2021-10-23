<?php
// Заборонити кешування wsdl-файла
ini_set("soap.wsdl_cache_enabled", 0);
// Параметри UXP
const UXP_SERVER_ADDRESS = "[UXP_SERVER_ADDR]";
const XROAD_INSTANCE = "[XROAD_INSTANCE]";
const MEMBER_CLASS = "[MEMBER_CLASS]";
const MEMBER_CODE = "[MEMBER_CODE]";
const SUBSYSTEM_CODE = "[SUBSYSTEM_CODE]";
const SERVICE_CODE = "getPersonInfo";
const USERID_CODE = "[USERID_CODE]";
// Для прикладу використовуются такіж значення, 
// але на практиці значення повинні разрізнятись
const MEMBER_CODE_CLIENT = "[MEMBER_CODE]";
const SUBSYSTEM_CODE_CLIENT = "[SUBSYSTEM_CODE]";

// Посилання для отримання WSDL Web-service від UXP сервера
/* $wsdlurl = "http://".UXP_SERVER_ADDRESS."/wsdl?xRoadInstance=".XROAD_INSTANCE
."&memberClass=".MEMBER_CLASS."&memberCode=".MEMBER_CODE
."&subsystemCode=".SUBSYSTEM_CODE."&serviceCode=".SERVICE_CODE;
*/
// Посилання для отримання WSDL Web-service від локального Web server
$wsdlurl = "http://[YOUR_IP_ADDR:PORT]/ws/TrembitaSoapService.php?wsdl";
// Структура параметрів даних запиту
class getPersonInfo {
    public $inn;
}
// Функція для генерації ID запиту до UXP сервера
function generate_uuid() {
    return sprintf( '%04x%04x-%04x-%04x-%04x-%04x%04x%04x',
    mt_rand( 0, 0xffff ), mt_rand( 0, 0xffff ),
    mt_rand( 0, 0xffff ),
    mt_rand( 0, 0x0fff ) | 0x4000,
    mt_rand( 0, 0x3fff ) | 0x8000,
    mt_rand( 0, 0xffff ), mt_rand( 0, 0xffff ), mt_rand( 0, 0xffff )
    );
}
// Клас SoapClient
class TrembitaSoapClient extends SoapClient {
    public function __doRequest($request, $location, $action, $version, $one_way = 0 ) {
        return parent::__doRequest($request, $location, $action, $version, $one_way);
    }
}
// Функція для тестування запиту до Web service
function callPersonInfoService($inn){
    // Посилання на xsd для запитів до UXP сервера
    $nsxroad = "http://x-road.eu/xsd/xroad.xsd";
    $nsident = "http://x-road.eu/xsd/identifiers";
    global $wsdlurl;
    // echo $wsdlurl;
    // Створюємо SoapClient
    $soapclient = new TrembitaSoapClient( 
        $wsdlurl,
        array( 
            'trace' =>0,
            'encoding' =>'UTF-8',
            'soap_version' =>SOAP_1_1,
            'stream_context' =>stream_context_create([
                'ssl' => [
                'allow_self_signed' =>true,
                'verify_peer' =>false,
                'verify_peer_name' =>false,
                ]
            ]),
    )
    );
    // Формуємо заголовок запиту
    $xml = '<ns2:service ns3:objectType="SERVICE" xmlns:ns3="'.$nsident.'">'
        . "<ns3:xRoadInstance>". XROAD_INSTANCE ."</ns3:xRoadInstance>"
        . "<ns3:memberClass>". MEMBER_CLASS ."</ns3:memberClass>"
        . "<ns3:memberCode>". MEMBER_CODE ."</ns3:memberCode>"
        . "<ns3:subsystemCode>". SUBSYSTEM_CODE ."</ns3:subsystemCode>"
        . "<ns3:serviceCode>". SERVICE_CODE ."</ns3:serviceCode>"
        . "</ns2:service>";
    $servicesoapvar = new SoapVar($xml, XSD_ANYXML);
    $xml = '<ns2:client ns3:objectType="SUBSYSTEM" xmlns:ns3="'.$nsident.'">'
        . "<ns3:xRoadInstance>". XROAD_INSTANCE ."</ns3:xRoadInstance>"
        . "<ns3:memberClass>". MEMBER_CLASS ."</ns3:memberClass>"
        . "<ns3:memberCode>". MEMBER_CODE_CLIENT ."</ns3:memberCode>"
        . "<ns3:subsystemCode>". SUBSYSTEM_CODE_CLIENT ."</ns3:subsystemCode>"
        . "</ns2:client>";
    $clientsoapvar = new SoapVar($xml, XSD_ANYXML);
    $clientHeader = new SoapHeader($nsxroad, 'client', $clientsoapvar);
    $serviceHeader = new SoapHeader($nsxroad, 'service', $servicesoapvar);
    $idHeader = new SoapHeader($nsxroad, 'id', generate_uuid());
    $protocolVersionHeader = new SoapHeader($nsxroad, 'protocolVersion', '4.0');
    $userIdHeader = new SoapHeader($nsxroad, 'userId', USERID_CODE);
    // Встановлюємо заголовок
    $soapclient->__setSoapHeaders(array($clientHeader, $serviceHeader, $idHeader,
    $protocolVersionHeader, $userIdHeader));
    // Заповнюємо вхідні дані
    $gp = new getPersonInfo();
    $gp->inn = $inn;
    // Робимо запит до Web service
    try {
        $res = $soapclient->getPersonInfo($gp);
    } catch (SoapFault $fault) {
        // Виводимо помилку від сервера на сторінку
        echo "[".$fault->faultcode.":".$fault->faultstring."]<br>";
        return null;
    }
    // повертаємо результат
    return $res;
}
?>

<html>
<head>
<title>getPersonInfo web service test page</title>
<link rel="stylesheet" href="/pure-min.css">
</head>
<body>
<div style="margin: 20px">
<h1>Пошук клієнта</h1>
<form action="TrembitaSoapClient.php" method="post" class="pure-form pure-form-stacked">
<p>ІПН клієнта: <input type="text" name="inn"
value="<?php if (!empty($_POST) &&isset($_POST['inn'])) echo $_POST['inn'] ?>" /></p>
<p><input type="submit" value="Пошук"/></p>
</form>
<?php if(empty($_POST) || empty($_POST['inn'])): ?>
Для отримання інформації по клієнту заповните поле ІПН
<?php else:
$inn = $_POST['inn'];
if($inn != null) {
    $res = callPersonInfoService($inn);
    if($res != null ) {
        echo "<h1>Інформація по клієнту:</h1>";
        echo "<table class='pure-table'>";
        echo "<tr><td>ІПН</td><td>" . $res->inn . "</td></tr>";
        echo "<tr><td>Прізвище</td><td>" . $res->surname . "</td></tr>";
        echo "<tr><td>Им'я</td><td>" . $res->firstname . "</td></tr>";
        echo "<tr><td>Дата народження</td><td>" . $res->birthdate . "</td></tr>";
        echo "<tr><td>Серія/номер паспорта</td><td>" . $res->passport_ser. $res->passport_num . "</td></tr>";
        echo "</table>";
    } else {
        echo "\tІнформації по клієнту не знайдено";
    }
}
?>
<?php endif; ?>
</div>
</body>
</html>
