package Modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Vista.Tablero;

public class Atacante implements Constantes{
    public int[] currentPosition;
    public int[] lastPosition;
    public int hp;
    public int[] coordenadas;


    public Atacante(int x, int y) {
        currentPosition = new int[2];
        currentPosition[X] = x;
        currentPosition[Y] = y;

        lastPosition = new int[2];
        lastPosition[X] = x;
        lastPosition[Y] = y;

        coordenadas = new int[2];
        coordenadas[X] = x;
        coordenadas[Y] = y;
        
        hp=10;
    }



    public int darVida(){
        return hp;
    }

    public void RecibirAtaque(int ataque){
        hp=hp-ataque;
    }   

    public void atacarJugador(JugadorPrincipal jugador){
        if(jugador.coordenadas[X] == currentPosition[X] && jugador.coordenadas[Y] == currentPosition[Y]){
            jugador.hp=jugador.hp-5;
        }
    }

    //crear metodo que recibar las coosssssxadrdenadas del jugador principal y que se mueva los enemigos a exxdd
    public void acercarseJugador(int x, int y){
        if(currentPosition[X]>x && currentPosition[Y]>y){
            currentPosition[X]=currentPosition[X]-1;
            currentPosition[Y]=currentPosition[Y]-1;
            System.out.println("moviendose a la izquierda");
            //limpiar la posicion donde estaba el enemigo antes de moverse
            
            return;
        }
        if(currentPosition[X]<x && currentPosition[Y]<y){
            currentPosition[X]=currentPosition[X]+1;
            currentPosition[Y]=currentPosition[Y]+1;
            System.out.println("moviendose a la derecha");
            return;
        }
        if(currentPosition[X]>x && currentPosition[Y]<y){
            currentPosition[X]=currentPosition[X]-1;
            currentPosition[Y]=currentPosition[Y]+1;
            System.out.println("moviendose a la izquierda");
            return;
        }
        if(currentPosition[X]<x && currentPosition[Y]>y){
            currentPosition[X]=currentPosition[X]+1;
            currentPosition[Y]=currentPosition[Y]-1;
              // System.out.println("moviendose a la derecha");
            System.out.println("moviendose a la derecha");
         
            return;
        }             
    }

    public void validarPosicion(){
        if(coordenadas[X]<0 || coordenadas[X]>=TABLERO_SIZE || coordenadas[Y]<0 || coordenadas[Y]>=TABLERO_SIZE){
            JOptionPane.showMessageDialog(null, "Se esta saliendo del tablero");
            coordenadas[X]=lastPosition[X];
            coordenadas[Y]=lastPosition[Y];
        }
    }

    //cuando se mueve el enemigo, se debe limpiar la posicion donde estaba antes de moverse para que no se vea el enemigo
     


    public int[] getCurrentPosition() {
        return currentPosition;
    }



    public void setCurrentPosition(int[] currentPosition) {
        this.currentPosition = currentPosition;
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
