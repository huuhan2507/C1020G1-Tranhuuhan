<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 2/2/2021
  Time: 8:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .text-1 {
            margin-top: 30px;
        }
    </style>
</head>
<body>
<h3>Create New Employee</h3>
<form method="post" action="/employeeServlet">
    <div class="text-1">
        <label>Name: </label>
        <input type="text" name="name">
    </div>
    <div class="text-1">
        <label>Birthday: </label>
        <input type="text" name="birthday">
    </div>
    <div class="text-1">
        <label>Card Id: </label>
        <input type="text" name="cardId">
    </div>
    <div class="text-1">
        <label>Salary: </label>
        <input type="text" name="salary">
    </div>
    <div class="text-1">
        <label>Phone: </label>
        <input type="text" name="phone">
    </div>
    <div class="text-1">
        <label>Email: </label>
        <input>
    </div>
    <div class="text-1">
        <label>Address: </label>
        <input type="text" name="address">
    </div>
    <div class="text-1">
        <label>Position Id: </label>
        <input type="text" name="position">
    </div>
    <div class="text-1">
        <label>Education Degree Id: </label>
        <input type="text" name="education">
    </div>
    <div class="text-1">
        <label>Division Id: </label>
        <input type="text" name="division">
    </div>
    <div class="text-1">
        <label>User Name: </label>
        <input type="text" name="user">
    </div>
    <div class="text-1">
        <button type="submit" name="action" value="close">Close</button>
        <button type="submit" name="action" value="create">Create</button>
    </div>
</form>

</body>
</html>
