package Controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import Modelo.*;

import Vista.*;

public class Control extends GUI implements KeyListener{

    JugadorPrincipal jugador;
    public ArrayList<Secundarios> enemigos = new ArrayList<Secundarios>();
    public ArrayList<Secundarios> aliados = new ArrayList<Secundarios>();
    Secundarios creador;

    public Control() {

        ventana.addKeyListener(this);
        jugador = new JugadorPrincipal();
        crearEnemigos();
        System.out.println("************************");
        crearAliados();
    }

    // ----------------------------ENEMIGOS--------------------------------------
    public void suscribirEnemigos() {
        for (Secundarios i : enemigos) {
            jugador.agregarObservadores(i);
        }
    }

    public void crearEnemigos() {
        for (int i = 0; i < 10; i++) {
            creador = Factory.creaFactory(2);
            enemigos.add(creador);
            ponerAtacantes(creador, aliados);
        }
        suscribirEnemigos();
    }

    public void moverEnemigo() {
        for (Secundarios i : enemigos) {
            ponerAtacantes(i, aliados);
        }
    }

    public void reducirVida() {
        int damage;
        for (Secundarios i : enemigos) {
            damage = i.atacarJugador(jugador.coordenadas[X], jugador.coordenadas[Y]);
            if (damage != 0) {
                jugador.RecibirAtaque(damage);
            }
        }
    }
    // ----------------------------ALIADOS--------------------------------------

    public void suscribirAliados() {
        for (Secundarios i : aliados) {
            jugador.agregarObservadores(i);
        }
    }

    public void crearAliados() { //
        for (int i = 0; i < 6; i++) {
            creador = Factory.creaFactory(1);
            aliados.add(creador);
            ponerAliados(creador);
        }
        suscribirAliados();

    }

    // El jugador salva a un aliado y este recibe vida
    public void subirVida() {
        int vida;
        for (Secundarios i : aliados) {
            vida = i.curarJugador(jugador.coordenadas[X], jugador.coordenadas[Y]);
            if (vida != 0) {
                if (jugador.recibirVida(vida)) {
                    mapa.tablero[i.currentPosition[X]][i.currentPosition[Y]].pintarAliado();
                    JOptionPane.showMessageDialog(null, "tenkiu\n nueva vida: " + jugador.hp);
                    mapa.tablero[i.currentPosition[X]][i.currentPosition[Y]].pintarPersonaje();
                    aliados.remove(i);
                    break;

                }
            }
        }
    }
    // ------------------------------------------------------------------

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            jugador.moverseJugador('R');
            jugador.validarPosicion();
            for (int i = 0; i < TABLERO_SIZE; i++) {
                for (int j = 0; j < TABLERO_SIZE; j++) {
                    mapa.tablero[i][j].clearCasilla();
                }
            }
            moverEnemigo();
            reducirVida();
            for (Secundarios i : aliados) {
                mapa.tablero[i.currentPosition[X]][i.currentPosition[Y]].pintarAliado();
            }
            subirVida();
            System.out.println("Hp jugador:" + jugador.hp);
            mapa.tablero[jugador.lastPosition[X]][jugador.lastPosition[Y]].clearCasilla();
            mapa.tablero[jugador.coordenadas[X]][jugador.coordenadas[Y]].pintarPersonaje();
            System.out.println("*********************");

        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            jugador.moverseJugador('L');

            jugador.validarPosicion();
            for (int i = 0; i < TABLERO_SIZE; i++) {
                for (int j = 0; j < TABLERO_SIZE; j++) {
                    mapa.tablero[i][j].clearCasilla();
                }
            }
            moverEnemigo();
            reducirVida();
            for (Secundarios i : aliados) {
                mapa.tablero[i.currentPosition[X]][i.currentPosition[Y]].pintarAliado();
            }
            subirVida();
            System.out.println("Hp jugador:" + jugador.hp);
            mapa.tablero[jugador.lastPosition[X]][jugador.lastPosition[Y]].clearCasilla();
            mapa.tablero[jugador.coordenadas[X]][jugador.coordenadas[Y]].pintarPersonaje();

            System.out.println("*********************");
        }
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            jugador.moverseJugador('U');
            jugador.validarPosicion();
            for (int i = 0; i < TABLERO_SIZE; i++) {
                for (int j = 0; j < TABLERO_SIZE; j++) {
                    mapa.tablero[i][j].clearCasilla();
                }
            }
            moverEnemigo();
            reducirVida();
            for (Secundarios i : aliados) {
                mapa.tablero[i.currentPosition[X]][i.currentPosition[Y]].pintarAliado();
            }
            subirVida();
            System.out.println("Hp jugador:" + jugador.hp);
            mapa.tablero[jugador.lastPosition[X]][jugador.lastPosition[Y]].clearCasilla();
            mapa.tablero[jugador.coordenadas[X]][jugador.coordenadas[Y]].pintarPersonaje();
            System.out.println("*********************");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            jugador.moverseJugador('D');
            jugador.validarPosicion();
            for (int i = 0; i < TABLERO_SIZE; i++) {
                for (int j = 0; j < TABLERO_SIZE; j++) {
                    mapa.tablero[i][j].clearCasilla();
                }
            }
            moverEnemigo();
            reducirVida();
            for (Secundarios i : aliados) {
                mapa.tablero[i.currentPosition[X]][i.currentPosition[Y]].pintarAliado();
            }
            subirVida();
            System.out.println("Hp jugador:" + jugador.hp);
            mapa.tablero[jugador.lastPosition[X]][jugador.lastPosition[Y]].clearCasilla();
            mapa.tablero[jugador.coordenadas[X]][jugador.coordenadas[Y]].pintarPersonaje();
            System.out.println("*********************");
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER) {
            for (Secundarios actual : enemigos) {
                if (jugador.atacar(actual)) {
                    Random r = new Random();
                    int new_x = r.nextInt(30);
                    int new_y = r.nextInt(30);
                    actual.lastPosition[X] = actual.currentPosition[X];
                    actual.lastPosition[Y] = actual.currentPosition[Y];

                    actual.currentPosition[X] = new_x;
                    actual.currentPosition[Y] = new_y;

                    mapa.tablero[actual.lastPosition[X]][actual.lastPosition[Y]].clearCasilla();
                    mapa.tablero[actual.currentPosition[X]][actual.currentPosition[Y]].pintarEnemigo();
                    System.out.println("Ahora el enemigo está en: x" + actual.currentPosition[X] + ", y"
                            + actual.currentPosition[Y]);
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
