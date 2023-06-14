import java.util.ArrayList;

public class Deklaracja extends Instrukcja {
    public void nazwa_instrukcji(){
        System.out.println("Deklaracja zmiennej "+this.nazwa);
    }
    private char nazwa;
    private Wyrazenie a;

    public Deklaracja(char nazwa, Wyrazenie a) {
        this.stanWykonania = 0;
        this.a = a;
        this.nazwa = nazwa;
        this.jestBlokiem = false;
    }

    public void Wykonaj(Blok x) {
        try {
            boolean finished = false;
            for (int i = x.getPoprzedni().zmienne.size(); i < x.zmienne.size(); i++) {
                ArrayList<Para<Character, Integer>> zmienne = x.zmienne;
                if ((x.zmienne.get(i)).pierwszy()==nazwa) {
                    finished=true;
                    throw new IstniejacaZmienna("Zmienna juz istnieje");
                }
                }
            if (!finished) {
                (x.zmienne).add(new Para<>(nazwa, a.Wylicz(x)));
            }
        }catch(DzieleniePrzezZero e){
            System.out.println("Dzielenie przez zero");
            e.printStackTrace();
        }catch(BrakZmiennej e){
            System.out.println("Brak zmiennej");
            e.printStackTrace();
        } catch (IstniejacaZmienna e) {
            throw new RuntimeException(e);
        }
    }

    public int WykonajJedno(Blok x) {
        this.Wykonaj(x);
        this.stanWykonania = 1;
        return 1;
    }
}
