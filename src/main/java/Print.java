public class Print extends Instrukcja {
    public void nazwa_instrukcji(){
        System.out.println("new main.Print");
    }
    private Wyrazenie w;
    public Print(Wyrazenie w) {
        this.stanWykonania=0;
        this.w = w;
        this.jestBlokiem = false;
    }
    public void Wykonaj(Blok x) {
        try{
            int wartosc = w.Wylicz(x);
            System.out.println(wartosc);
        }catch(DzieleniePrzezZero e){
            System.out.println("Dzielenie przez zero");
            e.printStackTrace();
        }catch(BrakZmiennej e){
            System.out.println("Brak zmiennej");
            e.printStackTrace();
        }
    }
    public int WykonajJedno(Blok x) {
        this.Wykonaj(x);
        this.stanWykonania = 1;
        return 1;
    }
}
