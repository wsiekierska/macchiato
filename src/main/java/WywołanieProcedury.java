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
            pom.sprawdzParametry(parametry);
            for (Wyrazenie i : parametry) {
                z.dodaj(argumenty.get(parametry.indexOf(i)), i.Wylicz(x));//e?
            }
            pom.blok().Wykonaj(x, z);
        } catch(BrakProcedury e){
            e.printStackTrace();
        }catch(DzieleniePrzezZero e){
            e.printStackTrace();
        }catch(BrakZmiennej e){
            e.printStackTrace();
        }catch(ZlaLiczbaParametrow e){
            e.printStackTrace();
        }
    }
    public int WykonajJedno(Blok x){
        try {
            DeklaracjaProcedury pom = x.procedury().znajdz(this.nazwa);
            ArrayList<Character> argumenty = pom.argumenty();
            Zmienne z = new Zmienne();
            pom.sprawdzParametry(parametry);
            for (Wyrazenie i : parametry) {
                z.dodaj(argumenty.get(parametry.indexOf(i)), i.Wylicz(x));//e?
            }
            pom.blok().WykonajJedno(x, z);
        }catch(BrakProcedury e){
            e.printStackTrace();
        }catch(DzieleniePrzezZero e){
            e.printStackTrace();
        }catch(BrakZmiennej e){
            e.printStackTrace();
        }catch(ZlaLiczbaParametrow e){
            e.printStackTrace();
        }
        stanWykonania=1;
        return 1;
    }
}
