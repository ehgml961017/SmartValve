<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
    <title>Smart Valve</title>
    <link rel="stylesheet" type="text/css" href="style.css"
</head>
<body>
        <section>
            <div class="bg">
                <img src="bg1.jpg" class="layer" data-speed="-2">
            </div>
            <img src="Smart Valve icon.png" class="layer" data-speed="4">
        </section>
        <script type="text/javascript">
            document.addEventListener('mousemove'
                , parallax);
            function parallax(e){
                this.querySelectorAll('.layer').
                    forEach(layer =>{
                    var speed = layer.getAttribute('data-speed')
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
</html>