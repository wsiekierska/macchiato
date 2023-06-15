public class PrzypisanieWartosci extends Deklaracja {
    public void nazwa_instrukcji(){
        System.out.println("new Przypisanie wartosci zmiennej: "+this.nazwa);
    }
//    private char nazwa;
//    private Wyrazenie a;

    public PrzypisanieWartosci(char nazwa, Wyrazenie a) {
        super(nazwa, a);
    }

    public void Wykonaj(Blok x){
        try {
            int wartosc = a.Wylicz(x);
            x.zmienne().dodaj(nazwa, wartosc);
        }catch(DzieleniePrzezZero e){
            System.out.println("Dzielenie przez zero");
            e.printStackTrace();
        }catch(BrakZmiennej e){
            System.out.println("Brak zmiennej");
            e.printStackTrace();
        }
    }
}
