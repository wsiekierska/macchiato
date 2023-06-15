import java.util.ArrayList;

public class WywołanieProcedury extends Instrukcja{
    public void nazwa_instrukcji(){
        System.out.println("new WykonanieProcedury");
    }
    private Zmienne zmienne;
    private String nazwa;
    private ArrayList<Integer> parametry;
    public WywołanieProcedury(String nazwa, ArrayList<Integer> parametry){
        this.nazwa=nazwa;
        this.parametry=parametry;
        this.stanWykonania = 0;
        this.jestBlokiem=false;
    }
    public void Wykonaj(Blok x){
        try {
            DeklaracjaProcedury pom = x.procedury().znajdz(this.nazwa);
            ArrayList<Character> argumenty = pom.argumenty();
            for (int i : parametry) {
                x.zmienne().dodaj(argumenty.get(parametry.get(i)), i);
            }
            pom.blok().Wykonaj(x);
        } catch(BrakProcedury e){
            System.out.println("Brak zadeklarowanej procedury");
            e.printStackTrace();
        }
    }

    public int WykonajJedno(Blok x){
        Wykonaj(x);
        stanWykonania=1;
        return 1;
    }




//    @TODO: dodać chary z kontruktora jako zmienne, wywołać Blok jakoś??, ale to w metodzie Wywołaj
//    @TODO: probably wywalić builder bo się nie przyda

}
