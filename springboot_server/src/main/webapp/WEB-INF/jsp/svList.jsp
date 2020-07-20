<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>

<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>스마트 밸브 리스트</title>
</head>
<body>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<style>
    .align {
        text-align: center
    }
</style>
<link rel="stylesheet"
      href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<body>
<div>
    <p>
    <h1 class="align">Smart Valve
        <img src="/resources/logo.png" width=40px
             height=40px>
    </h1>
    </p>
    <hr>

</div>
<table class="table table-striped">
    <tr>
        <th>No.</th>
        <th>valve</th>
        <th>cork</th>
        <th>valve_on_date</th>
        <th>valve_off_date</th>
        <th>cork_on_date
        <th>cork_off_date</th>
    </tr>
    <c:forEach items="${list}" var="list">
        <tr>
            <c:if test="${not empty list}"/>
            <td>${list.num}</td>
            <td>${list.sw1}</td>
            <td>${list.sw2}</td>
            <td>
                <c:if test="${list.on_sw1 ne null}">  <%--ne : not equal--%>
                    <fmt:formatDate
                            pattern="yyyy-MM-dd 'T' HH:mm:ss"
                            value="${list.on_sw1}"></fmt:formatDate>
                </c:if>
                <c:if test="${list.on_sw1 eq null}">
                    null
                </c:if>
            </td>
            <td>
                <c:if test="${list.off_sw1 ne null}">
                    <fmt:formatDate
                            pattern="yyyy-MM-dd 'T' HH:mm:ss"
                            value="${list.off_sw1}"/>
                </c:if>
                <c:if test="${list.off_sw1 eq null}">
                    null
                </c:if>

            </td>
            <td>
                <c:if test="${list.on_sw2 ne null}"><fmt:formatDate
                        pattern="yyyy-MM-dd 'T' HH:mm:ss"
                        value="${list.on_sw2}"/>
                </c:if>
                <c:if test="${list.on_sw2 eq null}">
                    null
                </c:if>
            </td>
            <td><c:if test="${list.off_sw2 ne null}"/><fmt:formatDate
                    pattern="yyyy-MM-dd 'T' HH:mm:ss"
                    value="${list.off_sw2}"/>
                <c:if test="${list.off_sw2 eq null}">
                    null
                </c:if>
            </td>
        </tr>

    </c:forEach>
</table>

</body>
</html>