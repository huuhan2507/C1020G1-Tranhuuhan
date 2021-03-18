<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 1/27/2021
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/userServlet?actionUser=null">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"
                        data-whatever="@mdo">Create user</button>
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form method="post" action="/userServlet">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">CREATE USER</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <input type="hidden" value="1" name="id">
                                    </div>
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Name User</label>
                                        <input type="text" name="name" class="form-control" id="recipient-name">
                                    </div>
                                    <div class="form-group">
                                        <label for="recipient-email" class="col-form-label">Email User</label>
                                        <input type="text" name="email" class="form-control" id="recipient-email">
                                    </div>
                                    <div class="form-group">
                                        <label for="recipient-country" class="col-form-label">Country</label>
                                        <input type="text" name="country" class="form-control" id="recipient-country">
                                    </div>
                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary" name="action" value="create">Submit</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <a class="btn btn-primary" href="/userServlet?actionUser=sort" role="button" style="margin-left: 30px">
                    Sort Name User
                </a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="/userServlet">
            <input type="hidden" name="actionUser" value="search">
            <input class="form-control mr-sm-2" type="text" name="country" placeholder="Search" value="${country}" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Country</th>
        <th scope="col" colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="users" items="${list_users}">
        <tr>
            <td><c:out value="${users.id}"/></td>
            <td><c:out value="${users.name}"/></td>
            <td><c:out value="${users.email}"/></td>
            <td><c:out value="${users.country}"/></td>
            <td>
                <a href="/userServlet?actionUser=update&id=${users.id}">
                    <button type="button" class="btn btn-primary">Edit</button>
                </a>
            <td>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal1">
                    Delete
                </button>
                <div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel1" style="color: red">Notification</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body" style="color: blue">
                                Are you sure ?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                                <a href="/userServlet?actionUser=delete&id=${users.id}" style="color: black">
                                    <button type="button" class="btn btn-primary">
                                        Yes
                                    </button>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
        integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
        crossorigin="anonymous"></script>
</html>
