
package Cuentas;

import java.util.ArrayList;


public class Cuentas {
    private double saldo;
    private boolean estado;
    private ArrayList<String> comprobantesTransacciones = new ArrayList<>();

    public Cuentas(){
        
    }

    public Cuentas(double saldo, boolean estado) {
        this.saldo = saldo;
        this.estado = estado;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public void depositarDinero(double cantidadDeposito) {  //Suma a saldoDeLaCuenta una cantidad ingresada.

        this.saldo += cantidadDeposito;
    }

    public ArrayList<String> getComprobantesTransacciones() {
        return comprobantesTransacciones;
    }

    public void setComprobantesTransacciones(ArrayList<String> comprobantesTransacciones) {
        this.comprobantesTransacciones = comprobantesTransacciones;
    }
    
    
}
