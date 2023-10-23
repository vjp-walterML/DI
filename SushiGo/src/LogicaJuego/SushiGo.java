package LogicaJuego;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wmartinl01
 */

//Aquí se implementará toda la lógica principal del juego
public class SushiGo {

    //Atributos
    private Mesa mesa;
    private Jugador usuario;
    private List<Jugador> jugadoresCPU;

    //Constructores
    public SushiGo() {
        mesa = new Mesa();
        usuario = new Jugador();
        jugadoresCPU = new ArrayList<>();
    }

    public SushiGo(Mesa mesa, Jugador usuario, List<Jugador> jugadoresCPU) {
        this.mesa = mesa;
        this.usuario = usuario;
        this.jugadoresCPU = jugadoresCPU;
    }

    //Getter y Setter
    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Jugador getUsuario() {
        return usuario;
    }

    public void setUsuario(Jugador usuario) {
        this.usuario = usuario;
    }

    public List<Jugador> getJugadoresCPU() {
        return jugadoresCPU;
    }

    public void setJugadoresCPU(List<Jugador> jugadoresCPU) {
        this.jugadoresCPU = jugadoresCPU;
    }

    //MÉTODOS PROPIOS
    public void iniciarJuego() {

    }

    public void jugarRonda() {

    }

    public void finalizarJuego() {

    }
}
