/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamo.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import prestamo.dao.LectorDAO;
import prestamo.dao.PrestamoDAO;
import prestamo.dto.PrestamoDTO;

/**
 *
 * @author UPEU
 */
@WebServlet(name = "PrestamoController", urlPatterns = {"/pc"})
public class PrestamoController extends HttpServlet {
    private LectorDAO aO1 = new LectorDAO();
    private PrestamoDAO aO = new PrestamoDAO();
//    private List<Cliente> lista = new ArrayList<>();
    private Gson gson = new Gson();
    private PrestamoDTO dTO = new PrestamoDTO();
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
       RequestDispatcher dispatcher;
            String url;
            int op = Integer.parseInt(request.getParameter("opc"));
            HttpSession session = request.getSession(true);
        switch (op) {
            case 1:
                List<Map<String, ?>> lista2 = new ArrayList<>();
                request.setAttribute("lista4", aO.readAll2());
//                request.setAttribute("lista5", aO1.readAll());
                url = "/prestamo.jsp";
                dispatcher = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);
                break;
//            case 2:
//                int idc = Integer.parseInt(request.getParameter("idc"));
//                String f1 = request.getParameter("fecha1");
//                String f2 = request.getParameter("fecha2");
//                PrestamoDTO p1 = new PrestamoDTO(idc, f1, f2);
//                if (aO.create(p1) == 1) {
//                    out.println(1);
//                }
//                // out.println(idr+" / "+nombres+" / "+user+" / "+clave);
//                break;
//            case 3:
//                int id = Integer.parseInt(request.getParameter("id"));
//                dTO = aO.read(id);
//                out.println(gson.toJson(dTO));
//                break;
//            case 4:
//                dTO.setIdprestamo(Integer.parseInt(request.getParameter("idp")));
//                dTO.setIdcliente(Integer.parseInt(request.getParameter("idc")));
//                dTO.setFecha1(request.getParameter("fecha1"));
//                dTO.setFecha2(request.getParameter("fecha2"));  
//                int b=aO.update(dTO);
//                out.println(b);
//                break;
            case 5:
//                int w = aO1.delete(Integer.parseInt(request.getParameter("id")));
//                out.println(w);
                break;
            case 6:
//                int w = aO1.delete(Integer.parseInt(request.getParameter("id")));
//                out.println(w);
                break;
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
