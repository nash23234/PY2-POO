package Modelo;

public class Aliado implements Constantes{
    public int[] currentPosition;
    public int[] lastPosition;
    public int hp;

    public Aliado(){
        currentPosition = new int[2];
        currentPosition[X] = 0;
        currentPosition[Y] = 0;

        lastPosition = new int[2];
        lastPosition[X] = 0;
        lastPosition[Y] = 0;
        hp=100;
    }

    public int darVida(){
        if(currentPosition[X] == lastPosition[X] && currentPosition[Y] == lastPosition[Y]){
            hp=hp+5;
        }
        return hp;
    }

    
}
