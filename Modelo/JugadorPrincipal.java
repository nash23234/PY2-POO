package Modelo;

import Vista.*;

import javax.swing.JOptionPane;



import Controlador.Control;


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

    
    public void moverseJugador(char posicion){
        lastPosition[X] = coordenadas[X];//guarda la posicion anterior
        lastPosition[Y] = coordenadas[Y]; //guarda la posicion anterior
        switch(posicion){
            case 'D':
                if(coordenadas[X]<TABLERO_SIZE && coordenadas[X]>=0){//si no esta en el limite de la matriz
                    coordenadas[X]++;
                    
                }
            break;
            case 'U':
                if(coordenadas[X]<TABLERO_SIZE && coordenadas[X]>=0){
                    coordenadas[X]--;               
                }
            break;
            case 'L':
                if(coordenadas[Y]<TABLERO_SIZE && coordenadas[Y]>=0){
                    coordenadas[Y]--;
                   
                }
            break;
            case 'R':
                if(coordenadas[Y]<TABLERO_SIZE && coordenadas[Y]>=0){
                    coordenadas[Y]++;
                                 
                }
            break;
        }
        
    }

   
    public void validarPosicion(){
        if(coordenadas[X]<0 || coordenadas[X]>=TABLERO_SIZE || coordenadas[Y]<0 || coordenadas[Y]>=TABLERO_SIZE){
            JOptionPane.showMessageDialog(null, "Se esta saliendo del tablero");
            coordenadas[X]=lastPosition[X];
            coordenadas[Y]=lastPosition[Y];
        }
    }

    public int[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(int[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public int[] getLastPosition() {
        return lastPosition;
    }

    public void setLastPosition(int[] lastPosition) {
        this.lastPosition = lastPosition;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

	

    

}
    