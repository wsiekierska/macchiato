import java.util.ArrayList;
import java.util.Objects;

public class Blok extends Instrukcja {
    public void nazwa_instrukcji(){
        System.out.println("new Blok");
    }
    public ArrayList<Para<Character, Integer>> zmienne;

    public ArrayList<Para<Character, Integer>> getZmienne() {
        return zmienne;
    }

    protected ArrayList<Instrukcja> instrukcje;
    protected Blok poprzedni;

    public Blok getPoprzedni() {
        return poprzedni;
    }
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

    public Blok() {
    }

    public Blok(ArrayList<Instrukcja> instrukcje) {
        this.licznik = 0;
        this.stanWykonania = 0;
        this.instrukcje = instrukcje;
        this.zmienne = new ArrayList<>();
        this.jestBlokiem = true;
    }

    protected void Aktualizacja(Blok x) {
        try{
        for (int i = 0; i < x.zmienne.size(); i++) {
            if (Objects.equals((zmienne.get(i)).pierwszy(), (x.zmienne.get(i)).pierwszy())) {
                if (!Objects.equals((zmienne.get(i)).drugi(), (x.zmienne.get(i)).drugi())) {
                    new Przypisanie_wartosci((zmienne.get(i)).pierwszy(), new Literal((zmienne.get(i)).drugi())).Wykonaj(x);
                }
            }
        }
        }catch (IstniejacaZmienna e) {
            System.out.println("Taka zmienna juz istnieje");
            e.printStackTrace();
        }

    }

    public void Wykonaj (Blok x) throws IstniejacaZmienna{
        this.poprzedni=x;
        zmienne.addAll(x.zmienne);
        for (Instrukcja instrukcja : instrukcje) {
            instrukcja.Wykonaj(this);
            Aktualizacja(x);
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

    public int WykonajJedno(Blok x) throws IstniejacaZmienna{
        this.poprzedni=x;
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



