/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
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
 * @author James Romero JAJA
 */
@Entity
public class Proveedor implements Serializable {

    private int idProveedor;
    private String nombre;
    private String telefono;

    private String estado;
    private String direccion;
    private String descripción;

    private Compra compra_pro;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Column(length = 30)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(length = 10)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(length = 50)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(length = 40)
    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public Proveedor() {

    }

    public Proveedor(int idProveedor, String nombre, String telefono, String estado, String direccion, String descripción) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.estado = estado;
        this.direccion = direccion;
        this.descripción = descripción;
    }

    @ManyToOne
    public Compra getCompra_pro() {
        return compra_pro;
    }

    public void setCompra_pro(Compra compra_pro) {
        this.compra_pro = compra_pro;
    }

}
