package Vista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.*;

import Modelo.Secundarios;

import Modelo.Constantes;

public class Mapa implements Constantes {
    public JPanel panelTablero;
    public Casilla[][] tablero;


    public Mapa(){
        tablero = new Casilla[TABLERO_SIZE][TABLERO_SIZE];
        panelTablero = new JPanel();
        panelTablero.setLayout(new GridLayout(TABLERO_SIZE, TABLERO_SIZE));
        for (int i = 0; i < TABLERO_SIZE; i++){
            for (int j = 0; j < TABLERO_SIZE; j++){
                tablero[i][j] = new Casilla(i, j);
                tablero[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                tablero[i][j].setOpaque(true);
                panelTablero.add(tablero[i][j]);
            }
        }
    }
   
     
}
