<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>
<html>
<fmt:bundle basename="messages">
<head>
	<title>
		<fmt:message key="listaTodosHoteisTitle"/>
	</title>
	<script src="js/ajaxTipoListagem.js"></script>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	
	<jsp:useBean id="bean" class="br.ufscar.dc.dsw.bean.ListagemPorCidadeBean"/>
	
	<strong><fmt:message key="system_access"/></strong><br>
	<a href="login.jsp" title="Fazer login"><fmt:message key="entrar"/></a><br><br>
	<form method="post" action="index.jsp">
    	<tr>
        	<td colspan="2">
        		<fmt:message key="voltar" var="voltarMessage"/> 
                <input type="submit" name="voltar" value="${voltarMessage}"/>
            </td>
        </tr>
    </form>

	<div align="center">
		<table border="1">
			<caption><fmt:message key="listaTodosHoteisCaption"/></caption>
			<tr>
				<th><fmt:message key="nome"/></th>
				<th><fmt:message key="email"/></th>
				<th><fmt:message key="cidade"/></th>
				<th><fmt:message key="cnpj"/></th>
			</tr>
			<c:forEach var="hotel" items="${requestScope.listaHoteis}">
				<tr>
					<td>${hotel.nome}</td>
					<td>${hotel.email}</td>
					<td>${hotel.cidade}</td>
					<td>${hotel.cnpj}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</fmt:bundle>
</html>
