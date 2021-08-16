/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import utilidades.HibernateUtil;
import Modelo.Cuenta;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author James Romero
 */
public class Controlador_Cuenta {

    private Session st;

    public Controlador_Cuenta() {
        sessionHibernate();
    }

    public void sessionHibernate() {
        st = HibernateUtil.getSessionFactory().openSession();
    }

    public void guardarCuenta(Cuenta cuent) {
        try {
            st.beginTransaction();
            st.save(cuent);
            st.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al guardar cuenta");
        }
    }

    public Cuenta TraerCuenta(String idCuen) {
        Cuenta usu = new Cuenta();
        try {
            usu = (Cuenta) st.load(Cuenta.class, idCuen);
        } catch (Exception e) {
            System.out.println("Error al traer cuenta");
        }
        return usu;
    }

    public Cuenta TraerCuentas(String ced) {
        Cuenta cue = null;
        try {
            Query query = st.createQuery("From Cuenta cu where cu.cedula = ?");
            query.setParameter(0, ced);
            try {
                cue = (Cuenta) query.uniqueResult();
            } catch (Exception e) {
                System.out.println("Error la cuenta ya existe");
            }
        } catch (Exception e) {
            System.out.println("Error al no traer cuentas");
        }
        return cue;
    }

    public List<Cuenta> cargarRol(List<Cuenta> listaCuenta) {
        try {
            listaCuenta = (List<Cuenta>) st.createQuery("From Cuenta").list();
        } catch (Exception e) {
            System.out.println("Error al cargar rol");
        }
        return listaCuenta;
    }
     public Cuenta TraeUsuarioId(int id) {
        Cuenta per = null;
        try {
            per = (Cuenta) st.load(Cuenta.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar cuenta " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return per;
    }
    

}
