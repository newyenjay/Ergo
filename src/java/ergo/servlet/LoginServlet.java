package ergo.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 680420
 */

public class LoginServlet extends HttpServlet {

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
        getServletContext().getRequestDispatcher("/login/login.jsp").forward(request, response); //Forwards the browser to the login jsp
        
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
        
        
        if(username.isEmpty() || username == null || password.isEmpty() || password == null){
            //Return to the login page with an error message~ Gonna have to figure this one out because I don't know what to do here. 
            //How will you display the page? 
            request.setAttribute("message", "Please enter valid credentials in both fields."); //Changed the field to make it more fitting. 
            getServletContext().getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);
        }
        
        if(username.equals("admin") || password.equals("password")){
            response.sendRedirect("main");
            //Slapstick attempt at validation. Here we go, Until we have a version of the database up that is actually working and running, there isn't much I can do here....
            //I'm hopging the database objects that I have to work with will be easy.
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
