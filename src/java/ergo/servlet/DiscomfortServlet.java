/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.servlet;

import ergo.businesslogic.DiscomfortService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kimberly Oshiro
 * 
 * The Servlet Assessment page is in charge of the "Discomfort" tab in the assessment tab. 
 * I don't know what this name is hooked up to. 
 */
public class DiscomfortServlet extends HttpServlet {
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
      //does there need to be any checking on the JSP?
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
        
        String notes = request.getParameter("notes").trim();
        
        if(notes.isEmpty() || notes == null){
            request.setAttribute("message", "Please fill in some notes before attempting to save to the database");
            getServletContext().getRequestDispatcher("/WEB-INF/notes/discomfort.jsp").forward(request, response); //will have to figure out the URL for this. 
        }
        
        //insert into the database then
        DiscomfortService ds = new DiscomfortService();
        if((ds.insert(notes)) == 1){
//            //return a message of success. 
             //redirect to the jsp page
        }
        else{
            //redirect with an error 
        }
        

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
