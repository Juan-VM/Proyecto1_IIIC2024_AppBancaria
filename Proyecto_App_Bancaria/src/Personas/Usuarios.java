package Personas;

import ClasesProyecto.Personas;
import java.util.ArrayList;

public class Usuarios extends Personas {

    private double saldoDeLaCuenta;
    private double saldoCuentaSimpe;
    private double saldoCuentaAhorro;
    private boolean estadoCuentaSimpe;
    private boolean estadoCuentaAhorro;
    private ArrayList<String> comprobantesSimpe = new ArrayList<>();
    String comentario;

    public Usuarios(String usuario, String apellidos, String password, String cedula, String telefono, int claveNumerica, int rol, String sede, double saldoDeLaCuenta, double saldoCuentaSimpe, double saldoCuentaAhorro) {

        super(usuario, apellidos, password, cedula, telefono, claveNumerica, rol, sede);
        this.saldoDeLaCuenta = saldoDeLaCuenta;
        this.saldoCuentaAhorro = saldoCuentaAhorro;
        this.saldoCuentaSimpe = saldoCuentaSimpe;

    }

    public double getSaldoDeLaCuenta() {
        return saldoDeLaCuenta;
    }

    public void setSaldoDeLaCuenta(double saldoDeLaCuenta) {
        this.saldoDeLaCuenta = saldoDeLaCuenta;
    }

    public double getSaldoCuentaSimpe() {
        return saldoCuentaSimpe;
    }

    public void setSaldoCuentaSimpe(double saldoCuentaSimpe) {
        this.saldoCuentaSimpe = saldoCuentaSimpe;
    }

    public double getSaldoCuentaAhorro() {
        return saldoCuentaAhorro;
    }

    public void setSaldoCuentaAhorro(double saldoCuentaAhorro) {
        this.saldoCuentaAhorro = saldoCuentaAhorro;
    }

    public boolean getEstadoCuentaSimpe() {
        return estadoCuentaSimpe;
    }

    public void setEstadoCuentaSimpe(boolean estadoCuentaSimpe) {
        this.estadoCuentaSimpe = estadoCuentaSimpe;
    }

    public boolean getEstadoCuentaAhorro() {
        return estadoCuentaAhorro;
    }

    public void setEstadoCuentaAhorro(boolean estadoCuentaAhorro) {
        this.estadoCuentaAhorro = estadoCuentaAhorro;
    }

    public void retirarDinero(double cantidad, String cuentaDestino) {  //Resta a saldoDeLaCuenta una cantidad ingresada.

        switch (cuentaDestino) {
            case "1" -> {
                saldoDeLaCuenta -= cantidad;
            }
            case "2" -> {
                saldoCuentaAhorro -= cantidad;
            }
            case "3" -> {
                saldoCuentaSimpe -= cantidad;
            }
        }
    }

    public void depositarDinero(double cantidad, String cuentaDestino) {  //Suma a saldoDeLaCuenta una cantidad ingresada.

        switch (cuentaDestino) {
            case "1" -> {
                saldoDeLaCuenta += cantidad;
            }
            case "2" -> {
                saldoCuentaAhorro += cantidad;
            }
            case "3" -> {
                saldoCuentaSimpe += cantidad;
            }
        }
    }
    
    public void mostarHistorial(){
        for(String i : comprobantesSimpe){
            System.out.println(i);
        }
    }
    
    public void addComprobantesSimpe(String comprobante){
        comprobantesSimpe.add(comprobante);
    }
}
