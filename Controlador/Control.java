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
        crearEnemigos();

    }

    // ----------------------------ENEMIGOS--------------------------------------
    //Por hacer: Que se pinten y despinten bien, restar vida (si pasan por ese enemigo el personaje)
    //que no se junten en el pintar, aumentar enemigos
    // se agregan los observadores al arraylist de observadores
    public void suscribirEnemigos() {
        for (Secundarios i : enemigos) {
            //System.out.println("suscribiendo");
            jugador.agregarObservadores(i);
        }
    }

    // se deben hacer ciclos, para que se agreguen cada enemigo y aliado
    public void crearEnemigos() {
        for (int i = 0; i <10; i++) {
            creador = Factory.creaFactory(2);
            enemigos.add(creador);
            ponerAtacantes(creador);
        }
        suscribirEnemigos();
    }

    public void verificarEnemy(Secundarios nuevo) {//Arreglar validacion
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

    
    public void moverEnemigo(){
        for (Secundarios i : enemigos) {
            //if(jugador.coordenadas!= i.currentPosition)
            ponerAtacantes(i);
        }
    }
    // ----------------------------ALIADOS--------------------------------------
    //Por hacer: 
    
    public void suscribirAliados() {
        for (Secundarios i : aliados) {
            jugador.agregarObservadores(i);
        }
    }

    public void crearAliados() { //
        for (int i = 0; i > 10; i++) {
            creador = Factory.creaFactory(1);
            aliados.add(creador);
        }

    }

    public void reducirVida(){
        int damage;
        for (Secundarios i : enemigos) {
            damage=i.atacarJugador();
            if(damage!=0){
                jugador.RecibirAtaque(damage);
            }
        }
    }



    // ------------------------------------------------------------------

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            jugador.moverseJugador('R');
            jugador.validarPosicion();
            //System.out.println("moviendose a la derecha");
            //System.out.println("cordenada: X" + jugador.coordenadas[0] + "cordenada: Y" + jugador.coordenadas[1]);
            
            moverEnemigo();
            reducirVida();
            System.out.println("Hp jugador:"+jugador.hp);
            mapa.tablero[jugador.lastPosition[X]][jugador.lastPosition[Y]].clearCasilla();
            mapa.tablero[jugador.coordenadas[X]][jugador.coordenadas[Y]].pintarPersonaje();

        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            jugador.moverseJugador('L');

            jugador.validarPosicion();
            moverEnemigo();
            reducirVida();
            System.out.println("Hp jugador:"+jugador.hp);
            mapa.tablero[jugador.lastPosition[X]][jugador.lastPosition[Y]].clearCasilla();
            mapa.tablero[jugador.coordenadas[X]][jugador.coordenadas[Y]].pintarPersonaje();
            
            
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            jugador.moverseJugador('U');
            jugador.validarPosicion();
            moverEnemigo();
            reducirVida();
            System.out.println("Hp jugador:"+jugador.hp);
            mapa.tablero[jugador.lastPosition[X]][jugador.lastPosition[Y]].clearCasilla();
            mapa.tablero[jugador.coordenadas[X]][jugador.coordenadas[Y]].pintarPersonaje();
           
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            jugador.moverseJugador('D');
            jugador.validarPosicion();
            moverEnemigo();
            reducirVida();
            System.out.println("Hp jugador:"+jugador.hp);
            mapa.tablero[jugador.lastPosition[X]][jugador.lastPosition[Y]].clearCasilla();
            mapa.tablero[jugador.coordenadas[X]][jugador.coordenadas[Y]].pintarPersonaje();
            
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER) {
            for(Secundarios actual: enemigos){
                if(jugador.atacar(actual)){
                    mapa.tablero[actual.lastPosition[X]][actual.lastPosition[Y]].clearCasilla();
                    mapa.tablero[actual.currentPosition[X]][actual.currentPosition[Y]].pintarEnemigo();
                }
            }
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
