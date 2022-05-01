public class Objetos extends ClaseMadre{
    private int casillas;
    private int vida;


    //agregar la referencia del recurso

    public Objetos( int Rx, int Ry, int boxes, int vida){
        super(Rx, Ry);
        this.casillas=boxes;
        this.vida=vida;
    }

   
    public void ReducirVida(int a){
        vida-=a;  
    }

    @Override
    public boolean moverSe(){
        return false;
    }

   
    public void setCasillas(int boxes){
        this.casillas=boxes;
    }

    public int getCasillas(){
        return casillas;
    }

    public void setVida(int vida){
        this.vida=vida;
    }

    public int getVida(){
        return vida;
    }
}
