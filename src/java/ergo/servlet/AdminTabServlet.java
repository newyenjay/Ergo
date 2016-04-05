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

        String manager = request.getParameter("manager");
        String business = request.getParameter("business");
        String workspace = request.getParameter("workspace");
        String jobTitle = request.getParameter("jobTitle");

        //INT conversions
        String gender = request.getParameter("gender"); //Dropdown box
        String heightFeet = request.getParameter("heightFeet");
        String heightInches = request.getParameter("heightInches");

        String handedness = request.getParameter("handedness"); //Dropdown box

        // INT == > Convert 
        String daysWeeksInOffice = request.getParameter("daysWeeksInOffice");
        String hoursDayInOffice = request.getParameter("hoursDayInOffice");
        String hoursInVDT = request.getParameter("hoursInVDT");
        String hoursOnPhone = request.getParameter("hoursOnPhone");

        String dPresent = request.getParameter("dPresent");
        String dReported = request.getParameter("dReported");
        String tSought = request.getParameter("tSought");
        String maxDiscomfort = request.getParameter("maxDiscomfort");
        String workstationFit = request.getParameter("workFit");

        String equiptRec = request.getParameter("equiptRec");
        String generalNotes = request.getParameter("generalNotes");

        String followUpNeeded = request.getParameter("followUpNeeded");

        /*
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
         try {
         Date date = sdf.parse(accessorDate);
         } catch (ParseException ex) {
         Logger.getLogger(AdminTabServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
         */
        int hInches = 0;
        int hFeet = 0;
        int daysInOffice = 0;
        int hoursInOffice = 0;
        int vdt = 0;
        int phone = 0;
        int discomfort = 0;
        int workFit = 0;

        // sorry for ugly try catch
        try {
            hInches = Integer.parseInt(heightInches);
        } catch (NumberFormatException nfe) {
        }

        try {
            hFeet = Integer.parseInt(heightFeet);

        } catch (NumberFormatException nfe) {
        }

        try {
            daysInOffice = Integer.parseInt(daysWeeksInOffice);

        } catch (NumberFormatException nfe) {
        }

        try {
            hoursInOffice = Integer.parseInt(hoursDayInOffice);

        } catch (NumberFormatException nfe) {
        }

        try {
            vdt = Integer.parseInt(hoursInVDT);

        } catch (NumberFormatException nfe) {
        }

        try {
            phone = Integer.parseInt(hoursOnPhone);

        } catch (NumberFormatException nfe) {
        }

        try {
            discomfort = Integer.parseInt(maxDiscomfort);

        } catch (NumberFormatException nfe) {
        }

        try {
            workFit = Integer.parseInt(workstationFit);

        } catch (NumberFormatException nfe) {
        }

        int vdtScore = (vdt / 3) + (2 * workFit) + (2 * discomfort);

        if (action.equals("adminTab")) {

            //try {
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
            getServletContext().getRequestDispatcher("/WEB-INF/searchAdd/search.jsp").forward(request, response);

            //} catch (Exception ex) {
            //    request.setAttribute("message", ex);
            //     Logger.getLogger(AddServlet.class.getName()).log(Level.SEVERE, null, ex);
            //  }
        } else {
            request.setAttribute("message", "no work");
            getServletContext().getRequestDispatcher("/WEB-INF/searchAdd/search.jsp").forward(request, response);

        }

        //response.sendRedirect("assessments");
    }

}
