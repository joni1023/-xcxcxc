
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body class="container">
<h2>Busca tu rival</h2>
<h5>El Sistema Calculara el Mejor Rival PARA TI!</h5>
<div class="row">
	<div id="miEquipo" class="col-lg-5">
	<p>mi equipo</p>
	<br>
	<h2>${miEquipo.nombre}</h2>
	<c:forEach items="${jugadores1}" var="jugador"> 
	<p>${jugador.nombre}</p>
	</c:forEach>
	</div>
	
	<div class="col-lg-2">
	<form:form action="buscandoRival" method="POST" modelAttribute="equipo">
	<form:input path="id" id="id" type="text" class="form-control" value="${miEquipo.id}" />
	<button class="btn btn-primary" type="submit">Buscar Rival</button>
	</form:form>
	</div>
	
	<div id="rival" class="col-lg-5">
	<c:if test="${not empty rival.nombre}">
	<p>equipo rival</p>
	<br>
	<h2>${rival.nombre}</h2>
	<c:forEach items="${jugadores2}" var="jugador"> 
	<p>${jugador.nombre}</p>
	</c:forEach>
	</c:if>
	<c:if test="${empty rival }"><p>no hay equipos disponibles</p></c:if>
	</div>

</div>



</body>
</html>