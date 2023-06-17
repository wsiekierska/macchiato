import java.util.ArrayList;

public class ForBuilder {
    protected ArrayList<Instrukcja> instrukcje;
    protected Zmienne zmienne;
    protected Procedury procedury;
    private char k;
    private Wyrazenie w;

    public ForBuilder(char k, Wyrazenie w) {
        this.instrukcje = new ArrayList<>();
        this.zmienne = new Zmienne();
        this.procedury = new Procedury();
        this.w = w;
        this.k = k;
    }

    public ForBuilder deklaracja(char a, Wyrazenie b) {
        instrukcje.add(new Deklaracja(a, b));
        return this;
    }

    public ForBuilder blok(Blok d) {
        instrukcje.add(d);
        return this;
    }

    public ForBuilder deklaracjaProcedury(String nazwa, ArrayList<Character> argumenty, Blok b) {
        instrukcje.add(new DeklaracjaProcedury(nazwa, argumenty, b));
        return this;
    }

    public ForBuilder wywolanieProcedury(String nazwa, ArrayList<Wyrazenie> parametry) {
        instrukcje.add(new WywołanieProcedury(nazwa, parametry));
        return this;
    }

    public ForBuilder newFor(For d) {
        instrukcje.add(d);
        return this;
    }

    public ForBuilder newif(If d) {
        instrukcje.add(d);
        return this;
    }

    public ForBuilder newElseIf(ElseIf d) {
        instrukcje.add(d);
        return this;
    }

    public ForBuilder newPrint(Wyrazenie a) {
        instrukcje.add(new Print(a));
        return this;
    }

    public ForBuilder przypisanieWartosci(char a, Wyrazenie b) {
        instrukcje.add(new PrzypisanieWartosci(a, b));
        return this;
    }

    public For build() {
        return new For(k, w, instrukcje, zmienne, procedury);
    }
}
