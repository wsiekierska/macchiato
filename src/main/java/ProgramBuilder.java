import java.util.ArrayList;

public class ProgramBuilder {
    private ArrayList<Blok> bloczki;
    protected ArrayList<Instrukcja> instrukcje;
    protected Zmienne zmienne;
    protected Procedury procedury;

    public ProgramBuilder() {
        this.bloczki = new ArrayList<>();
        this.instrukcje = new ArrayList<>();
        this.zmienne = new Zmienne();
        this.procedury = new Procedury();
    }

    public ProgramBuilder deklaracja(char a, Wyrazenie b) {
        instrukcje.add(new Deklaracja(a, b));
        return this;
    }

    public ProgramBuilder deklaracjaProcedury(String nazwa, ArrayList<Character> argumenty, Blok b) {
        instrukcje.add(new DeklaracjaProcedury(nazwa, argumenty, b));
        return this;
    }

    public ProgramBuilder wywolanieProcedury(String nazwa, ArrayList<Wyrazenie> parametry) {
        instrukcje.add(new WywołanieProcedury(nazwa, parametry));
        return this;
    }

    public ProgramBuilder newFor(For d) {
        instrukcje.add(d);
        return this;
    }

    public ProgramBuilder newif(If d) {
        instrukcje.add(d);
        return this;
    }

    public ProgramBuilder newElseIf(ElseIf d) {
        instrukcje.add(d);
        return this;
    }

    public ProgramBuilder newPrint(Wyrazenie a) {
        instrukcje.add(new Print(a));
        return this;
    }

    public ProgramBuilder przypisanieWartosci(char a, Wyrazenie b) {
        instrukcje.add(new PrzypisanieWartosci(a, b));
        return this;
    }

    public ProgramBuilder blok(Blok d) {
        instrukcje.add(d);
        bloczki.add(d);
        return this;
    }

    public Program build() {
        return new Program(instrukcje, bloczki, zmienne, procedury);
    }
}
