<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<fmt:bundle basename="messages">
<head>
<title>
	<fmt:message key="formularioAdminHotelTitle"/>
</title>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1><fmt:message key="formularioAdminHotelTitle"/></h1>
		<h2>
			<a href="/<%=contextPath%>/admin/"><fmt:message key="menu_principal"/></a> &nbsp;&nbsp;&nbsp; <a
				href="/<%=contextPath%>/admin/hoteis/cadastro"><fmt:message key="add_hotel"/></a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption><fmt:message key="listaTodosHoteisCaption"/></caption>
			<tr>
				<th><fmt:message key="id"/></th>
				<th><fmt:message key="cnpj"/></th>
				<th><fmt:message key="nome"/></th>
				<th><fmt:message key="cidade"/></th>
				<th><fmt:message key="email"/></th>
				<th><fmt:message key="senha"/></th>
				<th><fmt:message key="actions"/></th>
			</tr>
			<c:forEach var="hotel" items="${requestScope.listaHotel}">
				<tr>
					<td>${hotel.id}</td>
					<td>${hotel.cnpj}</td>
					<td>${hotel.nome}</td>
					<td>${hotel.cidade}</td>
					<td>${hotel.email}</td>
					<td>${hotel.senha}</td>
					<fmt:message key="confirm_delete" var="confirmMessage"/>
					<td><a href="/<%= contextPath%>/admin/hoteis/edicao?id=${hotel.id}"><fmt:message key="edit"/></a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/<%= contextPath%>/admin/hoteis/remocao?id=${hotel.id}"
						onclick="return confirm('${confirmMessage}');">
							<fmt:message key="remove"/> </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</fmt:bundle>
</html>
