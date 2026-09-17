package arreglos;

import java.util.Random;

/**
 * Demuestra los conceptos fundamentales de arreglos en Java:
 * declaracion, inicializacion, recorrido, modificacion y busqueda.
 */
public class ArregloDemo {

    public static void main(String[] args) {
        int[] arreglo = crearArregloAleatorio(10);

        System.out.println("=== 1. Declaracion e inicializacion ===");
        imprimirConForClasico(arreglo);

        System.out.println("\n=== 2. Recorrido ===");
        System.out.println("-- for clasico --");
        imprimirConForClasico(arreglo);
        System.out.println("-- for-each --");
        imprimirConForEach(arreglo);

        System.out.println("\n=== 3. Modificacion ===");
        int[] sinImpares = reemplazarImparesPorCero(arreglo);
        System.out.println("Impares reemplazados por cero:");
        imprimirConForEach(sinImpares);

        int[] multiplicadoPorIndice = multiplicarPorIndice(arreglo);
        System.out.println("Cada valor multiplicado por su indice:");
        imprimirConForEach(multiplicadoPorIndice);

        System.out.println("\n=== 4. Busqueda lineal ===");
        int valorBuscado = arreglo[5];
        int posicion = busquedaLineal(arreglo, valorBuscado);
        System.out.println("Buscando el valor " + valorBuscado + " -> encontrado en la posicion " + posicion);
        System.out.println("Buscando el valor -999 (no existe) -> resultado: " + busquedaLineal(arreglo, -999));
    }

    /**
     * Declara un arreglo de {@code tamano} enteros y lo inicializa con valores aleatorios (0-99).
     */
    public static int[] crearArregloAleatorio(int tamano) {
        int[] arreglo = new int[tamano];
        Random random = new Random();
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = random.nextInt(100);
        }
        return arreglo;
    }

    public static void imprimirConForClasico(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

    public static void imprimirConForEach(int[] arreglo) {
        for (int valor : arreglo) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }

    /**
     * Retorna una copia del arreglo con los valores impares reemplazados por cero.
     */
    public static int[] reemplazarImparesPorCero(int[] arreglo) {
        int[] copia = arreglo.clone();
        for (int i = 0; i < copia.length; i++) {
            if (copia[i] % 2 != 0) {
                copia[i] = 0;
            }
        }
        return copia;
    }

    /**
     * Retorna una copia del arreglo donde cada valor fue multiplicado por su indice.
     */
    public static int[] multiplicarPorIndice(int[] arreglo) {
        int[] copia = arreglo.clone();
        for (int i = 0; i < copia.length; i++) {
            copia[i] = copia[i] * i;
        }
        return copia;
    }

    /**
     * Busqueda lineal de {@code valor} dentro del arreglo.
     *
     * @return el indice de la primera ocurrencia, o -1 si no se encuentra.
     */
    public static int busquedaLineal(int[] arreglo, int valor) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == valor) {
                return i;
            }
        }
        return -1;
    }
}
