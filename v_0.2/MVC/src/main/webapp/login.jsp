<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <fmt:bundle basename="messages">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <fmt:message key="loginTitle"/>
        </title>
        <link href="${pageContext.request.contextPath}/layout.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
            <h1><fmt:message key="loginTitle"/></h1>
            <c:if test="${mensagens.existeErros}">
                <div id="erro">
                    <ul>
                        <c:forEach var="erro" items="${mensagens.erros}">
                            <li> ${erro} </li>
                            </c:forEach>
                    </ul>
                </div>
            </c:if>
            <form method="post" action="login_admin.jsp">
                <table>
                    <tr>
                        <th><fmt:message key="entrar"/>: </th>
                        <td><input type="text" name="login"
                                   value="${param.login}"/></td>
                    </tr>
                    <tr>
                        <th><fmt:message key="senha"/>: </th>
                        <td><input type="password" name="senha" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"> 
                            <fmt:message key="entrar" var="entrarMessage"/>
                            <input type="submit" name="bOK" value="${entrarMessage}"/>
                        </td>
                    </tr>
                </table>
            </form>
            <form method="post" action="index.jsp">
            	<tr>
                	<td colspan="2">
                        <fmt:message key="voltar" var="voltarMessage"/>
                        <input type="submit" name="voltar" value="${voltarMessage}"/>
                    </td>
                </tr>
            </form>
    </body>
    </fmt:bundle>
</html>
