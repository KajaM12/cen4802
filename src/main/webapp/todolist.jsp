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

<h1>My Hibernate Todo List - Docker v7</h1>

<p> This application was rebuilt using Maven for Assignment 5.</p>

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
<p>Completed: ${summary.completedCount} | Incomplete: ${summary.incompleteCount}</p>

<!-- Display Todos -->
<c:forEach var="todo" items="${todos}">

    <p>

        <c:choose>

            <c:when test="${todo.completed}">
                <s>${todo.task}</s>
                <strong>Completed</strong>
            </c:when>

            <c:otherwise>
                ${todo.task}

                <a href="complete-todo?id=${todo.id}">
                    Complete
                </a>
            </c:otherwise>

        </c:choose>

        <a href="delete-todo?id=${todo.id}">
            Delete
        </a>

    </p>

</c:forEach>


</body>
</html>
