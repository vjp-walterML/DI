package Logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Walter
 */
public class Utileria {

    //Método que recibe un String por parámetro, lo codifica y lo devuelve codificado
    public static String encodeToMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] digest = md.digest();
            return DatatypeConverter.printHexBinary(digest).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    //Método que carga los datos de los usuarios registrados para el login
    public static Map<String, String> cargarDatos() {
        Map<String, String> lUsuarios = new LinkedHashMap<>();
        try {
            //Abro flujos
            BufferedReader br = new BufferedReader(new FileReader(Logica.Constantes.FICHERO_USERS));
            String linea = br.readLine();
            String[] usuario;
            //Leo mientras haya usuarios
            while (linea != null) {
                usuario = linea.split("-");
                lUsuarios.put(usuario[0], usuario[1]);
                linea = br.readLine();
            }
            //Cierro flujos
            br.close();
        } catch (IOException ex) {
            System.out.println("ERROR: NO SE HA PODIDO CARGAR LOS DATOS DEL FICHERO.");
        }
        //Retorno mapa
        return lUsuarios;
    }
}
