<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 2/3/2021
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<style>
    .form-control{
        width: 400px;
        height: 40px;
    }
    .text-1{
        color: red;
    }
</style>
<body>
<form style="margin-left: 30px" method="post" action="/serviceServlet">
    <div class="form-group">
        <label for="exampleInputId">Id Service</label>
        <input type="text" class="form-control" id="exampleInputId" aria-describedby="emailHelp" name="name"
               value="${service.serviceId}" readonly>
    </div>
    <div class="form-group">
        <label for="exampleInputName">Name Service</label>
        <input required type="text" class="form-control" id="exampleInputName" aria-describedby="emailHelp" name="name"
               value="${service.serviceName}" >
    </div>
    <div class="form-group">
        <label for="exampleInputArea">Area</label>
        <input required type="text" class="form-control" id="exampleInputArea" name="area"
               value="${service.serviceArea}">
    </div>
    <div class="form-group">
        <label for="exampleInputCost">Cost</label>
        <input type="text" class="form-control" id="exampleInputCost" name="cost"
               value="${service.serviceCost}">
        <label for="exampleInputCost" class="text-1"><c:out value=""/></label>
    </div>
    <div class="form-group">
        <label for="exampleInputMaxPeople">Max People</label>
        <input required type="text" class="form-control" id="exampleInputMaxPeople" name="people"
               value="${service.serviceMaxPeople}">
        <label for="exampleInputMaxPeople" class="text-1"><c:out value=""/></label>
    </div>
    <div class="form-group">
        <label>Rent Type</label>
        <select class="form-control" name="rentType">
            <option value="1">Hour</option>
            <option value="2">Day</option>
            <option value="3">Month</option>
            <option value="4">Year</option>
        </select>
    </div>
    <div class="form-group">
        <label>Service Type</label>
        <select class="form-control" name="type">
            <option value="1">Villa</option>
            <option value="2">House</option>
            <option value="3">Room</option>
        </select>
    </div>
    <div class="form-group">
        <label>Standard Room</label>
        <select class="form-control" name="room">
            <option value="1">Vip</option>
            <option value="2">Bussiness</option>
            <option value="3">Normal</option>
        </select>
    </div>
    <div class="form-group">
        <label for="exampleInputOther">Description Other Convenience</label>
        <input required type="text" class="form-control" id="exampleInputOther" name="doc"
               value="${service.descriptionOtherConvenience}">
    </div>
    <div class="form-group">
        <label for="exampleInputAreaPool">Area Pool</label>
        <input required type="text" class="form-control" id="exampleInputAreaPool" name="ap"
               value="${service.areaPool}">
    </div>
    <div class="form-group">
        <label for="exampleInputFloors">Floors</label>
        <input required type="text" class="form-control" id="exampleInputFloors" name="floor"
               value="${service.numberOfFloors}">
    </div>
    <a class="btn btn-secondary" href="/serviceServlet">Close</a>
    <button type="submit" class="btn btn-primary" name="action" value="update">Update</button>
</form>

</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0l
sSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
</html>
