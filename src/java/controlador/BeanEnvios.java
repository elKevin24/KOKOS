package controlador;

public class BeanEnvios {

    public String getId_envio() {
        return id_envio;
    }

    public void setId_envio(String id_envio) {
        this.id_envio = id_envio;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getTienda_id() {
        return tienda_id;
    }

    public void setTienda_id(String tienda_id) {
        this.tienda_id = tienda_id;
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

    

    public BeanEnvios(String tienda_id, String usuario_id
            ) {

        
        this.tienda_id = tienda_id;        
        this.usuario_id = usuario_id;

    }

    private String id_envio;
    private String usuario_id;    
    private String tienda_id;    
    private String fecha;
    private String status;

    public BeanEnvios() {
    }

}
