package ejercicioexamen1;

import java.text.SimpleDateFormat;

/**
 *
 * @author Walter
 */
public class Cita {
    
    //Atributos
    private int idCita;
    private String matricula;
    private String coche;
    private String fecha;
    
    //Constructor
    public Cita(int idCita, String matricula, String coche, String fecha) {
        this.idCita = idCita;
        this.matricula = matricula;
        this.coche = coche;
        this.fecha = fecha;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCoche() {
        return coche;
    }

    public void setCoche(String coche) {
        this.coche = coche;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
