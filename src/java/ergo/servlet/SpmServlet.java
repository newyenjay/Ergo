/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.servlet;

import ergo.businesslogic.SpmService;
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
 *
 * @author 671402
 */
public class SpmServlet extends HttpServlet {
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
        getServletContext().getRequestDispatcher("/WEB-INF/notes/template.jsp").forward(request, response);
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
        SpmService ss = new SpmService();
        
        //Booleans
        Boolean armAfBool = Boolean.parseBoolean(request.getParameter("armAfBool"));
        Boolean armBeBool = Boolean.parseBoolean(request.getParameter("armBeBool"));
        Boolean baseAfBool = Boolean.parseBoolean(request.getParameter("baseAfBool"));
        Boolean baseBeBool = Boolean.parseBoolean(request.getParameter("baseBeBool"));
        Boolean shoulderAfBool = Boolean.parseBoolean(request.getParameter("shoulderAfBool"));
        Boolean shoulderBeBool = Boolean.parseBoolean(request.getParameter("shoulderBeBool"));
        
        //Notes
        String armAfNotes = request.getParameter("armAfNotes");
        String armBeNotes = request.getParameter("armBeNotes");
        String baseAfNotes = request.getParameter("baseAfNotes");
        String baseBeNotes = request.getParameter("baseBeNotes");
        String shoulderAfNotes = request.getParameter("shoulderAfNotes");
        String shoulderBeNotes = request.getParameter("shoulderBeNotes");
        
        try {
            ss.insert(baseBeBool, baseBeNotes, baseAfBool, baseAfNotes, shoulderBeBool, shoulderBeNotes, shoulderAfBool, shoulderAfNotes, armBeBool, armBeNotes, armAfBool, armAfNotes);
            request.setAttribute("message", "Success!");
            getServletContext().getRequestDispatcher("/WEB-INF/searchAdd/search.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PmbServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("message", "Nope");
        getServletContext().getRequestDispatcher("/WEB-INF/searchAdd/search.jsp").forward(request, response);
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
