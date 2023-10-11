package Logica;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author wmartinl01
 */
public class Tiempo {

    //Atributo ventana juego, que recibia por constructor
    private Timer timer;
    private int segundos = 0;

    public Tiempo() {
        this.timer = new Timer();
    }

    //Clase interna que funciona como contador
    class Contador extends TimerTask {

        //Atributo VentanaJuego, que recibia por constructor
        public Contador() {
        }

        public void run() {
            segundos++;
            //Implemento el método actualizar segundos
        }
    }

    //Crea un timer, inicia segundos a 0 y comienza a contar
    public void Contar() {
        this.segundos = 0;
        timer = new Timer();
        timer.schedule(new Contador(), 0, 1000);
    }

    //Detiene el contador
    public void Detener() {
        timer.cancel();
    }

    //Metodo que retorna los segundos transcurridos
    public int getSegundos() {
        return this.segundos;
    }
}
