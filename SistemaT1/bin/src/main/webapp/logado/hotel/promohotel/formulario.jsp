<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<fmt:bundle basename="messages">
<head>
<title>
	<fmt:message key="promocaoTitle"/>
</title>
</head>

<body>
	<div align="center">
		<h1><fmt:message key="promocaoTitle"/></h1>
		<h2>
			<a href="lista"><fmt:message key="promocaoList"/></a>
		</h2>
	</div>
	<div align="center">
		<c:choose>
			<c:when test="${promohotel != null}">
				<form action="atualizacao" method="post">
					<%@include file="campos.jsp"%>
				</form>
			</c:when>
			<c:otherwise>
				<form action="insercao" method="post">
					<%@include file="campos.jsp"%>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
            <c:if test="${mensagens.existeErros}">
                <div id="erro">
                    <ul>
                        <c:forEach var="erro" items="${mensagens.erros}">
                            <li> ${erro} </li>
                            </c:forEach>
                    </ul>
                </div>
            </c:if>
</body>
</fmt:bundle>
</html>
