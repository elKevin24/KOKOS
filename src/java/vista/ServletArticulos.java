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

        String Prenda;
        String Talla;
        String Marca;
        String precio_costo;
        String precio_venta;
        String codigo;
        String usuario;

        String param = request.getParameter("param");

        if (param.equalsIgnoreCase("1")) {
            System.err.println("Guardar");
            Prenda = request.getParameter("Prenda");
            Talla = request.getParameter("Talla");
            Marca = request.getParameter("Marca");
            precio_costo = request.getParameter("precio_costo");
            precio_venta = request.getParameter("precio_venta");
            codigo = request.getParameter("codigo");
            usuario = request.getParameter("usuario");

            out.println(param + Prenda + Talla + Marca + precio_costo + precio_venta + codigo + usuario);

            BeanInventario p = new BeanInventario(Prenda, Talla, Marca, precio_costo, precio_venta, codigo, usuario);
            String pol = Inventario.agregar(p);

            if (pol.equalsIgnoreCase("bien")) {
                System.out.println("Se inserto");
                response.sendRedirect("Agregar_Poliza.jsp");

            } else {
                System.err.println("No se inserto");
            }

        }
        if (param.equalsIgnoreCase("2")) {
            System.err.println("Editar");

        }
        if (param.equalsIgnoreCase("3")) {
            System.err.println("Borrar");

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
