package ejercicio3;

public class Visualizador {

    public static void main(String[] args) {

        // Si no llegan los dos argumentos o la cadena está vacía,
        // mostramos un mensaje y terminamos con el código 1
        if (args.length < 2 || args[0].isEmpty()) {
            System.out.println("Cadena introducida vacía.");
            System.exit(1);
        }

        // Guardamos la cadena (primer argumento)
        String cadena = args[0];

        // Convertimos el número de veces (segundo argumento) a entero
        int veces = Integer.parseInt(args[1]);

        // Mostramos la cadena numerada tantas veces como indique el número
        for (int i = 1; i <= veces; i++) {
            System.out.println(i + ". " + cadena);
        }
    }
}