<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <fmt:bundle basename="messages">
    <head>
        <title>
            <fmt:message key="erro"/>
        </title>
    </head>
    <body>
        <center>
            <h1><fmt:message key="erro"/></h1>
            <h2><%= exception.getMessage()%><br/> </h2>
        </center>	
    </body>
    </fmt:bundle>
</html>
