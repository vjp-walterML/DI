package juego_uno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author wmartinl01
 */
public class Juego {

    final static String[] COLORES = {"ROJO", "AZUL", "AMARILLO", "VERDE"};
    final static int[] NUMEROS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    final static int CARTAS_REPARTIR = 7;
    public static final String rojo = "\u001B[31m";
    public static final String azul = "\u001B[34m";
    public static final String amarillo = "\u001B[33m";
    public static final String verde = "\u001B[32m";
    public static boolean juegoTerminado = false;
    public static List<Carta> mazo = new ArrayList<>();
    public static List<Carta> mesa = new ArrayList<>();
    public static List<Carta> cartasUsuario = new ArrayList<>();
    public static List<Carta> cartasMaquina = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(rojo + "****************************************");
        System.out.println(amarillo + "********* B I E N VE N I D O ***********");
        System.out.println(amarillo + "********** A L   U N O   D E ***********");
        System.out.println(amarillo + "************* W A L T E R **************");
        System.out.println(rojo + "****************************************\n");

        //Creamos el mazo e iniciamos el juego barajando y repartiendo las cartas.
        rellenarMazo();
        iniciarJuego();
        mostrarCartas();
//        while (!juegoTerminado) {
//            //mostrarCartas();
//            turnoUsuario();
//            //mostrarCartas();
//            comprobarJugada();
//            turnoMaquina();
//            comprobarJugada();
//        }
    }

    //Todas las acciones necesarias del turno de la máquina
    public static void turnoMaquina() {
        boolean jugada = false;
        //Primero compruebo si el juego ha terminado, si no es asi actua
        if (!juegoTerminado) {
            for (Carta carta : cartasMaquina) {
                if (carta.valida(mesa.get(mesa.size() - 1))) {
                    mesa.add(carta);
                    cartasMaquina.remove(carta);
                    jugada = true;
                    break;
                }
            }
            if (!jugada) {
                cartasMaquina.add(mazo.remove(0));
                System.out.println("---- LA MÁQUINA HA ROBADO CARTA ----");
            } else {
                System.out.println("---- LA MÁQUINA HA JUGADO CARTA ----");
            }
        }
    }

    //Todas las acciones necesarias del turno del usuario
    public static void turnoUsuario() {
        Carta cartaElegida;
        int carta;
        if (!juegoTerminado) {
            carta = pedirNumeroCarta();
            //Compruebo si ha elegido la opción robar si es asi robamos y pasamos turno
            if (carta == (cartasUsuario.size() + 1)) {
                cartasUsuario.add(mazo.remove(0));
                System.out.println("----- HAS ROBADO UNA CARTA -----");
            } else {
                cartaElegida = cartasUsuario.get(carta);
                //Compruebo si el jugador puede jugar esa carta o debe realizar otra opcion
                if (cartaElegida.valida(mesa.get(mesa.size() - 1))) {
                    mesa.add(cartasUsuario.remove(carta));
                } else {
                    System.out.println("----- ¡NO PUEDES JUGAR ESA CARTA!, ¡ELIGE OTRA O ROBA! -----");
                    turnoUsuario();
                }
            }
        }
    }

    //Este método comprueba si se ha terminado el juego y quien es el ganador
    public static void comprobarJugada() {
        if (!juegoTerminado) {
            // Condiciones de finalización
            if (cartasUsuario.isEmpty() || cartasMaquina.isEmpty() || mazo.isEmpty()) {
                juegoTerminado = true; // Termina el juego

                if (cartasUsuario.size() < cartasMaquina.size()) {
                    System.out.println("----- ¡ENHORABUENA! ¡HAS GANADO! -----");
                } else if (cartasUsuario.size() > cartasMaquina.size()) {
                    System.out.println("----- ¡LO SIENTO! ¡LA MÁQUINA HA GANADO! -----");
                    System.out.println("\n******************************************");
                    System.out.println("*********** G A M E    O V E R ***********");
                    System.out.println("******************************************");
                } else {
                    System.out.println("----- EMPATE -----");
                }
            }
        }
    }

    //Rellena la lista de mazo con las respectivas cartas y luego las baraja.
    public static void rellenarMazo() {
        for (String c : COLORES) {
            for (int n : NUMEROS) {
                mazo.add(new Carta(n, c));
                mazo.add(new Carta(n, c));
            }
        }
        //Barajamos con el Collections.shuffle
        Collections.shuffle(mazo);
    }

    //Reparte 7 cartas a cada usuario, eliminandolas del mazo y añade una al centro de la mesa
    public static void iniciarJuego() {
        for (int i = 0; i < CARTAS_REPARTIR; i++) {
            cartasUsuario.add(mazo.remove(0));
            cartasMaquina.add(mazo.remove(0));
        }
        //Añadimos una carta al centro de la mesa
        mesa.add(mazo.remove(0));
    }

    //Muestra todas las cartas de la mesa
    public static void mostrarCartas() {
        List<List<String>> cartas = new ArrayList<>();
        if (!juegoTerminado) {

            // Obtiene las representaciones de todas las cartas del usuario
            for (Carta carta : cartasUsuario) {
                cartas.add(carta.mostrarCartaUsuario());
            }

            // Imprime las cartas lado a lado
            for (int i = 0; i < 5; i++) { // Cada carta tiene 5 líneas
                for (List<String> c : cartas) {
                    System.out.print(c.get(i));
                }
                System.out.println(); // Salto de línea después de imprimir todas las cartas en la misma fila
            }
        }
    }

    //Pedir un numero de carta
    public static int pedirNumeroCarta() {
        Scanner entrada = new Scanner(System.in);
        int carta;
        System.out.println("Por favor, elige la carta:");
        carta = entrada.nextInt();

        //Comprobamos si la carta existe si no la volvemos a pedir
        if (carta < 0 || carta > (cartasUsuario.size() + 1)) {
            System.out.println("ERROR.Introduce una carta válida.");
            carta = pedirNumeroCarta();
        }
        return carta;
    }

}
