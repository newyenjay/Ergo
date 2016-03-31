/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.servlet;

import ergo.businesslogic.AdminService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 680420
 */
public class AdminTabServlet extends HttpServlet {

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
        getServletContext().getRequestDispatcher("/WEB-INF/notes/report/admininfo.jsp").forward(request, response);
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

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        AdminService as = new AdminService();

        String proactive = request.getParameter("proactive");
        String reactive = request.getParameter("reactive");
        String assessor = request.getParameter("accessor");
        String accessorDate = request.getParameter("accessorDate");// CONVERT TO DATE 

        String manager = request.getParameter("manager").trim();
        String business = request.getParameter("business").trim();
        String workspace = request.getParameter("workspace").trim();
        String jobTitle = request.getParameter("jobTitle").trim();

        //INT conversions
        String gender = request.getParameter("gender"); //Dropdown box
        String heightFeet = request.getParameter("heightFeet").trim();
        String heightInches = request.getParameter("heightInches").trim();

        String handedness = request.getParameter("handedness"); //Dropdown box

        // INT == > Convert 
        String daysWeeksInOffice = request.getParameter("daysWeeksInOffice").trim();
        String hoursDayInOffice = request.getParameter("hoursDayInOffice").trim();
        String hoursInVDT = request.getParameter("hoursInVDT").trim();
        String hoursOnPhone = request.getParameter("hoursOnPhone").trim();

        String dPresent = request.getParameter("dPresent");
        String dReported = request.getParameter("dReported");
        String tSought = request.getParameter("tSought");
        String maxDiscomfort = request.getParameter("maxDiscomfort");
        String workstationFit = request.getParameter("workFit");

        String equiptRec = request.getParameter("equiptRec").trim();
        String generalNotes = request.getParameter("generalNotes").trim();

        String followUpNeeded = request.getParameter("followUpNeeded");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date date = sdf.parse(accessorDate);
        } catch (ParseException ex) {
            Logger.getLogger(AdminTabServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        int hInches = Integer.parseInt(heightInches);
        int hFeet = Integer.parseInt(heightFeet);

        int daysInOffice = Integer.parseInt("daysWeeksInOffice");
        int hoursInOffice = Integer.parseInt("hoursDayInOffice");
        int vdt = Integer.parseInt("hoursInVDT");
        int phone = Integer.parseInt("hoursOnPhone");
        int discomfort = Integer.parseInt("maxDiscomfort");
        int workFit = Integer.parseInt("workstationFit");

        int vdtScore = (vdt / 3) + (2 * workFit) + (2 * discomfort);

        if (action.equals("adminTab")) {
            
            try {
                    as.insert(proactive,
                    reactive,
                    assessor,
                    manager,
                    business,
                    workspace,
                    jobTitle,
                    gender,
                    hFeet,
                    hInches,
                    handedness,
                    daysInOffice,
                    hoursInOffice,
                    vdt,
                    phone,
                    dPresent,
                    dReported,
                    tSought,
                    discomfort,
                    workFit,
                    equiptRec,
                    generalNotes,
                    followUpNeeded,
                    vdtScore);
                    
                    request.setAttribute("message", "Success!");
                } catch (Exception ex) {
                    request.setAttribute("message", ex);
                    Logger.getLogger(AddServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

        } 
        
        getServletContext().getRequestDispatcher("/WEB-INF/notes/report/admininfo.jsp").forward(request, response);
    }

}
