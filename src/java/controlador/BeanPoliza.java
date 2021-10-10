package controlador;

public class BeanPoliza {

    public String getId_poliza() {
        return id_poliza;
    }

    public void setId_poliza(String id_poliza) {
        this.id_poliza = id_poliza;
    }

    public String getNumero_poliza() {
        return numero_poliza;
    }

    public void setNumero_poliza(String numero_poliza) {
        this.numero_poliza = numero_poliza;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTotal_prendas() {
        return total_prendas;
    }

    public void setTotal_prendas(String total_prendas) {
        this.total_prendas = total_prendas;
    }

    public String getPrendas_dañadas() {
        return prendas_dañadas;
    }

    public void setPrendas_dañadas(String prendas_dañadas) {
        this.prendas_dañadas = prendas_dañadas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getImpuestopoliza() {
        return impuestopoliza;
    }

    public void setImpuestopoliza(String impuestopoliza) {
        this.impuestopoliza = impuestopoliza;
    }

    public String getAlmacenaje() {
        return almacenaje;
    }

    public void setAlmacenaje(String almacenaje) {
        this.almacenaje = almacenaje;
    }

    public String getGestoraduanero() {
        return gestoraduanero;
    }

    public void setGestoraduanero(String gestoraduanero) {
        this.gestoraduanero = gestoraduanero;
    }

    public String getFleteaereo() {
        return fleteaereo;
    }

    public void setFleteaereo(String fleteaereo) {
        this.fleteaereo = fleteaereo;
    }

    public String getTramitador() {
        return tramitador;
    }

    public void setTramitador(String tramitador) {
        this.tramitador = tramitador;
    }

    public String getGastosimprevistos() {
        return gastosimprevistos;
    }

    public void setGastosimprevistos(String gastosimprevistos) {
        this.gastosimprevistos = gastosimprevistos;
    }

    public String getTotalpoliza() {
        return totalpoliza;
    }

    public void setTotalpoliza(String totalpoliza) {
        this.totalpoliza = totalpoliza;
    }

    
    
    


    public BeanPoliza(String numero_poliza, String referencia, String descripcion,  String total_prendas, String prendas_dañadas, String usuario_id,
            String pais, String impuestopoliza, String almacenaje,  String gestoraduanero, String fleteaereo, String tramitador, String gastosimprevistos, String totalpoliza) {
        
        
        this.numero_poliza = numero_poliza;
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.total_prendas = total_prendas;
        this.prendas_dañadas = prendas_dañadas;   
        this.usuario_id = usuario_id;
        
        this.pais = pais;
        this.impuestopoliza = impuestopoliza;
        this.almacenaje = almacenaje;
        this.gestoraduanero = gestoraduanero;
        this.fleteaereo = fleteaereo;
        this.tramitador = tramitador;
        this.gastosimprevistos = gastosimprevistos;
        this.totalpoliza = totalpoliza;


        
        
    }

    private String id_poliza;
    private String numero_poliza;
    private String referencia;
    private String descripcion;
    private String total_prendas;
    private String prendas_dañadas;
    private String pais;
    private String impuestopoliza;
    private String almacenaje;
    private String gestoraduanero;
    private String fleteaereo;
    private String tramitador;
    private String gastosimprevistos;
    private String totalpoliza;
    
    private String fecha;
    private String status;
    private String usuario_id;
    
    
    public BeanPoliza() {
    }

}
