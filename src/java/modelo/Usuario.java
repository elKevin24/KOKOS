/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.BeanPoliza;
import controlador.persona;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kcordon
 */
public class Usuario {
    
     public static String Actualizar(persona pers) {
        String actualizado = null;
        String sql = null;

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {

                Statement st;
                st = con.createStatement();
//                UNA COMA ME HIZO DESVELARME HASTA LAS DOS DE LA MAÑANA
                //            String sql = "update COTIZADOR_WEB.CW_BUQUE_COTIZA set CWBC_ETA =  to_date('" + buque.getCWBC_ETA()+ "','yyyy-mm-dd hh24:mi'), CWBC_HORA='" + buque.getCWBC_HORA()+ "'"
                //                  + "where CWBC_COTIZACION = '"+ buque.getCWBC_COTIZACION() +"'";

                 sql = " UPDATE plan_prestaciones.plpr_usuarios\n" +
"SET\n" +
"    plpru_clave = (USUARIO_SISTEMA.f_clave('" + pers.getClave()+ "')),\n" +
"    plru_reinicio_pass = 'N'\n" +
"WHERE\n" +
"    plpru_usuario = '" + pers.getUsuario()+ "'"                   
                       ;

                st.execute(sql);
                actualizado = "bien";
                st.close();
            }

        } catch (SQLException e) {
            actualizado = "mal" + e + sql;
        }

        return actualizado;
    }
     
    public static persona  Consultar(String id) {
        persona user = new persona();
        
        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT * FROM kokos.usuarios where usuario = '"+id+"'")) {
                    while (rs.next()) {

                        user.setId_login(rs.getInt("id_usuario"));
                        user.setTipo(rs.getInt("tipo_usuario"));
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.err.println("" + e);
        }
        return user;

    }
    
}
