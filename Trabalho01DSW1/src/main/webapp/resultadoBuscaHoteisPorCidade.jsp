<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="src.br.ufscar.dc.dsw.domain.Cidade" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
	<title>Lista de hotéis de acordo com a cidade</title>
</head>
	<body>
		
		<fmt:bundle basename="messages">
			<div align="center">
				<h1>Lista de hotéis de acordo com a cidade</h1>
				<h2>
					<a href="login_administrador.jsp">Área para login de administrador</a>
					<a href="login_hoteis_reservas.jsp" title="área de acesso ao sistema de hotéis e sistema de reservas">Área para login de hotéis e sistema de reservas</a><br/>
				</h2>
			</div>
			<%
		    String strCidade = request.getParameter("teste");
		    
		    
			%>
			<form name='form'>
					<table border="1" style="width: 400px; border: 1px solid black">
		                <tr>
		                    <td>Hotéis disponíveis na cidade <%= strCidade%></td>
		                    <td>
		                        
		                    </td>
		                </tr>
					</table>
			</form> <br/>
		</fmt:bundle>
	</body>
</html>