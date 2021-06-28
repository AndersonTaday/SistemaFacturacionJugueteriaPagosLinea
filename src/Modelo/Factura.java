/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author LENOVO LEGION
 */
public class Factura {
        private int idFactura;
    private String nombreCliente;
    private String CI;
    private String telefono;
    private String direccion;
    private String correoElectronico;
    private Double iva;
    private String fecha;

    public Factura() {

    }

    public Factura(int idFactura, String nombreCliente, String CI, String telefono, String direccion, String correoElectronico, Double iva, String fecha) {
        this.idFactura = idFactura;
        this.nombreCliente = nombreCliente;
        this.CI = CI;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.iva = iva;
        this.fecha = fecha;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
