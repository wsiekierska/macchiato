import java.util.ArrayList;

public class If_else extends If {
    public void nazwa_instrukcji(){
        System.out.println("new If else, operator: "+this.operator);
    }
    private ArrayList<Instrukcja> przeciwne;

    public If_else(Wyrazenie a, String operator, Wyrazenie b, ArrayList<Instrukcja> d, ArrayList<Instrukcja> przeciwne) {
        super(a, operator, b, d);
        this.przeciwne = przeciwne;
    }


    public void Wykonaj(Blok x) throws IstniejacaZmienna{
        If spełnioneWarunki = new If(a, operator, b, instrukcje);
        spełnioneWarunki.Wykonaj(x);
        if (spełnioneWarunki.getWykonano() == false) {
            zmienne.addAll(x.zmienne);
            for (Instrukcja instrukcja : przeciwne) {
                instrukcja.Wykonaj(x);
                Aktualizacja(x);
            }
        }
    }
}
