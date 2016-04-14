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
 * DiscomfortServlet is an HttpServlet that implements the Add Discomfort use case for the program by retrieving the
 * information from the jsp and using the ergo.businesslogic package to manipulate the database with the help of JPA.
 * If an Discomfort object does not exist in the assessment, a new Discomfort object is created and added in to the assessments table.
 * If an Discomfort object exists in the assessment, the existing Discomfort object is modified and updated in to the database.
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
        String action = request.getParameter("action");
        
        if(action.equals("add")){
            try {
            //Attempt to insert into the database 
            int discomforId = ds.insert(notes);
            assService.updateDiscomfort(assessmentId, discomforId);
            request.setAttribute("message", "successfully inserted");
            success =true;
            
        } catch (Exception ex) {
            //Something goes wrong with the insertion
            Logger.getLogger(DiscomfortServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("sucess", 0);
            request.setAttribute("message", "An error has ocurred");
        }
        }else if(action.equals("update")){
            int discomfortId = Integer.parseInt(request.getParameter("discomfortId"));
            try {
                ds.update(discomfortId, notes);

            assService.updateDiscomfort(assessmentId, discomfortId);
            } catch (Exception ex) {
                Logger.getLogger(DiscomfortServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        response.sendRedirect("assessments");

    }

    

}
