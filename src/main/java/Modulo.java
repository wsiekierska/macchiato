public class Modulo extends Wyrazenie {
    private Wyrazenie a, b;

    public Modulo(Wyrazenie a, Wyrazenie b){
        this.a = a;
        this.b = b;
    }
    public static Modulo of(Wyrazenie a, Wyrazenie b){
        return new Modulo(a, b);
    }

    public int wylicz(Blok x)throws DzieleniePrzezZero, BrakZmiennej {
        if(b.wylicz(x)==0){
            throw new DzieleniePrzezZero("main.Dzielenie przez zero");
        }else{
            return a.wylicz(x)%b.wylicz(x);
        }
    }
}
