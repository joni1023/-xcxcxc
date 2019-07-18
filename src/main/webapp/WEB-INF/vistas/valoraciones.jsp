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
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
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
					<a class="nav-link" href="login">Salir</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="text-center my-5">
			<h2>Datos de valoraciones en tabla</h2>
			<h3>1 arquero, 2 campo</h3>
		</div>
		
		<!-- PRIMERA ROW -->
		<div class="row mt-5">
			<div class="col-md-2">
			</div>
			<div class="col-md-8">
				<p>Valores por edad:</p>
				<table class="table table-bordered text-center">
					<thead >
					    <tr>
					      <th scope="col">Menor de 20</th>
					      <th scope="col">20 a 25</th>
					      <th scope="col">26 a 30</th>
					      <th scope="col">31 a 35</th>
					      <th scope="col">Mayor de 35</th>
					      <th scope="col">Opción</th>
					    </tr>
					</thead>
				<c:forEach items="${listaValorEdad}" var="valorEdad">
					<tbody>
					    <tr>
					      <th scope="col">${valorEdad.menor20}</th>
					      <th scope="col">${valorEdad.de20a25}</th>
					      <th scope="col">${valorEdad.de26a30}</th>
					      <th scope="col">${valorEdad.de31a35}</th>
					      <th scope="col">${valorEdad.mayor35}</th>
					      <th scope="row"><form:form action="modificarTablaEdad" method="POST" modelAttribute="valoracionEdad">
												<form:input path="id" id="id" type="hidden" value="${valorEdad.id}"/>
												<button class="btn btn-lg btn-primary font-weight-bold mb-2" type="submit"> Modificar</button>
										  </form:form></th>
					    </tr>
					</tbody>
				</c:forEach>
				</table>
				<h3 class="text-center"> -- -- -- -- -- </h3>
			</div>
			<div class="col-md-2">
			</div>
		</div>
		
		<!-- SEGUNDA ROW -->
		<div class="row mt-5">
			<div class="col-md-2">
			</div>
			<div class="col-md-8">
				<p>Valores por altura:</p>
				<table class="table table-bordered text-center">
					<thead >
					    <tr>
					      <th scope="col">Menor de 150cm</th>
					      <th scope="col">150 a 160cm</th>
					      <th scope="col">160 a 170cm</th>
					      <th scope="col">170 a 180cm</th>
					      <th scope="col">180 a 190cm</th>
					      <th scope="col">Mayor de 190cm</th>
					      <th scope="col">Opción</th>
					    </tr>
					</thead>
				<c:forEach items="${listaValorAltura}" var="valorAltura">
					<tbody>
					    <tr>
					      <th scope="col">${valorAltura.menor150cm}</th>
					      <th scope="col">${valorAltura.entre150y160cm}</th>
					      <th scope="col">${valorAltura.entre160y170cm}</th>
					      <th scope="col">${valorAltura.entre170y180cm}</th>
					      <th scope="col">${valorAltura.entre180y190cm}</th>
					      <th scope="col">${valorAltura.mayor190cm}</th>
					      <th scope="row"><form:form action="modificarTablaAltura" method="POST" modelAttribute="valoracionAltura">
												<form:input path="id" id="id" type="hidden" value="${valorAltura.id}" />
												<button class="btn btn-lg btn-primary font-weight-bold mb-2" type="submit"> Modificar</button>
										  </form:form></th>
					    </tr>
					</tbody>
				</c:forEach>
				</table>
				<h3 class="text-center"> -- -- -- -- -- </h3>
			</div>
			<div class="col-md-2">
			</div>
		</div>
		
		<!-- TERCERA ROW -->
		<div class="row mt-5">
			<div class="col-md-2">
			</div>
			<div class="col-md-8">
				<p>Valores por peso respecto a la altura:</p>
				<table class="table table-bordered text-center">
					<thead >
					    <tr>
					      <th scope="col">Altura</th>
					      <th scope="col">Menos de 60kg</th>
					      <th scope="col">60 a 70kg</th>
					      <th scope="col">70 a 80kg</th>
					      <th scope="col">80 a 90kg</th>
					      <th scope="col">90 a 100kg</th>
					      <th scope="col">Mas de 100kg</th>
					      <th scope="row">Opción</th>
					    </tr>
					</thead>
				<c:forEach items="${listaValorPA}" var="lista">
					<tbody>
					    <tr>
					      <th scope="col">${lista.altura}</th>
					      <th scope="col"><c:if test="${empty lista.menos60}"><p>No aplica</p></c:if><c:if test="${not empty lista.menos60}"> ${lista.menos60}</c:if></th>
					      <th scope="col">${lista.entre60y70}</th>
					      <th scope="col">${lista.entre70y80}</th>
					      <th scope="col">${lista.entre80y90}</th>
					      <th scope="col">${lista.entre90y100}</th>
					      <th scope="col">${lista.mas100}</th>
					      <th scope="row"><form:form action="modificarTablaPesoAltura" method="POST" modelAttribute="valoracionPesoAltura">
												<form:input path="id" id="id" type="hidden" value="${lista.id}"/>
												<button class="btn btn-lg btn-primary font-weight-bold mb-2" type="submit"> Modificar</button>
										  </form:form></th>
					    </tr>
					</tbody>
				</c:forEach>
				</table>
				<h3 class="text-center"> -- -- -- -- -- </h3>
			</div>
			<div class="col-md-2">
			</div>
		</div>
		<!--CUARTA ROW -->
		<div class="row mt-5">
			<div class="col-md-2">
			</div>
			<div class="col-md-8">
				<p>Valores Generales:</p>
				<table class="table table-bordered text-center">
					<thead >
					    <tr>
					      <th scope="col">Rango de Medición</th>
					      <th scope="col">Opción</th>
					    </tr>
					</thead>
					<tbody>
					    <tr>
					      <th scope="col">${valorGeneral.radioMedicion}</th>
					     
					      <th scope="row"><form:form action="modificarValoresGenerales" method="POST" modelAttribute="valoracionesGenerales">
												<form:input path="id" id="id" type="hidden" value="${valorGeneral.id}"/>
												<button class="btn btn-lg btn-primary font-weight-bold mb-2" type="submit"> Modificar</button>
										  </form:form></th>
					    </tr>
					</tbody>
				
				</table>
				<h3 class="text-center"> -- -- -- -- -- </h3>
			</div>
			<div class="col-md-2">
			</div>
		</div>
	</div>
	<p>${valorGeneral.radioMedicion}</p>
</body>
</html>