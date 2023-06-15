import java.util.ArrayList;

public class BlokBuilder {
    protected ArrayList<Instrukcja> instrukcje;
    protected Zmienne zmienne;
    protected Procedury procedury;

    public BlokBuilder(){
        this.instrukcje=new ArrayList<>();
        this.zmienne=new Zmienne();
        this.procedury=new Procedury();
    }
    public void Deklaracja(char a, Wyrazenie b){
        instrukcje.add(new Deklaracja(a, b));
    }
    public void Blok(Blok d){
        instrukcje.add(d);
    }
    public void DeklaracjaProcedury(String nazwa, ArrayList<Character> argumenty, Blok b){
        instrukcje.add(new DeklaracjaProcedury(nazwa, argumenty, b));
    }
    public void WywolanieProcedury(String nazwa, ArrayList<Integer> parametry){
        instrukcje.add(new WywołanieProcedury(nazwa, parametry));
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
        return new Blok(instrukcje, zmienne, procedury);
    }

}
