package controlador;

public class BeanMarcas {

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

     
    
    


    public BeanMarcas(String nombre, String usuario) {
        
        
        this.nombre = nombre;
        this.usuario = usuario;


        
        
    }

    private String id;
    private String nombre;
    private String usuario;
    private String fecha;
    private String status;
    
    
    public BeanMarcas() {
    }

}
