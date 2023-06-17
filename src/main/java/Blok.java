import java.util.ArrayList;

public class Blok extends Instrukcja {
    public void nazwa_instrukcji(){
        System.out.println("nowy Blok");
    }
    //public ArrayList<Para<Character, Integer>> zmienne;
    protected Zmienne zmienne;

    public Zmienne zmienne() {
        return zmienne;
    }
    protected Procedury procedury;
    public Procedury procedury() {
        return this.procedury;
    }

    protected ArrayList<Instrukcja> instrukcje;
    protected int licznik;
    protected int stanWykonania;
    public ArrayList<Instrukcja> getInstrukcje() {
        return this.instrukcje;
    }

    public int getStanWykonania() {
        return stanWykonania;
    }

    public int getLicznik() {
        return licznik;
    }

    public Blok(ArrayList<Instrukcja> instrukcje, Zmienne zmienne, Procedury procedury) {
        this.procedury=procedury;
        this.licznik = 0;
        this.stanWykonania = 0;
        this.instrukcje = instrukcje;
        this.zmienne = zmienne;
        this.jestBlokiem = true;
    }

    public void Wykonaj (Blok x){
        this.procedury.rzutuj(x.procedury());
        this.zmienne.rzutuj(x.zmienne());
        for (Instrukcja instrukcja : instrukcje) {
            instrukcja.Wykonaj(this);
        }
    }
    public void Wykonaj (Blok x, Zmienne z){
        this.procedury.rzutuj(x.procedury());
        this.zmienne.rzutuj(x.zmienne());
        for(Zmienna i: z.zmienne()){
            zmienne.dodaj(i.nazwa(), i.wartosc());
        }
        for (Instrukcja instrukcja : instrukcje) {
            instrukcja.Wykonaj(this);
        }
    }
    public Blok Znajdz_pozycje(Blok x) {
        for (Instrukcja instrukcja : instrukcje) {
            if (instrukcja.getStanWykonania() == 1) {
                continue;
            }
            if (!instrukcja.getJestBlokiem()) {
                return this;
            } else {
                return Znajdz_pozycje((Blok) instrukcja);
            }
        }
        return x;
    }

    public int WykonajJedno(Blok x){
        if(licznik==0){
            this.procedury.rzutuj(x.procedury());
            this.zmienne.rzutuj(x.zmienne());
        }
        if (instrukcje.get(licznik).getStanWykonania() == 1) {
            licznik++;
        }
        if (licznik == instrukcje.size()) {
            stanWykonania = 1;
            return 1;
        }
        instrukcje.get(licznik).WykonajJedno(this);
        return 0;
    }
    public int WykonajJedno(Blok x, Zmienne z){
        if(licznik==0){
            this.procedury.rzutuj(x.procedury());
            this.zmienne.rzutuj(x.zmienne());
            for(Zmienna i: z.zmienne()){
                zmienne.dodaj(i.nazwa(), i.wartosc());
            }
        }
        if (instrukcje.get(licznik).getStanWykonania() == 1) {
            licznik++;
        }
        if (licznik == instrukcje.size()) {
            stanWykonania = 1;
            return 1;
        }
        instrukcje.get(licznik).WykonajJedno(this);
        return 0;
    }
}



