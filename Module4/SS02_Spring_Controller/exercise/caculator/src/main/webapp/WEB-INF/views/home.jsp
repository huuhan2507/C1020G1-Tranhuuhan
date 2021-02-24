<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 2/23/2021
  Time: 11:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Calculator</h2>
<form action="/calculator" method="get">
    <input type="number" name="number1" placeholder="Number 1" value="${number1}">
    <br><br>
    <input type="number" name="number2" placeholder="Number 2" value="${number2}">
    <br><br>
    <input type="submit" name="calculation" value="Add">
    <input type="submit" name="calculation" value="Sub">
    <input type="submit" name="calculation" value="Mul">
    <input type="submit" name="calculation" value="Div">
</form>
<h4 style="color: #ff001b"><c:out value="${message}"/></h4>
<h3><c:out value="${result}"/></h3>
</body>
</html>
