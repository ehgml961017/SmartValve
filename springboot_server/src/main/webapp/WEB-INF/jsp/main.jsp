<<<<<<< HEAD
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
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
>>>>>>> 0d36c64bba2d02c8d9ff78fd18efec37cc95a318
<!doctype html>
<html lang="ko">
<head>
<<<<<<< HEAD
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="http://d3js.org/d3.v3.js"></script>
    <script src="https://d3js.org/d3.v4.min.js"></script>
    <title>Smart Valve List</title>
=======
    <title>Smart Valve</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
>>>>>>> 0d36c64bba2d02c8d9ff78fd18efec37cc95a318
</head>
<style>
    .align {
        text-align: center
    }

    div {
        background-image: url('/resources/le-creuset-04rqqMN_x7Q-unsplash.jpg');
        background-size: 1200px;
        height: 150px;
        padding-top: 15px;
    }

    body {

    .align {
        text-align: center
    }

    .blue {
        background: #5abae6;
    }

    .red {
        background: #d34e4e;
    }

    div {
        margin: 50px 50px;
        height: 400px;
        border: 1px solid #FFF;
        position: relative;
    }

    span {
        bottom: 0;
        position: absolute;
        font-size: 20px;
        line-height: 20px;
        color: #FFF;
        text-align: center;
        border-radius: 15px;
        display: inline-block;
        width: 60px;
    }
</style>
<style>
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
</style>
<link rel="stylesheet"
      href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<body>
<<<<<<< HEAD
<section>
    <div>
        <p>
        <h1 class="align">Smart Valve
            <img src="/resources/logo.png" width=40px
                 height=40px>
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
<%--<c:forEach items="${list}" var="list">--%>
<%--<div>
    <span class="blue" data-val=<%=time1%>>valve</span>
    <span class="red" data-val=<%=time2%>>cork</span>
    <span class="red" data-val=<%=time3%>>valve</span>
    <span class="blue" data-val=<%=time4%>>cork</span>
</div>--%>
<%--</c:forEach>--%>
<svg width="1000" height="500"></svg>
</body>
<%--<script>
    d3.selectAll("span")
    .datum(function(){ return this.dataset}) //data삽입, 선택물 각각의 속성에서 dataset을 data로 가져옴
    .style("height","0%")//초기 높이 값을 설정 한다.
    .style("left",(d,i)=>(i*100)+"px") //전달인수 d=data, i=index
    .transition().duration(1500) //막대 그래프가 1.5초동안 천천히 움직이게 합니다.
    .style("height", d=>d.val+ "%"); //선택물의 data속성 값으로 막대의 높이(height)를 바꿔줍니다.
</script>--%>
<script>
    function on_sw1() {
        var off_sw1 =
        <%=sw1%>
        if (off_sw1 == 0) {
            alert("1번스위치 시작");
            location.href = "/onSw1?num=<%=num%>&sw1=<%=sw1%>&sw2=<%=sw2%>";
        } else {
            alert("스위치가 이미 켜져있습니다 확인해주세요..")
        }
    }

    function off_sw1() {
        var on_sw1 =
        <%=sw1%>
        if (on_sw1 == 1) {
            alert("1번스위치 종료");
            location.href = "/offSw1?num=<%=num%>&sw1=<%=sw1%>&sw2=<%=sw2%>";
        } else {
            alert("스위치를 먼저 켜주세요.");
        }
    }

    function on_sw2() {
        var off_sw2 =
        <%=sw2%>
        if (off_sw2 == 0) {
            alert("2번스위치 시작");
            location.href = "/onSw2?num=<%=num%>&sw1=<%=sw1%>&sw2=<%=sw2%>";
        } else {
            alert("스위치가 이미 켜져있습니다 확인해주세요..")
        }
    }

    function off_sw2() {
        var on_sw2 =
        <%=sw2%>
        if (on_sw2 == 1) {
            alert("2번스위치 종료");
            location.href = "/offSw2?num=<%=num%>&sw1=<%=sw1%>&sw2=<%=sw2%>";
        } else {
            alert("스위치를 먼저 켜주세요.")
        }
    }
</script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
;;
<script>
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
    var keys = d3.keys(dataset[0]);
    var data = [];
    dataset.forEach(function (d, i) {
        data[i] = keys.map(function (key) {
            return {x: key, y: d[key]};
        })
    });
    var margin = {left: 20, top: 10, right: 10, bottom: 20};
    var svg = d3.select("svg");
    var width = parseInt(svg.style("width"), 10) - margin.left - margin.right;
    var height = parseInt(svg.style("height"), 10) - margin.top - margin.bottom;
    var svgG = svg.append("g")
        .attr("transform", "translate(" + margin.left + "," + margin.top + ")");
    var xScale = d3.scalePoint()//scaleBand() scaleOrdinal
        .domain(keys)
        .rangeRound([0, width]);
    var yScale = d3.scaleLinear()
        .domain([0, d3.max(dataset, function (d) {
            return d3.max(keys, function (key) {
                return d[key];
            });
        })])
        .nice()
        .range([height, 0]);
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
            .ticks(5)
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
    var legend = svgG.append("g")
        .attr("text-anchor", "end")
        .selectAll("g")
        .data(series)
        .enter().append("g")
        .attr("transform", function (d, i) {
            return "translate(0," + i * 20 + ")";
        });
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
</script>
=======
        <section>
            <div class="bg">
                <img src="/resources/bg1.jpg" width=100%>
            </div>
            <img src="/resources/1.png" class="layer" data-speed="4">
            <img src="/resources/2.png" class="layer logo" data-speed="-4" width=60px>
        </section>
        <script type="text/javascript">
            window.location.href="/"
            document.addEventListener('mousemove', parallax);
            function parallax(e){
                this.querySelectorAll('.layer').
                    forEach(layer =>{
                    var speed = layer.get
                        Attribute('data-speed')
                    var x = (window.innerWidth -
                        e.pageX * speed)/100
                    var y = (window.innerWidth -
                        e.pageY * speed)/100
                    layer.style.transform = '
                        translateX(${x}px)
                        translateX(${y}px) '
                })
            }
        </script>
    </body>
>>>>>>> 0d36c64bba2d02c8d9ff78fd18efec37cc95a318
</html>