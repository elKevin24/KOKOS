package controlador;

public class BeanDetalleEnvio {

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public String getInventario_id() {
        return inventario_id;
    }

    public void setInventario_id(String inventario_id) {
        this.inventario_id = inventario_id;
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

    public String getId_envio() {
        return id_envio;
    }

    public void setId_envio(String id_envio) {
        this.id_envio = id_envio;
    }

    

    

    public BeanDetalleEnvio(int id_detalle, String inventario_id
            ) {

        
        this.id_detalle = id_detalle;        
        this.inventario_id = inventario_id;
       

    }

    private int id_detalle;
    private String inventario_id;      
    private String fecha;
    private String status;
    private String id_envio;

    public BeanDetalleEnvio() {
    }

}