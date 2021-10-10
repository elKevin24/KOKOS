<%-- 
    Document   : Menu
    Created on : 30/07/2021, 23:01:17
    Author     : busqu
--%>

<%@page import="modelo.Poliza"%>
<%@page import="controlador.BeanPoliza"%>
<%@page import="controlador.persona"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="Head.jsp" flush="true"></jsp:include>
    <!--<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>-->
    
    <%
            
        String user  = String.valueOf(session.getAttribute("usuario"));
        
        persona per = new persona();
        per = Usuario.Consultar(user);
        

    String id_poliza = request.getParameter("id");
    
    BeanPoliza pol = new BeanPoliza();
    pol = Poliza.Consultar(id_poliza);
        
            %>
            <div class="content-inner">
            <header class="page-header">
        <div class="container-fluid">
            <h2 class="no-margin-bottom">Editar Poliza</h2>
        </div>
    </header>
    <div class="container">
        <form class="row g-3" action="ServletPoliza" method="post" autocomplete="off">
            <div class="col-md-6">
                <label for="numero_poliza" class="form-label">Numero Poliza</label>
                <input type="text" class="form-control" id="numero_poliza" name="numero_poliza" value="<%= pol.getNumero_poliza() %>">
            </div>
            <div class="col-md-6">
                <label for="referencia" class="form-label">Referencia</label>
                <input type="text" class="form-control" id="referencia" name="referencia" value="<%= pol.getReferencia()%>">
            </div>
            <div class="col-12">
                <label for="descripcion" class="form-label">Descripcion</label>
                <input type="text" class="form-control" id="descripcion" name="descripcion" value="<%= pol.getDescripcion()%>">
            </div>
            <div class="col-md-6">
                <label for="total_prendas" class="form-label">Total Prendas</label>
                <input type="number" class="form-control" id="total_prendas" name="total_prendas" value="<%= pol.getTotal_prendas()%>">
            </div>
            <div class="col-3">
                <label for="Pais" class="form-label">Pais</label>
                <input type="text" class="form-control" id="Pais" name="Pais" required value="<%= pol.getPais()%>">
            </div>
            <div class="col-9">
                <label for="descripcion" class="form-label">Descripcion</label>
                <input type="text" class="form-control" id="descripcion" name="descripcion" required value="<%= pol.getDescripcion()%>">
            </div>
            
            <div class="col-3">
                <label for="impuestopoliza" class="form-label">Impuesto Poliza</label>
                <input type="number" class="form-control" id="impuestopoliza" name="impuestopoliza" min="0" required value="<%= pol.getImpuestopoliza()%>">
            </div>
            <div class="col-3">
                <label for="almacenaje" class="form-label">Almacenaje</label>
                <input type="number" class="form-control" id="almacenaje" name="almacenaje" min="0" required value="<%= pol.getAlmacenaje()%>">
            </div>
            <div class="col-3">
                <label for="gestoraduanero" class="form-label">Gestor Aduanero</label>
                <input type="number" class="form-control" id="gestoraduanero" name="gestoraduanero" min="0" required value="<%= pol.getGestoraduanero()%>">
            </div>
            <div class="col-3">
                <label for="fleteaereo" class="form-label">Flete Aereo</label>
                <input type="number" class="form-control" id="fleteaereo" name="fleteaereo" min="0" required value="<%= pol.getFleteaereo()%>"> 
            </div>
            <div class="col-4">
                <label for="tramitador" class="form-label">Tramitador</label>
                <input type="number" class="form-control" id="tramitador" name="tramitador" min="0" required value="<%= pol.getTramitador()%>"> 
            </div>
            <div class="col-4">
                <label for="gastosimprevistos" class="form-label">Gastos Imprevistos</label>
                <input type="number" class="form-control" id="gastosimprevistos" name="gastosimprevistos" min="0" required value="<%= pol.getGastosimprevistos()%>">
            </div>
            <div class="col-4">
                <label for="totalpoliza" class="form-label">Total Poliza</label>
                <input type="number" class="form-control" id="totalpoliza" name="totalpoliza" min="0" required value="<%= pol.getTotalpoliza()%>">
            </div>
           <div class="col-md-12">
               </br>
               </div>
            <input  type="hidden" value="<%= per.getId_login() %>" name="usuario">
            <input  type="hidden" value="<%= id_poliza %>" name="id_poliza">
            <input  type="hidden" value="2" name="param">
              <div class="col-auto">
                  
    <button type="submit" class="btn btn-primary">Submit</button>
  </div>
            
        </form>
    </div>
<jsp:include page="Foot.jsp" flush="true"></jsp:include>

<!--<script src="js/bootstrap.min.js" type="text/javascript"></script>-->