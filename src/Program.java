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

    public Program(ArrayList<Instrukcja> instrukcje, ArrayList<Blok> Bloczki) {
        this.instrukcje = instrukcje;
        this.zmienne = new ArrayList<>();
        this.Bloczki = Bloczki;
        this.poprzedni=this;
        Bloczki.add(new Blok(instrukcje));
    }

    public void Wykonaj(Blok x) {
        try {
            for (Instrukcja instrukcja : instrukcje) {
                instrukcja.Wykonaj(this);
            }
            for (Para<Character, Integer> zmienna : zmienne) {
                System.out.print(zmienna.pierwszy());
                System.out.print("=");
                System.out.print(zmienna.drugi());
            }
        }catch (IstniejacaZmienna e) {
            System.out.println("Taka zmienna juz istnieje");
            e.printStackTrace();
        }
    }
    public void Uruchom_z_odpluskiwaczem(Blok x) {
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



