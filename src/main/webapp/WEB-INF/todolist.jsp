<%--
  Created by IntelliJ IDEA.
  User: kajam
  Date: 7/17/2026
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Todo List</title>
</head>

<body>

<h1>Todo List</h1>

<!-- Add Todo Form and Search Form -->
<form action="add-todo" method="post">

    <input type="text"
           name="task"
           placeholder="Enter a task">

    <button type="submit">
        Add Todo
    </button>

</form>

<form action="search" method="get">

    <input type="text" name="task">

    <button type="submit">
        Search
    </button>

</form>


<h2>Your Todos:</h2>

<p>Number of results: ${todos.size()}</p>

<!-- Display Todos -->
<c:forEach var="todo" items="${todos}">

    <p>
            ${todo.task}

        <a href="delete-todo?id=${todo.id}">
            Delete
        </a>
    </p>

</c:forEach>


</body>
</html>
