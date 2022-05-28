package  Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import Controlador.Control;
import Modelo.*;





public class Tablero implements Constantes{
    JFrame ventana;
    public  JLabel [][] matriz;

    public Control control;
    
    public Tablero(){
        ventana = new JFrame("Tablero");
        ventana.setSize(720,720);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new GridLayout(30,30));

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

        Control control = new Control();
        ventana.addKeyListener(control);
    }

    public void pintar(int x, int y, Color color){
        matriz[x][y].setBackground(color);
    }

    public void limpiar(){
        for(int i=0;i<30;i++){
            for(int j=0;j<30;j++){
                matriz[i][j].setBackground(BG_COLOR);
            }
        }
    }

 
    //posicionar el jugador principal en el tablero
    public void posicionarJugador(int x, int y){
        matriz[x][y].setBackground(JUGADORPRINCIPAL);
    }

    //si el jugador principal se mueve a otra casilla se pinta la casilla nueva y la antigua se pinta de blanco
    public void moverJugador(int x, int y){
        matriz[x][y].setBackground(JUGADORPRINCIPAL);
        matriz[x][y].setBackground(BG_COLOR);
    }


    
    //posicionar 10 enemigos en el tablero aleatoriamente
    /*
    public void posicionarEnemigos(int x, int y){
        Random r = new Random();
        int numero = r.nextInt(10);
        for(int i=0;i<numero;i++){
            int x1 = r.nextInt(30);
            int y1 = r.nextInt(30);
            matriz[x1][y1].setBackground(ENEMIGO);
        }
    }
    */

    
    







}
