<%-- 
    Document   : Menu
    Created on : 30/07/2021, 23:01:17
    Author     : busqu
--%>

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
<div class="container">
    <form class="row g-3" action="ServletArticulos" method="post" autocomplete="off">
        <div class="col-md-12">
            </br>

        </div>
        <div class="col-md-4">
            <label for="Prenda" class="form-label">Prenda</label>
            <select id="Prenda" name="Prenda" class="form-select" required>
                <option selected>Seleccione Tipo de Prenda</option>

                <%                     LinkedList<BeanPrenda> lista = Tipo_Prenda.consultaTipo_Prenda();

                    for (int i = 0; i < lista.size(); i++) {

                        //2
                        out.println("<option value='" + lista.get(i).getId() + "'>" + lista.get(i).getName() + "</option>");

                    }


                %>  

            </select>
        </div>
        <div class="col-md-4">
            <label for="Talla" class="form-label">Talla</label>
            <select id="Talla" name="Talla" class="form-select" required>
                <option selected>Seleccione Talla</option>

            </select>
        </div>

        <div class="col-md-4">
            <label for="Marca" class="form-label">Marca</label>
            <select id="Marca" name="Marca" class="form-select" required>
                <option selected>Seleccione Marca</option>
                <%                    
                    LinkedList<BeanMarcas> lista1 = Marcas.consulta();

                    for (int i = 0; i < lista1.size(); i++) {

                        //2
                        out.println("<option value='" + lista1.get(i).getId() + "'>" + lista1.get(i).getNombre()+ "</option>");

                    }


                %> 
            </select>
        </div>
        <div class="col-md-4">
            <label for="precio_costo" class="form-label">Precio Costo</label>
            <input type="number" class="form-control" id="precio_costo" name="precio_costo" required >
        </div>
        <div class="col-md-4">
            <label for="precio_venta" class="form-label">Precio Venta</label>
            <input type="number" class="form-control" id="precio_venta" name="precio_venta" required>
        </div>

        <div class="col-md-4">
            <label for="codigo" class="form-label">Codigo de Prenda</label>
            <input type="text" class="form-control" id="codigo" name="codigo" required>
        </div>
        <div class="col-md-12">
            </br>
        </div>
        <input  type="hidden" value="<%= per.getId_login()%>" name="usuario" required>
        <input  type="hidden" value="1" name="param">
        <div class="col-auto">

            <button type="submit" class="btn btn-primary">Submit</button>
        </div>

    </form>
</div>
<script>

    document.getElementById("Prenda").addEventListener("change", myFunction);


    function myFunction() {
        var x = document.getElementById("Prenda").value;
        var txtFiltro = $("#Prenda").val();
        $.ajax({
            url: "busca.do",
            data: {
                filtro: txtFiltro,

            },
            success: function (result) {
                $("#Talla").html(result);
            }
        });
    }

</script>
<jsp:include page="Foot.jsp" flush="true"></jsp:include>

<!--<script src="js/bootstrap.min.js" type="text/javascript"></script>-->