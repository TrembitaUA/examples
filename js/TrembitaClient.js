var express = require('express');
var soap = require('soap');
const securityServerAddr = "127.0.0.1:8080";
const xRoadInstance = "UXPInstance";
const memberClass = "GOV";
const memberCode = "UXPMemberCode";
const subsystemCode = "SubSystemCode";
const serviceCode = "getPersonInfoJs";

var trembita =  "http://" + securityServerAddr + "/wsdl?xRoadInstance=" + xRoadInstance + "&memberClass=" + memberClass + "&memberCode=" + memberCode + "&subsystemCode=" + subsystemCode + "&serviceCode=" + serviceCode;

var clientArgs = process.argv.slice(2);
if (clientArgs.length == 0) {
    console.error("Enter INN");
    return;
}

var args = { inn: clientArgs[0] };

soap.createClient(trembita, function(err, client){
    if(err)
        console.error("SOAP error: " + err.body);
    else {
        var soapHeaderXml = 
        "<xroad:client id:objectType=\"SUBSYSTEM\">" +
            "<id:xRoadInstance>"+xRoadInstance+"</id:xRoadInstance>" +
            "<id:memberClass>"+memberClass+"</id:memberClass>" +
            "<id:memberCode>"+memberCode+"</id:memberCode>" +
            "<id:subsystemCode>"+subsystemCode+"</id:subsystemCode>" +
            "</xroad:client>" +
        "<xroad:service id:objectType=\"SERVICE\">" +
            "<id:xRoadInstance>"+xRoadInstance+"</id:xRoadInstance>" +
            "<id:memberClass>"+memberClass+"</id:memberClass>" +
            "<id:memberCode>"+memberCode+"</id:memberCode>" +
            "<id:subsystemCode>"+subsystemCode+"</id:subsystemCode>" +
            "<id:serviceCode>"+serviceCode+"</id:serviceCode>" +
        "</xroad:service>" +
        "<xroad:userId>123</xroad:userId>" +
        "<xroad:id>321</xroad:id>" +
        "<xroad:protocolVersion>4.0</xroad:protocolVersion>";
        client.addSoapHeader(soapHeaderXml);
        client.getPersonInfoJs(args,function(err,response) {
        if(err) {
                console.error("SOAP error: " + err.body);
        } else {console.log(response);}
        })
    }
});
             
