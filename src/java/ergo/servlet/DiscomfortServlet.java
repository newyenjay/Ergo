/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.servlet;

import ergo.businesslogic.DiscomfortService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        DiscomfortService ds = new DiscomfortService();
        String notes = request.getParameter("notes").trim();
        
        if(notes.isEmpty() || notes == null){
            notes = null; 
            request.setAttribute("message", "Please fill in at least one field before submitting the form");
            getServletContext().getRequestDispatcher("/WEB-INF/searchAdd/addClientCompany.jsp").forward(request, response); //will have to figure out the URL for this. 
        }
        
        try {
            //insert into the database then
            if((ds.insert(notes)) == 1){
//            //return a message of success.
                request.setAttribute("message", "successfully inserted");
                getServletContext().getRequestDispatcher("/WEB-INF/searchAdd/addClientCompany.jsp").forward(request, response);
            }
            else{
                request.setAttribute("message", "something went wrong");
                getServletContext().getRequestDispatcher("/WEB-INF/searchAdd/addClientCompany.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(DiscomfortServlet.class.getName()).log(Level.SEVERE, null, ex);
            getServletContext().getRequestDispatcher("/WEB-INF/searchAdd/addClientCompany.jsp").forward(request, response);
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
