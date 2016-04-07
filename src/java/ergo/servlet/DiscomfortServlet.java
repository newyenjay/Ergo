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
      getServletContext().getRequestDispatcher("/WEB-INF/notes/template.jsp").forward(request, response);
        
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
            request.setAttribute("sucess", 0);
            request.setAttribute("message", "Please fill in at least one field before submitting the form");
            getServletContext().getRequestDispatcher("/WEB-INF/searchAdd/addClientCompany.jsp").forward(request, response); 
        }
        
        try {
            //Attempt to insert into the database 
            ds.insert(notes);
            request.setAttribute("sucess", 1);
            request.setAttribute("message", "successfully inserted");
            getServletContext().getRequestDispatcher("/WEB-INF/searchAdd/addClientCompany.jsp").forward(request, response);
            
        } catch (Exception ex) {
            //Something goes wrong with the insertion
            Logger.getLogger(DiscomfortServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("sucess", 0);
            request.setAttribute("message", "An error has ocurred");
            getServletContext().getRequestDispatcher("/WEB-INF/searchAdd/addClientCompany.jsp").forward(request, response); //redirect to the main page with an error
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
