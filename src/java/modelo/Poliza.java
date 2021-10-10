package modelo;

import controlador.BeanPoliza;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.LinkedList;

public class Poliza {

    public static LinkedList<BeanPoliza> consultaPolizas() throws SQLException {
        LinkedList<BeanPoliza> usuarios = new LinkedList<>();
        String sql = "SELECT A.id_poliza, A.numero_poliza, A.referencia, A.descripcion, A.total_prendas, A.prendas_dañadas, A.fecha, A.status, B.usuario \n"
                + "FROM kokos.poliza A, kokos.usuarios B\n"
                + "where A.usuario_id = B.id_usuario and A.status = '1'";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanPoliza user = new BeanPoliza();
                        user.setId_poliza(rs.getString("id_poliza"));
                        user.setNumero_poliza(rs.getString("numero_poliza"));
                        user.setReferencia(rs.getString("referencia"));
                        user.setDescripcion(rs.getString("descripcion"));
                        user.setTotal_prendas(rs.getString("total_prendas"));
                        user.setPrendas_dañadas(rs.getString("prendas_dañadas"));
                        user.setFecha(rs.getString("fecha"));
                        user.setStatus(rs.getString(8));
                        user.setUsuario_id(rs.getString(9));

                        usuarios.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.err.println("consultar" + e);
        }

        return usuarios;
    }

    public static String agregar(BeanPoliza poliza) {
        String agregado = null;

        String sql = null;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                sql = "INSERT INTO `kokos`.`poliza`\n"
                        + "(`numero_poliza`,\n"
                        + "`referencia`,\n"
                        + "`descripcion`,\n"
                        + "`total_prendas`,\n"
                        + "`prendas_dañadas`,\n"
                        + "`pais`,\n"
                        + "`impuestopoliza`,\n"
                        + "`almacenaje`,\n"
                        + "`gestoraduanero`,\n"
                        + "`fleteaereo`,\n"
                        + "`tramitador`,\n"
                        + "`gastosimprevistos`,\n"
                        + "`totalpoliza`,\n"
                        + "`usuario_id`)\n"
                        + "VALUES\n"
                        + "('" + poliza.getNumero_poliza() + "',\n"
                        + "'" + poliza.getReferencia() + "',\n"
                        + "'" + poliza.getDescripcion() + "',\n"
                        + "'" + poliza.getTotal_prendas() + "',\n"
                        + "'" + poliza.getPrendas_dañadas() + "',\n"
                        + "'" + poliza.getPais()+ "',\n"
                        + "'" + poliza.getImpuestopoliza()+ "',\n"
                        + "'" + poliza.getAlmacenaje()+ "',\n"
                        + "'" + poliza.getGestoraduanero()+ "',\n"
                        + "'" + poliza.getFleteaereo()+ "',\n"
                        + "'" + poliza.getTramitador()+ "',\n"
                        + "'" + poliza.getGastosimprevistos()+ "',\n"
                        + "'" + poliza.getTotalpoliza()+ "',\n"
                        + "'" + poliza.getUsuario_id() + "')";

                st.execute(sql);

                agregado = "bien";
                st.close();
            }

        } catch (SQLException e) {
            agregado = "false";
            System.err.println("" + e + sql);
        }
        return agregado;
    }

    public static BeanPoliza Consultar(String id) {
        BeanPoliza user = new BeanPoliza();
        System.out.println("entrando a consultar");

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT * FROM kokos.poliza where id_poliza = " + id + " and status = 1 ")) {
                    while (rs.next()) {

                        user.setId_poliza(rs.getString("id_poliza"));
                        user.setNumero_poliza(rs.getString("numero_poliza"));
                        user.setReferencia(rs.getString("referencia"));
                        user.setDescripcion(rs.getString("descripcion"));
                        user.setTotal_prendas(rs.getString("total_prendas"));
                        user.setPrendas_dañadas(rs.getString("prendas_dañadas"));
                        user.setPais(rs.getString("pais"));
                        user.setImpuestopoliza(rs.getString("impuestopoliza"));
                        user.setAlmacenaje(rs.getString("almacenaje"));
                        user.setGestoraduanero(rs.getString("gestoraduanero"));
                        user.setFleteaereo(rs.getString("fleteaereo"));
                        user.setTramitador(rs.getString("tramitador"));
                        user.setGastosimprevistos(rs.getString("gastosimprevistos"));
                        user.setTotalpoliza(rs.getString("totalpoliza"));
                        user.setFecha(rs.getString("fecha"));
                        user.setUsuario_id(rs.getString("usuario_id"));
                        
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.err.println("" + e);
        }
        return user;

    }

    public static boolean Eliminar(int id) {
        boolean actualizado = false;

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //UNA COMA ME HIZO DESVELARME HASTA LAS DOS DE LA MAÑANA
                String sql = "UPDATE `kokos`.`poliza` SET `status` = 2 WHERE `id_poliza` = " + id + "";
                //"update tbl_seccion set grado ='"+usuario.getGrado()+"', seccion='"+usuario.getSeccion()+"', Id_nivel='"+usuario.getId_nivel()+"' where Id_seccion="+usuario.getId_seccion()+"";

                st.execute(sql);
                actualizado = true;
                st.close();
            }

        } catch (SQLException e) {
            System.err.println("" + e);
            actualizado = false;
        }

        return actualizado;
    }

    public static String Editar(BeanPoliza poliza, String id) {
        String result = null;
String sql = null;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();

                 sql = "UPDATE `kokos`.`poliza` SET\n"
                        + "`numero_poliza` = '" + poliza.getNumero_poliza() + "',\n"
                        + "`referencia` = '" + poliza.getReferencia() + "',\n"
                        + "`descripcion` = '" + poliza.getDescripcion() + "',\n"
                        + "`total_prendas` = " + poliza.getTotal_prendas() + ",\n"
                        + "`prendas_dañadas` = " + poliza.getPrendas_dañadas() +",\n"
                         
                        + "`pais` = '" + poliza.getPais()+"',\n"
                        + "`impuestopoliza` = " + poliza.getImpuestopoliza()+",\n"
                        + "`almacenaje` = " + poliza.getAlmacenaje()+",\n"
                        + "`gestoraduanero` = " + poliza.getGestoraduanero()+",\n"
                        + "`fleteaereo` = " + poliza.getFleteaereo()+",\n"
                        + "`tramitador` = " + poliza.getTramitador()+",\n"
                        + "`gastosimprevistos` = " + poliza.getGastosimprevistos()+",\n"
                        + "`totalpoliza` = " + poliza.getTotalpoliza()+"\n"
                         
                        + "WHERE `id_poliza` = " + id + "";

                st.execute(sql);
                result = "ok";
                st.close();
            }

        } catch (SQLException e) {
            System.err.println("" + e+ sql);
            
        }

        return result;
    }

}
