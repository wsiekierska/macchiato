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
    public void wykonaj(Blok x) {
        try {
            int wartosc = a.wylicz(x);
            x.zmienne().zmienWartosc(nazwa, wartosc);
        } catch (DzieleniePrzezZero e) {
            e.printStackTrace();
        } catch (BrakZmiennej e) {
            e.printStackTrace();
        }
    }
    public int wykonajJedno(Blok x) {
        this.wykonaj(x);
        stanWykonania = 1;
        return 1;
    }
}
