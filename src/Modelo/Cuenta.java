/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author James Romero
 */
@Entity
public class Cuenta implements Serializable {

    private int idCuenta;
    private String usuario;
    private String clave;
    private boolean estadoCuenta;
    private Persona persona;

   
    

    public Cuenta() {
    }

    public Cuenta(int idCuenta, String usuario, String clave, boolean estadoCuenta) {
        this.idCuenta = idCuenta;
        this.usuario = usuario;
        this.clave = clave;
        this.estadoCuenta = estadoCuenta;
    }

    @Id
    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    @Column(length = 30)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Column(length = 30)
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
    
    @OneToOne
     public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
