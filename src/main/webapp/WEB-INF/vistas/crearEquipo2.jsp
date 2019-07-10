<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	<title>Crear Equipo</title>
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
                    <a class="nav-link" href="crearEquipo">Crear Equipo</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="buscandoRival">Buscar Rival</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login">Salir</a>
                </li>
            </ul>
        </div>
   	</nav>
	
	<div class="container-fluid">
		<div class="text-center my-5">
			<h2>Crea tu equipo</h2>
		</div>
		
		<!-- FORMULARIO -->
		<div class="row mt-5">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h5>¡COMPLETA LOS SIGUIENTES DATOS DE CADA JUGADOR!</h5>
				<form action="#!">
					<table class="table table-bordered text-center">
					  <thead>
					    <tr>
					      <th scope="col">#</th>
					      <th scope="col">Posición</th>
					      <th scope="col">Edad</th>
					      <th scope="col">Peso</th>
					      <th scope="col">Altura</th>
					    </tr>
					  </thead>
					  <tbody>
					    <tr>
					      <th scope="row">1</th>
					      <td><input name="posicion" type="hidden" id="posicion" class="form-control" value="Arquero"><p>Arquero</p></td>
					      <td><input name="edad" type="text" id="edad" class="form-control" required autofocus></td>
					      <td><input name="peso" type="text" id="peso" class="form-control" required></td>
					      <td><input name="altura" type="text" id="altura" class="form-control" required></td>
					    </tr>
					    <tr>
					      <th scope="row">2</th>
					      <td><input name="posicion" type="hidden" id="posicion" class="form-control" value="Campo"><p>Campo</p></td>
					      <td><input name="edad" type="text" id="edad" class="form-control" required></td>
					      <td><input name="peso" type="text" id="peso" class="form-control" required></td>
					      <td><input name="altura" type="text" id="altura" class="form-control" required></td>
					    </tr>
					    <tr>
					      <th scope="row">3</th>
					      <td><input name="posicion" type="hidden" id="posicion" class="form-control" value="Campo"><p>Campo</p></td>
					      <td><input name="edad" type="text" id="edad" class="form-control" required></td>
					      <td><input name="peso" type="text" id="peso" class="form-control" required></td>
					      <td><input name="altura" type="text" id="altura" class="form-control" required></td>
					    </tr>
					    <tr>
					      <th scope="row">4</th>
					      <td><input name="posicion" type="hidden" id="posicion" class="form-control" value="Campo"><p>Campo</p></td>
					      <td><input name="edad" type="text" id="edad" class="form-control" required></td>
					      <td><input name="peso" type="text" id="peso" class="form-control" required></td>
					      <td><input name="altura" type="text" id="altura" class="form-control" required></td>
					    </tr>
					    <tr>
					      <th scope="row">5</th>
					      <td><input name="posicion" type="hidden" id="posicion" class="form-control" value="Campo"><p>Campo</p></td>
					      <td><input name="edad" type="text" id="edad" class="form-control" required></td>
					      <td><input name="peso" type="text" id="peso" class="form-control" required></td>
					      <td><input name="altura" type="text" id="altura" class="form-control" required></td>
					    </tr>
					  </tbody>
					</table>
					<button class="btn btn-lg btn-primary float-right font-weight-bold mb-2" type="submit">Finalizar</button>
				</form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	
	<script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>