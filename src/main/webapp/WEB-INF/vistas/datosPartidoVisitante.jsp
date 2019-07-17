<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
        <a class="navbar-brand" href="homeAdmin">Buscando Rival</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
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
                    <a class="nav-link" href="#">XXXXXX</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login">Salir</a>
                </li>
            </ul>
        </div>
   	</nav>

	<div class="container-fluid">
		<div class="text-center my-5">
			<h2>${partido.visitante.nombre}</h2>
		</div>

		<div class="row mt-5">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<form action="datosPartido2" method="POST">
				<input type="hidden" name="partidoId" value="${partido.id}">
				<input type="hidden" name="datos" value="visitante">
				<table class="table table-bordered text-center">
					<thead>
						<tr>
							<th scope="col">Nombre</th>
							<th scope="col">Goles</th>
							<th scope="col">Amonestaciones</th>
							<th scope="col">Expulsiones</th>

						</tr>
					</thead>
					<tbody>
							<c:set var="count" value="1"/>
							<c:forEach items="${jugadores}" var="jugador">
								<input type="hidden" name="jugador${count}Id" value="${jugador.id}">
								<tr>
								<td>${jugador.nombre}</td>
								<td>
								<input type="number" name="gol${count}Cantidad" min="0" class="form-control">
								</td>
								<td>
								<input type="number" name="amonestacion${count}Cantidad" min="0" max="2" class="form-control">
								</td>
								<td>
								<input type="number" name="expulsion${count}Cantidad" min="0" max="1" class="form-control">
								</td>
								</tr>
								<c:set var="count" value="${count + 1}"/>
							</c:forEach>
					</tbody>
				</table>
					 <button class="btn btn-lg btn-primary btn-block font-weight-bold mb-2" type="submit">Guardar Datos</button>
					</form>
			</div>
			</div>
			<div class="col-md-2"></div>
		</div>
			
	<script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>