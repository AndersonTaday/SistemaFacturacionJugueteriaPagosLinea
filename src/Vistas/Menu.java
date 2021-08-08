/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

/**
 *
 * @author James Romero
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void FrmCredenciales() {
        Cambiar_Credenciales frm = new Cambiar_Credenciales();
        frm.setVisible(true);
    }

    public void FrmFactura() {
        Factura frm = new Factura();
        frm.setVisible(true);
    }

    public void FrmJuguete() {
        FrmJuguete frm = new FrmJuguete();
        frm.setVisible(true);
    }

    public void FrmProveedor() {
        FrmProveedor frm = new FrmProveedor();
        frm.setVisible(true);
    }

    public void FrmReporteCompra() {
        ReporteCompra frm = new ReporteCompra();
        frm.setVisible(true);
    }

    public void FrmCerrarSesion() {
        Iniciar_Sesion frm = new Iniciar_Sesion();
        frm.setVisible(true);
    }

    public void FrmPersonal() {
        Personal frm = new Personal();
        frm.setVisible(true);
    }

    public void FrmClientes() {
        Clientes frm = new Clientes();
        frm.setVisible(true);
    }

    public void FrmReporteVenta() {
        ReporteFactura frm = new ReporteFactura();
        frm.setVisible(true);
    }

    public void FrmCompra() {
        Compra frm = new Compra();
        frm.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton10 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnJuguete = new javax.swing.JButton();
        btnPersonal = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnFactura = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnReporteCompra = new javax.swing.JButton();
        btnReporteVenta = new javax.swing.JButton();
        btnCredenciales = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        btnCompra = new javax.swing.JButton();

        jButton10.setText("jButton10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú pricipal");

        jPanel1.setBackground(new java.awt.Color(234, 250, 241));

        btnJuguete.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnJuguete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/juguetes.png"))); // NOI18N
        btnJuguete.setText("Juguetes");
        btnJuguete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugueteActionPerformed(evt);
            }
        });

        btnPersonal.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/personal.png"))); // NOI18N
        btnPersonal.setText("Personal");
        btnPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalActionPerformed(evt);
            }
        });

        btnCliente.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/clientes.png"))); // NOI18N
        btnCliente.setText("Clientes");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnFactura.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/factura.png"))); // NOI18N
        btnFactura.setText("Factura");
        btnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaActionPerformed(evt);
            }
        });

        btnProveedor.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/proveedor.png"))); // NOI18N
        btnProveedor.setText("Proveedor");
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        btnReporteCompra.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnReporteCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reporte.png"))); // NOI18N
        btnReporteCompra.setText("Reporte Compra");
        btnReporteCompra.setToolTipText("");
        btnReporteCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteCompraActionPerformed(evt);
            }
        });

        btnReporteVenta.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnReporteVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reporte.png"))); // NOI18N
        btnReporteVenta.setText("Reporte Venta");
        btnReporteVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteVentaActionPerformed(evt);
            }
        });

        btnCredenciales.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnCredenciales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/credenciales.png"))); // NOI18N
        btnCredenciales.setText("Credenciales");
        btnCredenciales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCredencialesActionPerformed(evt);
            }
        });

        btnCerrarSesion.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnCerrarSesion.setText("Cerrar seción");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnCompra.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/compras.png"))); // NOI18N
        btnCompra.setText("Compra");
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnJuguete, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCredenciales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnReporteCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReporteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCerrarSesion)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPersonal)
                    .addComponent(btnFactura))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJuguete)
                    .addComponent(btnCliente))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProveedor)
                    .addComponent(btnCredenciales))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReporteCompra)
                    .addComponent(btnReporteVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnCompra)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCredencialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCredencialesActionPerformed
        // TODO add your handling code here:
        FrmCredenciales();
        this.dispose();
    }//GEN-LAST:event_btnCredencialesActionPerformed

    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaActionPerformed
        // TODO add your handling code here:
        FrmFactura();
        this.dispose();
    }//GEN-LAST:event_btnFacturaActionPerformed

    private void btnJugueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugueteActionPerformed
        // TODO add your handling code here:
        FrmJuguete();
        this.dispose();
    }//GEN-LAST:event_btnJugueteActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
        FrmProveedor();
        this.dispose();
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnReporteCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteCompraActionPerformed
        // TODO add your handling code here:
        FrmReporteCompra();
        this.dispose();
    }//GEN-LAST:event_btnReporteCompraActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // TODO add your handling code here:
        FrmCerrarSesion();
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalActionPerformed
        // TODO add your handling code here:
        FrmPersonal();
        this.dispose();
    }//GEN-LAST:event_btnPersonalActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        // TODO add your handling code here:
        FrmClientes();
        this.dispose();
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnReporteVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteVentaActionPerformed
        // TODO add your handling code here:
        FrmReporteVenta();
        this.dispose();
    }//GEN-LAST:event_btnReporteVentaActionPerformed

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        // TODO add your handling code here:
        FrmCompra();
        this.dispose();
    }//GEN-LAST:event_btnCompraActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnCompra;
    private javax.swing.JButton btnCredenciales;
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnJuguete;
    private javax.swing.JButton btnPersonal;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnReporteCompra;
    private javax.swing.JButton btnReporteVenta;
    private javax.swing.JButton jButton10;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
