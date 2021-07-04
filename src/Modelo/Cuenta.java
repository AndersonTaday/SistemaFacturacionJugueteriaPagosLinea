/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author James Romero
 */
public class Cuenta {

    private int idCuenta;
    private String usuario;
    private String clave;
    private boolean estadoCuenta;

    public Cuenta() {
    }

    public Cuenta(int idCuenta, String usuario, String clave, boolean estadoCuenta) {
        this.idCuenta = idCuenta;
        this.usuario = usuario;
        this.clave = clave;
        this.estadoCuenta = estadoCuenta;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(boolean estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

}
