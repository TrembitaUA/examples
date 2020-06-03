<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table{
                border: solid 1px;
            }
            td{
                border: solid 1px;
                padding: 2px;
            }
        </style>
    </head>
    <body>
        <jsp:useBean id="dataProvider" class="com.sx.uxp.training.PeopleClientDataProvider" scope="page">
        </jsp:useBean>
        
        <c:choose>
            <c:when test="${empty param.inn}">
                <c:set var="data" scope="page" value="${dataProvider.listAllData()}"/>
            </c:when>
            <c:otherwise>
                <c:set var="data" scope="page" value="${dataProvider.findDataByInn(param.inn)}"/>
            </c:otherwise>
        </c:choose>
        <form action="" method="get">
            <input type="text" name="inn"/>
            <input type="submit"/>
        </form>
        <table>
            <tr>
                <th>Прізвище</th>
                <th>Им'я</th>
                <th></th>
                <th>ІНН</th>
                <th>Дата народження</th>
                <th>Паспорт</th>
                <th></th>
            </tr>
            <c:forEach items="${data}" var="dataItem">
                <tr>
                    <td>${dataItem.surname}</td>
                    <td>${dataItem.firstname}</td>
                    <td>${dataItem.patronymic}</td>
                    <td>${dataItem.inn}</td>
                    <td>${dataItem.birthdate}</td>
                    <td>${dataItem.passportSer}</td>
                    <td>${dataItem.passportNum}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

