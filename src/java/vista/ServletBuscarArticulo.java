/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import controlador.BeanInventario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Inventario;

/**
 *
 * @author kcordon
 */
@WebServlet(name = "buscaArticulo", urlPatterns = {"/buscaArticulo.do"})
public class ServletBuscarArticulo extends HttpServlet {

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

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String filtro = request.getParameter("filtro");

            // System.err.println("" + filtro);
            

            try {
                for (BeanInventario p : Inventario.consultaInventario(filtro)) {

                    
                    //out.println("<li> Ubicacion: " + p.getUbicacion() + ", Encargada: " + p.getEncargada()+" </li>");
                    out.println("<li onclick='myFunction2(\"" + p.getCodigo()+ "\", \"" + p.getId_inventario()+ "\", \"" + p.getPrenda()+ "\", \"" + p.getMarca()+ "\", \"" + p.getTalla()+ "\", \"" + p.getNumero_Prenda()+ "\", \"" + p.getDescripcion()+ "\")'>" + p.getCodigo()+ "</li>");
                      
                     
                }
            } catch (SQLException ex) {
                System.err.println("" + ex);
            }
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
