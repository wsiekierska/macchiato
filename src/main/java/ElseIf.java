import java.util.ArrayList;

public class ElseIf extends If {
    public void nazwa_instrukcji() {
        System.out.println("new If else, operator: " + this.operator);
        System.out.println("new main.If else, operator: " + this.operator);
    }

    private ArrayList<Instrukcja> przeciwne;

    public ElseIf(Wyrazenie a, String operator, Wyrazenie b, ArrayList<Instrukcja> instrukcje,
                  ArrayList<Instrukcja> przeciwne, Zmienne zmienne, Procedury procedury) {
        super(a, operator, b, instrukcje, zmienne, procedury);
        this.przeciwne = przeciwne;
    }


    public void wykonaj(Blok x){
        If spełnioneWarunki = new If(a, operator, b, instrukcje, zmienne, procedury);
        spełnioneWarunki.wykonaj(x);
        if (spełnioneWarunki.getStanWykonania() == 0) {
            zmienne.rzutuj(x.zmienne());
            for (Instrukcja instrukcja : przeciwne) {
                instrukcja.wykonaj(x);
            }
        }
    }
}
