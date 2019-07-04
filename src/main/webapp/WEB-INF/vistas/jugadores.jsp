<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Lista de jugadores</title>
</head>
<body>

	<h1>Lista de jugadores y su valoración</h1>
	
	<c:forEach items="${lista}" var="lista">
		<p>Nombre: ${lista.nombre}, Edad: ${lista.edad}, Peso: ${lista.peso}, Altura: ${lista.altura}, Valoración: ${lista.valoracion}, Posición: ${lista.posicion}</p>
	</c:forEach>
	
</body>
</html>