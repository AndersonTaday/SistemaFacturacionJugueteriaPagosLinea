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
public class Compra {

    private int idCompra;
    private int numCompra;
    private String fechaEntrega;
    private String descripción;
    private Proveedor proveedor;

    public Compra(){
        
    }
    
    public Compra(int idCompra, int numCompra, String fechaEntrega, String descripción, Proveedor proveedor) {
        this.idCompra = idCompra;
        this.numCompra = numCompra;
        this.fechaEntrega = fechaEntrega;
        this.descripción = descripción;
        this.proveedor = proveedor;
    }

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

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

}
