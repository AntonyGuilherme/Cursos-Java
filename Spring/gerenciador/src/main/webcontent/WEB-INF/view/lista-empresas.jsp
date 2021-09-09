<%@page import="java.util.List"%>
<%@page import="br.com.alura.gerenciador.modelo.Empresa"%>
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
	
	<c:import url="logout-parcial.jsp"/>
	<br>
	<h1> Usuario Logado ${usuarioLogado}</h1>

	<h1> Empresas Cadastradas </h1>
	
	
	
	<ul>
	
	<c:forEach items="${empresas}" var="empresa" >
	
			
		<li> 
		${ empresa } 
		
		<fmt:formatDate 
		value="${empresa.dataAbertura}" 
		pattern="dd/MM/yyyy"/> 
		
		<a href="entrada?acao=MostraEmpresa&id=${empresa.id}">Editar</a>
		<a href="entrada?acao=RemoverEmpresa&id=${empresa.id}">Remover</a>
		
		
		</li>
	
	</c:forEach>
	

	
	</ul>

	


</body>
</html>