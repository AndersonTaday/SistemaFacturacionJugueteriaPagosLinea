/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import utilidades.HibernateUtil;
import Modelo.Persona;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author James Romero
 */
public class Controlador_Persona {

    private Session st;

    public Controlador_Persona() {
        sessionHibernate();
    }

    public void sessionHibernate() {
        st = HibernateUtil.getSessionFactory().openSession();
    }

    public void Cliente(Persona cli) {
        try {
            st.beginTransaction();
            st.save(cli);
            st.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al guardar cliente");
        }
    }

    public List<Persona> cargarCliente(List<Persona> listaPersona, String cedula) {
        try {
            listaPersona = (List<Persona>) st.createQuery("From Persona where cedula = '" + cedula + "'order by apellido").list();
        } catch (Exception e) {
            System.out.println("Error al cargar cliente");
        }
        return listaPersona;
    }

    public Persona TraerCliente(String cedula) {
        Persona per = null;
        try {
            per = (Persona) st.load(Persona.class, cedula);
        } catch (Exception e) {
            System.out.println("Error al traer cliente");
        }
        return per;
    }

    public Persona TraerClientes(String cedula) {
        Persona per = null;
        try {
            Query query = st.createQuery("From Persona person where person.cedula = ?");
            query.setParameter(0, cedula);
            try {
                per = (Persona) query.uniqueResult();
            } catch (Exception e) {
                System.out.println("Error esta cédula ya existe");
            }
        } catch (Exception e) {
            System.out.println("Error al traer todos los clientes");
        }
        return per;
    }
    
     public void nuevaPersona(Persona per){
        try {
            st.beginTransaction();
            st.save(per);
            st.getTransaction().commit();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Guardar Cliente "+e.getMessage());
        }
    }

}
