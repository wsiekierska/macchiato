import java.util.ArrayList;

public class Zmienna extends Wyrazenie {
    private char nazwa;
    private int wartosc;
    public Zmienna(char nazwa) {
        this.nazwa = nazwa;
    }
    public Zmienna(char nazwa, int wartosc) {
        this.nazwa = nazwa;
        this.wartosc=wartosc;
    }

    public char nazwa() {
        return this.nazwa;
    }
    public int wartosc(){return this.wartosc;}
    public void zmienWartosc(int w){this.wartosc=w;}

    public static Zmienna zmiennaONazwie(char nazwa){
        return new Zmienna(nazwa);
    }
    public int Wylicz(Blok b) throws BrakZmiennej {
        return b.zmienne().zwrocWartosc(nazwa);
    }
}
