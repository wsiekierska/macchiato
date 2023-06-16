import java.util.ArrayList;

public class WywołanieProcedury extends Instrukcja{
    public void nazwa_instrukcji(){
        System.out.println("new WykonanieProcedury");
    }
    private Zmienne zmienne;
    private String nazwa;
    private ArrayList<Wyrazenie> parametry;
    public WywołanieProcedury(String nazwa, ArrayList<Wyrazenie> parametry){
        this.nazwa=nazwa;
        this.parametry=parametry;
        this.stanWykonania = 0;
        this.jestBlokiem=false;
    }
    public void Wykonaj(Blok x){
        try {
            DeklaracjaProcedury pom = x.procedury().znajdz(this.nazwa);
            ArrayList<Character> argumenty = pom.argumenty();
            Zmienne z = new Zmienne();
            for (Wyrazenie i : parametry) {
                z.dodaj(argumenty.get(parametry.indexOf(i)), i.Wylicz(x));//e?
            }
            pom.blok().Wykonaj(x, z);
        } catch(BrakProcedury e){
            System.out.println("Brak zadeklarowanej procedury");
            e.printStackTrace();
        }catch(DzieleniePrzezZero e){
            System.out.println("Dzielenie przez zero");
            e.printStackTrace();
        }catch(BrakZmiennej e){
            System.out.println("Brak zmiennej");
            e.printStackTrace();
        }
    }
    public int WykonajJedno(Blok x){
        Wykonaj(x);
        stanWykonania=1;
        return 1;
    }
}
