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
				 Person p = (Person) request.getSession(false).getAttribute("person");
				 if (p != null) {
			%>

			<h1>Hello <%= p.getName()%> </h1>
			<% } else {
						response.sendRedirect(String.format("error.jsp?error=%s", "No se pudo ingresar"));
				 }%>
			<div>
				 <form method = "GET" action = "Main_Control">
						<input type = "submit"  name = "btn_option" value = "Agregar Cliente">
						<input type = "submit" name = "btn_option" value = "Agregar un Producto"> 						
				 </form>
			</div>
	 </body>
</html >
