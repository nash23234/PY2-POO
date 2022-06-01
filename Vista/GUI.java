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
    Mapa mapa;

    public GUI(){
        ventana = new JFrame("Tablero");
        mapa = new Mapa();

        ventana.setSize(720,720);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(mapa.panelTablero);
        ventana.setResizable(false);
        ventana.setLayout(new GridLayout(30,30));
        ventana.addKeyListener(this);
        
    
        moverJugador(0,0);
        ponerAtacantes();
        ventana.setVisible(true);
       
    }

    public void moverJugador(int x, int y){
        mapa.tablero[x][y].setBackground(BG_COLOR);
        mapa.tablero[x][y].setBackground(JUGADORPRINCIPAL);
    }

    //poner atacantes en el tablero y guardarlos en un array , que ningun atacante este en el indice 0,0
    public void ponerAtacantes(){
        Random r = new Random();

        for(int i=0;i<10;i++){
            int x = r.nextInt(30);
            int y = r.nextInt(30);
            if(x==0 && y==0){
                i--;
            }else{
                mapa.tablero[x][y].setBackground(ENEMIGO);
                //atacante.guardarAtacantes(x, y);
            }
        }

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
