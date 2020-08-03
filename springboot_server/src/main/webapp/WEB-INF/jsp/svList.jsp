<%@ page import="com.springboot.smartvalve.dto.SvDTO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<% SvDTO svDTO = new SvDTO();
    List<SvDTO> numArr = (List<SvDTO>) request.getAttribute("list");
    //모델에서 넘어온 파라미터.
    int num = numArr.get(0).getNum();
    int sw1 = numArr.get(0).getSw1();
    int sw2 = numArr.get(0).getSw2();

//    int time1 = numArr.get(1).getValve_time();
//    int time2 = numArr.get(1).getCork_time();
//    int time3 = numArr.get(2).getValve_time();
//    int time4 = numArr.get(2).getCork_time();

%>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="http://d3js.org/d3.v3.js"></script>
    <script src="https://d3js.org/d3.v4.min.js"></script>
    <title>Smart Valve List</title>
</head>
<style>
.align {
    text-align: center;
    background-image: url('/resources/le-creuset-04rqqMN_x7Q-unsplash.jpg');
    background-size: 1200px;
    height: 150px;
    padding-top: 40px;
}
.grid line {
    stroke: lightgrey;
    stroke-opacity: 0.7;
}
.lineChart {
    fill: none;
    stroke: steelblue;
    stroke-width: 1.5px;
}
.lineChart:hover {
    stroke: black;
    stroke-width: 3px;
}
.toolTip {
    position: absolute;
    border: 1px solid;
    border-radius: 4px 4px 4px 4px;
    background: rgba(0, 0, 0, 0.8);
    color : white;
    padding: 5px;
    text-align: center;
    font-size: 12px;
    min-width: 30px;
}

</style>

<link rel="stylesheet"
      href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<body>
<section>
    <div>
    <p>
        <h1 class="align">Smart Valve
            <img src="/resources/logo.png" width=40px;
                 height=40px;>
        </h1>
    </p>
    </div>
    <hr>
</section>
<section>
    <article>
        <table class="table table-striped">
            <tr>
                <th>No.</th>
                <th>valve</th>
                <th>cork</th>
                <th>valve_on_date</th>
                <th>valve_off_date</th>
                <th>cork_on_date
                <th>cork_off_date</th>
                <th>valve_time</th>
                <th>cork_time</th>
            </tr>
            <c:forEach items="${list}" var="list">
                <tr>
                    <td>${list.num}</td>
                    <td>${list.sw1}</td>
                    <td>${list.sw2}</td>
                    <td>
                        <c:if test="${list.on_sw1 ne null}">  <%--ne : not equal--%>
                            <fmt:formatDate
                                    pattern="yyyy-MM-dd HH:mm:ss"
                                    value="${list.on_sw1}"/>
                        </c:if>
                        <c:if test="${list.on_sw1 eq null}">
                            null
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${list.off_sw1 ne null}">
                            <%--ne : not equal--%>
                            <fmt:formatDate
                                    pattern="yyyy-MM-dd HH:mm:ss"
                                    value="${list.off_sw1}"/>
                        </c:if>
                        <c:if test="${list.off_sw1 eq null}">
                            null
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${list.on_sw2 ne null}">
                            <fmt:formatDate
                                    pattern="yyyy-MM-dd HH:mm:ss"
                                    value="${list.on_sw2}"/>
                        </c:if>
                        <c:if test="${list.on_sw2 eq null}">
                            null
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${list.off_sw2 ne null}">
                            <fmt:formatDate
                                    pattern="yyyy-MM-dd HH:mm:ss"
                                    value="${list.off_sw2}"/>
                        </c:if>
                        <c:if test="${list.off_sw2 eq null}">
                            null
                        </c:if>
                    </td>
                    <td>${list.valve_time}</td>
                    <td>${list.cork_time}</td>
                </tr>
            </c:forEach>
        </table>
    </article>

    <article>
        <button id="on_sw1" onclick="on_sw1()">sw1(on)</button>
        <button id="off_sw1" onclick="off_sw1()">sw1(off)</button>
        <button id="on_sw2" onclick="on_sw2()">sw2(on)</button>
        <button id="off_sw2" onclick="off_sw2()">sw2(off)</button>
    </article>
</section>

<script>
    function on_sw1() {

        var off_sw1 = <%=sw1%>
        if (off_sw1==0) {
            alert("1번스위치 시작");
            location.href = "/onSw1?num=<%=num%>&sw1=<%=sw1%>&sw2=<%=sw2%>";
        }
        else
        {
            alert("스위치가 이미 켜져있습니다 확인해주세요..")
        }
    }

    function off_sw1() {
        var on_sw1 = <%=sw1%>
        if (on_sw1==1) {
            alert("1번스위치 종료");
            location.href = "/offSw1?num=<%=num%>&sw1=<%=sw1%>&sw2=<%=sw2%>";
        }
        else
        {
            alert("스위치를 먼저 켜주세요.");
        }
    }

    function on_sw2() {
        var off_sw2 = <%=sw2%>
        if (off_sw2==0) {
            alert("2번스위치 시작");
            location.href = "/onSw2?num=<%=num%>&sw1=<%=sw1%>&sw2=<%=sw2%>";
        }
        else
        {
            alert("스위치가 이미 켜져있습니다 확인해주세요..")
        }
    }

    function off_sw2() {
        var on_sw2 = <%=sw2%>
        if (on_sw2==1) {
            alert("2번스위치 종료");
            location.href = "/offSw2?num=<%=num%>&sw1=<%=sw1%>&sw2=<%=sw2%>";
        }
        else
        {
            alert("스위치를 먼저 켜주세요.")
        }
    }
</script>

</body>
</html>