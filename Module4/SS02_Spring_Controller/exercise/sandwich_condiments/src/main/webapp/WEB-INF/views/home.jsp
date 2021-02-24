<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 2/23/2021
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form action="/select" method="get">
    <input type="checkbox" name="select" value="Lettuce " >Lettuce
    <input type="checkbox" name="select" value="Tomato " >Tomato
    <input type="checkbox" name="select" value="Mustard " >Mustard
    <input type="checkbox" name="select" value="Sprouts " >Sprouts
    <hr>
    <input type="submit" value="Save">
</form>
<h3><c:out value="${sandwich}"/></h3>
</body>
</html>
