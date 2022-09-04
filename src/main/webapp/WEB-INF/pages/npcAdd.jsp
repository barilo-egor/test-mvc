<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Добавление нпс</title>
  <style><%@include file="css/style.css"%></style>
</head>
<body class="center">
<jsp:include page="headers/npcHeader.jsp"/>
<h2>Введите информацию о нпс</h2>
<form:form method="post" action="save.form" modelAttribute="npcForm">
  <table border="1" style="display: inline-block;">
    <tr>
      <td><form:label path="name">имя</form:label></td>
      <td><form:input path="name" /></td>
    </tr>
    <tr>
              <td><form:label path="eliteStatus">элита</form:label></td>
              <td>
              <form:select path="eliteStatus">
                  <option value="true">да</option>
                  <option value="false">нет</option>
              </form:select>
              </td>
    </tr>
    <tr>
              <td><form:label path="fraction">фракциия</form:label></td>
              <td>
              <form:select path="fraction">
                  <form:options items="${fractions}" itemValue="name" itemLabel="displayName"/>
              </form:select>
              </td>
    </tr>
     <tr>
                  <td><form:label path="locationId">локация</form:label></td>
                  <td>
                  <form:select path="locationId">
                      <form:options items="${locations}" itemValue="id" itemLabel="name"/>
                  </form:select>
                  </td>
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