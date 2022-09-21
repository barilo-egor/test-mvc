<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Редактирование нпс</title>
  <style><%@include file="/WEB-INF/pages/css/style.css"%></style>
</head>
<body class="center">
<jsp:include page="/WEB-INF/pages/headers/npcHeader.jsp"/>
<h2>Введите информацию о нпс</h2>
<form:form method="post" action="/test-mvc/jsp/entities/npc/save.form" modelAttribute="npcForm">
  <table border="1" style="display: inline-block;">
    <tr>
          <td><form:input path="id" type="hidden"/></td>
    </tr>
    <tr>
      <td><form:label path="name">Имя</form:label></td>
      <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="eliteStatus">Элита</form:label></td>
        <td>
            <form:select path="eliteStatus">
                <option value="true" ${npcForm.eliteStatus == true ? 'selected="selected"' : ''}>Да</option>
                <option value="false" ${npcForm.eliteStatus == false ? 'selected="selected"' : ''}>Нет</option>
            </form:select>
        </td>
    </tr>
    <tr>
              <td><form:label path="fraction">Фракциия</form:label></td>
              <td>
                <form:select path="fraction">
                    <form:options items="${fractions}" itemValue="name" itemLabel="displayName"/>
                </form:select>
              </td>
    </tr>
    <tr>
                  <td><form:label path="locationId">Локация</form:label></td>
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