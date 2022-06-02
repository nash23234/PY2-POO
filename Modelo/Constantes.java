package Modelo;
import java.awt.Color;
import java.text.CollationElementIterator; 

public interface Constantes {
    public static final int X =0;
    public static final int Y =1;

    public static final int CASILLA_WIDTH  = 10; //ancho de las casillas
    public static final int CASILLA_HEIGHT = 10; //Tamaño de las casillas

    public static final int TABLERO_SIZE = 30; //Tamaño del tablero

    public static final Color BG_COLOR = Color.WHITE; //Color de fondo
    public static final Color ALIADO = Color.GRAY; //Color de los aliados
    public static final Color ENEMIGO = Color.RED; //Color de los enemigos
    public static final Color JUGADORPRINCIPAL = Color.GREEN; //Color del jugador principal
}

