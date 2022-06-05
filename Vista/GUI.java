package Vista;

import java.awt.*;
import javax.swing.*;
import Modelo.*;
import Controlador.*;

public class GUI implements Constantes {

    public JFrame ventana;
    public Mapa mapa;
    public Control control;

    public GUI() {
        ventana = new JFrame("Tablero");
        mapa = new Mapa();
       

        ventana.add(mapa.panelTablero,BorderLayout.CENTER);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1000, 700);
        ventana.setResizable(false);
        ventana.pack();
        ventana.setVisible(true);

       
        mapa.tablero[0][0].pintarPersonaje();

        

    }
    public void ponerAtacantes(Secundarios enemigo) {
        if(mapa.tablero[enemigo.currentPosition[X]][enemigo.currentPosition[Y]].getBackground()==Color.WHITE){
            mapa.tablero[enemigo.lastPosition[X]][enemigo.lastPosition[Y]].clearCasilla();
            mapa.tablero[enemigo.currentPosition[X]][enemigo.currentPosition[Y]].pintarEnemigo();
        }
        else{
            enemigo.currentPosition[X]=enemigo.currentPosition[X]+1;
            enemigo.currentPosition[Y]=enemigo.currentPosition[Y]+1;
            ponerAtacantes(enemigo);
        }
        

    }

    public void ponerAliado(Secundarios aliado){
        mapa.tablero[aliado.lastPosition[X]][aliado.lastPosition[Y]].clearCasilla();
    }

    

}
