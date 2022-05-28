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
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            jugador.moverse('R');
            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            moverJugador(jugador.coordenadas[0], jugador.coordenadas[1]);
            System.out.println("Estoy en la derecha");
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            jugador.moverse('L');
            
            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            moverJugador(jugador.coordenadas[0], jugador.coordenadas[1]);
            System.out.println("Estoy en la izquierda");
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            jugador.moverse('D');
            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            moverJugador(jugador.coordenadas[0], jugador.coordenadas[1]);
            System.out.println("Estoy abajo");
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
            jugador.moverse('U');
           
            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            moverJugador(jugador.coordenadas[0], jugador.coordenadas[1]);
            System.out.println("Estoy arriba");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
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
