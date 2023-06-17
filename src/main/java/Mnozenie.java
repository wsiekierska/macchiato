public class Mnozenie extends Wyrazenie {
    private Wyrazenie a, b;
    public Mnozenie(Wyrazenie a, Wyrazenie b){
        this.a = a;
        this.b = b;
    }
    public static Mnozenie of(Wyrazenie a, Wyrazenie b){
        return new Mnozenie(a, b);
    }

    public int Wylicz(Blok x) throws DzieleniePrzezZero, BrakZmiennej {
        return a.Wylicz(x)*b.Wylicz(x);
    }
}
