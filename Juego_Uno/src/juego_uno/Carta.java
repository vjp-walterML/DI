package juego_uno;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wmartinl01
 */
public class Carta {

    private int numero;
    private String color;

    //CONSTRUCTORES
    public Carta() {
        numero = 0;
        color = "";
    }

    public Carta(int numero, String color) {
        this.numero = numero;
        this.color = color;
    }

    //SETTER Y GETTER
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumero() {
        return numero;
    }

    public String getColor() {
        return color;
    }

    //MÉTODOS PROPIOS
    //Este método nos comprobará si la carta es jugable con la carta del centro de la mesa
    public boolean valida(Carta cartaMesa) {
        return this.color.equals(cartaMesa.getColor()) || this.numero == cartaMesa.getNumero();
    }

    public void mostrarCarta() {
        switch (color) {
            case "ROJO":
                System.out.println(Juego.rojo + " -----");
                System.out.println(Juego.rojo + "|     |");
                System.out.println(Juego.rojo + "|  " + numero + "  |");
                System.out.println(Juego.rojo + "|     |");
                System.out.println(Juego.rojo + " -----");
                break;
            case "AZUL":
                System.out.println(Juego.azul + " -----");
                System.out.println(Juego.azul + "|     |");
                System.out.println(Juego.azul + "|  " + numero + "  |");
                System.out.println(Juego.azul + "|     |");
                System.out.println(Juego.azul + " -----");
                break;
            case "AMARILLO":
                System.out.println(Juego.amarillo + " -----");
                System.out.println(Juego.amarillo + "|     |");
                System.out.println(Juego.amarillo + "|  " + numero + "  |");
                System.out.println(Juego.amarillo + "|     |");
                System.out.println(Juego.amarillo + " -----");
                break;
            case "VERDE":
                System.out.println(Juego.verde + " -----");
                System.out.println(Juego.verde + "|     |");
                System.out.println(Juego.verde + "|  " + numero + "  |");
                System.out.println(Juego.verde + "|     |");
                System.out.println(Juego.verde + " -----");
                break;
            default:
                throw new AssertionError();
        }
    }

    public List<String> mostrarCartaUsuario() {
        List<String> cartas = new ArrayList<>();
        switch (color) {
            case "ROJO":
                cartas.add(Juego.rojo + " -----");
                cartas.add(Juego.rojo + "|     |");
                cartas.add(Juego.rojo + "|  " + numero + "  |");
                cartas.add(Juego.rojo + "|     |");
                cartas.add(Juego.rojo + " -----");
                break;
            case "AZUL":
                cartas.add(Juego.azul + " -----");
                cartas.add(Juego.azul + "|     |");
                cartas.add(Juego.azul + "|  " + numero + "  |");
                cartas.add(Juego.azul + "|     |");
                cartas.add(Juego.azul + " -----");
                break;
            case "AMARILLO":
                cartas.add(Juego.amarillo + " -----");
                cartas.add(Juego.amarillo + "|     |");
                cartas.add(Juego.amarillo + "|  " + numero + "  |");
                cartas.add(Juego.amarillo + "|     |");
                cartas.add(Juego.amarillo + " -----");
                break;
            case "VERDE":
                cartas.add(Juego.verde + " -----");
                cartas.add(Juego.verde + "|     |");
                cartas.add(Juego.verde + "|  " + numero + "  |");
                cartas.add(Juego.verde + "|     |");
                cartas.add(Juego.verde + " -----");
                break;
            default:
                throw new AssertionError();
        }
        return cartas;
    }
}
