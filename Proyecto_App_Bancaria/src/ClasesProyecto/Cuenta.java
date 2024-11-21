package ClasesProyecto;

import Personas.Usuarios;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Cuenta {

    //Lee un valor ingresado por el usuario lo valida y luego lo retorna.
    public static double ingresarMontoRetiro(Personas persona, String cuentaElejida) {

        Scanner leer = new Scanner(System.in);
        double saldoCuenta;
        
        if(cuentaElejida.equals("1")){
            saldoCuenta = persona.getSaldoDeLaCuenta();
        }else if(cuentaElejida.equals("2")){
            saldoCuenta = persona.getSaldoCuentaAhorro();
        }else{
            saldoCuenta = persona.getSaldoCuentaSimpe();
        }
        
        double monto = 0.0;

        boolean centinela = false;
        while (centinela == false) {
            try {
                System.out.println("\n--- RETIRAR DINERO ---\n");
                System.out.print("Ingrese le monto que desea retirar o 1 para salir: >>> ");
                monto = Double.parseDouble(leer.nextLine());

                if (monto % 1000.0 == 0.0 && monto >= 0 && monto <= saldoCuenta && monto != 1) {

                    System.out.printf("\nDeseas retirar el monto de: %.1f\n\n", monto);
                    boolean decision = Herramientas.decisionGuardadoDatos();
                    if (decision == true) {
                        centinela = true;
                        System.out.println("\nRetiro realizado con exito. Puede consultar su saldo en la opcion 2 del menu.");
                        System.out.printf("El monto retirado es de %.1f colones.\n", monto);
                    }
                } else if (monto == 1) {
                    centinela = true;
                    monto = 0;
                } else {
                    System.out.println("\nError...El monto a retirar debe cumplir lo siguente:\n");
                    System.out.println("1. Debe ser multiplo de 1000.\n2. Debe ser mayor o igual a 1000 colones.\n3. Debe ser igual o menor al saldo de la cuenta.");
                    System.out.print("\nPulse enter para continuar: >>> ");
                    leer.nextLine();

                }
            } catch (Exception e) {
                System.out.print("\nError...el monto a retirar debe ser numerico\nPulse enter para continuar: >>> ");
                leer.nextLine();
            }
        }
        return monto;
    }

    //Lee un valor ingresado por teclado, lo valida y luego lo retorna.
    public static double ingresarMontoDeposito() {
        Scanner leer = new Scanner(System.in);
        double cantidad = 0;
        boolean centinela;

        do {
            centinela = true;

            while (true) {

                System.out.println("\n--- DEPOSITAR ---\n");
                cantidad = Herramientas.validarEntradaDouble("Ingrese la cantidad de dinero a depositar o 0 para salir: >>> ");

                if (cantidad != 0) {
                    System.out.printf("\nDesea depositar %.2f colones:\n\n", cantidad);
                    boolean desicion = Herramientas.decisionGuardadoDatos();

                    if (desicion == true) {
                        break;
                    }

                } else if (cantidad == 0) {
                    centinela = false;
                    break;
                }
            }

            if (cantidad > 0) {
                System.out.printf("\nSe depositaron: %.2f colones.\n", cantidad);
                centinela = false;
                System.out.print("\nPulse enter para continuar >>> ");
                leer.nextLine();

            } else if (cantidad < 0) {
                System.out.println("\nLa cantidad a depositar debe ser mayor a 0.");
                cantidad = 0.0;
                System.out.print("Pulse enter para continuar >>> ");
                leer.nextLine();
            }
        } while (centinela == true);
        return cantidad;
    }

    //Muetra el valor de la variable de instancia saldoDeLaCuenta.
    public static void verSaldoCuenta(Personas persona, String cuentaElejida) {
        Scanner leer = new Scanner(System.in);

        System.out.println("\n--- VER SALDO ---\n");
        if(cuentaElejida.equals("1")){
            System.out.printf("El saldo de su cuenta es: %.3f\n", persona.getSaldoDeLaCuenta());
        }else if (cuentaElejida.equals("2")){
            System.out.printf("El saldo de su cuenta es: %.3f\n", persona.getSaldoCuentaAhorro());
        }else if (cuentaElejida.equals("3")){
            System.out.printf("El saldo de su cuenta es: %.3f\n", persona.getSaldoCuentaSimpe());
        }
        
        System.out.print("\nPresiona enter para continuar: >>> ");
        leer.nextLine();
    }

    public static void mostarTipoDeCambio(double monto) {
        Scanner leer = new Scanner(System.in);
        int billetes20000, billetes10000, billetes5000, billetes2000, billetes1000;
        double montoDeCambio = monto;

        if (monto > 0) {
            System.out.println("Recibira el dinero retirado de la siguiente forma:\n");

            billetes20000 = (int) montoDeCambio / 20000;
            montoDeCambio %= 20000;

            billetes10000 = (int) montoDeCambio / 10000;
            montoDeCambio %= 10000;

            billetes5000 = (int) montoDeCambio / 5000;
            montoDeCambio %= 5000;

            billetes2000 = (int) montoDeCambio / 2000;
            montoDeCambio %= 2000;

            billetes1000 = (int) montoDeCambio / 1000;
            montoDeCambio %= 1000;

            if (billetes20000 > 0) {
                System.out.printf("Cant.Billetes de 20 000 colones: %d\n", billetes20000);
            }
            if (billetes10000 > 0) {
                System.out.printf("Cant.Billetes de 10 000 colones: %d\n", billetes10000);
            }
            if (billetes5000 > 0) {
                System.out.printf("Cant.Billetes de 5000 colones: %d\n", billetes5000);
            }
            if (billetes2000 > 0) {
                System.out.printf("Cant.Billetes de 2000 colones: %d\n", billetes2000);
            }
            if (billetes1000 > 0) {
                System.out.printf("Cant.Billetes de 1000 colones: %d\n", billetes1000);
            }

            System.out.print("\nPresiona enter para continuar: >>> ");
            leer.nextLine();
        }
    }

    public static void crearNuevaCuentaSimpe(ArrayList<Integer> numerosRegistrados,HashMap<String,Integer> cuentasSimpe, Personas persona) {
        Scanner leer = new Scanner(System.in);
        int numeroTelefono = 0;

        int centinela = 1;
        while(centinela != 0){
            
            System.out.print("Ingrese el nombre de usuario que desea ligar a esta cuenta o 0 para salir: >>> ");
            String nombreUsuario = leer.nextLine();
            
            
            if(!nombreUsuario.equals("0")){
                numeroTelefono = Credenciales.addNumeroTelefono(numerosRegistrados);

                System.out.println("\nDesea guardar los datos ingresados?\n");
                boolean decision = Herramientas.decisionGuardadoDatos();
                if(decision == true){
                    System.out.println("Cuenta registrada existosamente...");
                    persona.setUsuario(nombreUsuario);
                    persona.setEstadoCuentaSimpe(true);
                    cuentasSimpe.put(nombreUsuario, numeroTelefono);
                    persona.setTelefono(String.valueOf(numeroTelefono));
                    System.out.print("\nPresiona enter para continuar: >>> ");
                    leer.nextLine();
                    centinela = 0;
                }
            }else{
                centinela = 0;
            }
        }
        
    }
    
    public static void crearCuentaAhorro(Personas persona){
        
        System.out.println("\n--- CREAR CUENTA AHORROS ---\n");
        System.out.println("Desea habilitar una cuenta de ahorro?:\n");
        boolean desicion = Herramientas.decisionGuardadoDatos();
        
        if(desicion == true){
            persona.setEstadoCuentaAhorro(true);
            System.out.printf("Cuenta de ahorros habilitada para el usuario: %s\n", persona.getUsuario());
            Herramientas.enterParaContinuar();
        }
    }
    
    public static String elejirCuentaParaLaFuncion(String instruccion){
        System.out.println(instruccion);
        String cuentaElejida = Herramientas.mostarMenuDe4Opciones("Cuenta corriente", "Cuenta ahorro", "Cuenta simpe movil", "Salir");
        return cuentaElejida;
    }

} // Fin clase Cuenta
