package Personas;

import Comentarios.Comentario;
import Comprobantes.ComprobanteSimpeEntrada;
import Comprobantes.ComprobanteSimpeSalida;
import Cuentas.CuentaAhorro;
import Cuentas.CuentaCorriente;
import Cuentas.CuentaSimpe;
import java.util.ArrayList;

public class Usuarios extends Personas {

    private boolean estadoUsuario = true;
    private boolean estadoCuenta = true;
    private Comentario comentario;
    private CuentaCorriente cuentaCorriente = new CuentaCorriente(0, true);
    private CuentaAhorro cuentaAhorro = new CuentaAhorro(0, false);
    private CuentaSimpe cuentaSimpe = new CuentaSimpe(0, false);
    private ArrayList<ComprobanteSimpeSalida> comprobantesSimpeSalida = new ArrayList<>();
    private ArrayList<ComprobanteSimpeEntrada> comprobantesSimpeEntrada = new ArrayList<>();

    public Usuarios(String usuario, String apellidos, String password, String cedula, String telefono, int claveNumerica, int rol, int sede,
            double saldoDeLaCuenta, double saldoCuentaSimpe, double saldoCuentaAhorro) {

        super(usuario, apellidos, password, cedula, telefono, claveNumerica, rol, sede);
    }
    
    public Usuarios(){
        
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public CuentaAhorro getCuentaAhorro() {
        return cuentaAhorro;
    }

    public void setCuentaAhorro(CuentaAhorro cuentaAhorro) {
        this.cuentaAhorro = cuentaAhorro;
    }

    public CuentaSimpe getCuentaSimpe() {
        return cuentaSimpe;
    }

    public void setCuentaSimpe(CuentaSimpe cuentaSimpe) {
        this.cuentaSimpe = cuentaSimpe;
    }

    public ArrayList<ComprobanteSimpeSalida> getComprobantesSimpeSalida() {
        return comprobantesSimpeSalida;
    }

    public void setComprobantesSimpeSalida(ArrayList<ComprobanteSimpeSalida> comprobantesSimpeSalida) {
        this.comprobantesSimpeSalida = comprobantesSimpeSalida;
    }

    public ArrayList<ComprobanteSimpeEntrada> getComprobantesSimpeEntrada() {
        return comprobantesSimpeEntrada;
    }

    public void setComprobantesSimpeEntrada(ArrayList<ComprobanteSimpeEntrada> comprobantesSimpeEntrada) {
        this.comprobantesSimpeEntrada = comprobantesSimpeEntrada;
    }

    public boolean getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public boolean getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(boolean estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
    
    
}
