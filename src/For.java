import java.util.ArrayList;

public class For extends Blok {
    private char k;
    private Wyrazenie wyrazenie;
    private static int l;
    private static int iterator;
    public void nazwa_instrukcji(){
        System.out.println("For, iterator: "+this.k);
    }
    public For(char k, Wyrazenie wyrazenie, ArrayList<Instrukcja> instrukcje) {
        super(instrukcje);
        this.k = k;
        iterator = 0;
        this.zmienne = new ArrayList<>();
        this.wyrazenie = wyrazenie;
    }

    public void Wykonaj(Blok x) throws IstniejacaZmienna{
        try {
            this.poprzedni=x;
            zmienne.addAll(x.zmienne);
            new Deklaracja(k, new Literal(0));
            l = wyrazenie.Wylicz(x);
            for (int i = 0; i < l; i++) {
                new Przypisanie_wartosci(k, new Literal(i)).Wykonaj(this);
                for (Instrukcja instrukcja : instrukcje) {
                    instrukcja.Wykonaj(this);
                    Aktualizacja(x);
                }
            }
        }catch(DzieleniePrzezZero e){
            System.out.println("Dzielenie przez zero");
            e.printStackTrace();
        }catch(BrakZmiennej e){
            System.out.println("Brak zmiennej");
            e.printStackTrace();
        }
    }

    public int WykonajJedno(Blok x) throws IstniejacaZmienna{
        try {
            this.poprzedni=x;
            l = wyrazenie.Wylicz(x);
            if (instrukcje.get(licznik).getStanWykonania() == 1) {
                licznik++;
            }
            if (licznik == instrukcje.size()) {
                licznik = 0;
                iterator++;
                if (iterator == l) {
                    stanWykonania = 1;
                    return 1;
                }
            }
            instrukcje.get(licznik).WykonajJedno(this);
            return 0;
        }catch(DzieleniePrzezZero e){
            System.out.println("Dzielenie przez zero");
            e.printStackTrace();
        }catch(BrakZmiennej e){
            System.out.println("Brak zmiennej");
            e.printStackTrace();
        }
        return -1;
    }
}