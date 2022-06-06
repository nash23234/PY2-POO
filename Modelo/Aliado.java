package Modelo;

public class Aliado extends Secundarios {

    public int hp;

    public Aliado(int x, int y) {
        currentPosition = new int[2];
        currentPosition[X] = x;
        currentPosition[Y] = y;

        lastPosition = new int[2];
        lastPosition[X] = x;
        lastPosition[Y] = y;
        hp = 100;
    }

    public int curarJugador(int x, int y) {
        if (x == currentPosition[X] && y == currentPosition[Y]) {
            return 10;
        } else {
            return 0;
        }
    }

    @Override
    public void update(int ejeX, int ejeY) {
        lastPosition[X] = currentPosition[X];
        lastPosition[Y] = currentPosition[Y];
    }

}
