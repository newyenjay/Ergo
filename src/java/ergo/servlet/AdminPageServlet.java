/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.servlet;

import ergo.businesslogic.EmployeeService;
import ergo.dataacess.EmployeeRepository;
import ergo.domainmodel.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kimberly Oshiro
 */
public class AdminPageServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        List<Employee> empList = null;
        EmployeeService es = new EmployeeService();
	int role = (int)session.getAttribute("isAdmin");
	
        if(role != 1){
            response.sendRedirect("main");
        }
        
        
        if (action == null) {
            Employee e = (Employee) session.getAttribute("currentUser");

            if (e == null) {
                getServletContext().getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);
            } else {
                try {
                    empList = es.getAll();
                    request.setAttribute("users", empList);
                } catch (Exception ex) {
                      Logger.getLogger(AdminPageServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                getServletContext().getRequestDispatcher("/WEB-INF/admin/manageUsers.jsp").forward(request, response); //Forwards the browser to the login jsp
            }

        } else {
            es.logout(request);
            request.setAttribute("message", "Logged Out");
            getServletContext().getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);

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
        HttpSession session = request.getSession();    
        

    }

}
