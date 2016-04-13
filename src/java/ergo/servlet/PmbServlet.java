/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.servlet;

import ergo.businesslogic.AssessmentService;
import ergo.businesslogic.PmbService;
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
 * @author 671402
 */
public class PmbServlet extends HttpServlet {

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
        PmbService ps = new PmbService();

        //Booleans
        Boolean goalMetBool = Boolean.parseBoolean(request.getParameter("goalMetBool"));
        Boolean educBool = Boolean.parseBoolean(request.getParameter("educBool"));
        Boolean microBeBool = Boolean.parseBoolean(request.getParameter("microBeBool"));
        Boolean microAfBoool = Boolean.parseBoolean(request.getParameter("microAfBool"));

        //Notes
        String goalMetNotes = request.getParameter("goalMetNotes");
        String educNotes = request.getParameter("educNotes");
        String microBeNotes = request.getParameter("microBeNotes");
        String microAfNotes = request.getParameter("microAfNotes");

        boolean success = false;
        AssessmentService assService = new AssessmentService();
        int assessmentId = (int) session.getAttribute("assessmentId");

        String action = request.getParameter("action");

        if (action.equals("add")) {
            try {
                int pmbId = ps.insert(goalMetBool, goalMetNotes, educBool, educNotes, microBeBool, microBeNotes, microAfBoool, microAfNotes);
                assService.updatePmb(assessmentId, pmbId);
                success = true;

            } catch (Exception ex) {
                Logger.getLogger(PmbServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action.equals("update")) {
            int pmbId = Integer.parseInt(request.getParameter("pmbId"));
            try {
                ps.update(pmbId, goalMetBool, goalMetNotes, educBool, educNotes, microBeBool, microBeNotes, microAfBoool, microAfNotes);
                assService.updatePmb(assessmentId, pmbId);
            } catch (Exception ex) {
                Logger.getLogger(DiscomfortServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        response.sendRedirect("assessments");

    }

}
