<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/NovaEmpresa" var="linkServletNovaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form method="post" action="${ linkServletNovaEmpresa }">
	
		<label>Nome da Empresa</label>
		<input type="text" name="nome"><br>
		
		<label>Data de Abertura</label>
		<input type="text" name="dataAbertura">
		
		<input type="submit" value="Adicionar" />
	</form>
</body>
</html>