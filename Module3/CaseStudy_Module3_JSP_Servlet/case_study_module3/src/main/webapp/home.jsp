<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 2/1/2021
  Time: 9:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Furama Resort</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<style>
    .nav-link {
        margin-left: 50px;
    }

    .image1 {
        width: 100px;
        height: 100px;
    }

    .nav-link:hover {
        background-color: white;
    }

    a {
        color: white;
    }
    #image_1,#image_2,#image_3{
        margin-left: 20px;
        width: 900px;
        height: 520px;
    }
    .image-2{
        width: 100%;
        height: 45px;
    }
    #a1{
        padding: 0;
        margin: 0;
    }
    .col-12{
        margin: 0;
        padding: 0;
    }
</style>
<body>
<nav class="navbar" style="background-color: lightblue">
    <img class="image1" src="../image/furama.jpg" style="margin-left: 40px">
    <p style="margin-left: 150px;color: green ; font-family: 'Agency FB';font-size: 50px">WELCOME FURAMA RESORT</p>
    <h4 style="margin-left: 200px; color: green;font-family: 'Agency FB'">C1020G1</h4>
</nav>
<nav class="navbar navbar-expand-lg " style="background-color: black">
    <a class="navbar-brand" href="home.jsp" style="margin-left: 150px">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/employeeServlet"> Employee <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/customerServlet">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="/serviceServlet" tabindex="-1" aria-disabled="true">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="/contractServlet" tabindex="-1" aria-disabled="true">Contract</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" style="margin-right: 150px" action="">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                   style="border-radius: 20px; width: 240px">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="action" value="search">Search</button>
        </form>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-2" style="background-color: lightblue;height: 535px">
            <nav class="nav flex-column" style="padding: 0;margin: 0">
                <a class="nav-link active" href="https://furamavietnam.com/vi/the-resort/"
                   style="font-size: 20px;color: black;margin-top: 20px">Introduce</a>
                <a class="nav-link" href="https://furamavietnam.com/vi/furama-special-offers/"
                   style="font-size: 20px;color: black;margin-top: 20px">Incentives</a>
                <a class="nav-link" href="https://furamavietnam.com/vi/meeting-and-events/"
                   style="font-size: 20px;color: black;margin-top: 20px">Event</a>
            </nav>
        </div>
        <div class="col-10">
            <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="../image/furama_resort_3.jpg" id="image_1"  class="d-block w-100" alt="">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Khu nghỉ dưỡng Đà Nẵng</h5>
                            <p>Một trong 6 bãi biển đẹp nhất</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="../image/furama_resort_2.jpg" id="image_2" class="d-block w-100" alt="">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Khu nghỉ dưỡng Đà Nẵng</h5>
                            <p>Khu nghỉ dưỡng Furama Đà Nẵng là một khu nghỉ dưỡng 5 sao sang trọng, có uy tín
                                và được xem là một trong những biểu tượng của ngành du lịch Việt Nam.</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="../image/furama_resort_1.jpg" id="image_3" class="d-block w-100" alt="">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Khu nghỉ dưỡng Đà Nẵng</h5>
                            <p>khu nghỉ dưỡng đẳng cấp thế giới, furama đà nẵng, nổi tiếng là khu nghỉ dưỡng ẩm thực tại việt nam.</p>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

        </div>
    </div>
</div>
</div>
<div class="container-fluid" id="a1">
    <div class="col-12">
        <img class="image-2" src="../image/image-footer.PNG">
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
</html>
