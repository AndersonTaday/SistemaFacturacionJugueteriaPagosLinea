package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author yamilka
 */

public class Conexion {

    Connection cn;
    Statement st;
    private static String us = "root";
    private static String contra = "";
    private static String bd = "proyecto";
    private static String url = "jdbc:mysql://localhost:3306/" + bd;

    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, us, contra);
            System.out.println("CONEXION SEGURA");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cn;
    }

    Statement createStatement() {
        throw new UnsupportedOperationException("No Soportado");
    }
}
