package ejercicio1;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.IOException;

public class EjecutaValidaArgumentos {

    public static void main(String[] args) {

        // Pedimos al usuario el dato que se enviará como argumento
        System.out.println("Introduce un argumento: ");
        String dato = Entrada.cadena();

        // Obtenemos la ruta donde están las clases compiladas
        String rutaClases = System.getProperty("java.class.path");

        // Preparamos el proceso hijo: sin argumento si el dato está vacío, con él si no
        ProcessBuilder constructorProceso;
        if (dato.isEmpty()) {
            constructorProceso = new ProcessBuilder("java", "-cp", rutaClases, ValidaArgumentos.class.getName());
        } else {
            constructorProceso = new ProcessBuilder("java", "-cp", rutaClases, ValidaArgumentos.class.getName(), dato);
        }

        try {
            // Lanzamos el proceso hijo
            Process procesoValidador = constructorProceso.start();

            // Esperamos a que termine y obtenemos su valor de salida
            procesoValidador.waitFor();
            int valorSalida = procesoValidador.exitValue();

            // Mostramos el valor de salida
            System.out.println("Valor de salida: " + valorSalida);

            // Mostramos el mensaje correspondiente al valor recibido
            switch (valorSalida) {
                case 1 -> System.out.println("No hay argumentos...");
                case 2 -> System.out.println("Es una cadena...");
                case 3 -> System.out.println("Número menor que 0...");
                case 4 -> System.out.println("Número mayor o igual que 0...");
            }

        } catch (IOException e) {
            System.err.println("Error al lanzar el proceso.");
        } catch (InterruptedException e) {
            System.err.println("Se ha interrumpido la espera del proceso.");
        }
    }
}