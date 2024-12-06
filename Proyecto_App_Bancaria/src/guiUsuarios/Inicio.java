package guiUsuarios;

import Personas.Administradores;
import Personas.Usuarios;
import RegistroDatos.BaseDatos;
import RegistroDatos.DatosRegistrados;
import Sedes.SedeCentral;
import Sedes.SedeCiudadColon;
import Sedes.SedePuriscal;
import Sedes.SedeSanPedro;
import java.awt.Color;
import java.io.BufferedReader;

import java.io.FileReader;
import javax.swing.JOptionPane;

public class Inicio extends javax.swing.JFrame {

    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(null);

        try {
            BaseDatos.verfificarExistenciaArchivo();
            BufferedReader leer = new BufferedReader(new FileReader(BaseDatos.getArchivo()));
            String linea;
            int numeroLinea = 0;
            limpiarSedes();
            while ((linea = leer.readLine()) != null) {
                
                //Distribucion de la lista datos:
                //[0] = Usuario
                //[1] = Apellido
                //[2] = Cedula
                //[3] = Telefono
                //[4] = Password
                //[5] = Clave Num
                //[6] = Rol
                //[7] = Sede
                //Si es usuario...
                //[8] = saldo cuenta corriente
                //[9] = saldo cuenta ahorro
                //[10] = saldo cuenta simpe
                //[11] = estado cuenta corriente
                //[12] = estado cuenta ahorro
                //[13] = estado cuenta simpe
                //[14] = estado usuario
                //[15] = estado cuenta

                String[] datos = linea.split("\t");
                
                DatosRegistrados.getListaCedulas().add(datos[2]);
                DatosRegistrados.getListaClaves().add(Integer.parseInt(datos[5]));
                DatosRegistrados.getListaTelefonos().add(datos[3]);
               
                switch (Integer.parseInt(datos[6])) {
                    case 0 -> {
                       int n = 0;
                        for(String i : datos){
                            System.out.println("["+n+"] = "+i);
                            n+=1;
                        }
                        
                        Usuarios user = new Usuarios(datos[0], datos[1], datos[2], datos[3], datos[4], Integer.parseInt(datos[5]), Integer.parseInt(datos[6]), Integer.parseInt(datos[7]),
                                0, 0, 0);

                        user.getCuentaCorriente().setSaldo(Double.parseDouble(datos[8]));
                        user.getCuentaAhorro().setSaldo(Double.parseDouble(datos[9]));
                        user.getCuentaSimpe().setSaldo(Double.parseDouble(datos[10]));
                        
                        user.getCuentaCorriente().setEstado(Boolean.parseBoolean(datos[11]));
                        user.getCuentaAhorro().setEstado(Boolean.parseBoolean(datos[12]));
                        user.getCuentaSimpe().setEstado(Boolean.parseBoolean(datos[13]));

                        user.setEstadoUsuario(Boolean.parseBoolean(datos[14]));
                        user.setEstadoCuenta(Boolean.parseBoolean(datos[15]));

                        SedeCentral.getListaUsers().add(user);
                        agregarUserSede(Integer.parseInt(datos[7]), user);
                        
                        if(user.getEstadoCuenta() == false){
                            DatosRegistrados.getListaUsuariosEliminados().add(user);
                        }
                    }
                    case 1 -> {
                        Administradores admin = new Administradores(datos[0], datos[1], datos[2], datos[3], datos[4], Integer.parseInt(datos[5]), Integer.parseInt(datos[6]), Integer.parseInt(datos[7]));
                        SedeCentral.getListaAdmins().add(admin);
                        agregarAdminSede(Integer.parseInt(datos[7]), admin);
                    }
                }
            }
            leer.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    public void agregarUserSede(int sede, Usuarios user) {

        if (sede == 0) {
            SedePuriscal.getListaUsers().add(user);
        } else if (sede == 1) {
            SedeSanPedro.getListaUsers().add(user);
        } else {
            SedeCiudadColon.getListaUsers().add(user);
        }
    }

    public void agregarAdminSede(int sede, Administradores admin) {

        if (sede == 0) {
            SedePuriscal.getListaAdmins().add(admin);
        } else if (sede == 1) {
            SedeSanPedro.getListaAdmins().add(admin);
        } else {
            SedeCiudadColon.getListaAdmins().add(admin);
        }
    }

    public void limpiarSedes() {
        SedeCentral.getListaUsers().clear();
        SedeCentral.getListaAdmins().clear();

        SedePuriscal.getListaUsers().clear();
        SedePuriscal.getListaAdmins().clear();

        SedeSanPedro.getListaUsers().clear();
        SedeSanPedro.getListaAdmins().clear();

        SedeCiudadColon.getListaUsers().clear();
        SedeCiudadColon.getListaAdmins().clear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInicio = new javax.swing.JPanel();
        jblBarraArriba = new javax.swing.JLabel();
        jblLogo1 = new javax.swing.JLabel();
        jblFrase1 = new javax.swing.JLabel();
        jblNombreBanco1 = new javax.swing.JLabel();
        lblFondoInicio = new javax.swing.JLabel();
        jblNombreYLogo = new javax.swing.JLabel();
        panelInicioSesion = new javax.swing.JPanel();
        jblLogin = new javax.swing.JLabel();
        panelRegistroUsuario = new javax.swing.JPanel();
        jblRegistro = new javax.swing.JLabel();
        jblMensaje = new javax.swing.JLabel();
        jblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelInicio.setBackground(new java.awt.Color(255, 255, 255));
        panelInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblBarraArriba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BarraInicio.png"))); // NOI18N
        panelInicio.add(jblBarraArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 50));

        jblLogo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bambuLogo128px.png"))); // NOI18N
        panelInicio.add(jblLogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 390, 130));

        jblFrase1.setBackground(new java.awt.Color(0, 0, 0));
        jblFrase1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblFrase1.setForeground(new java.awt.Color(51, 51, 51));
        jblFrase1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblFrase1.setText("Deje que su dinero brote con nosotros");
        panelInicio.add(jblFrase1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 510, 390, -1));

        jblNombreBanco1.setFont(new java.awt.Font("STSong", 1, 36)); // NOI18N
        jblNombreBanco1.setForeground(new java.awt.Color(51, 51, 51));
        jblNombreBanco1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblNombreBanco1.setText("BNBUU");
        panelInicio.add(jblNombreBanco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 420, 390, -1));

        lblFondoInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFondoInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoInicioBN.png"))); // NOI18N
        panelInicio.add(lblFondoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, -10, 390, 720));

        jblNombreYLogo.setFont(new java.awt.Font("STSong", 1, 24)); // NOI18N
        jblNombreYLogo.setForeground(new java.awt.Color(51, 51, 51));
        jblNombreYLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bambuLogo64px.png"))); // NOI18N
        jblNombreYLogo.setText("BNBUU");
        panelInicio.add(jblNombreYLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 205, -1));

        panelInicioSesion.setBackground(new java.awt.Color(95, 87, 74));
        panelInicioSesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblLogin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jblLogin.setForeground(new java.awt.Color(250, 246, 235));
        jblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblLogin.setText("INICIAR SESION");
        jblLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblLoginMouseExited(evt);
            }
        });
        panelInicioSesion.add(jblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 70));

        panelInicio.add(panelInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 390, 70));

        panelRegistroUsuario.setBackground(new java.awt.Color(95, 87, 74));
        panelRegistroUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblRegistro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jblRegistro.setForeground(new java.awt.Color(250, 246, 235));
        jblRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblRegistro.setText("REGISTRARSE");
        jblRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblRegistroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblRegistroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblRegistroMouseExited(evt);
            }
        });
        panelRegistroUsuario.add(jblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 70));

        panelInicio.add(panelRegistroUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 390, 70));

        jblMensaje.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jblMensaje.setForeground(new java.awt.Color(51, 51, 51));
        jblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblMensaje.setText("Si no estas registrado te invitamos a registrarte!");
        panelInicio.add(jblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 670, -1));

        jblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jblTitulo.setForeground(new java.awt.Color(51, 51, 51));
        jblTitulo.setText("INICIO");
        panelInicio.add(jblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 685, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblLoginMouseClicked
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jblLoginMouseClicked

    private void jblLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblLoginMouseEntered
        panelInicioSesion.setBackground(new Color(153, 145, 86));
        jblLogin.setForeground(Color.black);
    }//GEN-LAST:event_jblLoginMouseEntered

    private void jblLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblLoginMouseExited
        panelInicioSesion.setBackground(new Color(92, 88, 29));
        jblLogin.setForeground(Color.white);
    }//GEN-LAST:event_jblLoginMouseExited

    private void jblRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblRegistroMouseClicked
        Registro registro = new Registro();
        registro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jblRegistroMouseClicked

    private void jblRegistroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblRegistroMouseEntered
        panelRegistroUsuario.setBackground(new Color(153, 145, 86));
        jblRegistro.setForeground(Color.black);
    }//GEN-LAST:event_jblRegistroMouseEntered

    private void jblRegistroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblRegistroMouseExited
        panelRegistroUsuario.setBackground(new Color(92, 88, 29));
        jblRegistro.setForeground(Color.white);
    }//GEN-LAST:event_jblRegistroMouseExited

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jblBarraArriba;
    private javax.swing.JLabel jblFrase1;
    private javax.swing.JLabel jblLogin;
    private javax.swing.JLabel jblLogo1;
    private javax.swing.JLabel jblMensaje;
    private javax.swing.JLabel jblNombreBanco1;
    private javax.swing.JLabel jblNombreYLogo;
    private javax.swing.JLabel jblRegistro;
    private javax.swing.JLabel jblTitulo;
    private javax.swing.JLabel lblFondoInicio;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelInicioSesion;
    private javax.swing.JPanel panelRegistroUsuario;
    // End of variables declaration//GEN-END:variables
}
