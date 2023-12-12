/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareafinalinmobiliaria.logica;

import static com.mycompany.tareafinalinmobiliaria.logica.Constantes.*;
import java.sql.Connection;
import java.sql.DriverManager;
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
        System.out.println("\n ¡CONEXIÓN REALIZADA CORRECTAMENTE!");
        return conexion;
    }
}
