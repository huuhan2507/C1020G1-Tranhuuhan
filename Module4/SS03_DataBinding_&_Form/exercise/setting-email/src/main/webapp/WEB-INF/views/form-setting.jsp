<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 2/24/2021
  Time: 12:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Settings</h3>
<form:form action="/setting" method="post" modelAttribute="setting">
    <div>
        <form:label path="language">Languages</form:label>
        <form:select path="language">
            <form:options items="${language}"/>
        </form:select>
    </div>
    <br>
    <div>
        <form:label path="page">Page Size: </form:label>
        <form:label path="page">Show </form:label>
        <form:select path="page">
            <form:options items="${page}"/>
        </form:select>
        <form:label path="page">  emails per page</form:label>
    </div>
    <br>
    <div>
        <form:label path="spam">Spams filter : </form:label>
        <form:checkbox path="spam"/>
        <form:label path="spam">Enable spams filter</form:label>
    </div>
    <br>
    <div>
        <form:label path="sign">Signature: </form:label>
        <form:input path="sign"/>
    </div>
    <br>
    <div>
        <input type="submit" name="action" value="Update">
        <input type="submit" name="action" value="Cancel">
    </div>
</form:form>
</body>
</html>
