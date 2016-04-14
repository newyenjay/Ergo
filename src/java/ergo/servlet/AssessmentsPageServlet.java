/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.servlet;

import ergo.businesslogic.AssessmentService;
import ergo.businesslogic.ClientService;
import ergo.businesslogic.EmployeeService;
import ergo.domainmodel.Assessment;
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
 * AssessmentsPageServlet is an HttpServlet that implements the Manage Assessment use case by retrieving the assessmentId using the ergo.businesslogic
 * package to retrieve the appropriate assessment from the database. Afterwards, the information about the Assessment is passed onto the jsp for the
 * user to view.
 */
public class AssessmentsPageServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        AssessmentService assService = new AssessmentService();
        EmployeeService es = new EmployeeService();
        if(session.getAttribute("clientInfo")==null||session.getAttribute("assessmentId")==null){
            response.sendRedirect("search");
        }else{
        int clientId = Integer.parseInt((String) session.getAttribute("clientInfo"));
        ClientService cs = new ClientService();
        int assessmentId = (int) session.getAttribute("assessmentId") ;
        try {
            Assessment ass = assService.getAssessment(assessmentId);
            request.setAttribute("assessmentInfo", ass);
            request.setAttribute("client", cs.getClient(clientId));
            request.setAttribute("employeeList", es.getAll());
        } catch (Exception ex) {
            Logger.getLogger(AssessmentsPageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/notes/template.jsp").forward(request, response);}

    }
}
