package pokemon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import static pokemon.Constantes.*;

/**
 *
 * @author wmartinl01
 */
public class Juego {

    //CREO LAS LISTAS DONDE SE ALMACENARÁN TODOS LOS OBJETOS CREADOS A PARTIR DE LA CARGA DE DATOS
    public static List<Entrenador> listaEntrenadores = new ArrayList<>();
    public static List<Pokemon> listaPokemons = new ArrayList<>();
    public static List<Ataque> listaAtaques = new ArrayList<>();
    public static Entrenador usuario;
    public static Entrenador maquina;
    public static boolean finJuego = false;

    public static void main(String[] args) throws IOException {
        //Cargo los datos del fichero
        cargarDatos();
        //Muestro los entrenadores disponibles,el usuario elige uno y lo elimino de la lista de entrenadores.
        usuario = listaEntrenadores.get(mostrarInicio());
        listaEntrenadores.remove(usuario);
        //Asigno aleatoriamente un entrenador a la máquina
        maquina = listaEntrenadores.get((int) Math.round(Math.random() * (listaEntrenadores.size() - 1)));
        listaEntrenadores.remove(maquina);

        //Inicio el juego
        //while (!finJuego) {
            mostrarJuego();

        //}
    }

    //Este método muestra los entrenadores y devuelve el entrenador que ha elegido el usuario
    public static int mostrarInicio() {
        System.out.println(" -----------------------------------------------------------------------\n"
                + "|                                   ,'\\                                 |\n"
                + "|      _.----.        ____         ,'  _\\   ___    ___     ____         |\n"
                + "|  _,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.	|\n"
                + "|  \\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |	|\n"
                + "|   \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |	|\n"
                + "|     \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |	|\n"
                + "|      \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |	|\n"
                + "|       \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |	|\n"
                + "|        \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |	|\n"
                + "|         \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |	|\n"
                + "|          \\_.-'       |__|    `-._ |              '-.|     '-.| |   |	|\n"
                + "|                                  `'                            '-._|	|\n"
                + " -----------------------------------------------------------------------");
        System.out.println("\n            E L I G E    A    T U    E N T R E N A D O R \n");
        mostrarEntrenadores();
        System.out.println("=======================================================================");
        int opcion = pedirEntero("INTRODUCE UNA OPCION:");
        return opcion;
    }
    
    //Metodo para mostrar juego
    public static void mostrarJuego(){
        //  mostrar maquina tabulado
        System.out.println("\n*********************");
        System.out.println("*** M A Q U I N A ***");
        System.out.println("*********************");
        System.out.println("\n"+maquina.getNombre().toUpperCase());
        System.out.println("\n ======= P O K E M O N S =======");
        maquina.mostrarInfoPokemons();
        //Mostrar usuario sin tabular
        System.out.println("\n*********************");
        System.out.println("*** U S U A R I O ***");
        System.out.println("*********************");
        System.out.println("\n"+usuario.getNombre().toUpperCase());
        System.out.println("\n ======= P O K E M O N S =======");
        usuario.mostrarInfoPokemons();
    }

    public static void mostrarEntrenadores() {
        for (int i = 0; i < listaEntrenadores.size(); i++) {
            System.out.println("============================ O P C I O N  " + (i + 1) + " ============================");
            listaEntrenadores.get(i).mostrarEntrenador();
        }

    }

    public static int pedirEntero(String texto) {
        Scanner s = new Scanner(System.in);
        int opcion;
        try {
            System.out.println(texto);
            opcion = s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR.NO PUEDES INTRODUCIR UNA LETRA.");
            opcion = pedirEntero(texto);
        }
        return opcion - 1;
    }

    public static void cargarDatos() throws FileNotFoundException, IOException {
        String linea;
        String[] objeto;

        //ABRO FLUJOS
        BufferedReader br = new BufferedReader(new FileReader(FICHERO));

        //Leo la primera línea
        linea = br.readLine();

        while (linea != null) {
            //Separo los datos por , y los introduzco en un vector
            objeto = linea.split(",");
            //Mando el vector al método que se encarga de crear el objeto e introducirlo en la respectiva lista
            crearObjeto(objeto);
            //Vuelvo a leer otra línea
            linea = br.readLine();
        }

        //CIERRO FLUJO
        br.close();
    }

    public static void crearObjeto(String[] objeto) {
        switch (objeto[0]) {
            case "ATAQUE":
                //Creo el objeto ataque
                var ataque = new Ataque(objeto[1], objeto[2], Integer.parseInt(objeto[3]), Integer.parseInt(objeto[4]), Integer.parseInt(objeto[5]));
                //Introduzco el objeto ataque en la lista
                listaAtaques.add(ataque);
                break;

            case "POKEMON":
                //Creo el objeto pokemon
                Pokemon pokemon = new Pokemon(objeto[1], objeto[3], objeto[4]);
                //Introduzco el objeto pokemon a la lista
                listaPokemons.add(pokemon);
                break;
            case "ENTRENADOR":
                //Creo el objeto entrenador
                Entrenador entrenador = new Entrenador(objeto[1]);
                //Introduzco el objeto entrenador a la lista
                listaEntrenadores.add(entrenador);
                break;
            default:
                throw new AssertionError();
        }
    }

    //Comprueba si el juego ha llegado a su fin comprobando si alguno de los dos se ha quedado sin pokemons con vida
    public static void comprobarFinJuego() {
        List<Pokemon> pokemonUsuario = usuario.getLpokemon();
        List<Pokemon> pokemonMaquina = maquina.getLpokemon();
        boolean vidaUsuario = false;
        boolean vidaMaquina = false;
        for (Pokemon pokemon : pokemonUsuario) {
            if (pokemon.getVida() > 0) {
                vidaUsuario = true;
            }
        }
        for (Pokemon pokemon : pokemonMaquina) {
            if (pokemon.getVida() > 0) {
                vidaMaquina = true;
            }
        }

        if (vidaUsuario && !vidaMaquina) {
            finJuego = true;
            System.out.println("\n******************************************************");
            System.out.println("************** ¡E N H O R A B U E N A! ***************");
            System.out.println("*************** ¡H A S   G A N A D O! ****************");
            System.out.println("******************************************************");
        } else {
            if (vidaMaquina && !vidaUsuario) {
                finJuego = true;
                System.out.println("\n******************************************");
                System.out.println("*********** G A M E    O V E R ***********");
                System.out.println("******************************************");
            }
        }
    }
}
