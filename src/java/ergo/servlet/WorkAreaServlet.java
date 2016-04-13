/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.servlet;

import ergo.businesslogic.AssessmentService;
import ergo.businesslogic.MonitorService;
import ergo.businesslogic.PwaeService;
import ergo.businesslogic.SiteRecService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kimberly Oshiro
 *
 * One of the main Servlets on the page. Will take in the information from the
 * "Prepare Work Area & Equiptment" and will input it into the database. From
 * there, the database will be able to recall the information whenever and can
 * put the information into a report.
 */
public class WorkAreaServlet extends HttpServlet {

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

        String elbowCurr = request.getParameter("elbowCurr");
        String elbowRec = request.getParameter("elbowRec");
        String elbowSit = request.getParameter("elbowSit");
        String eyeCurr = request.getParameter("eyeCurr");
        String eyeRec = request.getParameter("eyeRec");
        String eyeSit = request.getParameter("eyeSit");
        String deskCurr = request.getParameter("deskCurr");
        String deskRec = request.getParameter("deskRec");
        String deskSit = request.getParameter("deskSit");
        String keyboardCurr = request.getParameter("keyboardCurr");
        String keyboardRec = request.getParameter("keyboardRec");
        String keyboardSit = request.getParameter("keyboardSit");
        String chairNote = request.getParameter("chairNote");
        String monitorNote = request.getParameter("monitorNote");
        String inputNote = request.getParameter("inputNote");
        String deskNote = request.getParameter("deskNote");
        String accessNote = request.getParameter("accessNote");
        int pwaeId = 0;
        int monitorRow = Integer.parseInt(request.getParameter("monitorRow"));
        int siteRow = Integer.parseInt(request.getParameter("siteRow"));
        PwaeService pwaeS = new PwaeService();
        MonitorService ms = new MonitorService();
        SiteRecService srs = new SiteRecService();
        boolean success = false;
        AssessmentService assService = new AssessmentService();
        int assessmentId = (int) session.getAttribute("assessmentId");
        String action = request.getParameter("action");
        if (action.equals("add")) {
            try {
                pwaeId = pwaeS.insert(elbowCurr, elbowRec, elbowSit, eyeCurr, eyeRec, eyeSit, deskCurr, deskRec, deskSit, keyboardCurr, keyboardRec, keyboardSit, chairNote, monitorNote, inputNote, deskNote, accessNote);
                assService.updatePwae(assessmentId, pwaeId);
                success = true;
            } catch (Exception ex) {
                Logger.getLogger(WorkAreaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (monitorRow != 0) {
                for (int i = 1; i <= monitorRow; i++) {
                    String monType = request.getParameter("monType" + i);
                    String monCurr = request.getParameter("monCurr" + i);
                    String monRec = request.getParameter("monRec" + i);
                    String monSit = request.getParameter("monSit" + i);

                    try {
                        ms.insert(monType, monCurr, monRec, monSit, pwaeId);
                    } catch (Exception ex) {
                        Logger.getLogger(WorkAreaServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

            if (siteRow != 0) {
                for (int i = 1; i <= siteRow; i++) {
                    String srRec = request.getParameter("srRec" + i);
                    String srAcc = request.getParameter("srAcc" + i);
                    String srDate = request.getParameter("srDate" + i);
                    try {
                        srs.insert(srRec, srAcc, srDate, pwaeId);
                    } catch (Exception ex) {
                        Logger.getLogger(WorkAreaServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else if (action.equals("update")) {
            int pwaId = Integer.parseInt(request.getParameter("pwaId"));

            try {
                pwaeS.updatePwae(pwaId, elbowCurr, elbowRec, elbowSit, eyeCurr, eyeRec, eyeSit, deskCurr, deskRec, deskSit, keyboardCurr, keyboardRec, keyboardSit, chairNote, monitorNote, inputNote, deskNote, accessNote);
                assService.updatePwae(assessmentId, pwaId);
            } catch (Exception ex) {
                Logger.getLogger(WorkAreaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (monitorRow != 0) {
                for (int i = 1; i <= monitorRow; i++) {

                    int monitorId = Integer.parseInt(request.getParameter("monitorId" + i));
                    if (monitorId == 0) {
                        String monType = request.getParameter("monType" + i);
                        String monCurr = request.getParameter("monCurr" + i);
                        String monRec = request.getParameter("monRec" + i);
                        String monSit = request.getParameter("monSit" + i);

                        try {
                            ms.insert(monType, monCurr, monRec, monSit, pwaId);
                        } catch (Exception ex) {
                            Logger.getLogger(WorkAreaServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        String monType = request.getParameter("monType" + i);
                        String monCurr = request.getParameter("monCurr" + i);
                        String monRec = request.getParameter("monRec" + i);
                        String monSit = request.getParameter("monSit" + i);
                        try {

                            ms.update(monitorId, monType, monCurr, monRec, monSit, pwaId);
                            pwaeS.updateMonitorList(pwaId);
                        } catch (Exception ex) {
                            Logger.getLogger(WorkAreaServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }
            if (siteRow != 0) {
                for (int i = 1; i <= siteRow; i++) {

                    int siteRecId = Integer.parseInt(request.getParameter("siteRecId" + i));
                    if (siteRecId == 0) {
                        String srRec = request.getParameter("srRec" + i);
                        String srAcc = request.getParameter("srAcc" + i);
                        String srDate = request.getParameter("srDate" + i);
                        try {
                            srs.insert(srRec, srAcc, srDate, pwaId);
                        } catch (Exception ex) {
                            Logger.getLogger(WorkAreaServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                         String srRec = request.getParameter("srRec" + i);
                        String srAcc = request.getParameter("srAcc" + i);
                        String srDate = request.getParameter("srDate" + i);
                        try {
                            srs.update(siteRecId,srRec, srAcc, srDate, pwaId);
                            pwaeS.updateSiteRecList(pwaId);
                        } catch (Exception ex) {
                            Logger.getLogger(WorkAreaServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }
        }

        response.sendRedirect("assessments");

    }

}
