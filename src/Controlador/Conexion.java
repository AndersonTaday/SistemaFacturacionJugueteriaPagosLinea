/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author James Romero
 */
public class Conexion {

    /**
     *
     * @author Usuario
     */
    private static String us = "root";
    private static String contra = "";
    private static String bd = "proyecto";
    private static String url = "jdbc:mysql://localhost:3306/" + bd;

    private Connection con = null;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, us, contra);

            if (con != null) {
                System.out.println("CONEXION SEGURA");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Connection getConectar() {
        return con;
    }

    public void desconectar() {
        con = null;
    }

    public String getUs() {
        return us;
    }

    public void setUs(String us) {
        this.us = us;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public static void main(String[] args) {
        Conexion test = new Conexion();
        test.getConectar();
    }

}
