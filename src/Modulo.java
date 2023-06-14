public class Modulo extends Wyrazenie {
    private Wyrazenie a, b;

    public Modulo(Wyrazenie a, Wyrazenie b){
        this.a = a;
        this.b = b;
    }


    public int Wylicz(Blok x)throws DzieleniePrzezZero, BrakZmiennej {
        if(b.Wylicz(x)==0){
            throw new DzieleniePrzezZero("Dzielenie przez zero");
        }else{
            return a.Wylicz(x)%b.Wylicz(x);
        }
    }
}
