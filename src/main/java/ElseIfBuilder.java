import java.util.ArrayList;

public class ElseIfBuilder {
    private ArrayList<Instrukcja> instrukcjePozytywne;
    protected ArrayList<Instrukcja> instrukcje;
    protected Zmienne zmienne;
    protected Procedury procedury;
    protected Wyrazenie a, b;
    protected String operator;

    public ElseIfBuilder(Wyrazenie a, String operator, Wyrazenie b) {
        this.instrukcjePozytywne = new ArrayList<>();
        this.instrukcje = new ArrayList<>();
        this.zmienne = new Zmienne();
        this.procedury = new Procedury();
        this.a = a;
        this.operator = operator;
        this.b = b;
    }

    public ElseIfBuilder deklaracja(char a, Wyrazenie b) {
        instrukcje.add(new Deklaracja(a, b));
        return this;
    }

    public ElseIfBuilder blok(Blok d) {
        instrukcje.add(d);
        return this;
    }

    public ElseIfBuilder deklaracjaProcedury(String nazwa, ArrayList<Character> argumenty, Blok b) {
        instrukcje.add(new DeklaracjaProcedury(nazwa, argumenty, b));
        return this;
    }

    public ElseIfBuilder wywolanieProcedury(String nazwa, ArrayList<Wyrazenie> parametry) {
        instrukcje.add(new WywołanieProcedury(nazwa, parametry));
        return this;
    }

    public ElseIfBuilder newFor(For d) {
        instrukcje.add(d);
        return this;
    }

    public ElseIfBuilder newif(If d) {
        instrukcje.add(d);
        return this;
    }

    public ElseIfBuilder newElseIf(ElseIf d) {
        instrukcje.add(d);
        return this;
    }

    public ElseIfBuilder newPrint(Wyrazenie a) {
        instrukcje.add(new Print(a));
        return this;
    }

    public ElseIfBuilder przypisanieWartosci(char a, Wyrazenie b) {
        instrukcje.add(new PrzypisanieWartosci(a, b));
        return this;
    }

    public ElseIfBuilder butElse() {
        instrukcjePozytywne.addAll(instrukcje);
        instrukcje.clear();
        return this;
    }

    public ElseIf build() {
        return new ElseIf(a, operator, b, instrukcjePozytywne, instrukcje, zmienne, procedury);
    }

}
