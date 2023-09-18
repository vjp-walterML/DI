package juego_uno;

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
    public void mostrarCarta() {
        System.out.println(" -------------");
        System.out.println("|             |");
        System.out.println("|     " + numero);
        System.out.println("|             |");
        System.out.println("|   " + color);
        System.out.println("|             |");
        System.out.println(" -------------");
    }

}
