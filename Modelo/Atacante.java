package Modelo;

import java.util.ArrayList;

public class Atacante implements Constantes{
    public int[] currentPosition;
    public int[] lastPosition;
    public int hp;
    public ArrayList<Atacante> atacantes ;
   

     

    public Atacante(int x, int y) {
        currentPosition = new int[2]; // [0] = x, [1] = y
        currentPosition[X] = x; // [0] = x
        currentPosition[Y] = y; // [1] = y

        lastPosition = new int[2]; // [0] = x, [1] = y
        lastPosition[X] = x;
        lastPosition[Y] = y;
        hp=10;
    }



    public int darVida(){
        return hp;
    }

    public void RecibirAtaque(int ataque){
        hp=hp-ataque;
    }


    //CREAR METODO QUE ME MUEVA TODOS LOS ATACANTES Y ME RETORNE LA POSICION DE LOS ATACANTES 
    public int[] moverseAtacante(int x, int y){
        lastPosition[X] = currentPosition[X];
        lastPosition[Y] = currentPosition[Y];
        currentPosition[X] = x;
        currentPosition[Y] = y;

        return currentPosition;
    }

    
    

    //GUARDAR 10 ATACANTES EN UN ARRAYLIST
    public void guardarAtacantes(int x, int y){
        for (int i = 0; i < 10; i++) {
            atacantes.add(new Atacante(x, y));
        }
    }   
   

    public void atacarJugador(JugadorPrincipal jugador){
        if(jugador.coordenadas[X] == currentPosition[X] && jugador.coordenadas[Y] == currentPosition[Y]){
            jugador.hp=jugador.hp-5;
        }
    }

}
