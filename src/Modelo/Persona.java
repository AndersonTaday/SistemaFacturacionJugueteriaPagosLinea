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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author James Romero
 */
@Entity
public class Persona implements Serializable {

    private int idPersona;
    private String nombre;
    private String CI;
    private String apellido;

    private String telefono;
    private String direccion;
    private String correoElectronico;
    private Boolean estado;
    private Rol rol;
    private List<Factura>ListaFac = new ArrayList<Factura>();
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    @Column(length = 30)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(length = 10)
    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    @Column(length = 10)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Column(length = 40)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(length = 40)
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    //
        public Persona() {

    }

    public Persona(int idPersona, String nombre, String CI, String telefono, String direccion, String correoElectronico, Boolean estado) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.CI = CI;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.estado = estado;
    }
    
    @OneToMany(mappedBy = "fac",cascade = CascadeType.ALL)
     public List<Factura> getListaFac() {
        return ListaFac;
    }

    public void setListaFac(List<Factura> ListaFac) {
        this.ListaFac = ListaFac;
    }
    
    //@OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    
    @ManyToOne
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    

}
