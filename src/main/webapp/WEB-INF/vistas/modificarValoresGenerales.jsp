<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	<title>Modificar los valores de las Valoraciones Generales</title>
</head>
<body>

	<div class="container-fluid">
		<div class="text-center my-5">
			<h2>Modificar los valores de las Valoraciones Generales</h2>
		</div>

		<!-- ROW -->
		<div class="row mt-5">
			<div class="col-md-2">
			</div>
			<div class="col-md-8">
				<table class="table table-bordered text-center">
					<thead >
					    <tr>
					      <th scope="col">Rango de Medicion</th>
					    </tr>
					</thead>
					<tbody>
					    <tr>
							<form:form action="modificarValoresGeneralesT" method="POST" modelAttribute="valoracionesGenerales">
								<form:input path="id" type="hidden" value="${valorGeneral.id}"/>
								<th scope="col"><form:input class="form-control" path="radioMedicion" type="text" value="${valorGeneral.radioMedicion}"/></th>
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