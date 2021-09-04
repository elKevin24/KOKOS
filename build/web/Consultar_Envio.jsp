<%-- 
    Document   : Menu
    Created on : 30/07/2021, 23:01:17
    Author     : busqu
--%>

<%@page import="modelo.Envios"%>
<%@page import="controlador.BeanEnvios"%>
<%@page import="modelo.Usuario"%>
<%@page import="controlador.persona"%>
<%@page import="java.util.LinkedList"%>
<%@page import="modelo.Inventario"%>
<%@page import="controlador.BeanInventario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>KOKOS</title>
        <link href="css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>

        <jsp:include page="Head.jsp" flush="true"></jsp:include>

            <!--Let browser know website is optimized for mobile-->
            <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <%

            String user = String.valueOf(session.getAttribute("usuario"));

            persona per = new persona();
            per = Usuario.Consultar(user);
            System.out.println("" + per.getTipo());


        %>


    </head>
    <body>
        <div class="container">
            <table id="example" border="1"   class="display table table-hover table-bordered table-striped table-responsive-sm" >
                <thead>
                    <tr>

                        <th>No. Envio</th>
                        <th>Tienda</th>
                        <th>Fecha</th>
                        <th>Numero de Prendas</th>
                        <th>Ver Detalle</th>

                    </tr>
                </thead>
                <tbody>
                    <%                        LinkedList<BeanEnvios> lista = Envios.consultaEnvios();

                        for (int i = 0; i < lista.size(); i++) {

                            out.println("<tr>");
                            //1
                            out.println("<td>" + lista.get(i).getId_envio() + "</td>");
                            //2
                            out.println("<td id='prueba'>" + lista.get(i).getTienda_id() + "</td>");
                            out.println("<td id='prueba'>" + lista.get(i).getFecha() + "</td>");
                            out.println("<td id='prueba'>" + lista.get(i).getUsuario_id() + "</td>");
                            out.println("<td>" + "<a class='btn btn-warning' href=Detalle_Envio.jsp?id=" + lista.get(i).getId_envio() + ">" + " Detalle" + "</a>" + "</td>");
                            // <input  type="hidden" value="1" name="param">
                            // out.println("<td> <a class='btn-floating btn-small waves-effect waves-light green'></a></td>");
                            out.println("</tr>");
                        }


                    %>  
                </tbody>

                <tfoot>
                    <tr>
                        <th>No. Envio</th>
                        <th>Tienda</th>
                        <th>Fecha</th>
                        <th>Numero de Prendas</th>
                        <th>Ver Detalle</th>
                    </tr>
                </tfoot>
            </table>
        </div>

        <script src="js/jquery-3.5.1.js" type="text/javascript"></script>
        <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>

        <script>

            $(document).ready(function () {
                $('#example').DataTable();
            });

        </script>
    </body>
    <jsp:include page="Foot.jsp" flush="true"></jsp:include>

    <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
