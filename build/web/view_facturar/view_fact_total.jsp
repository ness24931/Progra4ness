<%-- 
    Document   : view_fact_total
    Created on : 20/09/2020, 08:48:35 PM
    Author     : ADMIN
--%>

<%@page import="Model.ListProduct"%>
<%@page import="java.util.List"%>
<%@page import="Model.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	 <head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>JSP Page</title>
	 </head>
	 <body>
			<jsp:useBean class="Model.Factura" id="factura" scope="session" ></jsp:useBean>
				 <h1>Total</h1>
				 <table border="1">
						<thead>
							 <tr>
									<th>Tipo de identificación</th>
									<th>Número de cédula</th>
									<th>Nombre completo</th>
									<th>Número de teléfono</th>
									<th>E-Mail</th>
									<th>Provincia</th>
									<th>Cantón</th>
									<th>Distrito</th>
									<th>Dirección</th>									
							 </tr>
						</thead>
						<tbody>						
							 <tr>
							 <%
									String type = "";
									if (factura.getCliente().getId_type() == 1) {
										 type = "Físico";
									} else if (factura.getCliente().getId_type() == 2) {
										 type = "Jurídico";
									}
							 %>
							 <td><%= type%></td>
							 <td><%= factura.getCliente().getDni()%></td>
							 <td><%= factura.getCliente().getName()%></td>
							 <td><%= factura.getCliente().getTelephone()%></td>
							 <td><%= factura.getCliente().getE_mail()%></td>
							 <td><%= factura.getCliente().getLocation().getProvince()%></td>
							 <td><%= factura.getCliente().getLocation().getCanton()%></td>
							 <td><%= factura.getCliente().getLocation().getDistrito()%></td>
							 <td><%= factura.getCliente().getLocation().getAddress()%></td>							 							 
						</tr>												
				 </tbody>
			</table>
			<table border="1">
				 <%
						ListProduct productos = factura.getProductos();
				 %>
				 <thead>
						<tr>
							 <th>Categoria</th>
							 <th>Detalle</th>
							 <th>Precio</th>							 
							 <th>I.V.A.</th>
							 <th>Cantidad</th>
							 <th>Total</th>
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
							 <td><%= productos.get(i).getCantidad()%></td>
							 <%
									float t = productos.get(i).getCantidad() * productos.get(i).getPrice();
									float iva = productos.get(i).getCategory().getIva() * t;
							 %>
							 <td><%= productos.get(i).getTotal()%></td>
						</tr>
						<%
							 }
						%>
						<tr>
							 <td>Total de la factura</td>
							 <td><%= factura.getTotal()%></td>
						</tr>
				 </tbody>
			</table>
			<form action="Control_Facturar" method="GET">
				 <input type="submit" name="btn_next" value="Ingresar otro producto"> 
			</form>
	 </body>
</html>
