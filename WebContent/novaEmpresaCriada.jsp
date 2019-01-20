<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<c:if test="${not empty empresa }">
			<p>Empresa de nome ${empresa} cadastrada com sucesso !!!!</p>
		</c:if>
		<c:if test="${empty empresa }">
			<p>Empresa nao cadastrada </p>
		</c:if>
</body>
</html>