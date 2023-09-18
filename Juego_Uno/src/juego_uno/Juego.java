package juego_uno;

import java.util.ArrayList;

/**
 *
 * @author wmartinl01
 */
public class Juego {

    final static String[] COLORES = {"ROJO", "AZUL", "AMARILLO", "VERDE"};
    final static int[] NUMEROS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//    public static ArrayList<Carta> mazo = new ArrayList<>();
//    public static ArrayList<Carta> cartasMesa = new ArrayList<>();
//    public static ArrayList<Carta> mazoUsuario = new ArrayList<>();
//    public static ArrayList<Carta> mazoMaquina = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Carta> mazo = new ArrayList<>();
        ArrayList<Carta> cartasMesa = new ArrayList<>();
        ArrayList<Carta> mazoUsuario = new ArrayList<>();
        ArrayList<Carta> mazoMaquina = new ArrayList<>();

        rellenarMazo();
        mostrarMazo();
    }

    //Rellena el mazo
    public static void rellenarMazo() {
        for (String c : COLORES) {
            for (int n : NUMEROS) {
                mazo.add(new Carta(n, c));
                mazo.add(new Carta(n, c));
            }
        }
    }

    //Reparte 7 cartas a cada usuario, eliminandolas del mazo
    public static void repartirCartas() {

    }

    //Muestra el mazo 
    public static void mostrarMazo() {
        for (Carta c : mazo) {
            c.mostrarCarta();
        }
    }

    //Muestra el mazo en filas de 4
    public static void mostrarMazo4() {
        Carta carta;
        ArrayList<Carta> mazoAuxiliar = new ArrayList<>();
        int contador = 0;
        for (Carta c : mazo) {
            carta = c;
            mazoAuxiliar.add(c);
            contador++;
            if (contador == 4) {
                System.out.println(" -------------     -------------     -------------     -------------");
                System.out.println("|             |   |             |   |             |   |             |");
                System.out.println("|     " + mazoAuxiliar.get(0).getNumero() + "       |         " + mazoAuxiliar.get(1).getNumero() + "       |         " + mazoAuxiliar.get(2).getNumero() + "       |         " + mazoAuxiliar.get(3).getNumero());
                System.out.println("|             |   |             |   |             |   |             |");
                System.out.println("|   " + mazoAuxiliar.get(0).getColor() + "     |       " + mazoAuxiliar.get(1).getColor() + "     |       " + mazoAuxiliar.get(2).getColor() + "     |       " + mazoAuxiliar.get(3).getColor());
                System.out.println("|             |   |             |   |             |   |             |");
                System.out.println(" -------------     -------------     -------------     -------------");
                contador = 0;
                mazoAuxiliar.clear();
            }

        }
    }
}
