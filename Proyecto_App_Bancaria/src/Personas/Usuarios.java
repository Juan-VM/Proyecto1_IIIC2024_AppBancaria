package Personas;

import Cuentas.CuentaAhorro;
import Cuentas.CuentaCorriente;
import Cuentas.CuentaSimpe;

public class Usuarios extends Personas {

    private CuentaCorriente cuentaCorriente = new CuentaCorriente(0, false);
    private CuentaAhorro cuentaAhorro = new CuentaAhorro(0, false);
    private CuentaSimpe cuentaSimpe = new CuentaSimpe(0, false);

    public Usuarios(String usuario, String apellidos, String password, String cedula, String telefono, int claveNumerica, int rol, int sede, double saldoDeLaCuenta, double saldoCuentaSimpe, double saldoCuentaAhorro) {

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

}
