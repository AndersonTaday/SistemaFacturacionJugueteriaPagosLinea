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
public class DetalleFactura {

    private int idDetFact;
    private Juguete juguete;
    private Double precioUnitario;
    private Double precioTotal;
    private int cantidad;

    public DetalleFactura() {

    }

    public DetalleFactura(int idDetFact, Juguete juguete, Double precioUnitario, Double precioTotal, int cantidad) {
        this.idDetFact = idDetFact;
        this.juguete = juguete;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
        this.cantidad = cantidad;
    }

    public int getIdDetFact() {
        return idDetFact;
    }

    public void setIdDetFact(int idDetFact) {
        this.idDetFact = idDetFact;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
