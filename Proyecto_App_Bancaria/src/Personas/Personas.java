
package Personas;

public class Personas {
    private String usuario;
    private String password;
    private String cedula;
    private int claveNumerica;
    private String telefono;
    private String apellidos;
    private int rol;
    private int sede;
    
    public Personas(String usuario, String apellidos, String password, String cedula, String telefono, int claveNumerica, int rol, int sede){
        this.usuario = usuario;
        this.password = password;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.telefono = telefono;
        this.claveNumerica = claveNumerica;
        this.rol = rol;
        this.sede = sede;
    }
    
    public Personas(){
        
    }
    public Personas(String usuario, String comentario){
        
    }
    
    public String getUsuario(){ //Retorna el valor de usuario.
        return usuario;
    }
    
    public String getPassword(){ //Retorna el valor de password.
        return password;
    }
    
    public int getClaveNumerica(){ //Retorna el valor de claveNumerica.
        return claveNumerica;
    }
    
    
    public void setUsuario(String usuario){  //Establece el valor de usuario.
        this.usuario = usuario;
    }
    
    public void setPassword(String password){  //Establece el valor de password.
        this.password = password;
    }
    
    public void setClaveNumerica(int claveNumerica){  //Establece el valor de claveNumerica.
        this.claveNumerica = claveNumerica;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }
    
} //Fin clase persona
