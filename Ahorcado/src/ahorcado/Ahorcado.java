
package ahorcado;

import java.util.Scanner;

/**
 *
 * @author wmartinl01
 */
public class Ahorcado {

    final static String[] PALABRAS = {"WA"};
    final static int MAX_FALLOS = 7;
    public static int FALLOS = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("**************************************");
        System.out.println("******** B I E N VE N I D O **********");
        System.out.println("**************************************\n");
        String palabraSeleccionada = PALABRAS[(int) Math.round(Math.random() * PALABRAS.length)];
        Character[] palabraUsuario = new Character[palabraSeleccionada.length()];
        char letraAux;
        do {
            pintarAhorcado(FALLOS);
            letraAux = pedirLetra();
            palabraUsuario = actualizarPalabraUsuario(palabraSeleccionada, letraAux, palabraUsuario);
            pintarPalabra(palabraUsuario);
        } while (FALLOS < MAX_FALLOS && !comprobarPalabra(palabraSeleccionada, palabraUsuario));

        if (comprobarPalabra(palabraSeleccionada, palabraUsuario)) {
            System.out.println("¡ENHORABUENA HAS ACERTADO LA PALABRA!");
            pintarPalabra(palabraUsuario);
        } else {
            System.out.println("¡LO SIENTO, HAS SUPERADO EL MAXIMO NUMERO DE INTENTOS!");
            System.out.println("******************************************");
            System.out.println("*********** G A M E    O V E R ***********");
            System.out.println("******************************************");
        }
    }

    public static char pedirLetra() {
        Scanner entrada = new Scanner(System.in);
        String input;
        System.out.println("INTRODUCE UNA LETRA: ");
        input = entrada.nextLine();
        input = input.toUpperCase();
        return input.charAt(input.length() - 1);
    }

    public static void pintarAhorcado(int fallos) {
        switch (fallos) {
            case 0:
                System.out.println("--------------------------");
                System.out.println("|       ________         |");
                System.out.println("|      |                 |");
                System.out.println("|      |                 |");
                System.out.println("|      |                 |");
                System.out.println("|      |                 |");
                System.out.println("|      |                 |");
                System.out.println("|      |                 |");
                System.out.println("|  -------               |");
                System.out.println("--------------------------");
                break;
            case 1:
                System.out.println("--------------------------");
                System.out.println("|       ________         |");
                System.out.println("|      |        |        |");
                System.out.println("|      |                 |");
                System.out.println("|      |                 |");
                System.out.println("|      |                 |");
                System.out.println("|      |                 |");
                System.out.println("|      |                 |");
                System.out.println("|  -------               |");
                System.out.println("--------------------------");
                break;
            case 2:
                System.out.println("----------------------------");
                System.out.println("|       ________           |");
                System.out.println("|      |      __|__        |");
                System.out.println("|      |     ( . . )       |");
                System.out.println("|      |                   |");
                System.out.println("|      |                   |");
                System.out.println("|      |                   |");
                System.out.println("|      |                   |");
                System.out.println("|  -------                 |");
                System.out.println("----------------------------");
                break;
            case 3:
                System.out.println("----------------------------");
                System.out.println("|       ________           |");
                System.out.println("|      |      __|__        |");
                System.out.println("|      |     ( . . )       |");
                System.out.println("|      |        |          |");
                System.out.println("|      |        |          |");
                System.out.println("|      |                   |");
                System.out.println("|      |                   |");
                System.out.println("|  -------                 |");
                System.out.println("----------------------------");
                break;
            case 4:
                System.out.println("----------------------------");
                System.out.println("|       ________           |");
                System.out.println("|      |      __|__        |");
                System.out.println("|      |     ( . . )       |");
                System.out.println("|      |  ----- |          |");
                System.out.println("|      |        |          |");
                System.out.println("|      |                   |");
                System.out.println("|      |                   |");
                System.out.println("|  -------                 |");
                System.out.println("----------------------------");
                break;
            case 5:
                System.out.println("----------------------------");
                System.out.println("|       ________           |");
                System.out.println("|      |      __|__        |");
                System.out.println("|      |     ( . . )       |");
                System.out.println("|      |  ----- |-----     |");
                System.out.println("|      |        |          |");
                System.out.println("|      |                   |");
                System.out.println("|      |                   |");
                System.out.println("|  -------                 |");
                System.out.println("----------------------------");
                break;
            case 6:
                System.out.println("----------------------------");
                System.out.println("|       ________           |");
                System.out.println("|      |      __|__        |");
                System.out.println("|      |     ( . . )       |");
                System.out.println("|      |  ----- |-----     |");
                System.out.println("|      |        |          |");
                System.out.println("|      |       /           |");
                System.out.println("|      |      /            |");
                System.out.println("|  -------                 |");
                System.out.println("----------------------------");
                break;
            case 7:
                System.out.println("----------------------------");
                System.out.println("|       ________           |");
                System.out.println("|      |      __|__        |");
                System.out.println("|      |     ( . . )       |");
                System.out.println("|      |  ----- |-----     |");
                System.out.println("|      |        |          |");
                System.out.println("|      |       / |         |");
                System.out.println("|      |      /   |        |");
                System.out.println("|  -------                 |");
                System.out.println("----------------------------");
                break;
            default:
                break;
        }
    }

    public static int comprobarLetra(char letra, String palabra) {
        boolean encontrada = false;
        int contador = 0;
        while (!encontrada && contador < palabra.length()) {
            if (palabra.charAt(contador) == letra) {
                encontrada = true;
            } else {
                contador++;
            }
        }
        if (encontrada == true) {
            return contador;
        } else {
            return -1;
        }

    }

    public static Character[] actualizarPalabraUsuario(String palabraSeleccionada, char letra,
            Character[] palabraUsuario) {
        Character[] aux = palabraUsuario;
        if (comprobarLetra(letra, palabraSeleccionada) != -1) {
            System.out.println("Enhorabuena! la letra se encuentra en la palabra.");
            aux[comprobarLetra(letra, palabraSeleccionada)] = letra;
        } else {
            System.out.println("Lo siento, esa letra no existe en la palabra.");
            FALLOS++;
        }
        return aux;
    }

    public static boolean comprobarPalabra(String palabraSeleccionada, Character[] palabraUsuarioVector) {
        String palabraUsuario = "";
        for (Character c : palabraUsuarioVector) {
            palabraUsuario += c;
        }

        return palabraSeleccionada.equalsIgnoreCase(palabraUsuario);
    }

    public static void pintarPalabra(Character[] palabraUsuario) {
        for (int i = 0; i < palabraUsuario.length; i++) {
            if (palabraUsuario[i] == null) {
                palabraUsuario[i] = '_';
            }
        }

        for (int i = 0; i < palabraUsuario.length; i++) {
            System.out.print(palabraUsuario[i] + " ");
        }

        System.out.println("");
    }

}
