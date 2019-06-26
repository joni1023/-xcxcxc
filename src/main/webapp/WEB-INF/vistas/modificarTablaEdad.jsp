<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- Bootstrap core CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet" >
	<!-- Bootstrap theme -->
	<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Modificar los valores de la valoracion de la tabla edad</title>
</head>
<body class="container">

	<h1>Modificar los valores de la valoracion de la tabla edad</h1>
	
	<form:form action="modificarEdadTabla" method="POST" modelAttribute="valoracionEdad">
		<form:input path="id" type="text" value="${valorEdad.id}"/>
		<form:input path="menor20" type="text" value="${valorEdad.menor20}"/>
		<form:input path="de20a25" type="text" value="${valorEdad.de20a25}"/>
		<form:input path="de26a30" type="text" value="${valorEdad.de26a30}"/>
		<form:input path="de31a35" type="text" value="${valorEdad.de31a35}"/>
		<form:input path="mayor35" type="text" value="${valorEdad.mayor35}"/>
		
		<button type="submit" class="btn btn-primar">Modificar</button>
	</form:form>
	
</body>
</html>