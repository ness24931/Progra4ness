<%-- 
    Document   : view_login
    Created on : 07/09/2020, 03:23:14 PM
    Author     : Emanuel Barrantes Guzmán
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>   
<!--        <div class="img "><img src="img/background.jpeg" alt=""/></div>-->
        <form name="form" class="formulario_login" method="POST" action="Control_Login">
            <div class="formulario_grupo"> 
                <label> Usuario</label>
                <input name="input_idUser"type="text"placeholder="Digite su usuario"> &nbsp;
            </div>
            <div class="formulario_grupo">
                <br>
                <label> Contraseña</label><br>
                <input name="input_password"type="password"placeholder="Digite su contraseña">
            </div>
            <div>
                <div>
																				<input type="submit" value="Aceptar" style="margin-bottom: 15px">
																				<a class="boton" href="view_singin.jsp">Registrarse</a>
																</div>
												</div>          
        </form>
    </body>
</html>