import java.util.ArrayList;

public class Zmienna extends Wyrazenie {
    private char nazwa;
    public Zmienna(char nazwa) {
        this.nazwa = nazwa;
    }

    public char getNazwa() {
        return nazwa;
    }

    public int Wylicz(Blok b) throws DzieleniePrzezZero, BrakZmiennej {
        ArrayList<Para<Character, Integer>> zmienne;
        zmienne = b.zmienne;
        for (int i = zmienne.size() - 1; i >= 0; i--) {
            if ((zmienne.get(i)).pierwszy().equals(this.nazwa)) {
                return (zmienne.get(i)).drugi();
            }
        }
        throw new BrakZmiennej("Brak zmiennej");
    }
}
