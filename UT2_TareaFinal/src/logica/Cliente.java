package logica;

import java.time.LocalDate;

/**
 *
 * @author Walter
 */
public class Cliente {
    
    //Atributos
    private int numCliente;
    private String dni;
    private LocalDate fechaAlta;
    private String direccion;
    private int telefono;
    private String foto;
    
    //Constructores
    public Cliente(int numCliente, String dni, LocalDate fechaAlta, String direccion, int telefono, String foto) {
        this.numCliente = numCliente;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
        this.direccion = direccion;
        this.telefono = telefono;
        this.foto = foto;
    }

    public Cliente() {
    }
    
    //Getter y Setter
    public int getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(int numCliente) {
        this.numCliente = numCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    //Métodos propios
    
}
