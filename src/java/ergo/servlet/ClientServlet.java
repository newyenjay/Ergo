package ergo.servlet;

import ergo.businesslogic.AssessmentService;
import ergo.businesslogic.ClientService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.AssertFalse;

/**
 * ClientServlet is an HttpServlet that implements the Manage Client Use Cases for the program by using the ergo.businesslogic package to
 * retrieve the objects inside the database using the forms passed through the jsp files. 
 */
@WebServlet(name = "ClientServlet", urlPatterns = {"/client"})
public class ClientServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * This method retrieves the client information which is then sent to the jsp for the user to view.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("assessmentId");
        int clientId = Integer.parseInt((String) session.getAttribute("clientInfo"));
        ClientService cs = new ClientService();
        try {
            request.setAttribute("client", cs.getClient(clientId));
        } catch (Exception ex) {
            Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/patient/overview.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * This method handles actions to manage client information such as adding and editing assessments. This Servlet redirects
     * the website to the assessments page for the user to modify the corresponding assessment in the database.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int clientId = Integer.parseInt((String) session.getAttribute("clientInfo"));
        int assessmentId = 0;

        String action = request.getParameter("action");
        if (action.equals("addAssessment")) {
            AssessmentService as = new AssessmentService();
            String type = request.getParameter("type");
            try {
                assessmentId = as.insert(clientId, type);
                ClientService cs = new ClientService();
                cs.updateAssess(clientId, assessmentId);
                
            } catch (Exception ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            session.setAttribute("assessmentId", assessmentId);

        }else if(action.equals("edit")){
            assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
            session.setAttribute("assessmentId", assessmentId);

        }
        response.sendRedirect("assessments");

    }

}
