/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Factura;
import Model.ListProduct;
import Model.Product;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Control_Fac_P extends HttpServlet {

	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
					 throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			Enumeration<String> parameterNames = request.getParameterNames();
			String[] split = null;
			while (parameterNames.hasMoreElements()) {
				 String aux = parameterNames.nextElement();
				 if (aux.contains("btnAdd_")) {
						split = aux.split("btnAdd_");
				 }
			}
			int i = Integer.valueOf(split[1]);
			int cant = Integer.valueOf(request.getParameter("cantidad_" + i));
			HttpSession session = request.getSession(false);
			if (session != null) {
				 ListProduct productos = (ListProduct) session.getAttribute("productos");
				 Factura f = (Factura) session.getAttribute("factura");

//				 Logger LOGGER = Logger.getLogger(Control_Fac_P.class.getName());
//				 f.getProductos().stream().forEach(elem -> LOGGER.info(elem.getDetail() + "   " + String.valueOf(elem.getCantidad())));

				 if (productos != null && f != null) {
						Product p_new = productos.get(i);
						Product p_old = f.getProductos().search(p_new.getId());
						if (p_old == null) {
							 p_new.setCantidad(cant);
							 f.getProductos().add(p_new);
						} else {
							 p_old.setCantidad(p_old.getCantidad() + cant);
						}
//						session.setAttribute("factura", f);
						request.getRequestDispatcher("view_facturar/view_fact_prod.jsp").forward(request, response);
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
