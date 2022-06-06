package Vista;
<<<<<<< HEAD

=======
>>>>>>> 76f08738b7eee7628d4b03c647bad24339020066
import java.awt.Dimension;
import javax.swing.JLabel;
import Modelo.Constantes;

public class Casilla extends JLabel implements Constantes {
    private int[] coordenadas;

    public Casilla(int posX, int posY) {
        coordenadas = new int[2];
        coordenadas[X] = posX;
        coordenadas[Y] = posY;

        setBackground(BG_COLOR);
        setPreferredSize(new Dimension(20, 20));
    }

    public int[] getCoords() {
        return coordenadas;
    }

    public void pintarPersonaje() {
        setBackground(JUGADORPRINCIPAL);
    }

    public void pintarEnemigo() {
        setBackground(ENEMIGO);
    }

    public void clearCasilla() {
        setBackground(BG_COLOR);
    }

    public void pintarAliado() {
        setBackground(ALIADO);
    }

}
