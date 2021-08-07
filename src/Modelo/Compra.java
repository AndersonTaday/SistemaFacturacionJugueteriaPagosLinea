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
public class Compra implements Serializable {

    private int idCompra;
    private int numCompra;
    private String fechaEntrega;
    private String descripción;

    private List<Proveedor> listaProveedor = new ArrayList<Proveedor>();
    private List<DetalleCompra> listaC = new ArrayList<DetalleCompra>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PONER OBLIGATORIAMENTE
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getNumCompra() {
        return numCompra;
    }

    public void setNumCompra(int numCompra) {
        this.numCompra = numCompra;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public Compra() {

    }

    public Compra(int idCompra, int numCompra, String fechaEntrega, String descripción, Proveedor proveedor) {
        this.idCompra = idCompra;
        this.numCompra = numCompra;
        this.fechaEntrega = fechaEntrega;
        this.descripción = descripción;
    }

    @OneToMany(mappedBy = "compra_pro", cascade = CascadeType.ALL)
    public List<Proveedor> getListaProveedor() {
        return listaProveedor;
    }

    public void setListaProveedor(List<Proveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }

    @OneToMany(mappedBy = "compras", cascade = CascadeType.ALL)
    public List<DetalleCompra> getListaC() {
        return listaC;
    }

    public void setListaC(List<DetalleCompra> listaC) {
        this.listaC = listaC;
    }

}
