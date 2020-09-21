<%-- 
    Document   : view_add_client
    Created on : 20/09/2020, 06:50:38 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	 <head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>JSP Page</title>
	 </head>
	 <body>
			<h1>Hello World!</h1>
			<form action="Control_AddClient" method="POST">
				 <select name="type_id" value="Tipo de identificación">
						<option value="1">Física</option>
						<option value="2">Jurídica</option>
				 </select>				 
				 <input type="text" name="dni" placeholder="Ingrese el número de cédula">
				 <input type="text" name="name" placeholder="Ingrese el nombre completo">
				 <input type="tel" name="num_tel" placeholder="Ingrese el número de teléfono">
				 <input type="email" name="mail" placeholder="Ingrese el correo electrónico">				 
				 <input type="text" name="province" placeholder="Provincia">
				 <input type="text" name="canton" placeholder="Cantón">
				 <input type="text" name="district" placeholder="Distrito">						
				 <input type="text" name="address" placeholder="Direccion (Opcional)">
				 <input type="submit" value="Agregar">
			</form>
	 </body>
</html>
