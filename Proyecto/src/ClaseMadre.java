public class ClaseMadre {

    private int rx;
    private int ry;

    public ClaseMadre(int rx, int ry){
        this.rx=rx;
        this.ry=ry;
    }

    

    public ClaseMadre(){}

    public void vision(ClaseMadre [] tableroLogico){
        

    }

    public boolean moverSe(){
        return true;
    }
    
    public void setRx(int rx){
        this.rx=rx;
    }

    public int getRx(){
        return rx;
    }

    public void setRy(int ry){
        this.ry=ry;
    }

    public int getRy(){
        return ry;
    }

    //
    public void ineteractuar(){

    }

    public boolean Hormiguero(){
        return true;
    }

    public int [] reaccion(int x, int y, int xH, int yH){
        int [] radar={x,y};
        return radar;
    }

    public int quitarVida(int vida){
        if(vida<=10){
            return 1;
        }
        return 0;
    }

    public int atacar(int vida){
        if(vida<=10){
            return 1;
        }
        return 0;
    }


}
