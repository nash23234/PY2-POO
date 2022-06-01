package  Vista;

import java.awt.*;
import javax.swing.*;
import Modelo.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;




public class GUI implements Constantes, KeyListener{
    
    public JFrame ventana;
    public Mapa mapa;

    public GUI(){
        ventana = new JFrame("Tablero");
        mapa = new Mapa();
        ventana.add(mapa.panelTablero);
        ventana.setSize(1000,720);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ventana.setResizable(false);
        //ponerAtacantes();
        ventana.pack();
        ventana.setVisible(true);
        //moverJugador(0,0);
    }

    public void moverJugador(JugadorPrincipal hereo){
        mapa.tablero[hereo.lastPosition[X]][hereo.lastPosition[X]].setBackground(BG_COLOR);
        mapa.tablero[hereo.coordenadas[X]][hereo.coordenadas[Y]].setBackground(JUGADORPRINCIPAL);
    }

    //poner atacantes en el tablero y guardarlos en un array , que ningun atacante este en el indice 0,0
    public void ponerAtacantes(int x, int y){
        mapa.tablero[x][y].setBackground(ENEMIGO);

    }



    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }


   
    
}
