import java.util.ArrayList;

public class DeklaracjaProcedury extends Instrukcja{
    public void nazwa_instrukcji(){
        System.out.println("Deklaracja Procedury: "+this.nazwa);
    }
    private String nazwa;
    public String nazwa(){return this.nazwa;}
    private Zmienne zmienne;
    private ArrayList<Character> argumenty;
    private Blok b;
    public ArrayList<Character> argumenty(){
        return this.argumenty;
    }
    public Blok blok(){
        return this.b;
    }
    public DeklaracjaProcedury(String nazwa, ArrayList<Character> argumenty, Blok b){
        this.stanWykonania = 0;
        this.nazwa=nazwa;
        this.argumenty=argumenty;
        this.b=b;
        this.zmienne=new Zmienne();
        this.jestBlokiem = false;
    }
    public void Wykonaj(Blok x){
        try{
            x.procedury().dodaj(this);
        }catch(IstniejacaProcedura e){}
    }
    public int WykonajJedno(Blok x){
        Wykonaj(x);
        stanWykonania=1;
        return 1;
    }
    public void sprawdzParametry(ArrayList<Wyrazenie> parametry)throws ZlaLiczbaParametrow{
        if(parametry.size()!= argumenty().size()){
            throw new ZlaLiczbaParametrow("Podano złą liczbę parametrów.");
        }
    }

}
