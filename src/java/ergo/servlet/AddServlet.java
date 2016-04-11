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
import ergo.domainmodel.Location;
import java.io.IOException;
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
            LocationService ls = new LocationService();
            List<Location> locList = ls.getAll();
            request.setAttribute("location", locList);
        } catch (Exception ex) {
            request.setAttribute("sucess", "0");
            request.setAttribute("message", "Problem loading the Company List");
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
        String locAdd = request.getParameter("locAdd");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String comId = request.getParameter("comloc");

        CompanyService cs = new CompanyService();
        LocationService ls = new LocationService();
        ClientService cls = new ClientService();

        if (action.equals("addCompany")) {
            if (compName == null || locAdd == null || compName.isEmpty() || locAdd.isEmpty()) {
                request.setAttribute("sucess", 0);
                request.setAttribute("message", "Please enter all the information For Company");
            } else {
                try {
                    int compId = cs.insert(compName);
                    ls.insert(cs.getCompany(compId), locAdd);
                    request.setAttribute("sucess", 1);
                    request.setAttribute("message", "Added Company - Location");
                } catch (Exception ex) {
                    request.setAttribute("sucess", 0);
                    request.setAttribute("message", "Error Adding Company - Location");
                    Logger.getLogger(AddServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (action.equals("addClient")) {
            int comloc = Integer.parseInt(comId);
            if (fname == null || lname == null || comloc == 0 || fname.isEmpty() || lname.isEmpty()) {
                request.setAttribute("sucess", 0);
                request.setAttribute("message", "Please enter all the information For Client");
            } else {
                try {
                    cls.insert(fname, lname, comloc);

                    request.setAttribute("sucess", 1);
                    request.setAttribute("message", "Client Added");
                } catch (Exception ex) {
                    request.setAttribute("sucess", 0);
                    request.setAttribute("message", ex);
                    Logger.getLogger(AddServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        try {
            ls = new LocationService();
            List<Location> locList = ls.getAll();
            request.setAttribute("location", locList);
        } catch (Exception ex) {
            request.setAttribute("message", ex);
            Logger.getLogger(AddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/searchAdd/addClientCompany.jsp").forward(request, response);
    }

}
