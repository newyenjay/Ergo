/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.servlet;

import ergo.businesslogic.ClientService;
import ergo.businesslogic.CompanyService;
import ergo.businesslogic.LocationService;
import ergo.domainmodel.Client;
import ergo.domainmodel.Company;
import ergo.domainmodel.Location;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SearchServlet extends HttpServlet {

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

        session.removeAttribute("clientInfo");
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
        String companyId = request.getParameter("company");
        String clientId = request.getParameter("client");
        CompanyService cos = new CompanyService();
        HttpSession session = request.getSession();
        boolean noRedirect = true;

        if (action.equals("searchCompany")) {
            if (companyId.equals("0")) {
                request.setAttribute("sucess", "0");
                request.setAttribute("message", "Please select the required field");
            } else {
                try {
                    Company com = cos.getCompany(Integer.parseInt(companyId));
                    List<Client> clientResult = com.getClientList();
                    request.setAttribute("clientResult", clientResult);
                    request.setAttribute("comName", com.getName());
                } catch (Exception ex) {
                    request.setAttribute("sucess", "0");
                    request.setAttribute("message", "Problem loading the Client List");
                    Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (action.equals("searchClient")) {
            if (companyId.equals("0") || clientId.equals("0")) {
                request.setAttribute("sucess", "0");
                request.setAttribute("message", "Please select the required field");
            } else {
                noRedirect = false;
                session.setAttribute("clientInfo", clientId);
                response.sendRedirect("client");
            }
        } else if (action.equals("viewClient")) {

            noRedirect = false;
            session.setAttribute("clientInfo", clientId);
            response.sendRedirect("client");
        }
        if (noRedirect) {
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

}
