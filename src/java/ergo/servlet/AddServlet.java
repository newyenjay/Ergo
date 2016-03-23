/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.servlet;

import ergo.businesslogic.ClientService;
import ergo.businesslogic.CompanyService;
import ergo.businesslogic.LocationService;
import ergo.domainmodel.Company;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 680420
 */
public class AddServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        try {
            CompanyService cs = new CompanyService();
            List<Company> comList = null;
            comList = cs.getAll();
            request.setAttribute("company", comList);

        } catch (Exception ex) {
            request.setAttribute("message", ex);
            Logger.getLogger(AddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/searchAdd/addClientCompany.jsp").forward(request, response);

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
        String action = request.getParameter("action");
        String compName = request.getParameter("compName");
        String locName = request.getParameter("locName");
        String locAdd = request.getParameter("locAdd");
        CompanyService cs = new CompanyService();
        LocationService ls = new LocationService();

        //if(compName == null||locName == null||locAdd==null){
        //    request.setAttribute("message", "Please enter all the information");
        //}
        if (action.equals("addCompany")) {
            try {
                int compId = cs.insert(compName);

                ls.insert(cs.getCompany(compId), locAdd);
                request.setAttribute("message", "Successfully Added");

            } catch (Exception ex) {
                request.setAttribute("message", ex);
                Logger.getLogger(AddServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (action.equals("addClient")) {
            String firstName = request.getParameter("fname");
            String lastName = request.getParameter("lname");
            ClientService cls = new ClientService();

            try {
                cls.insert(firstName, lastName);
                request.setAttribute("message", "Successfully Added");

            } catch (Exception e) {
                request.setAttribute("message", e);
            }

        }

        try {
            cs = new CompanyService();
            List<Company> comList = null;
            comList = cs.getAll();
            request.setAttribute("company", comList);

        } catch (Exception ex) {
            request.setAttribute("message", ex);
            Logger.getLogger(AddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/searchAdd/addClientCompany.jsp").forward(request, response);
    }

}
