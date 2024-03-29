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
 * FollowUpServlet is an HttpServlet that implements the Add FollowUp use case for the program by retrieving the
 * information from the jsp and using the ergo.businesslogic package to manipulate the database with the help of JPA.
 * If an FollowUp object does not exist in the assessment, a new FollowUp object is created and added in to the assessments table.
 * If an FollowUp object exists in the assessment, the existing FollowUp object is modified and updated in to the database.
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
        String action = request.getParameter("action");

        if (action.equals("add")) {
            try {
                int fsId = fs.insert(note, comments, recommendations);
                assService.updateFollow(assessmentId, fsId);
                success = true;
                request.setAttribute("message", "Successfully Inserted");
            } catch (Exception ex) {
                Logger.getLogger(FollowUpServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("message", "An error has ocurred");
            }

        } else if (action.equals("update")) {
            int followupId = Integer.parseInt(request.getParameter("followupId"));
            try {
                fs.update(followupId, note, comments, recommendations);

                assService.updateFollow(assessmentId, followupId);
            } catch (Exception ex) {
                Logger.getLogger(DiscomfortServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        response.sendRedirect("assessments");

    }

}
