package Modelo;
import java.util.Random;

import javax.swing.text.Position;


/**
 *
 * @author Hengerlyn_Nash
 */

public class JugadorPrincipal implements Constantes{
    public int [] coordenadas;
    public int[] lastPosition;
    public int hp;

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

    public void moverse(char posicion){
        switch(posicion){
            case 'R':
            
                if(coordenadas[X]<TABLERO_SIZE && coordenadas[X]>=0){
                    coordenadas[X]++;
                }
            break;
            case 'L':
            if(coordenadas[X]<TABLERO_SIZE && coordenadas[X]>=0){
                coordenadas[X]--;
            }
            break;
            case 'U':
            if(coordenadas[Y]<TABLERO_SIZE && coordenadas[Y]>=0){
                coordenadas[Y]--;
            }
            break;
            case 'D':
            if(coordenadas[Y]<TABLERO_SIZE){
                coordenadas[Y]++;
            }
            break;
        }
        
    }

     
     
}
