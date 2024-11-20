
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
    public void insertar_dato(Personas usuario){
        ArrayList<Personas> comentario = new ArrayList<>();
        
        
        File fichero = new File(mensaje);//ficheros txt en blanco
        
        Personas p = new Personas();
        
        p.setUsuario(usuario.getUsuario());
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingrese un comentario:");///guarda los datos en la clases con el scanner
        p.comentario = entrada.nextLine();

        comentario.add(new Personas(p.getUsuario(),p.getComentario()));
        guadar(comentario);//guada los datos en arraylist
    }
    
    public void guadar(ArrayList<Personas> lista) {

        try {
            BufferedWriter escribir = new BufferedWriter(new FileWriter(mensaje, true));
            for (Personas list : lista) {
                escribir.write(list.getUsuario()+"\t"+list.getComentario());
                escribir.newLine();
            }
            escribir.close();
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    public void leer(ArrayList<Personas> lista) {
        try {
            BufferedReader leer = new BufferedReader(new FileReader(mensaje));//leer el txt
            String linea = "";
            while ((linea = leer.readLine()) != null) {
                String[] arreglo = linea.split("\t");
                if (arreglo.length == 2) {
                    String usuario = arreglo[0];
                    String Comentario = arreglo[1];
                    lista.add(new Personas(usuario,Comentario));
                }
            }
            leer.close();
        } catch (IOException e) {
            System.out.println("error" + e.getMessage());
        }
    }
}
