/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.servlet;

import ergo.businesslogic.AssessmentService;
import ergo.businesslogic.FollowupService;
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
 */
public class FollowUpServlet extends HttpServlet {

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

        FollowupService fs = new FollowupService();

        String note = request.getParameter("identifiedRisks").trim(); //remember the names
        String comments = request.getParameter("workerComments").trim(); //remember the names 
        String recommendations = request.getParameter("recommendations").trim();

        boolean success = false;
        AssessmentService assService = new AssessmentService();
        int assessmentId = (int) session.getAttribute("assessmentId");

        try {
            int fsId = fs.insert(note, comments, recommendations);
            assService.updateFollow(assessmentId, fsId);
            success = true;
            request.setAttribute("message", "Successfully Inserted");
        } catch (Exception ex) {
            Logger.getLogger(FollowUpServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "An error has ocurred");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/notes/template.jsp").forward(request, response);

    }

}
