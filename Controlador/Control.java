package Controlador;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import Modelo.*;

import Vista.*;

public class Control extends Tablero  implements KeyListener,Constantes{
    
    JugadorPrincipal jugador= new JugadorPrincipal();
    public Tablero tablero;
    public ArrayList <Atacante> enemigos ;
    public Atacante enemigo;
   
    
    public Control() {

        enemigos = super.getEnemigos();   
    }

    
    

    @Override
    public void keyReleased(KeyEvent e) {
      
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e)  {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
          
            jugador.moverseJugador('R');
            jugador.validarPosicion();
            moverEnemigo();
            
           
            System.out.println("moviendose a la derecha");

            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);

            matriz[jugador.lastPosition[X]][jugador.lastPosition[Y]].setBackground(BG_COLOR);
            matriz[jugador.coordenadas[X]][jugador.coordenadas[Y]].setBackground(JUGADORPRINCIPAL);
         

        }
    
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            jugador.moverseJugador('L');
            jugador.validarPosicion();
            moverEnemigo();
            System.out.println("moviendose a la izquierda");
            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            matriz[jugador.lastPosition[X]][jugador.lastPosition[Y]].setBackground(BG_COLOR);
            matriz[jugador.coordenadas[X]][jugador.coordenadas[Y]].setBackground(JUGADORPRINCIPAL);
         
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
            jugador.moverseJugador('U');
            jugador.validarPosicion();
            moverEnemigo();
            System.out.println("moviendose hacia arriba");

            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            matriz[jugador.lastPosition[X]][jugador.lastPosition[Y]].setBackground(BG_COLOR);
            matriz[jugador.coordenadas[X]][jugador.coordenadas[Y]].setBackground(JUGADORPRINCIPAL);
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            jugador.moverseJugador('D');
            jugador.validarPosicion();
            moverEnemigo();
            System.out.println("moviendose hacia abajo");

            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            matriz[jugador.lastPosition[X]][jugador.lastPosition[Y]].setBackground(BG_COLOR);
            matriz[jugador.coordenadas[X]][jugador.coordenadas[Y]].setBackground(JUGADORPRINCIPAL);
           
        }
    }


    //
    public void moverEnemigo(){
        for(int i=0;i<enemigos.size();i++){
            enemigos.get(i).acercarseJugador(jugador.coordenadas[X],jugador.coordenadas[Y]);
            matriz[enemigos.get(i).lastPosition[X]][enemigos.get(i).lastPosition[Y]].setBackground(BG_COLOR);
            matriz[enemigos.get(i).currentPosition[X]][enemigos.get(i).currentPosition[Y]].setBackground(ENEMIGO);
        }
    }

    //limpiar la casilla de la posicion anterior del enemigo
    public void limpiarCasilla(int x,int y){

        matriz[x][y].setBackground(BG_COLOR);
    }

   
}
