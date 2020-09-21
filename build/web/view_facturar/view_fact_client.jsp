<%-- 
    Document   : view_facturar
    Created on : 20/09/2020, 08:28:50 PM
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
			<div>
				 <form action="Control_Facturar" method="POST">
						<input type="submit" name="btn_buscar" value="Buscar Cliente">
				 </form>
				 <form action="Control_Facturar" method="POST">
						<select name="tipo_id"></select>
						<input type="text" name="id" placeholder="Número de identificación">
						<input type="text" name="name" placeholder="Nombre completo">
						<input type="tel" name="num_tel" placeholder="Número de teléfono">
						<input type="email" name="mail" placeholder="Correo electrónico">				 
						<input type="text" name="province" placeholder="Provincia">
						<input type="text" name="canton" placeholder="Cantón">
						<input type="text" name="district" placeholder="Distrito">						
						<input type="text" name="address" placeholder="Direccion (Opcional)">
						<input type="submit" name="btn_next" value="Siguiente">
				 </form>
			</div>

	 </body>
</html>
