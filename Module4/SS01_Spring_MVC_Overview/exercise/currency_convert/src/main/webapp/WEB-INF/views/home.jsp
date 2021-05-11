<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 2/22/2021
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> Currency Conversion </h2>
<form action="/home" method="post">
    <input name="usd" type="number" value="${usd}" >
    <button type="submit">Convert</button>
</form>
<p><c:out value="${vnd}"/></p>
</body>
</html>
