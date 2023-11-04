package LogicaJuego;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wmartinl01
 */
//Esta clase representa un jugador del juego, puede ser el USER o CPU
public class Jugador {

    //Atributos
    private String nombre;
    private List<Carta> mano;
    private List<Carta> cartasVisibles;
    private int puntuacion;
    private int puddings;
    private String tipo;

    //Constructores
    public Jugador(String nombre, List<Carta> cartasVisibles, int puntuacion, int puddings, String tipo) {
        this.nombre = nombre;
        this.cartasVisibles = cartasVisibles;
        this.mano = new ArrayList<>();
        this.puntuacion = puntuacion;
        this.puddings = puddings;
        this.tipo = tipo;
    }

    //Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Carta> getMano() {
        return mano;
    }

    public void setMano(List<Carta> mano) {
        this.mano = mano;
    }

    public List<Carta> getCartasVisibles() {
        return cartasVisibles;
    }

    public void setCartasVisibles(List<Carta> cartasVisibles) {
        this.cartasVisibles = cartasVisibles;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getPuddings() {
        return puddings;
    }

    public void setPuddings(int puddings) {
        this.puddings = puddings;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //MÉTODOS PROPIOS
    //Añade puntuacion
    public void sumarPuntos(int puntos) {
        puntuacion += puntos;
    }

    //Retorna true si el jugador es tipo CPU
    public boolean esCPU() {
        return tipo.equalsIgnoreCase("CPU");
    }

    //Retorna un objeto carta según el índice
    public Carta jugarCarta(int indice) {
        return mano.get(indice);
    }

    //Añade la carta a la mano
    public void cogerCarta(Carta carta) {
        mano.add(carta);
    }

    //Añadir pudding
    public void aniadirPudding() {
        puddings++;
    }
}
