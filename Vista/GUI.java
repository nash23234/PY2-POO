package Vista;

import java.awt.*;
import javax.swing.*;
import Modelo.*;
import java.util.ArrayList;
import Controlador.*;

public class GUI implements Constantes {
    public JFrame ventana;
    public Mapa mapa;
    public Control control;

    public GUI() {
        ventana = new JFrame("Tablero");
        mapa = new Mapa();
        ventana.add(mapa.panelTablero, BorderLayout.CENTER);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1000, 700);
        ventana.setResizable(false);
        ventana.pack();
        ventana.setVisible(true);
        mapa.tablero[0][0].pintarPersonaje();
    }

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
            mapa.tablero[enemigo.lastPosition[X]][enemigo.lastPosition[Y]].clearCasilla();
            mapa.tablero[enemigo.currentPosition[X]][enemigo.currentPosition[Y]].pintarEnemigo();
        } else {
            enemigo.currentPosition[X] = Math.abs(enemigo.currentPosition[X] + 1);
            enemigo.currentPosition[Y] = Math.abs(enemigo.currentPosition[X] + 1);
            ponerAtacantes(enemigo, prueba);
        }
    }

    public void ponerAliados(Secundarios aliado) {
        mapa.tablero[aliado.currentPosition[X]][aliado.currentPosition[Y]].pintarAliado();
    }
}
