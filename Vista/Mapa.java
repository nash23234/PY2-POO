package Vista;
<<<<<<< HEAD

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.Color;

=======
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.Color;
>>>>>>> 76f08738b7eee7628d4b03c647bad24339020066
import Modelo.Constantes;

public class Mapa implements Constantes {
    
    public JPanel panelTablero;
    public Casilla[][] tablero;

    public Mapa() {
        tablero = new Casilla[TABLERO_SIZE][TABLERO_SIZE];
        panelTablero = new JPanel();
        panelTablero.setLayout(new GridLayout(TABLERO_SIZE, TABLERO_SIZE));
        panelTablero.setSize(20, 20);
        for (int i = 0; i < TABLERO_SIZE; i++) {
            for (int j = 0; j < TABLERO_SIZE; j++) {
                tablero[i][j] = new Casilla(i, j);
                tablero[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                tablero[i][j].setOpaque(true);
                panelTablero.add(tablero[i][j]);
            }
        }
    }

}
