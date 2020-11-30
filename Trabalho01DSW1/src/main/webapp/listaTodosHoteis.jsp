<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Lista de hotéis do banco de dados Hotéis</title>
	<script src="js/ajaxTipoListagem.js"></script>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	
	<jsp:useBean id='bean' class='src.br.ufscar.dc.dsw.bean.ListagemPorCidadeBean'/>
	
	<div align="center">
		<h1>Sistema para criação de promoções de quarto de hotel em sites de reservas</h1>
		<h2>
			<a href="login_administrador.jsp">Área para login de administrador</a>
			<a href="login_hoteis_reservas.jsp" title="área de acesso ao sistema de hotéis e sistema de reservas">Área para login de hotéis e sistema de reservas</a><br/>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de Hotéis</caption>
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
	</div>
</body>
</html>