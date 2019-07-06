<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<title>Modificar los valores de la valoración de la tabla Altura</title>
</head>
<body >

	<h1>Modificar los valores de la valoración de la tabla Altura</h1>
	<table class="table table-bordered text-center">
		<thead >
		    <tr>
		     <th scope="col">Menor de 150cm</th>
		      <th scope="col">150 a 160cm</th>
		      <th scope="col">160 a 170cm</th>
		      <th scope="col">170 a 180cm</th>
		      <th scope="col">180 a 190cm</th>
		      <th scope="col">Mayor de 190cm</th>
		    </tr>
		</thead>
		<tbody>
		    <tr>
		<form:form action="modificarAlturaT" method="POST" modelAttribute="valoracionAltura">
		<form:input path="id" type="hidden" value="${valorAltura.id}" />
		<th scope="col"><form:input path="menor150cm" type="text" value="${valorAltura.menor150cm}"/> </th>
		<th scope="col"><form:input path="entre150y160cm" type="text" value="${valorAltura.entre150y160cm}"/> </th>
		<th scope="col"><form:input path="entre160y170cm" type="text" value="${valorAltura.entre160y170cm}"/> </th>
		<th scope="col"><form:input path="entre170y180cm" type="text" value="${valorAltura.entre170y180cm}"/> </th>
		<th scope="col"><form:input path="entre180y190cm" type="text" value="${valorAltura.entre180y190cm}"/> </th>
		<th scope="col"><form:input path="mayor190cm" type="text" value="${valorAltura.mayor190cm}"/> </th>	
		 	</tr>
		</tbody>
		</table>
		<button type="submit" class="btn btn-info">Guardar cambios</button>
		</form:form>
	
	
</body>
</html>