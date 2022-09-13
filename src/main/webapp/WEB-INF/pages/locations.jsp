<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Локации</title>
<style><%@include file="css/style.css"%></style>
</head>
<body class="center">
<header><a href="/test-mvc/jsp/entities.form">Главная</a></header>
<h2>Локации</h2>
<table border="1" style="display: inline-block;">
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Континент</th>
        <th>Дата введения</th>
    </tr>
    <c:forEach var="location" items="${locations}">
        <tr>
            <td>${location.id}</td>
            <td>${location.name}</td>
            <td>${location.mainland.displayName}</td>
            <td>${location.introductionDate}</td>
            <td><a href="${location.id}/edit.form">Изменить</a></td>
            <td><a href="${location.id}/delete.form">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
<div><a href="add.form">Добавить новую локацию</a></div>
</body>
</html>