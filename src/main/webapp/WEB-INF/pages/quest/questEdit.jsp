<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Редактирование квеста</title>
  <style><%@include file="/WEB-INF/pages/css/style.css"%></style>
</head>
<body class="center">
<jsp:include page="/WEB-INF/pages/headers/questHeader.jsp"/>
<h2>Введите информацию о квесте</h2>
<form:form method="post" action="/test-mvc/jsp/entities/quest/save.form" modelAttribute="questForm">
  <table border="1" style="display: inline-block;">
    <tr>
          <td><form:input path="id" type="hidden"/></td>
    </tr>
    <tr>
      <td><form:label path="name">Название</form:label></td>
      <td><form:input path="name" /></td>
    </tr>
    <tr>
              <td><form:label path="questType">Тип квеста</form:label></td>
              <td>
                <form:select path="questType">
                    <form:options items="${questTypes}" itemValue="name" itemLabel="displayName"/>
                </form:select>
              </td>
    </tr>
    <tr>
                  <td><form:label path="npcId">Нпс</form:label></td>
                  <td>
                  <form:select path="npcId">
                      <form:options items="${nonPlayerCharacters}" itemValue="id" itemLabel="name"/>
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