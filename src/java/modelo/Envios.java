package modelo;

import controlador.BeanDetalleEnvio;
import controlador.BeanEnvios;
import controlador.BeanPoliza;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.LinkedList;

public class Envios {

    static int ID = 0;

    public static int ConsultaSolicitud_ID() {

        int id = 0;
        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("select max(id_envio) id from kokos.envios")) {
                    while (rs.next()) {

                        ID = rs.getInt("id");

                    }
                }
                st.close();
            }
        } catch (SQLException e) {
            System.err.println("" + e);
        }
        return ID;

    }

    public static LinkedList<BeanEnvios> consultaEnvios() throws SQLException {
        LinkedList<BeanEnvios> inv = new LinkedList<>();
        String sql = "SELECT A.id_envio, B.nombre, A.fecha, COUNT(C.id_envio ) PRENDAS\n"
                + "FROM kokos.envios A, kokos.tiendas B, kokos.detalles_envios C\n"
                + "where A.tienda_id = B.id_tienda\n"
                + "AND A.id_envio =  C.id_envio \n"
                + "GROUP BY A.id_envio";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanEnvios user = new BeanEnvios();
                        user.setId_envio(rs.getString(1));
                        user.setTienda_id(rs.getString(2));
                        user.setFecha(rs.getString(3));
                        user.setUsuario_id(rs.getString(4));
                        

                        inv.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.err.println("consultar" + e);
        }

        return inv;
    }
//
//    public static LinkedList<BeanEnvios> consultaInventario(String filtro) throws SQLException {
//        LinkedList<BeanEnvios> inv = new LinkedList<>();
//        String sql = "SELECT A.id_inventario, B.prenda, C.marcas, D.talla, A.precio_costo, A.precio_venta, A.codigo FROM \n"
//                + "kokos.inventario A, kokos.prenda B, kokos.marcas C, kokos.tallas D, kokos.usuarios E\n"
//                + "where A.prenda = B.id_prenda\n"
//                + "AND A.marca = C.id_marcas\n"
//                + "and A.talla = D.id_talla\n"
//                + "AND A.usuario_id = E.id_usuario\n"
//                + "AND CONCAT(A.codigo , C.marcas) LIKE  '%" + filtro + "%'";
//
//        //String sql = "SELECT CODIGO, NOMBRE FROM FINANCIERO.ASFT_USUARIOS_DE_SERVICIOS WHERE CO_TDU_CODIGO = 1 AND CODIGO||' '||NOMBRE  LIKE '%" + filtro + "%' ";
//        try {
//            Conexion c = new Conexion();
//            try (Connection con = c.getConexion()) {
//                Statement st;
//                st = con.createStatement();
//
//                try (ResultSet rs = st.executeQuery(sql)) {
//                    while (rs.next()) {
//                        BeanEnvios user = new BeanEnvios();
//                        user.setId_inventario(rs.getString(1));
//                        user.setPrenda(rs.getString(2));
//                        user.setMarca(rs.getString(3));
//                        user.setTalla(rs.getString(4));
//                        user.setPrecio_costo(rs.getString(5));
//                        user.setPrecio_venta(rs.getString(6));
//                        user.setCodigo(rs.getString(7));
//
//                        inv.add(user);
//                    }
//                }
//                st.close();
//            }
//        } catch (SQLException e) {
//
//            System.err.println("consultar" + e);
//        }
//
//        return inv;
//    }

    public static String agregar(BeanEnvios inv) {
        String agregado = null;

        String sql = null;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                sql = "INSERT INTO `kokos`.`envios`\n"
                        + "(`usuario_id`,\n"
                        + "`tienda_id`)\n"
                        + "VALUES\n"
                        + "('" + inv.getUsuario_id() + "',\n"
                        + "'" + inv.getTienda_id() + "')";

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

    public static boolean agregarDetalle(BeanDetalleEnvio inv) {
        boolean agregado = false;
        int id = ConsultaSolicitud_ID();
        String sql = null;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                sql = "INSERT INTO `kokos`.`detalles_envios`\n"
                        + "(`id_detalle`,\n"
                        + "`inventario_id`,\n"
                        + "`id_envio`)\n"
                        + "VALUES\n"
                        + "('" + inv.getId_detalle() + "',\n"
                        + "'" + inv.getInventario_id() + "',"
                        + "'" + id + "')";

                st.execute(sql);

                agregado = true;
                st.close();
            }

        } catch (SQLException e) {
            agregado = false;
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
                try (ResultSet rs = st.executeQuery("SELECT * FROM kokos.poliza where id_poliza = " + id + " ")) {
                    while (rs.next()) {

                        user.setNumero_poliza(rs.getString("numero_poliza"));
                        user.setReferencia(rs.getString("referencia"));
                        user.setDescripcion(rs.getString("descripcion"));
                        user.setTotal_prendas(rs.getString("total_prendas"));
                        user.setPrendas_dañadas(rs.getString("prendas_dañadas"));
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
                        + "`prendas_dañadas` = " + poliza.getPrendas_dañadas() + "\n"
                        + "WHERE `id_poliza` = " + id + "";

                st.execute(sql);
                result = "ok";
                st.close();
            }

        } catch (SQLException e) {
            System.err.println("" + e + sql);

        }

        return result;
    }

}
