import java.util.ArrayList;

public class Deklaracja extends Instrukcja {
    public void nazwa_instrukcji(){
        System.out.println("Deklaracja zmiennej "+this.nazwa);
    }
    protected char nazwa;
    protected Wyrazenie a;
    public Deklaracja(char nazwa, Wyrazenie a) {
        this.stanWykonania = 0;
        this.a = a;
        this.nazwa = nazwa;
        this.jestBlokiem = false;
    }
    public void Wykonaj(Blok x) {
        try {
            int wartosc = a.Wylicz(x);
            x.zmienne().dodaj(nazwa, wartosc);
        }catch(DzieleniePrzezZero e){
            System.out.println("Dzielenie przez zero");
            e.printStackTrace();
        }catch(BrakZmiennej e){
            System.out.println("Brak zmiennej");
            e.printStackTrace();
        }
    }
    public int WykonajJedno(Blok x) {
        this.Wykonaj(x);
        this.stanWykonania = 1;
        return 1;
    }
}
