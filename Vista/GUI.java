package Vista;

import java.awt.*;
import javax.swing.*;
import Modelo.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import Controlador.*;

public class GUI implements Constantes {
    public JPanel estadistica;
    public JPanel play;
    public JFrame ventana;
    public JLabel mensaje;
    public JButton iniciar;
    public Mapa mapa;
    public Control control;

    public GUI() {
        ventana = new JFrame("Tablero");
        mapa = new Mapa();
        estadistica = new JPanel();

        ventana.add(mapa.panelTablero,BorderLayout.CENTER);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    
        //estadistica.setLayout(new GridLayout(, 2));
        mensaje = new JLabel("     Estados    ");//se espera aqui hacer un tipo de toString
        estadistica.add(mensaje);

        ventana.add(estadistica, BorderLayout.EAST);
        ventana.setSize(1000, 700);
        ventana.setResizable(false);
        ventana.pack();
        ventana.setVisible(true);
        //ventana.add(control.crearEnemigos(10));
       
        mapa.tablero[0][0].pintarPersonaje();

        //agregar crear enenigos a tablero 
        
        

    }

    

    public void moverJugador(JugadorPrincipal hereo) {
        mapa.tablero[hereo.lastPosition[X]][hereo.lastPosition[Y]].clearPersonaje();
        mapa.tablero[hereo.coordenadas[X]][hereo.coordenadas[Y]].pintarPersonaje();
    }

    // poner atacantes en el tablero y guardarlos en un array , que ningun atacante
    // este en el indice 0,0
    public void ponerAtacantes(Secundarios enemigo) {
        mapa.tablero[enemigo.lastPosition[X]][enemigo.lastPosition[Y]].clearEnemigo();
        mapa.tablero[enemigo.currentPosition[X]][enemigo.currentPosition[Y]].pintarEnemigo();
    }

}
