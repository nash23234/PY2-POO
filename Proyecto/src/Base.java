public class Base extends agentes{
    public Base(boolean recurso, int Rx, int Ry, int boxes){
        super(recurso, Rx, Ry, boxes);
    }

    @Override
    public boolean moverSe(){
        return false;
    }
}
