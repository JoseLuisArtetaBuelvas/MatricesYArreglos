package ahorcado;

/**
 * Representa a un jugador del Juego del Ahorcado y su puntaje acumulado.
 */
public class Jugador {

    private final String nombre;
    private int puntaje;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void sumarPuntos(int puntos) {
        this.puntaje += puntos;
    }

    @Override
    public String toString() {
        return nombre + ": " + puntaje + " punto(s)";
    }
}
