package vista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.persona;
import modelo.personaDAO;


import javax.servlet.http.HttpSession;


public class Controlador extends HttpServlet {
    personaDAO dao= new personaDAO();
    persona p=new persona();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion= request.getParameter("accion");
        if(accion.equals("Ingresar")){
            String usuario=request.getParameter("usuario");
            String clave=request.getParameter("clave");
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(30*60);
            
            p.setUsuario(usuario);
            p.setClave(clave);
            r=dao.Validar(p);
            if(r==1){
                
                session.setAttribute("usuario", usuario);
                //session.setAttribute("clave", clave);
                
                request.getSession().setAttribute("usuario", usuario);
                //request.getSession().setAttribute("clave", clave)s;
                request.getRequestDispatcher("Menu.jsp").forward(request, response);
                
            }else{
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("Login.jsp").forward(request, response);
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
