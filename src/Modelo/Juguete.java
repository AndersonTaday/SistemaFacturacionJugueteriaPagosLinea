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
public class Juguete {

    private int idJuguete;
    private String nombre;
    private String marca;
    private String modelo;
    private String descripcion;
    private int stock;
    private Double precio;
    private Boolean estado;
    private String observacion;
    private String codigo;

    public Juguete() {

    }

    public Juguete(int idJuguete, String nombre, String marca, String modelo, String descripcion, int stock, Double precio, Boolean estado, String observacion, String codigo) {
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

    public int getIdJuguete() {
        return idJuguete;
    }

    public void setIdJuguete(int idJuguete) {
        this.idJuguete = idJuguete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
