/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Controlador_Persona;
import Controlador.Controlador_Rol;
import Controlador.Controlador_Validar;
import Modelo.Persona;
import Modelo.Rol;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
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
        JTPersona.getColumnModel().getColumn(0).setMaxWidth(0);
        JTPersona.getColumnModel().getColumn(0).setMinWidth(0);
        JTPersona.getColumnModel().getColumn(0).setPreferredWidth(0);

        JTPersona.getColumnModel().getColumn(1).setPreferredWidth(220);
        JTPersona.getColumnModel().getColumn(2).setPreferredWidth(220);
        JTPersona.getColumnModel().getColumn(3).setPreferredWidth(220);
        JTPersona.getColumnModel().getColumn(4).setPreferredWidth(220);
        JTPersona.getColumnModel().getColumn(5).setPreferredWidth(220);
        JTPersona.getColumnModel().getColumn(6).setPreferredWidth(220);
        JTPersona.getColumnModel().getColumn(7).setPreferredWidth(220);
        JTPersona.getColumnModel().getColumn(8).setPreferredWidth(220);

        TablaPersona = (DefaultTableModel) JTPersona.getModel();
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

    private void buscaPersonaCedula(String ced) {
        TablaPersona.setNumRows(0);
        List<Persona> lis = null;
        lis = personadb.buscarPersona(ced, lis);

        if (lis.size() > 0) {
            for (Persona perLis : lis) {
                TablaPersona.addRow(new Object[]{
                    perLis.getIdPersona(), perLis.getCI(), perLis.getNombre(), perLis.getApellido(), perLis.getTelefono(), perLis.getCorreoElectronico(), perLis.getDireccion(), perLis.getEstado(), perLis.getRol().getTipo()

                });
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            txtBusqueda.requestFocus();
            inicio();
        }
    }

//      private void cargarTabla(String cedula) {
//        List<Persona> lista = null;
//        lista = personadb.cargarCliente(lista, cedula);
//        for (Persona persona : lista) {
//            TablaPersona.addRow(new Object[]{
//                persona.getCI(), persona.getNombre(), persona.getApellido(), persona.getTelefono(), persona.getCorreoElectronico(), persona.getTelefono(), persona.getEstado()
//
//            });
//        }
//    }
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
        cbxTipoBusqueda = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTPersona = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        txtBusqueda = new java.awt.TextField();
        jPanel1 = new javax.swing.JPanel();
        cbxRolesPersonal = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        txtNombre = new java.awt.TextField();
        txtApellido = new java.awt.TextField();
        txtCedula = new java.awt.TextField();
        txtCorreoElectronico = new java.awt.TextField();
        txtTelefono = new java.awt.TextField();
        txtDireccion = new java.awt.TextField();

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
        setBackground(new java.awt.Color(233, 250, 241));

        jPanel2.setBackground(new java.awt.Color(234, 250, 241));

        cbxTipoBusqueda.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        cbxTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cédula", "Nombre" }));

        JTPersona.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        JTPersona.setModel(new javax.swing.table.DefaultTableModel(
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
        JTPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTPersonaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTPersona);

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

        txtBusqueda.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(253, 242, 233));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Courier New", 0, 12))); // NOI18N

        cbxRolesPersonal.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        cbxRolesPersonal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Administrador", "Empleado" }));
        cbxRolesPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRolesPersonalActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel1.setText("Rol:");

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel2.setText("Nombres:");

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel3.setText("Apellidos:");

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel4.setText("Cédula:");

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel5.setText("Correo Electrónico:");

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel6.setText("Teléfono:");

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel7.setText("Dirección:");

        btnModificar.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ActivarDesactivar.png"))); // NOI18N
        jButton5.setText("Activar/Desactivar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(56, 56, 56)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addComponent(cbxRolesPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(227, 227, 227))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxRolesPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(25, 25, 25)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnCrear)
                    .addComponent(jButton5))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(20, Short.MAX_VALUE))
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
                        personadb.ActualizarCliente(per);
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
                            personadb.ActualizarCliente(per);
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
                                personadb.ActualizarCliente(per);
                                JOptionPane.showMessageDialog(null, "Cliente Guardado exitoso", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
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
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
                                JOptionPane.showMessageDialog(null, "Cliente Guardado exitoso", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
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

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        FrmMenu();
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void JTPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTPersonaMouseClicked
        // TODO add your handling code here:
        int selectRow = JTPersona.getSelectedRow();
        int idCedula = Integer.parseInt(TablaPersona.getValueAt(selectRow, 0).toString());
        cargarPersonas(idCedula);
    }//GEN-LAST:event_JTPersonaMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        if (cbxTipoBusqueda.getSelectedItem().equals("Cédula")) {
            //val.ValidarCedula(txtBusqueda.getText(), txtBusqueda);
            if (txtBusqueda.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "LLENAR CAMPO REQUERIDO", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                txtBusqueda.requestFocus();
            } else {
                buscaPersonaCedula(txtBusqueda.getText());
            }
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

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
                new FrmPersonal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTPersona;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbxRolesPersonal;
    private javax.swing.JComboBox<String> cbxTipoBusqueda;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
