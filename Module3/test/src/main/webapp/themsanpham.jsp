<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 2/4/2021
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <style>
        .form-control{
            width: 400px;
            height: 40px;
        }
    </style>
</head>

<body>
<form style="margin-left: 30px" method="post" action="/sanPhamServlet">
    <input hidden name="id" value="0">
    <div class="form-group">
        <label for="exampleInputName">Name(*)</label>
        <input required type="text" class="form-control" id="exampleInputName" aria-describedby="emailHelp" name="name"
               value="" >
        <label for="exampleInputName" class="text-1"><c:out value=""/></label>
    </div>
    <div class="form-group">
        <label for="exampleInputPrice">Price(*)</label>
        <input required type="text" class="form-control" id="exampleInputPrice" name="price"
               value="">
        <label for="exampleInputPrice" class="text-1"><c:out value=""/></label>
    </div>
    <div class="form-group">
        <label>Discount(*)</label>
        <select class="form-control" name="discount">
            <option value="5">5(%)</option>
            <option value="10">10(%)</option>
            <option value="15">15(%)</option>
            <option value="20">20(%)</option>
        </select>
    </div>
    <div class="form-group">
        <label for="exampleInputSalary">Stock(*)</label>
        <input required type="text" class="form-control" id="exampleInputSalary" name="stock"
               value="">
        <label for="exampleInputSalary" class="text-1"><c:out value=""/></label>
    </div>
    <button type="submit">Thêm</button>
</form>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

</html>
