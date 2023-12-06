<%--
  Created by IntelliJ IDEA.
  User: daonhuanh
  Date: 07/12/2023
  Time: 01:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/students?act=create">Add new Student</a>
<form action="/students">
    <input type="text" name="key">
    <button>Search</button>
</form>
<c:forEach items="${ds}" var="st">
    <h3>${st.name}, ${st.score} <a href="/students?act=edit&id=${st.id}">Edit</a></h3>
</c:forEach>
</body>
</html>
