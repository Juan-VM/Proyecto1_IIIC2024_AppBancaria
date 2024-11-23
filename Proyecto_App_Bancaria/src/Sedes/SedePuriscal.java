package Sedes;

import Personas.Administradores;
import Personas.Usuarios;
import java.util.ArrayList;

public class SedePuriscal{

    public static ArrayList<Usuarios> ListaUsers = new ArrayList<>();
    public static ArrayList<Administradores> ListaAdmins = new ArrayList<>();

    public static ArrayList<Usuarios> getListaUsers() {
        return ListaUsers;
    }

    public static ArrayList<Administradores> getListaAdmins() {
        return ListaAdmins;
    }
    
    
    
}
