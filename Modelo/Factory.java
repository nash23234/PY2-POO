package Modelo;

import java.util.Random;

public class Factory implements Constantes{

    public static Secundarios creaFactory(int op) {
        int[] pos;
        pos = new int[2];
        switch (op) {
            case 1:
<<<<<<< HEAD
                pos = RandomPos(1);
                return new Aliado(pos[X], pos[Y]);
            case 2:
                pos = RandomPos(2);
=======
                pos = randomPos();
                return new Aliado(pos[X], pos[Y]);
            case 2:
                pos = randomPos();
>>>>>>> 76f08738b7eee7628d4b03c647bad24339020066
                return new Enemigo(pos[X], pos[Y]);
            default:     
                return null;
        }
        
    }

<<<<<<< HEAD
    public static int[] RandomPos(int tipo) {
=======
    public static int[] randomPos() {
>>>>>>> 76f08738b7eee7628d4b03c647bad24339020066
        int[] coords;
        coords = new int[2];
        Random r = new Random();
        int x = r.nextInt(30);
        int y = r.nextInt(30);
  
        coords[0] = x;
        coords[1] = y;
        if(tipo==1){
            System.out.println("Aliado creado en fila: " + y + " columna: " + x);
        }
        if(tipo==2){
            System.out.println("Enemigo creado en fila: " + y + " columna: " + x);
        }
        return coords;
    }

}
