/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Conexion;
import Controlador.Controlador_Persona;
import Controlador.Controlador_Rol;
import Controlador.Controlador_Validar;
import Modelo.Persona;
import Modelo.Rol;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author James Romero
 */
public class FrmPersonal extends javax.swing.JFrame {

    /**
     * Creates new form Personal
     */
    Controlador_Persona personadb = new Controlador_Persona();
    Controlador_Rol RolDB = new Controlador_Rol();
    Controlador_Validar val = new Controlador_Validar();
    DefaultTableModel TablaPersona;
    Conexion con = new Conexion();
    Connection cn = con.conexion();

    public FrmPersonal() {
        this.getContentPane().setBackground(Color.getHSBColor(153, 153, 255));
        initComponents();
        inicio();
    }

    private boolean ValidarCampos() {
        boolean lleno = true;
        if (txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtCedula.getText().equals("")
                || txtTelefono.getText().equals("") || txtDireccion.getText().equals("") || txtCorreoElectronico.getText().equals("")) {
            lleno = false;
        } else {
            lleno = true;

        }
        return lleno;
    }

    private void ModificarTabla() {
        JTPersonal.getColumnModel().getColumn(0).setMaxWidth(0);
        JTPersonal.getColumnModel().getColumn(0).setMinWidth(0);
        JTPersonal.getColumnModel().getColumn(0).setPreferredWidth(0);

        JTPersonal.getColumnModel().getColumn(1).setPreferredWidth(220);
        JTPersonal.getColumnModel().getColumn(2).setPreferredWidth(220);
        JTPersonal.getColumnModel().getColumn(3).setPreferredWidth(220);
        JTPersonal.getColumnModel().getColumn(4).setPreferredWidth(220);
        JTPersonal.getColumnModel().getColumn(5).setPreferredWidth(220);
        JTPersonal.getColumnModel().getColumn(6).setPreferredWidth(220);
        JTPersonal.getColumnModel().getColumn(7).setPreferredWidth(220);
        JTPersonal.getColumnModel().getColumn(8).setPreferredWidth(220);

        TablaPersona = (DefaultTableModel) JTPersonal.getModel();
        TablaPersona.setNumRows(0);
    }

    private void limpiar() {
        txtCedula.setText(" ");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCorreoElectronico.setText("");
    }

    private void cargarPersonas(int id) {
        Persona pe = personadb.TraeClienteId(id);
        txtCedula.setText(pe.getCI());
        txtNombre.setText(pe.getNombre());
        txtApellido.setText(pe.getApellido());
        txtDireccion.setText(pe.getDireccion());
        txtTelefono.setText(pe.getTelefono());
        txtCorreoElectronico.setText(pe.getCorreoElectronico());
    }

    private void cargarTabla(String estado) {
        try {
            List<Persona> lista = null;
            lista = personadb.cargarClientes(estado, lista);
            for (Persona persona : lista) {
                TablaPersona.addRow(new Object[]{
                    persona.getIdPersona(), persona.getCI(), persona.getNombre(), persona.getApellido(), persona.getCorreoElectronico(), persona.getDireccion(), persona.getTelefono(), persona.getEstado(), persona.getRol().getTipo()

                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + " " + e.getMessage(), "mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void mostrarDatos(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cédula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Correo Electrónico");
        modelo.addColumn("Dirección");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Estado");
        modelo.addColumn("Rol");
        JTPersonal.setModel(modelo);
        String sql = "";
        String variable = (String) cbxTipoBusqueda.getSelectedItem();
        if(valor.equals("")){
            sql = "SELECT * FROM persona";
        } else{
            
            if(variable.equals("Código")){
            sql = "SELECT * FROM persona WHERE CI='"+valor+"'";
            } else {
                if (variable.equals("Nombre")){
                    sql = "SELECT * FROM persona WHERE nombre='"+valor+"'";
                } else {
                    if (variable.equals("Rol")){
                        sql = "SELECT * FROM persona WHERE rol_idRol='"+valor+"'"; 
                    }
                }
            }
        }
        String[] datos = new String[8];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(2);
                datos[1] = rs.getString(7);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(8);
                datos[4] = rs.getString(4);
                datos[5] = rs.getString(5);
                datos[6] = rs.getString(6);
                datos[7] = rs.getString(9);
                modelo.addRow(datos);
            }
            JTPersonal.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + " " + e.getMessage(), "mensaje", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    private void inicio() {
        ModificarTabla();
        cargarTabla("A");
//        cargarTabla("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void FrmMenu() {
        Menu frm = new Menu();
        frm.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cbxRolesPersonal = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jButton = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        txtNombre = new java.awt.TextField();
        txtApellido = new java.awt.TextField();
        txtCedula = new java.awt.TextField();
        txtCorreoElectronico = new java.awt.TextField();
        txtTelefono = new java.awt.TextField();
        txtDireccion = new java.awt.TextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTPersonal = new javax.swing.JTable();
        cbxTipoBusqueda = new javax.swing.JComboBox<>();
        txtBusqueda = new java.awt.TextField();
        btnBuscar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personal");
        setBackground(new java.awt.Color(233, 250, 241));

        jPanel2.setBackground(new java.awt.Color(234, 250, 241));

        jPanel4.setBackground(new java.awt.Color(253, 242, 233));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Courier New", 0, 12))); // NOI18N

        cbxRolesPersonal.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        cbxRolesPersonal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente (1)", "Administrador (2)", "Empleado (3)" }));
        cbxRolesPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRolesPersonalActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel8.setText("Rol:");

        jLabel9.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel9.setText("Nombres:");

        jLabel10.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel10.setText("Apellidos:");

        jLabel11.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel11.setText("Cédula:");

        jLabel12.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel12.setText("Correo Electrónico:");

        jLabel13.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel13.setText("Teléfono:");

        jLabel14.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel14.setText("Dirección:");

        btnModificar.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jButton.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ActivarDesactivar.png"))); // NOI18N
        jButton.setText("Activar/Desactivar");
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });

        btnCrear.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/crear.png"))); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellido.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        txtCedula.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        txtCorreoElectronico.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtDireccion.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(56, 56, 56)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel13))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(36, 36, 36)
                        .addComponent(cbxRolesPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(227, 227, 227))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxRolesPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(50, 50, 50)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnCrear)
                    .addComponent(jButton))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        JTPersonal.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        JTPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cédula", "Nombre", "Apellido", "Correo Electónico", "Dirección", "Teléfono", "Estado", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTPersonalMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTPersonal);

        cbxTipoBusqueda.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        cbxTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cédula", "Nombre", "Rol" }));

        txtBusqueda.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAtras.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/atras.png"))); // NOI18N
        btnAtras.setText("Atrás");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxRolesPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRolesPersonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxRolesPersonalActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try{
           PreparedStatement pst = cn.prepareStatement("UPDATE persona SET apellido='"+txtApellido.getText()+"',correoElectronico='"+txtCorreoElectronico.getText()+"',direccion='"+txtDireccion.getText()+"',estado='A',nombre='"+txtNombre.getText()+"',telefono='"+txtTelefono.getText()+"' WHERE CI='"+txtCedula.getText()+"'");
            pst.executeUpdate();
            mostrarDatos("");
            JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionPerformed
        try {
            int fila = JTPersonal.getSelectedRow();
            String valor = JTPersonal.getValueAt(fila,7).toString();
            if(valor.equals("A")){
                PreparedStatement pst = cn.prepareStatement("UPDATE persona SET estado='D' WHERE CI='"+txtCedula.getText()+"'");
                pst.executeUpdate();
                mostrarDatos("");
                JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                PreparedStatement pst = cn.prepareStatement("UPDATE persona SET estado='A' WHERE CI='"+txtCedula.getText()+"'");
                pst.executeUpdate();
                mostrarDatos("");
                JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmJuguete.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_jButtonActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        Persona per = null;
        if (btnCrear.getText().equals("Crear")) {
            per = personadb.TraerClientes(txtCedula.getText());
            if (per == null) {
                if (ValidarCampos() == true) {
                    per = new Persona();
                    Rol r = new Rol();
                    if (cbxRolesPersonal.getSelectedItem().equals("Cliente")) {
                        r = RolDB.TraerRoles("Cliente");
                        per.setRol(r);
                        per.setCI(txtCedula.getText().trim());
                        per.setNombre(txtNombre.getText().trim());
                        per.setApellido(txtApellido.getText().trim());
                        per.setCorreoElectronico(txtCorreoElectronico.getText().trim());
                        per.setDireccion(txtDireccion.getText().trim());
                        per.setTelefono(txtTelefono.getText().trim());
                        per.setEstado("A");
                        r.getPersonas().add(per);
                        personadb.Cliente(per);
                        JOptionPane.showMessageDialog(null, "Cliente Guardado exitoso", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        inicio();
                        limpiar();
                    } else {
                        if (cbxRolesPersonal.getSelectedItem().equals("Administrador")) {
                            r = RolDB.TraerRoles("Administrador");
                            per.setRol(r);
                            per.setCI(txtCedula.getText().trim());
                            per.setNombre(txtNombre.getText().trim());
                            per.setApellido(txtApellido.getText().trim());
                            per.setCorreoElectronico(txtCorreoElectronico.getText().trim());
                            per.setDireccion(txtDireccion.getText().trim());
                            per.setTelefono(txtTelefono.getText().trim());
                            per.setEstado("A");
                            r.getPersonas().add(per);
                            personadb.Cliente(per);
                            JOptionPane.showMessageDialog(null, "Cliente Guardado exitoso", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            inicio();
                            limpiar();
                        } else {
                            if (cbxRolesPersonal.getSelectedItem().equals("Empleado")) {
                                r = RolDB.TraerRoles("Empleado");
                                per.setRol(r);
                                per.setCI(txtCedula.getText().trim());
                                per.setNombre(txtNombre.getText().trim());
                                per.setApellido(txtApellido.getText().trim());
                                per.setCorreoElectronico(txtCorreoElectronico.getText().trim());
                                per.setDireccion(txtDireccion.getText().trim());
                                per.setTelefono(txtTelefono.getText().trim());
                                per.setEstado("A");
                                r.getPersonas().add(per);
                                personadb.Cliente(per);
                                JOptionPane.showMessageDialog(null, "Guardado exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                inicio();
                                limpiar();
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Llenar campos sin escribir", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El número de cédula ya existe en el sistema", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        val.ValidarLetra(evt, txtNombre, 50);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        // TODO add your handling code here:
        val.ValidarLetra(evt, txtApellido, 50);
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        // TODO add your handling code here:
        val.ValidarNumero(evt, txtCedula, 10);
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        val.ValidarNumero(evt, txtTelefono, 10);
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void JTPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTPersonalMouseClicked
        int fila = JTPersonal.getSelectedRow();
        if (fila >=0 ){
            txtCedula.setText(JTPersonal.getValueAt(fila, 0).toString());
            txtNombre.setText(JTPersonal.getValueAt(fila, 1).toString());
            txtApellido.setText(JTPersonal.getValueAt(fila, 2).toString());
            txtCorreoElectronico.setText(JTPersonal.getValueAt(fila, 3).toString());
            txtDireccion.setText(JTPersonal.getValueAt(fila, 4).toString());
            txtTelefono.setText(JTPersonal.getValueAt(fila, 5).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un juguete");
        }   
    }//GEN-LAST:event_JTPersonalMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtBusqueda.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "LLENAR CAMPO REQUERIDO", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtBusqueda.requestFocus();
        } else {
            mostrarDatos(txtBusqueda.getText());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        FrmMenu();
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrmPersonal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(FrmPersonal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(FrmPersonal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(FrmPersonal.class.getName()).log(Level.SEVERE, null, ex);
                }
                new FrmPersonal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTPersonal;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbxRolesPersonal;
    private javax.swing.JComboBox<String> cbxTipoBusqueda;
    private javax.swing.JButton jButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private java.awt.TextField txtApellido;
    private java.awt.TextField txtBusqueda;
    private java.awt.TextField txtCedula;
    private java.awt.TextField txtCorreoElectronico;
    private java.awt.TextField txtDireccion;
    private java.awt.TextField txtNombre;
    private java.awt.TextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
