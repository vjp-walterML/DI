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
    private String representacion;
    private List<Ataque> lAtaques;

    //CONSTRUCTORES
    public Pokemon(String nombre, String tipo, String representacion) {
        this.nombre = nombre;
        this.vida = Constantes.VIDA_MAX;
        this.tipo = tipo;
        this.representacion = representacion.replace("\\n", "\n");
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

    public String getRepresentacion() {
        return representacion;
    }

    public void setRepresentacion(String representacion) {
        this.representacion = representacion;
    }

    public List<Ataque> getLataques() {
        return lAtaques;
    }

    public void setLataques(List<Ataque> lataques) {
        this.lAtaques = lataques;
    }

    //MÉTODOS PROPIOS
    private void rellenarAtaques() {
        boolean encontrado;
        int a = 0;
        for (int i = 0; i < Constantes.MAX_ATAQUES; i++) {
            encontrado = false;
            while (a < Juego.listaAtaques.size() && !encontrado) {
                if (Juego.listaAtaques.get(a).getTipo().equalsIgnoreCase(tipo)) {
                    lAtaques.add(Juego.listaAtaques.get(a));
                    Juego.listaAtaques.remove(a);
                    encontrado = true;
                } else {
                    a++;
                }
            }
        }
    }

    public void mostrarPokemon() {
        System.out.println("" + this.nombre.toUpperCase());
        System.out.println("");
        System.out.println(this.representacion);
        System.out.println("-------------------");
    }

    public void mostrarPokemonInfo() {
        System.out.println("------------------");
        System.out.println(this.representacion);
        System.out.println("\nNombre: " + this.nombre);
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Vida: " + this.vida);
        System.out.println("Estado: ");
        for (int i = 0; i < lAtaques.size(); i++) {
            System.out.println("#ATAQUE " + (i + 1));
            System.out.println("   -" + lAtaques.get(i).getNombre());
            System.out.println("   -TIPO: " + lAtaques.get(i).getTipo());
            System.out.println("   -Daño normal: " + lAtaques.get(i).getPuntosDeDanoNormal());
            System.out.println("   -Daño vulnerable: " + lAtaques.get(i).getPuntosDeDanoVulnerable());
            System.out.println("   -Daño inofensivo: " + lAtaques.get(i).getPuntosDeDanoInofensivo());
        }
    }
}
