package ejercicio1;

public class ValidaArgumentos {

    public static void main(String[] args) {

        // Si no se ha recibido ningún argumento, terminamos con el código 1
        if (args.length < 1) {
            System.exit(1);
        }

        try {
            // Intentamos convertir el primer argumento en un número entero
            int numero = Integer.parseInt(args[0]);

            // Si el número es menor que 0, terminamos con el código 3
            if (numero < 0) {
                System.exit(3);
            } else {
                System.exit(4);
            }

        } catch (NumberFormatException e) {
            // Si no se puede convertir, es una cadena: terminamos con el código 2
            System.exit(2);
        }
    }
}