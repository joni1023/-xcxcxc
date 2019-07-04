<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Valoracion de Equipos</title>
</head>
<body>

	<h1>Valoracion de Equipos</h1>
	<c:forEach items="${equipos }" var="equipo">
		<p>El equipo ${equipo.nombre} tiene una valoración de: ${equipo.valoracion} </p>
	</c:forEach>
</body>
</html>