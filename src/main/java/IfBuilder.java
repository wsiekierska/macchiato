import java.util.ArrayList;

public class IfBuilder {
    protected ArrayList<Instrukcja> instrukcje;
    protected Zmienne zmienne;
    protected Procedury procedury;
    protected Wyrazenie a, b;
    protected String operator;

    public IfBuilder(Wyrazenie a, String operator, Wyrazenie b) {
        this.instrukcje = new ArrayList<>();
        this.zmienne = new Zmienne();
        this.procedury = new Procedury();
        this.a = a;
        this.operator = operator;
        this.b = b;
    }

    public IfBuilder deklaracja(char a, Wyrazenie b) {
        instrukcje.add(new Deklaracja(a, b));
        return this;
    }

    public IfBuilder blok(Blok d) {
        instrukcje.add(d);
        return this;
    }

    public IfBuilder deklaracjaProcedury(String nazwa, ArrayList<Character> argumenty, Blok b) {
        instrukcje.add(new DeklaracjaProcedury(nazwa, argumenty, b));
        return this;
    }

    public IfBuilder wywolanieProcedury(String nazwa, ArrayList<Wyrazenie> parametry) {
        instrukcje.add(new WywołanieProcedury(nazwa, parametry));
        return this;
    }

    public IfBuilder newFor(For d) {
        instrukcje.add(d);
        return this;
    }

    public IfBuilder newif(If d) {
        instrukcje.add(d);
        return this;
    }

    public IfBuilder newElseIf(ElseIf d) {
        instrukcje.add(d);
        return this;
    }

    public IfBuilder newPrint(Wyrazenie a) {
        instrukcje.add(new Print(a));
        return this;
    }

    public IfBuilder przypisanieWartosci(char a, Wyrazenie b) {
        instrukcje.add(new PrzypisanieWartosci(a, b));
        return this;
    }

    public If build() {
        return new If(a, operator, b, instrukcje, zmienne, procedury);
    }
}
