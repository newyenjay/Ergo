/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.servlet;

import ergo.businesslogic.ClientService;
import ergo.businesslogic.EmployeeService;
import ergo.domainmodel.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * This page is also known as HomePageServlet 
 */
public class MainPageServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


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
        try {
            //Bro this servlet is gonna be massive please have mercy on my soul I don't know what to do oh my god.
            //the code here is gonna be 30 miles long sweet jesus how are we gonna do this.
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            List<Employee> empList = null;
            ClientService cs = new ClientService();
            
            if(action == null || action.isEmpty()){
                action = "";
            }
            
            switch(action){
                case "addClient":
                    String firstName = request.getParameter("firstname");
                    String lastName = request.getParameter("lastname");
                    String email = request.getParameter("email");
                    String date = request.getParameter("date");
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                    Date newDate = new Date();
                    newDate = format.parse(date);
                    //int nice = cs.insert(firstName, lastName, newDate,email);  
                    //request.setAttribute("firstname", nice);
                    getServletContext().getRequestDispatcher("/WEB-INF/searchAdd/searchAdd.jsp").forward(request, response);                    //cs.insert(firstName, lastName, date,email);                default:
                    break;
            }
        } catch (ParseException ex) {
            Logger.getLogger(MainPageServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainPageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
