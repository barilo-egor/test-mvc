<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Сохранение квеста</title>
  <style><%@include file="/WEB-INF/pages/css/style.css"%></style>
</head>
<body class="center">
<jsp:include page="/WEB-INF/pages/headers/questHeader.jsp"/>
<h2>Информация о квесте</h2>
<table border="1" style="display: inline-block;">
  <tr>
    <td>ID</td>
    <td>${id}</td>
  </tr>
  <tr>
  <tr>
    <td>Название</td>
    <td>${name}</td>
  </tr>
  <tr>
      <td>Тип квеста</td>
      <td>${questType}</td>
  </tr>
  <tr>
      <td>Нпс</td>
      <td>${npc}</td>
    </tr>
</table>
</body>
</html>