package ejercicioexamen3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Walter
 */
public class LogicaNegocio {

    //Lista
    private List<Juego> lJuegos = new ArrayList<>();

    //Constructor
    public LogicaNegocio() {
        lJuegos.add(new Juego("Juego 1", "Plataforma 1", 255.2f));
        lJuegos.add(new Juego("Juego 2", "Plataforma 2", 2.2f));
        lJuegos.add(new Juego("Juego 3", "Plataforma 1", 125.2f));
        lJuegos.add(new Juego("Juego 4", "Plataforma 2", 25.2f));
    }

    //Getter
    public List<Juego> getlJuegos() {
        return lJuegos;
    }
     

}
