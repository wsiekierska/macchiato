import java.util.ArrayList;

public class ForBuilder extends BlokBuilder{
    private char k;
    private Wyrazenie w;
    public ForBuilder(char k, Wyrazenie w){
        super();
        this.w=w;
        this.k=k;
    }
    public For build(){
        return new For(k,w, instrukcje, zmienne);
    }
}
