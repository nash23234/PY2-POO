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
        hp=10;
    }

    public void RecibirAtaque(int ataque){
        hp=hp-ataque;
    }


    //CREAR METODO QUE ME MUEVA TODOS LOS ATACANTES Y ME RETORNE LA POSICION DE LOS ATACANTES 
    

    //Terminarlo 
    public int atacarJugador(){
        
        if(personajePos[X]== currentPosition[X] && personajePos[Y] == currentPosition[Y]){
            
        }
        return 0;
    }

    @Override
    public void update(int x, int y) {
        //moverseAtacante(x, y);
        personajePos[0]=x;
        personajePos[1]=y;
        System.out.println("cordenada: X"+x+"cordenada: Y" +y);
    }



}
