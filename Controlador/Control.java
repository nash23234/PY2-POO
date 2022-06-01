package Controlador;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Modelo.*;

import Vista.*;

public class Control extends Tablero  implements KeyListener,Constantes{
    
    JugadorPrincipal jugador= new JugadorPrincipal();
    public Tablero tablero;
    
    public Control() {
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
            //atacante.moverseAtacante(jugador.coordenadas[X],jugador.coordenadas[Y]);
            jugador.validarPosicion();
            System.out.println("moviendose a la derecha");

            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            
            matriz[jugador.lastPosition[X]][jugador.lastPosition[Y]].setBackground(BG_COLOR);
            matriz[jugador.coordenadas[X]][jugador.coordenadas[Y]].setBackground(JUGADORPRINCIPAL);
        }
    
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            jugador.moverseJugador('L');
            
            jugador.validarPosicion();
            
            //atacante.moverAtacante(jugador.coordenadas[X],jugador.coordenadas[Y]);
            System.out.println("moviendose a la izquierda");

            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            matriz[jugador.lastPosition[X]][jugador.lastPosition[Y]].setBackground(BG_COLOR);
            matriz[jugador.coordenadas[X]][jugador.coordenadas[Y]].setBackground(JUGADORPRINCIPAL);
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
            jugador.moverseJugador('U');
            jugador.validarPosicion();
            System.out.println("moviendose hacia arriba");

            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            matriz[jugador.lastPosition[X]][jugador.lastPosition[Y]].setBackground(BG_COLOR);
            matriz[jugador.coordenadas[X]][jugador.coordenadas[Y]].setBackground(JUGADORPRINCIPAL);
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            jugador.moverseJugador('D');
            jugador.validarPosicion();
            System.out.println("moviendose hacia abajo");

            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            matriz[jugador.lastPosition[X]][jugador.lastPosition[Y]].setBackground(BG_COLOR);
            matriz[jugador.coordenadas[X]][jugador.coordenadas[Y]].setBackground(JUGADORPRINCIPAL);
        }
    }


   


   
}
