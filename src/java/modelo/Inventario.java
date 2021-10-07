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
        String sql = "SELECT A.id_inventario, B.prenda, C.marcas, D.talla, A.precio_costo, A.precio_venta, A.codigo, E.usuario, A.fecha, A.status, A.cantidad, A.descripcion FROM \n"
                + "kokos.inventario A, kokos.prenda B, kokos.marcas C, kokos.tallas D, kokos.usuarios E\n"
                + "where A.prenda = B.id_prenda\n"
                + "AND  A.marca = C.id_marcas\n"
                + "and A.talla = D.id_talla\n"
                + "AND A.usuario_id = E.id_usuario order by 1 DESC";

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
                        user.setNumero_Prenda(rs.getString(11));
                        user.setDescripcion(rs.getString(12));

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
                        + "`cantidad`,\n"
                        + "`descripcion`,\n"
                        + "`usuario_id`)\n"
                        + "VALUES\n"
                        + "('" + inv.getPrenda() + "',\n"
                        + "'" + inv.getMarca() + "',\n"
                        + "'" + inv.getTalla() + "',\n"
                        + "'" + inv.getPrecio_costo() + "',\n"
                        + "'" + inv.getPrecio_venta() + "',\n"
                        + "UPPER('" + inv.getCodigo() + "'),\n"
                        + "'" + inv.getNumero_Prenda() + "',\n"
                        + "UPPER('" + inv.getDescripcion() + "'),\n"
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

    public static BeanInventario ConsultarUnique(String id) {
        BeanInventario user = new BeanInventario();
        System.out.println("entrando a consultar");

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT \n"
                        + "	IFNULL(`inventario`.`id_inventario`,' ') id_inventario,\n"
                        + "    IFNULL(`inventario`.`prenda`,' ') prenda,\n"
                        + "    IFNULL(`inventario`.`marca`,' ') marca,\n"
                        + "    IFNULL(`inventario`.`talla`,' ') talla,\n"
                        + "    IFNULL(`inventario`.`cantidad`,' ') cantidad,\n"
                        + "    IFNULL(`inventario`.`descripcion`, ' ') descripcion,\n"
                        + "    IFNULL(`inventario`.`precio_costo`,' ') precio_costo,\n"
                        + "    IFNULL(`inventario`.`precio_venta`,' ') precio_venta,\n"
                        + "    IFNULL(`inventario`.`usuario_id`,' ') usuario_id,\n"
                        + "    IFNULL(`inventario`.`fecha`,' ') fecha,\n"
                        + "    IFNULL(`inventario`.`status`,' ') estatus,\n"
                        + "    IFNULL(`inventario`.`codigo`,' ') codigo\n"
                        + "    \n"
                        + "FROM `kokos`.`inventario` where id_inventario = " + id + " ")) {
                    while (rs.next()) {

                        user.setId_inventario(rs.getString(1));
                        user.setPrenda(rs.getString(2));
                        user.setMarca(rs.getString(3));
                        user.setTalla(rs.getString(4));
                        user.setNumero_Prenda(rs.getString(5));
                        user.setDescripcion(rs.getString(6));
                        user.setPrecio_costo(rs.getString(7));
                        user.setPrecio_venta(rs.getString(8));
                        user.setUsuario_id(rs.getString(9));
                        user.setFecha(rs.getString(10));
                        user.setStatus(rs.getString(11));
                        user.setCodigo(rs.getString(12));
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

    public static String Editar(BeanInventario poliza, String id) {
        String result = null;
        String sql = null;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();

                sql = "UPDATE `kokos`.`inventario` SET\n"
                        
                        + "`prenda` = '" + poliza.getPrenda()+ "',\n"
                        + "`marca` = '" + poliza.getMarca()+ "',\n"
                        + "`talla` = " + poliza.getTalla()+ ",\n"
                        + "`cantidad` = " + poliza.getNumero_Prenda()+ ",\n"
                        + "`descripcion` = '" + poliza.getDescripcion()+ "',\n"
                        + "`precio_costo` = " + poliza.getPrecio_costo()+ ",\n"
                        + "`precio_venta` = " + poliza.getPrecio_venta()+ ",\n"
                        + "`usuario_id` = " + poliza.getUsuario_id()+ ",\n"
                        + "`fecha` = now(),\n"
                        + "`codigo` = '" + poliza.getCodigo()+ "'\n"
                        + "WHERE `id_inventario` = " + id + "";

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
