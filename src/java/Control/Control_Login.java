/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.DAO_User;
import Model.User;
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
public class Control_Login extends HttpServlet {

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
								String user = request.getParameter("input_idUser");
								String pass = request.getParameter("input_password");
								if (user.isEmpty() || pass.isEmpty()) {
												response.sendRedirect("index.jsp");
								} else {
												DAO_User dao = new DAO_User();
												if (dao.validate(user, pass)) {
																request.getRequestDispatcher("view_principal.jsp").forward(request, response);
												} else {
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
