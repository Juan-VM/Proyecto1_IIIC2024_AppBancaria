package guiAdministradores;

import Personas.Usuarios;
import Sedes.SedeCiudadColon;
import Sedes.SedePuriscal;
import Sedes.SedeSanPedro;
import guiUsuarios.Inicio;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestionSedes extends javax.swing.JFrame {

    int sedeElegida;
    String cedula;

    DefaultTableModel modeloUsersTotales = new DefaultTableModel();
    DefaultTableModel modeloCuentasActivas = new DefaultTableModel();
    DefaultTableModel modeloCuentasBloqueadas = new DefaultTableModel();

    public GestionSedes() {
        initComponents();
    }

    public GestionSedes(int sedeElegida, String cedula) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.sedeElegida = sedeElegida;
        this.cedula = cedula;

        modeloUsersTotales.addColumn("Usuario");
        modeloUsersTotales.addColumn("Cedula");
        modeloUsersTotales.addColumn("Rol");

        modeloCuentasActivas.addColumn("Usuario");
        modeloCuentasActivas.addColumn("Cedula");
        modeloCuentasActivas.addColumn("Rol");

        modeloCuentasBloqueadas.addColumn("Usuario");
        modeloCuentasBloqueadas.addColumn("Cedula");
        modeloCuentasBloqueadas.addColumn("Rol");

        tablaTodosUsuarios.setModel(modeloUsersTotales);
        tablaCuentasActivas.setModel(modeloCuentasActivas);
        tablaCuentasBloqueadas.setModel(modeloCuentasBloqueadas);

        llenarTablas();

        if (sedeElegida == 0) {
            jblUbicacion.setText("Puriscal");
        } else if (sedeElegida == 1) {
            jblUbicacion.setText("San Pedro");
        } else {
            jblUbicacion.setText("Ciudad Colon");
        }
    }

    public void llenarTablas() {
        switch (sedeElegida) {
            case 0 -> {
                for (Usuarios i : SedePuriscal.getListaUsers()) {
                    String rol = "";
                    switch (i.getRol()) {
                        case 0 -> {
                            rol = "Usuario";
                        }
                        case 1 -> {
                            rol = "Administrador";
                        }

                    }
                    modeloUsersTotales.addRow(new Object[]{i.getUsuario(), i.getCedula(), rol});
                    if (i.getEstadoUsuario() == true) {
                        modeloCuentasActivas.addRow(new Object[]{i.getUsuario(), i.getCedula(), rol});
                    } else {
                        modeloCuentasBloqueadas.addRow(new Object[]{i.getUsuario(), rol});
                    }
                }
            }
            case 1 -> {
                for (Usuarios i : SedeSanPedro.getListaUsers()) {
                    String rol = "";
                    switch (i.getRol()) {
                        case 0 -> {
                            rol = "Usuario";
                        }
                        case 1 -> {
                            rol = "Administrador";
                        }

                    }
                    modeloUsersTotales.addRow(new Object[]{i.getUsuario(), i.getCedula(), rol});
                    if (i.getEstadoUsuario() == true) {
                        modeloCuentasActivas.addRow(new Object[]{i.getUsuario(), i.getCedula(), rol});
                    } else {
                        modeloCuentasBloqueadas.addRow(new Object[]{i.getUsuario(), i.getCedula(), rol});
                    }
                }
            }
            case 2 -> {
                for (Usuarios i : SedeCiudadColon.getListaUsers()) {
                    String rol = "";
                    switch (i.getRol()) {
                        case 0 -> {
                            rol = "Usuario";
                        }
                        case 1 -> {
                            rol = "Administrador";
                        }

                    }
                    modeloUsersTotales.addRow(new Object[]{i.getUsuario(), i.getCedula(), rol});
                    if (i.getEstadoUsuario() == true) {
                        modeloCuentasActivas.addRow(new Object[]{i.getUsuario(), i.getCedula(), rol});
                    } else {
                        modeloCuentasBloqueadas.addRow(new Object[]{i.getUsuario(), i.getCedula(), rol});
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

        panelVisible = new javax.swing.JPanel();
        background = new javax.swing.JPanel();
        jblUbicacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCuentasActivas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCuentasBloqueadas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaTodosUsuarios = new javax.swing.JTable();
        panelVerInfoUsuario = new javax.swing.JPanel();
        jblVerInfoDelUsuario = new javax.swing.JLabel();
        jblUsuariosTotales = new javax.swing.JLabel();
        jblCuentasActivas = new javax.swing.JLabel();
        jblCuentasBloquedas = new javax.swing.JLabel();
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

        panelVisible.setBackground(new java.awt.Color(255, 255, 255));

        background.setBackground(new java.awt.Color(252, 247, 215));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblUbicacion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jblUbicacion.setForeground(new java.awt.Color(51, 51, 51));
        jblUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ubicacion32px.png"))); // NOI18N
        jblUbicacion.setText("Sede");
        background.add(jblUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, -1, -1));

        tablaCuentasActivas.setBackground(new java.awt.Color(204, 204, 204));
        tablaCuentasActivas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaCuentasActivas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaCuentasActivasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCuentasActivas);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 260, 450));

        tablaCuentasBloqueadas.setBackground(new java.awt.Color(204, 204, 204));
        tablaCuentasBloqueadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaCuentasBloqueadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaCuentasBloqueadasMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablaCuentasBloqueadas);

        background.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, 260, 450));

        tablaTodosUsuarios.setBackground(new java.awt.Color(204, 204, 204));
        tablaTodosUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaTodosUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaTodosUsuariosMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tablaTodosUsuarios);

        background.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 260, 450));

        panelVerInfoUsuario.setBackground(new java.awt.Color(92, 88, 29));
        panelVerInfoUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblVerInfoDelUsuario.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jblVerInfoDelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jblVerInfoDelUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblVerInfoDelUsuario.setText("VER INFO DEL USUARIO");
        jblVerInfoDelUsuario.setToolTipText("");
        jblVerInfoDelUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblVerInfoDelUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblVerInfoDelUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblVerInfoDelUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblVerInfoDelUsuarioMouseExited(evt);
            }
        });
        panelVerInfoUsuario.add(jblVerInfoDelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 70));

        background.add(panelVerInfoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 590, 370, 70));

        jblUsuariosTotales.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jblUsuariosTotales.setForeground(new java.awt.Color(51, 51, 51));
        jblUsuariosTotales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblUsuariosTotales.setText("Usuarios totales");
        background.add(jblUsuariosTotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 260, -1));

        jblCuentasActivas.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jblCuentasActivas.setForeground(new java.awt.Color(51, 51, 51));
        jblCuentasActivas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblCuentasActivas.setText("Cuentas activas");
        background.add(jblCuentasActivas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 260, -1));

        jblCuentasBloquedas.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jblCuentasBloquedas.setForeground(new java.awt.Color(51, 51, 51));
        jblCuentasBloquedas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblCuentasBloquedas.setText("Cuentas bloqueadas");
        background.add(jblCuentasBloquedas, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 260, -1));

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

    private void tablaTodosUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTodosUsuariosMousePressed
        if (tablaCuentasActivas.getSelectedRow() >= 0) {
            tablaCuentasActivas.clearSelection();
        }
        if (tablaCuentasBloqueadas.getSelectedRow() >= 0) {
            tablaCuentasBloqueadas.clearSelection();
        }
    }//GEN-LAST:event_tablaTodosUsuariosMousePressed

    private void tablaCuentasActivasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCuentasActivasMousePressed
        if (tablaTodosUsuarios.getSelectedRow() >= 0) {
            tablaTodosUsuarios.clearSelection();
        }
        if (tablaCuentasBloqueadas.getSelectedRow() >= 0) {
            tablaCuentasBloqueadas.clearSelection();
        }
    }//GEN-LAST:event_tablaCuentasActivasMousePressed

    private void tablaCuentasBloqueadasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCuentasBloqueadasMousePressed
        if (tablaTodosUsuarios.getSelectedRow() >= 0) {
            tablaTodosUsuarios.clearSelection();
        }
        if (tablaCuentasActivas.getSelectedRow() >= 0) {
            tablaCuentasActivas.clearSelection();
        }
    }//GEN-LAST:event_tablaCuentasBloqueadasMousePressed

    private void jblVerInfoDelUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerInfoDelUsuarioMouseEntered
        panelVerInfoUsuario.setBackground(new Color(153, 145, 86));
        jblVerInfoDelUsuario.setForeground(Color.black);
    }//GEN-LAST:event_jblVerInfoDelUsuarioMouseEntered

    private void jblVerInfoDelUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerInfoDelUsuarioMouseExited
        panelVerInfoUsuario.setBackground(new Color(92, 88, 29));
        jblVerInfoDelUsuario.setForeground(Color.white);
    }//GEN-LAST:event_jblVerInfoDelUsuarioMouseExited

    private void jblVerInfoDelUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerInfoDelUsuarioMouseClicked

        String cedulaUser = "";
        int filaSeleccionada = 0;

        if(tablaTodosUsuarios.getSelectedRow() >= 0 || tablaCuentasActivas.getSelectedRow() >= 0 || tablaCuentasBloqueadas.getSelectedRow() >= 0) {
            
            
            if (tablaTodosUsuarios.getSelectedRow() >= 0) {
                filaSeleccionada = tablaTodosUsuarios.getSelectedRow();
                cedulaUser = tablaTodosUsuarios.getValueAt(filaSeleccionada, 1).toString();

            } else if (tablaCuentasActivas.getSelectedRow() >= 0) {
                filaSeleccionada = tablaCuentasActivas.getSelectedRow();
                cedulaUser = tablaCuentasActivas.getValueAt(filaSeleccionada, 1).toString();

            } else if(tablaCuentasBloqueadas.getSelectedRow() >= 0){
                filaSeleccionada = tablaCuentasBloqueadas.getSelectedRow();
                cedulaUser = tablaCuentasBloqueadas.getValueAt(filaSeleccionada, 1).toString();
            }
            
            VerInfoUsuario ver = new VerInfoUsuario(this.cedula, this.sedeElegida, cedulaUser);
            ver.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Error, elecciona un usuario");;
        }
    }//GEN-LAST:event_jblVerInfoDelUsuarioMouseClicked

    private void itemEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarUsuarioActionPerformed
        EliminarUsuario eliminar = new EliminarUsuario(this.cedula);
        eliminar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemEliminarUsuarioActionPerformed

    private void itemRestaurarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRestaurarUsuarioActionPerformed
        RestaurarUsuario restaurar =  new RestaurarUsuario(this.cedula);
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
            java.util.logging.Logger.getLogger(GestionSedes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionSedes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionSedes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionSedes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionSedes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JLabel jblCuentasActivas;
    private javax.swing.JLabel jblCuentasBloquedas;
    private javax.swing.JLabel jblUbicacion;
    private javax.swing.JLabel jblUsuariosTotales;
    private javax.swing.JLabel jblVerInfoDelUsuario;
    private javax.swing.JMenu menuBloqueoDesbloqueo;
    private javax.swing.JMenu menuComentarios;
    private javax.swing.JMenu menuGestionUsuarios;
    private javax.swing.JMenu menuInformacionSedes;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JPanel panelVerInfoUsuario;
    private javax.swing.JPanel panelVisible;
    private javax.swing.JTable tablaCuentasActivas;
    private javax.swing.JTable tablaCuentasBloqueadas;
    private javax.swing.JTable tablaTodosUsuarios;
    // End of variables declaration//GEN-END:variables
}
