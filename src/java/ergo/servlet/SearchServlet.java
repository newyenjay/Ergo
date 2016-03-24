/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.servlet;

import ergo.businesslogic.ClientService;
import ergo.businesslogic.LocationService;
import ergo.domainmodel.Client;
import ergo.domainmodel.Location;
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
public class SearchServlet extends HttpServlet {

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
            
            ClientService cs = new ClientService();
            List<Client> clientList = cs.getAll();
            request.setAttribute("client", clientList);
            
        } catch (Exception ex) {
            request.setAttribute("sucess", "0");
            request.setAttribute("message", "Problem loading the Company List");
            Logger.getLogger(AddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/searchAdd/search.jsp").forward(request, response);
    }

}
