package LogicaJuego;

import javax.swing.Icon;

/**
 *
 * @author wmartinl01
 */

//Esta clase representa una carta individual en el juego
public class Carta {

    //Atributos
    private String nombre;
    private int valor;
    private Icon representacion;//AQUI

    //Constructores
    public Carta() {
        nombre = "";
        valor = 0;
    }

    public Carta(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    //Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    //MÉTODOS PROPIOS
    
}
