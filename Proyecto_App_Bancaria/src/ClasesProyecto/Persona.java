
package ClasesProyecto;

import java.util.ArrayList;

public class Persona {
    private String usuario;
    private String password;
    private int claveNumerica;
    private double saldoDeLaCuenta;
    private int numeroSimpe;
    private String usuarioSimpe;
    private double saldoCuentaSimpe;
    private boolean estadoCuentaSimpe;
    private ArrayList<String> comprobantesSimpe = new ArrayList<>();
    private double saldoCuentaAhorro;
    private boolean estadoCuentaAhorro;
    String comentario;
    
    public Persona(String usuario, String password, int claveNumerica, double saldoDeLaCuenta, int numeroSimpe,String comprobantesSimpe,boolean estadoCuentaSimpe, boolean estadoCuentaAhorro){
        this.usuario = usuario;
        this.password = password;
        this.claveNumerica = claveNumerica;
        this.saldoDeLaCuenta = saldoDeLaCuenta;
        this.numeroSimpe = numeroSimpe;
        this.comprobantesSimpe.add(comprobantesSimpe);
        this.estadoCuentaSimpe = estadoCuentaSimpe;
        
        
    }
    
    public Persona(){
        
    }
    public Persona(String usuario,String comentario){
        this.usuario = usuario;
        this.comentario = comentario;
        
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    

    public String getUsuarioSimpe() {
        return usuarioSimpe;
    }
 
    public double getSaldoCuentaSimpe() {
        return saldoCuentaSimpe;
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
    
    public double getSaldoCuenta(){ //Retorna el valor de SaldoDeLaCuenta.
        return saldoDeLaCuenta;
    }
    
    public int getNumeroSimpe(){ //Retorna el valor de SaldoDeLaCuenta.
        return numeroSimpe;
    }

    public boolean getEstadoCuentaSimpe() {
        return estadoCuentaSimpe;
    }

    public double getSaldoCuentaAhorro() {
        return saldoCuentaAhorro;
    }

    public double getSaldoDeLaCuenta() {
        return saldoDeLaCuenta;
    }
    
    public boolean getEstadoCuentaAhorro() {
        return estadoCuentaAhorro;
    }
    
    public ArrayList<String> getComprobantesSimpe(){
        return comprobantesSimpe;
    }
    
    public void setUsuarioSimpe(String usuarioSimpe) {
        this.usuarioSimpe = usuarioSimpe;
    }
      
    public void setSaldoCuentaAhorro(double saldoCuentaAhorro) {
        this.saldoCuentaAhorro = saldoCuentaAhorro;
    }

    public void setEstadoCuentaAhorro(boolean estadoCuentaAhorro) {
        this.estadoCuentaAhorro = estadoCuentaAhorro;
    }

    public void setEstadoCuentaSimpe(boolean estadoCuentaSimpe) {
        this.estadoCuentaSimpe = estadoCuentaSimpe;
    }
    
    public void addComprobantesSimpe(String comprobante){
        this.comprobantesSimpe.add(comprobante);
    }
    
    public void setSaldoCuentaSimpe(double saldoCuentaSimpe) {
        this.saldoCuentaSimpe = saldoCuentaSimpe;
    }
     
    public void setNumeroSimpe(int numeroTelefono){  //Establece el valor de usuario.
        this.numeroSimpe = numeroTelefono;
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
    
    public void setSaldoCuenta(double saldoDeLaCuenta){  //Establece el valor de SaldoDeLaCuenta.
        this.saldoDeLaCuenta = saldoDeLaCuenta;
    }
    
    
    
    public void retirarDinero(double cantidad, String cuentaDestino){  //Resta a saldoDeLaCuenta una cantidad ingresada.

        switch (cuentaDestino) {
            case "1" -> {
                saldoDeLaCuenta -= cantidad;
            }
            case "2" -> {
                saldoCuentaAhorro -= cantidad;
            }
            case "3" -> {
                saldoCuentaSimpe -= cantidad;
            }
        }
    }
    
    public void depositarDinero(double cantidad, String cuentaDestino){  //Suma a saldoDeLaCuenta una cantidad ingresada.
        
        switch (cuentaDestino) {
            case "1" -> {
                saldoDeLaCuenta += cantidad;
            }
            case "2" -> {
                saldoCuentaAhorro += cantidad;
            }
            case "3" -> {
                saldoCuentaSimpe += cantidad;
            }
        }

    }
    public static int obtenerIndicePersona(ArrayList<Persona> lista, int claveNumerica){
        
        int indiceDelObjeto = -1;
        
        for( Persona i : lista){
            if( i.getClaveNumerica() == claveNumerica){
                indiceDelObjeto = lista.indexOf(i);
            }
        }
        return indiceDelObjeto;
    }
    
    public void mostarHistorial(){
        for(String i : comprobantesSimpe){
            System.out.println(i);
        }
    }
    public class Comentario {
       // private String 
    }
    
    
} //Fin clase persona
