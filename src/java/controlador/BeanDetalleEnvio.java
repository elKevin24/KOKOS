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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPrenda() {
        return prenda;
    }

    public void setPrenda(String prenda) {
        this.prenda = prenda;
    }

    public String getMarcas() {
        return marcas;
    }

    public void setMarcas(String marcas) {
        this.marcas = marcas;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    

    public BeanDetalleEnvio(int id_detalle, String inventario_id, String cantidad
            ) {

        
        this.id_detalle = id_detalle;        
        this.inventario_id = inventario_id;
        this.cantidad = cantidad;
       

    }

    private int id_detalle;
    private String inventario_id;      
    private String fecha;
    private String status;
    private String id_envio;
    private String cantidad;
    private String codigo;
    private String prenda;
    private String marcas;
    private String talla;
    private String descripcion;

    public BeanDetalleEnvio() {
    }

}
