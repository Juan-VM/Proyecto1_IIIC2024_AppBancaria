package guiUsuarios;

import guiGeneral.Inicio;
import BaseDatos.BaseDatos;
import Comentarios.Comentario;
import Comprobantes.ComprobanteSimpeEntrada;
import Comprobantes.ComprobanteSimpeSalida;
import Personas.Usuarios;
import RegistroDatos.DatosRegistrados;
import Sedes.SedeCiudadColon;
import Sedes.SedePuriscal;
import Sedes.SedeSanPedro;
import Sedes.SedeCentral;
import java.awt.Color;
import javax.swing.JOptionPane;

public class ConfigurarPerfil extends javax.swing.JFrame {

    boolean verPassword = false;
    int sede;
    String cedula;
    String cedulaVieja;
    String telefono;
    boolean BotonGuardarActivo;
    String telefonoAnterior;

    public ConfigurarPerfil(String cedula, int sede) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cedula = cedula;
        this.cedulaVieja = cedula;
        this.sede = sede;
        panelConfig.setBackground(new Color(255, 255, 218));
        alertaCedula.setVisible(false);
        alertaTelefono.setVisible(false);
        this.BotonGuardarActivo = false;

        for (Usuarios i : SedeCentral.getListaUsers()) {
            if (i.getSede() == this.sede && i.getCedula().equals(this.cedula)) {
                txtName.setText(i.getUsuario());
                txtApellido.setText(i.getApellidos());
                txtCedula.setText(i.getCedula());
                txtTelefono.setText(i.getTelefono());
                this.telefono = i.getTelefono();
                psdPassword.setText(String.valueOf(i.getPassword()));
                jblNombrePerfil.setText(i.getUsuario() + " " + i.getApellidos());
                switch (this.sede) {
                    case 0 -> {
                        jblVentanaActual.setText("Sede Puriscal");
                    }
                    case 1 -> {
                        jblVentanaActual.setText("Sede San Pedro");
                    }
                    case 2 -> {
                        jblVentanaActual.setText("Sede Ciudad Colon");
                    }
                }
                this.telefonoAnterior = txtTelefono.getText();
            }
        }
    }

    public ConfigurarPerfil() {

    }

    public void actualizarDatosEnLaSede(int sede, String cedula, Usuarios user) {
        switch (sede) {
            case 0 -> {
                for (Usuarios i : SedePuriscal.ListaUsers) {
                    if (i.getCedula().equals(cedula)) {
                        i = user;
                    }
                }
            }
            case 1 -> {
                for (Usuarios i : SedeSanPedro.ListaUsers) {
                    if (i.getCedula().equals(cedula)) {
                        i = user;
                    }
                }
            }
            case 2 -> {
                for (Usuarios i : SedeCiudadColon.ListaUsers) {
                    if (i.getCedula().equals(cedula)) {
                        i = user;
                    }
                }
            }
        }
    }

    public boolean validarRepetidos() {
        boolean existen = false;
        if (DatosRegistrados.getListaCedulas().contains(txtCedula.getText()) || DatosRegistrados.getListaTelefonos().contains(txtTelefono.getText())) {

            if (DatosRegistrados.getListaCedulas().contains(txtCedula.getText())) {
                if (!txtCedula.getText().equals(this.cedula) || txtCedula.getText().trim().equals("")) {
                    alertaCedula.setVisible(true);
                    existen = true;
                }
            }

            if (DatosRegistrados.getListaTelefonos().contains(txtTelefono.getText())) {
                if (!txtTelefono.getText().equals(this.telefono) || txtTelefono.getText().trim().equals("")) {
                    alertaTelefono.setVisible(true);
                    existen = true;
                }
            }
        }
        return existen;
    }

    public void actualizarDatosRegistrados(String ced, String tel) {
        if (!ced.equals(this.cedula)) {
            DatosRegistrados.getListaCedulas().remove(this.cedula);
            DatosRegistrados.getListaCedulas().add(ced);
        }

        if (!tel.equals(this.telefono)) {
            DatosRegistrados.getListaTelefonos().remove(this.telefono);
            DatosRegistrados.getListaTelefonos().add(tel);
        }
    }

    public void actalizarNumerosEmisoresYReceptoresComprobantesSalida(String telN) {
        for (Usuarios i : SedeCentral.getListaUsers()) {

            for (ComprobanteSimpeSalida c : i.getComprobantesSimpeSalida()) {
                if (c.getNumeroEmisor().equals(this.telefonoAnterior)) {
                    c.setNumeroEmisor(telN);
                }

                if (c.getNumeroReceptor().equals(this.telefonoAnterior)) {
                    c.setNumeroReceptor(telN);
                }
            }
        }

        for (Usuarios i : DatosRegistrados.getListaUsuariosEliminados()) {
            for (ComprobanteSimpeSalida c : i.getComprobantesSimpeSalida()) {
                if (c.getNumeroEmisor().equals(this.telefonoAnterior)) {
                    c.setNumeroEmisor(telN);
                }

                if (c.getNumeroReceptor().equals(this.telefonoAnterior)) {
                    c.setNumeroReceptor(telN);
                }
            }
        }
    }

    public void actalizarNumerosEmisoresYReceptoresComprobantesEntrada(String telN) {
        for (Usuarios i : SedeCentral.getListaUsers()) {

            for (ComprobanteSimpeEntrada c : i.getComprobantesSimpeEntrada()) {
                if (c.getNumeroEmisor().equals(this.telefonoAnterior)) {
                    c.setNumeroEmisor(telN);
                }

                if (c.getNumeroReceptor().equals(this.telefonoAnterior)) {
                    c.setNumeroReceptor(telN);
                }
            }
        }

        for (Usuarios i : DatosRegistrados.getListaUsuariosEliminados()) {

            for (ComprobanteSimpeEntrada c : i.getComprobantesSimpeEntrada()) {
                if (c.getNumeroEmisor().equals(this.telefonoAnterior)) {
                    c.setNumeroEmisor(telN);
                }

                if (c.getNumeroReceptor().equals(this.telefonoAnterior)) {
                    c.setNumeroReceptor(telN);
                }
            }
        }
    }

    public void actalizarUsuarioCedulaComentarios(Usuarios u) {
        for (Usuarios i : SedeCentral.getListaUsers()) {
            if (i.getCedula().equals(u.getCedula())) {

                i.getComentario().setAutor(i.getUsuario());
                i.getComentario().setCedulaAutor(i.getCedula());

                for (Comentario c : DatosRegistrados.getListaComentarios()) {
                    if (c.getCedulaAutor().equals(cedulaVieja)) {
                        c.setAutor(i.getComentario().getAutor());
                        c.setCedulaAutor(i.getComentario().getCedulaAutor());
                        c.setTexto(i.getComentario().getTexto());
                        c.setFecha(i.getComentario().getFecha());
                        c.setHora(i.getComentario().getHora());
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
        panelSimpeBarra = new javax.swing.JPanel();
        jblSimpe = new javax.swing.JLabel();
        panelConfigOp = new javax.swing.JPanel();
        panelEditDatos = new javax.swing.JPanel();
        jblPassword = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        alertaCedula = new javax.swing.JLabel();
        jblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        alertaTelefono = new javax.swing.JLabel();
        jblTelefono = new javax.swing.JLabel();
        psdPassword = new javax.swing.JPasswordField();
        txtTelefono = new javax.swing.JTextField();
        panelVerPass = new javax.swing.JPanel();
        jblVerPass = new javax.swing.JLabel();
        panelEditar = new javax.swing.JPanel();
        jblEditar = new javax.swing.JLabel();
        panelGuardar = new javax.swing.JPanel();
        jblGuardar = new javax.swing.JLabel();
        jblOpcionActual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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
        jblRetirar.setText("Retirar");
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

        panelOpciones.add(panelComentariosBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 300, 60));

        panelSimpeBarra.setBackground(new java.awt.Color(252, 247, 215));
        panelSimpeBarra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblSimpe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblSimpe.setForeground(new java.awt.Color(102, 102, 102));
        jblSimpe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblSimpe.setText("Simpe");
        jblSimpe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblSimpe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblSimpeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblSimpeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblSimpeMouseExited(evt);
            }
        });
        panelSimpeBarra.add(jblSimpe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 60));

        panelOpciones.add(panelSimpeBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 300, 60));

        background.add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 720));

        panelConfigOp.setBackground(new java.awt.Color(255, 255, 255));
        panelConfigOp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        background.add(panelConfigOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelEditDatos.setBackground(new java.awt.Color(255, 255, 255));
        panelEditDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblPassword.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jblPassword.setForeground(new java.awt.Color(51, 51, 51));
        jblPassword.setText("PASSWORD");
        panelEditDatos.add(jblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 580, -1));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        panelEditDatos.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 750, 10));

        jblName.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jblName.setForeground(new java.awt.Color(51, 51, 51));
        jblName.setText("USUARIO");
        panelEditDatos.add(jblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 580, -1));

        txtName.setBackground(new java.awt.Color(255, 255, 255));
        txtName.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txtName.setForeground(new java.awt.Color(204, 204, 204));
        txtName.setText("Usuario");
        txtName.setBorder(null);
        panelEditDatos.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 580, 40));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        panelEditDatos.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 750, 10));

        alertaCedula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alertaCedula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/advertencia.png"))); // NOI18N
        panelEditDatos.add(alertaCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 40, 40));

        jblApellido.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jblApellido.setForeground(new java.awt.Color(51, 51, 51));
        jblApellido.setText("APELLIDO");
        panelEditDatos.add(jblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 580, -1));

        txtApellido.setBackground(new java.awt.Color(255, 255, 255));
        txtApellido.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(204, 204, 204));
        txtApellido.setText("Apellidos");
        txtApellido.setBorder(null);
        panelEditDatos.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 580, 40));

        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));
        panelEditDatos.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 750, 10));

        jblCedula.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jblCedula.setForeground(new java.awt.Color(51, 51, 51));
        jblCedula.setText("CEDULA");
        panelEditDatos.add(jblCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 580, -1));

        txtCedula.setBackground(new java.awt.Color(255, 255, 255));
        txtCedula.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txtCedula.setForeground(new java.awt.Color(204, 204, 204));
        txtCedula.setText("Cedula");
        txtCedula.setBorder(null);
        txtCedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCedulaMousePressed(evt);
            }
        });
        panelEditDatos.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 580, 50));

        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));
        panelEditDatos.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 750, 10));

        alertaTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alertaTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/advertencia.png"))); // NOI18N
        panelEditDatos.add(alertaTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 40, 40));

        jblTelefono.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jblTelefono.setForeground(new java.awt.Color(51, 51, 51));
        jblTelefono.setText("TELEFONO");
        panelEditDatos.add(jblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 580, -1));

        psdPassword.setBackground(new java.awt.Color(255, 255, 255));
        psdPassword.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        psdPassword.setForeground(new java.awt.Color(204, 204, 204));
        psdPassword.setText("Password");
        psdPassword.setBorder(null);
        panelEditDatos.add(psdPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 500, 40));

        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(204, 204, 204));
        txtTelefono.setText("Telefono");
        txtTelefono.setBorder(null);
        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTelefonoMousePressed(evt);
            }
        });
        panelEditDatos.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 580, 40));

        panelVerPass.setBackground(new java.awt.Color(255, 255, 255));
        panelVerPass.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblVerPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblVerPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojoCerrado.png"))); // NOI18N
        jblVerPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblVerPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblVerPassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblVerPassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblVerPassMouseExited(evt);
            }
        });
        panelVerPass.add(jblVerPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        panelEditDatos.add(panelVerPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 490, 40, 40));

        background.add(panelEditDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 790, 570));

        panelEditar.setBackground(new java.awt.Color(204, 212, 152));
        panelEditar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblEditar.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jblEditar.setForeground(new java.awt.Color(102, 102, 102));
        jblEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblEditar.setText("EDITAR");
        jblEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblEditarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblEditarMouseExited(evt);
            }
        });
        panelEditar.add(jblEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 60));

        background.add(panelEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 130, -1));

        panelGuardar.setBackground(new java.awt.Color(204, 212, 152));
        panelGuardar.setForeground(new java.awt.Color(51, 51, 51));
        panelGuardar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblGuardar.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jblGuardar.setForeground(new java.awt.Color(102, 102, 102));
        jblGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblGuardar.setText("GUARDAR");
        jblGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblGuardarMouseExited(evt);
            }
        });
        panelGuardar.add(jblGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 60));

        background.add(panelGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 90, 130, -1));

        jblOpcionActual.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jblOpcionActual.setForeground(new java.awt.Color(51, 51, 51));
        jblOpcionActual.setText("CONFIGURACION");
        background.add(jblOpcionActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 320, 40));

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

    private void jblDepositarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblDepositarMouseClicked
        Depositar depositar = new Depositar(this.cedula, this.sede);
        depositar.setVisible(true);
        panelConfig.setBackground(new Color(247, 240, 194));
        this.dispose();
    }//GEN-LAST:event_jblDepositarMouseClicked

    private void jblDepositarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblDepositarMouseEntered
        panelDepositarBarra.setBackground(new Color(232, 225, 182));
    }//GEN-LAST:event_jblDepositarMouseEntered

    private void jblDepositarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblDepositarMouseExited
        panelDepositarBarra.setBackground(new Color(252, 247, 215));
    }//GEN-LAST:event_jblDepositarMouseExited

    private void jblRetirarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblRetirarMouseClicked
        Retirar retirar = new Retirar(this.cedula, this.sede);
        retirar.setVisible(true);
        panelConfig.setBackground(new Color(247, 240, 194));
        this.dispose();
    }//GEN-LAST:event_jblRetirarMouseClicked

    private void jblRetirarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblRetirarMouseEntered
        panelRetirarBarra.setBackground(new Color(232, 225, 182));
    }//GEN-LAST:event_jblRetirarMouseEntered

    private void jblRetirarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblRetirarMouseExited
        panelRetirarBarra.setBackground(new Color(252, 247, 215));
    }//GEN-LAST:event_jblRetirarMouseExited

    private void jblVerSaldoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerSaldoMouseClicked
        VerSaldo ver = new VerSaldo(this.cedula, this.sede);
        ver.setVisible(true);
        panelConfig.setBackground(new Color(247, 240, 194));
        this.dispose();
    }//GEN-LAST:event_jblVerSaldoMouseClicked

    private void jblVerSaldoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerSaldoMouseEntered
        panelVerSaldoBarra.setBackground(new Color(232, 225, 182));
    }//GEN-LAST:event_jblVerSaldoMouseEntered

    private void jblVerSaldoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerSaldoMouseExited
        panelVerSaldoBarra.setBackground(new Color(252, 247, 215));
    }//GEN-LAST:event_jblVerSaldoMouseExited

    private void jblDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblDashboardMouseClicked
        PrincipalUsers users = new PrincipalUsers(this.cedula, this.sede);
        users.setVisible(true);
        panelConfig.setBackground(new Color(247, 240, 194));
        this.dispose();;
    }//GEN-LAST:event_jblDashboardMouseClicked

    private void jblDashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblDashboardMouseEntered
        panelDashboardBarra.setBackground(new Color(232, 225, 182));
    }//GEN-LAST:event_jblDashboardMouseEntered

    private void jblDashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblDashboardMouseExited
        panelDashboardBarra.setBackground(new Color(252, 247, 215));
    }//GEN-LAST:event_jblDashboardMouseExited

    private void jblHabilitarCuentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblHabilitarCuentasMouseClicked
        HabilitarCuentas habilitar = new HabilitarCuentas(this.cedula, this.sede);
        habilitar.setVisible(true);
        //panelDashboardBarra.setBackground(new Color(252, 247, 215));
        this.dispose();
    }//GEN-LAST:event_jblHabilitarCuentasMouseClicked

    private void jblHabilitarCuentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblHabilitarCuentasMouseEntered
        panelHabilitarCuentasBarra.setBackground(new Color(232, 225, 182));
    }//GEN-LAST:event_jblHabilitarCuentasMouseEntered

    private void jblHabilitarCuentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblHabilitarCuentasMouseExited
        panelHabilitarCuentasBarra.setBackground(new Color(252, 247, 215));
    }//GEN-LAST:event_jblHabilitarCuentasMouseExited

    private void jblComentariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblComentariosMouseClicked
        Comentarios comentario = new Comentarios(this.cedula, this.sede);
        comentario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jblComentariosMouseClicked

    private void jblComentariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblComentariosMouseEntered
        panelComentariosBarra.setBackground(new Color(232, 225, 182));
    }//GEN-LAST:event_jblComentariosMouseEntered

    private void jblComentariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblComentariosMouseExited
        panelComentariosBarra.setBackground(new Color(252, 247, 215));
    }//GEN-LAST:event_jblComentariosMouseExited

    private void jblAtrasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblAtrasMouseEntered
        panelAtras.setBackground(new Color(245, 228, 120));
    }//GEN-LAST:event_jblAtrasMouseEntered

    private void jblAtrasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblAtrasMouseExited
        panelAtras.setBackground(new Color(210, 196, 103));
    }//GEN-LAST:event_jblAtrasMouseExited

    private void jblSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblSalirMouseEntered
        panelSalir.setBackground(new Color(255, 255, 218));
    }//GEN-LAST:event_jblSalirMouseEntered

    private void jblSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblSalirMouseExited
        panelSalir.setBackground(new Color(247, 240, 194));
    }//GEN-LAST:event_jblSalirMouseExited

    private void jblVerPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerPassMouseClicked

        if (verPassword == false) {
            verPassword = true;
            jblVerPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojoAbierto.png")));
            psdPassword.setEchoChar((char) 0);
        } else {
            verPassword = false;
            jblVerPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojoCerrado.png")));
            psdPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jblVerPassMouseClicked

    private void jblVerPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerPassMouseEntered
        panelVerPass.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_jblVerPassMouseEntered

    private void jblVerPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerPassMouseExited
        panelVerPass.setBackground(Color.white);
    }//GEN-LAST:event_jblVerPassMouseExited

    private void jblEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblEditarMouseClicked
        this.BotonGuardarActivo = true;
        txtName.setEditable(true);
        txtApellido.setEditable(true);
        txtCedula.setEditable(true);
        txtTelefono.setEditable(true);
        psdPassword.setEditable(true);
        txtName.setForeground(new Color(102, 102, 102));
        txtApellido.setForeground(new Color(102, 102, 102));
        txtCedula.setForeground(new Color(102, 102, 102));
        txtTelefono.setForeground(new Color(102, 102, 102));
        psdPassword.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_jblEditarMouseClicked

    private void jblEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblEditarMouseEntered
        panelEditar.setBackground(new Color(228, 237, 170));
        jblEditar.setForeground(new Color(51, 51, 51));
    }//GEN-LAST:event_jblEditarMouseEntered

    private void jblEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblEditarMouseExited
        panelEditar.setBackground(new Color(204, 212, 152));
        jblEditar.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_jblEditarMouseExited

    private void jblGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblGuardarMouseClicked
        if (this.BotonGuardarActivo == true) {
            boolean EspaciosRepetidos = validarRepetidos();
            if (EspaciosRepetidos == false) {
                for (Usuarios i : SedeCentral.getListaUsers()) {
                    if (i.getSede() == sede && i.getCedula().equals(this.cedula)) {

                        i.setUsuario(txtName.getText());
                        i.setApellidos(txtApellido.getText());
                        i.setCedula(txtCedula.getText());
                        i.setTelefono(txtTelefono.getText());
                        i.setPassword(String.valueOf(psdPassword.getPassword()));
                        jblNombrePerfil.setText(i.getUsuario() + " " + i.getApellidos());
                        actualizarDatosRegistrados(i.getCedula(), i.getTelefono()); //Toma los datos nuevos y los compara con los anteriores.
                        this.cedula = i.getCedula();
                        this.telefono = i.getTelefono();
                        actualizarDatosEnLaSede(this.sede, i.getCedula(), i);
                        actalizarUsuarioCedulaComentarios(i);
                    }
                }

                try {
                    BaseDatos.actualizarUsuariosBaseDatos();
                    actalizarNumerosEmisoresYReceptoresComprobantesSalida(txtTelefono.getText());
                    actalizarNumerosEmisoresYReceptoresComprobantesEntrada(txtTelefono.getText());
                    BaseDatos.actualizarComprobantesSalidaTxtBD();
                    BaseDatos.actualizarComprobantesEntradaTxtBD();
                    BaseDatos.actualizarComentariosTxtBD();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error, actalizando la base de datos");
                }

                txtName.setForeground(new Color(204, 204, 204));
                txtApellido.setForeground(new Color(204, 204, 204));
                txtCedula.setForeground(new Color(204, 204, 204));
                txtTelefono.setForeground(new Color(204, 204, 204));
                psdPassword.setForeground(new Color(204, 204, 204));
                txtName.setEditable(false);
                txtApellido.setEditable(false);
                txtCedula.setEditable(false);
                txtTelefono.setEditable(false);
                psdPassword.setEditable(false);
                BotonGuardarActivo = false;
                jblGuardar.setForeground(new Color(102, 102, 102));
                panelGuardar.setBackground(new Color(204, 212, 152));
            } else {
                JOptionPane.showMessageDialog(null, "Error, datos en uso o en blanco");
            }
        }
    }//GEN-LAST:event_jblGuardarMouseClicked

    private void jblGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblGuardarMouseEntered
        if (this.BotonGuardarActivo == true) {
            panelGuardar.setBackground(new Color(228, 237, 170));
            jblGuardar.setForeground(new Color(51, 51, 51));
        }
    }//GEN-LAST:event_jblGuardarMouseEntered

    private void jblGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblGuardarMouseExited
        if (this.BotonGuardarActivo == true) {
            panelGuardar.setBackground(new Color(204, 212, 152));
            jblGuardar.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_jblGuardarMouseExited

    private void txtCedulaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCedulaMousePressed
        alertaCedula.setVisible(false);
    }//GEN-LAST:event_txtCedulaMousePressed

    private void txtTelefonoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMousePressed
        alertaTelefono.setVisible(false);
    }//GEN-LAST:event_txtTelefonoMousePressed

    private void jblAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblAtrasMouseClicked
        PrincipalUsers users = new PrincipalUsers(this.cedula, this.sede);
        users.setVisible(true);
        panelConfig.setBackground(new Color(247, 240, 194));
        this.dispose();
    }//GEN-LAST:event_jblAtrasMouseClicked

    private void jblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblSalirMouseClicked
        Inicio ini = new Inicio();
        ini.setVisible(true);
        panelConfig.setBackground(new Color(247, 240, 194));
        this.dispose();
    }//GEN-LAST:event_jblSalirMouseClicked

    private void jblSimpeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblSimpeMouseClicked
        for (Usuarios i : SedeCentral.getListaUsers()) {
            if (i.getCedula().equals(this.cedula)) {
                if (i.getCuentaSimpe().getEstado() == true) {
                    Simpe simpe = new Simpe(this.cedula, this.sede);
                    simpe.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Cuenta simpe inactiva, debes habilitarla");
                }
            }
        }
    }//GEN-LAST:event_jblSimpeMouseClicked

    private void jblSimpeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblSimpeMouseEntered
        panelSimpeBarra.setBackground(new Color(232, 225, 182));
    }//GEN-LAST:event_jblSimpeMouseEntered

    private void jblSimpeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblSimpeMouseExited
        panelSimpeBarra.setBackground(new Color(252, 247, 215));
    }//GEN-LAST:event_jblSimpeMouseExited

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
            java.util.logging.Logger.getLogger(ConfigurarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfigurarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfigurarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigurarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfigurarPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertaCedula;
    private javax.swing.JLabel alertaTelefono;
    private javax.swing.JPanel background;
    private javax.swing.JLabel iconBarra;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel jblApellido;
    private javax.swing.JLabel jblAtras;
    private javax.swing.JLabel jblBarra;
    private javax.swing.JLabel jblCedula;
    private javax.swing.JLabel jblComentarios;
    private javax.swing.JLabel jblConfig;
    private javax.swing.JLabel jblDashboard;
    private javax.swing.JLabel jblDepositar;
    private javax.swing.JLabel jblEditar;
    private javax.swing.JLabel jblFondoPerfil;
    private javax.swing.JLabel jblGuardar;
    private javax.swing.JLabel jblHabilitarCuentas;
    private javax.swing.JLabel jblName;
    private javax.swing.JLabel jblNombreBanco;
    private javax.swing.JLabel jblNombrePerfil;
    private javax.swing.JLabel jblOpcionActual;
    private javax.swing.JLabel jblPassword;
    private javax.swing.JLabel jblPerfil;
    private javax.swing.JLabel jblRetirar;
    private javax.swing.JLabel jblSalir;
    private javax.swing.JLabel jblSimpe;
    private javax.swing.JLabel jblTelefono;
    private javax.swing.JLabel jblVentanaActual;
    private javax.swing.JLabel jblVerPass;
    private javax.swing.JPanel panelAtras;
    private javax.swing.JPanel panelComentariosBarra;
    private javax.swing.JPanel panelConfig;
    private javax.swing.JPanel panelConfigOp;
    private javax.swing.JPanel panelDashboardBarra;
    private javax.swing.JPanel panelDepositarBarra;
    private javax.swing.JPanel panelEditDatos;
    private javax.swing.JPanel panelEditar;
    private javax.swing.JPanel panelGuardar;
    private javax.swing.JPanel panelHabilitarCuentasBarra;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelRetirarBarra;
    private javax.swing.JPanel panelSalir;
    private javax.swing.JPanel panelSimpeBarra;
    private javax.swing.JPanel panelVerPass;
    private javax.swing.JPanel panelVerSaldoBarra;
    private javax.swing.JPasswordField psdPassword;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
