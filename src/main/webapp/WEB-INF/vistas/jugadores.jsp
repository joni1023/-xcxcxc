<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>lista de jugadores</title>
</head>
<body>
<h1>lista de jugadores y su valoracion</h1>
<h3>Arquero</h3>
<c:forEach items="${lista}" var="lista">
<p>nombre: ${lista.nombre}, edad: ${lista.edad}, peso:${lista.peso}, altura: ${lista.altura}, valoracion ${lista.valoracion } , tipo ${lista.DTYPE }</p>
</c:forEach> 
</body>
</html>