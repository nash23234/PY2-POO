package Controlador;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.KeyException;
import Modelo.*;

import Vista.*;

public class Control  implements KeyListener,Constantes{
    
    JugadorPrincipal jugador= new JugadorPrincipal();
    public Tablero tablero;
    
    public Control(){
        addKeyListener(this);
    }
    
    void addKeyListener(Control control) {

    }

    @Override
    public void keyTyped(KeyEvent e) {  

    }


    @Override 
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            jugador.moverseJugador('R');
            jugador.validarRango(jugador.coordenadas[0],jugador.coordenadas[1]);
            System.out.println(" cordenada: X"+ jugador.coordenadas[0]+ " cordenada: Y" +jugador.coordenadas[1]);
            System.out.println("Estoy en la derecha");
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
           jugador.moverseJugador('L');
            jugador.validarRango(jugador.coordenadas[0],jugador.coordenadas[1]);
            System.out.println(" cordenada: X"+ jugador.coordenadas[0]+" cordenada: Y" +jugador.coordenadas[1]);
            System.out.println("Estoy en la izquierda");
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            jugador.moverseJugador('D');
            jugador.validarRango(jugador.coordenadas[0],jugador.coordenadas[1]);
            System.out.println(" cordenada: X"+ jugador.coordenadas[0]+" cordenada: Y" +jugador.coordenadas[1]);
            System.out.println("Estoy abajo");
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
           jugador.moverseJugador('U');
            jugador.validarRango(jugador.coordenadas[0],jugador.coordenadas[1]);
            System.out.println(" cordenada: X"+ jugador.coordenadas[0]+" cordenada: Y" +jugador.coordenadas[1]);
            System.out.println("Estoy arriba");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
      
    }

}
