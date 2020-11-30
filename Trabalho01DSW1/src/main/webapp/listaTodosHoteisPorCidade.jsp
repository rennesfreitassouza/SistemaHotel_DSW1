<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="js/ajaxListagemPorCampoSelecao.js"></script>
    
	<title>Lista de hotéis de acordo com a cidade</title>
</head>
	<body>
		
		<jsp:useBean id='bean' class='src.br.ufscar.dc.dsw.bean.ListagemPorCidadeBean' />
		<fmt:bundle basename="messages">
			<div align="center">
				<h1>Hotéis por cidade</h1>
				<h2>
					<a href="login_administrador.jsp">Área para login de administrador</a>
					<a href="login_hoteis_reservas.jsp" title="área de acesso ao sistema de hotéis e sistema de reservas">Área para login de hotéis e sistema de reservas</a><br/>
				</h2>
			</div>
			
			<form name='form'>
					<table border="1" style="width: 400px; border: 1px solid black">
		                <tr>
		                    <td>Cidades com hotéis:</td>
		                    <td>
		                        <select id = 'cidade' name='cidade' onchange='cidadeSelecionada(this.value)'>
		                            <option value='--'>Selecione a cidade</option>
		                            <c:forEach items='${bean.getHotelPorCidade()}' var='cidade'>
		                                <option value='${cidade.getNomeCidade()}'>${cidade.getNomeCidade()}</option>
		                            </c:forEach>
		                        </select>
		                    </td>
		                </tr>
		                <tr id='hoteis'>    
                    		<td>
                        		Hotéis desta cidade:
                    		</td>
                    		<td>
                        		<select id='hotel' name='hotel' onchange='apresenta()'>
                        		</select>
                    		</td>   
                		</tr>
					</table>
			</form> <br/>
		</fmt:bundle>
	</body>
</html>