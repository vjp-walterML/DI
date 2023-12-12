package com.mycompany.tareafinalinmobiliaria.logica;

/**
 *
 * @author Walter
 */
public class Inmueble {

    //Atributos
    private int idInmueble;
    private String titulo;
    private String transaccion;
    private int precio;
    private int telefono;

    //Constructor
    public Inmueble() {
    }

    public Inmueble(int idInmueble, String titulo, String transaccion, int precio, int telefono) {
        this.idInmueble = idInmueble;
        this.titulo = titulo;
        this.transaccion = transaccion;
        this.precio = precio;
        this.telefono = telefono;
    }

    //Getter y Setter
    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
