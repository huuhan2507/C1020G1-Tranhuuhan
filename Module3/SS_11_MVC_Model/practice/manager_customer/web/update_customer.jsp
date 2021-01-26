<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 1/26/2021
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/customerServlet" method="post">
        <p>
            Id:
            <input type="text" name="id" readonly value="${customerInfo.id}">
        </p>
        <p>
            Name:
            <input type="text" name="name" value="${customerInfo.name}">
        </p>
        <p>
            Email:
            <input type="text" name="email" value="${customerInfo.email}">
        </p>
        <p>
            Address:
            <input type="text" name="address" value="${customerInfo.address}">
        </p>
        <p>
            <input type="submit" value="Save" />
        </p>
    </form>
</body>
</html>
