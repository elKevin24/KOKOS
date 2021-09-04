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

    
    
    


    public BeanPoliza(String numero_poliza, String referencia, 
            String descripcion,  String total_prendas, String prendas_dañadas, String usuario_id ) {
        
        
        this.numero_poliza = numero_poliza;
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.total_prendas = total_prendas;
        this.prendas_dañadas = prendas_dañadas;   
        this.usuario_id = usuario_id;


        
        
    }

    private String id_poliza;
    private String numero_poliza;
    private String referencia;
    private String descripcion;
    private String total_prendas;
    private String prendas_dañadas;
    private String fecha;
    private String status;
    private String usuario_id;
    
    
    public BeanPoliza() {
    }

}
