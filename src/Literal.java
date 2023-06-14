public class Literal extends Wyrazenie {
    private int wartosc;

    public Literal(int x){
        this.wartosc = x;
    }

    public int Wylicz(Blok x)throws DzieleniePrzezZero, BrakZmiennej {
        return wartosc;
    }
}
