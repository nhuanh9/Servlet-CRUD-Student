<%--
  Created by IntelliJ IDEA.
  User: daonhuanh
  Date: 07/12/2023
  Time: 01:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Edit
<form action="/students" method="post">
    <input type="hidden" name="act" value="edit">
    <input type="text" name="id" value="${s.id}">
    <input type="text" name="name" value="${s.name}">
    <input type="text" name="score" value="${s.score}">
    <button>Save</button>
</form>
</body>
</html>
