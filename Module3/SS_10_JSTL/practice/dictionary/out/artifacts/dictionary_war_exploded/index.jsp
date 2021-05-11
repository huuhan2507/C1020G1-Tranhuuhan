<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 1/25/2021
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Simple Dictionary</title>
</head>
<body>
<form method="post" action="/index">
  <input name="search" type="text" placeholder="Seacrh...">
  <input type="submit" value="Enter">
</form>
<%!
  Map<String, String> dic = new HashMap<>();
%>
<%
  dic.put("hello", "Xin chào");
  dic.put("how", "Thế nào");
  dic.put("book", "Quyển vở");
  dic.put("computer", "Máy tính");
  String search = request.getParameter("search");
  String result = dic.get(search);
  String resultSearch;
  if (result != null) {
    resultSearch = "Word: "+search+"\n"+"Result"+result;
  } else {
    resultSearch = "Not found";
  }
%>
<p><%= resultSearch %></p>
</body>
</html>
