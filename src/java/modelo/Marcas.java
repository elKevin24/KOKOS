package modelo;



import controlador.BeanMarcas;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.LinkedList;

public class Marcas {

    public static LinkedList<BeanMarcas> consulta() throws SQLException {
        LinkedList<BeanMarcas> usuarios = new LinkedList<>();
        String sql = "SELECT id_marcas, marcas FROM kokos.marcas";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanMarcas user = new BeanMarcas();
                        user.setId(rs.getString(1));
                        user.setNombre(rs.getString(2));
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

//    public static String agregar(BeanMarcas poliza) {
//        String agregado = null;
//
//        String sql = null;
//        try {
//            Conexion c = new Conexion();
//            Connection con = c.getConexion();
//            if (con != null) {
//                Statement st;
//                st = con.createStatement();
//                //campos de la tabla
//                sql = "INSERT INTO `kokos`.`poliza`\n"
//                        + "(`numero_poliza`,\n"
//                        + "`referencia`,\n"
//                        + "`descripcion`,\n"
//                        + "`total_prendas`,\n"
//                        + "`prendas_dañadas`,\n"
//                        + "`usuario_id`)\n"
//                        + "VALUES\n"
//                        + "('" + poliza.getNumero_poliza() + "',\n"
//                        + "'" + poliza.getReferencia() + "',\n"
//                        + "'" + poliza.getDescripcion() + "',\n"
//                        + "'" + poliza.getTotal_prendas() + "',\n"
//                        + "'" + poliza.getPrendas_dañadas() + "',\n"
//                        + "'" + poliza.getUsuario_id() + "')";
//
//                st.execute(sql);
//
//                agregado = "bien";
//                st.close();
//            }
//
//        } catch (SQLException e) {
//            agregado = "false";
//            System.err.println("" + e + sql);
//        }
//        return agregado;
//    }
//
//    public static BeanMarcas Consultar(String id) {
//        BeanMarcas user = new BeanMarcas();
//        System.out.println("entrando a consultar");
//
//        try {
//            Conexion c = new Conexion();
//            try (Connection con = c.getConexion()) {
//                Statement st;
//                st = con.createStatement();
//                try (ResultSet rs = st.executeQuery("SELECT * FROM kokos.poliza where id_poliza = " + id + " ")) {
//                    while (rs.next()) {
//
//                        user.setNumero_poliza(rs.getString("numero_poliza"));
//                        user.setReferencia(rs.getString("referencia"));
//                        user.setDescripcion(rs.getString("descripcion"));
//                        user.setTotal_prendas(rs.getString("total_prendas"));
//                        user.setPrendas_dañadas(rs.getString("prendas_dañadas"));
//                    }
//                }
//                st.close();
//            }
//        } catch (SQLException e) {
//
//            System.err.println("" + e);
//        }
//        return user;
//
//    }
//
//    public static boolean Eliminar(int id) {
//        boolean actualizado = false;
//
//        try {
//            Conexion c = new Conexion();
//            Connection con = c.getConexion();
//            if (con != null) {
//                Statement st;
//                st = con.createStatement();
//                //UNA COMA ME HIZO DESVELARME HASTA LAS DOS DE LA MAÑANA
//                String sql = "UPDATE `kokos`.`poliza` SET `status` = 2 WHERE `id_poliza` = " + id + "";
//                //"update tbl_seccion set grado ='"+usuario.getGrado()+"', seccion='"+usuario.getSeccion()+"', Id_nivel='"+usuario.getId_nivel()+"' where Id_seccion="+usuario.getId_seccion()+"";
//
//                st.execute(sql);
//                actualizado = true;
//                st.close();
//            }
//
//        } catch (SQLException e) {
//            System.err.println("" + e);
//            actualizado = false;
//        }
//
//        return actualizado;
//    }
//
//    public static String Editar(BeanMarcas poliza, String id) {
//        String result = null;
//String sql = null;
//        try {
//            Conexion c = new Conexion();
//            Connection con = c.getConexion();
//            if (con != null) {
//                Statement st;
//                st = con.createStatement();
//
//                 sql = "UPDATE `kokos`.`poliza` SET\n"
//                        + "`numero_poliza` = '" + poliza.getNumero_poliza() + "',\n"
//                        + "`referencia` = '" + poliza.getReferencia() + "',\n"
//                        + "`descripcion` = '" + poliza.getDescripcion() + "',\n"
//                        + "`total_prendas` = " + poliza.getTotal_prendas() + ",\n"
//                        + "`prendas_dañadas` = " + poliza.getPrendas_dañadas() + "\n"
//                        + "WHERE `id_poliza` = " + id + "";
//
//                st.execute(sql);
//                result = "ok";
//                st.close();
//            }
//
//        } catch (SQLException e) {
//            System.err.println("" + e+ sql);
//            
//        }
//
//        return result;
//    }

}