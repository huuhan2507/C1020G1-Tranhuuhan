<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 1/25/2021
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/calculator" method="post">
    <input type="number" name="operaFirst">
    <select name="operator">
      <option>Addition</option>
      <option>Subtraction</option>
      <option>Multiplication</option>
      <option>Division</option>
    </select>
    <input type="number" name="operaSecond">
    <input type="submit" value="Enter">
  </form>
  <p><%= request.getAttribute("result")%></p>
  </body>
</html>
