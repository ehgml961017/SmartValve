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
    <script src="https://www.chartjs.org/dist/2.9.3/Chart.min.js"></script>
    <%--필수--%>
    <script src="https://www.chartjs.org/samples/latest/utils.js"></script>
    <%--필수--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <%--필수--%>
    <script src="analyser.js"></script>
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

    .tableSet th {
        text-align: center;
    }


</style>

<link rel="stylesheet"
      href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<body>

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
            <tr class="tableSet">
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
                    <td>
                        <c:if test="${list.sw1 ne 0}">
                            on
                        </c:if>
                        <c:if test="${list.sw1 eq 0}">
                            off
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${list.sw2 ne 0}">
                            on
                        </c:if>
                        <c:if test="${list.sw2 eq 0}">
                            off
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${list.on_sw1 ne null}">  <%--ne : not equal--%>
                            <javatime:format
                                    pattern="yyyy-MM-dd HH:mm:ss"
                                    value="${list.on_sw1}"/>
                        </c:if>
                        <c:if test="${list.on_sw1 eq null}">

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

                        </c:if>
                    </td>
                    <td>
                        <c:if test="${list.on_sw2 ne null}">
                            <javatime:format
                                    pattern="yyyy-MM-dd HH:mm:ss"
                                    value="${list.on_sw2}"/>
                        </c:if>
                        <c:if test="${list.on_sw2 eq null}">

                        </c:if>
                    </td>
                    <td>
                        <c:if test="${list.off_sw2 ne null}">
                            <javatime:format
                                    pattern="yyyy-MM-dd HH:mm:ss"
                                    value="${list.off_sw2}"/>
                        </c:if>
                        <c:if test="${list.off_sw2 eq null}">

                        </c:if>
                    </td>
                    <td>${list.valve_time}</td>
                    <td>${list.cork_time}</td>
                </tr>
            </c:forEach>
        </table>
    </article>

    <article>
        <button id="on_sw1" class="btn btn-secondary" onclick="on_sw1()">
            sw1(on)
        </button>
        <button id="off_sw1" class="btn btn-secondary" onclick="off_sw1()">
            sw1(off)
        </button>
        <button id="on_sw2" class="btn btn-secondary" onclick="on_sw2()">
            sw2(on)
        </button>
        <button id="off_sw2" class="btn btn-secondary" onclick="off_sw2()">
            sw2(off)
        </button>
    </article>
</section>
</body>

<script>
    function on_sw1() {

        let off_sw1 =<%=sw1%>;
        if (off_sw1 === 0) {
            alert("1번스위치 시작");
            location.href = "/onSw1?num=<%=num%>&sw1=<%=sw1%>&sw2=<%=sw2%>";
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
            location.href = "/onSw2?num=<%=num%>&sw1=<%=sw1%>&sw2=<%=sw2%>";
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
/*변수 선언 방식 const - 변수 재선언, 변수 재할당 모두 불가능하다.*/
const chartLabels = []; //chart의 x축 데이터(num할당)
const chartData1 = [];  //chart의 valve_time의 data를 담당
const chartData2 = [];  //chart의 cork_time의 data를 담당

$.getJSON("http://localhost:8085/incomeList", function (data) {//$.getJSON(url,callback) url에서 json파일 로드
    $.each(data, function (index, item) { //$.each(collection, callback) collection은 배열이나 객체
        chartLabels.push(item.num);
        chartData1.push(item.valve_time);
        chartData2.push(item.cork_time);
    });
/*
    (1) $.getJSON(url,callback)
    1) 자바에서 static 메서드와 유사--> jQuery에서는 전역메서드라 불린다.
    2) 첫번째 매개변수로 JSON 파일을 로드한다.
    3) 두번째 매개변수(콜백함수)에서 JSON 파일을 이용하여 로드된 데이터를 처리한다.
        콜백함수는 로드된 데이터를 인자로 넘겨받는다.(JSON 데이터를 참조하기 위해 data 변수를 사용하고 있다.)
*/
/*
    $.each(collection, callback)
    1) 매개변수
    - collection: 순회할 배열이나 객체
    - callback: 컬렉션의 각 요소를 대상으로 실행할 콜백 함수
        callback 함수에서 첫번째 매개변수는 객체의 개수를 반환한다. index는 0부터 시작한다.
        callback 함수에서 두번째 매개변수는 객체의 key값을 반환한다. 반환된 key값을 이용하여 value값을 구할 수 있다.
    2) 반환값: 컬렉션의 매개변수
*/
    createChart(); //함수 호출
    console.log("create Chart")
});

const lineChartData = {
    type: "line",   //line chart 명시
    labels: chartLabels,    //data들의 label, x축
    datasets: [ //데이터 삽입
        {
            label: "valve_time",    //각 데이터의 label
            fill: false,    //채우지 않음
            backgroundColor: window.chartColors.red,    //선채우기 색상
            borderColor: window.chartColors.red,    //선 색상
            data: chartData1,   //데이터 값
        },
        {
            label: "cork_time",
            fill: false,
            backgroundColor: window.chartColors.blue,
            borderColor: window.chartColors.blue,
            data: chartData2
        }
    ]
};


function createChart() {
    const ctx = document.getElementById("canvas").getContext("2d"); //캔버스 셋팅
    /* 2D 그래픽의 경우, CanvasRenderingContext2D을 얻기위해 "2d"로 지정*/
    LineChartDemo = Chart.Line(ctx, {
        data: lineChartData,
        options: {
            responsive: true,   //canvas의 크기 상대적 조정(반응형)
            title: {    /*차트의 이름*/
                display: true,
                text: "Smart Valve"
            },
            scales: {
                xAxes: [{   //x축 정의
                    display: true,
                    scaleLabel: {   //x축 Label
                        display: true,
                        labelString: "Number"   //제목 text
                    }
                }],
                yAxes: [{   //y축 정의
                    display: true,
                    scaleLabel: {   //y축 label
                        display: true,
                        labelString: "elapsed time"
                    },
                    ticks: {
                        beginAtZero: true   //y축이 0부터 시작
                    }
                }]
            }
        }
    })
}
</script>
</body>
</html>