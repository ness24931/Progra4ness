<%@page import="Model.Transmitter"%>
<%@page import="Model.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	 <head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>JSP Page</title>
	 </head>
	 <body>
			<%
				 Transmitter emisor = (Transmitter) request.getSession(false).getAttribute("emisor");
				 if (emisor != null) {
			%>

			<h1>Hello <%= emisor.getName()%> </h1>
			<% } else {
						response.sendRedirect(String.format("error.jsp?error=%s", "No se pudo ingresar"));
				 }%>
			<div>
				 <form method = "GET" action = "Main_Control">
						<input type = "submit"  name = "btn_option" value = "Agregar Cliente">
						<input type = "submit" name = "btn_option" value = "Agregar un Producto">
						<input type = "submit" name = "btn_option" value = "Perfil">
						<input type = "submit" name = "btn_option" value = "Facturar">
				 </form>
			</div>
	 </body>
</html >
