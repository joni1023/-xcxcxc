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
   	<div id="torneo" class= "col-md-3">
   		<c:forEach items="${listaTorneos}" var="torneo"> 
			<div class="card text-white bg-success mb-3" style="max-width: 18rem;">
  				<div class="card-header">${torneo.nombre}</div>
  					<div class="card-body">
  		
					<form action="torneoDescripcion" method="POST">
						<input type="hidden" name="idTorneo" value="${torneo.id}" id="id">
						<button class="btn btn-lg btn-primary font-weight-bold mb-2" type="submit">Ver Torneo</button>
					</form>
					</div>
 				 	</div>  		
		</c:forEach>
	</div>				
						  		
						    	
   	
   	<a href="crearTorneo">Crear nuevo torneo</a>
   
</body>
</html>