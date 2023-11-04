package LogicaJuego;

import InterfazGrafica.VentanaJuego;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wmartinl01
 */
//Aquí se implementará toda la lógica principal del juego
public class Juego {

    private VentanaJuego ventanaJuego;

    //Atributos
    private Mazo mazo;
    private Jugador usuario;
    private Jugador cpu1;
    private Jugador cpu2;
    private List<Jugador> jugadores;
    private int ronda;
    private boolean finJuego;

    //Constructores
    public Juego(String nombreUsuario) {
        this.mazo = new Mazo();
        this.jugadores = new ArrayList<>();
        crearJugadorUsuario(nombreUsuario);
        crearJugadoresCPU();
        this.ronda = 1;
        this.finJuego = false;
    }

    public void comunicarVentanaJuego(VentanaJuego ventanaJuego) {
        this.ventanaJuego = ventanaJuego;
    }

    //Getter y Setter
    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public boolean isFinJuego() {
        return finJuego;
    }

    public void setFinJuego(boolean finJuego) {
        this.finJuego = finJuego;
    }

    //MÉTODOS PROPIOS
    private void crearJugadorUsuario(String nombre) {
        usuario = new Jugador(nombre, mazo.repartirCartas(Constantes.NUM_CARTAS), 0, 0, "USER");
        jugadores.add(usuario);
    }

    private void crearJugadoresCPU() {
        cpu1 = new Jugador(Constantes.CPU1, mazo.repartirCartas(Constantes.NUM_CARTAS), 0, 0, "CPU");
        cpu2 = new Jugador(Constantes.CPU2, mazo.repartirCartas(Constantes.NUM_CARTAS), 0, 0, "CPU");
        jugadores.add(cpu1);
        jugadores.add(cpu2);
    }

    public void jugarTurnoUsuario(int cartaSeleccionada) {
        //Muevo la carta a mano
//        usuario.getMano().add(usuario.getCartasVisibles().remove(cartaSeleccionada));
//        ventanaJuego.actualizarCartas();
//ventanaJuego.borrarTOOO();
    }

    private void jugarTurnoCPU() {

    }

    private void calcularPuntuacionRonda() {

    }

    public Jugador comprobarGanador() {
        //el jugador que haya acumulado más puntos después de tres
//rondas. Si hay dos o más jugadores empatados, gana quien tenga
//más cartas de pudin.
        return null;
    }
}
