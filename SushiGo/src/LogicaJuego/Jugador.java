package LogicaJuego;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wmartinl01
 */
//Esta clase representa un jugador del juego, puede ser el usuario o CPU
public class Jugador {

    //Atributos
    private String nombre;
    private List<Carta> mano;
    private int puntuacion;
    private int puddings;
    private String tipo;

    //Constructores
    public Jugador() {
        nombre = "";
        mano = new ArrayList<>();
        puntuacion = 0;
        puddings = 0;
        tipo = "";
    }

    public Jugador(String nombre, List<Carta> mano, int puntuacion, int puddings, String tipo) {
        this.nombre = nombre;
        this.mano = mano;
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

    //Añadir pudding
    public void aniadirPudding() {
        puddings++;
    }
}
