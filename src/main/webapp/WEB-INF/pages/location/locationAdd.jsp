<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Добавление локации</title>
  <style><%@include file="/WEB-INF/pages/css/style.css"%></style>
</head>
<body class="center">
<jsp:include page="/WEB-INF/pages/headers/locationHeader.jsp"/>
<h2>Введите информацию о локации</h2>
<form:form method="post" action="save.form" modelAttribute="locationForm">
  <table border="1" style="display: inline-block;">
    <tr>
      <td><form:label path="name">Название</form:label></td>
      <td><form:input path="name" /></td>
    </tr>
    <tr>
          <td><form:label path="mainland">Континет</form:label></td>
          <td>
          <form:select path="mainland">
              <form:options items="${mainlands}" itemValue="name" itemLabel="displayName" />
          </form:select>
          </td>
    </tr>
    <tr>
          <td><form:label path="introductionDate">Дата введения</form:label></td>
          <td><form:input type="date" path="introductionDate" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Submit"/>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>