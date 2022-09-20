<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Сохранение локации</title>
  <style><%@include file="/WEB-INF/pages/css/style.css"%></style>
</head>
<body class="center">
<jsp:include page="/WEB-INF/pages/headers/locationHeader.jsp"/>
<h2>Информация о локации</h2>
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
    <td>Континет</td>
    <td>${mainlandName}</td>
  </tr>
  <tr>
      <td>Дата введения</td>
      <td>${introductionDate}</td>
  </tr>
</table>
</body>
</html>