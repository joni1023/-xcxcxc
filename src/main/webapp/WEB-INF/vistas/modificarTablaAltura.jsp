<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
               		<a class="nav-link" href="estadistcas">Estadísticas</a>
               	</li>
				<li class="nav-item">
					<a class="nav-link" href="login">Salir</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="text-center my-5">
			<h2>Modificar los valores de la valoración de la tabla Altura</h2>
		</div>
		
		<!-- ROW -->
		<div class="row mt-5">
			<div class="col-md-2">
			</div>
			<div class="col-md-8">
				<table class="table table-bordered text-center">
					<thead >
					    <tr>
					      <th scope="col">Menor de 150cm</th>
					      <th scope="col">150 a 160cm</th>
					      <th scope="col">160 a 170cm</th>
					      <th scope="col">170 a 180cm</th>
					      <th scope="col">180 a 190cm</th>
					      <th scope="col">Mayor de 190cm</th>
					    </tr>
					</thead>
					<tbody>
					    <tr>
							<form:form action="modificarAlturaT" method="POST" modelAttribute="valoracionAltura">
								<form:input path="id" type="hidden" value="${valorAltura.id}"/>
								<th scope="col"><form:input class="form-control" path="menor150cm" type="text" value="${valorAltura.menor150cm}"/></th>
								<th scope="col"><form:input class="form-control" path="entre150y160cm" type="text" value="${valorAltura.entre150y160cm}"/></th>
								<th scope="col"><form:input class="form-control" path="entre160y170cm" type="text" value="${valorAltura.entre160y170cm}"/></th>
								<th scope="col"><form:input class="form-control" path="entre170y180cm" type="text" value="${valorAltura.entre170y180cm}"/></th>
								<th scope="col"><form:input class="form-control" path="entre180y190cm" type="text" value="${valorAltura.entre180y190cm}"/></th>
								<th scope="col"><form:input class="form-control" path="mayor190cm" type="text" value="${valorAltura.mayor190cm}"/></th>	
					 	</tr>
					</tbody>
				</table>
								<button type="submit" class="btn btn-lg btn-primary font-weight-bold mb-2">Guardar cambios</button>
							</form:form>
			</div>
			<div class="col-md-2">
			</div>
		</div>
	</div>
</body>
</html>