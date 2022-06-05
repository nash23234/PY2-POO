package Modelo;

import java.util.Random;

public class Factory implements Constantes{

    public static Secundarios creaFactory(int op) {
        int[] pos;
        pos = new int[2];
        switch (op) {
            case 1:
                pos = randomPos();
                return new Aliado(pos[X], pos[Y]);
            case 2:
                pos = randomPos();
                return new Enemigo(pos[X], pos[Y]);
        }
        return null;
    }

    public static int[] randomPos() {
        int[] coords;
        coords = new int[2];
        Random r = new Random();
        int x = r.nextInt(30);
        int y = r.nextInt(30);
  
        coords[0] = x;
        coords[1] = y;
        System.out.println("Enemigo creado en fila: " + x + " columna: " + y);
        return coords;
    }

}
