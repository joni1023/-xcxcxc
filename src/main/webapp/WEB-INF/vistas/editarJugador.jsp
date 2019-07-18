<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	<title>Editar Jugador</title>
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
                <li class="nav-item">
                    <a class="nav-link" href="miEquipo">Mi Equipo</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="buscandoRival">Buscar Rival</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="estadisticas">Estadisticas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login">Salir</a>
                </li>
            </ul>
        </div>
   	</nav>
	
	<div class="container-fluid">
		<div class="text-center my-5">
			<h2>Editar Jugador</h2>
		</div>
		
		<!-- FORMULARIO -->
		<div class="row mt-5">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<h5>¡COMPLETA LOS SIGUIENTES DATOS!</h5>
				<table class="table table-bordered text-center">
				  <thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Posicion</th>
				      <th scope="col">Nombre</th>
				      <th scope="col">Edad</th>
				      <th scope="col">Peso</th>
				      <th scope="col">Altura</th>
				    </tr>
				  </thead>
				  <tbody>
				    <form action="editarJugador" method= "POST" modelAttribute="jugador">
				    <tr>
				      <th scope="row">1</th>
				      <td><select name="posicion" id="posicion" class="form-control" value="${jugador.posicion}" required autofocus>
				      <option value="Arquero">Arquero</option>
				      <option value="Campo">Campo</option>
				      </select></td>
				      <td><input name="nombre" type="text" id="nombre" class="form-control" value="${jugador.nombre}" required ></td>
				      <td><input name="edad" type="number" id="edad" class="form-control" value="${jugador.edad}" required></td>
				      <td><input name="peso" type="number" step="any" id="peso" class="form-control" value="${jugador.peso}" required></td>
				      <td><input name="altura" type="number" step="any" id="altura" class="form-control" value="${jugador.altura}" required></td>					   
				    </tr>
				  </tbody>
				</table>
				<input name="id" type="hidden" id="id" value="${jugador.id}">
				<button class="btn btn-lg btn-primary float-right font-weight-bold mb-2" type="submit">Editar</button>
				</form>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
	
	<script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>