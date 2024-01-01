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
Create
<form action="/students" method="post">
    <input type="hidden" name="act" value="create">
    <input type="text" name="name">
    <input type="text" name="score">
    <button>Save</button>
</form>
</body>
</html>
