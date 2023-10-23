package LogicaJuego;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wmartinl01
 */

//Esta clase representará el estado actual del juego en la mesa
public class Mesa {
    
    //Atributos
    private List<Jugador> jugadores;
    private Mazo mazo;
    private int ronda;
    
    //Constructores

    public Mesa() {
        jugadores =new ArrayList<>();
        mazo = new Mazo();
        ronda = 0;
    }

    public Mesa(List<Jugador> jugadores, Mazo mazo,int ronda) {
        this.jugadores = jugadores;
        this.mazo = mazo;
        this.ronda = ronda;
    }
    
    //Getter y Setter

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }
    
    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }
    
    //MÉTODOS PROPIOS
    public void iniciarRonda(){
        
    }
    
    public void finalizarRonda(){
        //Calcular los puntos de cada uno y sumarselos
        //...
    }
    
    //Calcular puntuacion
    
    public Jugador ganador(){
        return null;
    }
}
