package Comentarios;

public class Comentario {

    private String autor = "";
    private String ceulaAutor = "";
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
        this.ceulaAutor = cedulaAutor;
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

    public String getCeulaAutor() {
        return ceulaAutor;
    }

    public void setCeulaAutor(String ceulaAutor) {
        this.ceulaAutor = ceulaAutor;
    }
    
    
}
