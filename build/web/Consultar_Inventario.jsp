<%-- 
    Document   : Menu
    Created on : 30/07/2021, 23:01:17
    Author     : busqu
--%>

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
    System.out.println(""+per.getTipo());


%>


        </head>
        <body>
            <div class="container">
                <table id="example" border="1"   class="display table table-hover table-bordered table-striped table-responsive table-sm" >
                    <thead>
                        <tr>

                            <th>No.</th>
                            <th>Prenda</th>
                            <th>Marca</th>
                            <th>Talla</th>
                            <th>Precio Costo</th>
                            <th>Precio Venta</th>
                            <th>Codigo</th>
                            <th>Usuario</th>
                            <th>Fecha Ingreso</th>
                            <th>Cantidad de Prenda</th>
                            <th>Editar</th>
                            <th>Eliminar</th>

                        </tr>
                    </thead>
                    <tbody>
                    <%

                        LinkedList<BeanInventario> lista = Inventario.consultaInventario();

                        for (int i = 0; i < lista.size(); i++) {

                            out.println("<tr>");
                            //1
                            out.println("<td>" + lista.get(i).getId_inventario() + "</td>");
                            //2
                            out.println("<td id='prueba'>" + lista.get(i).getPrenda() + "</td>");
                            out.println("<td id='prueba'>" + lista.get(i).getMarca() + "</td>");
                            out.println("<td id='prueba'>" + lista.get(i).getTalla() + "</td>");
                            if(per.getTipo() == 1){
                               out.println("<td id='prueba'>" + lista.get(i).getPrecio_costo() + "</td>"); 
                            }else{
                                out.println("<td id='prueba'></td>");
                            }
                            
                            out.println("<td id='prueba'>" + lista.get(i).getPrecio_venta() + "</td>");
                            out.println("<td id='prueba'>" + lista.get(i).getCodigo() + "</td>");
                            out.println("<td id='prueba'>" + lista.get(i).getUsuario_id() + "</td>");
                            out.println("<td id='prueba'>" + lista.get(i).getFecha() + "</td>");
                            out.println("<td id='prueba'>" + lista.get(i).getNumero_Prenda()+ "</td>");
                            out.println("<td>" + "<a class='btn btn-warning' href=Editar_Articulo.jsp?id=" + lista.get(i).getId_inventario() + ">" + "Editar" + "</a>" + "</td>");
                            out.println("<td><form  method='post' action='ServletArticulos'><input  type='hidden' value='3' name='param'><input  type='hidden' value='" + lista.get(i).getId_inventario() + "' name='id'><button type='submit' class='btn btn-danger'>Eliminar</button></form></td>");

                            // <input  type="hidden" value="1" name="param">
                            // out.println("<td> <a class='btn-floating btn-small waves-effect waves-light green'></a></td>");
                            out.println("</tr>");
                        }


                    %>  
                </tbody>

                <tfoot>
                    <tr>
                        <th>No.</th>
                        <th>Prenda</th>
                        <th>Marca</th>
                        <th>Talla</th>
                        <th>Precio Costo</th>
                        <th>Precio Venta</th>
                        <th>Codigo</th>
                        <th>Usuario</th>
                        <th>Fecha Ingreso</th>
                        <th>Status</th>
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
                $('#example').DataTable({
        "order": [[ 0, "desc" ]]
    } );
            });

        </script>
    </body>
    <jsp:include page="Foot.jsp" flush="true"></jsp:include>

    <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
