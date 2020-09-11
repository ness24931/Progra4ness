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
												<form action="#" method="POST">
																<select name="type_id" value="Tipo de identificación">
																				<option value="1">Física</option>
																				<option value="2">Jurídica</option>
																</select>
																<input type="text" name="num_id" placeholder="Ingrese su número de cédula">
																<input type="text" name="name_full" placeholder="Ingrese su nombre completo">
																<input type="tel" name="num_tel" placeholder="Ingrese su número de teléfono">
																<input type="email" name="mail" placeholder="Ingrese su correo electrónico">
																<input type="text" name="tradename" placeholder="Ingrese el nombre de su negocio">

																<input type="text" name="user" placeholder="Ingrese un nombre de usuario">
																<input type="text" name="pass" placeholder="Ingrese una contraseña">
																<select name="province" value="Provincia">
																				<option>provincia</option>
																</select>
												</form>
								</div>
    </body>
</html>
