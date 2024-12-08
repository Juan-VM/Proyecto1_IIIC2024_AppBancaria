
package Cuentas;

import Comprobantes.ComprobanteSimpeSalida;
import java.util.ArrayList;


public class CuentaSimpe extends Cuentas{
    
    private ArrayList<ComprobanteSimpeSalida> comprobantesSimpe = new ArrayList<>();
    
    public CuentaSimpe(boolean estado) {
        super(estado);
    }
}
