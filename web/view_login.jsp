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
        
        <form class="formulario_login" method="POST" action="">
            <div class="formulario_grupo">
                
                <label> Usuario</label><br>
                <input class="formulario_control"name="input_user"type="text"placeholder="Digite su usuario"> &nbsp;
                  </div>
                 <div class="formulario_grupo">
                     
                 <label> Contraseña</label><br>
                 <input class="formulario_control"name="input_password"type="password"placeholder="Digite su contraseña">
                  </div>
                   <div class="panel_boton">
                  <input type="submit" name = "boton_login" value = "Aceptar">
                  </div>
                 <div class="formulario_grupo">
               <label>
                Sea parte de nuestros clientes</label>
                  
                </div>
            <div >
                  <a href ="" class="panel_boton" >Registrarse</a>
                 </div> 
                
                
        </form>
    </body>
</html>
