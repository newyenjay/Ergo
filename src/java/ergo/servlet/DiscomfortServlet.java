/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.servlet;

import ergo.businesslogic.AssessmentService;
import ergo.businesslogic.DiscomfortService;
import java.io.IOException;
import java.io.PrintWriter;
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
 * 
 * The Servlet Assessment page is in charge of the "Discomfort" tab in the assessment tab. 
 * I don't know what this name is hooked up to. 
 */
public class DiscomfortServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        boolean success = false;
        AssessmentService assService = new AssessmentService();
        int assessmentId = (int) session.getAttribute("assessmentId") ;
        
        try {
            //Attempt to insert into the database 
            int discomforId = ds.insert(notes);
            assService.updateDiscomfort(assessmentId, discomforId);
            request.setAttribute("message", "successfully inserted");
            success =true;
            
        } catch (Exception ex) {
            //Something goes wrong with the insertion
            Logger.getLogger(DiscomfortServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "An error has ocurred");
        }
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/notes/template.jsp").forward(request, response);

    }

    

}
