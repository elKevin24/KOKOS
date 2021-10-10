/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.BeanPoliza;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Poliza;

/**
 *
 * @author kcordon
 */
@WebServlet(name = "ServletPoliza", urlPatterns = {"/ServletPoliza"})
public class ServletPoliza extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        PrintWriter out = response.getWriter();

        String numero_poliza;
        String referencia;
        String descripcion;
        String total_prendas;
        String prendas_danadas;
        String usuario;
        String Pais;
        String impuestopoliza;
        String almacenaje;
        String gestoraduanero;
        String fleteaereo;
        String tramitador;
        String gastosimprevistos;
        String totalpoliza;

        int key = 0;
        String param = request.getParameter("param");
        if (param.isEmpty()) {
            System.err.println("" + param);
        } else {
            key = Integer.parseInt(param);
        }

        // instrucción switch con tipo de datos int
        switch (key) {
            case 1:
                numero_poliza = request.getParameter("numero_poliza");
                referencia = request.getParameter("referencia");
                descripcion = request.getParameter("descripcion");
                total_prendas = request.getParameter("total_prendas");
                prendas_danadas = request.getParameter("prendas_danadas");
                usuario = request.getParameter("usuario");
                
                Pais = request.getParameter("Pais");
                impuestopoliza = request.getParameter("impuestopoliza");
                almacenaje = request.getParameter("almacenaje");
                gestoraduanero = request.getParameter("gestoraduanero");
                fleteaereo = request.getParameter("fleteaereo");
                tramitador = request.getParameter("tramitador");
                gastosimprevistos = request.getParameter("gastosimprevistos");
                totalpoliza = request.getParameter("totalpoliza");
                
                

                out.println(param + "numero_poliza" + numero_poliza + referencia + descripcion + total_prendas + "prendas_danadas" + prendas_danadas + usuario);

                BeanPoliza p = new BeanPoliza(numero_poliza, referencia, descripcion, total_prendas, prendas_danadas, usuario, Pais, impuestopoliza, almacenaje, gestoraduanero, fleteaereo, tramitador, gastosimprevistos, totalpoliza);
                String pol = Poliza.agregar(p);

                if (pol.equalsIgnoreCase("bien")) {
                    System.out.println("Se inserto");
                    response.sendRedirect("Agregar_Poliza.jsp");

                } else {
                    System.err.println("No se insnerto");
                }
                break;
            case 2:

                System.err.println("editar");
                String id_poliza_edit = request.getParameter("id_poliza");
                numero_poliza = request.getParameter("numero_poliza");
                referencia = request.getParameter("referencia");
                descripcion = request.getParameter("descripcion");
                total_prendas = request.getParameter("total_prendas");
                prendas_danadas = request.getParameter("prendas_danadas");
                usuario = request.getParameter("usuario");
                
                Pais = request.getParameter("Pais");
                impuestopoliza = request.getParameter("impuestopoliza");
                almacenaje = request.getParameter("almacenaje");
                gestoraduanero = request.getParameter("gestoraduanero");
                fleteaereo = request.getParameter("fleteaereo");
                tramitador = request.getParameter("tramitador");
                gastosimprevistos = request.getParameter("gastosimprevistos");
                totalpoliza = request.getParameter("totalpoliza");

                BeanPoliza b = new BeanPoliza(numero_poliza, referencia, descripcion, total_prendas, prendas_danadas, usuario, Pais, impuestopoliza, almacenaje, gestoraduanero, fleteaereo, tramitador, gastosimprevistos, totalpoliza);
                String pol2 = Poliza.Editar(b, id_poliza_edit);
                System.err.println(""+pol2);
                if (pol2.equalsIgnoreCase("ok")) {
                    System.out.println("Se inserto");
                    response.sendRedirect("Consultar_Poliza.jsp");

                } else {
                    System.err.println("No se insnerto");
                }

                break;
            case 3:
                System.err.println("borrar");
                int id_poliza = Integer.parseInt(request.getParameter("id"));
                boolean borrar = Poliza.Eliminar(id_poliza);
                if (borrar) {
                    response.sendRedirect("Consultar_Poliza.jsp");
                }
                break;

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
