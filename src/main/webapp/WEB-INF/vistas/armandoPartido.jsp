<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>armando partido</h1>
<p>mi ${equipo1ID }</p>
<p>vs ${equipo2ID } </p>
<%-- <form:form action="crearPartido" method="Post" modelAttribute="partido"> --%>
<%-- <form:input path="equipo1" type="hidden" value="${equipo1}"/> --%>
<%-- <form:input path="equipo2" type="hidden" value="${equipo2}"/> --%>
<%-- <form:input path="fecha" type="date"/> --%>
<%-- <form:button type="submit">confirmar</form:button> --%>
<%-- </form:form> --%>
<form action="crearPartido" method="post">
<input type="text" value="${equipo1ID}" name="equipo1ID">
<input type="text" value="${equipo2ID}" name="equipo2ID">
<select type="datetime-local" name="fecha">
<option value="2019/07/20 08:00">2019/07/20 08:00</option>
  <option value="2019/07/20 11:00">2019/07/20 11:00</option>
  <option value="2019/07/20 14:00">2019/07/20 14:00</option>
  <option value="2019/07/20 17:00">2019/07/20 17:00</option>
</select>
<button type="submit">confirmar</button>

</form>

</body>
</html>