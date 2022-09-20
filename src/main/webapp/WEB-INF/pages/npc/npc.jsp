<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>НПС</title>
<style><%@include file="/WEB-INF/pages/css/style.css"%></style>
</head>
<body class="center">
<header><a href="/test-mvc/jsp/entities.form">Главная</a></header>
<h2>НПС</h2>
<table border="1" style="display: inline-block;">
    <tr>
        <th>id</th>
        <th>имя</th>
        <th>элита</th>
        <th>фракция</th>
        <th>локация</th>
    </tr>
    <c:forEach var="npc" items="${nonPlayerCharacters}">
        <tr>
            <td>${npc.id}</td>
            <td>${npc.name}</td>
            <td>${npc.eliteStatus ? "Да" : "Нет"}</td>
            <td>${npc.fraction.displayName}</td>
            <td>${npc.location.name}</td>
            <td><a href="${npc.id}/edit.form">Изменить</a></td>
            <td><a href="${npc.id}/delete.form">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
<div><a href="add.form">Добавить нового нпс</a></div>
</body>
</html>