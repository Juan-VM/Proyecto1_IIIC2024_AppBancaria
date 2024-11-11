
package ClasesProyecto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SimpeMovil {

    public static boolean validarSimpe(ArrayList<Integer> numerosRegistrados, double saldoCuenta, int numeroDestino, double montoSimpe){
        boolean validacion = false;
        
        if (numerosRegistrados.contains(numeroDestino)){
            if(saldoCuenta < montoSimpe){
                System.out.println("El monto que desea enviar es mayor al saldo de la cuenta a debitar");
                Herramientas.enterParaContinuar();
            }else{
                System.out.println("\nDesea realizar el simpe?\n");
                validacion = Herramientas.decisionGuardadoDatos();
            }
        }else{
            System.out.println("El numero al que intenta hacer el simpe no cuenta con cuenta simpeMovil, verifique los datos...");
            Herramientas.enterParaContinuar();
        }
        return validacion;
    }
    
    
    
    public static void mostarSimpe(String nombreDestino, double montoSimpe){
        System.out.println("Simpe realizado con exito...\n");
        System.out.printf("%s a recibido el simpe por un monto de %.2f colones.\n",nombreDestino,montoSimpe);
        
        Herramientas.enterParaContinuar();
    }
   
    
    public static void aumentarSaldoCuentaDestino(ArrayList<Persona> personasRegistradas, int numeroDestino, double montoSimpe){
        for(Persona i: personasRegistradas){
            if(i.getNumeroSimpe() == numeroDestino){
                i.setSaldoCuentaSimpe(i.getSaldoCuentaSimpe() + montoSimpe);
            }
        }
    }
    
    public static String realizarSimpe(ArrayList<Integer> numerosRegistrados,HashMap<String,Integer> simpesRegistrados,Persona persona, ArrayList<Persona> personasRegistradas){
        String comprobanteTransaccion = "Ninguno";
        
        boolean salir = false;
        while (salir == false){
            
            System.out.println("\nElije la cuenta que realizara el simpe:\n");
            String cuentaADebitar = Herramientas.mostarMenuDe4Opciones("Cuenta Corriente", "Cuenta Ahorro", "Cuenta Simpe","Salir");
            
            if(!cuentaADebitar.equals("4")){
                
                double montoSimpe = Herramientas.validarEntradaDouble("Ingrese el monto de dinero que desea pasar por simpe: >>> ");  
                int numeroDestino = Herramientas.validarEntradaInteger("Ingrese el numero de la persona a quien desea hacer el simpe: >>> ");

                String nombreDestino = "";
                for (String i : simpesRegistrados.keySet()){
                    if(simpesRegistrados.get(i) == numeroDestino){
                        nombreDestino = i;
                    }
                }
                
                String nombreEnvio = "";
                for (String i : simpesRegistrados.keySet()){
                    if(simpesRegistrados.get(i) == persona.getNumeroSimpe()){
                        nombreEnvio = i;
                    }
                }
                
                switch(cuentaADebitar){
                    case "1" -> {
                        if (persona.getSaldoCuenta() < montoSimpe){
                            System.out.println("El monto del simpe debe ser menor o igual al saldo de la cuenta");  
                            Herramientas.enterParaContinuar();
                        }else{
                            double saldoCuenta = persona.getSaldoCuenta();
                            boolean confirmarSimpe = validarSimpe(numerosRegistrados, saldoCuenta, numeroDestino, montoSimpe);

                            if(confirmarSimpe == true){
                                persona.setSaldoCuenta( persona.getSaldoCuenta() - montoSimpe);
                                aumentarSaldoCuentaDestino(personasRegistradas, numeroDestino, montoSimpe);
                                mostarSimpe(nombreDestino, montoSimpe);
                                comprobanteTransaccion = "Simpe por un monto de "+montoSimpe+" colones. Destinatario: "+nombreDestino+","+
                                                         "Has recibido un simpe por un monto de: "+montoSimpe+" de parte de "+nombreEnvio+","+
                                                         numeroDestino;
                                salir = true;
                            }else{
                                System.out.println("Deseas salir al menu prncipal?");
                                String op = Herramientas.mostarMenuDe2Opciones("Continuar", "Salir");
                                salir = (op.equals("1")) ? false : true;
                            }
                        }
                    }
                    case "2" -> {
                        if(persona.getEstadoCuentaAhorro() == true){
                            if (persona.getSaldoCuentaAhorro() < montoSimpe){
                                System.out.println("El monto del simpe debe ser menor o igual al saldo de la cuenta"); 
                                Herramientas.enterParaContinuar();
                            }else{
                                double saldoCuentaSimpe = persona.getSaldoCuentaAhorro();
                                boolean confirmarSimpe = validarSimpe(numerosRegistrados, saldoCuentaSimpe, numeroDestino, montoSimpe);

                                if(confirmarSimpe == true){
                                    persona.setSaldoCuentaAhorro( persona.getSaldoCuentaAhorro() - montoSimpe);
                                    aumentarSaldoCuentaDestino(personasRegistradas, numeroDestino, montoSimpe);
                                    mostarSimpe(nombreDestino, montoSimpe);
                                    comprobanteTransaccion = "Simpe por un monto de "+montoSimpe+" colones. Destinatario: "+nombreDestino+","+
                                                         "Has recibido un simpe por un monto de: "+montoSimpe+" de parte de "+nombreEnvio+","+
                                                         numeroDestino;
                                }else{
                                    System.out.println("Deseas salir al menu prncipal?");
                                    String op = Herramientas.mostarMenuDe2Opciones("Continuar", "Salir");
                                    salir = (op.equals("1")) ? false : true;
                                } 
                            }
                        }else{
                            System.out.println("\nLa cuenta de ahorro esta inactiva, debes de crearla antes de utilizar esta cuenta");
                            Herramientas.enterParaContinuar();
                        }
                    }
                    case "3" -> {
                        if(persona.getEstadoCuentaSimpe() == true){
                            if (persona.getSaldoCuentaSimpe() < montoSimpe){
                                System.out.println("El monto del simpe debe ser menor o igual al saldo de la cuenta"); 
                                Herramientas.enterParaContinuar();
                            }else{
                                double saldoCuentaSimpe = persona.getSaldoCuentaSimpe();
                                boolean confirmarSimpe = validarSimpe(numerosRegistrados, saldoCuentaSimpe, numeroDestino, montoSimpe);

                                if(confirmarSimpe == true){
                                    persona.setSaldoCuentaSimpe( persona.getSaldoCuentaSimpe() - montoSimpe);
                                    aumentarSaldoCuentaDestino(personasRegistradas, numeroDestino, montoSimpe);
                                    mostarSimpe(nombreDestino, montoSimpe);
                                    comprobanteTransaccion = "Simpe por un monto de "+montoSimpe+" colones. Destinatario: "+nombreDestino+","+
                                                         "Has recibido un simpe por un monto de: "+montoSimpe+" de parte de "+nombreEnvio+","+
                                                         numeroDestino;
                                }else{
                                    System.out.println("Deseas salir al menu prncipal?");
                                    String op = Herramientas.mostarMenuDe2Opciones("Continuar", "Salir");
                                    salir = (op.equals("1")) ? false : true;
                                } 
                            }
                        }else{
                            System.out.println("\nLa cuenta de simpe movil esta inactiva, debes de crearla antes de utilizar esta cuenta");
                            Herramientas.enterParaContinuar();
                        }
                    } 
                }
            } else{
                salir = true;
            }
        }
        return comprobanteTransaccion;
    } 
    
    public static void asignarComprobantesTransaccionACuentas(ArrayList<Persona> listaPersonas, String comprobante, Persona persona){
        if(!comprobante.equals("Ninguno")){
            String[] comprobantesSeparados = comprobante.split(",");
            String comprobanteTrnsEnviada = comprobantesSeparados[0];
            String comprobanteTrnsRecibida = comprobantesSeparados[1];
            String numeroQueEnvia = comprobantesSeparados[2];

            persona.addComprobantesSimpe(comprobanteTrnsEnviada);

            for(Persona i: listaPersonas){
                if(i.getNumeroSimpe()== Integer.parseInt(numeroQueEnvia)){
                    i.addComprobantesSimpe(comprobanteTrnsRecibida);
                }
            }

        }
    }
    
    public static void cambiarDatosCuentaSimpe(ArrayList<Integer> numerosRegistrados,HashMap<String, Integer> cuentasSimpeMovil,Persona persona){
        Scanner leer = new Scanner(System.in);
        boolean centinela = true;
        while(centinela == true){
            System.out.println("\n--- CAMBIAR DATOS CUENTA SIMPE ---\n");
            
            System.out.println("Ingrese la opcion que desea:\n");
            String opcion = Herramientas.mostarMenuDe3Opciones("Cambiar nombre usuario", "Cambiar numero telefono", "Salir");
            switch(opcion){
                case "1" ->{
                    System.out.println("\n--- CAMBIAR USUARIO SIMPE ---\n");
                    System.out.print("Ingrse su usuario anterior: >>> ");
                    String usuarioAnterior = leer.nextLine();

                    if(usuarioAnterior.equals(persona.getUsuarioSimpe())){
                        System.out.print("Ingrse su usuario nuevo: >>> ");
                        String usuarioNuevo = leer.nextLine();  

                        System.out.println("\nDesea guardar el cambio?\n");
                        boolean desicion = Herramientas.decisionGuardadoDatos();
                        if(desicion == true){
                            persona.setUsuarioSimpe(usuarioNuevo);
                            cuentasSimpeMovil.remove(usuarioAnterior);
                            cuentasSimpeMovil.put(usuarioNuevo, persona.getNumeroSimpe());
                            System.out.println("Cambio realizado con exito");
                            Herramientas.enterParaContinuar();
                        }
                    }else{
                        System.out.println("El usuario ingresado no coincide...");
                        Herramientas.enterParaContinuar();
                    }
                }
                case "2" ->{
                    System.out.println("\n--- CAMBIAR TELEFONO SIMPE ---\n");
                    int numeroAnterior = Herramientas.validarEntradaInteger("Ingrse su numero de telefono anterior: >>> ");

                    if(numeroAnterior == persona.getNumeroSimpe()){
                        int numeroNuevo = Herramientas.validarEntradaInteger("Ingrse su numero de telefono nuevo: >>> ");
                        System.out.println("\nDesea guardar el cambio?\n");
                        boolean decision = Herramientas.decisionGuardadoDatos();
                        if(decision == true){
                            persona.setNumeroSimpe(numeroNuevo);
                            numerosRegistrados.remove(Integer.valueOf(numeroAnterior));
                            numerosRegistrados.add(numeroNuevo);
                            cuentasSimpeMovil.put(persona.getUsuarioSimpe(), numeroNuevo);
                            System.out.println("Cambio realizado con exito");
                            Herramientas.enterParaContinuar();
                        }
                    }else{
                        System.out.println("El numero ingresado no coincide...");
                        Herramientas.enterParaContinuar();
                    }
                }
                case "3" ->{
                    centinela = false;
                }
            }
        }
    }
}
