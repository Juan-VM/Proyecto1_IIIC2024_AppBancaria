package RegistroDatos;

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

    public static File archivo = new File("Datos.txt");

    public static void verfificarExistenciaArchivo() {
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "A ocorrido un error");
        }
    }

    public static void llenarTxtUser(String usuario, String apellido, String cedula, String telefono, String password, String claveNum, String rol, String sede,
            String saldoC, String saldoA, String saldoS, String estadoC, String estadoA, String estadoS, String estadoUser, String estadoCuenta) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        BufferedWriter escribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true), "utf-8"));

        escribir.write(usuario + "\t" + apellido + "\t" + cedula + "\t" + telefono + "\t" + password + "\t" + claveNum + "\t" + rol + "\t" + sede + "\t"
                + saldoC + "\t" + saldoA + "\t" + saldoS + "\t" + estadoC + "\t" + estadoA + "\t" + estadoS + "\t" + estadoUser + "\t" + estadoCuenta + "\n");

        escribir.close();
    }

    public static void llenarTxtAdmin(String usuario, String apellido, String cedula, String telefono, String password, String claveNum, String rol, String sede) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        BufferedWriter escribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true), "utf-8"));

        escribir.write(usuario + "\t" + apellido + "\t" + cedula + "\t" + telefono + "\t" + password + "\t" + claveNum + "\t" + rol + "\t" + sede + "\n");

        escribir.close();
    }

    public static void limpiarArchivo() throws IOException {
        if (archivo.exists()) {
            FileWriter escribir = new FileWriter(archivo, false);
            escribir.write("");
            escribir.close();
        }
    }
    
    public static void actualizarBaseDatos() throws IOException{
        limpiarArchivo();
        
        for(Usuarios i : SedeCentral.getListaUsers()){
            llenarTxtUser(i.getUsuario(), i.getApellidos(), i.getCedula(), i.getTelefono(), i.getPassword(), String.valueOf(i.getClaveNumerica()),
                    String.valueOf(i.getRol()), String.valueOf(i.getSede()), 
                    String.valueOf(i.getCuentaCorriente().getSaldo()), String.valueOf(i.getCuentaAhorro().getSaldo()), String.valueOf(i.getCuentaSimpe().getSaldo()),
                    String.valueOf(i.getCuentaCorriente().getEstado()), String.valueOf(i.getCuentaAhorro().getEstado()), String.valueOf(i.getCuentaSimpe().getEstado()),
                    String.valueOf(i.getEstadoUsuario()), String.valueOf(i.getEstadoCuenta()));
        }
        for(Administradores o : SedeCentral.getListaAdmins()){
            llenarTxtAdmin(o.getUsuario(), o.getApellidos(), o.getCedula(), o.getTelefono(), o.getPassword(), String.valueOf(o.getClaveNumerica()),
                    String.valueOf(o.getRol()), String.valueOf(o.getSede()));
        }
    }

    public static File getArchivo() {
        return archivo;
    }

    public static void setArchivo(File archivo) {
        BaseDatos.archivo = archivo;
    }

}
