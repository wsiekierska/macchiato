import java.util.ArrayList;

public class BlokBuilder {
    protected ArrayList<Instrukcja> instrukcje;
    protected Zmienne zmienne;

    public BlokBuilder(){
        this.instrukcje=new ArrayList<>();
        this.zmienne=new Zmienne();
    }
    public void Deklaracja(char a, Wyrazenie b){
        instrukcje.add(new Deklaracja(a, b));
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
    public void Print(Wyrazenie a){
        instrukcje.add(new Print(a));
    }
    public void PrzypisanieWartosci(char a, Wyrazenie b){
        instrukcje.add(new PrzypisanieWartosci(a, b));
    }
    public Blok build(){
        return new Blok(instrukcje, zmienne);
    }

}
