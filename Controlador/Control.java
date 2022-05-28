package Controlador;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.KeyException;
import Modelo.*;

import Vista.*;

public class Control  implements KeyListener{
    
    JugadorPrincipal jugador= new JugadorPrincipal();
    Tablero tablero= new Tablero();
    public Control(){
        addKeyListener(this);
    }
    
    private void addKeyListener(Control control) {

    }

    @Override
    public void keyTyped(KeyEvent e) {  

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            jugador.moverse('R');
            tablero.moverJugador(jugador.coordenadas[0], jugador.coordenadas[1]);
            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            System.out.println("Estoy en la derecha");
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            jugador.moverse('L');
            tablero.moverJugador(jugador.coordenadas[0], jugador.coordenadas[1]);
            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            System.out.println("Estoy en la izquierda");
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            jugador.moverse('D');
            
            tablero.moverJugador(jugador.coordenadas[0], jugador.coordenadas[1]);
            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            System.out.println("Estoy abajo");
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
            jugador.moverse('U');
            tablero.moverJugador(jugador.coordenadas[0], jugador.coordenadas[1]);
            System.out.println("cordenada: X"+ jugador.coordenadas[0]+"cordenada: Y" +jugador.coordenadas[1]);
            System.out.println("Estoy arriba");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
      
    }
    
    public static void main(String args){
        
    }
}
