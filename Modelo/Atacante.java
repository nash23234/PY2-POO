package Modelo;


public class Atacante extends Secundarios {
    
    public int hp;
    public Atacante(int x, int y) {
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
    

    
    public void atacarJugador(JugadorPrincipal jugador){
        if(jugador.coordenadas[X] == currentPosition[X] && jugador.coordenadas[Y] == currentPosition[Y]){
            jugador.hp=jugador.hp-5;
        }
    }

    @Override
    public void update(int x, int y) {
        //moverseAtacante(x, y);
        System.out.println("cordenada: X"+x+"cordenada: Y" +y);
    }



}
