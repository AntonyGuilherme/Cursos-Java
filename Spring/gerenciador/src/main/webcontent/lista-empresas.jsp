<%@page import="java.util.List"%>
<%@page import="br.com.alura.gerenciador.servlet.Empresa"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>

	<h1> Empresas Cadastradas </h1>
	
	
	<ul>
	
	<c:forEach items="${empresas}" var="empresa" >
	
			
		<li> 
		${ empresa } 
		
		<fmt:formatDate 
		value="${empresa.dataAbertura}" 
		pattern="dd/MM/yyyy"/> 
		
		<a href="mostra-empresa?id=${empresa.id}">Editar</a>
		<a href="remover-empresa?id=${empresa.id}">Remover</a>
		
		
		</li>
	
	</c:forEach>
	

	
	</ul>

	


</body>
</html>