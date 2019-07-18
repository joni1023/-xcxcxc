<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item">
					<a class="nav-link" href="valoraciones">Valoraciones</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="cargarPartidos">Cargar Partidos</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="login">Salir</a>
				</li>
			</ul>
		</div>
	</nav>
	<br>
	<div class="row mr-3 ml-3">
		<c:forEach items="${partidos}" var="partido">
			<div class="col-md-4">
				<div class="card w-100 mb-3">
					<div class="card-body">
						<h5 class="card-title text-center">${partido.local.nombre} - ${partido.visitante.nombre}</h5>
						<form action="datosPartido" method="POST" class="text-center">
							<input type="hidden" name="idPartido" id="idPartido" value="${partido.id}">
							<button class="btn btn-lg btn-primary font-weight-bold my-2" type="submit">Cargar Datos</button>
						</form>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	
	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>