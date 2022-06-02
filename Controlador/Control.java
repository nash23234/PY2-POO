package Controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import Modelo.*;

import Vista.*;

public class Control extends GUI implements KeyListener, Constantes {

    JugadorPrincipal jugador;
    public ArrayList<Secundarios> enemigos = new ArrayList<Secundarios>();
    public ArrayList<Secundarios> aliados = new ArrayList<Secundarios>();
    Secundarios creador;

    public Control() {

        ventana.addKeyListener(this);
        jugador = new JugadorPrincipal();

    }

    // se agregan los observadores al arraylist de observadores
    public void suscribirEnemigos() {
        for (Secundarios i : enemigos) {
            System.out.println("suscribiendo");
            jugador.agregarObservadores(i);
        }
    }

    public void suscribirAliados() {
        for (Secundarios i : aliados) {
            jugador.agregarObservadores(i);
        }
    }

    // se deben hacer ciclos, para que se agreguen cada enemigo y aliado
    public void crearEnemigos(int cant) {
        for (int i = 0; i < cant; i++) {
            creador = Factory.creaFactory(2);
            //verificarEnemy(creador);
            enemigos.add(creador);
            ponerAtacantes(creador);
        }
        suscribirEnemigos();
    }

    public void verificarEnemy(Secundarios nuevo) {
        if (enemigos.isEmpty()) {
            enemigos.add(nuevo);
        } else {
            for (Secundarios i : enemigos) {
                if (nuevo.currentPosition[X] == i.currentPosition[X] && nuevo.currentPosition[Y] == i.currentPosition[Y]) {
                    creador = Factory.creaFactory(2);
                    verificarEnemy(nuevo);
                } else {
                    enemigos.add(nuevo);
                }
            }
        }
    }

    public void crearAliados() {

        for (int i = 0; i > 10; i++) {
            creador = Factory.creaFactory(1);
            aliados.add(creador);
        }

    }

    public void moverEnemigo(){
        for (Secundarios i : enemigos) {
            ponerAtacantes(i);
        }
    }
    // ------------------------------------------------------------------

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            jugador.moverseJugador('R');
            jugador.validarPosicion();
            System.out.println("moviendose a la derecha");
            System.out.println("cordenada: X" + jugador.coordenadas[0] + "cordenada: Y" + jugador.coordenadas[1]);
            moverJugador(jugador);
            moverEnemigo();

        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            jugador.moverseJugador('L');

            jugador.validarPosicion();

            System.out.println("moviendose a la izquierda");

            System.out.println("cordenada: X" + jugador.coordenadas[0] + "cordenada: Y" + jugador.coordenadas[1]);
            moverJugador(jugador);
            moverEnemigo();
            
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            jugador.moverseJugador('U');
            jugador.validarPosicion();
            System.out.println("moviendose hacia arriba");

            System.out.println("cordenada: X" + jugador.coordenadas[0] + "cordenada: Y" + jugador.coordenadas[1]);
            moverJugador(jugador);
            moverEnemigo();
           
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            jugador.moverseJugador('D');
            jugador.validarPosicion();
            System.out.println("moviendose hacia abajo");

            System.out.println("cordenada: X" + jugador.coordenadas[0] + "cordenada: Y" + jugador.coordenadas[1]);
            moverJugador(jugador);
            moverEnemigo();
            
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            crearEnemigos(10);
            
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

        }
    }


    // -----------------------------------------------------------------------------------
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}
