package digimon;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase que representa un Domador en el juego de Digimon.
 */
class Domador {
    private String nombre;
    private ArrayList<Digimon> equipo;
    public static final int CAPACIDAD_EQUIPO = 3;

    /**
     * Constructor para crear un Domador con un nombre dado.
     * @param nombre El nombre del Domador.
     */
    public Domador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
        // Agregar un Digimon aleatorio al equipo
        String[] nombres = {"Agumon", "Gabumon", "Patamon"};
        String digimonInicial = nombres[new Random().nextInt(nombres.length)];
        equipo.add(new Digimon(digimonInicial, digimonInicial));
    }

    /**
     * Método para obtener el nombre del Domador.
     * @return El nombre del Domador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener el equipo de Digimon del Domador.
     * @return El equipo de Digimon del Domador.
     */
    public ArrayList<Digimon> getEquipo() {
        return equipo;
    }

    /**
     * Método para capturar un Digimon y añadirlo al equipo del Domador.
     * @param digimon El Digimon a capturar.
     */
    public void captura(Digimon digimon) {
        if (digimon.getSalud() <= 20 && equipo.size() < CAPACIDAD_EQUIPO) {
            equipo.add(digimon);
            System.out.println(digimon.getNombre() + " ha sido añadido a su equipo");
        } else {
            System.out.println("No se ha podido unir");
        }
    }
}
