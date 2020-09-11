<%-- 
    Document   : view_login
    Created on : 07/09/2020, 03:23:14 PM
    Author     : Emanuel Barrantes Guzmán
--%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="Control.Login_Controller"%>
<%@page import="Model.Model_login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body> 
        <% Model_login m = (Model_login) request.getAttribute("model_login");%>
        <form name="form" class="formulario_login" method="POST" action="Login_Controller">
            <div class="formulario_grupo"> 

                <label> Usuario</label>
                <input name="input_idUser"type="text"placeholder="Digite su usuario"> &nbsp;
            </div>
            <div class="formulario_grupo">
                <br>
                <label> Contraseña</label><br>
                <input name="input_password"type="password"placeholder="Digite su contraseña">
            </div>
            <div >
               
 <div ><button  style="margin-bottom: 15px">Ingresar</button> </div>
           
            </div>




        </form>
    </body>
</html>
<%!
    private Map<String,String[]>getForm(Model_login model_login)
{
Map<String,String[]> values = new HashMap<>();
values.put("input_idUser",new String[]{model_login.getUser().getId_user()});
values.put("input_password",new String[]{model_login.getUser().getPassword()});
return values;
}
    %>