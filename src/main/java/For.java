import java.util.ArrayList;

public class For extends Blok {
    private char k;
    private Wyrazenie wyrazenie;
    private static int l;
    private static int iterator;
    public void nazwa_instrukcji(){
        System.out.println("For, iterator: "+this.k);
    }
    public For(char k, Wyrazenie wyrazenie, ArrayList<Instrukcja> instrukcje, Zmienne zmienne, Procedury procedury) {
        super(instrukcje, zmienne, procedury);
        this.k = k;
        iterator = 0;
        this.wyrazenie = wyrazenie;
    }

    public void wykonaj(Blok x){
        try {
            zmienne.rzutuj(x.zmienne());
            procedury.rzutuj(x.procedury());
            new Deklaracja(k, new Literal(0)).wykonaj(this);
            l = wyrazenie.wylicz(x);
            for (int i = 0; i < l; i++) {
                new PrzypisanieWartosci(k, new Literal(i)).wykonaj(this);
                for (Instrukcja instrukcja : instrukcje) {
                    instrukcja.wykonaj(this);
                }
            }
        }catch(DzieleniePrzezZero e){
            System.out.println("main.Dzielenie przez zero");
            e.printStackTrace();
        }catch(BrakZmiennej e){
            System.out.println("Brak zmiennej");
            e.printStackTrace();
        }
    }

    public int wykonajJedno(Blok x){
        try {
            if(licznik==0){
                zmienne.rzutuj(x.zmienne());
                procedury.rzutuj(x.procedury());
                new Deklaracja(k, new Literal(0)).wykonaj(this);
                l = wyrazenie.wylicz(x);
            }
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
            instrukcje.get(licznik).wykonajJedno(this);
            return 0;
        }catch(DzieleniePrzezZero e){
            System.out.println("main.Dzielenie przez zero");
            e.printStackTrace();
        }catch(BrakZmiennej e){
            System.out.println("Brak zmiennej");
            e.printStackTrace();
        }
        return -1;
    }
}
