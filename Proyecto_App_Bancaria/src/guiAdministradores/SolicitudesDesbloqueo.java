package guiAdministradores;

import guiAdministradores.PrincipalAdmins;
import Personas.Administradores;
import Personas.Usuarios;
import RegistroDatos.BaseDatos;
import Sedes.SedeCentral;
import Sedes.SedeCiudadColon;
import Sedes.SedePuriscal;
import Sedes.SedeSanPedro;
import guiUsuarios.Inicio;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SolicitudesDesbloqueo extends javax.swing.JFrame {

    String cedula;
    DefaultTableModel modelo = new DefaultTableModel();

    public SolicitudesDesbloqueo(String cedula) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cedula = cedula;
        jblSoloNumeros.setVisible(false);

        tablaSolicitudesDesbloqueo.setModel(modelo);
        this.modelo.addColumn("Usuario");
        this.modelo.addColumn("Cedula");
        this.modelo.addColumn("Sede");
        for (Usuarios i : SedeCentral.getListaCuentasBloqueadas()) {
            String sede = "";
            switch (i.getSede()) {
                case 0 -> {
                    sede = "Puriscal";
                }
                case 1 -> {
                    sede = "San Pedro";
                }
                case 2 -> {
                    sede = "Ciudad Colon";
                }
            }
            modelo.addRow(new Object[]{i.getUsuario(), i.getCedula(), sede});
        }
    }

    public SolicitudesDesbloqueo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLibre = new javax.swing.JPanel();
        Background = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSolicitudesDesbloqueo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtClaveNum = new javax.swing.JTextField();
        panelDesbloquear = new javax.swing.JPanel();
        jblDesbloquear = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCedulaUser = new javax.swing.JTextField();
        jblSoloNumeros = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        itemBienvenida = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemIrInicio = new javax.swing.JMenuItem();
        menuGestionUsuarios = new javax.swing.JMenu();
        menuBloqueoDesbloqueo = new javax.swing.JMenu();
        itemSolicitudesDesbloqueo = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemBloquearCuenta = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        itemDesbloquearCuenta = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        itemEliminarUsuario = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        itemRestaurarUsuario = new javax.swing.JMenuItem();
        menuInformacionSedes = new javax.swing.JMenu();
        itemSedePuriscal = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemSedeSanPedro = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        itemSedeCiudadColon = new javax.swing.JMenuItem();
        menuComentarios = new javax.swing.JMenu();
        itemComentariosUsuarios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelLibre.setBackground(new java.awt.Color(255, 255, 255));

        Background.setBackground(new java.awt.Color(252, 247, 215));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaSolicitudesDesbloqueo.setBackground(new java.awt.Color(204, 204, 204));
        tablaSolicitudesDesbloqueo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tablaSolicitudesDesbloqueo.setForeground(new java.awt.Color(51, 51, 51));
        tablaSolicitudesDesbloqueo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaSolicitudesDesbloqueo);

        Background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 580));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Selecciona el usuario para desbloquear cuenta");
        Background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 620, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Admin ingresa tu clave numerica");
        Background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 620, -1));

        txtClaveNum.setBackground(new java.awt.Color(255, 255, 255));
        txtClaveNum.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtClaveNum.setForeground(new java.awt.Color(51, 51, 51));
        txtClaveNum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClaveNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClaveNumKeyTyped(evt);
            }
        });
        Background.add(txtClaveNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 200, 50));

        panelDesbloquear.setBackground(new java.awt.Color(92, 88, 29));
        panelDesbloquear.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblDesbloquear.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jblDesbloquear.setForeground(new java.awt.Color(255, 255, 255));
        jblDesbloquear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblDesbloquear.setText("DESBLOQUEAR");
        jblDesbloquear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblDesbloquear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblDesbloquearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblDesbloquearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblDesbloquearMouseExited(evt);
            }
        });
        panelDesbloquear.add(jblDesbloquear, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 70));

        Background.add(panelDesbloquear, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 540, 220, 70));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ingresa la cedula del usuario");
        Background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 620, -1));

        txtCedulaUser.setBackground(new java.awt.Color(255, 255, 255));
        txtCedulaUser.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtCedulaUser.setForeground(new java.awt.Color(51, 51, 51));
        txtCedulaUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Background.add(txtCedulaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, 280, 50));

        jblSoloNumeros.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jblSoloNumeros.setForeground(new java.awt.Color(255, 102, 102));
        jblSoloNumeros.setText("Solo numeros");
        Background.add(jblSoloNumeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 220, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tabla solicitudes de desbloqueo");
        Background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 450, -1));

        javax.swing.GroupLayout panelLibreLayout = new javax.swing.GroupLayout(panelLibre);
        panelLibre.setLayout(panelLibreLayout);
        panelLibreLayout.setHorizontalGroup(
            panelLibreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelLibreLayout.setVerticalGroup(
            panelLibreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLibreLayout.createSequentialGroup()
                .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        barraMenu.setBackground(new java.awt.Color(255, 255, 255));
        barraMenu.setBorder(null);
        barraMenu.setForeground(new java.awt.Color(51, 51, 51));

        menuInicio.setText("Inicio");

        itemBienvenida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemBienvenida.setText("Bienvenida");
        itemBienvenida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBienvenidaActionPerformed(evt);
            }
        });
        menuInicio.add(itemBienvenida);
        menuInicio.add(jSeparator1);

        itemIrInicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemIrInicio.setText("Ir a Inicio");
        itemIrInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemIrInicioActionPerformed(evt);
            }
        });
        menuInicio.add(itemIrInicio);

        barraMenu.add(menuInicio);

        menuGestionUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        menuGestionUsuarios.setForeground(new java.awt.Color(51, 51, 51));
        menuGestionUsuarios.setText("Gestion usuarios y cuentas");
        menuGestionUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        menuBloqueoDesbloqueo.setText("Bloqueos y desbloqueos");
        menuBloqueoDesbloqueo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemSolicitudesDesbloqueo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemSolicitudesDesbloqueo.setText("Solicitudes debloqueo cuenta");
        itemSolicitudesDesbloqueo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSolicitudesDesbloqueoActionPerformed(evt);
            }
        });
        menuBloqueoDesbloqueo.add(itemSolicitudesDesbloqueo);
        menuBloqueoDesbloqueo.add(jSeparator2);

        itemBloquearCuenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemBloquearCuenta.setText("Bloquear cuenta");
        itemBloquearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBloquearCuentaActionPerformed(evt);
            }
        });
        menuBloqueoDesbloqueo.add(itemBloquearCuenta);
        menuBloqueoDesbloqueo.add(jSeparator5);

        itemDesbloquearCuenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemDesbloquearCuenta.setText("Desbloquear cuenta");
        itemDesbloquearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDesbloquearCuentaActionPerformed(evt);
            }
        });
        menuBloqueoDesbloqueo.add(itemDesbloquearCuenta);

        menuGestionUsuarios.add(menuBloqueoDesbloqueo);
        menuGestionUsuarios.add(jSeparator6);

        itemEliminarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemEliminarUsuario.setText("Eliminar usuario");
        itemEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarUsuarioActionPerformed(evt);
            }
        });
        menuGestionUsuarios.add(itemEliminarUsuario);
        menuGestionUsuarios.add(jSeparator7);

        itemRestaurarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemRestaurarUsuario.setText("Restaurar Usuario");
        itemRestaurarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRestaurarUsuarioActionPerformed(evt);
            }
        });
        menuGestionUsuarios.add(itemRestaurarUsuario);

        barraMenu.add(menuGestionUsuarios);

        menuInformacionSedes.setText("Informacion sedes");

        itemSedePuriscal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemSedePuriscal.setText("Sede Puriscal");
        itemSedePuriscal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSedePuriscalActionPerformed(evt);
            }
        });
        menuInformacionSedes.add(itemSedePuriscal);
        menuInformacionSedes.add(jSeparator3);

        itemSedeSanPedro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemSedeSanPedro.setText("Sede San Pedro");
        itemSedeSanPedro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSedeSanPedroActionPerformed(evt);
            }
        });
        menuInformacionSedes.add(itemSedeSanPedro);
        menuInformacionSedes.add(jSeparator4);

        itemSedeCiudadColon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemSedeCiudadColon.setText("Sede Ciudad Colon");
        itemSedeCiudadColon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSedeCiudadColonActionPerformed(evt);
            }
        });
        menuInformacionSedes.add(itemSedeCiudadColon);

        barraMenu.add(menuInformacionSedes);

        menuComentarios.setText("Comentarios");

        itemComentariosUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemComentariosUsuarios.setText("Comentarios usuarios");
        itemComentariosUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemComentariosUsuariosActionPerformed(evt);
            }
        });
        menuComentarios.add(itemComentariosUsuarios);

        barraMenu.add(menuComentarios);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLibre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLibre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemBienvenidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBienvenidaActionPerformed
        PrincipalAdmins admins = new PrincipalAdmins(cedula);
        admins.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemBienvenidaActionPerformed

    private void itemIrInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemIrInicioActionPerformed
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemIrInicioActionPerformed

    private void itemSolicitudesDesbloqueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSolicitudesDesbloqueoActionPerformed

    }//GEN-LAST:event_itemSolicitudesDesbloqueoActionPerformed

    private void itemBloquearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBloquearCuentaActionPerformed
        BloquearCuenta bloquear = new BloquearCuenta(this.cedula);
        bloquear.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemBloquearCuentaActionPerformed

    private void itemSedePuriscalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSedePuriscalActionPerformed
        GestionSedes gestion = new GestionSedes(0, this.cedula);
        gestion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemSedePuriscalActionPerformed

    private void itemSedeSanPedroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSedeSanPedroActionPerformed
        GestionSedes gestion = new GestionSedes(1, this.cedula);
        gestion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemSedeSanPedroActionPerformed

    private void itemSedeCiudadColonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSedeCiudadColonActionPerformed
        GestionSedes gestion = new GestionSedes(2, this.cedula);
        gestion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemSedeCiudadColonActionPerformed

    private void jblDesbloquearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblDesbloquearMouseEntered
        panelDesbloquear.setBackground(new Color(153, 145, 86));
        jblDesbloquear.setForeground(Color.black);
    }//GEN-LAST:event_jblDesbloquearMouseEntered

    private void jblDesbloquearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblDesbloquearMouseExited
        panelDesbloquear.setBackground(new Color(92, 88, 29));
        jblDesbloquear.setForeground(Color.white);
    }//GEN-LAST:event_jblDesbloquearMouseExited

    private void jblDesbloquearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblDesbloquearMouseClicked
        if (tablaSolicitudesDesbloqueo.getRowCount() > 0) {
            try {
                if (tablaSolicitudesDesbloqueo.getSelectedRow() >= 0) {
                    int filaSeleccionada = tablaSolicitudesDesbloqueo.getSelectedRow();
                    String cedulaUser = tablaSolicitudesDesbloqueo.getValueAt(filaSeleccionada, 1).toString();
                    boolean datosCorrectos = false;

                    for (Administradores i : SedeCentral.getListaAdmins()) {
                        if (i.getClaveNumerica() == Integer.parseInt(txtClaveNum.getText()) && cedulaUser.equals(txtCedulaUser.getText())) {
                            datosCorrectos = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Datos incorrectos");
                        }
                    }
                    if (datosCorrectos == true) {
                        for (Usuarios u : SedeCentral.getListaUsers()) {
                            if (u.getCedula().equals(cedulaUser)) {
                                u.setEstadoUsuario(true);
                                SedeCentral.getListaCuentasBloqueadas().remove(u);
                                modelo.removeRow(filaSeleccionada);
                                switch (u.getSede()) {
                                    case 0 -> {
                                        SedePuriscal.getListaCuentasBloqueadas().remove(u);
                                    }
                                    case 1 -> {
                                        SedeSanPedro.getListaCuentasBloqueadas().remove(u);
                                    }
                                    case 2 -> {
                                        SedeCiudadColon.getListaCuentasBloqueadas().remove(u);
                                    }
                                }
                                try {
                                    BaseDatos.actualizarBaseDatos();
                                } catch (IOException ex) {
                                    JOptionPane.showMessageDialog(null, "Error actualizando la base de datos");
                                }
                                JOptionPane.showMessageDialog(null, "Cuenta habilitada para: " + u.getUsuario());
                                txtClaveNum.setText("");
                                txtCedulaUser.setText("");
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error, selecciona una fila");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error, verifica los datos ingresados");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay solicitudes pendientes");
        }
    }//GEN-LAST:event_jblDesbloquearMouseClicked

    private void txtClaveNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveNumKeyTyped
        char tecla = evt.getKeyChar();
        boolean teclaBorrar = true;
        if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
            teclaBorrar = false;
        }

        if (!Character.isDigit(tecla) && teclaBorrar == false) {
            evt.consume();
            jblSoloNumeros.setVisible(true);
            jblSoloNumeros.setText("Solo numeros");
        } else if (txtClaveNum.getText().length() == 4) {
            evt.consume();
            jblSoloNumeros.setText("Max numeros alcanzado");
            jblSoloNumeros.setVisible(true);
        } else {
            jblSoloNumeros.setVisible(false);
            jblSoloNumeros.setVisible(false);
        }
    }//GEN-LAST:event_txtClaveNumKeyTyped

    private void itemDesbloquearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDesbloquearCuentaActionPerformed
        DesbloquearCuenta desbloquear = new DesbloquearCuenta(this.cedula);
        desbloquear.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemDesbloquearCuentaActionPerformed

    private void itemEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarUsuarioActionPerformed
        EliminarUsuario eliminar = new EliminarUsuario(this.cedula);
        eliminar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemEliminarUsuarioActionPerformed

    private void itemRestaurarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRestaurarUsuarioActionPerformed
        RestaurarUsuario restaurar = new RestaurarUsuario(this.cedula);
        restaurar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemRestaurarUsuarioActionPerformed

    private void itemComentariosUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemComentariosUsuariosActionPerformed
        ComentariosUsuarios coments = new ComentariosUsuarios(this.cedula);
        coments.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemComentariosUsuariosActionPerformed

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
            java.util.logging.Logger.getLogger(SolicitudesDesbloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolicitudesDesbloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolicitudesDesbloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolicitudesDesbloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SolicitudesDesbloqueo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem itemBienvenida;
    private javax.swing.JMenuItem itemBloquearCuenta;
    private javax.swing.JMenuItem itemComentariosUsuarios;
    private javax.swing.JMenuItem itemDesbloquearCuenta;
    private javax.swing.JMenuItem itemEliminarUsuario;
    private javax.swing.JMenuItem itemIrInicio;
    private javax.swing.JMenuItem itemRestaurarUsuario;
    private javax.swing.JMenuItem itemSedeCiudadColon;
    private javax.swing.JMenuItem itemSedePuriscal;
    javax.swing.JMenuItem itemSedeSanPedro;
    private javax.swing.JMenuItem itemSolicitudesDesbloqueo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JLabel jblDesbloquear;
    private javax.swing.JLabel jblSoloNumeros;
    private javax.swing.JMenu menuBloqueoDesbloqueo;
    private javax.swing.JMenu menuComentarios;
    private javax.swing.JMenu menuGestionUsuarios;
    private javax.swing.JMenu menuInformacionSedes;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JPanel panelDesbloquear;
    private javax.swing.JPanel panelLibre;
    private javax.swing.JTable tablaSolicitudesDesbloqueo;
    private javax.swing.JTextField txtCedulaUser;
    private javax.swing.JTextField txtClaveNum;
    // End of variables declaration//GEN-END:variables
}
