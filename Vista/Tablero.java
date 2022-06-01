package  Vista;

import java.awt.*;
import javax.swing.*;
import Modelo.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;




public class Tablero implements Constantes, KeyListener{
    
    public JFrame ventana;
    public JLabel [][] matriz;
    public JugadorPrincipal jugador;
    ArrayList<Atacante> enemigos = new ArrayList<Atacante>();

    
    
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
        ponerEnemigo();
        ventana.setVisible(true);
       
    }

    public void moverJugador(int x, int y){
        matriz[x][y].setBackground(JUGADORPRINCIPAL);
    }

    public void moverEnemigo(int x, int y){
        matriz[x][y].setBackground(ENEMIGO);
    }
   
    public void ponerEnemigo(){
        Random r = new Random();
        for(int i=0;i<10;i++){
            int x = r.nextInt(30); //genera un numero aleatorio entre 0 y 29
            int y = r.nextInt(30); //genera un numero aleatorio entre 0 y 29
            if(x == 0 && y == 0){
                i--;
            }
            else{
                if(matriz[x][y].getBackground()==BG_COLOR){
                matriz[x][y].setBackground(ENEMIGO);
                enemigos.add(new Atacante(x,y));
                System.out.println("Enemigo creado en fila: "+x+" columna: "+y);
                }
                else{
                    i--; //si no se puede crear el enemigo, se vuelve a intentar
                }
                
            }
        }
    }

   

    
    public JFrame getVentana() {
        return ventana;
    }

    public void setVentana(JFrame ventana) {
        this.ventana = ventana;
    }

    public JLabel[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(JLabel[][] matriz) {
        this.matriz = matriz;
    }

    public JugadorPrincipal getJugador() {
        return jugador;
    }

    public void setJugador(JugadorPrincipal jugador) {
        this.jugador = jugador;
    }

    public ArrayList<Atacante> getEnemigos() {
        return enemigos;
    }

    public void setEnemigos(ArrayList<Atacante> enemigos) {
        this.enemigos = enemigos;
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
