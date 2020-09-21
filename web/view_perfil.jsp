<%-- 
    Document   : view_perfil
    Created on : 20/09/2020, 07:34:38 PM
    Author     : ADMIN
--%>

<%@page import="Model.Transmitter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	 <head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>JSP Page</title>
	 </head>
	 <body>
			<form action="Control_Perfil" method="Post">
				 <%
						Transmitter emisor = (Transmitter) request.getSession(false).getAttribute("emisor");
						if (emisor != null) {
				 %>
				 <h1>Hello World!</h1>
				 <input type="text" name="dni" placeholder="Ingrese su número de cédula" value="<%= emisor.getDni()%>" readonly>
				 <input type="text" name="name" placeholder="Ingrese su nombre completo" value="<%= emisor.getName()%>">
				 <input type="tel" name="num_tel" placeholder="Ingrese su número de teléfono" value="<%= emisor.getTelephone()%>">
				 <input type="email" name="mail" placeholder="Ingrese su correo electrónico" value="<%= emisor.getE_mail()%>">
				 <input type="text" name="tradename" placeholder="Ingrese el nombre de su negocio" value="<%= emisor.getTradename()%>">
				 <input type="text" name="user" placeholder="Ingrese un nombre de usuario" value="<%= emisor.getUser().getUser()%>" readonly>
				 <input type="text" name="pass" placeholder="Ingrese una contraseña" value="<%= emisor.getUser().getPass()%>">
				 <input type="text" name="province" placeholder="Provincia" value="<%= emisor.getLocation().getProvince()%>">
				 <input type="text" name="canton" placeholder="Cantón" value="<%= emisor.getLocation().getCanton()%>">
				 <input type="text" name="district" placeholder="Distrito" value="<%= emisor.getLocation().getDistrito()%>">
				 <input type="text" name="address" placeholder="Dirección" value="<%= emisor.getLocation().getAddress()%>">
				 <input type="submit" name="btn_updtPerfil" value="Actualizar Datos">
				 <% } else {
							 response.sendRedirect(String.format("error.jsp?error=%s", "No se pudo cargar su perfil"));
						}
				 %>
			</form>
	 </body>
</html>
