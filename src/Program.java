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
    private int ktoryBlok;

    public Program(ArrayList<Instrukcja> instrukcje, ArrayList<Blok> Bloczki, Zmienne zmienne, Procedury procedury) {
        super(instrukcje, zmienne, procedury);
        this.Bloczki = Bloczki;
        Bloczki.add(0, new Blok(instrukcje, zmienne, procedury));
    }
    public void Uruchom() {
            for (Instrukcja instrukcja : instrukcje) {
                instrukcja.Wykonaj(this);
            } zmienne.wypisz();
    }

    public void Debug() {
        Odpluskiwacz debug=new Odpluskiwacz();
        ktoryBlok = 0;
        Scanner sc = new Scanner(System.in);
        String c;
        while (true) {
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
                }
                case "e" -> {
                    System.out.println("Program został zakończony.");
                    return;
                }
            }
        }
    }
}



