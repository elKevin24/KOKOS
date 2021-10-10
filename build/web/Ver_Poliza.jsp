<%-- 
    Document   : Menu
    Created on : 30/07/2021, 23:01:17
    Author     : busqu
--%>

<%@page import="modelo.Usuario"%>
<%@page import="controlador.persona"%>
<%@page import="java.util.LinkedList"%>
<%@page import="modelo.Poliza"%>
<%@page import="controlador.BeanPoliza"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


        <jsp:include page="Head.jsp" flush="true"></jsp:include>

            <!--Let browser know website is optimized for mobile-->
            <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <%

            String user = String.valueOf(session.getAttribute("usuario"));

            persona per = new persona();
            per = Usuario.Consultar(user);

            String id_poliza = request.getParameter("id");

            BeanPoliza pol = new BeanPoliza();
            pol = Poliza.Consultar(id_poliza);

        %>
    <div class="content-inner">
    <!-- Page Header-->
    <header class="page-header">
        <div class="container-fluid">
            <h2 class="no-margin-bottom">Ver Poliza</h2>
        </div>
    </header>
        <div class="container">
            <table id="example" border="1"   class="display table table-hover table-bordered table-striped table-responsive-sm" >
                <thead>
                    <tr>
                        <th colspan=7"">Datos de Poliza</th>
                    </tr>
                    <tr>
                        <th colspan="2">Poliza</th>
                        <th colspan="2">Referencia</th>
                        <th colspan="2">Descripcion</th>
                        <th >Fecha</th>
                    </tr>
                    <tr>
                        <td colspan="2"><%= pol.getNumero_poliza()%></td>
                        <td colspan="2"><%=  pol.getReferencia()%></td>
                        <td colspan="2"><%= pol.getDescripcion()%></td>
                        <td><%= pol.getFecha()%></td>
                    </tr>
                </thead>
                <tbody>
                    <tr>

                        <td colspan="2">Total Prendas</td>
                        <td colspan="2">Prendas Dañadas</td>
                        <td colspan="3">Pais</td>


                    </tr>
                    <tr>

                        <td colspan="2"><%= pol.getTotal_prendas()%></td>
                        <td colspan="2"><%=  pol.getPrendas_dañadas()%></td>
                        <td colspan="2"><%= pol.getPais()%></td>


                    </tr>
                    <tr>

                        <td>Impuestopoliza</td>
                        <td>Almacenaje </td>
                        <td>Gestor Aduanero</td>
                        <td>Flete Aereo</td>
                        <td>Tramitador </td>
                        <td>Gastos Imprevistos</td>
                        <td>Total Poliza</td>


                    </tr>
                    <tr>

                        <td><%= pol.getImpuestopoliza()%></td>
                        <td><%= pol.getAlmacenaje()%></td>
                        <td><%= pol.getGestoraduanero()%></td>
                        <td><%= pol.getFleteaereo() %></td>
                        <td><%= pol.getTramitador()%></td>
                        <td><%= pol.getGastosimprevistos()%></td>
                        <td><%= pol.getTotalpoliza()%></td>


                    </tr>
                </tbody>

            </table>
        </div>

        <script src="js/jquery-3.5.1.js" type="text/javascript"></script>

    </body>
    <jsp:include page="Foot.jsp" flush="true"></jsp:include>

    <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
