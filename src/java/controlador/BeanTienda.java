package controlador;

public class BeanTienda {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEncargada() {
        return encargada;
    }

    public void setEncargada(String encargada) {
        this.encargada = encargada;
    }
    
    

     
    
    


    public BeanTienda(String nombre, String usuario) {
        
        
        this.nombre = nombre;
        this.usuario = usuario;


        
        
    }

    private String id;
    private String nombre;
    private String ubicacion;
    private String encargada;
    private String usuario;
    private String fecha;
    private String status;
    
    
    public BeanTienda() {
    }

}
