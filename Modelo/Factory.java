package Modelo;

import java.util.Random;

public class Factory {
    
    public static Secundarios creaFactory(int op){
        int[] pos;
        pos= new int[2];
        switch(op){
            case 1:
                pos=RandomPos();
                return new Aliado(pos[0],pos[1]);
            case 2:
                pos=RandomPos();
                return new Atacante(pos[0],pos[1]);
        }
        return null;
    }

    public static int[] RandomPos(){
        int[] coords;
        coords= new int[2];
        Random r = new Random();
        int x = r.nextInt(30);
        int y = r.nextInt(30);
        if(x!=0 && y!=0){
            coords[0]=x;
            coords[1]=y;
        }
        return coords;
    }

}
