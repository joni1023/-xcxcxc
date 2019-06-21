<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>datos de valoraciones en tabla</h1>
<h3> ${valorEdad.menor20 } --- ${valorEdad.de20a25 } -- ${valorEdad.de26a30 } -- ${valorEdad.de31a35 }-- ${valorEdad.mayor35 }</h3>
<br>
<h3> ${valorAltura.menor150cm } --- ${valorAltura.entre150y160cm } -- ${valorAltura.entre160y170cm } -- ${valorAltura.entre170y180cm } -- ${valorAltura.entre180y190cm } -- ${valorAltura.mayor190cm } </h3>
<br>
<c:forEach items="${listaValor }" var="lista">
<h3>${lista.altura } -- ${lista.menos60 } --  ${lista.entre60y70 } -- ${lista.entre70y80 } -- ${lista.entre80y90 } -- ${lista.entre90y100 } -- ${lista.mas100 } </h3>
</c:forEach>

</body>
</html>