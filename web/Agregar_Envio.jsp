<%-- 
    Document   : Menu
    Created on : 30/07/2021, 23:01:17
    Author     : busqu
--%>

<%@page import="modelo.Tienda"%>
<%@page import="controlador.BeanTienda"%>
<%@page import="modelo.Marcas"%>
<%@page import="controlador.BeanMarcas"%>
<%@page import="modelo.Tipo_Prenda"%>
<%@page import="controlador.BeanPrenda"%>
<%@page import="java.util.LinkedList"%>
<%@page import="modelo.Poliza"%>
<%@page import="controlador.BeanPoliza"%>
<%@page import="controlador.persona"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="Head.jsp" flush="true"></jsp:include>
    <!--<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>-->

<%

    String user = String.valueOf(session.getAttribute("usuario"));

    persona per = new persona();
    per = Usuario.Consultar(user);


%>

<div class="content-inner">
    <!-- Page Header-->
    <header class="page-header">
        <div class="container-fluid">
            <h2 class="no-margin-bottom">Agregar Envio</h2>
        </div>
    </header>
    <div class="container">
        <form class="row g-3" action="ServletEnvios" method="post" autocomplete="off">
            <div class="col-md-12">
                </br>

            </div>
            <div class="col-md-4">
                <label for="Tienda" class="form-label">Seleccione Tienda</label>
                <select class="form-select" aria-label="Default select example" id="Tienda" name="Tienda" required>
                    <option selected>Seleccionar Tienda</option>


                    <%                    LinkedList<BeanTienda> lista = Tienda.consulta_tienda();

                        for (int i = 0; i < lista.size(); i++) {

                            //2
                            out.println("<option value='" + lista.get(i).getId() + "'>" + lista.get(i).getNombre() + "</option>");

                        }


                    %>  

                </select>
            </div>
            <div class="col-md-8">
                <label for="Tienda_info" class="form-label">Informacion de Tienda</label>
                <span id="Tienda_info"></span>
            </div>

            <div class="table-responsive">
                <table border="1" class="table table-striped" id="tablaprueba">
                    <thead>
                        <tr>
                            <th colspan="8"><center>SERVICIOS</center></th>

                    </tr>
                    </thead>
                    <thead class="thead">
                        <tr class="center">
                            <th>CODIGO</th>
                            <th>CANTIDAD</th>
                            <th>PRENDA</th>
                            <th>MARCA</th>                            
                            <th>TALLA</th>


                        </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>


            <div class="form-group">
                <button type="button" class="btn btn-primary" onclick="agregarFila()">Agregar Fila</button>
                <button type="button" class="btn btn-danger" onclick="eliminarFila()">Eliminar Fila</button>
            </div>





            <input  type="hidden" value="<%= per.getId_login()%>" name="usuario" required>
            <input  type="hidden" value="1" name="param">
            <input  type="hidden" id="cont" name="cont">
            <div class="col-auto">

                <button type="submit" class="btn btn-primary">Submit</button>
            </div>

        </form>
    </div>


    <script>
        var a = 0;
        var lastChar;
        function agregarFila() {
            a++;
            document.getElementById("tablaprueba").insertRow(-1).innerHTML = `<td>
                    <input type="text" id="CODIGO` + a + `" class="form-control" placeholder="CODIGO PRENDA" aria-label="CODIGO PRENDA"   onkeyup="buscar_nav(this.value,this.id)" aria-describedby="addon-wrapping" name="CODIGO` + a + `">
                                            <input type="hidden" id="codigo_nav` + a + `" name="codigo_nav` + a + `">
                                            <div id="busca_nav_resultado` + a + `" class="z"></div></div></td>

    <td id="Cantidad Prenda` + a + `"><input type="number" id="Cantidad` + a + `" class="form-control" placeholder="Cantidad Prendas" aria-label="Cantidad Prendas"  aria-describedby="addon-wrapping" name="Cantidad` + a + `" min="1"></td>
    <td id="Prenda` + a + `"></td>
    <td id="Marca` + a + `"></td>
    <td id="Talla` + a + `"></td>`;
            document.getElementById("cont").value = a;


        }

        function eliminarFila() {

            a--;
            document.getElementById("cont").value = a;
            var table = document.getElementById("tablaprueba");
            var rowCount = table.rows.length;
            //console.log(rowCount);

            if (rowCount <= 2)
                alert('No se puede eliminar el encabezado');
            else
                table.deleteRow(rowCount - 1);
        }

    </script>
    <script>

        function buscar_nav(valor, valor1) {
            //lo que el usuario escribio

            //lastChar = valor1[valor1.length -1];
            lastChar = valor1.replace(/\D/g, '');



            var txtFiltro = valor;
            $.ajax({
                url: "buscaArticulo.do",
                data: {
                    filtro: txtFiltro,

                },
                success: function (result) {
                    $("#busca_nav_resultado" + lastChar + "").html(result);
                }
            });
        }


        function myFunction2(valor, valor2, valor3, valor4, valor5, valor6) {



            document.getElementById("CODIGO" + lastChar + "").value = valor;
            document.getElementById("codigo_nav" + lastChar + "").value = valor2;
            document.getElementById("Prenda" + lastChar + "").innerHTML = valor3;
            document.getElementById("Marca" + lastChar + "").innerHTML = valor4;
            document.getElementById("Talla" + lastChar + "").innerHTML = valor5;
            document.getElementById("Cantidad" + lastChar + "").max = valor6;
            document.getElementById("busca_nav_resultado" + lastChar + "").innerHTML = " ";
        }

        document.getElementById("Tienda").addEventListener("change", myFunction);

        function myFunction() {

            var txtFiltro = $("#Tienda").val();
            ;
            $.ajax({
                url: "buscaTienda.do",
                data: {
                    filtro: txtFiltro

                },
                success: function (result) {
                    $("#Tienda_info").html(result);
                }
            });
        }



    </script>

    <jsp:include page="Foot.jsp" flush="true"></jsp:include>

    <!--<script src="js/bootstrap.min.js" type="text/javascript"></script>-->