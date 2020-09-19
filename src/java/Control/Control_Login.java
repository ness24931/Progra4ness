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
import Model.Province;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class Control_Login extends HttpServlet {

	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
					 throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			String user = request.getParameter("input_idUser");
			String pass = request.getParameter("input_password");
			if (user.isEmpty() || pass.isEmpty()) {
				 response.sendRedirect("index.jsp");
			} else {
				 I_User dao = new DAO_User();
				 if (dao.validate(user, pass)) {
						I_Personal_Info person = new DAO_Personal_Info();
						Person p = person.searchUser(user);
						if (p != null) {
							 HttpSession session = request.getSession(false);
							 session.setAttribute("person", p);
							 request.getRequestDispatcher("view_principal.jsp").forward(request, response);
						} else {
							 response.sendRedirect("index.jsp");
						}
				 } else {
						I_Ubication dao_u = new DAO_Ubication();
						List<Province> provinces = dao_u.provinces();
						request.setAttribute("provinces", provinces);
						request.getRequestDispatcher("view_singin.jsp").forward(request, response);
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
