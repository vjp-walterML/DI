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
    public static Pokemon pokemonUsuario;
    public static Entrenador maquina;
    public static Pokemon pokemonMaquina;
    public static boolean finJuego = false;

    public static void main(String[] args) throws IOException, InterruptedException {
        //Cargo los datos del fichero
        cargarDatos();
        //Muestro los entrenadores disponibles,el usuario elige uno y lo elimino de la lista de entrenadores.
        usuario = listaEntrenadores.get(mostrarInicio());
        listaEntrenadores.remove(usuario);
        //Asigno aleatoriamente un entrenador a la máquina
        maquina = listaEntrenadores.get((int) Math.round(Math.random() * (listaEntrenadores.size() - 1)));
        listaEntrenadores.remove(maquina);

        //Inicio el juego
        while (!finJuego) {
            //mostrarJuego();
            asignarPokemons();
            turnoUsuario();
            comprobarFinJuego();
            actualizarEstadoPokemons();
            asignarPokemons();
            turnoMaquina();
            actualizarEstadoPokemons();
        }
    }

    public static void turnoUsuario() throws InterruptedException {
        if (!finJuego) {
            limpiarPantalla();
            System.out.println("\nESTÁS JUGANDO CON EL POKEMON " + pokemonUsuario.getNombre());
            pokemonUsuario.mostrarPokemonInfo();
            //Pedimos el ataque al usuario y atacamos
            Ataque ataqueElegido = pokemonUsuario.getLataques().get(pedirAtaque("\nIntroduce el ataque que deseas: "));
            if (pokemonMaquina.getEstado().equalsIgnoreCase("NORMAL")) {
                pokemonMaquina.setVida(pokemonMaquina.getVida() - ataqueElegido.getPuntosDeDanoNormal());
                Thread.sleep(1000);
                System.out.println("\n¡HAS ATACADO A " + pokemonMaquina.getNombre() + " con " + ataqueElegido.getNombre() + "!");
                Thread.sleep(1000);
                System.out.println("\n¡LE HAS INFRINFIDO " + ataqueElegido.getPuntosDeDanoNormal() + " PUNTOS DE DAÑO!");
                Thread.sleep(2000);
            } else {
                if (pokemonMaquina.getEstado().equalsIgnoreCase("VULNERABLE")) {
                    pokemonMaquina.setVida(pokemonMaquina.getVida() - ataqueElegido.getPuntosDeDanoVulnerable());
                    Thread.sleep(1000);
                    System.out.println("\n¡HAS ATACADO A " + pokemonMaquina.getNombre() + " con " + ataqueElegido.getNombre() + "!");
                    Thread.sleep(1000);
                    System.out.println("\n¡LE HAS INFRINFIDO " + ataqueElegido.getPuntosDeDanoVulnerable() + " PUNTOS DE DAÑO!");
                    Thread.sleep(2000);
                } else {
                    pokemonMaquina.setVida(pokemonMaquina.getVida() - ataqueElegido.getPuntosDeDanoInofensivo());
                    Thread.sleep(1000);
                    System.out.println("\n¡HAS ATACADO A " + pokemonMaquina.getNombre() + " con " + ataqueElegido.getNombre() + "!");
                    Thread.sleep(1000);
                    System.out.println("\n¡LE HAS INFRINFIDO " + ataqueElegido.getPuntosDeDanoInofensivo() + " PUNTOS DE DAÑO!");
                    Thread.sleep(2000);
                }
            }
            if (pokemonMaquina.getVida() > 0) {
                System.out.println("\nAHORA SU VIDA ES DE " + pokemonMaquina.getVida());
                Thread.sleep(2000);
            } else {
                System.out.println("\n¡HAS MATADO A !" + pokemonMaquina.getNombre() + "!");
                Thread.sleep(2000);
            }
        }
    }

    public static void mostrarInfoEntrenadoresElegidos() throws InterruptedException {
        System.out.println("¡HAS ELEGIDO A " + usuario.getNombre() + "!");
        Thread.sleep(1000);
        System.out.println("LA MÁQUINA HA ELEGIDO AL ENTRENADOR " + maquina.getNombre());
        Thread.sleep(1000);
    }

    public static void turnoMaquina() throws InterruptedException {
        if (!finJuego) {
            System.out.println("\nLA MÁQUINA HA ELEGIDO A  " + pokemonMaquina.getNombre());
            Thread.sleep(1000);
            //pokemonMaquina.mostrarPokemonInfo();
            //Elige el ataque aleatoriamente y atacam
            Ataque ataqueElegido = pokemonMaquina.getLataques().get((int) Math.round(Math.random() * (pokemonMaquina.getLataques().size())));
            if (pokemonUsuario.getEstado().equalsIgnoreCase("NORMAL")) {
                pokemonUsuario.setVida(pokemonUsuario.getVida() - ataqueElegido.getPuntosDeDanoNormal());
                Thread.sleep(1000);
                System.out.println("\n¡TE HA ATACADO CON " + ataqueElegido.getNombre() + "!");
                Thread.sleep(1000);
                System.out.println("\n¡TE HA INFRINFIDO " + ataqueElegido.getPuntosDeDanoNormal() + " PUNTOS DE DAÑO!");
                Thread.sleep(2000);
            } else {
                if (pokemonUsuario.getEstado().equalsIgnoreCase("VULNERABLE")) {
                    pokemonUsuario.setVida(pokemonUsuario.getVida() - ataqueElegido.getPuntosDeDanoVulnerable());
                    Thread.sleep(1000);
                    System.out.println("\n¡TE HA ATACADO CON " + ataqueElegido.getNombre() + "!");
                    Thread.sleep(1000);
                    System.out.println("\n¡TE HA INFRINFIDO " + ataqueElegido.getPuntosDeDanoVulnerable() + " PUNTOS DE DAÑO!");
                    Thread.sleep(2000);
                } else {
                    pokemonUsuario.setVida(pokemonUsuario.getVida() - ataqueElegido.getPuntosDeDanoInofensivo());
                    Thread.sleep(1000);
                    System.out.println("\n¡TE HA ATACADO CON " + ataqueElegido.getNombre() + "!");
                    Thread.sleep(1000);
                    System.out.println("\n¡TE HA INFRINFIDO " + ataqueElegido.getPuntosDeDanoInofensivo() + " PUNTOS DE DAÑO!");
                    Thread.sleep(2000);
                }
            }
            if (pokemonUsuario.getVida() > 0) {
                System.out.println("\nAHORA TU VIDA ES DE " + pokemonUsuario.getVida());
                Thread.sleep(2000);
            } else {
                System.out.println("\n¡LA MAQUINA HA MATADO A !" + pokemonUsuario.getNombre() + "!");
                Thread.sleep(2000);
            }
        }
    }

    public static void asignarPokemons() {
        //Me recorro la lista de pokemon del usuario para dar valor a la variable pokemonUsuario
        for (Pokemon p : usuario.getLpokemon()) {
            if (p.getVida() > 0) {
                pokemonUsuario = p;
            }
        }
        //Me recorro la lista de pokemon de la máquina para dar valor a la variable pokemonMaquina
        for (Pokemon p : maquina.getLpokemon()) {
            if (p.getVida() > 0) {
                pokemonMaquina = p;
            }
        }
    }

    public static void actualizarEstadoPokemons() {
        //Actualizo el estado del pokemon de la maquina según su vida
        if (pokemonMaquina.getVida() > Constantes.ESTADO_NORMAL) {
            pokemonMaquina.setEstado("NORMAL");
        } else {
            if (pokemonMaquina.getVida() > Constantes.ESTADO_VULNERABLE) {
                pokemonMaquina.setEstado("VULNERABLE");
            } else {
                pokemonMaquina.setEstado("INOFENSIVO");
            }
        }
        //Actualizo el estado del pokemon del usuario según su vida
        if (pokemonUsuario.getVida() > Constantes.ESTADO_NORMAL) {
            pokemonUsuario.setEstado("NORMAL");
        } else {
            if (pokemonUsuario.getVida() > Constantes.ESTADO_VULNERABLE) {
                pokemonUsuario.setEstado("VULNERABLE");
            } else {
                pokemonUsuario.setEstado("INOFENSIVO");
            }
        }

    }

    //Este método muestra los entrenadores y devuelve el entrenador que ha elegido el usuario
    public static int mostrarInicio() throws InterruptedException {
        System.out.println(" -----------------------------------------------------------------------");
        Thread.sleep(200);
        System.out.println("|                                   ,'\\                                 |");
        Thread.sleep(200);
        System.out.println("|      _.----.        ____         ,'  _\\   ___    ___     ____         |");
        Thread.sleep(200);
        System.out.println("|  _,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.	|");
        Thread.sleep(200);
        System.out.println("|  \\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |	|");
        Thread.sleep(200);
        System.out.println("|   \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |	|");
        Thread.sleep(200);
        System.out.println("|     \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |	|");
        Thread.sleep(200);
        System.out.println("|      \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |	|");
        Thread.sleep(200);
        System.out.println("|       \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |	|");
        Thread.sleep(200);
        System.out.println("|        \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |	|");
        Thread.sleep(200);
        System.out.println("|         \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |	|");
        Thread.sleep(200);
        System.out.println("|          \\_.-'       |__|    `-._ |              '-.|     '-.| |   |	|");
        Thread.sleep(200);
        System.out.println("|                                  `'                            '-._|	|");
        Thread.sleep(200);
        System.out.println(" -----------------------------------------------------------------------");
        Thread.sleep(400);
        System.out.println("\n            E L I G E    A    T U    E N T R E N A D O R \n");
        Thread.sleep(3000);
        mostrarEntrenadores();
        System.out.println("=======================================================================");
        int opcion = pedirEntero("INTRODUCE UNA OPCION:");
        while (opcion > listaEntrenadores.size() || opcion < 0) {
            System.out.println("ERROR, ELIGE UNA OPCION VALIDA.");
            opcion = pedirEntero("INTRODUCE UNA OPCION:");
        }
        return opcion;
    }

    //Metodo para mostrar juego
    public static void mostrarJuego() {
        //  mostrar maquina tabulado
        System.out.println("\n*********************");
        System.out.println("*** M A Q U I N A ***");
        System.out.println("*********************");
        System.out.println("\n" + maquina.getNombre().toUpperCase());
        System.out.println("\n ======= P O K E M O N S =======");
        maquina.mostrarInfoPokemons();
        //Mostrar usuario sin tabular
        System.out.println("\n*********************");
        System.out.println("*** U S U A R I O ***");
        System.out.println("*********************");
        System.out.println("\n" + usuario.getNombre().toUpperCase());
        System.out.println("\n ======= P O K E M O N S =======");
        usuario.mostrarInfoPokemons();
    }

    public static void limpiarPantalla() {
        for (int i = 0; i < 60; i++) {
            System.out.println("");
        }
    }

    public static void mostrarEntrenadores() throws InterruptedException {
        for (int i = 0; i < listaEntrenadores.size(); i++) {
            System.out.println("============================ O P C I O N  " + (i + 1) + " ============================");
            Thread.sleep(100);
            listaEntrenadores.get(i).mostrarEntrenador();
            Thread.sleep(100);
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

    public static int pedirAtaque(String texto) {
        Scanner s = new Scanner(System.in);
        int opcion;
        try {
            System.out.println(texto);
            opcion = s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR.NO PUEDES INTRODUCIR UNA LETRA.");
            opcion = pedirEntero(texto);
        }
        if (opcion < 0 || opcion > 4) {
            System.out.println("ERROR.INTRODUCE UN ATAQUE VALIDO.");
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
