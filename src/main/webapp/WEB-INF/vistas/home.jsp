<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">
    <title>Buscando Rival</title>
</head>
<body>
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark px-5">
        <a class="navbar-brand" href="home">Buscando Rival</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="home">Inicio</a>
                </li>
                
                <c:set var="equipoBoolean" value="${tieneEquipo}"/>
                <c:if test="${equipoBoolean == true}">
                	<li class="nav-item">
                    	<a class="nav-link" href="buscandoRival">Buscar Rival</a>
                	</li>
                </c:if>
                <c:if test="${equipoBoolean == true}">
                	<li class="nav-item">
                    	<a class="nav-link" href="miEquipo">Mi Equipo</a>
               		</li>
                </c:if>
                <c:if test="${equipoBoolean == false}">
                	<li class="nav-item">
                    	<a class="nav-link" href="crearEquipo">Crear Equipo</a>
                	</li>
                </c:if>
                <c:if test="${equipoBoolean == true}">
                	<li class="nav-item">
                    	<a class="nav-link" href="misPartidos">Mis Partidos</a>
                	</li>
                </c:if>
                
                <li class="nav-item">
                    <a class="nav-link" href="login">Salir</a>
                </li>
            </ul>
        </div>
   	</nav>
   	
   	<div class="row mt-5">
   		<div class ="col-md-3"></div>
   		<div class ="col-md-6 text-center"><h4>¡Bienvenido ${usuario.nombreUsuario}, disfruta de nuestra aplicación!</h4></div>
   		<div class ="col-md-3"></div>
   	</div>
   	
	<script src="js/jquery-3.4.1.min.js"></script>
   	<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>