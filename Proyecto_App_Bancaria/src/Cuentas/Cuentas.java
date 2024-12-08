
package Cuentas;

import java.util.ArrayList;


public class Cuentas {
    private double saldo;
    private boolean estado;

    public Cuentas(){
        
    }

    public Cuentas(boolean estado) {
        this.estado = estado;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public void depositarDinero(double cantidadDeposito) {  //Suma a saldoDeLaCuenta una cantidad ingresada.
        this.saldo += cantidadDeposito;
    }
    
    public void retirarDinero(double cantidadRetiro) {  //Suma a saldoDeLaCuenta una cantidad ingresada.
        this.saldo -= cantidadRetiro;
    }
}
