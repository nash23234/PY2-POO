package Modelo;

/**
 *
 * @author Hengerlyn_Nash
 */
public abstract class Secundarios implements Constantes, Observador {
    public int[] currentPosition;
    public int[] lastPosition;
    public int[] personajePos;

    public int atacarJugador(int x, int y) {
        return 0;
    }

    public int curarJugador(int x, int y) {
        return 0;
    }
}
