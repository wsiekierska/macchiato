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


    public int Wylicz(Blok b) throws DzieleniePrzezZero, BrakZmiennej {
        return this.wartosc;
//        ArrayList<Para<Character, Integer>> zmienne;
//        zmienne = b.zmienne;
//        for (int i = zmienne.size() - 1; i >= 0; i--) {
//            if ((zmienne.get(i)).pierwszy().equals(this.nazwa)) {
//                return (zmienne.get(i)).drugi();
//            }
//        }
//        throw new BrakZmiennej("Brak zmiennej");
    }
}
