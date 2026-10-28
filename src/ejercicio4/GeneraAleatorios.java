package ejercicio4;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class GeneraAleatorios {
    public static void main(String[] args) {

        // Indicamos al usuario cómo usar el programa
        System.out.println("Escribe cualquier texto para pedir un número aleatorio (escribe \"fin\" para terminar):");

        // Preparamos el proceso hijo (Aleatorios)
        String rutaClases = System.getProperty("java.class.path");
        ProcessBuilder constructorProceso = new ProcessBuilder("java", "-cp", rutaClases, Aleatorios.class.getName());

        try {
            // Lanzamos el proceso hijo
            Process proceso = constructorProceso.start();

            // Creamos el escritor hacia la entrada del hijo
            BufferedWriter escritorHijo = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()));

            // Creamos el lector de la salida del hijo
            BufferedReader lectorHijo = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            // Leemos la primera línea del usuario
            String lineaUsuario = Entrada.cadena();

            // Mientras el usuario no escriba "fin"
            while (!lineaUsuario.equals("fin")) {

                // Enviamos la línea al hijo como petición de un número aleatorio
                escritorHijo.write(lineaUsuario);
                escritorHijo.newLine();
                escritorHijo.flush();

                // Leemos el número aleatorio que nos devuelve el hijo y lo mostramos
                String numeroAleatorio = lectorHijo.readLine();
                System.out.println(numeroAleatorio);

                // Leemos la siguiente línea del usuario
                lineaUsuario = Entrada.cadena();
            }

            // El usuario ha escrito "fin": cerramos el escritor para que el hijo reciba el fin de datos y esperamos a que termine
            escritorHijo.close();
            proceso.waitFor();
        } catch (IOException e) {
            System.err.println("Error al lanzar o comunicarse con el proceso Aleatorios.");
        } catch (InterruptedException e) {
            System.err.println("Se ha interrumpido la espera del proceso Aleatorios.");
        }
    }
}
