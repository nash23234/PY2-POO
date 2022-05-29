package Modelo;
import java.lang.StackWalker.Option;
import java.util.Random;
import Vista.*;

import javax.swing.JOptionPane;
import javax.swing.text.Position;


/**
 *
 * @author Hengerlyn_Nash
 */

public class JugadorPrincipal implements Constantes{
    public int [] coordenadas;
    public int[] lastPosition;
    public int hp;
    public Tablero tablero;

    public JugadorPrincipal(){
        coordenadas=new int[2];
        coordenadas[X]=0;
        coordenadas[Y]=0;
        lastPosition = new int[2];
        lastPosition[X] = 0;
        lastPosition[Y] = 0;
        hp=100;
    }
   
    public int atacar(){
        return 0;
    }

    
    public void moverseJugador(char posicion){
        lastPosition[X] = coordenadas[X];
        lastPosition[Y] = coordenadas[Y];
        switch(posicion){
            case 'D':
                if(coordenadas[X]<TABLERO_SIZE && coordenadas[X]>=0){
                    coordenadas[X]++;
                    tablero.matriz[lastPosition[X]][lastPosition[Y]].setBackground(BG_COLOR);
                    tablero.matriz[coordenadas[X]][coordenadas[Y]].setBackground(JUGADORPRINCIPAL);
                }
            break;
            case 'U':
            if(coordenadas[X]<TABLERO_SIZE && coordenadas[X]>=0){
                coordenadas[X]--;
                tablero.matriz[lastPosition[X]][lastPosition[Y]].setBackground(BG_COLOR);
                tablero.matriz[coordenadas[X]][coordenadas[Y]].setBackground(JUGADORPRINCIPAL);
            }
            break;
            case 'L':
            if(coordenadas[Y]<TABLERO_SIZE && coordenadas[Y]>=0){
                coordenadas[Y]--;
                tablero.matriz[lastPosition[X]][lastPosition[Y]].setBackground(BG_COLOR);
                tablero.matriz[coordenadas[X]][coordenadas[Y]].setBackground(JUGADORPRINCIPAL);
            }
            break;
            case 'R':
            if(coordenadas[Y]<TABLERO_SIZE){
                coordenadas[Y]++;
                tablero.matriz[lastPosition[X]][lastPosition[Y]].setBackground(BG_COLOR);
                tablero.matriz[coordenadas[X]][coordenadas[Y]].setBackground(JUGADORPRINCIPAL);
            }
            break;
        }
        
    }
    
    //validar rango de coordenadas del jugador principal , si esta en el rango de coordenadas del tablero 
    public boolean validarRango(int x, int y){
        if(x>=0 && x<TABLERO_SIZE && y>=0 && y<TABLERO_SIZE){
            JOptionPane optionPane = new JOptionPane();
            optionPane.showMessageDialog(null, "El jugador principal se encuentra fuera del rango del tablero");
            return true;
        }
        return false;
    }
        


     
     
}
