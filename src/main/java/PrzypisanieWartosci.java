public class PrzypisanieWartosci extends Deklaracja {
    public void nazwa_instrukcji(){
        System.out.println("Przypisanie wartosci zmiennej: "+this.nazwa);
    }
//    private char nazwa;
//    private main.Wyrazenie a;

    public PrzypisanieWartosci(char nazwa, Wyrazenie a) {
        super(nazwa, a);
    }

    @Override
    public void Wykonaj(Blok x) {
        try {
            int wartosc = a.Wylicz(x);
            x.zmienne().zmienWartosc(nazwa, wartosc);
        } catch (DzieleniePrzezZero e) {
            e.printStackTrace();
        } catch (BrakZmiennej e) {
            e.printStackTrace();
        }
    }
    public int WykonajJedno(Blok x) {
        this.Wykonaj(x);
        stanWykonania = 1;
        return 1;
    }
}
