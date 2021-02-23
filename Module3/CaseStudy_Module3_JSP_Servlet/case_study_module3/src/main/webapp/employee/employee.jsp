<%--
  Created by IntelliJ IDEA.
  User: DELL PC
  Date: 2/1/2021
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Furama Resort</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<style>
    .nav-link {
        margin-left: 50px;
    }

    .image1 {
        width: 50px;
        height: 50px;
    }

    .nav-link:hover {
        background-color: white;
    }

    a {
        color: white;
    }

    .col-10 {
        padding: 0;
        margin: 0;
    }

    button:hover {
        background-color: lightblue;
        text-decoration: none;
    }
</style>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <img class="image1" src="../image/furama.jpg" style="margin-left: 40px">
    <h4 style="margin-left: 1200px; color: green;font-family: 'Agency FB'">C1020G1</h4>
</nav>
<nav class="navbar navbar-expand-lg " style="background-color: black">
    <a class="navbar-brand" href="#" style="margin-left: 150px">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/employeeServlet"> Employee <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/customerServlet">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="/serviceServlet" tabindex="-1" aria-disabled="true">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="/contractServlet" tabindex="-1" aria-disabled="true">Contract</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" style="margin-right: 150px">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                   style="border-radius: 20px; width: 240px">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-2">
            <div class="text" style="padding-top: 50px">
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"
                        data-whatever="@mdo">Create New Employee
                </button>
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form method="post" action="/employeeServlet">
                                <div class="form-row">
                                    <div class="form-group">
                                        <input type="hidden" value="1" name="id">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputName">Name</label>
                                        <input type="text" class="form-control" id="inputName" name="name">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputBirthday">Birth Day</label>
                                        <input type="text" class="form-control" id="inputBirthday" name="birthday">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputCardId">Card Id</label>
                                        <input type="text" class="form-control" id="inputCardId" name="cardId">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputSalary">Salary</label>
                                        <input type="text" class="form-control" id="inputSalary" name="salary">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputPhone">Phone</label>
                                        <input type="text" class="form-control" id="inputPhone" name="phone">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputEmail">Email</label>
                                        <input type="text" class="form-control" id="inputEmail" name="email">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputAddress">Address</label>
                                        <input type="text" class="form-control" id="inputAddress" name="address">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputPositionId">Position Id</label>
                                        <input type="text" class="form-control" id="inputPositionId" name="position">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputEducationDegreeId">Education Id</label>
                                        <input type="text" class="form-control" id="inputEducationDegreeId"
                                               name="education">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputDivisionId">Division Id</label>
                                        <input type="text" class="form-control" id="inputDivisionId" name="division">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputUserName">User name</label>
                                        <input type="text" class="form-control" id="inputUserName" name="user">
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary" name="action" value="create">Submit
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                </a>
            </div>
            <div style="padding-top: 30px">
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal1"
                >
                    Delete All Customer
                </button>
                <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel2" style="color: red">Notification</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body" style="color: blue">
                                Are you sure ?
                            </div>
                            <div class="modal-footer">
                                <button type="button" data-dismiss="modal">No</button>
                                <a href="/employeeServlet?action=deleteAll&id=${users.id}" style="color: black">
                                    <button type="button" class="btn btn-primary">
                                        Yes
                                    </button>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="col-10">
            <table class="table table-dark">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Birthday</th>
                    <th scope="col">Card ID</th>
                    <th scope="col">Salary</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Email</th>
                    <th scope="col">Address</th>
                    <th scope="col" colspan="2">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="employee" items="${listEmployee}">
                    <tr>
                        <td><c:out value="${employee.employeeId}"/></td>
                        <td><c:out value="${employee.employeeName}"/></td>
                        <td><c:out value="${employee.employeeBirthDay}"/></td>
                        <td><c:out value="${employee.employeeIdCard}"/></td>
                        <td><c:out value="${employee.employeeSalary}"/></td>
                        <td><c:out value="${employee.employeePhone}"/></td>
                        <td><c:out value="${employee.employeeEmail}"/></td>
                        <td><c:out value="${employee.employeeAddress}"/></td>
                        <td><a href="/employeeServlet?action=update&id=${employee.employeeId}">
                            <button type="button" class="btn btn-primary">Edit</button>
                        </a></td>
                        <td>
                            <button type="button" class="btn btn-primary" data-toggle="modal"
                                    data-target="#exampleModal1">
                                Delete
                            </button>
                            <div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel1" style="color: red">
                                                Notification</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body" style="color: blue">
                                            Are you sure ?
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">No
                                            </button>
                                            <a href="/employeeServlet?action=delete&id=${employee.employeeId}"
                                               style="color: black">
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
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="col-12">

    </div>
</div>
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
