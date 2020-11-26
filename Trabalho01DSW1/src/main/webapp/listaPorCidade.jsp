<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de hotéis do banco de dados Hotéis</title>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1>Sistema para criação de promoções de quarto de hotel em sites de reservas</h1>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de Hotéis por cidade</caption>
			<tr>
				<th>e-mail</th>
				<th>Senha</th>
				<th>CNPJ</th>
				<th>Nome do hotel</th>
				<th>Cidade</th>
			</tr>
			<c:forEach var="hotel" items="${requestScope.listaHoteisPorCidade}">
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