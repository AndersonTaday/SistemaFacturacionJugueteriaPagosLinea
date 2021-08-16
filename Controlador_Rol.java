/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import utilidades.HibernateUtil;
import Modelo.Rol;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author James Romero
 */
public class Controlador_Rol {

    private Session st;

    public Controlador_Rol() {
        sessionHibernate();
    }

    public void sessionHibernate() {
        st = HibernateUtil.getSessionFactory().openSession();
    }

    public void guardarRol(Rol tipo) {
        try {
            st.beginTransaction();
            st.save(tipo);
            st.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al guardar rol");
        }
    }

    public List<Rol> cargarRol(List<Rol> listaRol) {
        try {
            listaRol = (List<Rol>) st.createQuery("From Rol").list();
        } catch (Exception e) {
            System.out.println("Error al cargar rol");
        }
        return listaRol;
    }

     public Rol traeRol(String id) {
        Rol ro = new Rol();
        try {
            ro = (Rol) st.load(Rol.class, id);
        } catch (Exception e) {
            System.out.println("Error al traer rol");
        }
        return ro;
    } 

    public Rol TraerRoles(String des) {
        Rol r = null;
        try {
            Query query = st.createQuery("from Rol tp Where tp.descripcion = ?");
            query.setParameter(0, des);
            try {
                r = (Rol)query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR1"+e.getMessage(),"mensaje",JOptionPane.ERROR_MESSAGE);  
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "error22"+e.getMessage(),"mensaje",JOptionPane.ERROR_MESSAGE);  
        }
        return r;
    }

    public void actualkzarRol(Rol rl) {
        try {
            st.beginTransaction();
            st.save(rl);
            st.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al guardar rol");
        }
    }

}
