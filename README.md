# Actividad Unidad 1 - Protocolo Individual: Arreglos y Matrices

**Asignatura:** Estructuras de datos
**Programa:** Ingeniería del software
**IES:** Universidad de Cartagena
**Tutor:** John Carlos Arrieta Arrieta
**Estudiante:** José Luis Arrieta Buelvas

## Introducción

Este repositorio contiene el desarrollo de la actividad individual de la Unidad 1 de la
asignatura Estructuras de Datos, enfocada en el estudio, implementación y práctica de los
conceptos fundamentales sobre **arreglos (arrays)** y **matrices (arreglos bidimensionales)**
utilizando el lenguaje de programación Java.

## Objetivos

- Comprender el concepto, la estructura en memoria y las operaciones básicas de los arreglos
  y las matrices.
- Implementar en Java las operaciones de declaración, inicialización, recorrido, modificación
  y búsqueda sobre arreglos.
- Implementar en Java la declaración, inicialización, recorrido y operaciones básicas sobre
  matrices.
- Aplicar los conceptos de arreglos en la resolución de un problema práctico asignado
  (Juego del Ahorcado).
- Practicar el flujo de trabajo estándar con Git y GitHub (ramas, commits, push, merge).

## Justificación

Los arreglos y las matrices son estructuras de datos fundamentales en la programación, ya que
permiten almacenar y organizar múltiples valores del mismo tipo de forma contigua en memoria,
siendo la base para estructuras de datos más complejas. Su comprensión es indispensable para
cualquier estudiante de Ingeniería de Software, pues son ampliamente utilizadas en la resolución
de problemas de búsqueda, ordenamiento, procesamiento de datos y simulación de sistemas reales.

## Desarrollo

El desarrollo de la actividad se organiza en tres módulos, cada uno correspondiente a una rama
de trabajo en Git:

### 1. Arreglos (Arrays)

Ubicado en [`src/main/java/arreglos`](src/main/java/arreglos). Incluye:

- Declaración e inicialización de un arreglo de 10 enteros con valores aleatorios.
- Recorrido con bucle `for` clásico y con `for-each`.
- Modificación: reemplazo de valores impares por cero y multiplicación de cada valor por su índice.
- Búsqueda lineal de un valor dentro del arreglo.
- Comparativa de sintaxis y diferencias entre lenguajes (estáticos vs. dinámicos, tipado
  fuerte vs. débil).

### 2. Matrices (Arreglos bidimensionales)

Ubicado en [`src/main/java/matrices`](src/main/java/matrices). Incluye:

- Declaración e inicialización de una matriz 3x3 con valores del 1 al 9.
- Recorrido e impresión en forma de tabla, y recorrido por columnas.
- Suma de todos los elementos de la matriz.
- Intercambio de la primera fila con la última.

### 3. Ejercicio asignado: Juego del Ahorcado

Ubicado en [`src/main/java/ahorcado`](src/main/java/ahorcado). Implementa:

- Un arreglo de caracteres para representar la palabra oculta.
- Control de letras adivinadas y errores cometidos.
- Registro de los puntajes de varios jugadores en un arreglo.

## Cómo ejecutar el proyecto

El proyecto usa Maven. Cada módulo tiene una clase con método `main` independiente:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="arreglos.ArregloDemo"
mvn exec:java -Dexec.mainClass="matrices.MatrizDemo"
mvn exec:java -Dexec.mainClass="ahorcado.Ahorcado"
```

## Enlaces

- **Repositorio público de GitHub:** https://github.com/JoseLuisArtetaBuelvas/MatricesYArreglos
- **Video de sustentación:** _pendiente_
