<%-- 
    Document   : view_fact_prod
    Created on : 20/09/2020, 08:48:20 PM
    Author     : ADMIN
--%>

<%@page import="Model.ListProduct"%>
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
			<div>
				 <form action="Control_Fac_P" method="GET">
						<jsp:useBean class="Model.ListProduct" id="productos" scope="session"></jsp:useBean>				 
							 <table border="1">
									<thead>
										 <tr>
												<th>Categoria</th>
												<th>Descripción</th>
												<th>Precio</th>
												<th>I.V.A.</th>
												<th>Cantidad(unidades)</th>
												<th></th>									
										 </tr>
									</thead>
									<tbody>
									<%
										 for (int i = 0; i < productos.size(); i++) {
									%>
									<tr>
										 <td><%= productos.get(i).getCategory().getDescripcion()%></td>
										 <td><%= productos.get(i).getDetail()%></td>
										 <td><%= productos.get(i).getPrice()%></td>									
										 <td><%= productos.get(i).getCategory().getIva() * 100%>%</td>
										 <td><input name="cantidad_<%= i%>" type="number" min="0" step="1"></td>
										 <td><input name="btnAdd_<%= i%>" type="submit" value="Agregar"></td>
									</tr>
									<% }%>							 
							 </tbody>
						</table>
				 </form>
				 <form action="Control_Facturar" method="GET">
						<input type="submit" name="btn_next" value="Total">
				 </form>
			</div>
	 </body>
</html>
