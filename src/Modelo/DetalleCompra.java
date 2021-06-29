/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author yamil
 */
public class DetalleCompra {

    private int idDetCompra;
    private int cantCompra;
    private String descripcion;
    private Juguete juguete;
    private Double precioUnitario;
    private Double precioTotal;
    
    public DetalleCompra(){
        
    }
    
    public DetalleCompra(int idDetCompra, int cantCompra, String descripcion, Juguete juguete, Double precioUnitario, Double precioTotal) {
        this.idDetCompra = idDetCompra;
        this.cantCompra = cantCompra;
        this.descripcion = descripcion;
        this.juguete = juguete;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
    }

    public int getIdDetCompra() {
        return idDetCompra;
    }

    public void setIdDetCompra(int idDetCompra) {
        this.idDetCompra = idDetCompra;
    }

    public int getCantCompra() {
        return cantCompra;
    }

    public void setCantCompra(int cantCompra) {
        this.cantCompra = cantCompra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Juguete getJuguete() {
        return juguete;
    }

    public void setJuguete(Juguete juguete) {
        this.juguete = juguete;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

}
