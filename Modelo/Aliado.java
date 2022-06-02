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

    public int darVida(boolean sennal){
        if(sennal)
            return hp;
        return 0;
    }

    public void verificando(boolean sennal){
        darVida(sennal);
    }

    @Override
    public void update(int ejeX, int ejeY) {
        if(ejeX==currentPosition[X]&& ejeY==currentPosition[Y]){
            verificando(true);
        }
        verificando(false);
        
    }


    
}
