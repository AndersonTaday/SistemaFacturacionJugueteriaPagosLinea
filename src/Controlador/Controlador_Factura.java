/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Factura;
import java.util.Vector;
import org.hibernate.Session;
import utilidades.HibernateUtil;

/**
 *
 * @author yamilka
 */

public class Controlador_Factura {

    private Session st;
    private int cantidad;
    private double precioU;
    private double precioT;
    private String nombre;
    private String marca;
    private String modelo;
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioU() {
        return precioU;
    }

    public void setPrecioU(double precioU) {
        this.precioU = precioU;
    }

    public double getPrecioT() {
        return precioT;
    }

    public void setPrecioT(double precioT) {
        this.precioT = precioT;
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

    public Controlador_Factura() {
        sessionHibernate();
    }

    public void sessionHibernate() {
        st = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void Agregar(){
        Factura.Agregar(this);
    }
    
    public void Eliminar(){
        Factura.Eliminar(0);
    }
    public void Drop(){
        Factura.Drop();
    }
    
    public Vector Mostrar(){
        return Factura.Mostrar();
    }
    
    public double Mult(){
        return (double) cantidad*precioU;
    }
}
