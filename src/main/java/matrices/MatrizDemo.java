package matrices;

/**
 * Demuestra los conceptos fundamentales de matrices (arreglos bidimensionales) en Java:
 * declaracion, inicializacion, recorrido y operaciones basicas.
 */
public class MatrizDemo {

    public static void main(String[] args) {
        int[][] matriz = crearMatrizDelUnoAlNueve();

        System.out.println("=== 1. Declaracion e inicializacion (matriz 3x3, valores 1-9) ===");
        imprimirComoTabla(matriz);

        System.out.println("\n=== 2. Recorrido ===");
        System.out.println("-- Por filas (tabla) --");
        imprimirComoTabla(matriz);
        System.out.println("-- Por columnas --");
        imprimirPorColumnas(matriz);

        System.out.println("\n=== 3. Operaciones ===");
        System.out.println("Suma de todos los elementos: " + sumarElementos(matriz));

        System.out.println("Matriz con la primera y ultima fila intercambiadas:");
        int[][] intercambiada = intercambiarPrimeraYUltimaFila(matriz);
        imprimirComoTabla(intercambiada);
    }

    /**
     * Crea una matriz 3x3 e inicializa sus celdas con los valores 1 al 9, fila por fila.
     */
    public static int[][] crearMatrizDelUnoAlNueve() {
        int[][] matriz = new int[3][3];
        int valor = 1;
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = valor++;
            }
        }
        return matriz;
    }

    public static void imprimirComoTabla(int[][] matriz) {
        for (int[] fila : matriz) {
            StringBuilder linea = new StringBuilder();
            for (int valor : fila) {
                linea.append(valor).append("\t");
            }
            System.out.println(linea.toString().trim());
        }
    }

    public static void imprimirPorColumnas(int[][] matriz) {
        int numeroColumnas = matriz[0].length;
        for (int columna = 0; columna < numeroColumnas; columna++) {
            for (int[] fila : matriz) {
                System.out.print(fila[columna] + " ");
            }
            System.out.println();
        }
    }

    public static int sumarElementos(int[][] matriz) {
        int suma = 0;
        for (int[] fila : matriz) {
            for (int valor : fila) {
                suma += valor;
            }
        }
        return suma;
    }

    /**
     * Retorna una copia de la matriz con la primera y la ultima fila intercambiadas.
     */
    public static int[][] intercambiarPrimeraYUltimaFila(int[][] matriz) {
        int[][] copia = new int[matriz.length][];
        for (int i = 0; i < matriz.length; i++) {
            copia[i] = matriz[i].clone();
        }
        int[] temporal = copia[0];
        copia[0] = copia[copia.length - 1];
        copia[copia.length - 1] = temporal;
        return copia;
    }
}
