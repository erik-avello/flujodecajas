/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import dao.DAO_RegistroTabla;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Erik
 */
public class editarDato_Servlet extends HttpServlet {

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
        try {
            String datoNuevo = request.getParameter("inputSalida");
            String datoViejo = request.getParameter("inputEntrada");
            String idFlujo = request.getParameter("idFlujo");
            String idMes = request.getParameter("idMes");
            
            /* size=1
            if(){
                
            }else{ size = >=2;
            }
            */
           
            System.out.println("IdMes: "+idMes);
            
            DAO_RegistroTabla daoRegistro = new DAO_RegistroTabla();
            System.out.println("Entra a consulta");
            daoRegistro.editarDato(datoNuevo, datoViejo, idFlujo, idMes);
            System.out.println("Sale consulta");
            
        } catch (Exception e) {
        }
    }

    private JsonArray convertirJSONArray(String listaEnString) throws IOException {
        JsonParser parser = new JsonParser();
        Object obj = parser.parse(listaEnString);
        JsonArray array = (JsonArray) obj;
        System.out.println("Array----" + array);
        return array;
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
