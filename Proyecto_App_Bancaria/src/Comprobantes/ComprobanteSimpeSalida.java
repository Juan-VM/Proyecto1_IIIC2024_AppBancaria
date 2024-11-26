package Comprobantes;

public class ComprobanteSimpeSalida extends Comprobantes {

    private String numeroEmisor;
    private String numeroReceptor;
    private String cuentaUtilizada;
    private String detalle;
    
    public ComprobanteSimpeSalida(){
        
    }

    public ComprobanteSimpeSalida(String numeroEmisor, String numeroReceptor, String cuentaUtilizada, double monto, String fecha, String hora, String detalle) {
        super(monto, fecha, hora);
        this.numeroEmisor = numeroEmisor;
        this.numeroReceptor = numeroReceptor;
        this.cuentaUtilizada = cuentaUtilizada;
        this.detalle = detalle;
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

    public String getCuentaUtilizada() {
        return cuentaUtilizada;
    }

    public void setCuentaUtilizada(String cuentaUtilizada) {
        this.cuentaUtilizada = cuentaUtilizada;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    
}
