/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author James Romero
 */
@Entity
public class Rol implements Serializable {

    private int idRol;
    private String tipo;
    private String descripcion;
    private String rol;
    private List<Persona> personas = new ArrayList<Persona>();
    private Persona persona;
    

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

//    public Rol(int idRol, String tipo, String descripcion) {
//        this.idRol = idRol;
//        this.tipo = tipo;
//        this.descripcion = descripcion;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    @Column(length = 30)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Column(length = 30)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    public List<Persona> getPersonas() {
        return personas;
    }
    
    public Rol() {
    }
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
