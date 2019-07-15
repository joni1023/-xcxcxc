<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	<title>Modificar los valores de la valoración de la tabla Peso y Altura</title>
</head>
<body>

	<div class="container-fluid">
		<div class="text-center my-5">
			<h2>Modificar los valores de la valoración de la tabla Peso y Altura</h2>
		</div>
		
		<!-- ROW -->
		<div class="row mt-5">
			<div class="col-md-2">
			</div>
			<div class="col-md-8">
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
					    </tr>
					</thead>
					<tbody>
					    <tr>
							<form:form action="modificarPesoAlturaT" method="POST" modelAttribute="valoracionPesoAltura">
								<form:input path="id" type="hidden" value="${valorPesoAltura.id}"/>	
								<th scope="col"><p>${valorPesoAltura.altura}</p><form:input path="altura" type="hidden" value="${valorPesoAltura.altura}"/></th>
								<th scope="col"><form:input class="form-control" path="menos60" type="text" value="${valorPesoAltura.menos60}"/></th>
								<th scope="col"><form:input class="form-control" path="entre60y70" type="text" value="${valorPesoAltura.entre60y70}"/></th>
								<th scope="col"><form:input class="form-control" path="entre70y80" type="text" value="${valorPesoAltura.entre70y80}"/></th>
								<th scope="col"><form:input class="form-control" path="entre80y90" type="text" value="${valorPesoAltura.entre80y90}"/></th>
								<th scope="col"><form:input class="form-control" path="entre90y100" type="text" value="${valorPesoAltura.entre90y100}"/></th>
								<th scope="col"><form:input class="form-control" path="mas100" type="text" value="${valorPesoAltura.mas100}"/></th>
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