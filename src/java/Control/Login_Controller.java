/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.DAO_User;
import Logic.User;
import java.io.IOException;
import Model.Model_login;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Emanuel Barrantes Guzmán
 */
@WebServlet(name = "Login_Controller", urlPatterns = {"/Login_Controller"})
public class Login_Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        request.setAttribute("Model_login", new Model_login());
    request.getRequestDispatcher("view_perfil.jsp").forward(request, response);
    String user=request.getParameter("input_idUsuario");
     String password=request.getParameter("input_password");
     validate_user(user,password,request);
    
    }
    public void validate_user(String user,String password,HttpServletRequest request)
    {
        DAO_User dao = new DAO_User();
        
        try {
            User us=dao.return_User(new User (user,password));
            HttpSession session = request.getSession(true);
            if(us!=null)
            {
                 session.setAttribute("user", us);
            }
           else
            {
                session.setAttribute("user", "usuario no encontrado =( ");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private String login(HttpServletRequest request) {
        //pendiente validación
        return "index.jsp";
 }
    void updateModel(HttpServletRequest request) {
       Model_login model = (Model_login)request.getAttribute("Model_login");
       model.getUser().setId_user(request.getParameter("input_user"));
       model.getUser().setPassword(request.getParameter("input_password"));
        
    }
   public String loginAction(HttpServletRequest request) throws SQLException
   {
       Model_login model_login = (Model_login) request.getAttribute("Model_login");
       Logic.model domainModel = Logic.model.instance();
         HttpSession session = request.getSession(true);
         try
         {
             User real = domainModel.user_find(model_login.getUser().getId_user(),model_login.getUser().getPassword());
             session.setAttribute("user", real);
             String viewUrl="";
             return viewUrl = "index.jsp";
             
             
         }catch(Exception ex)
         {
             return"index.jsp";
         }}
          public String logout(HttpServletRequest request) throws SQLException {
        return this.loginAction(request);
   }
public String logoutAction(HttpServletRequest request)
{
  HttpSession session = request.getSession(true);
  session.removeAttribute("user");
  session.invalidate();
return "index.jsp" ; 
}
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
              
   