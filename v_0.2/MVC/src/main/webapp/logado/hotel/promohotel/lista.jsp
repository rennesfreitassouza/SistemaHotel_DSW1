<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<fmt:bundle basename="messages">
    <head>
        <title>
        	<fmt:message key="systemMenu"/>
        </title>
    </head>
    
    <body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1><fmt:message key="hotelPage"/></h1>
		<p><fmt:message key="hello"/> ${sessionScope.usuarioLogado.nome}</p>
		<h2>
				<!-- <a href="/<%=contextPath%>/hotel/">Menu Principal</a> &nbsp;&nbsp;&nbsp; -->
				<a href="/<%=contextPath%>/hoteluser/cadastro"><fmt:message key="add_promo"/></a>
				
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption><fmt:message key="promoListByHotel"/></caption>
			<tr>
				<th><fmt:message key="id"/></th>
				<th><fmt:message key="preco"/></th>
				<th><fmt:message key="promo_inicio"/></th>
				<th><fmt:message key="promo_fim"/></th>
				<th><fmt:message key="cnpjHotel"/></th>
				<th><fmt:message key="urlSite"/></th>
				<th><fmt:message key="actions"/></th>
			</tr>
			<c:forEach var="promohotel" items="${requestScope.listaPromoHotel}">
				<tr>
					<td>${promohotel.id}</td>
					<td>${promohotel.preco}</td>
					<td>${promohotel.iniciopromo}</td>
					<td>${promohotel.fimpromo}</td>
					<td>${promohotel.hotel.cnpj}</td>
					<td>${promohotel.sitereserva.url}</td>
					<fmt:message key="confirm_delete" var="confirmMessage"/>
					<td><a href="/<%= contextPath%>/hoteluser/edicao?id=${promohotel.id}"><fmt:message key="edit"/></a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/<%= contextPath%>/hoteluser/remocao?id=${promohotel.id}"
						onclick="return confirm('${confirmMessage}');">
							<fmt:message key="remove"/> </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/logout.jsp"><fmt:message key="logout"/></a>
        </li>
    </ul>
</body>
</fmt:bundle>
</html>
