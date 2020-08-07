<%@ page import="com.springboot.smartvalve.dto.SvDTO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@ page session="false" %>
<% SvDTO svDTO = new SvDTO();
    List<SvDTO> numArr = (List<SvDTO>) request.getAttribute("list");
    //모델에서 넘어온 파라미터.
    int num = numArr.get(0).getNum();
    int sw1 = numArr.get(0).getSw1();
    int sw2 = numArr.get(0).getSw2();

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
    <script src="https://www.chartjs.org/dist/2.9.3/Chart.min.js"></script>
    <script src="https://www.chartjs.org/samples/latest/utils.js"></script>
    <title>Smart Valve List</title>
</head>
<style>
    .align {
        text-align: center;
        background-image: url('/resources/image/le-creuset-04rqqMN_x7Q-unsplash.jpg');
        background-size: 1200px;
        height: 150px;
        padding-top: 40px;
    }

    body {
        text-align: center;
    }

</style>

<link rel="stylesheet"
      href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
<section>
    <div>
        <p>
        <h1 class="align">Smart Valve
            <img src="/resources/image/logo.png" width=40px;
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
                <th>cork_on_date</th>
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
                            <javatime:format
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
                            <javatime:format
                                    pattern="yyyy-MM-dd HH:mm:ss"
                                    value="${list.off_sw1}"/>
                        </c:if>
                        <c:if test="${list.off_sw1 eq null}">
                            null
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${list.on_sw2 ne null}">
                            <javatime:format
                                    pattern="yyyy-MM-dd HH:mm:ss"
                                    value="${list.on_sw2}"/>
                        </c:if>
                        <c:if test="${list.on_sw2 eq null}">
                            null
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${list.off_sw2 ne null}">
                            <javatime:format
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
</body>

<script>
    function on_sw1() {

        let off_sw1 =<%=sw1%>;
        if (off_sw1 === 0) {
            alert("1번스위치 시작");
            location.href = "/onSw1?num=<%=num%>&sw1=<%=sw1+1%>&sw2=<%=sw2%>";
        } else {
            alert("스위치가 이미 켜져있습니다 확인해주세요..");
        }
    }

    function off_sw1() {
        let on_sw1 =
        <%=sw1%>
        if (on_sw1 === 1) {
            alert("1번스위치 종료");
            location.href = "/offSw1?num=<%=num%>&sw1=<%=sw1%>&sw2=<%=sw2%>";
        } else {
            alert("스위치를 먼저 켜주세요.");
        }
    }

    function on_sw2() {
        let off_sw2 =
        <%=sw2%>
        if (off_sw2 === 0) {
            alert("2번스위치 시작");
            location.href = "/onSw2?num=<%=num%>&sw1=<%=sw1%>&sw2=<%=sw2+1%>";
        } else {
            alert("스위치가 이미 켜져있습니다 확인해주세요..");
        }
    }

    function off_sw2() {
        let on_sw2 =
        <%=sw2%>
        if (on_sw2 === 1) {
            alert("2번스위치 종료");
            location.href = "/offSw2?num=<%=num%>&sw1=<%=sw1%>&sw2=<%=sw2%>";
        } else {
            alert("스위치를 먼저 켜주세요.");
        }
    }
</script>

<div style="width: 60%; margin: 30px 0px 100px 300px">
    <canvas id="canvas" height="450" width="600"></canvas>
</div>
<script> /*차트 script*/
var chartLabels = [];

var chartData1 = [];
var chartData2 = [];


$.getJSON("http://localhost:8085/incomeList", function(data){

    $.each(data, function(inx, obj){
        chartLabels.push(obj.num);
        chartData1.push(obj.valve_time);
        chartData2.push(obj.cork_time);
    });

    createChart();
    console.log("create Chart")


});

var lineChartData = {
    type: "line",
    labels : chartLabels,
    datasets : [
        {
            label : "valve_time",
            fill : false,
            backgroundColor: window.chartColors.red,
            borderColor: window.chartColors.red,
            data : chartData1
        },
        {
            label : "cork_time",
            fill : false,
            backgroundColor: window.chartColors.blue,
            borderColor: window.chartColors.blue,
            data : chartData2
        }
    ]
}



function createChart(){
    var ctx = document.getElementById("canvas").getContext("2d");
    LineChartDemo = Chart.Line(ctx,{
        data : lineChartData,
        options :{
            responsive: true,
            title: {
                display: true,
                text: "Smart Valve"
            },
            scales : {
                xAxes: [{
                   display: true,
                   scaleLabel: {
                       display: true,
                       labelString: "elapsed time"
                   }
                }],
                yAxes : [{
                    display: true,
                    scaleLabel: {
                        display: true,
                        labelString: "Number"
                    },
                    ticks :{
                        beginAtZero : true
                    }
                }]
            }
        }
    })
}
</script>
</body>
</html>