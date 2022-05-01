
public class Obstaculo extends Objetos{

    public Obstaculo(int Rx, int Ry, int boxes, int vida){
        super(Rx, Ry, boxes, vida);
    }

    @Override
    public boolean moverSe(){
        return false;
    }
    
    
    
}