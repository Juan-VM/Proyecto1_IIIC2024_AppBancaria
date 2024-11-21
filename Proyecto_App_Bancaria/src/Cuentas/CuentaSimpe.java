
package Cuentas;

import Comprobantes.ComprobanteSimpe;
import java.util.ArrayList;


public class CuentaSimpe extends Cuentas{
    
    private ArrayList<ComprobanteSimpe> comprobantesSimpe = new ArrayList<>();
    
    public CuentaSimpe(double saldo, boolean estado) {
        super(saldo, estado);
    }
}
