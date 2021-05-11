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
    .table{
        margin: 0;
    }
</style>
<body>
<nav class="navbar" style="background-color: lightblue">
    <img class="image1" src="../image/furama.jpg" style="margin-left: 40px">
    <p style="margin-left: 150px;color: green ; font-family: 'Agency FB';font-size: 50px">WELCOME FURAMA RESORT</p>
    <h4 style="margin-left: 200px; color: green;font-family: 'Agency FB'">C1020G1</h4>
</nav>
<nav class="navbar navbar-expand-lg " style="background-color: black">
    <a class="navbar-brand" href="#" style="margin-left: 150px">Home</a>
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
        <form class="form-inline my-2 my-lg-0" style="margin-right: 150px">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                   style="border-radius: 20px; width: 240px">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-2" style="background-color: lightgray">
            <nav class="nav flex-column">
                <a class="nav-link active" href="#">Active</a>
                <a class="nav-link" href="#">Link</a>
                <a class="nav-link" href="#">Link</a>
            </nav>
        </div>
        <div class="col-10">
            <!--            text-->
        </div>
    </div>
</div>
</div>
<div class="container-fluid">
    <div class="col-12">

    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0l
sSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
</html>
