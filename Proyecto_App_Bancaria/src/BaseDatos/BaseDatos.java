package BaseDatos;

import Personas.Administradores;
import Personas.Usuarios;
import Sedes.SedeCentral;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import javax.swing.JOptionPane;

public class BaseDatos {

    public static File usuariosTxt = new File("usuariosTxt.txt");
    public static File administradoresTxt = new File("administradoresTxt.txt");
    public static File simpesSalidaTxt = new File("simpesSalidaTxt.txt");
    public static File simpesEntradaTxt = new File("simpesEntradaTxt.txt");

    public static void verfificarExistenciaUsuariosTxT() {
        try {
            if (!usuariosTxt.exists()) {
                usuariosTxt.createNewFile();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "A ocorrido un error");
        }
    }

    public static void verfificarExistenciaAdministradoresTxT() {
        try {
            if (!administradoresTxt.exists()) {
                administradoresTxt.createNewFile();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "A ocorrido un error");
        }
    }

    public static void verfificarExistenciaSimpesSalidaTxt() {
        try {
            if (!simpesSalidaTxt.exists()) {
                simpesSalidaTxt.createNewFile();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "A ocorrido un error");
        }
    }

    public static void verfificarExistenciaSimpesEntradaTxt() {
        try {
            if (!simpesEntradaTxt.exists()) {
                simpesEntradaTxt.createNewFile();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "A ocorrido un error");
        }
    }

    public static void agregarUsuarioTxt(String usuario, String apellido, String cedula, String telefono, String password, String claveNum, String rol, String sede,
            String saldoC, String saldoA, String saldoS, String estadoC, String estadoA, String estadoS, String estadoUser, String estadoCuenta) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        BufferedWriter escribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(usuariosTxt, true), "utf-8"));

        escribir.write(usuario + "\t" + apellido + "\t" + cedula + "\t" + telefono + "\t" + password + "\t" + claveNum + "\t" + rol + "\t" + sede + "\t"
                + saldoC + "\t" + saldoA + "\t" + saldoS + "\t" + estadoC + "\t" + estadoA + "\t" + estadoS + "\t" + estadoUser + "\t" + estadoCuenta + "\n");

        escribir.close();
    }

    public static void agregarAdminTxt(String usuario, String apellido, String cedula, String telefono, String password, String claveNum, String rol, String sede) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        BufferedWriter escribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(administradoresTxt, true), "utf-8"));

        escribir.write(usuario + "\t" + apellido + "\t" + cedula + "\t" + telefono + "\t" + password + "\t" + claveNum + "\t" + rol + "\t" + sede + "\n");

        escribir.close();
    }

    public static void agregarComprobanteSalida(String monto, String fecha, String hora, String numeroEmisor, String numeroReceptor, String cuentaUtilizada, String detalle) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        BufferedWriter escribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(simpesSalidaTxt, true), "utf-8"));

        escribir.write(monto + "\t" + fecha + "\t" + hora + "\t" + numeroEmisor + "\t" + numeroReceptor + "\t" + cuentaUtilizada + "\t" + detalle + "\n");

        escribir.close();
    }

    public static void agregarComprobanteEntrada(String monto, String fecha, String hora, String numeroEmisor, String numeroReceptor, String cuentaUtilizada, String detalle) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        BufferedWriter escribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(simpesEntradaTxt, true), "utf-8"));

        escribir.write(monto + "\t" + fecha + "\t" + hora + "\t" + numeroEmisor + "\t" + numeroReceptor + "\t" + cuentaUtilizada + "\t" + detalle + "\n");

        escribir.close();
    }

    public static void actualizarUsuariosBaseDatos() throws IOException {
        limpiarTxtUsuarios();
        for (Usuarios i : SedeCentral.getListaUsers()) {
            agregarUsuarioTxt(i.getUsuario(), i.getApellidos(), i.getCedula(), i.getTelefono(), i.getPassword(), String.valueOf(i.getClaveNumerica()),
                    String.valueOf(i.getRol()), String.valueOf(i.getSede()),
                    String.valueOf(i.getCuentaCorriente().getSaldo()), String.valueOf(i.getCuentaAhorro().getSaldo()), String.valueOf(i.getCuentaSimpe().getSaldo()),
                    String.valueOf(i.getCuentaCorriente().getEstado()), String.valueOf(i.getCuentaAhorro().getEstado()), String.valueOf(i.getCuentaSimpe().getEstado()),
                    String.valueOf(i.getEstadoUsuario()), String.valueOf(i.getEstadoCuenta()));
        }
    }

    public static void actualizarAdministradoresBaseDatos() throws IOException {
        limpiarTxtAdministradores();
        for (Administradores o : SedeCentral.getListaAdmins()) {
            agregarAdminTxt(o.getUsuario(), o.getApellidos(), o.getCedula(), o.getTelefono(), o.getPassword(), String.valueOf(o.getClaveNumerica()),
                    String.valueOf(o.getRol()), String.valueOf(o.getSede()));
        }
    }

    public static void limpiarTxtUsuarios() throws IOException {
        if (usuariosTxt.exists()) {
            FileWriter escribir = new FileWriter(usuariosTxt, false);
            escribir.write("");
            escribir.close();
        }
    }

    public static void limpiarTxtAdministradores() throws IOException {
        if (administradoresTxt.exists()) {
            FileWriter escribir = new FileWriter(administradoresTxt, false);
            escribir.write("");
            escribir.close();
        }
    }

    public static File getUsuariosTxt() {
        return usuariosTxt;
    }

    public static void setUsuariosTxt(File usuariosTxt) {
        BaseDatos.usuariosTxt = usuariosTxt;
    }

    public static File getAdministradoresTxt() {
        return administradoresTxt;
    }

    public static void setAdministradoresTxt(File administradoresTxt) {
        BaseDatos.administradoresTxt = administradoresTxt;
    }

    public static File getSimpesSalidaTxt() {
        return simpesSalidaTxt;
    }

    public static void setSimpesSalidaTxt(File simpesSalidaTxt) {
        BaseDatos.simpesSalidaTxt = simpesSalidaTxt;
    }

    public static File getSimpesEntradaTxt() {
        return simpesEntradaTxt;
    }

    public static void setSimpesEntradaTxt(File simpesEntradaTxt) {
        BaseDatos.simpesEntradaTxt = simpesEntradaTxt;
    }
    
    
}