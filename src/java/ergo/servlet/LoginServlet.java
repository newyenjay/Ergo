package ergo.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ergo.businesslogic.EmployeeService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * LoginServlet is an HttpServlet that implements the Login use case for the program by using the
 * ergo.businesslogic package to validate the credentials passed from the jsp.
 * If the credentials are invalid, the session is cleared and the website is redirected to login
 * page with the appropriate message
 * If the credentials are valid and the Employee is not an admin, the website is redirected to the Search Page.
 * If the credentials are valid and the Employee is an admin, the website is redirected to the Manage Employees page.
 */
public class LoginServlet extends HttpServlet {

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

        String action = request.getParameter("action");
        EmployeeService es = new EmployeeService();

        if (action == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response); //Forwards the browser to the login jsp
        } else if (action.equals("logout")) {
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
        HttpSession session = request.getSession(); //Creates a HttpSession

        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        EmployeeService es = new EmployeeService();

        if (username.isEmpty() || username == null || password.isEmpty() || password == null) {
            //Return to the login page with an error message~ Gonna have to figure this one out because I don't know what to do here. 
            //How will you display the page? 
            request.setAttribute("message", "Please enter valid credentials in both fields."); //Changed the field to make it more fitting. 
            getServletContext().getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);
        }
        try {
            if (es.login(request, username, password)) {
                int isAdmin = (int) session.getAttribute("isAdmin");
                if (isAdmin == 1) { //Will redirect the user to the admin page. 
                    response.sendRedirect("admin");
                } else { //Will redirect the user to the user page. 
                    response.sendRedirect("search");
                }
            } else {
                request.setAttribute("message", "Invalid username or password");
                getServletContext().getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);

            }
        } catch (Exception ex) {
            Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "Server internal error, contact support");
            getServletContext().getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);

        }

        //Continue on by making the objects and such. 
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Handles the login for the login page. ";
    }// </editor-fold>

}
