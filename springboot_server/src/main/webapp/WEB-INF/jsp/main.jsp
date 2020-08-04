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
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
>>>>>>> 65dc4b8b9aa4ea2be2116c47b515dec8008fe8b4
    <title>Smart Valve</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
<section>
    <div class="bg">
        <a href="/svList">
        <img src="/resources/bg1.jpg" width=100%>
        </a>
    </div>
    <img src="/resources/1.png" class="layer" data-speed="4">
    <img src="/resources/2.png" class="layer logo" data-speed="-4" width=60px>
</section>
<script type="text/javascript">
    window.location.href="/svList"
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
<<<<<<< HEAD
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
=======
</body>
>>>>>>> 65dc4b8b9aa4ea2be2116c47b515dec8008fe8b4
</html>