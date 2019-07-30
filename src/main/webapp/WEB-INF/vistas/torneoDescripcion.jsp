<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <a class="navbar-brand" href="homeAdmin">Buscando Rival</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
            	<li class="nav-item">
                    <a class="nav-link" href="homeAdmin">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="valoraciones">Valoraciones</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cargarPartidos">Cargar Partidos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="estadisticas">Estadísticas</a>
                </li>
                <li class="nav-item">
                	<a class="nav-link" href="torneos">Torneos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login">Salir</a>
                </li>
            </ul>
        </div>
   	</nav>
   	<p>${torneo.nombre}</p>
   	
   	<div id="equipos" class= "col-md-3">
			<div class="card text-white bg-success mb-3" style="max-width: 18rem;">
  				<div class="card-header">Cuartos de final</div>
  					<div class="card-body">
  						<c:if test="${equipos.size() == 8}">
  							${equipos.get(0).nombre} vs ${equipos.get(7).nombre}
  							<form action="datosPartido" method="POST" class="text-center">
							<input type="hidden" name="idPartido" id="idPartido" value="${partido1.id}">
							<button class="btn btn-lg btn-primary font-weight-bold my-2" type="submit">Cargar Datos</button>
						</form>
  						</c:if>  						
						<c:if test="${equipos.size() < 8}">
							<p>No hay equipos disponibles.</p>
						</c:if>
 				 	</div>
			</div>   			
	</div>
	<div id="equipos" class= "col-md-3">
			<div class="card text-white bg-success mb-3" style="max-width: 18rem;">
  				<div class="card-header">Cuartos de final</div>
  					<div class="card-body">
  						<c:if test="${equipos.size() >= 7}">
  							${equipos.get(1).nombre} vs ${equipos.get(6).nombre}
  							<form action="datosPartido" method="POST" class="text-center">
							<input type="hidden" name="idPartido" id="idPartido" value="${partido2.id}">
							<button class="btn btn-lg btn-primary font-weight-bold my-2" type="submit">Cargar Datos</button>
						</form>
  						</c:if>  						
						<c:if test="${equipos.size() < 7}">
							<p>No hay equipos disponibles.</p>
						</c:if>
 				 	</div>
			</div>   		
	</div>
	<div id="equipos" class= "col-md-3">
			<div class="card text-white bg-success mb-3" style="max-width: 18rem;">
  				<div class="card-header">Cuartos de final</div>
  					<div class="card-body">
  						<c:if test="${equipos.size() >= 6}">
  							${equipos.get(2).nombre} vs ${equipos.get(5).nombre}
  							<form action="datosPartido" method="POST" class="text-center">
							<input type="hidden" name="idPartido" id="idPartido" value="${partido3.id}">
							<button class="btn btn-lg btn-primary font-weight-bold my-2" type="submit">Cargar Datos</button>
						</form>
  						</c:if>  						
						<c:if test="${equipos.size() < 6}">
							<p>No hay equipos disponibles.</p>
						</c:if>
 				 	</div>
			</div>  		
	</div>
   <div id="equipos" class= "col-md-3">
			<div class="card text-white bg-success mb-3" style="max-width: 18rem;">
  				<div class="card-header">Cuartos de final</div>
  					<div class="card-body">
  						<c:if test="${equipos.size() >= 5}">
  							${equipos.get(3).nombre} vs ${equipos.get(4).nombre}
  							<form action="datosPartido" method="POST" class="text-center">
							<input type="hidden" name="idPartido" id="idPartido" value="${partido4.id}">
							<button class="btn btn-lg btn-primary font-weight-bold my-2" type="submit">Cargar Datos</button>
						</form>
  						</c:if>  						
						<c:if test="${equipos.size() < 5}">
							<p>No hay equipos disponibles.</p>
						</c:if>
 				 	</div>
			</div>   		
	</div>
</body>
</html>