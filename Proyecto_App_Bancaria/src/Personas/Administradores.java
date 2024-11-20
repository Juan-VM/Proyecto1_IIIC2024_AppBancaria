
package Personas;

import ClasesProyecto.Personas;

public class Administradores extends Personas{
    private String claveSede;
    
    public Administradores(String claveSede, String usuario, String apellidos, String password, String cedula, String telefono, int claveNumerica, int rol, String sede){
        super(usuario, apellidos, password, cedula, telefono, claveNumerica, rol, sede);
        this.claveSede = claveSede;
    }
}
