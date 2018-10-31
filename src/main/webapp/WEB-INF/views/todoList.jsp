<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <title>todo list</title>
</head>
<body>
  <jsp:include page="todoForm.jsp" />
  <hr>
  <table>
    <tr><th>id</th><th>task</th><th>assignee</th><th>DELETE</th></tr>
 
    <c:forEach items="${todos}" var="todo">
    <tr><td>${todo.id}</td><td>${todo.task}</td><td>${todo.assignee}</td><td><a href="delete/${todo.id}">delete</a></tr>
    </c:forEach>  

  </table>
</body>
</html>

