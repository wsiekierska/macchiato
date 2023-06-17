import java.util.ArrayList;

public class Blok extends Instrukcja {
    public void nazwa_instrukcji(){
        System.out.println("nowy Blok");
    }
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
        this.jestProcedura=false;
    }

    public void wykonaj(Blok x){
        this.procedury.rzutuj(x.procedury());
        this.zmienne.rzutuj(x.zmienne());
        for (Instrukcja instrukcja : instrukcje) {
            instrukcja.wykonaj(this);
        }
    }
    public void wykonaj(Blok x, Zmienne z){
        this.procedury.rzutuj(x.procedury());
        this.zmienne.rzutuj(x.zmienne());
        for(Zmienna i: z.zmienne()){
            zmienne.dodaj(i.nazwa(), i.wartosc());
        }
        for (Instrukcja instrukcja : instrukcje) {
            instrukcja.wykonaj(this);
        }
    }
    public Blok znajdzPozycje(Blok x) {
        ArrayList<Instrukcja> pomocnicze=x.getInstrukcje();
        for (Instrukcja instrukcja : pomocnicze) {
            if (instrukcja.getStanWykonania() == 1) {
                continue;
            }
            if (!instrukcja.getJestBlokiem()) {
                if(instrukcja.getJestProcedura()){
                    WywołanieProcedury p= (WywołanieProcedury) instrukcja;
                    try {
                        DeklaracjaProcedury pom = x.procedury().znajdz(p.nazwa());
                        return x.znajdzPozycje(pom.blok());
                    }catch(BrakProcedury e){
                        e.printStackTrace();
                    }
                }
                return this;
            } else {
                return znajdzPozycje((Blok) instrukcja);
            }
        }
        return x;
    }

    public int wykonajJedno(Blok x){
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
        instrukcje.get(licznik).wykonajJedno(this);
        return 0;
    }
    public int wykonajJedno(Blok x, Zmienne z){
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
        instrukcje.get(licznik).wykonajJedno(this);
        return 0;
    }
}



