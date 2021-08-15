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

    public void Cliente(Persona p) {
        try {
            st.beginTransaction();
            st.save(p);
            st.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al traer los datos" + e.getMessage(), "mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ActualizarCliente(Persona p) {
        try {
            st.clear();
            st.beginTransaction();
            st.saveOrUpdate(p);
            st.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acualizao los datos" + e.getMessage(), "mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void desactivaCliente(Persona p) {
        try {
            st.beginTransaction();
            st.update(p);
            st.getTransaction().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al desactivar cliente " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<Persona> buscarPersona(String cedula, List<Persona> lis) {
        try {
            lis = (List<Persona>) st.createQuery("From Persona where CI LIKE '%" + cedula + "%'").list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar cliente " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return lis;
    }

    public List<Persona> cargarClientes(String estado, List<Persona> listaPersona) {
        try {
            listaPersona = (List<Persona>) st.createQuery("From Persona where estado='" + estado + "'order by apellido").list();
        } catch (Exception e) {

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
            Query query = st.createQuery("From Persona persona where persona.cedula = ?");
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

    public Persona TraeClienteId(int id) {
        Persona per = null;
        try {
            per = (Persona) st.load(Persona.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar cliente " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return per;
    }

}
