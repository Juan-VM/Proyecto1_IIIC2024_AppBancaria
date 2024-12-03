
package RegistroDatos;

import Comentarios.Comentario;
import Personas.Usuarios;
import java.util.ArrayList;

public class DatosRegistrados {
    private static ArrayList<String> listaTelefonos = new ArrayList<>();
    private static ArrayList<Integer> listaClaves = new ArrayList<>();
    private static ArrayList<String> listaCedulas = new ArrayList<>();
    private static ArrayList<Usuarios> listaUsuariosEliminados = new ArrayList<>();
    private static ArrayList<Comentario> listaComentarios = new ArrayList<>();

    public static ArrayList<String> getListaTelefonos() {
        return listaTelefonos;
    }

    public static void setListaTelefonos(ArrayList<String> listaTelefonos) {
        DatosRegistrados.listaTelefonos = listaTelefonos;
    }

    public static ArrayList<Integer> getListaClaves() {
        return listaClaves;
    }

    public static void setListaClaves(ArrayList<Integer> listaClaves) {
        DatosRegistrados.listaClaves = listaClaves;
    }

    public static ArrayList<String> getListaCedulas() {
        return listaCedulas;
    }

    public static void setListaCedulas(ArrayList<String> listaCedulas) {
        DatosRegistrados.listaCedulas = listaCedulas;
    }
    
    public static void addTelefono(String telefono){
        DatosRegistrados.listaTelefonos.add(telefono);
    }
    
    public static void addCedula(String cedula){
        DatosRegistrados.listaCedulas.add(cedula);
    }
    
    public static void addClave(int clave){
        DatosRegistrados.listaClaves.add(clave);
    }

    public static ArrayList<Usuarios> getListaUsuariosEliminados() {
        return listaUsuariosEliminados;
    }

    public static void setListaUsuariosEliminados(ArrayList<Usuarios> listaUsuariosEliminados) {
        DatosRegistrados.listaUsuariosEliminados = listaUsuariosEliminados;
    }

    public static ArrayList<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public static void setListaComentarios(ArrayList<Comentario> listaComentarios) {
        DatosRegistrados.listaComentarios = listaComentarios;
    }
    
}
