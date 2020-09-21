/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.DAO_Product;
import DAO.DAO_Transmitter;
import IDAO.I_Product;
import IDAO.I_Transmitter;
import Model.List.List_category;
import Model.Person;
import Model.Product;
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
public class Control_AddProduct extends HttpServlet {

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
			String detail = request.getParameter("detail");
			int category = Integer.valueOf(request.getParameter("category"));
			float price = Float.valueOf(request.getParameter("price"));
//			 ? categoria = 1 & detail =  & price =  & bnt_addProduct = Agregar + Producto;
			I_Product dao = new DAO_Product();
			HttpSession session = request.getSession(false);
			if (session != null) {
				 Transmitter emisor = (Transmitter) session.getAttribute("emisor");
				 if (emisor != null) {
						List_category categories = (List_category) session.getAttribute("categories");
						Product product = new Product(-1, detail, price, categories.get(category));
						if (dao.create(product, emisor.getDni())) {
//							 if (product.getId() != -1) {
//									I_Transmitter i_t = new DAO_Transmitter();
//									System.out.println(product.getId());
//									if (i_t.create(emisor, product)) {
										 response.sendRedirect("error.jsp?error=Ingresado&link=view_addProduct.jsp");
									} else {
										 response.sendRedirect("error.jsp?error=No se pudo relacionar su producto a su cuenta"
														 + "&link=view_addProduct.jsp");
									}
							 } else {
									response.sendRedirect("error.jsp?error=El emisor no se encuentra"
													+ "&link=view_addProduct.jsp");
							 }
						} else {
							 response.sendRedirect("error.jsp?error=Error en sesion&link=view_addProduct.jsp");
						}
//				 }
//				 List_category lista = (List_category) request.getAttribute("lista");
//			}

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
