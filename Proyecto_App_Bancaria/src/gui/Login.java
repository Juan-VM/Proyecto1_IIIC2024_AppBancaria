package gui;

import Personas.Administradores;
import Personas.Usuarios;
import Sedes.SedeCentral;
import Sedes.SedeCiudadColon;
import Sedes.SedePuriscal;
import Sedes.SedeSanPedro;
import gui.PrincipalAdmins;
import gui.PrincipalUsers;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    boolean verPassword = false;
    String cedula;
    int rol;
    int sede;
    int intentosRestantes;

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtsPorDefecto();
        this.intentosRestantes = 3;
    }

    public void txtsPorDefecto() {
        txtCedula.setText("Ingrese su cedula");
        psdPassword.setText("Ingrese su password");
    }

    public boolean validarDatos(String listaRol) {

        ArrayList<Usuarios> listaUsers = SedeCentral.getListaUsers();
        ArrayList<Administradores> listaAdmins = SedeCentral.getListaAdmins();

        boolean CredencialesIguales = false;
        String cedula = txtCedula.getText();
        String password = String.valueOf(psdPassword.getPassword());

        try {
            switch (listaRol) {
                case "usuarios" -> {
                    for (Usuarios p : listaUsers) {
                        if (p.getCedula().equals(cedula) && p.getPassword().equals(password)) {
                            CredencialesIguales = true;
                            this.cedula = p.getCedula();
                            sede = p.getSede();
                        }
                    }
                }
                case "administradores" -> {
                    for (Administradores p : listaAdmins) {
                        if (p.getCedula().equals(cedula) && p.getPassword().equals(password)) {
                            CredencialesIguales = true;
                            this.cedula = p.getCedula();
                            sede = p.getSede();
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, intentalo de nuevo");
            txtsPorDefecto();
        }

        if (CredencialesIguales == true) {
            JOptionPane.showMessageDialog(null, "Datos correctos");

        } else if (CredencialesIguales == false) {
            JOptionPane.showMessageDialog(null, "Datos incorrectos");
            txtsPorDefecto();
        }
        return CredencialesIguales;
    }

    public void getRol(ArrayList<Administradores> listaAd, ArrayList<Usuarios> listaUs) {
        for (Administradores a : listaAd) {
            if (a.getCedula().equals(txtCedula.getText()) && a.getPassword().equals(String.valueOf(psdPassword.getPassword()))) {
                rol = a.getRol();
            }
        }
        for (Usuarios u : listaUs) {
            if (u.getCedula().equals(txtCedula.getText()) && u.getPassword().equals(String.valueOf(psdPassword.getPassword()))) {
                rol = u.getRol();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        backgroundLogin = new javax.swing.JPanel();
        panelAtras = new javax.swing.JPanel();
        jblAtras = new javax.swing.JLabel();
        jblBarraArriba = new javax.swing.JLabel();
        jblLogo = new javax.swing.JLabel();
        jblNombreBanco = new javax.swing.JLabel();
        jblFrase = new javax.swing.JLabel();
        jblFondoPanel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jblPassword = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jblCedula = new javax.swing.JLabel();
        psdPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        panelEntrar = new javax.swing.JPanel();
        jblEntrar = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jblIniciarSesion = new javax.swing.JLabel();
        panelnAtras = new javax.swing.JPanel();
        panelVerPassword = new javax.swing.JPanel();
        jblVerPassword = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelLogin.setBackground(new java.awt.Color(255, 255, 255));
        panelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backgroundLogin.setBackground(new java.awt.Color(255, 255, 255));
        backgroundLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAtras.setBackground(new java.awt.Color(252, 247, 215));
        panelAtras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblAtras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        jblAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblAtrasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblAtrasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblAtrasMouseExited(evt);
            }
        });
        panelAtras.add(jblAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        backgroundLogin.add(panelAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        jblBarraArriba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BarraInicio.png"))); // NOI18N
        backgroundLogin.add(jblBarraArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 50));

        jblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bambuLogo128px.png"))); // NOI18N
        backgroundLogin.add(jblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 390, 130));

        jblNombreBanco.setFont(new java.awt.Font("STSong", 1, 36)); // NOI18N
        jblNombreBanco.setForeground(new java.awt.Color(51, 51, 51));
        jblNombreBanco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblNombreBanco.setText("BNBUU");
        backgroundLogin.add(jblNombreBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 420, 390, -1));

        jblFrase.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblFrase.setForeground(new java.awt.Color(51, 51, 51));
        jblFrase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblFrase.setText("Deje que su dinero brote con nosotros");
        backgroundLogin.add(jblFrase, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 510, 390, -1));

        jblFondoPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N
        backgroundLogin.add(jblFondoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 390, 680));

        jLabel1.setFont(new java.awt.Font("STSong", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bambuLogo64px.png"))); // NOI18N
        jLabel1.setText("BNBUU");
        backgroundLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 205, -1));

        jblPassword.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jblPassword.setForeground(new java.awt.Color(51, 51, 51));
        jblPassword.setText("PASSWORD");
        backgroundLogin.add(jblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        txtCedula.setBackground(new java.awt.Color(255, 255, 255));
        txtCedula.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtCedula.setForeground(new java.awt.Color(204, 204, 204));
        txtCedula.setText("Ingrese su cedula");
        txtCedula.setBorder(null);
        txtCedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCedulaMousePressed(evt);
            }
        });
        backgroundLogin.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 420, 50));

        jblCedula.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jblCedula.setForeground(new java.awt.Color(51, 51, 51));
        jblCedula.setText("CEDULA");
        backgroundLogin.add(jblCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        psdPassword.setBackground(new java.awt.Color(255, 255, 255));
        psdPassword.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        psdPassword.setForeground(new java.awt.Color(204, 204, 204));
        psdPassword.setText("Ingrese su password");
        psdPassword.setBorder(null);
        psdPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                psdPasswordMousePressed(evt);
            }
        });
        backgroundLogin.add(psdPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 380, 60));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        backgroundLogin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 530, 10));

        panelEntrar.setBackground(new java.awt.Color(92, 88, 29));
        panelEntrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblEntrar.setBackground(new java.awt.Color(92, 88, 29));
        jblEntrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jblEntrar.setForeground(new java.awt.Color(255, 255, 255));
        jblEntrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblEntrar.setText("ENTRAR");
        jblEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblEntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblEntrarMouseExited(evt);
            }
        });
        panelEntrar.add(jblEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 70));

        backgroundLogin.add(panelEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 570, 170, 70));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        backgroundLogin.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 530, 10));

        jblIniciarSesion.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jblIniciarSesion.setForeground(new java.awt.Color(51, 51, 51));
        jblIniciarSesion.setText("INICIAR SESION");
        backgroundLogin.add(jblIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        panelnAtras.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelnAtrasLayout = new javax.swing.GroupLayout(panelnAtras);
        panelnAtras.setLayout(panelnAtrasLayout);
        panelnAtrasLayout.setHorizontalGroup(
            panelnAtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        panelnAtrasLayout.setVerticalGroup(
            panelnAtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        backgroundLogin.add(panelnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 40));

        panelVerPassword.setBackground(new java.awt.Color(255, 255, 255));
        panelVerPassword.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblVerPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblVerPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojoCerrado.png"))); // NOI18N
        jblVerPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblVerPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblVerPasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblVerPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblVerPasswordMouseExited(evt);
            }
        });
        panelVerPassword.add(jblVerPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        backgroundLogin.add(panelVerPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, 40, 40));

        panelLogin.add(backgroundLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, -1, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCedulaMousePressed

        String psd = String.valueOf(psdPassword.getPassword());
        if (txtCedula.getText().equals("Ingrese su cedula")) {
            txtCedula.setText("");
        }
        txtCedula.setForeground(Color.black);
        if (psd.equals("")) {
            psdPassword.setText("Ingrese su password");
        } else {
            psdPassword.setText(psd);
        }
        psdPassword.setForeground(new Color(155, 155, 155));
    }//GEN-LAST:event_txtCedulaMousePressed

    private void psdPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_psdPasswordMousePressed

        String user = txtCedula.getText();
        if (String.valueOf(psdPassword.getPassword()).equals("Ingrese su password")) {
            psdPassword.setText("");
        }
        psdPassword.setForeground(Color.black);
        if (user.equals("")) {
            txtCedula.setText("Ingrese su cedula");
        } else {
            txtCedula.setText(user);
        }
        txtCedula.setForeground(new Color(155, 155, 155));
    }//GEN-LAST:event_psdPasswordMousePressed

    private void jblEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblEntrarMouseClicked

        ArrayList<Usuarios> listaUsers = SedeCentral.getListaUsers();
        ArrayList<Administradores> listaAdmins = SedeCentral.getListaAdmins();
        boolean datosIguales;
        getRol(listaAdmins, listaUsers);

        switch (this.rol) {
            case 0 -> {
                for (Usuarios i : SedeCentral.getListaUsers()) {
                    if (i.getCedula().equals(txtCedula.getText())) {
                        if (i.getEstadoUsuario() == true) {
                            if (this.intentosRestantes > 0) {

                                datosIguales = validarDatos("usuarios");
                                if (datosIguales == true) {
                                    PrincipalUsers users = new PrincipalUsers(this.cedula, this.sede);
                                    users.setVisible(true);
                                    this.dispose();
                                } else {
                                    this.intentosRestantes -= 1;
                                }
                            } else {
                                i.setEstadoUsuario(false);
                            }
                        } else {
                            int eleccion = JOptionPane.showConfirmDialog(null, "Cuenta bloqueada, deseas solicitar desbloqueo?", "Advertencia", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                            if (eleccion == 0) {
                                if (!SedeCentral.getListaCuentasBloqueadas().contains(i)) {
                                    SedeCentral.getListaCuentasBloqueadas().add(i);
                                    switch (i.getSede()) {
                                        case 0 -> {
                                            SedePuriscal.getListaCuentasBloqueadas().add(i);
                                        }
                                        case 1 -> {
                                            SedeSanPedro.getListaCuentasBloqueadas().add(i);
                                        }
                                        case 2 -> {
                                            SedeCiudadColon.getListaCuentasBloqueadas().add(i);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos incorrectos");
                    }
                }
            }
            case 1 -> {
                for (Administradores a : SedeCentral.getListaAdmins()) {
                    if (a.getCedula().equals(txtCedula.getText())) {

                        datosIguales = validarDatos("administradores");
                        if (datosIguales == true) {
                            PrincipalAdmins admins = new PrincipalAdmins(this.cedula);
                            admins.setVisible(true);
                            this.dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos incorrectos");
                    }
                }
            }
        }
    }//GEN-LAST:event_jblEntrarMouseClicked

    private void jblEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblEntrarMouseEntered
        panelEntrar.setBackground(new Color(153, 145, 86));
        jblEntrar.setForeground(Color.black);
    }//GEN-LAST:event_jblEntrarMouseEntered

    private void jblEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblEntrarMouseExited
        panelEntrar.setBackground(new Color(92, 88, 29));
        jblEntrar.setForeground(Color.white);
    }//GEN-LAST:event_jblEntrarMouseExited

    private void jblVerPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerPasswordMouseClicked
        if (verPassword == false) {
            verPassword = true;
            jblVerPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojoAbierto.png")));
            psdPassword.setEchoChar((char) 0);
        } else {
            verPassword = false;
            jblVerPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojoCerrado.png")));
            psdPassword.setEchoChar('*');

        }
    }//GEN-LAST:event_jblVerPasswordMouseClicked

    private void jblVerPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerPasswordMouseEntered
        panelVerPassword.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_jblVerPasswordMouseEntered

    private void jblVerPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerPasswordMouseExited
        panelVerPassword.setBackground(Color.white);
    }//GEN-LAST:event_jblVerPasswordMouseExited

    private void jblAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblAtrasMouseClicked
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jblAtrasMouseClicked

    private void jblAtrasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblAtrasMouseEntered
        panelAtras.setBackground(new Color(232, 225, 182));
    }//GEN-LAST:event_jblAtrasMouseEntered

    private void jblAtrasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblAtrasMouseExited
        panelAtras.setBackground(new Color(252, 247, 215));
    }//GEN-LAST:event_jblAtrasMouseExited

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jblAtras;
    private javax.swing.JLabel jblBarraArriba;
    private javax.swing.JLabel jblCedula;
    private javax.swing.JLabel jblEntrar;
    private javax.swing.JLabel jblFondoPanel;
    private javax.swing.JLabel jblFrase;
    private javax.swing.JLabel jblIniciarSesion;
    private javax.swing.JLabel jblLogo;
    private javax.swing.JLabel jblNombreBanco;
    private javax.swing.JLabel jblPassword;
    private javax.swing.JLabel jblVerPassword;
    private javax.swing.JPanel panelAtras;
    private javax.swing.JPanel panelEntrar;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelVerPassword;
    private javax.swing.JPanel panelnAtras;
    private javax.swing.JPasswordField psdPassword;
    private javax.swing.JTextField txtCedula;
    // End of variables declaration//GEN-END:variables
}
