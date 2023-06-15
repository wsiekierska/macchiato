import java.util.ArrayList;

public class BlokBuilder {
    protected ArrayList<Instrukcja> instrukcje;
    protected Zmienne zmienne;
    protected Procedury procedury;

    public BlokBuilder() {
        this.instrukcje = new ArrayList<>();
        this.zmienne = new Zmienne();
        this.procedury = new Procedury();
    }

    public BlokBuilder deklaracja(char a, Wyrazenie b) {
        instrukcje.add(new Deklaracja(a, b));
        return this;
    }

    public BlokBuilder blok(Blok d) {
        instrukcje.add(d);
        return this;
    }

    public BlokBuilder deklaracjaProcedury(String nazwa, ArrayList<Character> argumenty, Blok b) {
        instrukcje.add(new DeklaracjaProcedury(nazwa, argumenty, b));
        return this;
    }

    public BlokBuilder wywolanieProcedury(String nazwa, ArrayList<Wyrazenie> parametry) {
        instrukcje.add(new WywołanieProcedury(nazwa, parametry));
        return this;
    }

    public BlokBuilder newFor(For d) {
        instrukcje.add(d);
        return this;
    }

    public BlokBuilder newif(If d) {
        instrukcje.add(d);
        return this;
    }

    public BlokBuilder newElseIf(ElseIf d) {
        instrukcje.add(d);
        return this;
    }

    public BlokBuilder newPrint(Wyrazenie a) {
        instrukcje.add(new Print(a));
        return this;
    }

    public BlokBuilder przypisanieWartosci(char a, Wyrazenie b) {
        instrukcje.add(new PrzypisanieWartosci(a, b));
        return this;
    }

    public Blok build() {
        return new Blok(instrukcje, zmienne, procedury);
    }
}
