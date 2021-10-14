
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import controlador.Validar;
import controlador.persona;

public class personaDAO implements Validar {
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;   
  

    
    @Override
    public int Validar(persona per) {
        int r=0;
        

        String sql="SELECT usuario, contraseña FROM kokos.usuarios where usuario = ? and contraseña = ? ";
       // String sql="select * from PLAN_PRESTACIONES.plpr_usuarios  where plpru_usuario=? and PLPRU_CLAVE=?";
        
        
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, per.getUsuario());
            ps.setString(2, per.getClave());
           
            
            
            rs=ps.executeQuery();
            while(rs.next()){
                r=r+1;
                per.setUsuario(rs.getString("usuario"));
                 per.setClave(rs.getString("contraseña"));
                
            }
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        }catch (SQLException e){   
            System.out.println("modelo.personaDAO.Validar()"+e);
            return 0;
            
        }
    }
    
}
