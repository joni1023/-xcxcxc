<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">
<title>Buscando Rival</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark px-5">
        <a class="navbar-brand" href="#!">Buscando Rival</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <c:if test="${esAdmin == true}">
                <li class="nav-item">
                    <a class="nav-link" href="homeAdmin">Inicio</a>
                </li>
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
                    		<a class="nav-link" href="home">Inicio</a>
                		</li>
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
               		<a class="nav-link" href="estadisticas">Estadísticas</a>
               	</li>
                <li class="nav-item">
                    <a class="nav-link" href="login">Salir</a>
                </li>
            </ul>
        </div>
   	</nav>

												
								<form action="registrarTorneo2" method="post">
									<input type="hidden" name="torneoID" value="${torneoID}">
									<p>Cuartos de final (partido 1)</p>
									<select name="equipo1">
										<c:forEach items="${equipos}" var="equipo">
											<option value="equipo">${equipo.nombre}</option>
										</c:forEach>
									</select>
									<h3>vs.</h3>
									<select name="equipo8">
										<c:forEach items="${equipos}" var="equipo">
											<option value="equipo">${equipo.nombre}</option>
										</c:forEach>
									</select>
									
									<p>Cuartos de final (partido 2)</p>
									<select name="equipo2">
										<c:forEach items="${equipos}" var="equipo">
											<option value="equipo">${equipo.nombre}</option>
										</c:forEach>
									</select>
									<h3>vs.</h3>
									<select name="equipo7">
										<c:forEach items="${equipos}" var="equipo">
											<option value="equipo">${equipo.nombre}</option>
										</c:forEach>
									</select>
									
									<p>Cuartos de final (partido 3)</p>
									<select name="equipo3">
										<c:forEach items="${equipos}" var="equipo">
											<option value="equipo">${equipo.nombre}</option>
										</c:forEach>
									</select>
									<h3>vs.</h3>
									<select name="equipo6">
										<c:forEach items="${equipos}" var="equipo">
											<option value="equipo">${equipo.nombre}</option>
										</c:forEach>
									</select>
									
									<p>Cuartos de final (partido 4)</p>
									<select name="equipo4">
										<c:forEach items="${equipos}" var="equipo">
											<option value="equipo">${equipo.nombre}</option>
										</c:forEach>
									</select>
									<h3>vs.</h3>
									<select name="equipo5">
										<c:forEach items="${equipos}" var="equipo">
											<option value="equipo">${equipo.nombre}</option>
										</c:forEach>
									</select>
									<button class="btn btn-lg btn-primary font-weight-bold mb-2" type="submit">Crear Torneo</button>
								</form>
					
	
	<script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>