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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author LENOVO LEGION
 */
@Entity
public class Factura implements Serializable  {

    private int idFactura;
    private String nombreCliente;
    private String CI;
    private String telefono;
    private String direccion;
    private String correoElectronico;
    private Double iva;
    private String fecha;
    private Persona fac;
    
    private List<DetalleFactura>listaDetalleFac = new ArrayList<DetalleFactura>();
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    @Column(length = 40)
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Column(length = 10)
    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    @Column(length = 10)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Column(length = 40)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(length = 40)
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

    @Column(length = 10)
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
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
    
    //@OneToMany(mappedBy = "fac",cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "detalle_fac",cascade = CascadeType.ALL)
    public List<DetalleFactura> getListaDetalleFac() {
        return listaDetalleFac;
    }

    public void setListaDetalleFac(List<DetalleFactura> listaDetalleFac) {
        this.listaDetalleFac = listaDetalleFac;
    }
    
   @ManyToOne 
     public Persona getFac() {
        return fac;
    }

    public void setFac(Persona fac) {
        this.fac = fac;
    }
}
