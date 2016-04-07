/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.servlet;

import ergo.businesslogic.FollowupService;
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
 * @version 1.0 Implemented basic code. 
 * @version 1.1 - Implemented error messages. 
 */
public class FollowUpServlet extends HttpServlet {
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
        //do a check on the user being logged in?
        getServletContext().getRequestDispatcher("/WEB-INF/notes/template.jsp").forward(request, response);    }

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
        
        FollowupService fs = new FollowupService();
        
        String note = request.getParameter("identifiedRisks").trim(); //remember the names
        String comments = request.getParameter("workerComments").trim(); //remember the names 
        String recommendations = request.getParameter("recommendations").trim();
        
        
        //checks to see if all the fields are filled in before attempting to continue on with the process. 
        if(note.isEmpty() || note == null || comments.isEmpty() || comments == null || recommendations.isEmpty() ||  recommendations == null){
            request.setAttribute("sucess", 0);
            request.setAttribute("message", "Please fill in at least one field before submitting the form");
            getServletContext().getRequestDispatcher("/WEB-INF/searchAdd/addClientCompany.jsp").forward(request, response);
            //Have a place to send the response to, still don't know where to send this to. Where do we go I don't know
            //this redirect is one of the thing's that's screwing me up dude. 
        }
       
        try {
            fs.insert(note, comments, recommendations);
            request.setAttribute("sucess", 1);
            request.setAttribute("message", "Successfully Inserted");
            getServletContext().getRequestDispatcher("/WEB-INF/searchAdd/addClientCompany.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(FollowUpServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("sucess", 0);
            request.setAttribute("message", "An error has ocurred");
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
