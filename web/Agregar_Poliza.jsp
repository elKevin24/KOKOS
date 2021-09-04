<%-- 
    Document   : Menu
    Created on : 30/07/2021, 23:01:17
    Author     : busqu
--%>

<%@page import="controlador.persona"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="Head.jsp" flush="true"></jsp:include>
    <!--<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>-->
    
    <%
            
        String user  = String.valueOf(session.getAttribute("usuario"));
        
        persona per = new persona();
        per = Usuario.Consultar(user);
        
        
            %>
    <div class="container">
        <form class="row g-3" action="ServletPoliza" method="post" autocomplete="off">
            <div class="col-md-6">
                <label for="numero_poliza" class="form-label">Numero Poliza</label>
                <input type="text" class="form-control" id="numero_poliza" name="numero_poliza">
            </div>
            <div class="col-md-6">
                <label for="referencia" class="form-label">Referencia</label>
                <input type="text" class="form-control" id="referencia" name="referencia">
            </div>
            <div class="col-12">
                <label for="descripcion" class="form-label">Descripcion</label>
                <input type="text" class="form-control" id="descripcion" name="descripcion">
            </div>
            <div class="col-md-6">
                <label for="total_prendas" class="form-label">Total Prendas</label>
                <input type="number" class="form-control" id="total_prendas" name="total_prendas">
            </div>
            <div class="col-md-6">
                <label for="prendas_danadas" class="form-label">Prendas Dañadas</label>
                <input type="number" class="form-control" id="prendas_dañadas" name="prendas_danadas">
            </div>
           <div class="col-md-12">
               </br>
               </div>
            <input  type="hidden" value="<%= per.getId_login() %>" name="usuario">
            <input  type="hidden" value="1" name="param">
              <div class="col-auto">
                  
    <button type="submit" class="btn btn-primary">Submit</button>
  </div>
            
        </form>
    </div>
<jsp:include page="Foot.jsp" flush="true"></jsp:include>

<!--<script src="js/bootstrap.min.js" type="text/javascript"></script>-->