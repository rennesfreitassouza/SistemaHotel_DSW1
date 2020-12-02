<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<fmt:bundle basename="messages">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="loginAdminTitle"/></title>
    </head>
    <body>
     <h1><fmt:message key="loginAdminTitle"/></h1>
     <p><fmt:message key="hello"/> ${sessionScope.usuarioLogado.nome}</p>

	    <ul>
	    	<li>
	        	<a href="hoteis/"><fmt:message key="formularioAdminHotelTitle"/></a>
	        </li>
	        
	        <li>
	        	<a href="reservas/"><fmt:message key="formularioAdminSiteReservaTitle"/></a>
	        </li>
	        
        </ul>

        <a href="${pageContext.request.contextPath}/logout.jsp"><fmt:message key="logout"/></a>
    </body>
</fmt:bundle>
</html>
