
package ClasesProyecto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Comentarios {
    public static String mensaje = "Comentarios.txt";
    public void insertar_dato(Persona usuario){
        ArrayList<Persona> comentario = new ArrayList<>();
        
        
        File fichero = new File(mensaje);//ficheros txt en blanco
        
        Persona p = new Persona();
        
        p.setUsuario(usuario.getUsuario());
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingrese un comentario:");///guarda los datos en la clases con el scanner
        p.comentario = entrada.nextLine();

        comentario.add(new Persona(p.getUsuario(),p.getComentario()));
        guadar(comentario);//guada los datos en arraylist
    }
    
    public void guadar(ArrayList<Persona> lista) {

        try {
            BufferedWriter escribir = new BufferedWriter(new FileWriter(mensaje, true));
            for (Persona list : lista) {
                escribir.write(list.getUsuario()+"\t"+list.getComentario());
                escribir.newLine();
            }
            escribir.close();
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    public void leer(ArrayList<Persona> lista) {
        try {
            BufferedReader leer = new BufferedReader(new FileReader(mensaje));//leer el txt
            String linea = "";
            while ((linea = leer.readLine()) != null) {
                String[] arreglo = linea.split("\t");
                if (arreglo.length == 2) {
                    String usuario = arreglo[0];
                    String Comentario = arreglo[1];
                    lista.add(new Persona(usuario,Comentario));
                }
            }
            leer.close();
        } catch (IOException e) {
            System.out.println("error" + e.getMessage());
        }
    }
    
}
