<?php
include 'GetPersonInfoMethods.class.php';
// Відключаємо кешування WSDL для тестування
ini_set("soap.wsdl_cache_enabled", "0");
// Ідентифікатор сервісу для логування
const SYSTEM_ID="[YOUR_SYSTEM_ID]";
const LOG_ID="[".SYSTEM_ID."]";
const SERVER="192.168.122.181:8080";
// Посилання на WSDL-файл сервісу
$wsdlurl = "http://".SERVER."/ws/TrembitaService.wsdl";
// Базове URI сервісу
$wsuri = "http://".SERVER."/";
// URL Web-сервісу
$wslocation = "http://".SERVER."./ws/TrembitaSoapService.php";
// Клас-нащадок SoapServer
class TrembitaSoapServer extends SoapServer
{
    // Переписуємо функцію handle
    public function handle($request = null){
        // Отримуємо вхідний SOAP-запит
        if (!$request) {
            $request = file_get_contents('php://input');
            // Записати вхідний запит в лог
            error_log(LOG_ID." RAW REQUEST: ". $request);
        }
        // Вмикаємо буферизацію виводу. Зупиняємо миттєвий вивід - спочатку потрібно повністю скласти вихідне повідомлення
        try {
            ob_start();
            // Викликаємо стандартну функцію обробки вхідних запитів від SoapServer
            parent::handle($request);
            // Зберігаємо вихідне повідомлення
            $response = ob_get_contents();
            error_log(LOG_ID." RAW RESPONSE: ".$response);
            // Вимикаємо буферизацію виводу
            ob_end_clean();
            // Відправляємо вихідне повідомлення
            echo $response;
        } catch (Exception $e) {
            throw new SoapFault("-1",$e->getMessage());
        }
    }
}
// Створюємо новий об'єкт типу TrembitaSoapServer
$server = new TrembitaSoapServer(
    $wsdlurl,
    array(
        'uri' =>$wsuri,
        'location' =>$wslocation
    )
);
// Реєструємо клас, який містить функції, що відповідають WSDL-операціям
$server->setClass("GetPersonInfoMethods");
//Запускаємо сервер
$server->handle();
