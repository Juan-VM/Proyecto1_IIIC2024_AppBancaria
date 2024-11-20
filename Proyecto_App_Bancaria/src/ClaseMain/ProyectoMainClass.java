
package ClaseMain;

import ClasesProyecto.Comentarios;
import ClasesProyecto.Credenciales;
import ClasesProyecto.Cuenta;
import ClasesProyecto.Herramientas;
import ClasesProyecto.Personas;
import ClasesProyecto.SimpeMovil;
import Personas.Usuarios;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ProyectoMainClass {
    public static void main(String[] args) {

        // Declaracion e inicializacion de variables globales
        String usuario,
               password,
               decision = "0";
        int claveNumerica,
            indice = -1;
        
        HashMap<String, Integer> cuentasSimpeMovil = new HashMap<>();
        ArrayList<Integer> numerosRegistrados = new ArrayList<>();
        ArrayList<Integer> clavesRegistradas = new ArrayList<>();
        ArrayList<Usuarios> listaPersonas = new ArrayList<>(); // Almacena todos los usuarios y sus datos.
        
        
        boolean bandera = false; // Controla la repeticion del programa completo.
        while(bandera == false){
            
            //Inicio del apartado de registro y validacion de credenciales.
            System.out.println("\nBienvenido al sistema!!!\n");
            
            boolean validacion = false; //Controla el ciclo del apartado de credenciales
            while(validacion == false){

                System.out.println("\n---- REGISTRO E INICIO SESION ----\n");
                System.out.println("Elija una opcion:\n");
                decision = Herramientas.mostarMenuDe4Opciones("Registrarse", "Iniciar Sesion","Reestablecer clave numerica","Salir");

                switch (decision){
                    case "1" -> { 
                        //REGISTRARSE
                        boolean vali;

                        System.out.println("\n---- REGISTRO ----\n");
                        usuario = Credenciales.leerUsuario();
                        password = Credenciales.leerPassword();

                        System.out.println("\nDesea guardar los datos ingresados?:\n");
                        vali = Herramientas.decisionGuardadoDatos();//RETORNA TRUE O FALSE, SI EL USUARIO QUIERE GUARADAR LOS DATOS O NO.

                        if (vali == true){  //Se ejecuta solo si los datos ingresados fueron guardados.
                            claveNumerica = Credenciales.crearClaveNumerica(clavesRegistradas);
                            listaPersonas.add(new Usuarios(usuario,"",password,"","",claveNumerica,0,"",0,0,0));
                            Credenciales.muestraCredenciales( listaPersonas.get(listaPersonas.size()-1) );
                            
                        }
                    }
                    case "2" -> { 
                        //INICIAR SESION
                        System.out.println("\n---- INICIO SESION ----\n");
                        if ( listaPersonas.size() > 0 ){
                            
                            System.out.println("Complete los siguientes datos para ingresar:\n");
                            String user = Credenciales.leerUsuario();
                            String pswd = Credenciales.leerPassword();
                            int claveNum = Credenciales.leerClaveNumerica();
                            
                            validacion = Credenciales.validarCredenciales(listaPersonas, user, pswd, claveNum);

                            if (validacion == true){
                                System.out.println("\nCredenciales correctas");
                                
                                // Retorna el indice de la persona a la que correspondan los datos ingresados. Para usar ese indice en todo el programa.
                                indice = Personas.obtenerIndicePersona(listaPersonas, claveNum);
                                
                                listaPersonas.get(indice).setUsuario(user);
                                listaPersonas.get(indice).setPassword(pswd);
                                listaPersonas.get(indice).setClaveNumerica(claveNum);
       
                            }else{
                                System.out.println("\nCredenciales incorrectas");
                            }
                        }else{
                            System.out.println("No se ha registrado ningun usuario. Registrate antes de iniciar sesion.");
                        }
                    }
                    case "3" -> {
                        //REESTABLECER CLAVE NUMERICA.
                        System.out.println("\n--- REESTABLECER CLAVE NUMERICA ---\n");
                        Credenciales.restoreClaveNumerica(listaPersonas, clavesRegistradas);
                    }
                    case "4" -> {  
                        //SALIR.
                        validacion = true;
                        bandera = true;
                    }
                }//Fin swich
            }//Fin while (apartado credenciales).

            // INICIA EL MENU PRINCIPAL
            
            if (!decision.equals("4")){
                boolean centinela = false; // Controla el ciclo del menu principal.
                while(centinela == false){
                    System.out.println("\n--- MENU PRINCIPAL ---\n");
                    System.out.println("Ingrese la opcion que deseas utilizar:\n");
                    String opcion = Herramientas.mostarMenuDe8Opciones("Deposito","Ver saldo","Retirar dinero",
                                                                       "Simpemovil","Crear nueva cuenta",
                                                                       "Reestablecer credenciales","Comentarios","Salir");

                    switch (opcion) {
                        case "1" -> {
                            // Opción para depositar dinero
                            System.out.println("\n--- DEPOSITAR DINERO ---\n");
                            String cuentaElejida = Cuenta.elejirCuentaParaLaFuncion("\nElije la cuenta a la que deseas depositar dinero:\n");
                            
                            if(cuentaElejida != "4"){
                                
                                if(cuentaElejida.equals("1")){
                                    listaPersonas.get(indice).depositarDinero( Cuenta.ingresarMontoDeposito(), "1");
                                }
 
                                if(cuentaElejida.equals("2")){
                                    if(listaPersonas.get(indice).getEstadoCuentaAhorro() == true){
                                        listaPersonas.get(indice).depositarDinero( Cuenta.ingresarMontoDeposito(), "2");
                                    }else{
                                        System.out.println("\nLa cuenta de ahorro esta inactiva, debes de crearla antes de depositar");
                                        Herramientas.enterParaContinuar();
                                    }
                                }

                                if(cuentaElejida.equals("3")){
                                    if(listaPersonas.get(indice).getEstadoCuentaAhorro() == true){
                                        listaPersonas.get(indice).depositarDinero( Cuenta.ingresarMontoDeposito(), "3");
                                    }else{
                                        System.out.println("\nLa cuenta de simpe movil esta inactiva, debes de crearla antes de depositar");
                                        Herramientas.enterParaContinuar();
                                    }
                                }  
                            }
                        }
                        case "2" -> {
                            // Opción para ver saldo
                            System.out.println("\n--- VER SALDO ---\n");
                            String cuentaElejidaVer = Cuenta.elejirCuentaParaLaFuncion("\nElije la cuenta para ver el saldo:\n");
                            
                            if(cuentaElejidaVer != "4"){
                                if(cuentaElejidaVer.equals("1")){
                                    Cuenta.verSaldoCuenta(listaPersonas.get(indice), "1");
                                }

                                if(cuentaElejidaVer.equals("2")){
                                    if(listaPersonas.get(indice).getEstadoCuentaAhorro() == true){
                                        Cuenta.verSaldoCuenta(listaPersonas.get(indice), "2");
                                    }else{
                                        System.out.println("\nLa cuenta de ahorro esta inactiva, debes de crearla antes de ver saldo");
                                        Herramientas.enterParaContinuar();
                                    }
                                }

                                if(cuentaElejidaVer.equals("3")){
                                    if(listaPersonas.get(indice).getEstadoCuentaAhorro() == true){
                                        Cuenta.verSaldoCuenta(listaPersonas.get(indice), "3");
                                    }else{
                                        System.out.println("\nLa cuenta de simpe movil esta inactiva, debes de crearla antes de ver saldo");
                                        Herramientas.enterParaContinuar();
                                    }
                                } 
                            }
                        }
                        case "3" -> {
                            //Opcion para retirar dinero
                            String cuentaARetirar = Cuenta.elejirCuentaParaLaFuncion("\nElije la cuenta para retirar dinero:\n");
                            if(cuentaARetirar != "4"){
                                
                                if(cuentaARetirar.equals("1")){
                                    double montoRetiro = Cuenta.ingresarMontoRetiro(listaPersonas.get(indice), cuentaARetirar);
                                    listaPersonas.get(indice).retirarDinero(montoRetiro, cuentaARetirar);
                                    Cuenta.mostarTipoDeCambio(montoRetiro);
                                }

                                if(cuentaARetirar.equals("2")){
                                    if(listaPersonas.get(indice).getEstadoCuentaAhorro() == true){
                                        double montoRetiro = Cuenta.ingresarMontoRetiro(listaPersonas.get(indice), cuentaARetirar);
                                        listaPersonas.get(indice).retirarDinero(montoRetiro, cuentaARetirar);
                                        Cuenta.mostarTipoDeCambio(montoRetiro); 
                                    }else{
                                        System.out.println("\nLa cuenta de ahorro esta inactiva, debes de crearla antes de retirar");
                                        Herramientas.enterParaContinuar();
                                    }
                                }

                                if(cuentaARetirar.equals("3")){
                                    if(listaPersonas.get(indice).getEstadoCuentaAhorro() == true){
                                        double montoRetiro = Cuenta.ingresarMontoRetiro(listaPersonas.get(indice), cuentaARetirar);
                                        listaPersonas.get(indice).retirarDinero(montoRetiro, cuentaARetirar);
                                        Cuenta.mostarTipoDeCambio(montoRetiro); 
                                    }else{
                                        System.out.println("\nLa cuenta de simpe movil esta inactiva, debes de crearla antes de retirar");
                                        Herramientas.enterParaContinuar();
                                    }
                                }
                            }
                        }
                        case "4" -> {
                            //Simpemovil
                            if(listaPersonas.get(indice).getEstadoCuentaSimpe() == true){
                                System.out.println("\n--- SIMPE MOVIL ---\n");
                                System.out.println("Ingrese la opcion que desea:\n");
                                String opcionSimpe = Herramientas.mostarMenuDe5Opciones("Realizar simpeMovil","Ver saldo de la cuenta simpe","Editar datos de la cuenta", "Historial de Transacciones", "Salir");
                                switch(opcionSimpe){
                                    case "1" -> {
                                        System.out.println("\n--- REALIZAR SIMPE ---\n");
                                        String comprobante = SimpeMovil.realizarSimpe(numerosRegistrados, cuentasSimpeMovil, listaPersonas.get(indice), listaPersonas);
                                        SimpeMovil.asignarComprobantesTransaccionACuentas(listaPersonas, comprobante, listaPersonas.get(indice));
                                        
                                    }
                                    case "2" -> {
                                        System.out.println("\n--- VER SALDO ---\n");
                                        System.out.printf("El saldo de su cuenta simpe es: %.2f\n",listaPersonas.get(indice).getSaldoCuentaSimpe());
                                        Herramientas.enterParaContinuar();
                                    }
                                    case "3" -> {
                                        SimpeMovil.cambiarDatosCuentaSimpe(numerosRegistrados, cuentasSimpeMovil, listaPersonas.get(indice));
                                    }
                                    case "4" -> {
                                        System.out.println("\n--- HISTORIAL TRANSACCIONES ---\n");
                                        listaPersonas.get(indice).mostarHistorial();
                                        Herramientas.enterParaContinuar();
                                    }
                                    case "5" -> {
                                        System.out.println("");
                                    }
                                }
                            }else{
                                System.out.println("Primero debes crear una cuenta simpe");
                                Herramientas.enterParaContinuar();
                            }
                        }
                        case "5" -> {
                            //Crear nueva cuenta
                            System.out.println("\n--- CREAR NUEVA CUENTA ---\n");
                            System.out.println("Ingrese el tipo de cuenta que desea crear:\n");
                            String tipoCuenta = Herramientas.mostarMenuDe3Opciones("Cuenta Ahorro", "Cuenta Simpemovil","Salir");
                            
                            switch(tipoCuenta){
                                case "1" -> {
                                    Cuenta.crearCuentaAhorro(listaPersonas.get(indice));
                                }
                                case "2" -> {
                                    System.out.println("\n--- CREAR CUENTA SIMPE ---\n");
                                    if (listaPersonas.get(indice).getEstadoCuentaSimpe()==false){
                                        Cuenta.crearNuevaCuentaSimpe(numerosRegistrados, cuentasSimpeMovil, listaPersonas.get(indice));
                                        
                                    }else{
                                        System.out.println("Solo se puede tener una cuenta de simpe por cuenta");
                                        System.out.println("Si desea editar los datos de su cuenta use la opcion 7 del menu");
                                        Herramientas.enterParaContinuar();
                                    }
                                }
                                case "3" -> {
                                    System.out.println("");
                                }
                            }
                        }
                        case "6" -> {
                           // Opcion para reestablecer credenciales
                            Credenciales.reestablecerCredenciales(listaPersonas.get(indice), clavesRegistradas);
                        }
                        case "7" -> {
                            //COMENTARIOS
                            Scanner entrada = new Scanner(System.in);
                            Comentarios n = new Comentarios();
                            int op = 0;
                            ArrayList<Personas> persona = new ArrayList<>();
                            do {
                                System.out.println("Digite la opcion que desea \n1- Agregar comentario " + " \n2- ver \n3- Salir");
                                op = entrada.nextInt();
                                switch (op) {
                                    case 1:
                                        n.insertar_dato(listaPersonas.get(indice));
                                        break;
                                    case 2:
                                        n.leer(persona);
                                        for (Personas list : persona) {
                                            System.out.println(list.getUsuario() + " " + list.getComentario());
                                        }
                                        break;
                                    case 3:
                                        break;
                                }
                                System.out.println("***Gracias por preferirnos*** \n1)- Si desea continuar    \n2)- Si desea salir ");
                                op = entrada.nextInt();
                            } while (op != 2);
                        }    
 
                        case "8" -> {
                            //Salir
                            System.out.println("Sesion cerrada. Datos reestablecidos por defecto\n\n");
                            centinela = true; //cierra ciclo menu
                        }
                        
                    } //Fin switch menu principal
                
                } //Fin while menu principal
                
            }//Fin while del programa
        
        }
    }//Fin main
}//Fin clase