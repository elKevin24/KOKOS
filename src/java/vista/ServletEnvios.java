/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.BeanDetalleEnvio;
import controlador.BeanEnvios;
import controlador.BeanInventario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Envios;
import modelo.Inventario;

/**
 *
 * @author kcordon
 */
@WebServlet(name = "ServletEnvios", urlPatterns = {"/ServletEnvios"})
public class ServletEnvios extends HttpServlet {

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

        String Usuario = request.getParameter("usuario");
        //String cont = request.getParameter("cont");
        String Tienda = request.getParameter("Tienda");

        
       
           
            

           // out.println( Usuario + Tienda);

            BeanEnvios p = new BeanEnvios(Tienda,Usuario);
            String pol = Envios.agregar(p);

            if (pol.equalsIgnoreCase("bien")) {
                if(request.getParameter("cont").isEmpty()){
                    response.sendRedirect("Agregar_Poliza.jsp");
                }else{
                    
                    System.out.println("not is empty");
                int cont = Integer.valueOf(request.getParameter("cont"));
                    System.err.println("cont"+cont);
                BeanDetalleEnvio det;
                String[] detalle = new String[cont];
                for (int i = 0; i < detalle.length; i++) {
                    int a = i + 1;
                    detalle[i] = request.getParameter("codigo_nav" + a + "");
                    System.err.println("codigo "+request.getParameter("codigo_nav" + a + ""));
                    
                    
                    //Aqui vas obteniendo el id del curso
                }
                
                    
                    
                    for (String detalle1 : detalle) {
                        System.err.println("detalle" + detalle1);
                    }
                boolean k = false;


                for (int i = 0; i < detalle.length; i++) {

                    det = new BeanDetalleEnvio(i, detalle[i]);
                    k = Envios.agregarDetalle(det);
                }
                
                 response.sendRedirect("Agregar_Envio.jsp");
                    
                }
                
                

            } else {
                System.err.println("No se inserto");
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
