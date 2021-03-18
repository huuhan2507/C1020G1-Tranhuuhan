<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 2/4/2021
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<nav class="navbar" style="background-color: lightblue">
    <h1 style=" color: black;font-family: 'Agency FB'">Danh Sách Sản Phẩm</h1>
</nav>
<a href="themsanpham.jsp"
   style="color: black">
    <button type="button" class="btn btn-primary">
        Thêm mới
    </button>
</a>
<form>
    <a> Danh sách top</a>
    <select>
        <option>3</option>
        <option>5</option>
        <option>10</option>
    </select>
    <a>Sản phẩm được đặt hàng nhiều nhất:</a>
    <a href="#">
        <button type="submit" class="btn btn-primary" name="" > Xem</button>
    </a>
</form>
<form action="/sanPhamServlet">
    <a>Danh sách đặt hàng từ:</a>
    <input type="date" name="startdate">
    <a>đến:</a>
    <input type="date" name="#">
    <button type="submit" class="btn btn-primary" value="">Xem</button>
</form>
<div class="container-fluid">
    <div class="row">
        <table class="table table-dark" id="tableEmployee">
            <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Tên</th>
                <th scope="col">Giá</th>
                <th scope="col">Mức Giảm Giá</th>
                <th scope="col">Số Lượng</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="sanPham" items="${danhSachSanPham}">
            <tr>
                <td><c:out value="${sanPham.idSanPham}"/></td>
                <td><c:out value="${sanPham.tenSanPham}"/></td>
                <td><c:out value="${sanPham.giaSanPham}"/></td>
                <td><c:out value="${sanPham.mucGiamGia}"/></td>
                <td><c:out value="${sanPham.tonKho}"/></td>
            </tr>
             </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</div>


</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
</html>
