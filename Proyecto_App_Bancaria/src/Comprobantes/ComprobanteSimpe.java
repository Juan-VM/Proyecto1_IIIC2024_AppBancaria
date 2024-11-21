package Comprobantes;

public class ComprobanteSimpe extends Comprobantes {

    private String numeroEmisor;
    private String numeroReceptor;
    
    public ComprobanteSimpe(){
        
    }

    public ComprobanteSimpe(String numeroEmisor, String numeroReceptor, String cuentaUtilizada, double monto, String fecha, String hora) {
        super(cuentaUtilizada, monto, fecha, hora);
        this.numeroEmisor = numeroEmisor;
        this.numeroReceptor = numeroReceptor;
    }

    public String getNumeroEmisor() {
        return numeroEmisor;
    }

    public void setNumeroEmisor(String numeroEmisor) {
        this.numeroEmisor = numeroEmisor;
    }

    public String getNumeroReceptor() {
        return numeroReceptor;
    }

    public void setNumeroReceptor(String numeroReceptor) {
        this.numeroReceptor = numeroReceptor;
    }
    
    
}
