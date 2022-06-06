package Modelo;

public class Enemigo extends Secundarios {

    public int hp;

    public Enemigo(int x, int y) {
        currentPosition = new int[2]; // [0] = x, [1] = y
        currentPosition[X] = x; // [0] = x
        currentPosition[Y] = y; // [1] = y

        lastPosition = new int[2]; // [0] = x, [1] = y
        lastPosition[X] = x;
        lastPosition[Y] = y;
        
        personajePos= new int[2];
        personajePos[X]=0;
        personajePos[Y]=0;
        hp = 10;
    }

    public void RecibirAtaque(int ataque) {
        hp = hp - ataque;
    }

    @Override
    public int atacarJugador(int x, int y) {
        if (x == currentPosition[X] && y-1 == currentPosition[Y]) {
            return 5;
        }
        if (x == currentPosition[X] && y+1 == currentPosition[Y]) {
            return 5;
        }
        if (x+1 == currentPosition[X] && y == currentPosition[Y]) {
            return 5;
        }
        if (x-1 == currentPosition[X] && y == currentPosition[Y]) {
            return 5;
        }
        else{
            return 0;
        }
    }

    public void move(int x, int y){
        lastPosition[X] = currentPosition[X];
        lastPosition[Y] = currentPosition[Y];
    
        if(x == currentPosition[X] && y == currentPosition[Y]){
            return;
        }
        if(x != currentPosition[X]){
            currentPosition[X] += (x-currentPosition[X])/Math.abs(x-currentPosition[X]);
        }
        if(y != currentPosition[Y]){
            currentPosition[Y] += (y-currentPosition[Y])/Math.abs(y-currentPosition[Y]);
        }
    }

    @Override
    public void update(int x, int y) {
        personajePos[X]=x;
        personajePos[Y]=y;
        move(x,y);
        System.out.println("---------------------------------------");
        System.out.println("---------El enemigo esta: cordenada: X" + this.currentPosition[Y] + "cordenada: Y" + this.currentPosition[X]);

    }

}
