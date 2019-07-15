<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	<title>Modificar los valores de la valoración de la tabla Edad</title>
</head>
<body>

	<div class="container-fluid">
		<div class="text-center my-5">
			<h2>Modificar los valores de la valoración de la tabla Edad</h2>
		</div>

		<!-- ROW -->
		<div class="row mt-5">
			<div class="col-md-2">
			</div>
			<div class="col-md-8">
				<table class="table table-bordered text-center">
					<thead >
					    <tr>
					      <th scope="col">Menor de 20</th>
					      <th scope="col">20 a 25</th>
					      <th scope="col">26 a 30</th>
					      <th scope="col">31 a 35</th>
					      <th scope="col">Mayor de 35</th>
					    </tr>
					</thead>
					<tbody>
					    <tr>
							<form:form action="modificarEdadT" method="POST" modelAttribute="valoracionEdad">
								<form:input path="id" type="hidden" value="${valorEdad.id}"/>
								<th scope="col"><form:input class="form-control" path="menor20" type="text" value="${valorEdad.menor20}"/></th>
								<th scope="col"><form:input class="form-control" path="de20a25" type="text" value="${valorEdad.de20a25}"/></th>
								<th scope="col"><form:input class="form-control" path="de26a30" type="text" value="${valorEdad.de26a30}"/></th>
								<th scope="col"><form:input class="form-control" path="de31a35" type="text" value="${valorEdad.de31a35}"/></th>
								<th scope="col"><form:input class="form-control" path="mayor35" type="text" value="${valorEdad.mayor35}"/></th>
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