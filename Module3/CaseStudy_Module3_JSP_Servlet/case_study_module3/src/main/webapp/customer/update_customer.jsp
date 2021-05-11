<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 2/2/2021
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</style>
<body>
<form style="margin-left: 30px" method="post" action="/customerServlet">
    <div class="form-group">
        <label for="exampleInputId">Id</label>
        <input type="text" class="form-control" id="exampleInputId" aria-describedby="emailHelp" name="id" readonly
        value="${customer.customerId}">
    </div>
    <div class="form-group">
        <label>Customer Type</label>
        <select class="form-control" name="type">
            <option value="1">Diamond</option>
            <option value="2">Platinum</option>
            <option value="3">Gold</option>
            <option value="4">Silver</option>
            <option value="5">Member</option>
        </select>
    </div>
    <div class="form-group">
        <label for="exampleInputName">Name</label>
        <input type="text" class="form-control" id="exampleInputName" aria-describedby="emailHelp" name="name"
               value="${customer.customerName}">
    </div>
    <div class="form-group">
        <label for="exampleInputBirthday">Birthday</label>
        <input type="date" class="form-control" id="exampleInputBirthday" name="birthday" value="${customer.customerBirthday}">
    </div>
    <div class="form-group">
        <label>Gender</label>
        <select class="form-control" name="gender">
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Unknown">Unknown</option>
        </select>
    </div>
    <div class="form-group">
        <label for="exampleInputCardId">Card Id</label>
        <input type="text" class="form-control" id="exampleInputCardId" name="cardId" value="${customer.customerIdCard}">
        <label for="exampleInputCardId" class="text-1"><c:out value="${errCustomer.get(1)}"/></label>
    </div>

    <div class="form-group">
        <label for="exampleInputPhone">Phone</label>
        <input type="text" class="form-control" id="exampleInputPhone" name="phone" value="${customer.customerPhone}">
        <label for="exampleInputPhone" class="text-1"><c:out value="${errCustomer.get(0)}"/></label>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail">Email</label>
        <input type="text" class="form-control" id="exampleInputEmail" name="email" value="${customer.customerEmail}">
        <label for="exampleInputEmail" class="text-1"><c:out value="${errCustomer.get(2)}"/></label>
    </div>
    <div class="form-group">
        <label for="exampleInputAddress">Address</label>
        <input type="text" class="form-control" id="exampleInputAddress" name="address" value="${customer.customerAddress}">
    </div>
    <a class="btn btn-secondary" href="/customerServlet">Close</a>
    <button type="submit" class="btn btn-primary" name="action" value="update">Update</button>
</form>

</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0l
sSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
</html>
