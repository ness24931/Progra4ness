<%-- 
    Document   : error
    Created on : 15/09/2020, 01:38:38 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	 <head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Error</title>
	 </head>
	 <body>
			<%
				 String msj = request.getParameter("error");
				 String link = request.getParameter("link");
				 if (link == null || link.isEmpty()) {
						link = "index.jsp";
				 }
			%>
			<h1> <%=msj%></h1>
			<a href="<%= link%>">Volver al inicio</a>
	 </body>
</html>
