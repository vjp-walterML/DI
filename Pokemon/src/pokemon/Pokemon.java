package pokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author wmartinl01
 */
public class Pokemon {

    private String nombre;
    private int vida;
    private String tipo;
    private List<Ataque> lAtaques;

    //CONSTRUCTORES
    public Pokemon(String nombre, String tipo) {
        this.nombre = nombre;
        this.vida = Constantes.VIDA_MAX;
        this.tipo = tipo;
        this.lAtaques = new ArrayList<>();
        rellenarAtaques();
    }

    //SETTER Y GETTER
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        //Controlo si intentamos introducir un valor inválido en la vida
        if (vida < Constantes.VIDA_MIN) {
            this.vida = Constantes.VIDA_MIN;
        } else {
            if (vida > Constantes.VIDA_MAX) {
                this.vida = Constantes.VIDA_MAX;
            } else {
                this.vida = vida;
            }
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Ataque> getLataques() {
        return lAtaques;
    }

    public void setLataques(List<Ataque> lataques) {
        this.lAtaques = lataques;
    }

    //MÉTODOS PROPIOS
    private void rellenarAtaques() {
        for (int i = 0; i < Constantes.MAX_ATAQUES; i++) {
            //Barajo los ataques para que salgan aleatorios
            Collections.shuffle(Juego.listaAtaques);
            for (Ataque a : Juego.listaAtaques) {
                //Si es del mismo tipo lo añado a la lista de ataques del pokemon
                if (a.getTipo().equalsIgnoreCase(tipo)) {
                    lAtaques.add(a);
                    Juego.listaAtaques.remove(a);
                    break;
                }
            }
        }
    }
}
