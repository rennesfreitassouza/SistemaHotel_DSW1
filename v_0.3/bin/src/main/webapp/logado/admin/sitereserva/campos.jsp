<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:bundle basename="messages">
<table border="1">
	<caption>
		<c:choose>
			<c:when test="${sitereserva != null}">
                <fmt:message key="edit"/>
            </c:when>
			<c:otherwise>
                <fmt:message key="cadastro"/>
            </c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${sitereserva != null}">
		<input type="hidden" name="id" value="${sitereserva.id}" />
	</c:if>
	<tr>
		<td><label for="url">Url</label></td>
		<td><input type="text" id="url" name="url" size="45"
			required value="${sitereserva.url}" /></td>
	</tr>
	<tr>
		<td><label for="nome"><fmt:message key="nome"/></label></td>
		<td><input type="text" id="nome" name="nome" size="45" 
			required value="${sitereserva.nome}" /></td>
	</tr>

	<tr>
		<td><label for="telefone"><fmt:message key="telefone"/></label></td>
		<td><input type="text" id="telefone" name="telefone" size="45"
			required value="${sitereserva.telefone}" /></td>
	</tr>
	<tr>
		<td><label for="email"><fmt:message key="email"/></label></td>
		<td><input type="text" id="email" name="email" 
			required value="${sitereserva.email}" /></td>
	</tr>
	<tr>
		<td><label for="senha"><fmt:message key="senha"/></label></td>
		<td><input type="text" id="senha" name="senha" 
			required value="${sitereserva.senha}" /></td>
	</tr>
	<tr>
		<fmt:message key="save" var="saveMessage"/>
		<td colspan="2" align="center"><input type="submit" value="${saveMessage}" /></td>
	</tr>
</table>
</fmt:bundle>
