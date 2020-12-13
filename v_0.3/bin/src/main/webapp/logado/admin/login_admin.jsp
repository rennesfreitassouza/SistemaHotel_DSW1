<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<fmt:bundle basename="messages">
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../styles.css">
<title><fmt:message key="loginAdminTitle" /></title>
	</head>
	<body>
		<h1>
			<fmt:message key="loginAdminTitle" />
		</h1>
		<div class="area">
			<p>
				<fmt:message key="hello" />
				${sessionScope.usuarioLogado.nome}
			</p>
			<ul>
				<li><a href="hoteis/"><fmt:message
							key="formularioAdminHotelTitle" /></a></li>

				<li><a href="reservas/"><fmt:message
							key="formularioAdminSiteReservaTitle" /></a></li>

			</ul>
			<a href="${pageContext.request.contextPath}/logout.jsp"><fmt:message
					key="logout" /></a>
		</div>
		<div class="area" align="center">
			<form method="post" action="../index.jsp">
				<table>
					<tr>
						<td colspan="2"><fmt:message key="voltar" var="voltarMessage" />
							<input class="pagInicial" type="submit" name="voltar"
							value="${voltarMessage}" /></td>
					</tr>
				</table>
			</form>
		</div>
	</body>

</fmt:bundle>
</html>
