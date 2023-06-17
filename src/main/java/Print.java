public class Print extends Instrukcja {
    public void nazwa_instrukcji(){
        System.out.println("Print");
    }
    private Wyrazenie w;
    public Print(Wyrazenie w) {
        this.stanWykonania=0;
        this.w = w;
        this.jestBlokiem = false;
        this.jestProcedura=false;
    }
    public void wykonaj(Blok x) {
        try{
            int wartosc = w.wylicz(x);
            System.out.println(wartosc);
        }catch(DzieleniePrzezZero e){
            System.out.println("Dzielenie przez zero");
            e.printStackTrace();
        }catch(BrakZmiennej e){
            System.out.println("Brak zmiennej");
            e.printStackTrace();
        }
    }
    public int wykonajJedno(Blok x) {
        this.wykonaj(x);
        this.stanWykonania = 1;
        return 1;
    }
}
