
package ClasesProyecto;

import java.util.Random;
import java.util.Scanner;

public class Herramientas {
    
    //RECIBE UNA VARIABLE (opcion) Y UNA LISTA[] (lista).
    //VALIDA SI (opcion) EXISTE EN LA LISTA, Y RETORNA TRUE O FALSE.
    public static boolean opcionEnOpciones(String opcion, String[] lista){
        boolean confirmacion = false;
        
        for (String i : lista) {
            if (i.equalsIgnoreCase(opcion))
                confirmacion = true;
        }
        return confirmacion;
    }
    
    
    //FUNCION QUE MUESTRA UN MENU DE 2 OPCIONES, LEE Y VALIDA Y RETORNA LA OPCION INGRESADA.
    public static String mostarMenuDe2Opciones(String op1, String op2){
        Scanner leer = new Scanner(System.in); 
        String opciones[] = new String []{"1","2"};
        String variable;
        
        while (true){
            System.out.printf("1. %s\n2. %s\n\n>>> ", op1, op2);
            variable = leer.nextLine();
            variable = variable.trim();

            if (opcionEnOpciones(variable, opciones)){
                break;
            }else{
                System.out.println("Opcion Inexistente\n");
            }
        }
        return variable;
    }
    
    
    //FUNCION QUE MUESTRA UN MENU DE 3 OPCIONES, LEE Y VALIDA Y RETORNA LA OPCION INGRESADA.  
    public static String mostarMenuDe3Opciones(String op1, String op2, String op3){
        Scanner leer = new Scanner(System.in); 
        String opciones[] = new String []{"1","2","3"};
        String variable;
        
        while (true){
            System.out.printf("1. %s\n2. %s\n3. %s\n\n>>> ", op1, op2,op3);
            variable = leer.nextLine();
            variable = variable.trim();

            if (opcionEnOpciones(variable, opciones)){
                break;
            }else{
                System.out.println("Opcion Inexistente\n");
            }
        }
        return variable;
    }
    
    //FUNCION QUE MUESTRA UN MENU DE 4 OPCIONES, LEE Y VALIDA Y RETORNA LA OPCION INGRESADA.
    public static String mostarMenuDe4Opciones(String op1, String op2, String op3, String op4){
        Scanner leer = new Scanner(System.in); 
        String opciones[] = new String []{"1","2","3","4"};
        String variable;
        
        while (true){
            System.out.printf("1. %s\n2. %s\n3. %s\n4. %s\n\n>>> ", op1, op2,op3,op4);
            variable = leer.nextLine();
            variable = variable.trim();

            if (opcionEnOpciones(variable, opciones)){
                break;
            }else{
                System.out.println("Opcion Inexistente\n");
            }
        }
        return variable;
    }
    
    //FUNCION QUE MUESTRA UN MENU DE 5 OPCIONES, LEE Y VALIDA Y RETORNA LA OPCION INGRESADA.
    public static String mostarMenuDe5Opciones(String op1, String op2, String op3, String op4, String op5){
        Scanner leer = new Scanner(System.in); 
        String opciones[] = new String []{"1","2","3","4","5"};//Se agrega comentarios
        String variable;
        
        while (true){
            System.out.printf("1. %s\n2. %s\n3. %s\n4. %s\n5. %s\n\n>>> ", op1, op2,op3,op4,op5);
            variable = leer.nextLine();
            variable = variable.trim();

            if (opcionEnOpciones(variable, opciones)){
                break;
            }else{
                System.out.println("Opcion Inexistente\n");
            }
        }
        return variable;
    }
    
    
    //RETORNA TRUE EN CASO DE QUE QUIERA GUARDARLOS, FALSE EN CASO CONTRARIO.
    public static boolean decisionGuardadoDatos(){
        boolean vali = false;
        while (true){
            String opcion = mostarMenuDe2Opciones("Si","No");

            if(opcion.equals("1")){ 
                vali = true;
                break;
            }else if (opcion.equals("2")){
                break;   
            }
        }
        return vali;
    }
    
    public static String mostarMenuDe8Opciones(String op1, String op2, String op3, String op4, String op5, String op6,String op7, String op8){
        Scanner leer = new Scanner(System.in); 
        String opciones[] = new String []{"1","2","3","4","5","6","7","8"};
        String variable;
        
        while (true){
            System.out.printf("1. %s\n2. %s\n3. %s\n4. %s\n5. %s\n6. %s\n7.%s\n 8.%s\n\n>>> ", op1, op2,op3,op4,op5,op6,op7,op8);
            variable = leer.nextLine();
            variable = variable.trim();

            if (opcionEnOpciones(variable, opciones)){
                break;
            }else{
                System.out.println("Opcion Inexistente\n");
            }
        }
        return variable;
    }
    
    
    //Valida que no haya errores en un datos de tipo double ingresado por teclado.
    public static double validarEntradaDouble(String instruccion){
        Scanner leer = new Scanner(System.in); 
        double entrada = 0;
        boolean centinela = true;
        
        while(centinela == true){
            System.out.printf("%s",instruccion);
            try {
                entrada = leer.nextDouble();
                centinela = false;
            } catch (Exception e) {
                System.out.println("\nError..el valor ingresado debe ser numerico\n");
                leer.next();
            }
        }
        return entrada;
    }
    
    public static int validarEntradaInteger(String instruccion){
        Scanner leer = new Scanner(System.in); 
        int entrada = 0;
        boolean centinela = true;
        
        while(centinela == true){
            System.out.printf("%s",instruccion);
            try {
                entrada = leer.nextInt();
                centinela = false;
            } catch (Exception e) {
                System.out.println("\nError..el valor ingresado debe ser numerico\n");
                leer.next();
            }
        }
        return entrada;
    }
    
    public static void enterParaContinuar(){
        Scanner leer = new Scanner(System.in); 
        System.out.print("\nPulse enter para continuar: >>> ");
        leer.nextLine();
    }
    
    public class comentario{
        
    }
}//Fin clase Herramientas