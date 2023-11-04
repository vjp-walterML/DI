package LogicaJuego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author wmartinl01
 */
public class Mazo {

    //Atributos
    private List<Carta> cartas;

    //Constructores
    public Mazo() {
        cartas = new ArrayList<>();
        //Genero mazo
        generarMazo();
    }

    //Getter y Setter
    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    //MÉTODOS PROPIOS
    //Este método genera el mazo con las cartas propuestas en el enunciado
    private void generarMazo() {
        //CARTAS
        //MAKI 1
        for (int i = 0; i < 6; i++) {
            cartas.add(new Carta("Maki 1", 6, "/IMG/maki1.PNG"));
        }
        //MAKI 2
        for (int i = 0; i < 12; i++) {
            cartas.add(new Carta("Maki 2", 6, "/IMG/maki2.PNG"));
        }
        //MAKI 3
        for (int i = 0; i < 8; i++) {
            cartas.add(new Carta("Maki 3", 6, "/IMG/maki3.PNG"));
        }
        //SASHIMI
        for (int i = 0; i < 14; i++) {
            cartas.add(new Carta("Sashimi", 10, "/IMG/sashimi.PNG"));
        }
        //DUMPLING
        for (int i = 0; i < 14; i++) {
            cartas.add(new Carta("Dumpling", 15, "/IMG/dumpling.PNG"));
        }
        //NIGIRI CALAMAR
        for (int i = 0; i < 5; i++) {
            cartas.add(new Carta("NigiriCalamar", 3, "/IMG/nigiricalamar.PNG"));
        }
        //NIGIRI HUEVO
        for (int i = 0; i < 5; i++) {
            cartas.add(new Carta("NigiriHuevo", 1, "/IMG/nigirihuevo.PNG"));
        }
        //NIGIRI SALMÓN
        for (int i = 0; i < 10; i++) {
            cartas.add(new Carta("NigiriSalmon", 2, "/IMG/nigirisalmon.PNG"));
        }
        //PUDDING
        for (int i = 0; i < 10; i++) {
            cartas.add(new Carta("Pudding", 6, "/IMG/pudding.PNG"));
        }
    }

    //Este método baraja las cartas
    private void mezclar() {
        Collections.shuffle(cartas);
    }

    //Este método recibe el numero de cartas, baraja las cartas y reparte el numero de cartas especificado.
    public List<Carta> repartirCartas(int numeroCartas) {
        List<Carta> lCartas = new ArrayList<>();
        //Barajo cartas
        mezclar();
        //Añado las cartas a lCartas y lo retorno
        for (int i = 0; i < numeroCartas; i++) {
            lCartas.add(cartas.remove(i));
        }
        //Retorno lCartas
        return lCartas;
    }
}
