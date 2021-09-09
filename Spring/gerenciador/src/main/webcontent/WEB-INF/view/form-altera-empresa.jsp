
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="linkServeltNovaEmpresa"/>   
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
			<input id="nome" name="nome" type="text" value="${empresa.nome}" />
		</div>

		<div>
			<label for="data" >Data</label>
			<input value="<fmt:formatDate value="${empresa.dataAbertura}" 
				pattern="dd/MM/yyyy"/>" id="data" name="data" type="text" />
		</div>
		
		<div>
			<input id="id" name="id" type="hidden" value="${empresa.id}"/>
			<input id="acao" name="acao" type="hidden" value="AlteraEmpresa"/>
		</div>
		
		<input type="submit" />
	</form>

</body>
</html>