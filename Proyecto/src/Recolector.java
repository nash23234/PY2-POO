public class Recolector extends agentes{
    public Recolector(boolean recurso, int Rx, int Ry, int boxes){
        super(recurso, Rx, Ry, boxes);
    }

    public Recolector(){}

    @Override
    public boolean moverSe(){
        return true;
    }

    @Override
    public int quitarVida(int vida){
        if(getPosicion())
            return 0;
        else{
            if(vida<=10){
                setPosicion(true);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int atacar(int vida){
        return 0;
    }
    
    //es su funcion de huir
    @Override
    public int [] reaccion(int x, int y, int xH, int yH){
        int XN=0;
        int YN=0;
        if(x==xH){
            setRx(xH);
            setRy(yH+-1);
        }
        else if(y==yH){
            setRx(xH-1);
            setRy(yH);
        }
        
        int [] radar={XN,YN};
        return radar;
    }

    
}