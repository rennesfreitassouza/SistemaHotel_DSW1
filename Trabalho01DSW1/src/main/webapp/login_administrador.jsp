<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Administrador</title>
</head>

<body>
    <fmt:bundle basename="messages">
	    <form name="fomularioLoginAdministrador" action="TESTE.jsp" method="POST">
	        <fieldset>
	            <legend>
	            	<fmt:message key="Página"/>
	            	<fmt:message key="de"/> 
	            	<fmt:message key="login"/>
	            </legend>
	            <fmt:message key="Usuário"/>: 
	            <input type="text" name="strUsuario" /> <br />
	            <fmt:message key="Senha"/>:
	            <input type="password" name="senhaAdministrador" /> <br />
	            <input type="submit" name="enviar" value="<fmt:message key="Entrar"/> " />
	        </fieldset>
	    </form>
    </fmt:bundle>
</body>
</html>