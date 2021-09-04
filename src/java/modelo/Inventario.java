package modelo;

import controlador.BeanInventario;
import controlador.BeanPoliza;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.LinkedList;

public class Inventario {

    public static LinkedList<BeanInventario> consultaInventario() throws SQLException {
        LinkedList<BeanInventario> inv = new LinkedList<>();
        String sql = "SELECT A.id_inventario, B.prenda, C.marcas, D.talla, A.precio_costo, A.precio_venta, A.codigo, E.usuario, A.fecha, A.status FROM \n"
                + "kokos.inventario A, kokos.prenda B, kokos.marcas C, kokos.tallas D, kokos.usuarios E\n"
                + "where A.prenda = B.id_prenda\n"
                + "AND  A.marca = C.id_marcas\n"
                + "and A.talla = D.id_talla\n"
                + "AND A.usuario_id = E.id_usuario";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanInventario user = new BeanInventario();
                        user.setId_inventario(rs.getString(1));
                        user.setPrenda(rs.getString(2));
                        user.setMarca(rs.getString(3));
                        user.setTalla(rs.getString(4));
                        user.setPrecio_costo(rs.getString(5));
                        user.setPrecio_venta(rs.getString(6));
                        user.setCodigo(rs.getString(7));
                        user.setUsuario_id(rs.getString(8));
                        user.setFecha(rs.getString(9));
                        user.setStatus(rs.getString(10));

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

    public static LinkedList<BeanInventario> consultaInventario(String filtro) throws SQLException {
        LinkedList<BeanInventario> inv = new LinkedList<>();
        String sql = "SELECT A.id_inventario, B.prenda, C.marcas, D.talla, A.precio_costo, A.precio_venta, A.codigo FROM \n"
                + "kokos.inventario A, kokos.prenda B, kokos.marcas C, kokos.tallas D, kokos.usuarios E\n"
                + "where A.prenda = B.id_prenda\n"
                + "AND A.marca = C.id_marcas\n"
                + "and A.talla = D.id_talla\n"
                + "AND A.usuario_id = E.id_usuario\n"
                + "AND CONCAT(A.codigo , C.marcas) LIKE  '%" + filtro + "%'";

        //String sql = "SELECT CODIGO, NOMBRE FROM FINANCIERO.ASFT_USUARIOS_DE_SERVICIOS WHERE CO_TDU_CODIGO = 1 AND CODIGO||' '||NOMBRE  LIKE '%" + filtro + "%' ";
        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanInventario user = new BeanInventario();
                        user.setId_inventario(rs.getString(1));
                        user.setPrenda(rs.getString(2));
                        user.setMarca(rs.getString(3));
                        user.setTalla(rs.getString(4));
                        user.setPrecio_costo(rs.getString(5));
                        user.setPrecio_venta(rs.getString(6));
                        user.setCodigo(rs.getString(7));

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

    public static String agregar(BeanInventario inv) {
        String agregado = null;

        String sql = null;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                sql = "INSERT INTO `kokos`.`inventario`\n"
                        + "(`prenda`,\n"
                        + "`marca`,\n"
                        + "`talla`,\n"
                        + "`precio_costo`,\n"
                        + "`precio_venta`,\n"
                        + "`codigo`,\n"
                        + "`usuario_id`)\n"
                        + "VALUES\n"
                        + "('" + inv.getPrenda() + "',\n"
                        + "'" + inv.getMarca() + "',\n"
                        + "'" + inv.getTalla() + "',\n"
                        + "'" + inv.getPrecio_costo() + "',\n"
                        + "'" + inv.getPrecio_venta() + "',\n"
                        + "'" + inv.getCodigo() + "',\n"
                        + "'" + inv.getUsuario_id() + "')";

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
