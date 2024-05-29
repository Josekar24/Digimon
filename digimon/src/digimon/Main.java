/**
 * Clase principal que representa el inicio del juego de Digimon.
 */
package digimon;

import java.util.Scanner;

public class Main {

    /**
     * Método principal que inicia el juego de Digimon.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nombre del domador:");
        String nombreDomador = scanner.nextLine();
        Domador domador = new Domador(nombreDomador);

        while (true) {
            System.out.println("1. Iniciar batalla");
            System.out.println("2. Salir");
            int opcion = validarEntrada(2);

            if (opcion == 1) {
                BatallaDigital batalla = new BatallaDigital();
                System.out.println("¡Un " + batalla.getEnemigo().getNombre() + " salvaje ha aparecido!");
                batalla.getEnemigo().mostrarEstadisticas();
                batalla.elige(domador);
            } else if (opcion == 2) {
                System.out.println("¡Hasta la próxima, suerte la proxima vez!");
                break;
            }
        }
    }

    /**
     * Método privado para validar la entrada del usuario.
     * @param max Valor máximo válido.
     * @return La opción válida ingresada por el usuario.
     */
    private static int validarEntrada(int max) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while (opcion < 1 || opcion > max) {
            System.out.print("Elige una opción válida (1-" + max + "): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Entrada inválida. Elige una opción válida (1-" + max + "): ");
                scanner.next();
            }
            opcion = scanner.nextInt();
        }
        return opcion;
    }
}

