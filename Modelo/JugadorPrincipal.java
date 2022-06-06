package Modelo;

import Vista.*;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import Controlador.Control;

/**
 *
 * @author Hengerlyn_Nash
 */

public class JugadorPrincipal implements Constantes, Observado {
    public ArrayList<Observador> observer;
    public int[] coordenadas;
    public int[] lastPosition;
    public int hp;
    public GUI tablero;
    public Control control;

    public JugadorPrincipal() {
        coordenadas = new int[2];
        coordenadas[X] = 0;
        coordenadas[Y] = 0;
        lastPosition = new int[2];
        lastPosition[X] = 0;
        lastPosition[Y] = 0;
        hp = 100;
        observer = new ArrayList<Observador>();
        notificar();
    }
<<<<<<< HEAD

    public boolean atacar(Secundarios enemigo) {
        if (coordenadas[X] == enemigo.currentPosition[X] && coordenadas[Y] + 1 == enemigo.currentPosition[Y]) {
            System.out.println("Mirá, tengo un enemigo al frente, hay que atacarlo...");
            return true;
        }
        if (coordenadas[X] == enemigo.currentPosition[X] && coordenadas[Y] - 1 == enemigo.currentPosition[Y]) {
            System.out.println("Mirá, tengo un enemigo al frente, hay que atacarlo...");
            return true;
        } else {
            return false;
        }
    }

    public void RecibirAtaque(int damage) {
        if (hp > 0) {
            hp = hp - damage;
        }
        if (hp <= 0) {
            JOptionPane.showMessageDialog(null, "El jugador ha muerto, fin del juego");
            System.exit(0);
        }
    }

    public boolean recibirVida(int health) {
        if (hp < 100) {
            hp = hp + health;
            return true;
        } else {
            return false;
        }

=======
    public boolean atacar(Secundarios enemigo) {
        if(coordenadas[X]+1==enemigo.currentPosition[X] && coordenadas[Y]==enemigo.currentPosition[Y]){
            Random r = new Random();
            int x = r.nextInt(30);
            int y = r.nextInt(30);
            enemigo.currentPosition[X]=x;
            enemigo.currentPosition[Y]=y;
            return true;
        }
        return false;
    }

    public void RecibirAtaque(int damage){
        if(hp > 0 ){
            hp=hp-damage;
        }
        if(hp <= 0){
            JOptionPane.showMessageDialog(null, "El jugador ha muerto, fin del juego");
            System.exit(0);
        }
        
>>>>>>> 76f08738b7eee7628d4b03c647bad24339020066
    }

    public void moverseJugador(char posicion) {
        lastPosition[X] = coordenadas[X];
        lastPosition[Y] = coordenadas[Y];
        switch (posicion) {
            case 'D':
                if (coordenadas[X] < TABLERO_SIZE && coordenadas[X] >= 0) {// si no esta en el limite de la matriz
                    coordenadas[X]++;
                    notificar();

                }
                break;
            case 'U':
                if (coordenadas[X] < TABLERO_SIZE && coordenadas[X] >= 0) {
                    coordenadas[X]--;
                    notificar();
                }
                break;
            case 'L':
                if (coordenadas[Y] < TABLERO_SIZE && coordenadas[Y] >= 0) {
                    coordenadas[Y]--;
                    notificar();

                }
                break;
            case 'R':
                if (coordenadas[Y] < TABLERO_SIZE && coordenadas[Y] >= 0) {
                    coordenadas[Y]++;
                    notificar();
                }
                break;
        }

    }

    public void validarPosicion() {
        if (coordenadas[X] < 0 || coordenadas[X] >= TABLERO_SIZE || coordenadas[Y] < 0
                || coordenadas[Y] >= TABLERO_SIZE) {
            JOptionPane.showMessageDialog(null, "Se esta saliendo del tablero");
            coordenadas[X] = lastPosition[X];
            coordenadas[Y] = lastPosition[Y];
        }
    }

    public void agregarObservadores(Observador observador) {
        observer.add(observador);
    }

    @Override
    public void notificar() {
        for (Observador obs : observer) {
            obs.update(coordenadas[X], coordenadas[Y]);
        }

    }

}
