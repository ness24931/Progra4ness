/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.DAO_Categories;
import DAO.DAO_Person;
import DAO.DAO_Product;
import IDAO.I_Categories;
import IDAO.I_Person;
import IDAO.I_Product;
import Model.Factura;
import Model.List.List_Clients;
import Model.List.List_category;
import Model.ListProduct;
import Model.Person;
import Model.Product;
import Model.Transmitter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
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
public class Control_Fac_C extends HttpServlet {

	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
					 throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			Enumeration<String> parameterNames = request.getParameterNames();
			String param = parameterNames.nextElement();
			String[] split = param.split("btnAddC_");
			int i = Integer.valueOf(split[1]);
			HttpSession session = request.getSession(false);
			if (session != null) {
				 Transmitter emisor = (Transmitter) session.getAttribute("emisor");
				 List_Clients clients = (List_Clients) session.getAttribute("list_clients");
				 if (clients != null) {
						Person cliente = clients.getClientes().get(i);
						Factura f = new Factura(emisor, cliente);
						session.setAttribute("factura", f);
						I_Product dao = new DAO_Product();
						ListProduct lista = dao.read(emisor.getDni());
						if (lista != null) {
//						I_Categories dao = new DAO_Categories();
//						List_category lista = dao.read();
							 session.setAttribute("productos", lista);
							 request.getRequestDispatcher("view_facturar/view_fact_prod.jsp").forward(request, response);
						} else {
							 String msj = "No se encontraron productos asociados a su cuenta por favor agregue productos";
							 response.sendRedirect("error.jsp?error=" + msj + "link=../view_addProduct.jsp");
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
