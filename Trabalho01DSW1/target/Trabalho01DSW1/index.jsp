<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sistema para criação de promoções de quarto de hotel em sites de reservas</title>
	<script>
		function BoasVindas() {
			alert("Bem vindo!");
    	}
	</script>
</head>

<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
    <fmt:bundle basename="acessos">
    
	    <strong>Acesso ao sistema:</strong><br/>


	    <form name="fomularioTipoDeListagem" action="listaHoteis" method="POST">
			<fieldset>
				<legend>Área para não cadastrados</legend>
				<input type="radio" name ="AreaParaNaoCadastrados" title="área para não cadastrados" value="listaTodosHoteis"/>
				<label for="listaTodosHoteis">Listar todos os hotéis ordenados por nome</label><br>
				<input type="radio" name ="AreaParaNaoCadastrados" title="área para não cadastrados" value="listaHoteisPorCidade"/>
				<label for="listaHoteisPorCidade">Listar todos os hotéis ordenados por cidade</label><br>
				<input type="submit" value="Listar"/>
			</fieldset>
		</form>
	
	    <br><a href="login_administrador.jsp" title="área de acesso ao administrador">Área para login de administrador</a><br/> 
	    
	    <br><a href="login_hoteis_reservas.jsp" title="área de acesso ao sistema de hotéis e sistema de reservas">Área para login de hotéis e sistema de reservas</a><br/>

		<br><button onclick="BoasVindas()">Alerta: Boas vindas</button><br/>
	    <strong> <%= new Date() %></strong>
    </fmt:bundle>
    
    <div align="center">
		<table border="1">
			<caption>Lista de Hotéis (Não lista na página inicial =)</caption>
			<tr>
				<th>e-mail</th>
				<th>Senha</th>
				<th>CNPJ</th>
				<th>Nome do hotel</th>
				<th>Cidade</th>
			</tr>
			<c:forEach var="hotel" items="${requestScope.listaHoteis}">
				<tr>
					<td>${hotel.e_mail}</td>
					<td>${hotel.senha}</td>
					<td>${hotel.CNPJ}</td>
					<td>${hotel.nomeHotel}</td>
					<td>${hotel.cidade}</td>
				</tr>
			</c:forEach>
		</table>
		<h5>Para listagem, acesse a "Área para não cadastrados"</h5>
	</div>
</body>
</html>