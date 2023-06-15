import java.util.ArrayList;

public class BlokBuilder {
    protected ArrayList<Instrukcja> instrukcje;
    protected Zmienne zmienne;

    public BlokBuilder(){
        this.instrukcje=new ArrayList<>();
        this.zmienne=new Zmienne();
    }
    public void Deklaracja(Deklaracja d){
        instrukcje.add(d);
    }
    public void Blok(Blok d){
        instrukcje.add(d);
    }
    public void For(For d){
        instrukcje.add(d);
    }
    public void If(If d){
        instrukcje.add(d);
    }
    public void ElseIf(ElseIf d){
        instrukcje.add(d);
    }
    public void Print(Print d){
        instrukcje.add(d);
    }
    public void PrzypisanieWartosci(PrzypisanieWartosci d){
        instrukcje.add(d);
    }
    public Blok build(){
        return new Blok(instrukcje, zmienne);
    }

}
