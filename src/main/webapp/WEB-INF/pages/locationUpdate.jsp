<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Обновление локации</title>
  <style><%@include file="css/style.css"%></style>
</head>
<body class="center">
<jsp:include page="headers/locationHeader.jsp"/>
<h2>Информация о локации</h2>
<table border="1" style="display: inline-block;">
  <tr>
    <td>id</td>
    <td>${id}</td>
  </tr>
  <tr>
  <tr>
    <td>название</td>
    <td>${name}</td>
  </tr>
  <tr>
    <td>континет</td>
    <td>${mainlandName}</td>
  </tr>
</table>
</body>
</html>