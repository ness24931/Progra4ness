<%-- 
    Document   : view_add_product
    Created on : 05/09/2020, 05:39:29 PM
    Author     : ADMIN
--%>

<%@page import="Model.List.List_category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	 <head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>JSP Page</title>
	 </head>
	 <body>
			<h1>Hello World!</h1>
			<form action="Control_AddProduct" method="GET">
				 <%
						List_category lista = (List_category) request.getAttribute("lista");
				 %>
				 <select name="categoria">
						<option value="-1">Categoria</option>
						<%
							 for (int i = 0; i < lista.size(); i++) {
						%>
						<option value="<%= i%>"><%= lista.get(i).getDescripcion()%></option>
						<% }%>
				 </select>
				 <input type="submit" name="bnt_addProduct" value="Agregar Producto">
			</form>
	 </body>
</html>
