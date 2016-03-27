/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kimberly Oshiro
 * 
 * This is one of the main servlets of the assessment page, this page is connected to the "Admin" tab. 
 * From there the assessment page will be able to insert into the Assessments table. 
 */
public class AssessmentsAdminServlet extends HttpServlet {
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
        //I don't think the code here is needed tbh. 
        //Everything's done in the post so this isn't really needed. 
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
        //Get everything from the webpage go. I don't care if it's eating dinner with its family. take it and go. 
        String proactive = request.getParameter("proactive");//Dropdown box
        String reactive = request.getParameter("reactive");//Dropdown box
        String assessment = request.getParameter("assessment");//Dropdown box 
        String accessorDate = request.getParameter("accessorDate");//Dropdown box This has to be a date. THis is gonna break. 
        //This is gonna break. DOn't run this. This is supposed to be a date. 
        
        String manager = request.getParameter("manager").trim();
        String business = request.getParameter("business").trim();
        String workspace = request.getParameter("workspace").trim();
        String jobTitle = request.getParameter("jobTitle").trim();
        
        String gender = request.getParameter("gender"); //Dropdown box
        String heightFeet = request.getParameter("heightFeet").trim();
        String heightInches = request.getParameter("heightInches").trim();
        String handedness = request.getParameter("handedness"); //Dropdown box
        
        String daysWeeksInOffice = request.getParameter("daysWeeksInOffice").trim();
        String hoursDayInOffice = request.getParameter("hoursDayInOffice").trim();
        String hoursInVDT = request.getParameter("hoursInVDT").trim();
        String hoursOnPhone = request.getParameter("hoursOnPhone").trim();
        
        String dPresent = request.getParameter("dPresent");
        String dReported = request.getParameter("dReported");
        String tSought = request.getParameter("tSought");
        String maxDiscomfort = request.getParameter("maxDiscomfort");
        
        String equiptRec = request.getParameter("equiptRec").trim();
        String generalNotes = request.getParameter("generalNotes").trim();
        
        String email = request.getParameter("email").trim();
        //We have to have a bunch of JSP stuff on here. 
        //Kill me. 
        String followUpNeeded = request.getParameter("followUpNeeded");
        
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
