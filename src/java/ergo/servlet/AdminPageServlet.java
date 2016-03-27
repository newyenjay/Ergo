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
        int role = (int) session.getAttribute("isAdmin");

        if (role != 1) {
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
        getServletContext().getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);

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
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        EmployeeService es = new EmployeeService();

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "view":
                try {
                 Employee selectedUser = es.getEmployee(username);
                 request.setAttribute("selectedUser", selectedUser);
                 } catch (Exception ex) {
                 //why isnt there anything here i dont remember
                 }
                break;

            case "add":
                try {
                    es.insert(username, firstname, lastname, password, email);
                    request.setAttribute("message", "User added.");
                } catch (Exception ex) {
                    request.setAttribute("message", ex.toString());
                }
                break;

            case "delete":
                try {
                    es.delete(username);
                    request.setAttribute("message", "User deleted.");
                } catch (Exception ex) {
                request.setAttribute("message", "Error: User could not be deleted!");
                }
                break;

            case "edit":
                try {
                    es.update(username, firstname, lastname, password, email);
                    request.setAttribute("message", "User updated.");
                 } catch (Exception ex) {
                 request.setAttribute("message", "Error: User could not be updated!");
                 }
                break;

            default:
                break;
        }
        
        try {
            List<Employee> employees = es.getAll();
            request.setAttribute("users", employees);
        } catch (Exception ex) {
            
        }

        getServletContext().getRequestDispatcher("/WEB-INF/admin/manageUsers.jsp").forward(request, response); //Forwards the browser to the login jsp

    }

}
