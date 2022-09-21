<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Квесты</title>
    <style><%@include file="/WEB-INF/pages/css/style.css"%></style>
</head>
<body class="center">
<header><a href="/test-mvc/jsp/entities.form">Главная</a></header>
    <h2>Квесты</h2>
    <table border="1" style="display: inline-block;">
        <tr>
            <th>ID</th>
            <th>Название</th>
            <th>Тип квеста</th>
            <th>Нпс</th>
        </tr>
        <c:forEach var="quest" items="${quests}">
        <tr>
            <td>${quest.id}</td>
            <td>${quest.name}</td>
            <td>${quest.questType.displayName}</td>
            <td>${quest.nonPlayerCharacter.name}</td>
            <td><a href="${quest.id}/edit.form">Изменить</a></td>
            <td><a href="${quest.id}/delete.form">Удалить</a></td>
        </tr>
        </c:forEach>
    </table>
    <div><a href="add.form">Добавить новый квест</a></div>
</body>
</html>