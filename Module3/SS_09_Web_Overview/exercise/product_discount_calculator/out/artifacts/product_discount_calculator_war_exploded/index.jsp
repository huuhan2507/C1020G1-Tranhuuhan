<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 1/22/2021
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/product" method="post">
    <input type="text" placeholder="product name ..." name="name"><br><br>
    <input type="number" placeholder="Price.." name="price"><br><br>
    <input type="number" placeholder="discount percent.." name="percent"><br><br>
    <p>Discount amount: <%= request.getAttribute("discount_amount")%></p>
    <p>Discount price: <%= request.getAttribute("discount_price")%></p>
    <input type="submit" value="Enter">
  </form>
  </body>
</html>
