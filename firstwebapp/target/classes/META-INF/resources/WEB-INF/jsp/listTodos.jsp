<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <title>
            To-Do List
        </title>
    </head>
    <body>

        <div class="container">
        Welcome Todo Page ${name}
        <h1>Your TODOs are : </h1>
        <table class="table">
            <thead>
                <tr>
               
                <th>Description</th>
                <th>Target Date</th>
                <th>Status</th>
                <th></th>
                <th></th>
                </tr>
            </thead>
            <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
             
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.status}</td>
                <td><a href= "delete-todo?id=${todo.id}" class="btn-warning">Delete</a></td>
                <td><a href = "update-todo?id=${todo.id}" class="btn-success">Update</a></td>
            </tr>

        </c:forEach>
    </tbody>
    </table>
    <a href="add-todo" class="btn btn-success"> Add TO-DOs</a>
    </div>
    <script src ="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src ="webjars/jquery/3.6.0.jquery.min.js"></script>
    </body>
</html>