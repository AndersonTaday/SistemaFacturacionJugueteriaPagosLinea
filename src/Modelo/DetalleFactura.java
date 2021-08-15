/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author James Romero
 */
@Entity
public class DetalleFactura implements Serializable {

    private int idDetFact;
    private Juguete juguete;
    private Double precioUnitario;
    private Double precioTotal;
    private int cantidad;

    private Factura detalle_fac;
    private Juguete detalle_jug;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdDetFact() {
        return idDetFact;
    }

    public void setIdDetFact(int idDetFact) {
        this.idDetFact = idDetFact;
    }

    @Column(length = 30)
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

    public DetalleFactura() {

    }

    public DetalleFactura(int idDetFact, Juguete juguete, Double precioUnitario, Double precioTotal, int cantidad) {
        this.idDetFact = idDetFact;
        this.juguete = juguete;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
        this.cantidad = cantidad;
    }

    @ManyToOne
    public Factura getDetalle_fac() {
        return detalle_fac;
    }

    public void setDetalle_fac(Factura detalle_fac) {
        this.detalle_fac = detalle_fac;
    }

    @ManyToOne
    public Juguete getDetalle_jug() {
        return detalle_jug;
    }

    public void setDetalle_jug(Juguete detalle_jug) {
        this.detalle_jug = detalle_jug;
    }

}
