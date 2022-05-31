package  Vista;

import java.awt.*;
import javax.swing.*;
import Modelo.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.channels.Pipe;
import java.util.Random;




public class Tablero implements Constantes, KeyListener{
    public JFrame ventana;
    public  JLabel [][] matriz;
    public JugadorPrincipal jugador;
    public Atacante atacante;
    
    
    
    public Tablero(){
        ventana = new JFrame("Tablero");
        ventana.setSize(720,720);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new GridLayout(30,30));
        ventana.addKeyListener(this);
       
       
        matriz = new JLabel[30][30];
        for(int i=0;i<30;i++){
            for(int j=0;j<30;j++){
                matriz[i][j] = new JLabel();
                matriz[i][j].setBackground(Color.WHITE);
                //poner bordes en los labels
                matriz[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                matriz[i][j].setOpaque(true);
                ventana.add(matriz[i][j]);
            }
        }
        moverJugador(0,0);
        ponerAtacantes();
        ventana.setVisible(true);
       
    }

    public void moverJugador(int x, int y){
        matriz[x][y].setBackground(JUGADORPRINCIPAL);
    }
    
    public void ponerAtacantes(){
        Random r = new Random();
        for(int i=0;i<10;i++){
            int x = r.nextInt(30);
            int y = r.nextInt(30);
            matriz[x][y].setBackground(ENEMIGO);
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
