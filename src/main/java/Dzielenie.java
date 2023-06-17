public class Dzielenie extends Wyrazenie {
    private Wyrazenie a, b;

    public Dzielenie(Wyrazenie a, Wyrazenie b) {
        this.a = a;
        this.b = b;
    }

    public static Dzielenie of(Wyrazenie a, Wyrazenie b){
        return new Dzielenie(a, b);
    }
    public int wylicz(Blok i) throws DzieleniePrzezZero, BrakZmiennej{
        if(b.wylicz(i)==0){
            throw new DzieleniePrzezZero("Dzielenie przez zero");
        }else{
            return a.wylicz(i)/b.wylicz(i);
        }
    }
}
