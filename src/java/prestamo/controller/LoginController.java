/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamo.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import prestamo.dao.UsuarioDAO;

/**
 *
 * @author UPEU
 */
@WebServlet(name = "LoginController", urlPatterns = {"/lcc"})
public class LoginController extends HttpServlet {
    private final UsuarioDAO aO = new UsuarioDAO();
    private Map<String, Object> usuario = new HashMap<>();
    private Gson gson = new Gson();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        HttpSession session = request.getSession(true);
        int x = 0;
        int op = Integer.parseInt(request.getParameter("opc"));
        RequestDispatcher dispatcher;
        
        if(op==1){
            if (aO.login(user, pass) != null) {
                usuario = aO.login(user, pass);
                session.setAttribute("nombres", usuario.get("nombres"));
                session.setAttribute("user", usuario.get("user"));
                session.setAttribute("rol", usuario.get("rol"));
                Map<String, Object> datos = new HashMap<>();
                x = 1;
                datos.put("op", x);
                datos.put("rol", usuario.get("rol"));
                
                out.println(gson.toJson(datos));
            }else{
                out.println(0);
            }

        }else{
                    session.setAttribute("nombres",null);
                    session.setAttribute("user",null);  
                    session.setAttribute("rol",null);  
                    session.invalidate();
        
        } 
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
