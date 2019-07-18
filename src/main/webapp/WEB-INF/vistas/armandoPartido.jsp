<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	<title>Armando partido</title>
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
			<h2>Armando partido</h2>
			<h5>¡CONFIRMA EL PARTIDO A DISPUTAR!</h5>
		</div>
		<div class="row text-center">
			<div class="col-md-2">
			</div>
			<div id="miEquipo" class="col-md-3">
				<h3>Mi equipo</h3>
		    	<div class="card">
		    		<div class="card-header">
		    			<h5>${equipo1.nombre}</h5>
		    		</div>
		    	</div>
		  	</div>
		  	<div class="col-md-2 my-5">
		  		<form action="crearPartido" method="POST">
					<input type="text" class="form-control" name="equipo1ID" value="${equipo1.id}"/><br>
					<input type="text" class="form-control" name="equipo2ID" value="${equipo2.id}"/><br>
					<select type="datetime-local" name="fecha">
						<option value="2019/07/20 11:00">2019/07/20 11:00</option>
					 	<option value="2019/07/20 14:00">2019/07/20 14:00</option>
					    <option value="2019/07/20 17:00">2019/07/20 17:00</option>
					</select>
					<button class="btn btn-lg btn-primary font-weight-bold mt-5" type="submit">Confirmar</button>
				</form>
			</div>
		  	<div id="rival" class="col-md-3">
		  		<h3>Equipo rival</h3>
		    	<div class="card">
		    		<div class="card-header">
		    			<h5>${equipo2.nombre}</h5>
		    		</div>
		    	</div>
		  	</div>
		  	<div class="col-md-2">
			</div>
		</div>
	</div>
	
	<script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>