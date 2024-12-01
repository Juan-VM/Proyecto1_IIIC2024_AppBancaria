package guiAdministradores;

import Personas.Usuarios;
import Sedes.SedeCiudadColon;
import Sedes.SedePuriscal;
import Sedes.SedeSanPedro;
import guiUsuarios.Inicio;
import java.awt.Color;
import java.util.ArrayList;

public class VerInfoUsuario extends javax.swing.JFrame {

    String cedula;
    int sede;
    String cedulaUser;

    public VerInfoUsuario() {
        initComponents();
    }

    public VerInfoUsuario(String cedula, int sede, String cedulaUser) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cedula = cedula;
        this.sede = sede;
        this.cedulaUser = cedulaUser;
        
        llenarTxtDatos();
    }

    public void llenarTxtDatos() {
        ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
        switch (this.sede) {
            case 0 -> {
                listaUsuarios = SedePuriscal.getListaUsers();
            }
            case 1 -> {
                listaUsuarios = SedeSanPedro.getListaUsers();
            }
            case 2 -> {
                listaUsuarios = SedeCiudadColon.getListaUsers();
            }

        }
        for (Usuarios i : listaUsuarios) {
            if (i.getCedula().equals(this.cedulaUser)) {
                txtNombre.setText(i.getUsuario());
                txtApellido.setText(i.getApellidos());
                txtCedula.setText(i.getCedula());
                txtTelefono.setText(i.getTelefono());
                String sedeS;

                if (i.getSede() == 0) {
                    sedeS = "Puriscal";
                } else if (i.getSede() == 1) {
                    sedeS = "San Pedro";
                } else {
                    sedeS = "Ciudad Colon";
                }
                txtSede.setText(sedeS);
                txtRol.setText("Usuario");

                if (i.getCuentaCorriente().getEstado() == true) {
                    txtEstadoCorriente.setText("Habilitada");
                } else {
                    txtEstadoCorriente.setText("Desabilitada");
                }

                if (i.getCuentaAhorro().getEstado() == true) {
                    txtEstadoAhorro.setText("Habilitada");
                } else {
                    txtEstadoAhorro.setText("Desabilitada");
                }

                if (i.getCuentaSimpe().getEstado() == true) {
                    txtEstadoSimpe.setText("Habilitada");
                } else {
                    txtEstadoSimpe.setText("Desabilitada");
                }

                String saldoCuentaCorriente = String.format("%.3f", i.getCuentaCorriente().getSaldo());
                String saldoCuentaAhorro = String.format("%.3f", i.getCuentaAhorro().getSaldo());
                String saldoCuentaSimpe = String.format("%.3f", i.getCuentaSimpe().getSaldo());
                
                txtSaldoCorriente.setText(saldoCuentaCorriente);
                txtSaldoAhorro.setText(saldoCuentaAhorro);
                txtSaldoSimpe.setText(saldoCuentaSimpe);
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

        panelVisible = new javax.swing.JPanel();
        background = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtRol = new javax.swing.JTextField();
        txtEstadoSimpe = new javax.swing.JTextField();
        txtSede = new javax.swing.JTextField();
        txtSaldoSimpe = new javax.swing.JTextField();
        txtEstadoAhorro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEstadoCorriente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtSaldoCorriente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtSaldoAhorro = new javax.swing.JTextField();
        panelVerHistorial = new javax.swing.JPanel();
        jblVerHistorialSimpes = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
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
        menuInformacionSedes = new javax.swing.JMenu();
        itemSedePuriscal = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemSedeSanPedro = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        itemSedeCiudadColon = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelVisible.setBackground(new java.awt.Color(255, 255, 255));

        background.setBackground(new java.awt.Color(252, 247, 215));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Nombre: ");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Apellido:");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Cedula:");
        background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Telefono:");
        background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Rol:");
        background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Sede");
        background.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Cuenta Corriente:");
        background.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Historial simpes:");
        background.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 590, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Cuenta Simpe:");
        background.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 470, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Cuenta Ahorro:");
        background.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 470, -1, -1));

        txtNombre.setEditable(false);
        txtNombre.setBackground(new java.awt.Color(252, 247, 215));
        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(51, 51, 51));
        txtNombre.setBorder(null);
        background.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 16, 520, 40));

        txtApellido.setEditable(false);
        txtApellido.setBackground(new java.awt.Color(252, 247, 215));
        txtApellido.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(51, 51, 51));
        txtApellido.setBorder(null);
        background.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 86, 520, 40));

        txtCedula.setEditable(false);
        txtCedula.setBackground(new java.awt.Color(252, 247, 215));
        txtCedula.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCedula.setForeground(new java.awt.Color(51, 51, 51));
        txtCedula.setBorder(null);
        background.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 520, 40));

        txtTelefono.setEditable(false);
        txtTelefono.setBackground(new java.awt.Color(252, 247, 215));
        txtTelefono.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(51, 51, 51));
        txtTelefono.setBorder(null);
        background.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 520, 40));

        txtRol.setEditable(false);
        txtRol.setBackground(new java.awt.Color(252, 247, 215));
        txtRol.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtRol.setForeground(new java.awt.Color(51, 51, 51));
        txtRol.setBorder(null);
        background.add(txtRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 520, 40));

        txtEstadoSimpe.setEditable(false);
        txtEstadoSimpe.setBackground(new java.awt.Color(252, 247, 215));
        txtEstadoSimpe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtEstadoSimpe.setForeground(new java.awt.Color(51, 51, 51));
        txtEstadoSimpe.setBorder(null);
        background.add(txtEstadoSimpe, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 460, 140, 40));

        txtSede.setEditable(false);
        txtSede.setBackground(new java.awt.Color(252, 247, 215));
        txtSede.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtSede.setForeground(new java.awt.Color(51, 51, 51));
        txtSede.setBorder(null);
        background.add(txtSede, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 520, 40));

        txtSaldoSimpe.setEditable(false);
        txtSaldoSimpe.setBackground(new java.awt.Color(252, 247, 215));
        txtSaldoSimpe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtSaldoSimpe.setForeground(new java.awt.Color(51, 51, 51));
        txtSaldoSimpe.setBorder(null);
        background.add(txtSaldoSimpe, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 510, 220, 40));

        txtEstadoAhorro.setEditable(false);
        txtEstadoAhorro.setBackground(new java.awt.Color(252, 247, 215));
        txtEstadoAhorro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtEstadoAhorro.setForeground(new java.awt.Color(51, 51, 51));
        txtEstadoAhorro.setBorder(null);
        background.add(txtEstadoAhorro, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, 160, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Saldo:");
        background.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, -1, -1));

        txtEstadoCorriente.setEditable(false);
        txtEstadoCorriente.setBackground(new java.awt.Color(252, 247, 215));
        txtEstadoCorriente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtEstadoCorriente.setForeground(new java.awt.Color(51, 51, 51));
        txtEstadoCorriente.setBorder(null);
        background.add(txtEstadoCorriente, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 160, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Saldo:");
        background.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 520, -1, -1));

        txtSaldoCorriente.setEditable(false);
        txtSaldoCorriente.setBackground(new java.awt.Color(252, 247, 215));
        txtSaldoCorriente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtSaldoCorriente.setForeground(new java.awt.Color(51, 51, 51));
        txtSaldoCorriente.setBorder(null);
        background.add(txtSaldoCorriente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 260, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Saldo:");
        background.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 520, -1, -1));

        txtSaldoAhorro.setEditable(false);
        txtSaldoAhorro.setBackground(new java.awt.Color(252, 247, 215));
        txtSaldoAhorro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtSaldoAhorro.setForeground(new java.awt.Color(51, 51, 51));
        txtSaldoAhorro.setBorder(null);
        background.add(txtSaldoAhorro, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, 250, 40));

        panelVerHistorial.setBackground(new java.awt.Color(92, 88, 29));
        panelVerHistorial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblVerHistorialSimpes.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jblVerHistorialSimpes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblVerHistorialSimpes.setText("VER HISTORIAL SIMPES");
        jblVerHistorialSimpes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblVerHistorialSimpes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblVerHistorialSimpesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblVerHistorialSimpesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblVerHistorialSimpesMouseExited(evt);
            }
        });
        panelVerHistorial.add(jblVerHistorialSimpes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 50));

        background.add(panelVerHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 580, 300, 50));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Info del Usuario");
        background.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, -1));

        javax.swing.GroupLayout panelVisibleLayout = new javax.swing.GroupLayout(panelVisible);
        panelVisible.setLayout(panelVisibleLayout);
        panelVisibleLayout.setHorizontalGroup(
            panelVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 1082, Short.MAX_VALUE)
        );
        panelVisibleLayout.setVerticalGroup(
            panelVisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
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

    private void jblVerHistorialSimpesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerHistorialSimpesMouseEntered
        panelVerHistorial.setBackground(new Color(153, 145, 86));
        jblVerHistorialSimpes.setForeground(Color.black);
    }//GEN-LAST:event_jblVerHistorialSimpesMouseEntered

    private void jblVerHistorialSimpesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerHistorialSimpesMouseExited
        panelVerHistorial.setBackground(new Color(92, 88, 29));
        jblVerHistorialSimpes.setForeground(Color.white);
    }//GEN-LAST:event_jblVerHistorialSimpesMouseExited

    private void jblVerHistorialSimpesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerHistorialSimpesMouseClicked
        HistorialSimpeUsuario historial = new HistorialSimpeUsuario(this.cedula, this.sede, this.cedulaUser);
        historial.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jblVerHistorialSimpesMouseClicked

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
            java.util.logging.Logger.getLogger(VerInfoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerInfoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerInfoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerInfoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerInfoUsuario().setVisible(true);
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
    private javax.swing.JMenuItem itemSedeCiudadColon;
    private javax.swing.JMenuItem itemSedePuriscal;
    javax.swing.JMenuItem itemSedeSanPedro;
    private javax.swing.JMenuItem itemSolicitudesDesbloqueo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JLabel jblVerHistorialSimpes;
    private javax.swing.JMenu menuBloqueoDesbloqueo;
    private javax.swing.JMenu menuGestionUsuarios;
    private javax.swing.JMenu menuInformacionSedes;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JPanel panelVerHistorial;
    private javax.swing.JPanel panelVisible;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtEstadoAhorro;
    private javax.swing.JTextField txtEstadoCorriente;
    private javax.swing.JTextField txtEstadoSimpe;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRol;
    private javax.swing.JTextField txtSaldoAhorro;
    private javax.swing.JTextField txtSaldoCorriente;
    private javax.swing.JTextField txtSaldoSimpe;
    private javax.swing.JTextField txtSede;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
