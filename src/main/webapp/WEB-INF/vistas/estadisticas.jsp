<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
                <c:if test="${esAdmin == true}">
                	<li class="nav-item">
                    <a class="nav-link" href="valoraciones">Valoraciones</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cargarPartidos">Cargar Partidos</a>
                </li>
               </c:if>
               <c:if test="${esAdmin == false}">
               		<c:if test="${tieneEquipo == true}">
		                <li class="nav-item">
		                    <a class="nav-link" href="buscandoRival">Buscar Rival</a>
		                </li>
		                <li class="nav-item">
		                   	<a class="nav-link" href="miEquipo">Mi Equipo</a>
		            	</li>
		               	<li class="nav-item">
		                   	<a class="nav-link" href="misPartidos">Mis Partidos</a>
		               	</li>
		             </c:if>
		             <c:if test="${tieneEquipo == false}">
                		<li class="nav-item">
                    		<a class="nav-link" href="crearEquipo">Crear Equipo</a>
                		</li>
                	</c:if>
               	</c:if>
               	<li class="nav-item">
               	<a class="nav-link" href="estadistcas">Estadisticas</a>
               	</li>
                <li class="nav-item">
                    <a class="nav-link" href="login">Salir</a>
                </li>
            </ul>
        </div>
   	</nav>

	<div class="container-fluid">
		<div class="text-center my-5">
			<h2>Estadisticas de Equipos</h2>
		</div>

		<div class="row mt-5">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<table class="table table-bordered text-center">
					<thead>
						<tr>
							<th scope="col">Nombre</th>
							<th scope="col">PJ</th>
							<th scope="col">PG</th>
							<th scope="col">PE</th>
							<th scope="col">PP</th>
							<th scope="col">Valoracion</th>
							<th scope="col">Jugadores</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${equipos}" var="equipo">
							<tr>
							<td>${equipo.nombre}</td>
							<td>${equipo.partidosJugados}</td>
							<td>${equipo.partidosGanados}</td>
							<td>${equipo.partidosEmpatados}</td>
							<td>${equipo.partidosPerdidos}</td>
							<td>${equipo.valoracion}</td>
							<td><form action="estadisticasJugadores" method="POST">
								<input type="hidden" name="idEquipo" value="${equipo.id}" id="id">
								<button class="btn btn-lg btn-primary font-weight-bold mb-2" type="submit">Ver Jugadores</button>
								</form>
							</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
	
	<script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>