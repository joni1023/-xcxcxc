<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                    	<a class="nav-link" href="miEquipo">Mi Equipo</a>
               		</li>
                </c:if>
                <c:if test="${equipoBoolean == false}">
                	<li class="nav-item">
                    	<a class="nav-link" href="crearEquipo">Crear Equipo</a>
                	</li>
                </c:if>

                <li class="nav-item">
                    <a class="nav-link" href="buscandoRival">Buscar Rival</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="miEquipo">Mi Equipo</a>
                </li>
                <li class="nav-item">
                   	<a class="nav-link" href="misPartidos">Mis Partidos</a>
               	</li>
               	<li class="nav-item">
                    <a class="nav-link" href="estadisticas">Estadísticas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login">Salir</a>
                </li>
            </ul>
        </div>
   	</nav>
	
	<div class="container-fluid">
		<div class="text-center my-5">
			<h2>Busca tu rival</h2>
			<h5>¡EL SISTEMA CALCULARÁ EL MEJOR RIVAL PARA TI!</h5>
		</div>
		<div class="row text-center">
			<div class="col-md-2">
			</div>
			<div id="miEquipo" class="col-md-3">
				<h3>Mi equipo</h3>
		    	<div class="card">
		    		<div class="card-header">
		    			<h5>${miEquipo.nombre}</h5>
		    			<h6>Valoracion promedio: ${miEquipo.valoracion}</h6>
		    		</div>
		      		<div class="card-body">
		        		<p class="card-text">
		        			<c:forEach items="${jugadores1}" var="jugador"> 
								<p>${jugador.nombre}</p>
							</c:forEach>
						</p>
		      		</div>
		    	</div>
		  	</div>
		  	<div class="col-md-2 my-5">
				<form action="buscandoRival" method="post">
					<input type="hidden" value="${miEquipo.id}" name="id1">
					<input type="hidden" value="${rival.id}" name="id2" >
					<button class="btn btn-lg btn-primary font-weight-bold mb-2" type="submit">Buscar Rival</button>
				</form>
			</div>
		  	<div id="rival" class="col-md-3">
		  		<h3>Equipo rival</h3>
		    	<div class="card">
		    		<c:if test="${not empty rival.nombre}">
		    		<div class="card-header">
		    			<h5>${rival.nombre}</h5>
		    			<h6>Valoracion promedio: ${rival.valoracion}</h6>
		    		</div>
		    		</c:if>
		      		<div class="card-body">
		        		<p class="card-text">
		        			<c:forEach items="${jugadores2}" var="jugador"> 
								<p>${jugador.nombre}</p>
							</c:forEach>
						</p>
						<c:if test="${empty rival}"><p>No hay equipos disponibles.</p></c:if>
		      		</div>
		    	</div>
		  	</div>
		  	<div class="col-md-2">
			</div>
		</div>
		<div class="row text-center">
			<div class="col-md-2">
			</div>
			<div class="col-md-3">
			</div>
			<div class="col-md-2 my-5">
				<c:if test="${not empty rival}">
					<form action="armandoPartido" method="post">
						<input type="hidden" name="local" value="${miEquipo.id}">
						<input type="hidden" name="visitante" value="${rival.id}">
						<button class="btn btn-lg btn-primary font-weight-bold mb-2" type="submit">Crear partido</button>
					</form>
				</c:if>
			</div>
			<div class="col-md-3">
			</div>
			<div class="col-md-2">
			</div>
		</div>
	</div>
	
	<script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>