<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 1/26/2021
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <style>
        th{
            background-color: yellow;
        }
        td{
            background-color: lightblue;
        }
    </style>
</head>
<body>
<table class="table" border="3">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col" colspan="2" style="text-align: center">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customerListFromServlet}">
        <tr>
            <td><c:out value="${customer.id}"/></td>
            <td><c:out value="${customer.name}"/></td>
            <td><c:out value="${customer.email}"/></td>
            <td><c:out value="${customer.address}"/></td>
            <td><a href="/customerServlet?actionUser=update&id=${customer.id}">
                Update
            </a>
            </td>
            <td><a href="/customerServlet?actionUser=delete&id=${customer.id}">
                Delete
            </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p style="text-align: center;font-size: 18px"><a href="/customerServlet?actionUser=create">Add New Customer</a></p>

</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C
+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity
        ="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</html>
