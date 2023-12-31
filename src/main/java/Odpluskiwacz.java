import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Odpluskiwacz {
    private int wykonaneInstrukcje;

    public Odpluskiwacz() {
        this.wykonaneInstrukcje=0;
    }
    public void Step(Program p) {
        Scanner sc = new Scanner(System.in);
        int ile = sc.nextInt();
        if (p.getBloczki().get(0).getLicznik() >= p.getInstrukcje().size()) {
            p.stanWykonania(1);
            return;
        }
        while (ile != 0) {
            wykonaneInstrukcje++;
            int czyWykonano = p.wykonajJedno(p);
            if (wykonaneInstrukcje == p.getInstrukcje().size()) {
                p.stanWykonania(1);
                return;
            } else {
                ile--;
            }
        }
        if (p.getBloczki().get(0).getLicznik() < p.getInstrukcje().size()) {
            Blok teraz = p.znajdzPozycje(p);
            System.out.print("Wejdz w instrukcje: ");
            teraz.getInstrukcje().get(teraz.getLicznik()).nazwa_instrukcji();
        }
    }
    public void Continue(Program p) {
        if (p.getBloczki().get(0).getLicznik() >= p.getInstrukcje().size()) {
            p.stanWykonania(1);
            return;
        }
        int czyWykonano = 0;
        while (czyWykonano != 1) {
            czyWykonano = p.getBloczki().get(0).wykonajJedno(p.getBloczki().get(0));
        }
        if (p.getBloczki().get(0).getLicznik() >= p.getInstrukcje().size()) {
            p.stanWykonania(1);
            return;
        } else {
            for (int i = p.getBloczki().get(0).getLicznik(); i < p.getInstrukcje().size(); i++) {
                p.getBloczki().get(0).instrukcje.get(i).wykonaj(p.getBloczki().get(0));
            }
        }

    }
    public void Display(Program p) {
        Scanner sc = new Scanner(System.in);
        Blok teraz = p.getBloczki().get(0).znajdzPozycje(p.getBloczki().get(0));
        teraz.zmienne().wypisz();
    }

    public void dump(Program p){
        Scanner sc = new Scanner(System.in);
        String sciezka = sc.next();
        File plik = new File(sciezka);
            try {
                FileWriter zapisanie = new FileWriter(plik);
                Blok teraz = p.getBloczki().get(0).znajdzPozycje(p.getBloczki().get(0));
                teraz.procedury().zapisz(zapisanie);
                teraz.zmienne().zapisz(zapisanie);
                zapisanie.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
