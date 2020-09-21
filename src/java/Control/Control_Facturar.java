package Control;

import Model.Factura;
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

public class Control_Facturar extends HttpServlet {

	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
					 throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			String opc = request.getParameter("btn_next");
			switch (opc) {
				 case "Siguiente":
						addCliente(request, response);
						break;
				 case "Total":
						request.getRequestDispatcher("view_facturar/view_fact_total.jsp").forward(request, response);
						break;
				 case "Ingresar otro producto":
						request.getRequestDispatcher("view_facturar/view_fact_prod.jsp").forward(request, response);
						break;
				 default:
						break;
			}
	 }

	 private void addCliente(HttpServletRequest request, HttpServletResponse response)
					 throws ServletException, IOException {
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
							|| mail.equals("") || province.equals("") || canton.equals("") || district.equals("")) {
				 String msj = "Todos los campos deben ser rellenados";
				 response.sendRedirect(String.format("error.jsp?error=%s", msj));
			} else {
				 HttpSession session = request.getSession(false);
				 if (session != null) {
						Transmitter emisor = (Transmitter) session.getAttribute("emisor");
						if (emisor != null) {
							 Person receptor = new Person(num_id, name_full, num_tel, mail, type_id,
											 new Ubication(0, province, canton, district, address));
							 Factura factura = new Factura(emisor, receptor);
							 session.setAttribute("factura", factura);
						} else {
							 String msj = "Todos los campos deben ser rellenados";
							 response.sendRedirect(String.format("error.jsp?error=%s", msj));
						}
				 } else {
						String msj = "Todos los campos deben ser rellenados";
						response.sendRedirect(String.format("error.jsp?error=%s", msj));
				 }
			}
			request.getRequestDispatcher("view_fact_prod.jsp").forward(request, response);
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
