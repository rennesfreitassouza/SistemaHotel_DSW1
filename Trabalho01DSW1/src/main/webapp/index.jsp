<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sistema para criação de promoções de quarto de hotel em sites de reservas</title>
	<script>
		function mudarCor() {
			alert("Bem vindo!");
    	}
	</script>
</head>

<body>
    <fmt:bundle basename="acessos">
    
	    <strong>Acesso ao sistema:</strong><br/>
	    
	    <a href="login_administrador.jsp" title="área de acesso ao administrador">Área para login de administrador</a><br/> 
	    <a href="login_hoteis_reservas.jsp" title="área de acesso ao sistema de hotéis e sistema de reservas">Área para login de hotéis e sistema de reservas</a><br/>
	    <a href="nao_cadastrados.jsp" title="área para não cadastrados">Área para não cadastrados</a><br/> 
		
		<button onclick="mudarCor()">Clique aqui</button><br/><%--Linha de boas vindas--%>
	    <strong> <%= new Date() %></strong>
    </fmt:bundle>
</body>
</html>