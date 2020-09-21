/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.DAO_Categories;
import DAO.DAO_Person;
import IDAO.I_Categories;
import IDAO.I_Person;
import Model.List.List_Clients;
import Model.List.List_category;
import Model.Transmitter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class Main_Control extends HttpServlet {

	 /**
	  * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	  *
	  * @param request servlet request
	  * @param response servlet response
	  * @throws ServletException if a servlet-specific error occurs
	  * @throws IOException if an I/O error occurs
	  */
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
					 throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			String option = request.getParameter("btn_option");
			HttpSession session = request.getSession(false);
			switch (option) {
				 case "Agregar Cliente":
						request.getRequestDispatcher("view_add_client.jsp").forward(request, response);
						break;
				 case "Agregar un Producto":
						I_Categories dao = new DAO_Categories();
						List_category lista = dao.read();
						session.setAttribute("categories", lista);
//						request.setAttribute("lista", lista);
						request.getRequestDispatcher("view_addProduct.jsp").forward(request, response);
						break;
				 case "Perfil":

						break;
				 case "Facturar":
						Transmitter emisor = (Transmitter) session.getAttribute("emisor");
						if (emisor != null) {
							 I_Person daoP = new DAO_Person();
							 List_Clients clientes = daoP.searchClients(emisor.getDni());
//							 request.setAttribute("list_clients", clientes);
							 session.setAttribute("list_clients", clientes);
							 request.getRequestDispatcher("view_facturar/view_list_client.jsp").forward(request, response);
						}
						break;
				 default:
						break;
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
