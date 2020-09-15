<%-- 
    Document   : view_singin
    Created on : 11/09/2020, 03:54:31 PM
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
			<h1>Registro</h1>
			<div>
				 <form action="Control_Signin" method="GET">
						<select name="type_id" value="Tipo de identificación">
							 <option value="1">Física</option>
							 <option value="2">Jurídica</option>
						</select>
						<input type="text" name="dni" placeholder="Ingrese su número de cédula">
						<input type="text" name="name" placeholder="Ingrese su nombre completo">
						<input type="tel" name="num_tel" placeholder="Ingrese su número de teléfono">
						<input type="email" name="mail" placeholder="Ingrese su correo electrónico">
						<input type="text" name="tradename" placeholder="Ingrese el nombre de su negocio">
						<input type="text" name="user" placeholder="Ingrese un nombre de usuario">
						<input type="text" name="pass" placeholder="Ingrese una contraseña">
						<input type="text" name="province" placeholder="Provincia">
						<input type="text" name="canton" placeholder="Cantón">
						<input type="text" name="district" placeholder="Distrito">						
						<input type="submit" value="Registrarse">
				 </form>
			</div>
	 </body>
</html>
