/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.servlet;

import ergo.businesslogic.AssessmentService;
import ergo.businesslogic.SpmService;
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
public class SpmServlet extends HttpServlet {

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
        SpmService ss = new SpmService();

        //Booleans
        Boolean armAfBool = Boolean.parseBoolean(request.getParameter("armAfBool"));
        Boolean armBeBool = Boolean.parseBoolean(request.getParameter("armBeBool"));
        Boolean baseAfBool = Boolean.parseBoolean(request.getParameter("baseAfBool"));
        Boolean baseBeBool = Boolean.parseBoolean(request.getParameter("baseBeBool"));
        Boolean shoulderAfBool = Boolean.parseBoolean(request.getParameter("shoulderAfBool"));
        Boolean shoulderBeBool = Boolean.parseBoolean(request.getParameter("shoulderBeBool"));

        //Notes
        String armAfNotes = request.getParameter("armAfNotes");
        String armBeNotes = request.getParameter("armBeNotes");
        String baseAfNotes = request.getParameter("baseAfNotes");
        String baseBeNotes = request.getParameter("baseBeNotes");
        String shoulderAfNotes = request.getParameter("shoulderAfNotes");
        String shoulderBeNotes = request.getParameter("shoulderBeNotes");

        boolean success = false;
        AssessmentService assService = new AssessmentService();
        int assessmentId = (int) session.getAttribute("assessmentId");
        String action = request.getParameter("action");

        if (action.equals("add")) {
            try {
                int spmId = ss.insert(baseBeBool, baseBeNotes, baseAfBool, baseAfNotes, shoulderBeBool, shoulderBeNotes, shoulderAfBool, shoulderAfNotes, armBeBool, armBeNotes, armAfBool, armAfNotes);
                assService.updateSpm(assessmentId, spmId);
                success = true;
            } catch (Exception ex) {
                Logger.getLogger(PmbServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action.equals("update")) {
            int spmId = Integer.parseInt(request.getParameter("spmId"));
            try {
                ss.update(spmId, baseBeBool, baseBeNotes, baseAfBool, baseAfNotes, shoulderBeBool, shoulderBeNotes, shoulderAfBool, shoulderAfNotes, armBeBool, armBeNotes, armAfBool, armAfNotes);

                assService.updateSpm(assessmentId, spmId);
            } catch (Exception ex) {
                Logger.getLogger(DiscomfortServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
        response.sendRedirect("assessments");
    }

}
