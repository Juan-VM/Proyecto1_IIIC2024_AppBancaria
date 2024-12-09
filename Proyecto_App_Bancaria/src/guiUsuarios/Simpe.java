package guiUsuarios;

import BaseDatos.BaseDatos;
import Comprobantes.ComprobanteSimpeEntrada;
import Comprobantes.ComprobanteSimpeSalida;
import Personas.Usuarios;
import RegistroDatos.DatosRegistrados;
import Sedes.SedeCentral;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Simpe extends javax.swing.JFrame {

    String cedula;
    int sede;
    boolean verPassword;
    boolean numeroValido = false;
    boolean montoValido = false;
    boolean cuentaValida = false;
    DefaultTableModel modeloS = new DefaultTableModel();
    DefaultTableModel modeloE = new DefaultTableModel();

    public Simpe(String cedula, int sede) {
        initComponents();

        this.modeloS.addColumn("Fecha");
        this.modeloS.addColumn("Hora");
        this.modeloS.addColumn("Monto");

        this.modeloE.addColumn("Fecha");
        this.modeloE.addColumn("Hora");
        this.modeloE.addColumn("Monto");

        this.tabalSalidas.setModel(modeloS);
        this.tablaEntradas.setModel(modeloE);

        this.setLocationRelativeTo(null);
        this.cedula = cedula;
        this.sede = sede;
        this.verPassword = false;
        panelSimpeBarra.setBackground(new Color(232, 225, 182));
        jblAlerta.setVisible(false);
        alertaClave.setVisible(false);
        alertaNumero.setVisible(false);
        alertaMonto.setVisible(false);
        alertaDetalle.setVisible(false);
        txtsPorDefecto();

        for (Usuarios i : SedeCentral.getListaUsers()) {
            if (i.getCedula().equals(this.cedula)) {
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
            }
        }
    }

    public Simpe() {
        initComponents();
    }

    public void txtsPorDefecto() {
        txtClaveNum.setText("Ingrese su clave");
        psdPassword.setText("Ingrese su password");
    }

    public void txtsRealizarSimpePorDefecto() {
        txtNumeroSimpe.setText("Ingrese el numero");
        txtMontoTransferencia.setText("Ingrese el monto");
        txtDetalle.setText("Ingrese el detalle");
        cbCuentaElegida.setSelectedIndex(0);
    }

    public void txtsSetPredeterminatedText(String is) {
        if (!(txtNumeroSimpe.getText().equals("Ingrese el numero")) && !(txtNumeroSimpe.getText().trim().equals("")) && !is.equals("numero")) {
            txtNumeroSimpe.setForeground(new Color(153, 153, 153));
        } else {
            if (txtNumeroSimpe.getText().equals("")) {
                txtNumeroSimpe.setText("Ingrese el numero");
            }
            txtNumeroSimpe.setForeground(new Color(153, 153, 153));
        }

        if (!(txtMontoTransferencia.getText().equals("Ingrese el monto")) && !(txtMontoTransferencia.getText().trim().equals("")) && !is.equals("monto")) {
            txtMontoTransferencia.setForeground(new Color(153, 153, 153));
        } else {
            if (txtMontoTransferencia.getText().equals("")) {
                txtMontoTransferencia.setText("Ingrese el monto");
            }
            txtMontoTransferencia.setForeground(new Color(153, 153, 153));
        }

        if (!(txtDetalle.getText().equals("Ingrese el detalle")) && !(txtDetalle.getText().trim().equals("")) && !is.equals("detalle")) {
            txtDetalle.setForeground(new Color(153, 153, 153));
        } else {
            if (txtDetalle.getText().equals("")) {
                txtDetalle.setText("Ingrese el detalle");
            }
            txtDetalle.setForeground(new Color(153, 153, 153));
        }
    }

    public void validarDatosSimpe() {
        try {
            String numero = txtNumeroSimpe.getText();
            double monto = Double.parseDouble(txtMontoTransferencia.getText());

            boolean numeroEncontrado = false;
            boolean simpeActivo = false;

            for (Usuarios i : SedeCentral.getListaUsers()) {
                if (i.getTelefono().equals(numero)) {
                    numeroEncontrado = true;
                    if (i.getCuentaSimpe().getEstado() == true) {
                        simpeActivo = true;
                    }
                }
            }
            if (numeroEncontrado == true) {
                if (simpeActivo == true) {
                    this.numeroValido = true;
                    alertaNumero.setVisible(false);
                } else {
                    this.numeroValido = false;
                    alertaNumero.setVisible(true);
                    alertaNumero.setText("Este numero tiene el simpe desabilitado");
                }
            } else {
                this.numeroValido = false;
                alertaNumero.setVisible(true);
                alertaNumero.setText("Numero no encontrado");
            }

            for (Usuarios i : SedeCentral.ListaUsers) {
                if (i.getCedula().equals(this.cedula)) {

                    switch (cbCuentaElegida.getSelectedIndex()) {
                        case 0 -> {

                            if (i.getCuentaCorriente().getSaldo() >= monto) {
                                this.montoValido = true;
                                alertaMonto.setVisible(false);
                            } else {
                                this.montoValido = false;
                                alertaMonto.setVisible(true);
                                alertaMonto.setText("Saldo insuficiente");
                            }
                            if (i.getCuentaCorriente().getEstado() == true) {
                                this.cuentaValida = true;
                            }
                        }
                        case 1 -> {

                            if (i.getCuentaAhorro().getSaldo() >= monto) {
                                this.montoValido = true;
                                alertaMonto.setVisible(false);
                            } else {
                                this.montoValido = false;
                                alertaMonto.setVisible(true);
                                alertaMonto.setText("Saldo insuficiente");
                            }
                            if (i.getCuentaAhorro().getEstado() == true) {
                                this.cuentaValida = true;
                            } else {
                                JOptionPane.showMessageDialog(null, "Cuenta ahorro inactiva, debes habilitarla");
                                cbCuentaElegida.setSelectedIndex(0);
                            }
                        }
                        case 2 -> {

                            if ((i.getCuentaSimpe().getSaldo()) >= monto) {
                                this.montoValido = true;
                                alertaMonto.setVisible(false);
                            } else {
                                this.montoValido = false;
                                alertaMonto.setVisible(true);
                                alertaMonto.setText("Saldo insuficiente");
                            }
                            if (i.getCuentaSimpe().getEstado() == true) {
                                this.cuentaValida = true;
                            } else {
                                JOptionPane.showMessageDialog(null, "Cuenta simpe inactiva, debes habilitarla");
                                cbCuentaElegida.setSelectedIndex(0);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Rellena todos los espacios");
            numeroValido = false;
            montoValido = false;
            cuentaValida = false;
        }
    }

    public void setTextosMuestraComprobanteSalida(ComprobanteSimpeSalida comprobante) {
        String realizadoPor = "";
        String destinatario = "";
        String detalle = comprobante.getDetalle();
        if (detalle.equals("Ingrese el detalle")) {
            detalle = "ninguno";
        }
        
        for (Usuarios i : SedeCentral.getListaUsers()) {
            if (i.getTelefono().equals(comprobante.getNumeroEmisor())) {
                realizadoPor = i.getApellidos() + " " + i.getUsuario();
            }

            if (i.getTelefono().equals(comprobante.getNumeroReceptor())) {
                destinatario = i.getApellidos() + " " + i.getUsuario();
            }
        }

        jblFechaPago.setText(comprobante.getFecha() + "  " + comprobante.getHora());
        jblMontoDebitado.setText(String.valueOf(comprobante.getMonto()) + " Colones");
        jblRealizadoPor.setText(realizadoPor);
        jblMontoAcreditado.setText(String.valueOf(comprobante.getMonto()) + " Colones");
        jblNumeroMonedero.setText(comprobante.getNumeroReceptor());
        jblDestinatario.setText(destinatario);
        jblMontoTransferencia.setText(String.valueOf(comprobante.getMonto()) + " Colones");
        jblDetalle.setText(detalle);
    }

    public void setTextosMuestraComprobanteEntrada(ComprobanteSimpeEntrada comprobante) {
        String realizadoPor = "";
        String destinatario = "";
        String detalle = comprobante.getDetalle();
        if (detalle.equals("Ingrese el detalle")) {
            detalle = "ninguno";
        }

        for (Usuarios i : SedeCentral.getListaUsers()) {
            if (i.getTelefono().equals(comprobante.getNumeroEmisor())) {
                realizadoPor = i.getApellidos() + " " + i.getUsuario();
            }

            if (i.getTelefono().equals(comprobante.getNumeroReceptor())) {
                destinatario = i.getApellidos() + " " + i.getUsuario();
            }
        }

        jblFechaPago.setText(comprobante.getFecha() + "  " + comprobante.getHora());
        jblMontoDebitado.setText(String.valueOf(comprobante.getMonto()) + " Colones");
        jblRealizadoPor.setText(realizadoPor);
        jblMontoAcreditado.setText(String.valueOf(comprobante.getMonto()) + " Colones");
        jblNumeroMonedero.setText(comprobante.getNumeroReceptor());
        jblDestinatario.setText(destinatario);
        jblMontoTransferencia.setText(String.valueOf(comprobante.getMonto()) + " Colones");
        jblDetalle.setText(detalle);
    }

    public void llenarTablaSalida() {
        modeloS.setRowCount(0);
        for (Usuarios i : SedeCentral.getListaUsers()) {

            if (i.getCedula().equals(this.cedula)) {
                ArrayList<ComprobanteSimpeSalida> listaS = i.getComprobantesSimpeSalida();

                for (ComprobanteSimpeSalida c : listaS) {
                    modeloS.addRow(new Object[]{c.getFecha(), c.getHora(), c.getMonto()});
                }
            }
        }
    }

    public void llenarTablaEntrada() {
        modeloE.setRowCount(0);
        for (Usuarios i : SedeCentral.getListaUsers()) {

            if (i.getCedula().equals(this.cedula)) {
                ArrayList<ComprobanteSimpeEntrada> listaE = i.getComprobantesSimpeEntrada();

                for (ComprobanteSimpeEntrada c : listaE) {
                    modeloE.addRow(new Object[]{c.getFecha(), c.getHora(), c.getMonto()});
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
        pizarra = new javax.swing.JTabbedPane();
        panelValidar = new javax.swing.JPanel();
        jblClaveNum = new javax.swing.JLabel();
        txtClaveNum = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jblPassword = new javax.swing.JLabel();
        psdPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        panelVerPassword = new javax.swing.JPanel();
        jblVerPassword = new javax.swing.JLabel();
        panelContinuar = new javax.swing.JPanel();
        jblContinuar = new javax.swing.JLabel();
        alertaClave = new javax.swing.JLabel();
        jblAlerta = new javax.swing.JLabel();
        jblOpcionActual = new javax.swing.JLabel();
        panelElegir = new javax.swing.JPanel();
        jblOpcionActual1 = new javax.swing.JLabel();
        panelRealizarSimpe = new javax.swing.JPanel();
        jblRealizarSimpe = new javax.swing.JLabel();
        panelHistoriaSimpes = new javax.swing.JPanel();
        jblHistorialSimpe = new javax.swing.JLabel();
        jblInformativo = new javax.swing.JLabel();
        panelSimpe = new javax.swing.JPanel();
        numero = new javax.swing.JLabel();
        txtNumeroSimpe = new javax.swing.JTextField();
        monto = new javax.swing.JLabel();
        txtMontoTransferencia = new javax.swing.JTextField();
        cuenta = new javax.swing.JLabel();
        cbCuentaElegida = new javax.swing.JComboBox<>();
        detalle = new javax.swing.JLabel();
        txtDetalle = new javax.swing.JTextField();
        panelRealizar = new javax.swing.JPanel();
        jblRealizar = new javax.swing.JLabel();
        alertaNumero = new javax.swing.JLabel();
        alertaMonto = new javax.swing.JLabel();
        alertaDetalle = new javax.swing.JLabel();
        panelHistorial = new javax.swing.JPanel();
        panelSalidas = new javax.swing.JPanel();
        jblHistorialSalidas = new javax.swing.JLabel();
        panelEntradas = new javax.swing.JPanel();
        jblHistorialEntradas = new javax.swing.JLabel();
        jblInformativo1 = new javax.swing.JLabel();
        panelComprobanteTransaccion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jblFechaPago = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jblMontoDebitado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jblRealizadoPor = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jblMontoAcreditado = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jblNumeroMonedero = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jblDestinatario = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jblMontoTransferencia = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jblDetalle = new javax.swing.JLabel();
        panelHistorialSalidas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabalSalidas = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        panelVerComprobanteS = new javax.swing.JPanel();
        jblVerComprobanteS = new javax.swing.JLabel();
        panelHistorialEntradas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEntradas = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        panelVerComprobanteE = new javax.swing.JPanel();
        jblVerComprobanteE = new javax.swing.JLabel();

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
        panelSimpeBarra.add(jblSimpe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 60));

        panelOpciones.add(panelSimpeBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 300, 60));

        background.add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 720));

        pizarra.setBackground(new java.awt.Color(204, 204, 204));
        pizarra.setForeground(new java.awt.Color(102, 102, 102));

        panelValidar.setBackground(new java.awt.Color(255, 255, 255));
        panelValidar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblClaveNum.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jblClaveNum.setForeground(new java.awt.Color(51, 51, 51));
        jblClaveNum.setText("CLAVE NUMERICA");
        panelValidar.add(jblClaveNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        txtClaveNum.setBackground(new java.awt.Color(255, 255, 255));
        txtClaveNum.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtClaveNum.setForeground(new java.awt.Color(204, 204, 204));
        txtClaveNum.setText("Ingrese su clave");
        txtClaveNum.setBorder(null);
        txtClaveNum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtClaveNumMousePressed(evt);
            }
        });
        txtClaveNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClaveNumKeyTyped(evt);
            }
        });
        panelValidar.add(txtClaveNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 350, 50));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        panelValidar.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 530, 10));

        jblPassword.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jblPassword.setForeground(new java.awt.Color(51, 51, 51));
        jblPassword.setText("PASSWORD");
        panelValidar.add(jblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

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
        panelValidar.add(psdPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 380, 60));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        panelValidar.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 530, 10));

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

        panelValidar.add(panelVerPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 40, 40));

        panelContinuar.setBackground(new java.awt.Color(92, 88, 29));
        panelContinuar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblContinuar.setBackground(new java.awt.Color(92, 88, 29));
        jblContinuar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jblContinuar.setForeground(new java.awt.Color(255, 255, 255));
        jblContinuar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblContinuar.setText("CONTINUAR");
        jblContinuar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblContinuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblContinuarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblContinuarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblContinuarMouseExited(evt);
            }
        });
        panelContinuar.add(jblContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 70));

        panelValidar.add(panelContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 530, 170, 70));

        alertaClave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alertaClave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/advertencia.png"))); // NOI18N
        panelValidar.add(alertaClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 40, 40));

        jblAlerta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblAlerta.setForeground(new java.awt.Color(255, 102, 102));
        jblAlerta.setText("Solo numeros");
        panelValidar.add(jblAlerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 185, 250, -1));

        jblOpcionActual.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jblOpcionActual.setForeground(new java.awt.Color(51, 51, 51));
        jblOpcionActual.setText("SIMPE");
        panelValidar.add(jblOpcionActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 130, 40));

        pizarra.addTab("Validar", panelValidar);

        panelElegir.setBackground(new java.awt.Color(255, 255, 255));
        panelElegir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblOpcionActual1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jblOpcionActual1.setForeground(new java.awt.Color(51, 51, 51));
        jblOpcionActual1.setText("SIMPE");
        panelElegir.add(jblOpcionActual1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 110, 40));

        panelRealizarSimpe.setBackground(new java.awt.Color(92, 88, 29));
        panelRealizarSimpe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblRealizarSimpe.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jblRealizarSimpe.setForeground(new java.awt.Color(255, 255, 255));
        jblRealizarSimpe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblRealizarSimpe.setText("Realizar simpe");
        jblRealizarSimpe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblRealizarSimpe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblRealizarSimpeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblRealizarSimpeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblRealizarSimpeMouseExited(evt);
            }
        });
        panelRealizarSimpe.add(jblRealizarSimpe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 70));

        panelElegir.add(panelRealizarSimpe, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 460, 70));

        panelHistoriaSimpes.setBackground(new java.awt.Color(92, 88, 29));
        panelHistoriaSimpes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblHistorialSimpe.setBackground(new java.awt.Color(0, 0, 0));
        jblHistorialSimpe.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jblHistorialSimpe.setForeground(new java.awt.Color(255, 255, 255));
        jblHistorialSimpe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblHistorialSimpe.setText("Ver historial simpes");
        jblHistorialSimpe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblHistorialSimpe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblHistorialSimpeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblHistorialSimpeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblHistorialSimpeMouseExited(evt);
            }
        });
        panelHistoriaSimpes.add(jblHistorialSimpe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 70));

        panelElegir.add(panelHistoriaSimpes, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 460, 70));

        jblInformativo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jblInformativo.setForeground(new java.awt.Color(51, 51, 51));
        jblInformativo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblInformativo.setText("Elige la accion que deseas realizar");
        panelElegir.add(jblInformativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 790, 60));

        pizarra.addTab("Elegir", panelElegir);

        panelSimpe.setBackground(new java.awt.Color(255, 255, 255));
        panelSimpe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numero.setFont(new java.awt.Font("Roboto", 1, 30)); // NOI18N
        numero.setForeground(new java.awt.Color(51, 51, 51));
        numero.setText("Numero de telefono");
        panelSimpe.add(numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 310, -1));

        txtNumeroSimpe.setBackground(new java.awt.Color(255, 255, 255));
        txtNumeroSimpe.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtNumeroSimpe.setForeground(new java.awt.Color(204, 204, 204));
        txtNumeroSimpe.setText("Ingrese el numero");
        txtNumeroSimpe.setBorder(null);
        txtNumeroSimpe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNumeroSimpeMousePressed(evt);
            }
        });
        txtNumeroSimpe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroSimpeKeyTyped(evt);
            }
        });
        panelSimpe.add(txtNumeroSimpe, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 340, 50));

        monto.setFont(new java.awt.Font("Roboto", 1, 29)); // NOI18N
        monto.setForeground(new java.awt.Color(51, 51, 51));
        monto.setText("Monto a transferir");
        panelSimpe.add(monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 280, -1));

        txtMontoTransferencia.setBackground(new java.awt.Color(255, 255, 255));
        txtMontoTransferencia.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtMontoTransferencia.setForeground(new java.awt.Color(204, 204, 204));
        txtMontoTransferencia.setText("Ingrese el monto");
        txtMontoTransferencia.setBorder(null);
        txtMontoTransferencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtMontoTransferenciaMousePressed(evt);
            }
        });
        txtMontoTransferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoTransferenciaKeyTyped(evt);
            }
        });
        panelSimpe.add(txtMontoTransferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 330, 50));

        cuenta.setFont(new java.awt.Font("Roboto", 1, 29)); // NOI18N
        cuenta.setForeground(new java.awt.Color(51, 51, 51));
        cuenta.setText("Cuenta a debitar:");
        panelSimpe.add(cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 260, -1));

        cbCuentaElegida.setBackground(new java.awt.Color(255, 255, 255));
        cbCuentaElegida.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        cbCuentaElegida.setForeground(new java.awt.Color(102, 102, 102));
        cbCuentaElegida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cuenta corriente", "Cuenta Ahorro", "Cuenta Simpe" }));
        cbCuentaElegida.setBorder(null);
        panelSimpe.add(cbCuentaElegida, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, 50));

        detalle.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        detalle.setForeground(new java.awt.Color(51, 51, 51));
        detalle.setText("Detalle");
        panelSimpe.add(detalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 130, -1));

        txtDetalle.setBackground(new java.awt.Color(255, 255, 255));
        txtDetalle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtDetalle.setForeground(new java.awt.Color(153, 153, 153));
        txtDetalle.setText("Ingrese el detalle");
        txtDetalle.setBorder(null);
        txtDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDetalleMousePressed(evt);
            }
        });
        txtDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDetalleKeyTyped(evt);
            }
        });
        panelSimpe.add(txtDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 690, 50));

        panelRealizar.setBackground(new java.awt.Color(92, 88, 29));
        panelRealizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblRealizar.setBackground(new java.awt.Color(92, 88, 29));
        jblRealizar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jblRealizar.setForeground(new java.awt.Color(255, 255, 255));
        jblRealizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblRealizar.setText("REALIZAR");
        jblRealizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblRealizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblRealizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblRealizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblRealizarMouseExited(evt);
            }
        });
        panelRealizar.add(jblRealizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 70));

        panelSimpe.add(panelRealizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 550, 170, 70));

        alertaNumero.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        alertaNumero.setForeground(new java.awt.Color(255, 102, 102));
        alertaNumero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/advertencia.png"))); // NOI18N
        panelSimpe.add(alertaNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        alertaMonto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        alertaMonto.setForeground(new java.awt.Color(255, 102, 102));
        alertaMonto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/advertencia.png"))); // NOI18N
        panelSimpe.add(alertaMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));

        alertaDetalle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        alertaDetalle.setForeground(new java.awt.Color(255, 102, 102));
        alertaDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/advertencia.png"))); // NOI18N
        panelSimpe.add(alertaDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        pizarra.addTab("tab3", panelSimpe);

        panelHistorial.setBackground(new java.awt.Color(255, 255, 255));
        panelHistorial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSalidas.setBackground(new java.awt.Color(92, 88, 29));
        panelSalidas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblHistorialSalidas.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jblHistorialSalidas.setForeground(new java.awt.Color(255, 255, 255));
        jblHistorialSalidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblHistorialSalidas.setText("Historial salidas");
        jblHistorialSalidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblHistorialSalidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblHistorialSalidasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblHistorialSalidasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblHistorialSalidasMouseExited(evt);
            }
        });
        panelSalidas.add(jblHistorialSalidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 70));

        panelHistorial.add(panelSalidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 460, 70));

        panelEntradas.setBackground(new java.awt.Color(92, 88, 29));
        panelEntradas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblHistorialEntradas.setBackground(new java.awt.Color(0, 0, 0));
        jblHistorialEntradas.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jblHistorialEntradas.setForeground(new java.awt.Color(255, 255, 255));
        jblHistorialEntradas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblHistorialEntradas.setText("Historial entradas");
        jblHistorialEntradas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblHistorialEntradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblHistorialEntradasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblHistorialEntradasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblHistorialEntradasMouseExited(evt);
            }
        });
        panelEntradas.add(jblHistorialEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 70));

        panelHistorial.add(panelEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 460, 70));

        jblInformativo1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jblInformativo1.setForeground(new java.awt.Color(51, 51, 51));
        jblInformativo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblInformativo1.setText("Elije el historial que deseas ver:");
        panelHistorial.add(jblInformativo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 790, 60));

        pizarra.addTab("tab4", panelHistorial);

        panelComprobanteTransaccion.setBackground(new java.awt.Color(255, 255, 255));
        panelComprobanteTransaccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Transferencia BNBUU SIMPE");
        panelComprobanteTransaccion.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 790, 40));

        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));
        panelComprobanteTransaccion.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 750, 10));

        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));
        panelComprobanteTransaccion.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 750, 10));

        jSeparator5.setForeground(new java.awt.Color(51, 51, 51));
        panelComprobanteTransaccion.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 750, 10));

        jSeparator6.setForeground(new java.awt.Color(51, 51, 51));
        panelComprobanteTransaccion.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 273, 750, 10));

        jSeparator7.setForeground(new java.awt.Color(51, 51, 51));
        panelComprobanteTransaccion.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 750, 10));

        jSeparator8.setForeground(new java.awt.Color(51, 51, 51));
        panelComprobanteTransaccion.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 750, 10));

        jSeparator9.setForeground(new java.awt.Color(51, 51, 51));
        panelComprobanteTransaccion.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 750, 10));

        jSeparator10.setForeground(new java.awt.Color(51, 51, 51));
        panelComprobanteTransaccion.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 750, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Fecha del pago:");
        panelComprobanteTransaccion.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 750, -1));

        jblFechaPago.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblFechaPago.setForeground(new java.awt.Color(51, 51, 51));
        jblFechaPago.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jblFechaPago.setText("dd-mm-yy  hh:mm:ss");
        panelComprobanteTransaccion.add(jblFechaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 750, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Monto debitado");
        panelComprobanteTransaccion.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 750, -1));

        jblMontoDebitado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblMontoDebitado.setForeground(new java.awt.Color(51, 51, 51));
        jblMontoDebitado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jblMontoDebitado.setText("000000000 Colones");
        panelComprobanteTransaccion.add(jblMontoDebitado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 750, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Realizado por:");
        panelComprobanteTransaccion.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 750, -1));

        jblRealizadoPor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblRealizadoPor.setForeground(new java.awt.Color(51, 51, 51));
        jblRealizadoPor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jblRealizadoPor.setText("Nombre");
        panelComprobanteTransaccion.add(jblRealizadoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 750, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Monto acreditado:");
        panelComprobanteTransaccion.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 750, -1));

        jblMontoAcreditado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblMontoAcreditado.setForeground(new java.awt.Color(51, 51, 51));
        jblMontoAcreditado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jblMontoAcreditado.setText("Monto acreditado");
        panelComprobanteTransaccion.add(jblMontoAcreditado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 750, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Numero de monedero:");
        panelComprobanteTransaccion.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 750, -1));

        jblNumeroMonedero.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblNumeroMonedero.setForeground(new java.awt.Color(51, 51, 51));
        jblNumeroMonedero.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jblNumeroMonedero.setText("000000000 Colones");
        panelComprobanteTransaccion.add(jblNumeroMonedero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 750, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Destinatario:");
        panelComprobanteTransaccion.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 750, -1));

        jblDestinatario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblDestinatario.setForeground(new java.awt.Color(51, 51, 51));
        jblDestinatario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jblDestinatario.setText("Destinatario");
        panelComprobanteTransaccion.add(jblDestinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 750, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Monto transferencia");
        panelComprobanteTransaccion.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 750, -1));

        jblMontoTransferencia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblMontoTransferencia.setForeground(new java.awt.Color(51, 51, 51));
        jblMontoTransferencia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jblMontoTransferencia.setText("000000000 Colones");
        panelComprobanteTransaccion.add(jblMontoTransferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 750, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Detalle:");
        panelComprobanteTransaccion.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, -1, -1));

        jblDetalle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jblDetalle.setForeground(new java.awt.Color(51, 51, 51));
        jblDetalle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jblDetalle.setText("Texto del detalle");
        panelComprobanteTransaccion.add(jblDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 750, -1));

        pizarra.addTab("tab5", panelComprobanteTransaccion);

        panelHistorialSalidas.setBackground(new java.awt.Color(255, 255, 255));
        panelHistorialSalidas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        tabalSalidas.setBackground(new java.awt.Color(204, 204, 204));
        tabalSalidas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabalSalidas.setForeground(new java.awt.Color(51, 51, 51));
        tabalSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabalSalidas);

        panelHistorialSalidas.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 730, 170));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Elige el comprobante que deseas ver:");
        panelHistorialSalidas.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 750, -1));

        panelVerComprobanteS.setBackground(new java.awt.Color(92, 88, 29));
        panelVerComprobanteS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblVerComprobanteS.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jblVerComprobanteS.setForeground(new java.awt.Color(255, 255, 255));
        jblVerComprobanteS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblVerComprobanteS.setText("VER");
        jblVerComprobanteS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblVerComprobanteS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblVerComprobanteSMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblVerComprobanteSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblVerComprobanteSMouseExited(evt);
            }
        });
        panelVerComprobanteS.add(jblVerComprobanteS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 70));

        panelHistorialSalidas.add(panelVerComprobanteS, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 220, 70));

        pizarra.addTab("tab6", panelHistorialSalidas);

        panelHistorialEntradas.setBackground(new java.awt.Color(255, 255, 255));
        panelHistorialEntradas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);

        tablaEntradas.setBackground(new java.awt.Color(204, 204, 204));
        tablaEntradas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaEntradas.setForeground(new java.awt.Color(51, 51, 51));
        tablaEntradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaEntradas);

        panelHistorialEntradas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 730, 170));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Elige el comprobante que deseas ver:");
        panelHistorialEntradas.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 750, -1));

        panelVerComprobanteE.setBackground(new java.awt.Color(92, 88, 29));
        panelVerComprobanteE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblVerComprobanteE.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jblVerComprobanteE.setForeground(new java.awt.Color(255, 255, 255));
        jblVerComprobanteE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblVerComprobanteE.setText("VER");
        jblVerComprobanteE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jblVerComprobanteE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblVerComprobanteEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jblVerComprobanteEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jblVerComprobanteEMouseExited(evt);
            }
        });
        panelVerComprobanteE.add(jblVerComprobanteE, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 70));

        panelHistorialEntradas.add(panelVerComprobanteE, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 220, 70));

        pizarra.addTab("tab7", panelHistorialEntradas);

        background.add(pizarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 790, 690));

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

    private void jblAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblAtrasMouseClicked
        switch (pizarra.getSelectedIndex()) {
            case 0 -> {
                PrincipalUsers users = new PrincipalUsers(this.cedula, this.sede);
                users.setVisible(true);
                panelVerSaldoBarra.setBackground(new Color(252, 247, 215));
                this.dispose();
            }
            case 1 -> {
                pizarra.setSelectedIndex(0);
                txtsPorDefecto();
            }
            case 2 -> {
                pizarra.setSelectedIndex(1);
            }
            case 3 -> {
                pizarra.setSelectedIndex(1);
            }
            case 4 -> {
                pizarra.setSelectedIndex(1);
            }
            case 5 -> {
                pizarra.setSelectedIndex(3);
            }
            case 6 -> {
                pizarra.setSelectedIndex(3);
            }
        }
    }//GEN-LAST:event_jblAtrasMouseClicked

    private void jblAtrasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblAtrasMouseEntered
        panelAtras.setBackground(new Color(245, 228, 120));
    }//GEN-LAST:event_jblAtrasMouseEntered

    private void jblAtrasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblAtrasMouseExited
        panelAtras.setBackground(new Color(210, 196, 103));
    }//GEN-LAST:event_jblAtrasMouseExited

    private void jblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblSalirMouseClicked
        Inicio ini = new Inicio();
        ini.setVisible(true);
        panelVerSaldoBarra.setBackground(new Color(252, 247, 215));
        this.dispose();
    }//GEN-LAST:event_jblSalirMouseClicked

    private void jblSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblSalirMouseEntered
        panelSalir.setBackground(new Color(255, 255, 218));
    }//GEN-LAST:event_jblSalirMouseEntered

    private void jblSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblSalirMouseExited
        panelSalir.setBackground(new Color(247, 240, 194));
    }//GEN-LAST:event_jblSalirMouseExited

    private void jblConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblConfigMouseClicked
        ConfigurarPerfil config = new ConfigurarPerfil(this.cedula, this.sede);
        config.setVisible(true);
        panelVerSaldoBarra.setBackground(new Color(252, 247, 215));
        this.dispose();
    }//GEN-LAST:event_jblConfigMouseClicked

    private void jblConfigMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblConfigMouseEntered
        panelConfig.setBackground(new Color(255, 255, 218));
    }//GEN-LAST:event_jblConfigMouseEntered

    private void jblConfigMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblConfigMouseExited
        panelConfig.setBackground(new Color(247, 240, 194));
    }//GEN-LAST:event_jblConfigMouseExited

    private void jblDepositarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblDepositarMouseClicked
        Depositar depositar = new Depositar(this.cedula, this.sede);
        depositar.setVisible(true);
        panelVerSaldoBarra.setBackground(new Color(252, 247, 215));
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
        panelVerSaldoBarra.setBackground(new Color(252, 247, 215));
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
        panelRetirarBarra.setBackground(new Color(252, 247, 215));
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
        panelVerSaldoBarra.setBackground(new Color(252, 247, 215));
        this.dispose();
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

    private void txtClaveNumMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtClaveNumMousePressed

        String psd = String.valueOf(psdPassword.getPassword());
        if (txtClaveNum.getText().equals("Ingrese su clave")) {
            txtClaveNum.setText("");
        }
        txtClaveNum.setForeground(Color.black);
        if (psd.equals("")) {
            psdPassword.setText("Ingrese su password");
        } else {
            psdPassword.setText(psd);
        }
        psdPassword.setForeground(new Color(155, 155, 155));
    }//GEN-LAST:event_txtClaveNumMousePressed

    private void txtClaveNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveNumKeyTyped
        char tecla = evt.getKeyChar();
        boolean teclaBorrar = true;
        if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
            teclaBorrar = false;
        }

        if (!Character.isDigit(tecla) && teclaBorrar == false) {

            evt.consume();
            alertaClave.setVisible(true);
            jblAlerta.setVisible(true);
            jblAlerta.setText("Solo numeros");

        } else if (txtClaveNum.getText().length() == 4) {
            evt.consume();
            jblAlerta.setText("Max numeros alcanzado");
            jblAlerta.setVisible(true);
            alertaClave.setVisible(true);
        } else {
            alertaClave.setVisible(false);
            jblAlerta.setVisible(false);
        }
    }//GEN-LAST:event_txtClaveNumKeyTyped

    private void psdPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_psdPasswordMousePressed

        String user = txtClaveNum.getText();
        if (String.valueOf(psdPassword.getPassword()).equals("Ingrese su password")) {
            psdPassword.setText("");
        }
        psdPassword.setForeground(Color.black);
        if (user.equals("")) {
            txtClaveNum.setText("Ingrese su clave");
        } else {
            txtClaveNum.setText(user);
        }
        txtClaveNum.setForeground(new Color(155, 155, 155));
    }//GEN-LAST:event_psdPasswordMousePressed

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

    private void jblContinuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblContinuarMouseClicked
        try {
            for (Usuarios i : SedeCentral.ListaUsers) {
                if (i.getCedula().equals(this.cedula)) {
                    if (Integer.parseInt(txtClaveNum.getText()) == i.getClaveNumerica() && String.valueOf(psdPassword.getPassword()).equals(i.getPassword())) {
                        JOptionPane.showMessageDialog(null, "Datos correctos");
                        pizarra.setSelectedIndex(1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos incorrectos");
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Rellena todos los espacios");
        }
    }//GEN-LAST:event_jblContinuarMouseClicked

    private void jblContinuarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblContinuarMouseEntered
        panelContinuar.setBackground(new Color(153, 145, 86));
        jblContinuar.setForeground(Color.black);
    }//GEN-LAST:event_jblContinuarMouseEntered

    private void jblContinuarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblContinuarMouseExited
        panelContinuar.setBackground(new Color(92, 88, 29));
        jblContinuar.setForeground(Color.white);
    }//GEN-LAST:event_jblContinuarMouseExited

    private void jblRealizarSimpeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblRealizarSimpeMouseExited
        panelRealizarSimpe.setBackground(new Color(92, 88, 29));
        jblRealizarSimpe.setForeground(Color.white);
    }//GEN-LAST:event_jblRealizarSimpeMouseExited

    private void jblRealizarSimpeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblRealizarSimpeMouseEntered
        panelRealizarSimpe.setBackground(new Color(153, 145, 86));
        jblRealizarSimpe.setForeground(Color.black);
    }//GEN-LAST:event_jblRealizarSimpeMouseEntered

    private void jblRealizarSimpeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblRealizarSimpeMouseClicked
        pizarra.setSelectedIndex(2);
        txtsRealizarSimpePorDefecto();
    }//GEN-LAST:event_jblRealizarSimpeMouseClicked

    private void jblHistorialSimpeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblHistorialSimpeMouseExited
        panelHistoriaSimpes.setBackground(new Color(92, 88, 29));
        jblHistorialSimpe.setForeground(Color.white);
    }//GEN-LAST:event_jblHistorialSimpeMouseExited

    private void jblHistorialSimpeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblHistorialSimpeMouseEntered
        panelHistoriaSimpes.setBackground(new Color(153, 145, 86));
        jblHistorialSimpe.setForeground(Color.black);
    }//GEN-LAST:event_jblHistorialSimpeMouseEntered

    private void jblHistorialSimpeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblHistorialSimpeMouseClicked
        pizarra.setSelectedIndex(3);
    }//GEN-LAST:event_jblHistorialSimpeMouseClicked

    private void txtNumeroSimpeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNumeroSimpeMousePressed
        txtsSetPredeterminatedText("numero");
        alertaNumero.setVisible(false);
        if (txtNumeroSimpe.getText().equals("Ingrese el numero")) {
            txtNumeroSimpe.setText("");
        }
        txtNumeroSimpe.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_txtNumeroSimpeMousePressed

    private void txtMontoTransferenciaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMontoTransferenciaMousePressed
        txtsSetPredeterminatedText("monto");
        alertaMonto.setVisible(false);
        if (txtMontoTransferencia.getText().equals("Ingrese el monto")) {
            txtMontoTransferencia.setText("");
        }
        txtMontoTransferencia.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_txtMontoTransferenciaMousePressed

    private void txtDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDetalleMousePressed
        txtsSetPredeterminatedText("detalle");
        if (txtDetalle.getText().equals("Ingrese el detalle")) {
            txtDetalle.setText("");
        }
        txtDetalle.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_txtDetalleMousePressed

    private void jblRealizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblRealizarMouseClicked
        validarDatosSimpe();

        if (this.numeroValido == true && this.montoValido == true && this.cuentaValida == true) {
            int eleccion = JOptionPane.showConfirmDialog(null, "Deseas realizar el simpe?", "SIMPE", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (eleccion == 0) {
                Double monto = Double.parseDouble(txtMontoTransferencia.getText());
                String numeroEmisor = "";
                String numeroReceptor = "";
                String cuentaUtiizada = "";
                String detalle = txtDetalle.getText();

                LocalTime hora = LocalTime.now();
                DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
                String horaFormateada = hora.format(formatoHora);

                LocalDate fecha = LocalDate.now();
                DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String fechaFormateada = fecha.format(formatoFecha);

                for (Usuarios i : SedeCentral.getListaUsers()) {
                    if (i.getCedula().equals(this.cedula)) {
                        numeroEmisor = i.getTelefono();

                        //Reduce el monto a la cuenta elegida
                        switch (cbCuentaElegida.getSelectedIndex()) {
                            case 0 -> {
                                i.getCuentaCorriente().retirarDinero(monto);
                                cuentaUtiizada = "Cuenta corriente";
                            }
                            case 1 -> {
                                i.getCuentaAhorro().retirarDinero(monto);
                                cuentaUtiizada = "Cuenta ahorro";
                            }
                            case 2 -> {
                                i.getCuentaSimpe().retirarDinero(monto);
                                cuentaUtiizada = "Cuenta simpe";
                            }
                        }
                    }
                    //Le suma el monto a la cuenta simpe de destino
                    if (i.getTelefono().equals(txtNumeroSimpe.getText())) {
                        numeroReceptor = txtNumeroSimpe.getText();
                        i.getCuentaSimpe().depositarDinero(monto);
                    }
                }
                ComprobanteSimpeSalida compSal = new ComprobanteSimpeSalida(numeroEmisor, numeroReceptor, cuentaUtiizada, monto, fechaFormateada, horaFormateada, detalle);
                ComprobanteSimpeEntrada compEnt = new ComprobanteSimpeEntrada(numeroEmisor, numeroReceptor, cuentaUtiizada, monto, fechaFormateada, horaFormateada, detalle);

                for (Usuarios i : SedeCentral.getListaUsers()) {
                    if (i.getCedula().equals(this.cedula)) {
                        i.getComprobantesSimpeSalida().add(compSal);
                    }

                    if (i.getTelefono().equals(compSal.getNumeroReceptor())) {
                        i.getComprobantesSimpeEntrada().add(compEnt);
                    }
                }
                
                try {
                    //Agregar comprobantes base datos
                    BaseDatos.agregarComprobanteSalidaTxt(String.valueOf(compSal.getMonto()), compSal.getFecha(), compSal.getHora(), compSal.getNumeroEmisor(), compSal.getNumeroReceptor(), compSal.getCuentaUtilizada(), compSal.getDetalle());
                    BaseDatos.agregarComprobanteEntradaTxt(String.valueOf(compEnt.getMonto()), compEnt.getFecha(), compEnt.getHora(), compEnt.getNumeroEmisor(), compEnt.getNumeroReceptor(), compEnt.getCuentaUtilizada(), compEnt.getDetalle());
                    BaseDatos.actualizarUsuariosBaseDatos();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error cargando comprobantes a base de datos");
                }
                JOptionPane.showMessageDialog(null, "Simpe Realizado con exito");
                pizarra.setSelectedIndex(4);
                txtsPorDefecto();
                setTextosMuestraComprobanteSalida(compSal);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error, verifica los datos ingresados");
        }

    }//GEN-LAST:event_jblRealizarMouseClicked

    private void jblRealizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblRealizarMouseEntered
        panelContinuar.setBackground(new Color(153, 145, 86));
        jblContinuar.setForeground(Color.black);
    }//GEN-LAST:event_jblRealizarMouseEntered

    private void jblRealizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblRealizarMouseExited
        panelContinuar.setBackground(new Color(92, 88, 29));
        jblContinuar.setForeground(Color.white);
    }//GEN-LAST:event_jblRealizarMouseExited

    private void txtNumeroSimpeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroSimpeKeyTyped
        char tecla = evt.getKeyChar();
        boolean teclaBorrar = true;
        if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
            teclaBorrar = false;
        }

        if (!Character.isDigit(tecla) && teclaBorrar == false) {
            evt.consume();
            alertaNumero.setVisible(true);
            alertaNumero.setText("Debe ser un numero");
        } else if ((txtNumeroSimpe.getText() + evt.getKeyChar()).length() > 8) {
            evt.consume();
            alertaNumero.setVisible(true);
            alertaNumero.setText("Max digitos alcanzado");
        } else {
            alertaNumero.setVisible(false);
        }


    }//GEN-LAST:event_txtNumeroSimpeKeyTyped

    private void txtMontoTransferenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoTransferenciaKeyTyped
        char tecla = evt.getKeyChar();
        boolean teclaBorrar = true;
        if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
            teclaBorrar = false;
        }

        if (!Character.isDigit(tecla) && teclaBorrar == false) {
            evt.consume();
            alertaMonto.setVisible(true);
            alertaMonto.setText("Debe ser un numero");
        } else if ((txtMontoTransferencia.getText() + evt.getKeyChar()).length() > 10) {
            evt.consume();
            alertaMonto.setVisible(true);
            alertaMonto.setText("Max digitos alcanzado");
        } else if (Double.parseDouble(txtMontoTransferencia.getText() + tecla) > 10000000) {
            evt.consume();
            alertaMonto.setVisible(true);
            alertaMonto.setText("Monto max 10.000.000");
        } else {
            alertaMonto.setVisible(false);
        }

    }//GEN-LAST:event_txtMontoTransferenciaKeyTyped

    private void txtDetalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDetalleKeyTyped
        if ((txtDetalle.getText() + evt.getKeyChar()).length() > 50) {
            evt.consume();
            alertaDetalle.setVisible(true);
            alertaDetalle.setText("Max digitos alcanzado");
        }
    }//GEN-LAST:event_txtDetalleKeyTyped


    private void jblHistorialSalidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblHistorialSalidasMouseClicked
        pizarra.setSelectedIndex(5);
        llenarTablaSalida();
    }//GEN-LAST:event_jblHistorialSalidasMouseClicked

    private void jblHistorialSalidasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblHistorialSalidasMouseEntered
        panelSalidas.setBackground(new Color(153, 145, 86));
        jblHistorialSalidas.setForeground(Color.black);
    }//GEN-LAST:event_jblHistorialSalidasMouseEntered

    private void jblHistorialSalidasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblHistorialSalidasMouseExited
        panelSalidas.setBackground(new Color(92, 88, 29));
        jblHistorialSalidas.setForeground(Color.white);
    }//GEN-LAST:event_jblHistorialSalidasMouseExited

    private void jblHistorialEntradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblHistorialEntradasMouseClicked
        pizarra.setSelectedIndex(6);
        llenarTablaEntrada();
    }//GEN-LAST:event_jblHistorialEntradasMouseClicked

    private void jblHistorialEntradasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblHistorialEntradasMouseEntered
        panelEntradas.setBackground(new Color(153, 145, 86));
        jblHistorialEntradas.setForeground(Color.black);
    }//GEN-LAST:event_jblHistorialEntradasMouseEntered

    private void jblHistorialEntradasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblHistorialEntradasMouseExited
        panelEntradas.setBackground(new Color(92, 88, 29));
        jblHistorialEntradas.setForeground(Color.white);
    }//GEN-LAST:event_jblHistorialEntradasMouseExited

    private void jblVerComprobanteSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerComprobanteSMouseClicked
        if (tabalSalidas.getRowCount() > 0) {

            boolean filaElegida = false;
            int c = 0;
            try {
                c = tabalSalidas.getSelectedRow();
                if (c >= 0) {
                    filaElegida = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Error, selecciona un comprobante");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error, verifica la eleccion");
            }

            if (filaElegida == true) {
                pizarra.setSelectedIndex(4);
                for (Usuarios i : SedeCentral.getListaUsers()) {
                    if (i.getCedula().equals(this.cedula)) {
                        setTextosMuestraComprobanteSalida(i.getComprobantesSimpeSalida().get(c));
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay simpes registrados");
        }
    }//GEN-LAST:event_jblVerComprobanteSMouseClicked

    private void jblVerComprobanteSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerComprobanteSMouseEntered
        panelVerComprobanteS.setBackground(new Color(153, 145, 86));
        jblVerComprobanteS.setForeground(Color.black);
    }//GEN-LAST:event_jblVerComprobanteSMouseEntered

    private void jblVerComprobanteSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerComprobanteSMouseExited
        panelVerComprobanteS.setBackground(new Color(92, 88, 29));
        jblVerComprobanteS.setForeground(Color.white);
    }//GEN-LAST:event_jblVerComprobanteSMouseExited

    private void jblVerComprobanteEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerComprobanteEMouseClicked
        if (tablaEntradas.getRowCount() > 0) {

            boolean filaElegida = false;
            int c = 0;
            try {
                c = tablaEntradas.getSelectedRow();
                if (c >= 0) {
                    filaElegida = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Error, selecciona un comprobante");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error, verifica la eleccion");
            }

            if (filaElegida == true) {
                pizarra.setSelectedIndex(4);
                for (Usuarios i : SedeCentral.getListaUsers()) {
                    if (i.getCedula().equals(this.cedula)) {
                        setTextosMuestraComprobanteEntrada(i.getComprobantesSimpeEntrada().get(c));
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay simpes registrados");
        }
    }//GEN-LAST:event_jblVerComprobanteEMouseClicked

    private void jblVerComprobanteEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerComprobanteEMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jblVerComprobanteEMouseEntered

    private void jblVerComprobanteEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblVerComprobanteEMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jblVerComprobanteEMouseExited

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
            java.util.logging.Logger.getLogger(Simpe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simpe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simpe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simpe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simpe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertaClave;
    private javax.swing.JLabel alertaDetalle;
    private javax.swing.JLabel alertaMonto;
    private javax.swing.JLabel alertaNumero;
    private javax.swing.JPanel background;
    private javax.swing.JComboBox<String> cbCuentaElegida;
    private javax.swing.JLabel cuenta;
    private javax.swing.JLabel detalle;
    private javax.swing.JLabel iconBarra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel jblAlerta;
    private javax.swing.JLabel jblAtras;
    private javax.swing.JLabel jblBarra;
    private javax.swing.JLabel jblClaveNum;
    private javax.swing.JLabel jblComentarios;
    private javax.swing.JLabel jblConfig;
    private javax.swing.JLabel jblContinuar;
    private javax.swing.JLabel jblDashboard;
    private javax.swing.JLabel jblDepositar;
    private javax.swing.JLabel jblDestinatario;
    private javax.swing.JLabel jblDetalle;
    private javax.swing.JLabel jblFechaPago;
    private javax.swing.JLabel jblFondoPerfil;
    private javax.swing.JLabel jblHabilitarCuentas;
    private javax.swing.JLabel jblHistorialEntradas;
    private javax.swing.JLabel jblHistorialSalidas;
    private javax.swing.JLabel jblHistorialSimpe;
    private javax.swing.JLabel jblInformativo;
    private javax.swing.JLabel jblInformativo1;
    private javax.swing.JLabel jblMontoAcreditado;
    private javax.swing.JLabel jblMontoDebitado;
    private javax.swing.JLabel jblMontoTransferencia;
    private javax.swing.JLabel jblNombreBanco;
    private javax.swing.JLabel jblNombrePerfil;
    private javax.swing.JLabel jblNumeroMonedero;
    private javax.swing.JLabel jblOpcionActual;
    private javax.swing.JLabel jblOpcionActual1;
    private javax.swing.JLabel jblPassword;
    private javax.swing.JLabel jblPerfil;
    private javax.swing.JLabel jblRealizadoPor;
    private javax.swing.JLabel jblRealizar;
    private javax.swing.JLabel jblRealizarSimpe;
    private javax.swing.JLabel jblRetirar;
    private javax.swing.JLabel jblSalir;
    private javax.swing.JLabel jblSimpe;
    private javax.swing.JLabel jblVentanaActual;
    private javax.swing.JLabel jblVerComprobanteE;
    private javax.swing.JLabel jblVerComprobanteS;
    private javax.swing.JLabel jblVerPassword;
    private javax.swing.JLabel monto;
    private javax.swing.JLabel numero;
    private javax.swing.JPanel panelAtras;
    private javax.swing.JPanel panelComentariosBarra;
    private javax.swing.JPanel panelComprobanteTransaccion;
    private javax.swing.JPanel panelConfig;
    private javax.swing.JPanel panelContinuar;
    private javax.swing.JPanel panelDashboardBarra;
    private javax.swing.JPanel panelDepositarBarra;
    private javax.swing.JPanel panelElegir;
    private javax.swing.JPanel panelEntradas;
    private javax.swing.JPanel panelHabilitarCuentasBarra;
    private javax.swing.JPanel panelHistoriaSimpes;
    private javax.swing.JPanel panelHistorial;
    private javax.swing.JPanel panelHistorialEntradas;
    private javax.swing.JPanel panelHistorialSalidas;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelRealizar;
    private javax.swing.JPanel panelRealizarSimpe;
    private javax.swing.JPanel panelRetirarBarra;
    private javax.swing.JPanel panelSalidas;
    private javax.swing.JPanel panelSalir;
    private javax.swing.JPanel panelSimpe;
    private javax.swing.JPanel panelSimpeBarra;
    private javax.swing.JPanel panelValidar;
    private javax.swing.JPanel panelVerComprobanteE;
    private javax.swing.JPanel panelVerComprobanteS;
    private javax.swing.JPanel panelVerPassword;
    private javax.swing.JPanel panelVerSaldoBarra;
    private javax.swing.JTabbedPane pizarra;
    private javax.swing.JPasswordField psdPassword;
    private javax.swing.JTable tabalSalidas;
    private javax.swing.JTable tablaEntradas;
    private javax.swing.JTextField txtClaveNum;
    private javax.swing.JTextField txtDetalle;
    private javax.swing.JTextField txtMontoTransferencia;
    private javax.swing.JTextField txtNumeroSimpe;
    // End of variables declaration//GEN-END:variables
}
