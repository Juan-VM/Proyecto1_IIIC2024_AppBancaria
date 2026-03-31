
package Buzon;


public class Mensaje {
    private String mensaje; //Contenido del mensaje
    private boolean estadoMensaje = false; //Estado que representa si esta leido o no
    private String autor;
    private String fecha;
    
    public Mensaje() {
        
    }

    public Mensaje(String autor, String fecha, String mensaje) {
        this.mensaje = mensaje;
        this.autor = autor;
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean getEstadoMensaje() {
        return estadoMensaje;
    }

    public void setEstadoMensaje(boolean estadoMensaje) {
        this.estadoMensaje = estadoMensaje;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    public void marcarMensajeComoLeido(){
        this.estadoMensaje = true;
    }
    
}
