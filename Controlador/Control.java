package Controlador;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Modelo.*;

import Vista.*;

public class Control extends GUI  implements KeyListener,Constantes{
    
    JugadorPrincipal jugador;
    
    Secundarios creador;
    
    public Control() {
        ventana.addKeyListener(this);
        jugador= new JugadorPrincipal();
    }

    // se deben hacer ciclos, para que se agreguen cada enemigo y aliado 
    public void crearEnemigos(){
        
        creador= Factory.creaFactory(2);
        
    }
    
    public void crearAliados(){

        creador= Factory.creaFactory(2);

    }
    //------------------------------------------------------------------


    

    @Override
    public void keyPressed(KeyEvent e)  {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            jugador.moverseJugador('R');
            jugador.validarPosicion();
            System.out.println("moviendose a la derecha");
            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            
            moverJugador(jugador);
            mapa.tablero[jugador.lastPosition[X]][jugador.lastPosition[Y]].clearPersonaje();
            mapa.tablero[jugador.coordenadas[X]][jugador.coordenadas[Y]].pintarPersonaje();
        }
    
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            jugador.moverseJugador('L');
            
            jugador.validarPosicion();
            
            //atacante.moverAtacante(jugador.coordenadas[X],jugador.coordenadas[Y]);
            System.out.println("moviendose a la izquierda");

            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            mapa.tablero[jugador.lastPosition[X]][jugador.lastPosition[Y]].clearPersonaje();
            mapa.tablero[jugador.coordenadas[X]][jugador.coordenadas[Y]].pintarPersonaje();
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
            jugador.moverseJugador('U');
            jugador.validarPosicion();
            System.out.println("moviendose hacia arriba");

            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            mapa.tablero[jugador.lastPosition[X]][jugador.lastPosition[Y]].clearPersonaje();
            mapa.tablero[jugador.coordenadas[X]][jugador.coordenadas[Y]].pintarPersonaje();
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            jugador.moverseJugador('D');
            jugador.validarPosicion();
            System.out.println("moviendose hacia abajo");

            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            mapa.tablero[jugador.lastPosition[X]][jugador.lastPosition[Y]].clearPersonaje();
            mapa.tablero[jugador.coordenadas[X]][jugador.coordenadas[Y]].pintarPersonaje();
        }
    }



   

//-----------------------------------------------------------------------------------
   @Override
    public void keyReleased(KeyEvent e) {
      
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
