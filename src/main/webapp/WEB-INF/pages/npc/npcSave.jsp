<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Сохранение нпс</title>
  <style><%@include file="/WEB-INF/pages/css/style.css"%></style>
</head>
<body class="center">
<jsp:include page="/WEB-INF/pages/headers/npcHeader.jsp"/>
<h2>Информация о нпс</h2>
<table border="1" style="display: inline-block;">
  <tr>
    <td>ID</td>
    <td>${id}</td>
  </tr>
  <tr>
  <tr>
    <td>Имя</td>
    <td>${name}</td>
  </tr>
  <tr>
    <td>Элита</td>
    <td>${eliteStatus ? "Да" : "Нет"}</td>
  </tr>
  <tr>
      <td>Фракциия</td>
      <td>${fraction}</td>
  </tr>
  <tr>
      <td>Локация</td>
      <td>${location}</td>
    </tr>
</table>
</body>
</html>