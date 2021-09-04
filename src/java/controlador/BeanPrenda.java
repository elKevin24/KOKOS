package controlador;

public class BeanPrenda {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    
   
    public BeanPrenda(String name, String usuario, 
            String fecha) {
        
        
        this.name = name;
        this.usuario = usuario;
        this.fecha = fecha;       
        
    }

    private String id;
    private String name;
    private String usuario;
    private String fecha;
    private String status;
    
    
    public BeanPrenda() {
    }

}
