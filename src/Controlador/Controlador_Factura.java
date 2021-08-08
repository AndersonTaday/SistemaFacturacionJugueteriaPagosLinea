/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import org.hibernate.Session;
import utilidades.HibernateUtil;

/**
 *
 * @author James Romero
 */
public class Controlador_Factura {

    private Session st;

    public Controlador_Factura() {
        sessionHibernate();
    }

    public void sessionHibernate() {
        st = HibernateUtil.getSessionFactory().openSession();
    }
}
