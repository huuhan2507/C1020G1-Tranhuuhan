<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 1/27/2021
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<form method="post" action="/userServlet" style="width: 300px;height: 200px; margin-left: 30px">
    <div class="mb-3">
        <input type="text" class="form-control" id="exampleInputId"value="0" name="id" hidden>
    </div>
    <div class="mb-3">
        <label for="exampleInputName" class="form-label">Name</label>
        <input type="text" class="form-control" id="exampleInputName" name="name">
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Email</label>
        <input type="text" class="form-control" id="exampleInputEmail1" name="email">
    </div>
    <div class="mb-3">
        <label for="exampleInputCountry" class="form-label">Country</label>
        <input type="text" class="form-control" id="exampleInputCountry" name="country">
    </div>
    <button type="submit" class="btn btn-primary"name="action" value="create">Save</button>
</form>
</body>
</html>
