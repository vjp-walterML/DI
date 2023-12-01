package ejercicioexamen1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Walter
 */
public class LogicaNegocio {

    //Lista
    private List<Cita> lCitas = new ArrayList<>();

    //Constructor
    public LogicaNegocio() {
        lCitas.add(new Cita(1, "8457HGJ", "Coche1", "12-12-2023"));
        lCitas.add(new Cita(2, "8455HGJ", "Coche2", "13-12-2023"));
        lCitas.add(new Cita(3, "8454HGJ", "Coche3", "14-12-2023"));
        lCitas.add(new Cita(4, "8455HGJ", "Coche4", "15-12-2023"));
        lCitas.add(new Cita(5, "8458HGJ", "Coche5", "16-12-2023"));
    }

    //Getter y Setter
    public List<Cita> getlCitas() {
        return lCitas;
    }

    public void setlCitas(List<Cita> lCitas) {
        this.lCitas = lCitas;
    }

}
