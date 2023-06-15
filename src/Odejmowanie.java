public class Odejmowanie extends Wyrazenie {
    private Wyrazenie a, b;

    public Odejmowanie(Wyrazenie a, Wyrazenie b) {
        this.a = a;
        this.b = b;
    }
    public static Odejmowanie of(Wyrazenie a, Wyrazenie b){
        return new Odejmowanie(a, b);
    }

    public int Wylicz(Blok x) throws DzieleniePrzezZero, BrakZmiennej{
        return a.Wylicz(x) - b.Wylicz(x);
    }
}