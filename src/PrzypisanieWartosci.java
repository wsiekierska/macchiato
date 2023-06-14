public class PrzypisanieWartosci extends Instrukcja {
    public void nazwa_instrukcji(){
        System.out.println("new Przypisanie wartosci zmiennej: "+this.z);
    }
    private char z;
    private Wyrazenie wartosc;

    public PrzypisanieWartosci(char z, Wyrazenie wartosc) {
        this.z = z;
        this.wartosc = wartosc;
        this.jestBlokiem = false;
    }

    public void Wykonaj(Blok x) throws IstniejacaZmienna{
        try {
            for (int i = x.zmienne.size() - 1; i >= 0; i--) {
                if ((x.zmienne.get(i)).pierwszy().equals(this.z)) {
                    (x.zmienne.get(i)).drugi(wartosc.Wylicz(x));
                    break;
                }
            }
        }catch(DzieleniePrzezZero e){
            System.out.println("Dzielenie przez zero");
            e.printStackTrace();
        }catch(BrakZmiennej e){
            System.out.println("Brak zmiennej");
            e.printStackTrace();
        }
    }
    public int WykonajJedno(Blok x) throws IstniejacaZmienna{
        this.Wykonaj(x);
        this.stanWykonania = 1;
        return 1;
    }
}
