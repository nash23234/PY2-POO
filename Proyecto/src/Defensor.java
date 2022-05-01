public class Defensor extends agentes {
    
    private int ataque=1;
    public Defensor(){}
    public Defensor(boolean position,int rx,int ry,int boxes, int ataque){
        super(position, rx, ry, boxes);
        this.ataque=ataque;
    }

    @Override
    public boolean moverSe(){
        return true;
    }

    @Override
    public int atacar(int vida){
        if(vida<=10){
            return ataque;
        }
        return 0;
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
    public int [] reaccion(int x, int y, int xH, int yH){
        int XN=0;
        int YN=0;
        if(x==xH){
            setRx(xH);
            setRy(yH+1);
        }
        else if(y==yH){
            setRx(xH+1);
            setRy(yH);
        }
        
        int [] radar={XN,YN};
        return radar;
    }
}
