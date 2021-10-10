<%-- 
    Document   : Menu
    Created on : 30/07/2021, 23:01:17
    Author     : busqu
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="modelo.Poliza"%>
<%@page import="controlador.BeanPoliza"%>
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
        </head>
        <body>
            
            <div class="container">
                <table id="example" border="1"   class="display table table-hover table-bordered table-striped table-responsive-sm" >
                    <thead>
                        <tr>

                            <th>No.</th>
                            <th>Poliza</th>
                            <th>Referencia</th>
                            <th>Descripcion</th>
                            <th>Total Prendas</th>
                            <th>Prendas Dañadas</th>
                            <th>Fecha</th>
                            <th>Usuario</th>
                            <th>Ver</th>
                            <th>Editar</th>
                            <th>Eliminar</th>

                        </tr>
                    </thead>
                    <tbody>
                    <%

                        LinkedList<BeanPoliza> lista = Poliza.consultaPolizas();

                        for (int i = 0; i < lista.size(); i++) {

                            out.println("<tr>");
                            //1
                            out.println("<td>" + lista.get(i).getId_poliza() + "</td>");
                            //2
                            out.println("<td id='prueba'>" + lista.get(i).getNumero_poliza() + "</td>");
                            out.println("<td id='prueba'>" + lista.get(i).getReferencia() + "</td>");
                            out.println("<td id='prueba'>" + lista.get(i).getDescripcion() + "</td>");
                            out.println("<td id='prueba'>" + lista.get(i).getTotal_prendas() + "</td>");
                            out.println("<td id='prueba'>" + lista.get(i).getPrendas_dañadas() + "</td>");
                            out.println("<td id='prueba'>" + lista.get(i).getFecha() + "</td>");
                            out.println("<td id='prueba'>" + lista.get(i).getUsuario_id() + "</td>");
                            out.println("<td>" + "<a class='btn btn-primary' href=Ver_Poliza.jsp?id=" + lista.get(i).getId_poliza() + ">" + "Ver" + "</a>" + "</td>");
                            out.println("<td>" + "<a class='btn btn-warning' href=Editar_Poliza.jsp?id=" + lista.get(i).getId_poliza() + ">" + "Editar" + "</a>" + "</td>");
                            out.println("<td><form  method='post' action='ServletPoliza'><input  type='hidden' value='3' name='param'><input  type='hidden' value='" + lista.get(i).getId_poliza() + "' name='id'><button type='submit' class='btn btn-danger'>Eliminar</button></form></td>");

                            // <input  type="hidden" value="1" name="param">
                            // out.println("<td> <a class='btn-floating btn-small waves-effect waves-light green'></a></td>");
                            out.println("</tr>");
                        }


                    %>  
                </tbody>

                <tfoot>
                    <tr>
                        <th>No.</th>
                        <th>Poliza</th>
                        <th>Referencia</th>
                        <th>Descripcion</th>
                        <th>Total Prendas</th>
                        <th>Prendas Dañadas</th>
                        <th>Fecha</th>
                        <th>Usuario</th>
                        <th>Ver</th>
                        <th>Editar</th>
                        <th>Eliminar</th>
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
