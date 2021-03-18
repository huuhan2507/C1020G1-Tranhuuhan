<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 2/2/2021
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
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
<form style="margin-left: 30px" method="post" action="/employeeServlet">
    <div class="form-group">
        <label for="exampleInputName">Id</label>
        <input type="text" class="form-control" id="exampleInputId" aria-describedby="emailHelp" name="id"
               value="${employee.employeeId}" readonly >
    </div>
    <div class="form-group">
        <label for="exampleInputName">Name</label>
        <input required type="text" class="form-control" id="exampleInputName" aria-describedby="emailHelp" name="name"
               value="${employee.employeeName}" >
    </div>
    <div class="form-group">
        <label for="exampleInputBirthday">Birthday</label>
        <input required type="date" class="form-control" id="exampleInputBirthday" name="birthday"
               value="${employee.employeeBirthDay}">
    </div>
    <div class="form-group">
        <label for="exampleInputCardId">Card Id</label>
        <input type="text" class="form-control" id="exampleInputCardId" name="cardId"
               value="${employee.employeeIdCard}">
        <label for="exampleInputCardId" class="text-1"><c:out value="${errEmployee.get(1)}"/></label>
    </div>
    <div class="form-group">
        <label for="exampleInputSalary">Salary</label>
        <input required type="text" class="form-control" id="exampleInputSalary" name="salary"
               value="${employee.employeeSalary}">
        <label for="exampleInputSalary" class="text-1"><c:out value="${errEmployee.get(3)}"/></label>
    </div>
    <div class="form-group">
        <label for="exampleInputPhone">Phone</label>
        <input required type="text" class="form-control" id="exampleInputPhone" name="phone"
               value="${employee.employeePhone}">
        <label for="exampleInputPhone" class="text-1"><c:out value="${errEmployee.get(0)}"/></label>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail">Email</label>
        <input required type="text" class="form-control" id="exampleInputEmail" name="email"
               value="${employee.employeeEmail}">
        <label for="exampleInputEmail" class="text-1"><c:out value="${errEmployee.get(2)}"/></label>
    </div>
    <div class="form-group">
        <label for="exampleInputAddress">Address</label>
        <input required type="text" class="form-control" id="exampleInputAddress" name="address"
               value="${employee.employeeAddress}">
    </div>
    <div class="form-group">
        <label>Position</label>
        <select class="form-control" name="position">
            <option value="1">Giam doc</option>
            <option value="2">Quan Li</option>
            <option value="3">Phuc vu</option>
            <option value="4">Chuyen vien</option>
            <option value="5">Giam sat</option>
            <option value="6">Le Tan</option>
        </select>
    </div>
    <div class="form-group">
        <label>Education Degree</label>
        <select class="form-control" name="education">
            <option value="1">Dai Hoc</option>
            <option value="2">Cao Dang</option>
            <option value="3">Trung Cap</option>
            <option value="4">Sau Dai Hoc</option>
        </select>
    </div>
    <div class="form-group">
        <label>Division</label>
        <select class="form-control" name="division">
            <option value="1">Hanh chinh</option>
            <option value="2">Marketing</option>
            <option value="3">Phuc vu</option>
            <option value="4">Quan Li</option>
        </select>
    </div>
    <div class="form-group">
        <label for="exampleInputUserName">UserName</label>
        <input required type="text" class="form-control" id="exampleInputUserName" name="user"
               value="${employee.userName}">
    </div>
    <a class="btn btn-secondary" href="/employeeServlet">Close</a>
    <button type="submit" class="btn btn-primary" name="action" value="update">Update</button>
</form>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0l
sSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
</html>
