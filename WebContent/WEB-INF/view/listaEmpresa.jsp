
<%@ page import="java.util.List, br.com.caelum.gerenciador.modelo.Empresa"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada?acao=RemoveEmpresa&id=" var="linkServletRemoveEmpresa" />
<c:url value="/entrada?acao=AlteraEmpresa&id=" var="linkServletAlterarEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<c:import url="logout-parcial.jsp" />
	
	<label>Usuario Logado: ${ usuarioLogado.login }</label>
	
	
	<br>
	<br>
	<br>
		
	<c:if test="${not empty empresa }">
			Empresa ${ empresa } cadastrada com sucesso !!!!
	</c:if>

	<h1>Lista de Empresas:</h1>
	
	<ul>		
		<c:forEach items="${ empresas }" var="empresa">
			<li>${ empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
				<a href="${ linkServletRemoveEmpresa }${ empresa.id }" >Remove</a>
				<a href="${ linkServletAlterarEmpresa }${ empresa.id }" >Alterar</a>
			</li>
		</c:forEach>	
	</ul>
	
</body>
</html>	
