
package Buzon;

import java.util.ArrayList;


public class BuzonMensajes {

    public ArrayList<Mensaje> buzonMensajes = new ArrayList<>();

    public BuzonMensajes() {
        
    }

    public ArrayList<Mensaje> getBuzonMensajes() {
        return buzonMensajes;
    }

    public void setBuzonMensajes(ArrayList<Mensaje> buzonMensajes) {
        this.buzonMensajes = buzonMensajes;
    }
    
    public void agregarMensajeAlBuzon(Mensaje msj){
        this.buzonMensajes.add(msj);
    }
    
    public void eliminarMensajeDelBuzon(Mensaje msj){
        this.buzonMensajes.remove(msj);
    }
}
