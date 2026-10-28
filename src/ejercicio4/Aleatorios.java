package ejercicio4;

import java.io.*;
import java.util.Random;

public class Aleatorios {

    public static void main(String[] args) {

        // Preparamos la lectura de la entrada estándar y el generador de números aleatorios
        BufferedReader entradaEstandar = new BufferedReader(new InputStreamReader(System.in));
        Random generador = new Random();

        try {
            // Por cada línea recibida (petición), generamos y enviamos un número aleatorio
            String linea;
            while ((linea = entradaEstandar.readLine()) != null) {
                // Generamos un número del 0 al 10 y lo escribimos en la salida estándar
                int numero = generador.nextInt(11);
                System.out.println(numero);
            }
            entradaEstandar.close();
        } catch (IOException e) {
            System.err.println("Error al leer la entrada estándar.");
        }
    }
}
