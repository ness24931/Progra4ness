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
						HttpSession s = request.getSession(false);
						if (s != null) {
							 List_category lista = (List_category) s.getAttribute("categories");
				 %>
				 <select name="category">
						<option value="-1">Categoria</option>
						<%
							 for (int i = 0; i < lista.size(); i++) {
									int d = (int) (lista.get(i).getIva() * 100);
						%>
						<option value="<%= i%>">
							 <%= String.format("%1$s\tIVA: %2$d%3$s",
											 lista.get(i).getDescripcion(), d, "%")%>
						</option>
						<% }
							 }%>
				 </select>
				 <label for="txt_detail">Detalle del producto: </label>
				 <input type="text" id="txt_detail" name="detail">
				 <label for="txt_price">Precio: </label>
				 <input type="number" id="txt_price" min="1" name="price">				
				 <input type="submit" name="bnt_addProduct" value="Agregar Producto">				 

			</form>
	 </body>
</html>
