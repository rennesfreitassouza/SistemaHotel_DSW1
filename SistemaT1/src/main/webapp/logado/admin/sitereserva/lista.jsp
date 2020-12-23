<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<fmt:bundle basename="messages">
<head>
<title>
	<fmt:message key="formularioAdminSiteReservaTitle"/>
</title>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1><fmt:message key="formularioAdminSiteReservaTitle"/></h1>
		<h2>
			<a href="/<%=contextPath%>/admin/"><fmt:message key="menu_principal"/></a> &nbsp;&nbsp;&nbsp; <a
				href="/<%=contextPath%>/admin/reservas/cadastro"><fmt:message key="add_site_reserva"/></a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption><fmt:message key="site_list"/></caption>
			<tr>
				<th><fmt:message key="id"/></th>
				<th><fmt:message key="url"/></th>
				<th><fmt:message key="nome"/></th>
				<th><fmt:message key="telefone"/></th>
				<th><fmt:message key="email"/></th>
				<th><fmt:message key="senha"/></th>
				<th><fmt:message key="actions"/></th>
			</tr>
			<c:forEach var="site" items="${requestScope.listaSiteReserva}">
				<tr>
					<td>${site.id}</td>
					<td>${site.url}</td>
					<td>${site.nome}</td>
					<td>${site.telefone}</td>
					<td>${site.email}</td>
					<td>${site.senha}</td>
					<fmt:message key="confirm_delete" var="confirmMessage"/>
					<td><a href="/<%= contextPath%>/admin/reservas/edicao?id=${site.id}"><fmt:message key="edit"/></a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/<%= contextPath%>/admin/reservas/remocao?id=${site.id}"
						onclick="return confirm('${confirmMessage}');">
							<fmt:message key="remove"/> </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</fmt:bundle>
</html>
