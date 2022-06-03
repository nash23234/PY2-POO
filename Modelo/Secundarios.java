package Modelo;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.event.ActionListener;

/**
 *
 * @author Hengerlyn_Nash
 */
public abstract class Secundarios implements Constantes, Observador {
    public int[] currentPosition;
    public int[] lastPosition;
    public int[] personajePos;

    public int atacarJugador(){
        return 0;
    }

}
