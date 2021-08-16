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

    public Controlador_Juguete() {
        sessionHibernate();
    }

    public void sessionHibernate() {
        st = HibernateUtil.getSessionFactory().openSession();
    }

    public void NuevoJuguete(Juguete jugue) {
        try {
            st.beginTransaction();
            st.save(jugue);
            st.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al traer los datos" + e.getMessage(), "mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<Juguete> cargarJuguete(String estado, List<Juguete> listaJuguete) {
        try {
            listaJuguete = (List<Juguete>) st.createQuery("From Juguete where estado='" + estado).list();
        } catch (Exception e) {

        }
        return listaJuguete;
    }

    public Juguete TraerJuguete(String codigo) {
        Juguete per = null;
        try {
            per = (Juguete) st.load(Juguete.class, codigo);
        } catch (Exception e) {
            System.out.println("Error al traer juguete");
        }
        return per;
    }

    public Juguete TraerJuguetes(String codigo) {
        Juguete jugue = null;
        try {
            Query query = st.createQuery("From Juguete juguete where juguete.codigo = ?");
            query.setParameter(0, codigo);
            try {
                jugue = (Juguete) query.uniqueResult();
            } catch (Exception e) {
                System.out.println("Error este juguete ya existe");
            }
        } catch (Exception e) {
            System.out.println("Error al traer todos los juguetes");
        }
        return jugue;
    }
    
    public Juguete TraeJugueteId(int id) {
        Juguete jugue = null;
        try {
            jugue = (Juguete) st.load(Juguete.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al traer id juguete " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return jugue;
    }

    public List<Juguete> buscarJuguete(String cod, List<Juguete> lis) {
        try {
            lis = (List<Juguete>) st.createQuery("From Juguete where codigo LIKE '%" + cod + "%'").list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar cliente " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return lis;
    }
}
