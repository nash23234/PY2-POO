package Vista;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modelo.Constantes;

public class Casilla extends JLabel implements Constantes {
    private int[] coordenadas;
    public Casilla(int posX, int posY){
        coordenadas = new int[2];
        coordenadas[X] = posX;
        coordenadas[Y] = posY;

        setBackground(BG_COLOR);
        setPreferredSize(new Dimension(CASILLA_WIDTH, CASILLA_HEIGHT));
    }

   
    public int[] getCoords(){
        return coordenadas;
    }

    public void pintarPersonaje(){
        setBackground(JUGADORPRINCIPAL);
    }

    public void clearPersonaje(){
        setBackground(BG_COLOR);
    }

    public void pintarEnemigo(){
        setBackground(ENEMIGO);
    }

    public void clearEnemigo(){
        setBackground(BG_COLOR);
    }

    public void pintarAliado(){
        setBackground(ALIADO);
    }

    public void clearAliado(){
        setBackground(BG_COLOR);
    }


}
