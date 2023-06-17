import java.util.ArrayList;

public class WywołanieProcedury extends Instrukcja{
    public void nazwa_instrukcji(){
        System.out.println("Wywołanie Procedury: "+this.nazwa);
    }
    private Zmienne zmienne;
    private String nazwa;
    public String nazwa(){
        return this.nazwa;
    }
    private ArrayList<Wyrazenie> parametry;
    public WywołanieProcedury(String nazwa, ArrayList<Wyrazenie> parametry){
        this.nazwa=nazwa;
        this.parametry=parametry;
        this.stanWykonania = 0;
        this.jestBlokiem=false;
        this.jestProcedura=true;
    }
    public void wykonaj(Blok x){
        try {
            DeklaracjaProcedury pom = x.procedury().znajdz(this.nazwa);
            ArrayList<Character> argumenty = pom.argumenty();
            Zmienne z = new Zmienne();
            pom.sprawdzParametry(parametry);
            for (Wyrazenie i : parametry) {
                z.dodaj(argumenty.get(parametry.indexOf(i)), i.wylicz(x));//e?
            }
            pom.blok().wykonaj(x, z);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public int wykonajJedno(Blok x){
        try {
            DeklaracjaProcedury pom = x.procedury().znajdz(this.nazwa);
            ArrayList<Character> argumenty = pom.argumenty();
            Zmienne z = new Zmienne();
            pom.sprawdzParametry(parametry);
            for (Wyrazenie i : parametry) {
                z.dodaj(argumenty.get(parametry.indexOf(i)), i.wylicz(x));//e?
            }
            pom.blok().wykonajJedno(x, z);
        }catch(Exception e){
            e.printStackTrace();
        }
        stanWykonania=1;
        return 1;
    }
}
