package guiAdministradores;

import Personas.Usuarios;
import RegistroDatos.DatosRegistrados;
import Sedes.SedeCentral;
import Sedes.SedeCiudadColon;
import Sedes.SedePuriscal;
import Sedes.SedeSanPedro;
import guiUsuarios.Inicio;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RestaurarUsuario extends javax.swing.JFrame {

    String cedula;
    DefaultTableModel modelo = new DefaultTableModel();

    public RestaurarUsuario() {
        initComponents();
    }

    public RestaurarUsuario(String cedula) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cedula = cedula;
        modelo.addColumn("Usuario");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cedula");
        modelo.addColumn("Sede");
        modelo.addColumn("Estado");

        tablaEliminados.setModel(modelo);

        for (Usuarios i : DatosRegistrados.getListaUsuariosEliminados()) {
            String estado = "";
            String sede = "";
            if (i.getEstadoUsuario() == true) {
                estado = "Activo";
            } else {
                estado = "Bloqueado";
            }

            if (i.getSede() == 0) {
                sede = "Puriscal";
            } else if (i.getSede() == 1) {
                sede = "San Pedro";
            } else {
                sede = "Ciudad Colon";
            }
            modelo.addRow(new Object[]{i.getUsuario(), i.getApellidos(), i.getCedula(), sede, estado});
        }
    }
    
    public void reestablecerDatosUsuario(Usuarios user){
        user.getCuentaAhorro().setSaldo(0);
        user.getCuentaCorriente().setSaldo(0);
        user.getCuentaSimpe().setSaldo(0);
        
        user.getComprobantesSimpeSalida().clear();
        user.getComprobantesSimpeEntrada().clear();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelVisible = new javax.swing.JPanel();
        background = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEliminados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        panelMantener = new javax.swing.JPanel();
        jblMantener = new javax.swing.JLabel();
        panelBorrar = new javax.swing.JPanel();
        jblBorrar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        itemRestaurarUsuario = new javax.swing.JMenuItem();
        menuInformacionSedes = new javax.swing.JMenu();
        itemSedePuriscal = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemSedeSanPedro = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        itemSedeCiudadColon = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelVisible.setBackground(new java.awt.Color(255, 255, 255));

        background.setBackground(new java.awt.Color(252, 247, 215));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaEliminados.setBackground(new java.awt.Color(204, 204, 204));
        tablaEliminados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaEliminados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaEliminados);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 540, 590));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuarios eliminados");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 540, -1));

        panelMantener.setBackground(new java.awt.Color(92, 88, 29));
        panelMantener.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblMantener.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jblMantener.setForeground(new java.awt.Color(255, 255, 255));
        jblMantener.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblMantener.setText("Restaurar manteniendo datos");
        jblMantener.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblMantenerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblMantenerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblMantenerMouseExited(evt);
            }
        });
        panelMantener.add(jblMantener, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 60));

        background.add(panelMantener, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 410, 60));

        panelBorrar.setBackground(new java.awt.Color(92, 88, 29));
        panelBorrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblBorrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jblBorrar.setForeground(new java.awt.Color(255, 255, 255));
        jblBorrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblBorrar.setText("Restaurar borrando datos");
        jblBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblBorrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblBorrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblBorrarMouseExited(evt);
            }
        });
        panelBorrar.add(jblBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 60));

        background.add(panelBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, 410, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("* Restaura al usuario manteniendo el saldo e historial de sus cuentas");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("* Restaura al usuario con sus saldos de cuentas en 0 e historial vacio");
        background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 510, -1, -1));

        javax.swing.GroupLayout panelVisibleLayout = new javax.swing.GroupLayout(panelVisible);
        panelVisible.setLayout(panelVisibleLayout);
        panelVisibleLayout.setHorizontalGroup(
            panelVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
        );
        panelVisibleLayout.setVerticalGroup(
            panelVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
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
        menuGestionUsuarios.add(jSeparator10);

        itemRestaurarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemRestaurarUsuario.setText("Restaurar Usuario");
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

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVisible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVisible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemBienvenidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBienvenidaActionPerformed

    }//GEN-LAST:event_itemBienvenidaActionPerformed

    private void itemIrInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemIrInicioActionPerformed
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemIrInicioActionPerformed

    private void itemSolicitudesDesbloqueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSolicitudesDesbloqueoActionPerformed
        SolicitudesDesbloqueo soli = new SolicitudesDesbloqueo(this.cedula);
        soli.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemSolicitudesDesbloqueoActionPerformed

    private void itemBloquearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBloquearCuentaActionPerformed
        BloquearCuenta bloquear = new BloquearCuenta(this.cedula);
        bloquear.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemBloquearCuentaActionPerformed

    private void itemDesbloquearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDesbloquearCuentaActionPerformed
        DesbloquearCuenta desbloquear = new DesbloquearCuenta(this.cedula);
        desbloquear.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemDesbloquearCuentaActionPerformed

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

    private void jblMantenerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblMantenerMouseClicked
        if (tablaEliminados.getSelectedRow() >= 0) {
            int eleccion = JOptionPane.showConfirmDialog(null, "Deseas restaurar este usuario?", "RESTAURAR", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

            if (eleccion == 0) {
                int filaSeleccionada = tablaEliminados.getSelectedRow();
                String cedulaUser = tablaEliminados.getValueAt(filaSeleccionada, 2).toString();
                String sede = tablaEliminados.getValueAt(filaSeleccionada, 3).toString();
                int indice = 0;
                
                for(Usuarios i : DatosRegistrados.getListaUsuariosEliminados()){
                    if(i.getCedula().equals(cedulaUser)){
                        i.setEstadoCuenta(true);
                        indice = DatosRegistrados.getListaUsuariosEliminados().indexOf(i);
                        SedeCentral.getListaUsers().add(i);
                        switch (sede) {
                            case "Puriscal" ->{
                                SedePuriscal.getListaUsers().add(i);
                            }
                            case "San Pedro" ->{
                                SedeSanPedro.getListaUsers().add(i);
                            }
                            case "Ciudad Colon" ->{
                                SedeCiudadColon.getListaUsers().add(i);
                            }
                        }
                    }
                }
                DatosRegistrados.getListaUsuariosEliminados().remove(indice);
                modelo.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Usuario restaurado exitosamente");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error, selecciona un usuario");
        }
    }//GEN-LAST:event_jblMantenerMouseClicked

    private void jblBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblBorrarMouseClicked
        if (tablaEliminados.getSelectedRow() >= 0) {
            int eleccion = JOptionPane.showConfirmDialog(null, "Deseas restaurar el usuario?", "RESTAURAR", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

            if (eleccion == 0) {
                int filaSeleccionada = tablaEliminados.getSelectedRow();
                String cedulaUser = tablaEliminados.getValueAt(filaSeleccionada, 2).toString();
                String sede = tablaEliminados.getValueAt(filaSeleccionada, 3).toString();
                int indice = 0;
                
                for(Usuarios i : DatosRegistrados.getListaUsuariosEliminados()){
                    if(i.getCedula().equals(cedulaUser)){
                        i.setEstadoCuenta(true);
                        indice = DatosRegistrados.getListaUsuariosEliminados().indexOf(i);
                        reestablecerDatosUsuario(i);
                        SedeCentral.getListaUsers().add(i);
                        switch (sede) {
                            case "Puriscal" ->{
                                SedePuriscal.getListaUsers().add(i);
                            }
                            case "San Pedro" ->{
                                SedeSanPedro.getListaUsers().add(i);
                            }
                            case "Ciudad Colon" ->{
                                SedeCiudadColon.getListaUsers().add(i);
                            }
                        }
                    }
                }
                DatosRegistrados.getListaUsuariosEliminados().remove(indice);
                modelo.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Usuario restaurado exitosamente");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error, selecciona un usuario");
        }
    }//GEN-LAST:event_jblBorrarMouseClicked

    private void jblMantenerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblMantenerMouseEntered
        panelMantener.setBackground(new Color(153, 145, 86));
        jblMantener.setForeground(Color.black);
    }//GEN-LAST:event_jblMantenerMouseEntered

    private void jblMantenerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblMantenerMouseExited
        panelMantener.setBackground(new Color(92, 88, 29));
        jblMantener.setForeground(Color.white);
    }//GEN-LAST:event_jblMantenerMouseExited

    private void jblBorrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblBorrarMouseEntered
        panelBorrar.setBackground(new Color(153, 145, 86));
        jblBorrar.setForeground(Color.black);
    }//GEN-LAST:event_jblBorrarMouseEntered

    private void jblBorrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblBorrarMouseExited
        panelBorrar.setBackground(new Color(92, 88, 29));
        jblBorrar.setForeground(Color.white);
    }//GEN-LAST:event_jblBorrarMouseExited

    private void itemEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarUsuarioActionPerformed
        EliminarUsuario eliminar = new EliminarUsuario(this.cedula);
        eliminar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemEliminarUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(RestaurarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestaurarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestaurarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestaurarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem itemBienvenida;
    private javax.swing.JMenuItem itemBloquearCuenta;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JLabel jblBorrar;
    private javax.swing.JLabel jblMantener;
    private javax.swing.JMenu menuBloqueoDesbloqueo;
    private javax.swing.JMenu menuGestionUsuarios;
    private javax.swing.JMenu menuInformacionSedes;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JPanel panelBorrar;
    private javax.swing.JPanel panelMantener;
    private javax.swing.JPanel panelVisible;
    private javax.swing.JTable tablaEliminados;
    // End of variables declaration//GEN-END:variables
}
