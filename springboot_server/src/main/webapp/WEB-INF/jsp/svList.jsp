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
        color: white;
        padding: 5px;
        text-align: center;
        font-size: 12px;
        min-width: 30px;
    }

    body {
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
<svg width="800" height="420"></svg>
<script> /*차트 script*/
/*
var series = ["valve_time", "cork_time"];
$(document).ready(function () {
    jQuery.ajax({
        type: "GET",
        url: "/query",
        dataType: "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
    });
});
var dataset = [
    {
        '1': 23,
        '2': 27,
        '3': 37,
        '4': 27,
        '5': 17,
        '6': 7,
        '7': 9,
        '8': 19,
        '9': 29,
        '10': 19,
        '11': 9,
        '12': 0
    },
    {
        '1': 9,
        '2': 19,
        '3': 29,
        '4': 39,
        '5': 29,
        '6': 19,
        '7': 9,
        '8': 7,
        '9': 17,
        '10': 27,
        '11': 17,
        '12': 7
    }
];
*/
var series = ["valve_time", "cork_time"];

var dataset = [
    {
        '1': 17,
        '2': 27,
        '3': 37,
        '4': 27,
        '5': 17,
        '6': 7,
        '7': 9,
        '8': 19,
        '9': 29,
        '10': 19,
        '11': 9,
        '12': 0
    },
    {
        '1': 9,
        '2': 19,
        '3': 29,
        '4': 39,
        '5': 29,
        '6': 19,
        '7': 9,
        '8': 7,
        '9': 17,
        '10': 27,
        '11': 17,
        '12': 7
    }];

/*---2차원 배열 작업---*/
/*d3.keys () 함수 는 지정된 객체의 속성 이름 또는 키가 포함 된 배열 또는 연관 배열을 반환하는 데 사용됩니다.*/
/*1차원 배열을 2차원 배열로 변환하는 작업*/
var keys = d3.keys(dataset[0]);

var data = [];

dataset.forEach( /*변환을 위해 dataset의 개수만큼(2회) 반복한다.*/
    /*그 안에서 각 배열의 원소인 Json의 개수만큼 반복(keys.map)해서 배열 반환*/
    function (d, i) { /* data,index -> 17:'1'    '1'은 인덱스로 0이다. */
        /*반환된 배열을 다시 배열(data[i])에 넣으면서 2차월 배열이 만들어진다.*/
        data[i] = keys.map(function (key) {
                return {
                    /*{A:9}가 {x:'A',y:9}로 변환되어 저장*/
                    x: key, y: d[key]
                };
            }
        )
    }
);
/*----2차원 배열 작업 끝----*/

/*SVG내에서 차트를 중앙에 놓기 위한 코드*/
var margin = {left: 20, top: 10, right: 10, bottom: 20};
var svg = d3.select("svg");
var width = parseInt(svg.style("width"), 10) - margin.left - margin.right;
var height = parseInt(svg.style("height"), 10) - margin.top - margin.bottom;
var svgG = svg.append("g")
    .attr("transform", "translate(" + margin.left + "," + margin.top + ")");


/*x축에 1,2,3,...가 출력되도록 이 값을 가지고 있는 keys를
* xScale에 데이터로 지정하였다.*/
var xScale = d3.scalePoint()//scaleBand와는 다르게 Point는 0부터 시작하는 차이가 있다. y축에 붙어서 시작
    .domain(keys)
    .rangeRound([0, width]);

/*D3의 max함수는 주어진 배열내의 최대값을 찾아준다.
* 첫 max에 dataset을 지정하면 2개의 json 데이터가 반환되고
* 다시 각각에 대하여 max를 keys 개수만큼 반복한다.
* keys 개수만큼 반복하는 이유는 각 json 데이터 개수를 의미하기 때문이다.
* 이렇게 반복해서 키에 해당하는 값(d[key])을 반환하고 이중에 가장 큰 값(max)이
* 반환되고, 반환된 2개의 큰 값 중 가장 큰 값이 반환되어 척도 구성을 위한 domain의 값으로 지정한다.
* */
var yScale = d3.scaleLinear()
    .domain([0, d3.max(dataset, function (d) {
        return d3.max(keys, function (key) {
            return d[key];
        });
    })])
    .nice()/*그리고 이 domain의 소수점이 너무 많으면 적당히 반올림한 값을 사용하도록 했다.*/
    .range([height, 0]);

/* d3에서 지정한 컬러 값 집합(schemeCategory10)을 사용*/
var colors = d3.scaleOrdinal(d3.schemeCategory10);

svgG.append("g")
    .attr("class", "grid")
    .attr("transform", "translate(0," + height + ")")
    .call(d3.axisBottom(xScale)
        .tickSize(-height)
    );

svgG.append("g")
    .attr("class", "grid")
    .call(d3.axisLeft(yScale)
        .ticks(20)
        .tickSize(-width)
    );

var line = d3.line()
    //.curve(d3.curveBasis)
    .x(function (d) {
        return xScale(d.x);
    })
    .y(function (d) {
        return yScale(d.y);
    });
var lineG = svgG.append("g")
    .selectAll("g")
    .data(data)
    .enter().append("g");

lineG.append("path")
    .attr("class", "lineChart")
    /*각 라인별로 다른 색을 사용하게끔 지정*/
    .style("stroke", function (d, i) {
        return colors(series[i]);
    })
    .attr("d", function (d, i) {
        return line(d);
    });

lineG.selectAll("dot")
    .data(function (d) {
        return d
    })
    .enter().append("circle")
    .attr("r", 3)
    .attr("cx", function (d) {
        return xScale(d.x)
    })
    .attr("cy", function (d) {
        return yScale(d.y);
    })
    .on("mouseover", function () {
        tooltip.style("display", null);
    })
    .on("mouseout", function () {
        tooltip.style("display", "none");
    })
    .on("mousemove", function (d) {
        tooltip.style("left", (d3.event.pageX + 10) + "px");
        tooltip.style("top", (d3.event.pageY - 10) + "px");
        tooltip.html("month. " + d.x + "<br/>" + "data value : " + d.y);
    });

var tooltip = d3.select("body")
    .append("div")
    .attr("class", "toolTip")
    .style("display", "none");

/*-------범례 start---------*/
/*범례(legend)구현
* 범례는 차트 내에서 적당한 위치(우측 상단)에
* 각 라인이 나타내는 의미를 보여준다.*/
var legend = svgG.append("g")
    .attr("text-anchor", "end")
    .selectAll("g")
    .data(series)
    .enter().append("g")
    .attr("transform", function (d, i) {
        return "translate(0," + i * 20 + ")";
    });

/*
* 각 라인은 색으로 구분하기 때문에
* 도형(rect)을 생성, 어떤 데이터인지(series)를
* 문자로(text)로 출력
*/
legend.append("rect")
    .attr("x", width - 20)
    .attr("width", 19)
    .attr("height", 19)
    .attr("fill", colors);

legend.append("text")
    .attr("x", width - 30)
    .attr("y", 9.5)
    .attr("dy", "0.32em")
    .text(function (d) {
        return d;
    });
/*-------범례 end---------*/

</script>

</body>
</html>