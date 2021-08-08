/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Juguete;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import utilidades.HibernateUtil;

/**
 *
 * @author yamilka
 */

public class Controlador_Juguete {
    private Session st;

//    public Controlador_Juguete() {
//        sessionHibernate();
//    }

    public void sessionHibernate() {
        st = HibernateUtil.getSessionFactory().openSession();
    }

    public void Juguete(Juguete j) {
        try {
            st.beginTransaction();
            st.save(j);
            st.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al traer los datos" + e.getMessage(), "mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ActualizarJuguete(Juguete j) {
        try {
            st.clear();
            st.beginTransaction();
            st.saveOrUpdate(j);
            st.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acualizar los datos" + e.getMessage(), "mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void desactivaJuguete(Juguete j) {
        try {
            st.beginTransaction();
            st.update(j);
            st.getTransaction().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al desactivar Juguete " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<Juguete> buscarJuguete(String codigo, List<Juguete> lista) {
        try {
            lista = (List<Juguete>) st.createQuery("From Juguete where Codigo LIKE '%" + codigo + "%'").list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar Juguete " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public List<Juguete> cargarJuguetes(String estado, List<Juguete> listaJuguete) {
        try {
            listaJuguete = (List<Juguete>) st.createQuery("From Juguete where estado='" + estado + "'order by Codigo").list();
        } catch (Exception e) {

        }
        return listaJuguete;
    }

    public Juguete TraerJuguete(String codigo) {
        Juguete jug = null;
        try {
            jug = (Juguete) st.load(Juguete.class, codigo);
        } catch (Exception e) {
            System.out.println("Error al traer Juguete");
        }
        return jug;
    }

    public Juguete TraerJuguetes(String codigo) {
        Juguete jug = null;
        try {
            Query query = st.createQuery("From Juguete persona where Juguete.codigo = ?");
            query.setParameter(0, codigo);
            try {
                jug = (Juguete) query.uniqueResult();
            } catch (Exception e) {
                System.out.println("Error. Este código ya existe");
            }
        } catch (Exception e) {
            System.out.println("Error al traer todos los Juguetes");
        }
        return jug;
    }

    public Juguete TraeJugueteId(int id) {
        Juguete jug = null;
        try {
            jug = (Juguete) st.load(Juguete.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar Juguete " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return jug;
    }
}
