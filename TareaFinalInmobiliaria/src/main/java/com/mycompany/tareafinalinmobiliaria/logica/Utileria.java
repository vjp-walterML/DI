/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareafinalinmobiliaria.logica;

import static com.mycompany.tareafinalinmobiliaria.logica.Constantes.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Walter
 */
public class Utileria {

    //ESTABLECER CONEXIÓN
    public static Connection establecerConexion() {
        //Cargamos el driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(CLASS_NOT_FOUND_EXCEPTION);
        }
        //Establecemos la conexión
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:" + PUERTO + "/" + BD, USUARIO, "");
        } catch (SQLException e) {
            System.out.println(CONEXION_FALLIDA);
            return conexion;
        }
        return conexion;
    }

    //AÑADIR INMUEBLE A LA BD
    public static void addInmueble(Inmueble inmueble) {
        //Creamos conexión
        Connection conexion = establecerConexion();
        //Creamos sentencia insert
        String sql = "INSERT INTO inmuebles (titulo,descripcion,foto,ventaAlquiler,precio,telefono) VALUES (?,?,?,?,?,?)";
        PreparedStatement sentenciaPreparada = null;
        try {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setString(1, inmueble.getTitulo());
            sentenciaPreparada.setString(2, inmueble.getDescripcion());
            sentenciaPreparada.setString(3, inmueble.getFoto());
            sentenciaPreparada.setString(4, inmueble.getTransaccion());
            sentenciaPreparada.setInt(5, inmueble.getPrecio());
            sentenciaPreparada.setInt(6, inmueble.getTelefono());
            sentenciaPreparada.executeUpdate();
            //Liberamos recursos
            sentenciaPreparada.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(SQLEXCEPTION);
        }
    }

    //ELIMINAR INMUEBLE DE LA BD
    public static void eliminarInmueble(Inmueble inmueble) {
        //Creamos conexión
        Connection conexion = establecerConexion();
        //Creamos sentencia delete
        String sql = "DELETE FROM inmuebles WHERE idInmueble = ?";
        PreparedStatement sentenciaPreparada = null;
        try {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, inmueble.getIdInmueble());
            sentenciaPreparada.executeUpdate();
            //Liberamos recursos
            sentenciaPreparada.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(SQLEXCEPTION);
        }
    }
}
