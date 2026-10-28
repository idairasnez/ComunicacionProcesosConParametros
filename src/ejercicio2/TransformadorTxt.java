package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransformadorTxt {

    public static void main(String[] args) {

        // Preparamos la lectura de la entrada estándar
        BufferedReader entradaEstandar = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Leemos líneas mientras lleguen y mostramos cada una en mayúsculas
            String linea;
            while ((linea = entradaEstandar.readLine()) != null) {
                System.out.println(linea.toUpperCase());
            }
            entradaEstandar.close();

        } catch (IOException e) {
            System.err.println("Error al leer la entrada estándar.");
        }
    }
}