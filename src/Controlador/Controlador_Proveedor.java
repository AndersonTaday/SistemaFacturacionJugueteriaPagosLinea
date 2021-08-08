/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Proveedor;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utilidades.HibernateUtil;

/**
 *
 * @author James Romero
 */
public class Controlador_Proveedor {
      private Session st;

    public Controlador_Proveedor() {
        sessionHibernate();
    }

    public void sessionHibernate() {
        st = HibernateUtil.getSessionFactory().openSession();
    }

    public void NuevoProveedor(Proveedor nombre) {
        try {
            st.beginTransaction();
            st.save(nombre);
            st.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al guardar proveedor");
        }
    }

//    public List<Proveedor> cargarProveedor(List<Proveedor> listaProveedor, String nom){
//        try {
//            listaProveedor = (List<Proveedor>) st.createQuery("From Proveedor where nombre  = '" + nom + "'order by nombre").list();
//        } catch (Exception e) {
//            System.out.println("Error al cargar cliente");
//        }
//        return listaProveedor;
//    }

    public Proveedor TraerProveedor(String nombre) {
        Proveedor pro = null;
        try {
            pro = (Proveedor) st.load(Proveedor.class, nombre);
        } catch (Exception e) {
            System.out.println("Error al traer cliente");
        }
        return pro;
    }

    public Proveedor TraerProveedores(String nombre) {
        Proveedor pro = null;
        try {
            Query query = st.createQuery("From Proveedor proveedor where proveedor.nombre = ?");
            query.setParameter(0, nombre);
            try {
                pro = (Proveedor) query.uniqueResult();
            } catch (Exception e) {
                System.out.println("Error este proveedor ya existe");
            }
        } catch (Exception e) {
            System.out.println("Error al traer todos los proveedores");
        }
        return pro;
    }

    public List<Vistas.FrmProveedor> cargarProveedor(List<Vistas.FrmProveedor> listaProveedor, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
