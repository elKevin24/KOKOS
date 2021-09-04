package modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    Connection con = null;

    public Conexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //jdbc:sqlserver://localhost:1433;databaseName=db_proyecto [sa on dbo]
            String sURL = "jdbc:mysql://localhost:3306/kokos";
            con = DriverManager.getConnection(sURL, "kokos", "kokos100");

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.print("Error: " + ex.getMessage());
        }

    }
    //este es elultimo

    public Connection getConexion() {
        return con;
    }

}
