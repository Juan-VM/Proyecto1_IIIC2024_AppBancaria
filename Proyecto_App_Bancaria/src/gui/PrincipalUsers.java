package gui;

import Personas.Usuarios;
import Sedes.SedeCiudadColon;
import Sedes.SedePuriscal;
import Sedes.SedeSanPedro;
import java.awt.Color;

public class PrincipalUsers extends javax.swing.JFrame {

    int indice;
    int sede;
    String cedula;

    public PrincipalUsers(String cedula, int sede) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cedula = cedula;
        this.sede = sede;
        asignarIndicePersonaEnSede(this.cedula);

        switch (this.sede) {
            case 0 -> {
                jblNombrePerfil.setText(SedePuriscal.getListaUsers().get(indice).getUsuario() + " " + SedePuriscal.getListaUsers().get(indice).getApellidos());
                jblVentanaActual.setText("Sede Puriscal");
            }
            case 1 -> {
                jblNombrePerfil.setText(SedeSanPedro.getListaUsers().get(indice).getUsuario() + " " + SedeSanPedro.getListaUsers().get(indice).getApellidos());
                jblVentanaActual.setText("Sede San Pedro");
            }
            case 2 -> {
                jblNombrePerfil.setText(SedePuriscal.getListaUsers().get(indice).getUsuario() + " " + SedePuriscal.getListaUsers().get(indice).getApellidos());
                jblVentanaActual.setText("Sede Ciudad Colon");
            }
        }
    }

    public PrincipalUsers() {

    }

    public void asignarIndicePersonaEnSede(String cedula) {
        switch (sede) {
            case 0 -> {

                for (Usuarios u : SedePuriscal.getListaUsers()) {
                    if (u.getCedula().equals(cedula)) {
                        this.indice = SedePuriscal.getListaUsers().indexOf(u);
                    }
                }
            }
            case 1 -> {

                for (Usuarios u : SedeSanPedro.getListaUsers()) {
                    if (u.getCedula().equals(cedula)) {
                        this.indice = SedeSanPedro.getListaUsers().indexOf(u);
                    }
                }
            }
            case 2 -> {

                for (Usuarios u : SedeCiudadColon.getListaUsers()) {
                    if (u.getCedula().equals(cedula)) {
                        this.indice = SedeCiudadColon.getListaUsers().indexOf(u);
                    }
                }
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

        background = new javax.swing.JPanel();
        jblNombreBanco = new javax.swing.JLabel();
        jblPerfil = new javax.swing.JLabel();
        iconBarra = new javax.swing.JLabel();
        jblNombrePerfil = new javax.swing.JLabel();
        jblVentanaActual = new javax.swing.JLabel();
        panelAtras = new javax.swing.JPanel();
        jblAtras = new javax.swing.JLabel();
        jblBarra = new javax.swing.JLabel();
        panelSalir = new javax.swing.JPanel();
        jblSalir = new javax.swing.JLabel();
        panelConfig = new javax.swing.JPanel();
        jblConfig = new javax.swing.JLabel();
        panelOpciones = new javax.swing.JPanel();
        jblFondoPerfil = new javax.swing.JLabel();
        panelDepositarBarra = new javax.swing.JPanel();
        jblDepositar = new javax.swing.JLabel();
        panelRetirarBarra = new javax.swing.JPanel();
        jblRetirar = new javax.swing.JLabel();
        panelVerSaldoBarra = new javax.swing.JPanel();
        javax.swing.JLabel jblVerSaldo = new javax.swing.JLabel();
        panelDashboardBarra = new javax.swing.JPanel();
        jblDashboard = new javax.swing.JLabel();
        panelHabilitarCuentasBarra = new javax.swing.JPanel();
        jblHabilitarCuentas = new javax.swing.JLabel();
        panelComentariosBarra = new javax.swing.JPanel();
        jblComentarios = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblNombreBanco.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jblNombreBanco.setForeground(new java.awt.Color(51, 51, 51));
        jblNombreBanco.setText("BNBUU");
        background.add(jblNombreBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 120, 70));

        jblPerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perfilNegro128px.png"))); // NOI18N
        background.add(jblPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 130, 130));

        iconBarra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconBarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bambuLogo32px.png"))); // NOI18N
        background.add(iconBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, 70));

        jblNombrePerfil.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jblNombrePerfil.setForeground(new java.awt.Color(51, 51, 51));
        jblNombrePerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblNombrePerfil.setText("Nombre");
        background.add(jblNombrePerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 300, -1));

        jblVentanaActual.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jblVentanaActual.setForeground(new java.awt.Color(51, 51, 51));
        jblVentanaActual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ubicacion32px.png"))); // NOI18N
        jblVentanaActual.setText("Ubicacion");
        background.add(jblVentanaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 320, 70));

        panelAtras.setBackground(new java.awt.Color(210, 196, 103));
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

        background.add(panelAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, 50, 50));

        jblBarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BarraColorBambu.png"))); // NOI18N
        background.add(jblBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 790, 70));

        panelSalir.setBackground(new java.awt.Color(247, 240, 194));
        panelSalir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salida32px.png"))); // NOI18N
        jblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblSalirMouseExited(evt);
            }
        });
        panelSalir.add(jblSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        background.add(panelSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        panelConfig.setBackground(new java.awt.Color(247, 240, 194));
        panelConfig.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblConfig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/config32px.png"))); // NOI18N
        jblConfig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblConfigMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblConfigMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblConfigMouseExited(evt);
            }
        });
        panelConfig.add(jblConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        background.add(panelConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 50, 50));

        panelOpciones.setBackground(new java.awt.Color(252, 247, 215));
        panelOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblFondoPerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblFondoPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CuadroFondoPerfil2.png"))); // NOI18N
        panelOpciones.add(jblFondoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 200));

        panelDepositarBarra.setBackground(new java.awt.Color(252, 247, 215));
        panelDepositarBarra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblDepositar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblDepositar.setForeground(new java.awt.Color(102, 102, 102));
        jblDepositar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblDepositar.setText("Depositar");
        jblDepositar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblDepositar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblDepositarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblDepositarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblDepositarMouseExited(evt);
            }
        });
        panelDepositarBarra.add(jblDepositar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 60));

        panelOpciones.add(panelDepositarBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 300, 60));

        panelRetirarBarra.setBackground(new java.awt.Color(252, 247, 215));
        panelRetirarBarra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblRetirar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblRetirar.setForeground(new java.awt.Color(102, 102, 102));
        jblRetirar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblRetirar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/depositar32px.png"))); // NOI18N
        jblRetirar.setText("  Retirar          ");
        jblRetirar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblRetirar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblRetirarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblRetirarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblRetirarMouseExited(evt);
            }
        });
        panelRetirarBarra.add(jblRetirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 60));

        panelOpciones.add(panelRetirarBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 300, 60));

        panelVerSaldoBarra.setBackground(new java.awt.Color(252, 247, 215));
        panelVerSaldoBarra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblVerSaldo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblVerSaldo.setForeground(new java.awt.Color(102, 102, 102));
        jblVerSaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblVerSaldo.setText("Ver saldo");
        jblVerSaldo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblVerSaldo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblVerSaldoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblVerSaldoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblVerSaldoMouseExited(evt);
            }
        });
        panelVerSaldoBarra.add(jblVerSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 60));

        panelOpciones.add(panelVerSaldoBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 300, 60));

        panelDashboardBarra.setBackground(new java.awt.Color(252, 247, 215));
        panelDashboardBarra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblDashboard.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblDashboard.setForeground(new java.awt.Color(102, 102, 102));
        jblDashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblDashboard.setText("Dashboard");
        jblDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblDashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblDashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblDashboardMouseExited(evt);
            }
        });
        panelDashboardBarra.add(jblDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 60));

        panelOpciones.add(panelDashboardBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 300, 60));

        panelHabilitarCuentasBarra.setBackground(new java.awt.Color(252, 247, 215));
        panelHabilitarCuentasBarra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblHabilitarCuentas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblHabilitarCuentas.setForeground(new java.awt.Color(102, 102, 102));
        jblHabilitarCuentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblHabilitarCuentas.setText("Habilitar Cuentas");
        jblHabilitarCuentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblHabilitarCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblHabilitarCuentasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblHabilitarCuentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblHabilitarCuentasMouseExited(evt);
            }
        });
        panelHabilitarCuentasBarra.add(jblHabilitarCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 60));

        panelOpciones.add(panelHabilitarCuentasBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 300, 60));

        panelComentariosBarra.setBackground(new java.awt.Color(252, 247, 215));
        panelComentariosBarra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblComentarios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblComentarios.setForeground(new java.awt.Color(102, 102, 102));
        jblComentarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblComentarios.setText("Comentarios");
        jblComentarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblComentarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblComentariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblComentariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblComentariosMouseExited(evt);
            }
        });
        panelComentariosBarra.add(jblComentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 60));

        panelOpciones.add(panelComentariosBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 300, 60));

        background.add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jblConfigMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblConfigMouseEntered
        panelConfig.setBackground(new Color(255, 255, 218));
        //255,248,200
    }//GEN-LAST:event_jblConfigMouseEntered

    private void jblConfigMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblConfigMouseExited
        panelConfig.setBackground(new Color(247, 240, 194));
    }//GEN-LAST:event_jblConfigMouseExited

    private void jblSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblSalirMouseEntered
        panelSalir.setBackground(new Color(255, 255, 218));
    }//GEN-LAST:event_jblSalirMouseEntered

    private void jblSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblSalirMouseExited
        panelSalir.setBackground(new Color(247, 240, 194));
    }//GEN-LAST:event_jblSalirMouseExited

    private void jblAtrasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblAtrasMouseEntered
        panelAtras.setBackground(new Color(245, 228, 120));
    }//GEN-LAST:event_jblAtrasMouseEntered

    private void jblAtrasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblAtrasMouseExited
        panelAtras.setBackground(new Color(210, 196, 103));
    }//GEN-LAST:event_jblAtrasMouseExited

    private void jblRetirarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblRetirarMouseEntered
        panelRetirarBarra.setBackground(new Color(232, 225, 182));
    }//GEN-LAST:event_jblRetirarMouseEntered

    private void jblRetirarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblRetirarMouseExited
        panelRetirarBarra.setBackground(new Color(252, 247, 215));
    }//GEN-LAST:event_jblRetirarMouseExited

    private void jblDepositarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblDepositarMouseEntered
        panelDepositarBarra.setBackground(new Color(232, 225, 182));
    }//GEN-LAST:event_jblDepositarMouseEntered

    private void jblDepositarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblDepositarMouseExited
        panelDepositarBarra.setBackground(new Color(252, 247, 215));
    }//GEN-LAST:event_jblDepositarMouseExited

    private void jblDepositarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblDepositarMouseClicked
        
    }//GEN-LAST:event_jblDepositarMouseClicked

    private void jblRetirarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblRetirarMouseClicked
        
    }//GEN-LAST:event_jblRetirarMouseClicked

    private void jblVerSaldoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerSaldoMouseEntered
        panelVerSaldoBarra.setBackground(new Color(232, 225, 182));
    }//GEN-LAST:event_jblVerSaldoMouseEntered

    private void jblVerSaldoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerSaldoMouseExited
        panelVerSaldoBarra.setBackground(new Color(252, 247, 215));
    }//GEN-LAST:event_jblVerSaldoMouseExited

    private void jblVerSaldoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerSaldoMouseClicked
        
    }//GEN-LAST:event_jblVerSaldoMouseClicked

    private void jblDashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblDashboardMouseEntered
        panelDashboardBarra.setBackground(new Color(232, 225, 182));
    }//GEN-LAST:event_jblDashboardMouseEntered

    private void jblDashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblDashboardMouseExited
        panelDashboardBarra.setBackground(new Color(252, 247, 215));
    }//GEN-LAST:event_jblDashboardMouseExited

    private void jblDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblDashboardMouseClicked
        
    }//GEN-LAST:event_jblDashboardMouseClicked

    private void jblHabilitarCuentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblHabilitarCuentasMouseEntered
        panelHabilitarCuentasBarra.setBackground(new Color(232, 225, 182));
    }//GEN-LAST:event_jblHabilitarCuentasMouseEntered

    private void jblHabilitarCuentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblHabilitarCuentasMouseExited
        panelHabilitarCuentasBarra.setBackground(new Color(252, 247, 215));
    }//GEN-LAST:event_jblHabilitarCuentasMouseExited

    private void jblHabilitarCuentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblHabilitarCuentasMouseClicked
        
    }//GEN-LAST:event_jblHabilitarCuentasMouseClicked

    private void jblComentariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblComentariosMouseEntered
        panelComentariosBarra.setBackground(new Color(232, 225, 182));
    }//GEN-LAST:event_jblComentariosMouseEntered

    private void jblComentariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblComentariosMouseExited
        panelComentariosBarra.setBackground(new Color(252, 247, 215));
    }//GEN-LAST:event_jblComentariosMouseExited

    private void jblComentariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblComentariosMouseClicked
        
    }//GEN-LAST:event_jblComentariosMouseClicked

    private void jblConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblConfigMouseClicked
        ConfigurarPerfil config = new ConfigurarPerfil(this.cedula, this.sede);
        config.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jblConfigMouseClicked

    private void jblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblSalirMouseClicked
        Inicio ini = new Inicio();
        ini.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jblSalirMouseClicked

    private void jblAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblAtrasMouseClicked
        Inicio ini = new Inicio();
        ini.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jblAtrasMouseClicked

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
            java.util.logging.Logger.getLogger(PrincipalUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel iconBarra;
    private javax.swing.JLabel jblAtras;
    private javax.swing.JLabel jblBarra;
    private javax.swing.JLabel jblComentarios;
    private javax.swing.JLabel jblConfig;
    private javax.swing.JLabel jblDashboard;
    private javax.swing.JLabel jblDepositar;
    private javax.swing.JLabel jblFondoPerfil;
    private javax.swing.JLabel jblHabilitarCuentas;
    private javax.swing.JLabel jblNombreBanco;
    private javax.swing.JLabel jblNombrePerfil;
    private javax.swing.JLabel jblPerfil;
    private javax.swing.JLabel jblRetirar;
    private javax.swing.JLabel jblSalir;
    private javax.swing.JLabel jblVentanaActual;
    private javax.swing.JPanel panelAtras;
    private javax.swing.JPanel panelComentariosBarra;
    private javax.swing.JPanel panelConfig;
    private javax.swing.JPanel panelDashboardBarra;
    private javax.swing.JPanel panelDepositarBarra;
    private javax.swing.JPanel panelHabilitarCuentasBarra;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelRetirarBarra;
    private javax.swing.JPanel panelSalir;
    private javax.swing.JPanel panelVerSaldoBarra;
    // End of variables declaration//GEN-END:variables
}