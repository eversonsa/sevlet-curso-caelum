<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/NovaEmpresaAlterada" var="linkServletNovaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Alterando o formulario</h2>
	
	<form method="get" action="${ linkServletNovaEmpresa }">
	
		<label>Nome da Empresa</label>
		<input type="text" name="nome" value="${ empresa.nome } "><br>
		
		<label>Data de Abertura</label>
		<input type="text" name="dataAbertura" value="<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>">
		
		<input type="hidden" name="id" value="${ empresa.id }">
		
		<input type="submit" value="Alterar" />
	</form>
</body>
</html>