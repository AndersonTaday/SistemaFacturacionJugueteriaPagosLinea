/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import utilidades.HibernateUtil;
import Modelo.Rol;
import java.util.List;
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

    /* public Rol TraerRol(String iDrol) {
       // Rol ro = new Rol();
        try {
           // ro = (Rol) st.load(Rol.class, iDrol);
        } catch (Exception e) {
            System.out.println("Error al traer rol");
        }
       // return ro;
    } */

    public Rol TraerRoles(String descrip) {
        Rol rl = null;
        try {
            Query query = st.createQuery("From Rol tp where tp.descripcion = ?");
            query.setParameter(0, descrip);
            try {
                rl = (Rol) query.uniqueResult();
            } catch (Exception e) {
                System.out.println("Error el rol ya existe");
            }
        } catch (Exception e) {
            System.out.println("Error al no traer roles");
        }
        return rl;
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
