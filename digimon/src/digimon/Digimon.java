package digimon;

import java.util.Random;

/**
 * Clase que representa un Digimon en el juego.
 */
class Digimon {
    private String nombre;
    private String especie;
    private int nivel;
    private int ataque;
    private int salud;
    private int dp1;
    private int dp2;

    /**
     * Constructor para crear un Digimon con un nombre y especie específicos.
     * @param nombre Nombre del Digimon.
     * @param especie Especie del Digimon.
     */
    public Digimon(String nombre, String especie) {
        this.nombre = nombre;
        this.especie = especie;
        this.nivel = new Random().nextInt(5) + 1;
        this.ataque = 5 * nivel;
        this.salud = 10 * nivel;
        this.dp1 = 10;
        this.dp2 = 10;
    }

    /**
     * Método para obtener el nombre del Digimon.
     * @return El nombre del Digimon.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener la especie del Digimon.
     * @return La especie del Digimon.
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * Método para obtener el nivel del Digimon.
     * @return El nivel del Digimon.
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Método para obtener el valor de ataque del Digimon.
     * @return El valor de ataque del Digimon.
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Método para obtener la salud actual del Digimon.
     * @return La salud actual del Digimon.
     */
    public int getSalud() {
        return salud;
    }

    /**
     * Método para establecer la salud del Digimon.
     * @param salud La nueva salud del Digimon.
     */
    public void setSalud(int salud) {
        this.salud = salud;
    }

    /**
     * Método que representa el primer tipo de ataque del Digimon.
     * @return El valor de ataque si el Digimon tiene puntos de daño disponibles, de lo contrario, 0.
     */
    public int ataque1() {
        if (dp1 > 0) {
            dp1--;
            return ataque;
        } else {
            return 0;
        }
    }

    /**
     * Método que representa el segundo tipo de ataque del Digimon.
     * @return El valor de ataque si el Digimon tiene puntos de daño disponibles, de lo contrario, 0.
     */
    public int ataque2() {
        if (dp2 > 1) {
            dp2 -= 2;
            return 2 * ataque;
        } else {
            return 0;
        }
    }

    /**
     * Método para mostrar las estadísticas del Digimon en la consola.
     */
    public void mostrarEstadisticas() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Nivel: " + nivel);
        System.out.println("Ataque: " + ataque);
        System.out.println("Salud: " + salud);
        System.out.println("DP1: " + dp1 + " (daño: " + ataque + ")");
        System.out.println("DP2: " + dp2 + " (daño: " + (2 * ataque) + ")");
    }

    /**
     * Método para representar el Digimon como una cadena de texto.
     * @return Representación del Digimon como una cadena de texto.
     */
    @Override
    public String toString() {
        return nombre + " (" + especie + ") - Nivel: " + nivel + ", Ataque: " + ataque + ", Salud: " + salud + ", DP1: " + dp1 + ", DP2: " + dp2;
    }
}
