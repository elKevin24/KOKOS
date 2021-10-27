<%-- 
    Document   : Menu
    Created on : 30/07/2021, 23:01:17
    Author     : busqu
--%>

<%@page import="controlador.BeanDetalleEnvio"%>
<%@page import="modelo.Envios"%>
<%@page import="controlador.BeanEnvios"%>
<%@page import="modelo.Usuario"%>
<%@page import="controlador.persona"%>
<%@page import="java.util.LinkedList"%>
<%@page import="modelo.Poliza"%>
<%@page import="controlador.BeanPoliza"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<jsp:include page="Head.jsp" flush="true"></jsp:include>

    <!--Let browser know website is optimized for mobile-->

<%

    String user = String.valueOf(session.getAttribute("usuario"));

    persona per = new persona();
    per = Usuario.Consultar(user);

    String id = request.getParameter("id");

    BeanEnvios pol = new BeanEnvios();
    pol = Envios.Consultar(id);

%>


<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.min.js"></script>
<script src="js/jspdf.plugin.autotable.js" type="text/javascript"></script>
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>





</head>
<body>
<div class="content-inner">
    <!-- Page Header-->
    <header class="page-header">
        <div class="container-fluid">
            
            <button class="btn btn-primary" onclick="tablepdf()">PDF</button>
        </div>
    </header>


    <div class="container">

        <div class="table-responsive-lg">
            <div id="render_me">
                <table id="customers" class="table table-bordered table-striped table-hover" class="text-center">
                    <thead class="text-center">
                        <tr>
                            <th>
                                <img id="logo" width="100px" src="img/logo.jpg" alt=""/>

                            </th>
                            <th colspan="6"  class="text-center">
                                <p>ENVIO KOKOS BOUTIQUE</p> 

                            </th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <td  class="text-center">
                                Numero de Envio: <%= pol.getId_envio()%>
                            </td>
                            <td colspan="4" class="text-center">
                                Tienda que se Envia:         <%= pol.getTienda_id()%>                </td>
                            <td colspan="2" class="text-center">
                                Encargada de Tienda:  <%= pol.getStatus()%>
                            </td>

                        </tr>
                        <tr class="blue lighten-2">
                            <th colspan="8" class="text-center">
                                Datos de Envio
                            </th>

                        </tr>
                        <tbody>
                            <tr>
                                <th>Numero</th>                                                     
                                <th>Cantidad</th>
                                <th>Codigo</th>
                                <th>Precio Venta</th>
                                <th>Prenda</th>
                                <th>Marcas</th>
                                <th>Talla</th>
                                <th>Descripcion</th>                                
                            </tr>
                        
                            <%

                                LinkedList<BeanDetalleEnvio> lista = Envios.consultaEnviosDetalle(id);

                                for (int i = 0; i < lista.size(); i++) {
                                    
                                    out.println("<td>" + i+ "</td>");
                                    out.println("<td>" + lista.get(i).getCantidad()+ "</td>");
                                    out.println("<td>" + lista.get(i).getCodigo()+ "</td>");
                                    out.println("<td>" + lista.get(i).getPrecio_venta()+ "</td>");
                                    out.println("<td>" + lista.get(i).getPrenda()+ "</td>");
                                    out.println("<td>" + lista.get(i).getMarcas()+ "</td>");
                                    out.println("<td>" + lista.get(i).getTalla()+ "</td>");
                                    out.println("<td>" + lista.get(i).getDescripcion()+ "</td>");
                                    
                                    out.println("</tr>");

                                }

                            %>  



                        </tbody>
                        

                </table>              
            </div>
        </div>
                            
    </div>

</div>






</div>


<script type="text/javascript">
    function tablepdf() {

        var logo = document.getElementById("logo");
        var doc = new jsPDF('p', 'mm', 'letter');
        margins = {
            top: 150,
            bottom: 60,
            left: 40,
            right: 40,
            width: 600
        };
        var y = 20;
        doc.setLineWidth(2);

        doc.setLineWidth(2);
        doc.addImage(logo, 'jpg', 3, 2);
        doc.autoTable({
            html: '#customers',
            theme: 'grid',

        })
        doc.save('Envio.pdf');
    }
</script>






<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</body>
</html>
