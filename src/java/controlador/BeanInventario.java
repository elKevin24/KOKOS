package controlador;

public class BeanInventario {

    public String getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(String id_inventario) {
        this.id_inventario = id_inventario;
    }

    public String getPrenda() {
        return prenda;
    }

    public void setPrenda(String prenda) {
        this.prenda = prenda;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(String precio_costo) {
        this.precio_costo = precio_costo;
    }

    public String getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(String precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
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

    public String getNumero_Prenda() {
        return Numero_Prenda;
    }

    public void setNumero_Prenda(String Numero_Prenda) {
        this.Numero_Prenda = Numero_Prenda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

    public BeanInventario(String prenda, String marca,
            String talla, String precio_costo, String precio_venta, String codigo, String usuario_id, String Numero_Prenda, String descripcion) {

        this.prenda = prenda;
        this.marca = marca;
        this.talla = talla;
        this.precio_costo = precio_costo;
        this.precio_venta = precio_venta;
        this.codigo = codigo;
        this.usuario_id = usuario_id;
        this.Numero_Prenda = Numero_Prenda;
        this.descripcion = descripcion;

    }

    private String id_inventario;
    private String prenda;
    private String marca;
    private String talla;
    private String precio_costo;
    private String precio_venta;
    private String codigo;
    private String usuario_id;
    private String fecha;
    private String status;
    private String Numero_Prenda;
    private String descripcion;
    

    public BeanInventario() {
    }

}
