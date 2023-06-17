import java.util.ArrayList;
import java.util.Scanner;

public class Program extends Blok {
    private ArrayList<Blok> Bloczki;
    public void nazwa_instrukcji(){
        System.out.println("Blok glowny");
    }
    public ArrayList<Blok> getBloczki() {
        return Bloczki;
    }
    public void stanWykonania(int x){this.stanWykonania=x;}

    public Program(ArrayList<Instrukcja> instrukcje, ArrayList<Blok> Bloczki, Zmienne zmienne, Procedury procedury) {
        super(instrukcje, zmienne, procedury);
        this.Bloczki = Bloczki;
        Bloczki.add(0, new Blok(instrukcje, zmienne, procedury));
    }
    public void uruchom() {
            for (Instrukcja instrukcja : instrukcje) {
                instrukcja.wykonaj(this);
            } zmienne.wypisz();
    }

    public void debug() {
        Odpluskiwacz debug=new Odpluskiwacz();
        Scanner sc = new Scanner(System.in);
        String c;
        while (stanWykonania==0) {
            c = sc.next();
            switch (c) {
                case "s" -> {
                    debug.Step(this);
                }
                case "c" -> {
                    debug.Continue(this);
                }
                case "d" -> {
                    debug.Display(this);
                }case "m" -> {
                    debug.dump(this);
                }
                case "e" -> {
                    System.out.println("Program został zakończony.");
                    zmienne.wypisz();
                    return;
                }
            }
        }
        System.out.println("Program został zakończony.");
        return;
    }
    public int wykonajJedno(Blok x){
        instrukcje.get(licznik).wykonajJedno(this);
        if (instrukcje.get(licznik).getStanWykonania() == 1) {
            licznik++;
//            if (licznik == instrukcje.size()) {
//                stanWykonania = 1;
//            }
            return 1;
        }
        return 0;
    }
}



