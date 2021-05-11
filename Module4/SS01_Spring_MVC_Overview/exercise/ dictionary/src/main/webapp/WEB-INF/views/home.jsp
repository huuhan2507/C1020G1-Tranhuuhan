<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 2/22/2021
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dictionary</title>
</head>
<body>
<h2>Dictionary</h2>
<form action="/search" method="post">
    <input type="text" name="search" value="${search}">
    <button type="submit">Search</button>
</form>
<p><c:out value="${result}"/></p>
</body>
</html>
