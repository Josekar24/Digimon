package digimon;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase que representa una Batalla Digital entre un Domador y un Digimon enemigo.
 */
class BatallaDigital {
    private Digimon enemigo;

    /**
     * Constructor para iniciar una Batalla Digital con un Digimon enemigo aleatorio.
     */
    public BatallaDigital() {
        String[] nombres = {"Agumon", "Gabumon", "Patamon"};
        String digimonEnemigo = nombres[new Random().nextInt(nombres.length)];
        enemigo = new Digimon(digimonEnemigo, digimonEnemigo);
    }

    /**
     * Método para obtener el Digimon enemigo de la Batalla Digital.
     * @return El Digimon enemigo.
     */
    public Digimon getEnemigo() {
        return enemigo;
    }

    /**
     * Método para que el Domador elija un Digimon de su equipo para la Batalla Digital.
     * @param domador El Domador que elige el Digimon.
     */
    public void elige(Domador domador) {
        System.out.println("Elige un Digimon de tu equipo:");
        for (int i = 0; i < domador.getEquipo().size(); i++) {
            System.out.println((i + 1) + ". " + domador.getEquipo().get(i));
        }
        int eleccion = validarEntrada(domador.getEquipo().size());
        Digimon elegido = domador.getEquipo().get(eleccion - 1);
        pelea(domador, elegido);
    }

    /**
     * Método que representa la pelea entre el Digimon del Domador y el Digimon enemigo.
     * @param domador El Domador que participa en la pelea.
     * @param digimon El Digimon del Domador que pelea.
     */
    public void pelea(Domador domador, Digimon digimon) {
        while (enemigo.getSalud() > 0 && digimon.getSalud() > 0) {
            System.out.println("Tu Digimon: " + digimon);
            System.out.println("Digimon Enemigo: " + enemigo);
            System.out.println("Elige una opción:");
            System.out.println("1. Ataque1");
            System.out.println("2. Ataque2");
            System.out.println("3. Capturar");

            int opcion = validarEntrada(3);
            int dano = 0;
            switch (opcion) {
                case 1:
                    dano = digimon.ataque1();
                    enemigo.setSalud(enemigo.getSalud() - dano);
                    System.out.println(digimon.getNombre() + " usó Ataque1 ha causado " + dano + " de daño.");
                    break;
                case 2:
                    dano = digimon.ataque2();
                    enemigo.setSalud(enemigo.getSalud() - dano);
                    System.out.println(digimon.getNombre() + " usó Ataque2 ha causado " + dano + " de daño.");
                    break;
                case 3:
                    domador.captura(enemigo);
                    if (domador.getEquipo().size() >= Domador.CAPACIDAD_EQUIPO) {
                        System.out.println("¡Felicidades! Has capturado los 3 Digimones y has completado el juego.");
                        System.exit(0);
                    }
                    return;
                default:
                    System.out.println("Opción no válida.");
                    continue;
            }

            if (enemigo.getSalud() > 0) {
                int danoEnemigo = enemigo.ataque1();
                digimon.setSalud(digimon.getSalud() - danoEnemigo);
                System.out.println(enemigo.getNombre() + " atacó causando " + danoEnemigo + " de daño.");
            }
        }

        if (digimon.getSalud() <= 0) {
            System.out.println(digimon.getNombre() + " ha sido derrotado.");
        } else if (enemigo.getSalud() <= 0) {
            System.out.println(enemigo.getNombre() + " ha sido derrotado.");
        }
    }

    /**
     * Método privado para validar la entrada del usuario.
     * @param max Valor máximo válido.
     * @return La opción válida ingresada por el usuario.
     */
    private int validarEntrada(int max) {
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
