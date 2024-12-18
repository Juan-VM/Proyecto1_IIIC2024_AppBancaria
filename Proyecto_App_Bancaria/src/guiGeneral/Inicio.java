package guiGeneral;

import guiGeneral.Registro;
import guiGeneral.Login;
import BaseDatos.BaseDatos;
import Comentarios.Comentario;
import Comprobantes.ComprobanteSimpeEntrada;
import Comprobantes.ComprobanteSimpeSalida;
import Personas.Administradores;
import Personas.Usuarios;
import RegistroDatos.DatosRegistrados;
import Sedes.SedeCentral;
import Sedes.SedeCiudadColon;
import Sedes.SedePuriscal;
import Sedes.SedeSanPedro;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Inicio extends javax.swing.JFrame {

    //Estos arrayList seran utilizados para almacenar los objetos reconstruidos de la base de datos.
    //Posteriormente se asignará el objeto a su respectiva lista.
    private static ArrayList<ComprobanteSimpeEntrada> listaComprobantesEntrada = new ArrayList<>();
    private static ArrayList<ComprobanteSimpeSalida> listaComprobantesSalida = new ArrayList<>();
    public static ArrayList<Comentario> listaComentarios = new ArrayList<>();

    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    //Recorre el archivo de la base de datos que guarda a los comprobantes de entrada.
    //Reconstruye cada comprobante y lo agrega a la lista temporal.
    public static void descargarComprobantesEntrada() {
        try {
            BaseDatos.verfificarExistenciaSimpesEntradaTxt();
            BufferedReader leerEn = new BufferedReader(new FileReader(BaseDatos.getSimpesEntradaTxt()));
            String lineaEn = null;
            while ((lineaEn = leerEn.readLine()) != null) {

                //Distribucion String[] datosEn:
                //[0] monto
                //[1] fecha
                //[2] hora
                //[3] numeroEmisor
                //[4] numeroReceptor
                //[5] Cuenta
                //[6] Detalle
                String[] datosEn = lineaEn.split("\t");

                // comEn(numeroEmisor, numeroReceptor, cuenta, monto, fecha, hora, detalle)
                ComprobanteSimpeEntrada comEn = new ComprobanteSimpeEntrada(datosEn[3], datosEn[4], datosEn[5], Double.parseDouble(datosEn[0]), datosEn[1], datosEn[2], datosEn[6]);

                listaComprobantesEntrada.add(comEn);
            }
            leerEn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error descargando ComEntrada de BaseDatos");
        }
    }

    
    //Recorre el archivo de la base de datos que guarda a los comprobantes de salida.
    //Reconstruye cada comprobante y lo agrega a la lista temporal.
    public static void descargarComprobantesSalida() {
        try {

            BaseDatos.verfificarExistenciaSimpesSalidaTxt();
            BufferedReader leerSa = new BufferedReader(new FileReader(BaseDatos.getSimpesSalidaTxt()));
            String lineaSa = null;

            while ((lineaSa = leerSa.readLine()) != null) {
                //Distribucion String[] datosSa:
                //[0] monto
                //[1] fecha
                //[2] hora
                //[3] numeroEmisor
                //[4] numeroReceptor
                //[5] Cuenta
                //[6] Detalle
                String[] datosSa = lineaSa.split("\t");

                // comSa(numeroEmisor, numeroReceptor, cuenta, monto, fecha, hora, detalle)
                ComprobanteSimpeSalida comSa = new ComprobanteSimpeSalida(datosSa[3], datosSa[4], datosSa[5], Double.parseDouble(datosSa[0]), datosSa[1], datosSa[2], datosSa[6]);

                listaComprobantesSalida.add(comSa);
            }
            leerSa.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error descargando ComSalida de BaseDatos");
        }
    }

    
    //Recorre el archivo de la base de datos que guarda a los comentarios.
    //Reconstruye cada comentario y lo agrega a la lista temporal.
    public static void descargarComentarios() {
        try {
            BaseDatos.verfificarExistenciaComentariosTxT();
            BufferedReader leer = new BufferedReader(new FileReader(BaseDatos.getComentariosTxt()));
            String linea;

            while ((linea = leer.readLine()) != null) {
                //Distribucion String[] datos:
                //[0] autor 
                //[1] cedula
                //[2] texto
                //[3] fecha
                //[4] hora
                String[] datos = linea.split("\t");
                
                //coment( autor, cedulaAutor, texto, fecha, hora)
                Comentario coment = new Comentario(datos[0], datos[1], datos[2], datos[3], datos[4]);
                
                listaComentarios.add(coment);
                DatosRegistrados.getListaComentarios().add(coment);
            }
            leer.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error descargando comentarios de BaseDatos");
        }
    }

    //Recorre el archivo de la base de datos que guarda a los usuarios.
    //Reconstruye cada usuario y le asigna sus respectivos atributos.
    //Una vez esta completamente reconstruido lo agrega a las respectivas sedes.
    //Agrega los datos unicos en uso a la lista de datos unicos en uso.
    public static void descargarUsuariosBaseDatos() {
        try {
            BaseDatos.verfificarExistenciaUsuariosTxT();

            BufferedReader leerUs = new BufferedReader(new FileReader(BaseDatos.getUsuariosTxt()));

            String lineaUser = null;

            while ((lineaUser = leerUs.readLine()) != null) {
                //Distribucion de la lista String[] datos:
                //[0] = Usuario
                //[1] = Apellido
                //[2] = Cedula
                //[3] = Telefono
                //[4] = Password
                //[5] = Clave Num
                //[6] = Rol
                //[7] = Sede
                //[8] = saldo cuenta corriente
                //[9] = saldo cuenta ahorro
                //[10] = saldo cuenta simpe
                //[11] = estado cuenta corriente
                //[12] = estado cuenta ahorro
                //[13] = estado cuenta simpe
                //[14] = estado usuario
                //[15] = estado cuenta
                String[] datos = lineaUser.split("\t");

                //User = (usuario, apellidos, password, cedula, telefono, claveNumerica, rol, sede, saldoCorriente, saldoSimpe, saldoAhorro)
                Usuarios user = new Usuarios(datos[0], datos[1], datos[4], datos[2], datos[3], Integer.parseInt(datos[5]), Integer.parseInt(datos[6]), Integer.parseInt(datos[7]),
                        Double.parseDouble(datos[8]), Double.parseDouble(datos[10]), Double.parseDouble(datos[9]));

                user.getCuentaCorriente().setEstado(Boolean.parseBoolean(datos[11]));
                user.getCuentaAhorro().setEstado(Boolean.parseBoolean(datos[12]));
                user.getCuentaSimpe().setEstado(Boolean.parseBoolean(datos[13]));

                user.setEstadoUsuario(Boolean.parseBoolean(datos[14]));
                user.setEstadoCuenta(Boolean.parseBoolean(datos[15]));

                //leer txtSimpeSalida para asignarle a user los comprobantes
                for (ComprobanteSimpeSalida i : listaComprobantesSalida) {
                    String numeroEmisor = i.getNumeroEmisor();
                    if (user.getTelefono().equals(numeroEmisor)) {
                        user.getComprobantesSimpeSalida().add(i);
                    }
                }

                for (ComprobanteSimpeEntrada i : listaComprobantesEntrada) {
                    String numeroReceptor = i.getNumeroReceptor();
                    if (user.getTelefono().equals(numeroReceptor)) {
                        user.getComprobantesSimpeEntrada().add(i);
                    }
                }
                
                for(Comentario i : listaComentarios){
                    if(user.getCedula().equals(i.getCedulaAutor())){
                        user.setComentario(i);
                    }
                }

                //Agregar el usuario final a las sedes
                SedeCentral.getListaUsers().add(user);
                switch (user.getSede()) {
                    case 0 -> {
                        SedePuriscal.getListaUsers().add(user);
                    }
                    case 1 -> {
                        SedeSanPedro.getListaUsers().add(user);
                    }
                    case 2 -> {
                        SedeCiudadColon.getListaUsers().add(user);
                    }
                }

                //Agregar los datos a las listas de datos usados
                DatosRegistrados.getListaCedulas().add(user.getCedula());
                DatosRegistrados.getListaClaves().add(user.getClaveNumerica());
                DatosRegistrados.getListaTelefonos().add(user.getTelefono());
            }
            leerUs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error descargando usuarios de BaseDatos");
        }
    }

    
    //Recorre el archivo de la base de datos que guarda a los usuarios eliminados.
    //Reconstruye cada usuario eliminado y le asigna sus respectivos atributos.
    //Una vez esta completamente reconstruido lo agrega a la lista de usuarios eliminados.
    //Agrega los datos unicos en uso a la lista de datos unicos en uso.
    public static void descargarUsuariosEliminadosBaseDatos() {
        try {
            BaseDatos.verfificarExistenciaUsuariosEliminadosTxT();
            BufferedReader leer = new BufferedReader(new FileReader(BaseDatos.getUsuariosEliminadosTxt()));
            String linea;

            while ((linea = leer.readLine()) != null) {

                //Distribucion de la lista String[] datos:
                //[0] = Usuario
                //[1] = Apellido
                //[2] = Cedula
                //[3] = Telefono
                //[4] = Password
                //[5] = Clave Num
                //[6] = Rol
                //[7] = Sede
                //[8] = saldo cuenta corriente
                //[9] = saldo cuenta ahorro
                //[10] = saldo cuenta simpe
                //[11] = estado cuenta corriente
                //[12] = estado cuenta ahorro
                //[13] = estado cuenta simpe
                //[14] = estado usuario
                //[15] = estado cuenta
                String[] datos = linea.split("\t");

                //userEliminado = (usuario, apellidos, password, cedula, telefono, claveNumerica, rol, sede, saldoCorriente, saldoSimpe, saldoAhorro)
                Usuarios userEliminado = new Usuarios(datos[0], datos[1], datos[4], datos[2], datos[3], Integer.parseInt(datos[5]), Integer.parseInt(datos[6]), Integer.parseInt(datos[7]),
                        Double.parseDouble(datos[8]), Double.parseDouble(datos[10]), Double.parseDouble(datos[9]));

                userEliminado.getCuentaCorriente().setEstado(Boolean.parseBoolean(datos[11]));
                userEliminado.getCuentaAhorro().setEstado(Boolean.parseBoolean(datos[12]));
                userEliminado.getCuentaSimpe().setEstado(Boolean.parseBoolean(datos[13]));

                userEliminado.setEstadoUsuario(Boolean.parseBoolean(datos[14]));
                userEliminado.setEstadoCuenta(Boolean.parseBoolean(datos[15]));

                //leer comprobantes para asignarle a user los comprobantes correspondientes
                for (ComprobanteSimpeSalida i : listaComprobantesSalida) {
                    String numeroEmisor = i.getNumeroEmisor();
                    if (userEliminado.getTelefono().equals(numeroEmisor)) {
                        userEliminado.getComprobantesSimpeSalida().add(i);
                    }
                }

                for (ComprobanteSimpeEntrada i : listaComprobantesEntrada) {
                    String numeroReceptor = i.getNumeroReceptor();
                    if (userEliminado.getTelefono().equals(numeroReceptor)) {
                        userEliminado.getComprobantesSimpeEntrada().add(i);
                    }
                }
                
                for(Comentario i : listaComentarios){
                    if(userEliminado.getCedula().equals(i.getCedulaAutor())){
                        userEliminado.setComentario(i);
                    }
                }

                //Afregar al usuario a la lista de usuarios eliminados
                DatosRegistrados.getListaUsuariosEliminados().add(userEliminado);

                //Agregar los datos del usuario a los datos registrados
                DatosRegistrados.getListaCedulas().add(userEliminado.getCedula());
                DatosRegistrados.getListaClaves().add(userEliminado.getClaveNumerica());
                DatosRegistrados.getListaTelefonos().add(userEliminado.getTelefono());
            }
            leer.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error descargando usuariosEliminados de BaseDatos");
        }
    }

    
    //Recorre el archivo de la base de datos que guarda a los administradores.
    //Reconstruye cada administrador y le asigna sus respectivos atributos.
    //Una vez esta completamente reconstruido lo agrega a las respectivas sedes.
    //Agrega los datos unicos en uso a la lista de datos unicos en uso.
    public static void descargarAdministradoresBaseDatos() {
        try {
            BaseDatos.verfificarExistenciaAdministradoresTxT();
            BufferedReader leer = new BufferedReader(new FileReader(BaseDatos.getAdministradoresTxt()));
            String linea;

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
                String[] datos = linea.split("\t");

                // admin(usuario, apellidos, password, cedula, telefono, claveNumerica,  rol, sede)
                Administradores admin = new Administradores(datos[0], datos[1], datos[4], datos[2], datos[3], Integer.parseInt(datos[5]),
                        Integer.parseInt(datos[6]), Integer.parseInt(datos[7]));

                //agregar admin a las sedes
                SedeCentral.getListaAdmins().add(admin);
                switch (admin.getSede()) {
                    case 0 -> {
                        SedePuriscal.getListaAdmins().add(admin);
                    }
                    case 1 -> {
                        SedeSanPedro.getListaAdmins().add(admin);
                    }
                    case 2 -> {
                        SedeCiudadColon.getListaAdmins().add(admin);
                    }
                }

                //Agregar los datos a las listas de datos usados
                DatosRegistrados.getListaCedulas().add(admin.getCedula());
                DatosRegistrados.getListaClaves().add(admin.getClaveNumerica());
                DatosRegistrados.getListaTelefonos().add(admin.getTelefono());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error descargando administradores de BaseDatos");
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
                
                //Se ejecuta solo una vez en el main para evitar duplicar datos.
                descargarComprobantesEntrada();
                descargarComprobantesSalida();
                descargarComentarios();
                descargarUsuariosBaseDatos();
                descargarUsuariosEliminadosBaseDatos();
                descargarAdministradoresBaseDatos();
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
