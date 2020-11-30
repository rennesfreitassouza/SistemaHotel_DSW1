<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sistema para criação de promoções de quarto de hotel em sites de reservas</title>
</head>

	<body>
	    <fmt:bundle basename="acessos">
	    
		    <strong>Acesso ao sistema:</strong><br/>
			<div align="center">
				<h1>Sistema para criação de promoções de quarto de hotel em sites de reservas</h1>
				<h2>
					<a href="login_administrador.jsp">Área para login de administrador</a>
					<a href="login_hoteis_reservas.jsp" title="área de acesso ao sistema de hotéis e sistema de reservas">Área para login de hotéis e sistema de reservas</a><br/>
				</h2>
			</div>	
	
		    <form name="fomularioTipoDeListagem" action="listaHoteis" method="POST">
				<fieldset>
					<legend>Área para não cadastrados</legend>
					<input type="radio" name ="AreaParaNaoCadastrados" title="área para não cadastrados" value="listaTodosHoteis" checked/>
					<label for="listaTodosHoteis">Listar todos os hotéis ordenados por nome</label><br>
					<input type="radio" name ="AreaParaNaoCadastrados" title="área para não cadastrados" value="listaHoteisPorCidade" />
					<label for="listaHoteisPorCidade">Listar todos os hotéis ordenados por cidade</label><br>
					<input type="submit" value="Listar"/>
				</fieldset>
			</form>
		
		    	
		    <strong> <%= new Date() %></strong>
	    </fmt:bundle>
	</body>
</html>