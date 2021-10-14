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
        String sql = "SELECT A.id_envio, B.nombre, A.fecha, sum(C.cantidad ) PRENDAS\n"
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

    public static LinkedList<BeanDetalleEnvio> consultaEnviosDetalle(String id) throws SQLException {
        LinkedList<BeanDetalleEnvio> inv = new LinkedList<>();
        String sql = "SELECT \n"
                + "det.cantidad, inv.codigo, pren.prenda, m.marcas, talla.talla, inv.descripcion\n"
                + "FROM \n"
                + "kokos.detalles_envios det, kokos.inventario inv, kokos.prenda pren, kokos.marcas m, kokos.tallas talla\n"
                + "where det.inventario_id = inv.id_inventario\n"
                + "and inv.prenda = pren.id_prenda\n"
                + "and inv.marca = m.id_marcas\n"
                + "and inv.talla = talla.id_talla\n"
                + "and det.id_envio = " + id + "";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanDetalleEnvio user = new BeanDetalleEnvio();
                        user.setCantidad(rs.getString("cantidad"));
                        user.setCodigo(rs.getString("codigo"));
                        user.setPrenda(rs.getString("prenda"));
                        user.setMarcas(rs.getString("marcas"));
                        user.setTalla(rs.getString("talla"));
                        user.setDescripcion(rs.getString("descripcion"));

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
                        + "`cantidad`,\n"
                        + "`id_envio`)\n"
                        + "VALUES\n"
                        + "('" + inv.getId_detalle() + "',\n"
                        + "'" + inv.getInventario_id() + "',"
                        + "'" + inv.getCantidad() + "',"
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

    public static BeanEnvios Consultar(String id) {
        BeanEnvios user = new BeanEnvios();
        System.out.println("entrando a consultar");

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT  a.id_envio, b.usuario, c.nombre, c.encargada, a.fecha\n"
                        + "FROM kokos.envios a, kokos.usuarios b, kokos.tiendas c \n"
                        + "where a.usuario_id = b.id_usuario\n"
                        + "and a.tienda_id = c.id_tienda\n"
                        + "and id_envio =" + id + "")) {
                    while (rs.next()) {

                        user.setId_envio(rs.getString("id_envio"));
                        user.setUsuario_id(rs.getString("usuario"));
                        user.setTienda_id(rs.getString("nombre"));
                        user.setFecha(rs.getString("fecha"));
                        user.setStatus(rs.getString("encargada"));
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
