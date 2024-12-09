package Comentarios;

public class Comentario {

    private String autor = "";
    private String cedulaAutor = "";
    private String texto = "";
    private String fecha = "";
    private String hora = "";

    public Comentario() {
    }

    
    public Comentario(String autor, String cedulaAutor, String texto, String fecha, String hora) {
        this.autor = autor;
        this.texto = texto;
        this.fecha = fecha;
        this.hora = hora;
        this.cedulaAutor = cedulaAutor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCedulaAutor() {
        return cedulaAutor;
    }

    public void setCedulaAutor(String cedulaAutor) {
        this.cedulaAutor = cedulaAutor;
    }
    
    
}
