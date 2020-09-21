/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.DAO_Person;
import DAO.DAO_Ubication;
import IDAO.I_Person;
import IDAO.I_Ubication;
import Model.Person;
import Model.Transmitter;
import Model.Ubication;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class Control_AddClient extends HttpServlet {

	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
					 throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			int type_id = Integer.valueOf(request.getParameter("type_id"));
			String num_id = request.getParameter("dni");
			String name_full = request.getParameter("name");
			String num_tel = request.getParameter("num_tel");
			String mail = request.getParameter("mail");
			String province = request.getParameter("province");
			String canton = request.getParameter("canton");
			String district = request.getParameter("district");
			String address = request.getParameter("address");
			if (num_id.equals("") || name_full.equals("") || num_tel.equals("")
							|| mail.equals("") || province.equals("")) {
				 String msj = "Todos los campos deben ser rellenados";
				 response.sendRedirect(String.format("error.jsp?error=%s", msj));
			} else {
				 HttpSession session = request.getSession(false);
				 Ubication ubication = new Ubication(0, province, canton, district, address);
				 if (session != null) {
						Transmitter emisor = (Transmitter) session.getAttribute("emisor");
						if (emisor != null) {
							 I_Ubication dao_u = new DAO_Ubication();
							 if (dao_u.create(ubication)) {
									I_Person dao = new DAO_Person();
									if (dao.create(new Person(
													num_id, name_full, num_tel, mail, type_id, ubication),
													emisor.getDni())) {
										 response.sendRedirect("error.jsp?error=Registro completo&link=view_add_client.jsp");
									} else {
										 response.sendRedirect("error.jsp?error=No se pudo registrar al cliente&link=view_add_client.jsp");
									}
							 } else {
									response.sendRedirect("error.jsp?error=No se pudo registrar al cliente&link=view_add_client.jsp");
							 }
						}
				 }
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
