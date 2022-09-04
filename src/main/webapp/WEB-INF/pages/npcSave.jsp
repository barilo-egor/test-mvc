<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Сохранение нпс</title>
  <style><%@include file="css/style.css"%></style>
</head>
<body class="center">
<jsp:include page="headers/npcHeader.jsp"/>
<h2>Информация о нпс</h2>
<table border="1" style="display: inline-block;">
  <tr>
    <td>id</td>
    <td>${id}</td>
  </tr>
  <tr>
  <tr>
    <td>имя</td>
    <td>${name}</td>
  </tr>
  <tr>
    <td>элита</td>
    <td>${eliteStatus}</td>
  </tr>
  <tr>
      <td>фракциия</td>
      <td>${fraction}</td>
  </tr>
  <tr>
      <td>локация</td>
      <td>${location}</td>
    </tr>
</table>
</body>
</html>