package Modelo;

public class Aliado extends Secundarios{
    
    public int hp;
    public Aliado(int x, int y){
        currentPosition = new int[2];
        currentPosition[X] = 0;
        currentPosition[Y] = 0;

        lastPosition = new int[2];
        lastPosition[X] = 0;
        lastPosition[Y] = 0;
        hp=100;
    }

    public int darVida(){
        return hp;
    }


    
}
