public class Amenazas extends Objetos {
    public Amenazas (int Rx, int Ry, int boxes, int vida){
        super(Rx, Ry, boxes, vida);
    }
    
    @Override
    public void ReducirVida(int a){
        this.setVida(a-1);
    }
}
