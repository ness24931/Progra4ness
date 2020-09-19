/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.DAO_Personal_Info;
import DAO.DAO_Ubication;
import DAO.DAO_User;
import IDAO.I_Personal_Info;
import IDAO.I_Ubication;
import IDAO.I_User;
import Model.Person;
import Model.Ubication;
import Model.User;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class Control_Signin extends HttpServlet {

	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
					 throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			try {
				 int type_id = Integer.valueOf(request.getParameter("type_id"));
				 String num_id = request.getParameter("dni");
				 String name_full = request.getParameter("name");
				 String num_tel = request.getParameter("num_tel");
				 String mail = request.getParameter("mail");
				 String tradename = request.getParameter("tradename");
				 String user = request.getParameter("user");
				 String pass = request.getParameter("pass");
				 String province = request.getParameter("province");
				 String canton = request.getParameter("canton");
				 String district = request.getParameter("district");
				 if (num_id == "" || name_full == "" || num_tel == "" || mail == ""
								 || tradename == "" || user == "" || pass == "" || province == "") {
						String msj = "Todos los campos deben ser rellenados";
						response.sendRedirect(String.format("error.jsp?error=%s", msj));
				 } else {
						Person p = new Person(
										num_id, name_full, num_tel, mail, tradename, type_id,
										new Ubication(0, province, canton, district, ""),
										new User(user, pass));
						I_Ubication ubi = new DAO_Ubication();
						if (ubi.create(p.getLocation())) {
							 I_User i_u = new DAO_User();
							 if (i_u.create(p.getUser())) {
									I_Personal_Info info = new DAO_Personal_Info();
									if (info.create(p)) {
										 response.sendRedirect("error.jsp?error=Registro completo");
									} else {
										 response.sendRedirect("error.jsp?error=Error al registrar la info");
									}
							 } else {
									response.sendRedirect("error.jsp?error=Error al registrar el user");
							 }
						} else {
							 response.sendRedirect("error.jsp?error=Error al registrar el usuario");
						}
				 }
			} catch (NumberFormatException ex) {
				 String msj = "Todos los campos deben ser rellenados";
				 response.sendRedirect(String.format("error.jsp?error=%s", msj));
				 System.err.println(Arrays.toString(ex.getStackTrace()));
			}
	 }

	 // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	 /**
	  * Handles the HTTP <code>GET</code> method.
	  *
	  * @param request servlet request
	  * @param response servlet response
	  * @throws ServletException if a servlet-specific error occurs
	  * @throws IOException if an I/O error occurs
	  */
	 @Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
					 throws ServletException, IOException {
			processRequest(request, response);
	 }

	 /**
	  * Handles the HTTP <code>POST</code> method.
	  *
	  * @param request servlet request
	  * @param response servlet response
	  * @throws ServletException if a servlet-specific error occurs
	  * @throws IOException if an I/O error occurs
	  */
	 @Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
					 throws ServletException, IOException {
			processRequest(request, response);
	 }

	 /**
	  * Returns a short description of the servlet.
	  *
	  * @return a String containing servlet description
	  */
	 @Override
	 public String getServletInfo() {
			return "Short description";
	 }// </editor-fold>

}
