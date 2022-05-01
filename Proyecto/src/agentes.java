
public class agentes extends ClaseMadre {
    private boolean recurso;
    private int casillas;

 

    public agentes(boolean recursos, int Rx, int Ry, int boxes){
        super(Rx,Ry);
        this.recurso=recursos;
        this.casillas=boxes;
    }

    public agentes(){}

    
    public void setPosicion(boolean position){
        this.recurso=position;
    }
    
    public boolean getPosicion(){
        return recurso;
    }

    public void setCasillas(int boxes){
        this.casillas=boxes;
    }

    public int getCasillas(){
        return casillas;
    }
    @Override
    public boolean Hormiguero(){
        return true;
    }

    @Override
    public boolean moverSe(){
        return true;
    }

    @Override
    public int [] reaccion(int x, int y, int xH, int yH){
        int [] radar={x,y};
        return radar;
    }

    @Override
    public int quitarVida(int vida){
        if(vida<=10){
            return 1;
        }
        return 0;
    }

    @Override
    public int atacar(int vida){
        if(vida<=10){
            return 1;
        }
        return 0;
    }

}