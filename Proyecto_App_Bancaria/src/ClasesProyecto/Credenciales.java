
package ClasesProyecto;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Credenciales {
    
    //METODOS UTILIZADOS EN LA OPCION DE REGISTRO Y INICIO DE SECION.
    
    //LEE UN NOMBRE DE USUARIO INGRESADO POR TECLADO Y LO RETORNA.
    public static String leerUsuario(){
        Scanner leer = new Scanner(System.in); 
        System.out.print("Ingrese su usuario: ");
        String usuario = leer.nextLine();
        return usuario;
    }
    
    
    //LEE UN PASSWORD INGRESADO POR TECLADO Y LO RETORNA.
    public static String leerPassword(){
        Scanner leer = new Scanner(System.in); 
        System.out.print("Ingrese su contrasena: ");
        String password = leer.nextLine();
        return password;
    }
    
    
    //LEE UNA CLAVE NUMERICA INGRSADA POR TECLADO Y LA RETORNA.
    public static int leerClaveNumerica(){
        Scanner leer = new Scanner(System.in); 
        int claveIngresada;
        
        System.out.print("Ingrese su clave numerica: ");
        try {
            claveIngresada = leer.nextInt();
        } catch (Exception e) {
            claveIngresada = 0;
        }
        return claveIngresada;
    }
    

    //ESTA FUNCION SE ENCARGA DE REESTABLECER LA CLAVE NUMERICA Y RETORNARLA.
    //EN CASO DE QUE LA VALIDACION PARA EL REESTABLECIMIENTO SEA ERRONEA, RETORNA LA CLAVE ORIGINAL.
    public static void restoreClaveNumerica(ArrayList<Persona> lista, ArrayList<Integer> clavesRegistradas){
        
        Scanner leer = new Scanner(System.in);
        
        int clave;
        if (lista.size() < 1){ //Si el usuario no se ha registrado.
            System.out.println("No hay clave numerica registrada. Debes registrar un usuario.");
           
        }else{  //Si esta registrado.
            String usuario = Credenciales.leerUsuario();
            String password = Credenciales.leerPassword();
            int claveAnterior = Credenciales.leerClaveNumerica();
        
            int indice = Persona.obtenerIndicePersona(lista, claveAnterior);
            
            
            if(indice != -1){
                System.out.println("\nUsuario encontrado...\n");
                clave = crearClaveNumerica(clavesRegistradas);
                lista.get(indice).setClaveNumerica(clave);
                
                clavesRegistradas.remove(Integer.valueOf(claveAnterior));
                
                System.out.printf("Su nueva clave numerica es: --->  %d  <---\n", clave);
                System.out.print("\nPresione enter para continuar: >>> ");
                leer.nextLine();
            }else{
                System.out.println("No se ha registrado ningun usuario con esas credenciales");
                System.out.print("\nPresione enter para continuar: >>> ");
                leer.nextLine();
            }
 
        }     
    }
    public static void restoreClaveNumerica(Persona persona, ArrayList<Integer> clavesRegistradas){
        Scanner leer = new Scanner(System.in);
        
        int clave;
        
        System.out.println("\nPara continuar ingrese los siguietes datos:\n");
        String usuario = Credenciales.leerUsuario();
        String password = Credenciales.leerPassword();
        int claveAnterior = Credenciales.leerClaveNumerica();

        if (persona.getUsuario().equals(usuario) && persona.getPassword().equals(password) && persona.getClaveNumerica() == claveAnterior){
            System.out.println("\nCredenciales correctas...\n");
            clave = crearClaveNumerica(clavesRegistradas);
            persona.setClaveNumerica(clave);
            
            clavesRegistradas.remove(Integer.valueOf(claveAnterior));
            
            System.out.printf("Su nueva clave numerica es: --->  %d  <---\n", clave);
            System.out.print("\nPresione enter para continuar: >>> ");
            leer.nextLine(); 
        }else{
            System.out.println("\nCredenciales incorrectas...\n");
            System.out.print("\nPresione enter para continuar: >>> ");
            leer.nextLine(); 
        }      
    }
    
    
    //ESTA FUNCION VALIDA SI HAY CREDENCIALES REGISTRADAS Y SI HAY 
    //CREDENCIALES REGISTRADAS PIDE INGRESAR USUARIO Y CONTRASENA PARA
    //COMPARARLOS, SI SON IGUALES RETORNA TRUE, SI NO RETORNA FALSE.
    public static boolean validarCredenciales(ArrayList<Persona> lista,String user,String password,int claveNum){
        boolean validacion = false;
        
        for(Persona i : lista){
            if (i.getUsuario().equals(user) && i.getPassword().equals(password) && i.getClaveNumerica() == claveNum){
                validacion = true;
            }
        }
       
        return validacion;
    }
    
    public static boolean validarCredenciales(Persona persona){
        boolean validacion = false;

        String user = Credenciales.leerUsuario();
        String password = Credenciales.leerPassword();
        int claveNum = Credenciales.leerClaveNumerica();


        if (persona.getUsuario().equals(user) && persona.getPassword().equals(password) && persona.getClaveNumerica() == claveNum){
            System.out.println("\nCredenciales correctas\n");
            validacion = true;
        }else{
            System.out.println("\nCredenciales incorrectas");
        }

        return validacion;
    }
    
    
    //CREA UNA CLAVE NUMERICA DE 3 DIGITOS RAMDOM ENTRE 100 Y 999 Y LA RETORNA.
    public static int crearClaveNumerica(ArrayList<Integer> clavesRegistradas){
        Random random = new Random();
        int clave;
        while (true){
            clave = 100 + random.nextInt(900);
            
            if(!clavesRegistradas.contains(clave)){
                clavesRegistradas.add(clave);
                break;
            }     
        }
        return clave;     
    }
    
    
    //MUESTRA LAS CREDENCIALES DEL USUARIO.
    public static void muestraCredenciales(Persona persona){
        Scanner leer = new Scanner(System.in);
        
        String user = persona.getUsuario();
        String password =persona.getPassword();
        int clave =  persona.getClaveNumerica();
        
        System.out.println("\nRegistro realizado exitosamente.\n");
        System.out.printf("El usuario registrado es: %s\nLa contrasena registrada es: %s\n\n", user, password);
        System.out.printf("--- ATENCION ---\n\nLa CLAVE NUMERICA correspondiente para este usuario es:   --->  %d   <---\n",clave);
        System.out.print("\nPresione enter para continuar: >>> ");
        leer.nextLine();
    }
    
    public static void reestablecerCredenciales(Persona persona, ArrayList<Integer> clavesRegistradas){
        Scanner leer = new Scanner(System.in); 
        
        boolean vali = true;
        while (vali == true){
            
            System.out.println("\n\n--- REESTABLECER CREDENCIALES ---\n");
            System.out.println("Ingrese el dato que desea reestablecer o salir: \n");
            String opcion = Herramientas.mostarMenuDe3Opciones("Usuario y Contrasena", "Clave Numerica","Salir");
            
            switch (opcion){
                case "1" ->{
                    System.out.println("\n--- REESTABLECER USUARIO Y CONTRASENA ---\n");
                    System.out.println("Para continuar primero complete lo siguiente:\n");
                    boolean validacion;
                    validacion = validarCredenciales(persona);
                    
                    if (validacion == true){
                        System.out.print("Ingrese su nuevo usuario: >>> ");
                        String nuevoUsuario = leer.nextLine();
                        System.out.print("Ingrese su nueva contrasena: >>> ");
                        String nuevaContrasena = leer.nextLine();
                        System.out.println("\nDesea guardar los datos ingresados: \n");
                        boolean confirmacion = Herramientas.decisionGuardadoDatos();
                        
                        if (confirmacion == true){
                            persona.setUsuario(nuevoUsuario);
                            persona.setPassword(nuevaContrasena);
                            System.out.println("\nDatos reestablecidos correctamente\n");
                        }
                    } else{
                        System.out.print("\nLos datos ingresados son incorrectos....\nPulsa enter para continuar: >>> ");
                        leer.nextLine();
                    }
                }
                case "2" ->{
                    restoreClaveNumerica(persona, clavesRegistradas);
                }
                case "3" ->{
                    vali = false;
                }
            }
        }
    }
    
    public static int addNumeroTelefono(ArrayList<Integer> numerosRegistrados){
        Scanner leer = new Scanner(System.in);
        int numeroTelefono;
        
        while (true) {
            
            numeroTelefono = Herramientas.validarEntradaInteger("Ingrese el numero de telefono que quiere ligar a esta cuenta: >>> ");
            if (!numerosRegistrados.contains(numeroTelefono)) {
                numerosRegistrados.add(numeroTelefono);
                break;
            }else{
                System.out.println("Este numero ya esta registrado en el sistema, verifique de nuevo...\n");
            }
           
        }
        return numeroTelefono;
    }
}//Fin clase MetCredenciales.
