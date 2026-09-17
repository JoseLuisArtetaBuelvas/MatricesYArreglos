package ahorcado;

import java.util.Scanner;

/**
 * Juego del Ahorcado.
 *
 * Usa un arreglo de caracteres para representar la palabra oculta, controla las letras
 * ya adivinadas y los errores cometidos, y registra el puntaje de varios jugadores en
 * un arreglo de {@link Jugador}.
 */
public class Ahorcado {

    private static final String[] BANCO_PALABRAS = {
        "JAVA", "ARREGLO", "MATRIZ", "ESTRUCTURA", "PROGRAMACION"
    };
    private static final int MAXIMO_ERRORES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Cuantos jugadores van a participar? ");
        int numeroJugadores = Integer.parseInt(scanner.nextLine().trim());

        Jugador[] jugadores = new Jugador[numeroJugadores];
        for (int i = 0; i < numeroJugadores; i++) {
            System.out.print("Nombre del jugador " + (i + 1) + ": ");
            jugadores[i] = new Jugador(scanner.nextLine().trim());
        }

        for (Jugador jugador : jugadores) {
            System.out.println("\nTurno de " + jugador.getNombre());
            boolean gano = jugarRonda(scanner, jugador);
            if (gano) {
                jugador.sumarPuntos(1);
            }
        }

        System.out.println("\n=== Puntajes finales ===");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }
    }

    /**
     * Juega una ronda para un jugador: elige una palabra al azar, controla letras
     * adivinadas y errores, y retorna true si el jugador logro completar la palabra.
     */
    public static boolean jugarRonda(Scanner scanner, Jugador jugador) {
        String palabra = elegirPalabraAleatoria();
        char[] palabraOculta = ocultarPalabra(palabra);
        // Tamano maximo posible de letras distintas que se pueden intentar (alfabeto).
        char[] letrasAdivinadas = new char[26];
        int cantidadAdivinadas = 0;
        int errores = 0;

        while (errores < MAXIMO_ERRORES && !palabraCompleta(palabraOculta)) {
            System.out.println("Palabra: " + new String(palabraOculta));
            System.out.println("Errores: " + errores + "/" + MAXIMO_ERRORES);
            System.out.print("Ingrese una letra: ");
            String entrada = scanner.nextLine().trim().toUpperCase();
            if (entrada.isEmpty()) {
                continue;
            }
            char letra = entrada.charAt(0);

            if (yaFueAdivinada(letrasAdivinadas, cantidadAdivinadas, letra)) {
                System.out.println("Ya intentaste con la letra '" + letra + "'.");
                continue;
            }
            letrasAdivinadas[cantidadAdivinadas++] = letra;

            boolean acierto = adivinarLetra(palabraOculta, palabra, letra);
            if (!acierto) {
                errores++;
                System.out.println("Letra incorrecta.");
            }
        }

        boolean gano = palabraCompleta(palabraOculta);
        if (gano) {
            System.out.println("Felicidades " + jugador.getNombre() + ", adivinaste la palabra: " + palabra);
        } else {
            System.out.println(jugador.getNombre() + " perdio. La palabra era: " + palabra);
        }
        return gano;
    }

    public static String elegirPalabraAleatoria() {
        int indice = (int) (Math.random() * BANCO_PALABRAS.length);
        return BANCO_PALABRAS[indice];
    }

    /**
     * Crea el arreglo de caracteres que representa la palabra oculta, con guiones bajos
     * en cada posicion.
     */
    public static char[] ocultarPalabra(String palabra) {
        char[] oculta = new char[palabra.length()];
        for (int i = 0; i < oculta.length; i++) {
            oculta[i] = '_';
        }
        return oculta;
    }

    /**
     * Revela en {@code palabraOculta} todas las posiciones donde aparece {@code letra}.
     *
     * @return true si la letra aparece al menos una vez en la palabra original.
     */
    public static boolean adivinarLetra(char[] palabraOculta, String palabraOriginal, char letra) {
        boolean acierto = false;
        for (int i = 0; i < palabraOriginal.length(); i++) {
            if (palabraOriginal.charAt(i) == letra) {
                palabraOculta[i] = letra;
                acierto = true;
            }
        }
        return acierto;
    }

    public static boolean palabraCompleta(char[] palabraOculta) {
        for (char c : palabraOculta) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    public static boolean yaFueAdivinada(char[] letrasAdivinadas, int cantidad, char letra) {
        for (int i = 0; i < cantidad; i++) {
            if (letrasAdivinadas[i] == letra) {
                return true;
            }
        }
        return false;
    }
}
