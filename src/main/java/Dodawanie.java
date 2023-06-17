public class Dodawanie extends Wyrazenie {
    private Wyrazenie a, b;
    public Dodawanie(Wyrazenie a, Wyrazenie b){
        this.a = a;
        this.b = b;
    }
    public static Dodawanie of(Wyrazenie a, Wyrazenie b){
        return new Dodawanie(a, b);
    }

    public int wylicz(Blok x) throws DzieleniePrzezZero, BrakZmiennej{
        return a.wylicz(x)+b.wylicz(x);
    }
}
