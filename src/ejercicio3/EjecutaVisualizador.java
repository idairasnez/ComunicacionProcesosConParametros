package ejercicio3;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjecutaVisualizador {

    public static void main(String[] args) {

        // Pedimos la cadena al usuario
        System.out.print("Introduce una cadena: ");
        String cadena = Entrada.cadena();

        // Obtenemos la ruta donde están las clases compiladas
        String rutaClases = System.getProperty("java.class.path");

        // Preparamos el proceso hijo con la cadena y el número de veces como argumentos
        ProcessBuilder constructorProceso = new ProcessBuilder("java", "-cp", rutaClases, Visualizador.class.getName(), cadena, Integer.toString(5));

        try {
            // Lanzamos el proceso hijo
            Process proceso = constructorProceso.start();

            // Leemos lo que el hijo escribe en su salida estándar y lo mostramos
            BufferedReader lectorHijo = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            while ((linea = lectorHijo.readLine()) != null) {
                System.out.println(linea);
            }
            lectorHijo.close();

            // Esperamos a que termine y obtenemos su valor de salida
            proceso.waitFor();
            int valorSalida = proceso.exitValue();

            // Mostramos el valor de salida
            System.out.println("Valor de salida: " + valorSalida);

            // Mostramos "Final Correcto" o "Final Incorrecto" según el valor
            if (valorSalida == 0) {
                System.out.println("Final Correcto");
            } else {
                System.out.println("Final Incorrecto");
            }

        } catch (IOException e) {
            System.err.println("Error al lanzar el proceso.");
        } catch (InterruptedException e) {
            System.err.println("Se ha interrumpido la espera del proceso.");
        }
    }
}