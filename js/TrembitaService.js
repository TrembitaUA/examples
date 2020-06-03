var express = require('express');
var soap = require('soap');
var pgp = require("pg-promise")(/*options*/);
var connection_string = "postgres://uxptraining:uxptraining@127.0.0.1:5432/dbtest";
var db = pgp(connection_string);
var app = express();
var serviceTrembita = {
    TrembitaSoapService : {
        TrembitaSoapPort : {
            getPersonInfoJs : async function(args, cb, headers){
                console.log("args.inn = " + args.inn);
                console.log("UXP Heades information:");
                console.log("client.xRoadInstance = " + headers.client.xRoadInstance);
                console.log("client.memberClass = " + headers.client.memberClass);
                console.log("client.memberCode = " +  headers.client.memberCode);
                console.log("client.subsystemCode = " + headers.client.subsystemCode);
                console.log("service.xRoadInstance = " + headers.service.xRoadInstance);
                console.log("service.memberClass = " + headers.service.memberClass);
                console.log("service.memberCode = " + headers.service.memberCode);
                console.log("service.subsystemCode = " + headers.service.subsystemCode);
                console.log("service.serviceCode = " + headers.service.serviceCode);
                console.log("id = " + headers.id);
                console.log("userId = " + headers.userId);
                var res;
                await db.one("select * from people where inn = $1", args.inn).then(
                    val=>{
                    console.log("qury finish");
                    res = val;
                    console.log(res);
                }).catch(
                    err=>{
                        console.log("ERROR: ", err);
                        throw {
                            Fault: {
                                faultcode: -1,
                                faultstring: "Cannot get peson info!",
                                detail: {
                                    getPersonInfoJsFault: {
                                        errorMessage:err.toString(),
                                        errorCode: err.code
                                    }
                                }
                            }
                        }
                    }
                   );
                return { 
                    "inn": res.inn,
                    "firstname": res.firstname,
                    "surname": res.surname,
                    "birthdate": (new Date(res.birthdate)).toISOString(),
                    "passport_ser": res.passport_ser,
                    "passport_num": res.passport_num
                };
            }
        }
    }
}
// xml data is extracted from wsdl file created
var xmlTrembitaSoap = require('fs').readFileSync('./TrembitaService.wsdl', 'utf8');
//create an express server and pass it to a soap server
var server = app.listen(8080,function(){
    var host = "192.168.122.181";
    var port = server.address().port;
});
soap.listen(server, '/TrembitaSoap', serviceTrembita, xmlTrembitaSoap, function(){
    console.log('TrembitaService initialized');
});
