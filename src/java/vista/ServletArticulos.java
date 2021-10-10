/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.BeanInventario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ServletArticulos", urlPatterns = {"/ServletArticulos"})
public class ServletArticulos extends HttpServlet {

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

        String Prenda = request.getParameter("Prenda");
        String Talla = request.getParameter("Talla");
        String Marca = request.getParameter("Marca");
        String precio_costo = request.getParameter("precio_costo");
        String precio_venta = request.getParameter("precio_venta");
        String codigo = request.getParameter("codigo");
        String usuario = request.getParameter("usuario");
        String Numero_Prenda = request.getParameter("Numero_Prenda");
        String descripcion = request.getParameter("descripcion");
        BeanInventario p;
        String pol;

        String param = request.getParameter("param");

        if (param.equalsIgnoreCase("1")) {
            System.err.println("Guardar");
            
            

            out.println(param + Prenda + Talla + Marca + precio_costo + precio_venta + codigo + usuario);

             p = new BeanInventario(Prenda,Marca, Talla,  precio_costo, precio_venta, codigo.toUpperCase(), usuario, Numero_Prenda, descripcion.toUpperCase());
             pol = Inventario.agregar(p);

            if (pol.equalsIgnoreCase("bien")) {
                System.out.println("Se inserto");
                response.sendRedirect("Consultar_Inventario.jsp");

            } else {
                System.err.println("No se inserto");
            }

        }
        if (param.equalsIgnoreCase("2")) {
            System.err.println("Editar");
            String id = request.getParameter("id");
            p = new BeanInventario(Prenda,Marca, Talla,  precio_costo, precio_venta, codigo, usuario, Numero_Prenda, descripcion);
            pol = Inventario.Editar(p, id);
            
            if (pol.equalsIgnoreCase("ok")) {
                System.out.println("Se inserto");
                response.sendRedirect("Consultar_Inventario.jsp");

            } else {
                System.err.println("No se inserto");
            }

        }
        if (param.equalsIgnoreCase("3")) {
            
            boolean actualizado;
            
            String id = request.getParameter("id");
            actualizado  = Inventario.Eliminar(id);
            if(actualizado){
                response.sendRedirect("Consultar_Inventario.jsp");
            }else {
                out.println("No se actualizo");
            }

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
