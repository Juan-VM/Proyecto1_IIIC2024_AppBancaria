package ClasesProyecto;

import Personas.Administradores;
import Personas.Usuarios;
import java.util.ArrayList;

public class Datos {
    
    public static ArrayList<Integer> clavesRegistradas = new ArrayList<Integer>();
    public static ArrayList<Usuarios> listaUsuarios = new ArrayList<Usuarios>();
    public static ArrayList<Administradores> listaAdmins = new ArrayList<Administradores>();
    public static int indiceLogin;

    public static ArrayList<Integer> getClavesRegistradas() {
        return clavesRegistradas;
    }

    public static ArrayList<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    public static ArrayList<Administradores> getListaAdmins() {
        return listaAdmins;
    }

    public static int getIndiceLogin() {
        return indiceLogin;
    }

    public static void setIndiceLogin(int indiceLogin) {
        Datos.indiceLogin = indiceLogin;
    }
    
    public static int getLoginIndexUsuarios(ArrayList<Usuarios> lista, String user, String psd) {
        int index = -1;
        for (Personas i : lista) {
            if (i.getPassword().equals(psd) && i.getUsuario().equals(user)) {
                index = Datos.getListaUsuarios().indexOf(i);
            }
        }
        return index;
    }
    
    public static int getLoginIndexAdmins(ArrayList<Personas> lista, String user, String psd) {
        int index = -1;
        for (Personas i : lista) {
            if (i.getPassword().equals(psd) && i.getUsuario().equals(user)) {
                index = Datos.getListaAdmins().indexOf(i);
            }
        }
        return index;
    }
    
    public static String getAtributeInIndexUsuarios(int index, String atributo) {
        
        String nombre;
        String apellido;
        String cedula;
        String telefono;
        String password;
        
        switch (atributo) {
            case "nombre" -> {
                nombre = listaUsuarios.get(index).getUsuario();
                return nombre;
            }
            case "apellido" -> {
                apellido = listaUsuarios.get(index).getApellidos();
                return apellido;
            }
            case "cedula" -> {
                cedula = listaUsuarios.get(index).getCedula();
                return cedula;
            }
            case "telefono" -> {
                telefono = String.valueOf( listaUsuarios.get(index).getTelefono());
                return telefono;
            }
            case "password" -> {
                password = listaUsuarios.get(index).getPassword();
                return password;
            }
            default ->{
                return "ATRIBUTE_NO_FOUND";
            }
        }
    }
    public static String getAtributeInIndexAdmins(int index, String atributo) {
        
        String nombre;
        String apellido;
        String cedula;
        String telefono;
        String password;
        
        switch (atributo) {
            case "nombre" -> {
                nombre = listaAdmins.get(index).getUsuario();
                return nombre;
            }
            case "apellido" -> {
                apellido = listaAdmins.get(index).getApellidos();
                return apellido;
            }
            case "cedula" -> {
                cedula = listaAdmins.get(index).getCedula();
                return cedula;
            }
            case "telefono" -> {
                telefono = String.valueOf( listaAdmins.get(index).getTelefono());
                return telefono;
            }
            case "password" -> {
                password = listaAdmins.get(index).getPassword();
                return password;
            }
            default ->{
                return "ATRIBUTE_NO_FOUND";
            }
        }
    }
}
