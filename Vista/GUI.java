package Vista;

import java.awt.*;
import javax.swing.*;
import Modelo.*;
<<<<<<< HEAD
import java.util.ArrayList;
import Controlador.*;

public class GUI implements Constantes {
=======
import Controlador.*;

public class GUI implements Constantes {

>>>>>>> 76f08738b7eee7628d4b03c647bad24339020066
    public JFrame ventana;
    public Mapa mapa;
    public Control control;

    public GUI() {
        ventana = new JFrame("Tablero");
        mapa = new Mapa();
<<<<<<< HEAD
        ventana.add(mapa.panelTablero, BorderLayout.CENTER);
=======
       

        ventana.add(mapa.panelTablero,BorderLayout.CENTER);
>>>>>>> 76f08738b7eee7628d4b03c647bad24339020066
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1000, 700);
        ventana.setResizable(false);
        ventana.pack();
        ventana.setVisible(true);
<<<<<<< HEAD
=======

       
>>>>>>> 76f08738b7eee7628d4b03c647bad24339020066
        mapa.tablero[0][0].pintarPersonaje();
    }
<<<<<<< HEAD

    public void ponerAtacantes(Secundarios enemigo, ArrayList<Secundarios> prueba) {
        if (enemigo.currentPosition[X] < 0 || enemigo.currentPosition[X] >= TABLERO_SIZE
                || enemigo.currentPosition[Y] < 0 || enemigo.currentPosition[Y] >= TABLERO_SIZE) {
            enemigo.currentPosition[X] = enemigo.lastPosition[X];
            enemigo.currentPosition[Y] = enemigo.lastPosition[Y];
        }
        if (mapa.tablero[enemigo.currentPosition[X]][enemigo.currentPosition[Y]].getBackground() == Color.WHITE) {
            for (Secundarios i : prueba) {
                if (enemigo.currentPosition[X] == i.currentPosition[X]
                        && enemigo.currentPosition[Y] == i.currentPosition[Y]) {
                    enemigo.currentPosition[X] = Math.abs(enemigo.currentPosition[X] + 1);
                    enemigo.currentPosition[Y] = Math.abs(enemigo.currentPosition[X] + 1);
                    ponerAtacantes(enemigo, prueba);
                }
            }
=======
    public void ponerAtacantes(Secundarios enemigo) {
        if(mapa.tablero[enemigo.currentPosition[X]][enemigo.currentPosition[Y]].getBackground()==Color.WHITE){
>>>>>>> 76f08738b7eee7628d4b03c647bad24339020066
            mapa.tablero[enemigo.lastPosition[X]][enemigo.lastPosition[Y]].clearCasilla();
            mapa.tablero[enemigo.currentPosition[X]][enemigo.currentPosition[Y]].pintarEnemigo();
        } else {
            enemigo.currentPosition[X] = Math.abs(enemigo.currentPosition[X] + 1);
            enemigo.currentPosition[Y] = Math.abs(enemigo.currentPosition[X] + 1);
            ponerAtacantes(enemigo, prueba);
        }
<<<<<<< HEAD
    }

    public void ponerAliados(Secundarios aliado) {
        mapa.tablero[aliado.currentPosition[X]][aliado.currentPosition[Y]].pintarAliado();
=======
        else{
            enemigo.currentPosition[X]=enemigo.currentPosition[X]+1;
            enemigo.currentPosition[Y]=enemigo.currentPosition[Y]+1;
            ponerAtacantes(enemigo);
        }
        

    }

    public void ponerAliado(Secundarios aliado){
        mapa.tablero[aliado.lastPosition[X]][aliado.lastPosition[Y]].clearCasilla();
>>>>>>> 76f08738b7eee7628d4b03c647bad24339020066
    }
}
