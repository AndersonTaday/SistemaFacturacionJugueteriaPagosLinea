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
 * @author yami
 */
@Entity
public class DetalleCompra implements Serializable {

    private int idDetCompra;
    private int cantCompra;
    private String descripcion;
    private Juguete juguete;
    private Double precioUnitario;
    private Double precioTotal;
    private Juguete detacjug;
    
    private Compra compras;
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(length = 40)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public DetalleCompra() {

    }

    public DetalleCompra(int idDetCompra, int cantCompra, String descripcion, Juguete juguete, Double precioUnitario, Double precioTotal) {
        this.idDetCompra = idDetCompra;
        this.cantCompra = cantCompra;
        this.descripcion = descripcion;
        this.juguete = juguete;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
    }

    @ManyToOne
    public Juguete getDetacjug() {
        return detacjug;
    }

    public void setDetacjug(Juguete detacjug) {
        this.detacjug = detacjug;
    }
    
    @ManyToOne
     public Compra getCompras() {
        return compras;
    }

    public void setCompras(Compra compras) {
        this.compras = compras;
    }
   
}
