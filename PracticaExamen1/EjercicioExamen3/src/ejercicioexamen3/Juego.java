package ejercicioexamen3;

/**
 *
 * @author Walter
 */
public class Juego {

    //Atributos
    private static int contador = 0;
    private int id;
    private String nombre;
    private String plataforma;
    private float precio;

    //Constructor
    public Juego() {
        contador++;
        this.id = contador;
        this.nombre = "NombreDefecto";
        this.plataforma = "PlataformaDefecto";
        this.precio = 0.00f;
    }

    public Juego(String nombre, String plataforma, float precio) {
        contador++;
        this.id = contador;
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.precio = precio;
    }

    //Getter y Setter
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
