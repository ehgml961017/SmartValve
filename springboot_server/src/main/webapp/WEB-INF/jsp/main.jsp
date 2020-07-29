<<<<<<< HEAD
<!doctype html>
<html>
    <head>
        <title>Mousemove Parallax | Vanilla Javascript</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <section>
            <img src="1.png" data-speed="-5" class="layer">
            <img src="2.png" data-speed="5" class="layer">
            <img src="3.png" data-speed="2" class="layer">
            <img src="4.png" data-speed="6" class="layer">
            <img src="5.png" data-speed="8" class="layer">
            <img src="6.png" data-speed="-2" class="layer">
            <img src="7.png" data-speed="4" class="layer">
            <img src="8.png" data-speed="-9" class="layer">
            <img src="9.png" data-speed="6" class="layer">
            <img src="10.png" data-speed="-7" class="layer">
            <img src="11.png" data-speed="-5" class="layer">
            <img src="12.png" data-speed="5" class="layer">
            <h2 class="layer" data-speed="2">Parallax</h2>
        </section>
        <script type="text/javascript">
            document.addEventListener("mousemove" , parallax);
            function parallax(e){
                this.querySelectorAll('.layer').forEach(layer => {
                    const speed = layer.getAttribute('data-speed')

                    const x = (window.innerWidth - e.pageX*speed)/100
                    const y = (window.innerHeight - e.pageY*speed)/100

                    layer.style.transform = 'translateX(${x}px) translateY(${y}px)'
                })
            }
        </script>
    </body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>SmartValve</title>
</head>
<body>

</body>
>>>>>>> 2f0cd22d600b4133799a198ac8d7a89bcee61eda
</html>