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
 * @author INFORMASHION
 */
@Entity
public class Juguete implements Serializable {

    private int idJuguete;
    private String nombre;
    private String marca;
    private String modelo;
    private String descripcion;
    private int stock;
    private Double precio;

    private String estado;
    private String observacion;
    private String codigo;

    private List<DetalleFactura> listaDetalleJug = new ArrayList<DetalleFactura>();
    private List<DetalleCompra> listaJugCompra = new ArrayList<DetalleCompra>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdJuguete() {
        return idJuguete;
    }

    public void setIdJuguete(int idJuguete) {
        this.idJuguete = idJuguete;
    }

    @Column(length = 40)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(length = 40)
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Column(length = 30)
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Column(length = 40)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Column(length = 20)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    //
    public Juguete() {

    }

    public Juguete(int idJuguete, String nombre, String marca, String modelo, String descripcion, int stock, Double precio, String estado, String observacion, String codigo) {
        this.idJuguete = idJuguete;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.estado = estado;
        this.observacion = observacion;
        this.codigo = codigo;
    }

    @OneToMany(mappedBy = "detalle_jug", cascade = CascadeType.ALL)
    public List<DetalleFactura> getListaDetalleJug() {
        return listaDetalleJug;
    }

    public void setListaDetalleJug(List<DetalleFactura> listaDetalleJug) {
        this.listaDetalleJug = listaDetalleJug;
    }

    @OneToMany(mappedBy = "detacjug", cascade = CascadeType.ALL)
    public List<DetalleCompra> getListaJugCompra() {
        return listaJugCompra;
    }

    public void setListaJugCompra(List<DetalleCompra> listaJugCompra) {
        this.listaJugCompra = listaJugCompra;
    }

}
