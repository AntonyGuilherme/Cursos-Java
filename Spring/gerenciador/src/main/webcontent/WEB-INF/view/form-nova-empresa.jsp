
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?acao=NovaEmpresa" var="linkServeltNovaEmpresa"/>   
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<c:import url="logout-parcial.jsp"/>
	<br>
	
	<form action="${linkServeltNovaEmpresa}" method="post">
	
		<div>
			<label for="nome" >Nome</label>
			<input id="nome" name="nome" type="text" />
		</div>

		<div>
			<label for="data" >Data</label>
			<input id="data" name="data" type="text" />
		</div>
		<input type="submit" />
	</form>

</body>
</html>