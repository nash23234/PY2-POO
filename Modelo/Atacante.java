package Modelo;

public class Atacante implements Constantes{
    public int[] currentPosition;
    public int[] lastPosition;
    public int hp;
    JugadorPrincipal jugador;
    

    public Atacante(){
        currentPosition = new int[2];
        currentPosition[X] = 0;
        currentPosition[Y] = 0;

        lastPosition = new int[2];
        lastPosition[X] = 0;
        lastPosition[Y] = 0;
        hp=10;
    }

    public int darVida(){
        return hp;
    }

    public void RecibirAtaque(int ataque){
        hp=hp-ataque;
    }

    //mover a todos los atacantes cada vez que se mueve el jugador principal, es decir que se mueven todos los atacantes a direccion del jugador principal
    public void moverseAtacante(){
        lastPosition[X] = currentPosition[X];
        lastPosition[Y] = currentPosition[Y];
        currentPosition[X] = jugador.coordenadas[X];
        currentPosition[Y] = jugador.coordenadas[Y];
    }

   
    public void atacarJugador(JugadorPrincipal jugador){
        if(jugador.coordenadas[X] == currentPosition[X] && jugador.coordenadas[Y] == currentPosition[Y]){
            jugador.hp=jugador.hp-5;
        }
    }

}
