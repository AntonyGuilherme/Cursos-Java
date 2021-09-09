<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?acao=Login" var="linkServeltNovaEmpresa"/>   
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	
	<form action="${linkServeltNovaEmpresa}" method="post">
	
		<div>
			<label for="login" >Login</label>
			<input id="login" name="login" type="text" />
		</div>

		<div>
			<label for="senha" >Senha</label>
			<input id="senha" name="senha" type="password" />
		</div>
		<input type="submit" />
	</form>

</body>
</html>