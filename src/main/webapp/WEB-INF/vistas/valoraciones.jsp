<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="container">
<h1>datos de valoraciones en tabla</h1>
<h3>Arquero</h3>
<p>Valores por edad:</p>
<table class=" table table-bordered">
<thead >
			    <tr>
			      <th scope= "col">Menor de 20</th>
			      <th scope= "col">20 a 25</th>
			      <th scope= "col">26 a 30</th>
			      <th scope= "col">31 a 35</th>
			      <th scope= "col">mayor de 35</th>
			      <th scope= "col">opcion</th>
			    </tr>
</thead>
<tbody>
				    <tr>
				      <th scope= "col">${valorEdad.menor20 }</th>
				      <th scope= "col"> ${valorEdad.de20a25 }</th>
				      <th scope= "col">${valorEdad.de26a30 }</th>
				      <th scope= "col">${valorEdad.de31a35 }</th>
				      <th scope= "col">${valorEdad.mayor35 }</th>
				      <th scope= "row"><form:form action="modificarTablaEdad" method="Post" modelAttribute="valoracionEdad">
						<form:input path="id" id="id" type="hidden" value="${valorEdad.id}"/>
							<button class="btn btn-info" type="submit"><span class="glyphicon glyphicon-pencil"></span> modificar</button>
								</form:form>
								</th>
				    </tr>
</tbody>
</table>
<h3>  --- --  -- -- </h3>
<br>
<p>Valores por altura:</p>
<table class=" table table-bordered">
<thead >
			    <tr>
			      <th scope= "col">Menor de 150cm</th>
			      <th scope= "col">150 a 160cm</th>
			      <th scope= "col">160 a 170cm</th>
			      <th scope= "col">170 a 180cm</th>
			      <th scope= "col">180 a 190cm</th>
			      <th scope= "col">Mayor de 190cm</th>
			      <th scope= "col">opcion</th>
			    </tr>
</thead>
<tbody>
				    <tr>
				      <th scope= "col">${valorAltura.menor150cm }</th>
				      <th scope= "col"> ${valorAltura.entre150y160cm }</th>
				      <th scope= "col">${valorAltura.entre160y170cm }</th>
				      <th scope= "col">${valorAltura.entre170y180cm }</th>
				      <th scope= "col">${valorAltura.entre180y190cm }</th>
				      <th scope= "col">${valorAltura.mayor190cm }</th>
				      <th scope= "row"><form:form action="modificarTablaEdad" method="Post" modelAttribute="valoracionAltura">
						<form:input path="id" id="id" type="hidden" value=" ${ valorAltura.id } " />
							<button class="btn btn-info" type="submit"><span class="glyphicon glyphicon-pencil"></span> modificar</button>
								</form:form>
								</th>
				    </tr>
</tbody>
</table>
<h3>  ---  --  --  --  --  </h3>
<br>
<p>Valores Por peso respecto a la altura</p>
<table class="table table-bordered">
<thead >
			    <tr>
			      <th scope= "col">Altura</th>
			      <th scope= "col">Menos de 60kg</th>
			      <th scope= "col">60 a 70kg</th>
			      <th scope= "col">70 a 80kg</th>
			      <th scope= "col">80 a 90kg</th>
			      <th scope= "col">90 a 1000kg</th>
			      <th scope= "col">mas de 100kg</th>
			      <th scope="row">opcion</th>
			    </tr>
</thead>
<c:forEach items="${listaValor }" var="lista">
<tbody>
				    <tr>
				      <th scope= "col">${lista.altura }</th>
				      <th scope= "col"><c:if test="${empty lista.menos60}"><p>no aplica</p></c:if><c:if test="${not empty lista.menos60}"> ${lista.menos60 }</c:if></th>
				      <th scope= "col">${lista.entre60y70 }</th>
				      <th scope= "col">${lista.entre70y80 }</th>
				      <th scope= "col">${lista.entre80y90 }</th>
				      <th scope= "col">${lista.entre90y100 }</th>
				      <th scope= "col">${lista.mas100 }</th>
				      <th scope= "row"><form:form action="modificarTablaEdad" method="Post" modelAttribute="valoracionPesoAlturaA">
						<form:input path="id" id="id" type="hidden" value="${lista.id}"/>
							<button class="btn btn-info" type="submit"><span class="glyphicon glyphicon-pencil"></span> modificar</button>
								</form:form>
								</th>
				    </tr>
</tbody>
</c:forEach>
</table>
 <%---  <jsp:include page="***.jsp"  /> incluye pagina   --%>
</body>
</html>