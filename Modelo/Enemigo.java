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
        hp = 10;
    }

    public void RecibirAtaque(int ataque) {
        hp = hp - ataque;
    }

    public int atacarJugador() {

        if (personajePos[X] == currentPosition[X] && personajePos[Y] == currentPosition[Y]) {

        }
        return 0;
    }

    
    public void acercarseJugador(int x, int y) {
        if (currentPosition[X] > x && currentPosition[Y] > y) {
            currentPosition[X] = currentPosition[X] - 1;
            currentPosition[Y] = currentPosition[Y] - 1;
            System.out.println("moviendose a la izquierda");
            
        }
        if (currentPosition[X] < x && currentPosition[Y] < y) {
            currentPosition[X] = currentPosition[X] + 1;
            currentPosition[Y] = currentPosition[Y] + 1;
            System.out.println("moviendose a la derecha");
           
        }
        if (currentPosition[X] > x && currentPosition[Y] < y) {
            currentPosition[X] = currentPosition[X] - 1;
            currentPosition[Y] = currentPosition[Y] + 1;
            System.out.println("moviendose a la izquierda");
            
        }
        if (currentPosition[X] < x && currentPosition[Y] > y) {
            currentPosition[X] = currentPosition[X] + 1;
            currentPosition[Y] = currentPosition[Y] - 1;
            System.out.println("moviendose a la derecha");
        }
        lastPosition[X] = currentPosition[X];
        lastPosition[Y] = currentPosition[Y];
    }

    public void move(int x, int y){
        lastPosition[X] = currentPosition[X];
        lastPosition[Y] = currentPosition[Y];
    
        if(x != currentPosition[X]){
            currentPosition[X] += (x-currentPosition[X])/Math.abs(x-currentPosition[X]);
        }
        if(y != currentPosition[Y]){
            currentPosition[Y] += (y-currentPosition[Y])/Math.abs(y-currentPosition[Y]);
        }
    }

    @Override
    public void update(int x, int y) {
        //crear una función que vaya verificando cuando atacar
        acercarseJugador(x, y);
        //move(x,y);
        System.out.println("El jugador esta: cordenada: X" + x + "cordenada: Y" + y);
    }

}
