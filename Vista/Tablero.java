package  Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import Controlador.Control;
import Modelo.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;




public class Tablero implements Constantes,KeyListener{
    JFrame ventana;
    public  JLabel [][] matriz;
    JugadorPrincipal jugador= new JugadorPrincipal();
    
    
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
        ventana.setVisible(true);
    }

    public void moverJugador(int x, int y){
        matriz[x][y].setBackground(JUGADORPRINCIPAL);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
