import java.util.Scanner;

public class Odpluskiwacz {
    public Odpluskiwacz() {
    }
    public void Step(Program p) {
        Scanner sc = new Scanner(System.in);
        int ile = sc.nextInt();
        if (p.getBloczki().get(0).getLicznik() >= p.getInstrukcje().size()) {
            System.out.println("Program się wykonał.");
            return;
        }
        System.out.println("Wejdz w instrukcje: new Blok");
        while (ile != 0) {
            int czyWykonano = p.getBloczki().get(0).WykonajJedno(p.getBloczki().get(0));
            if (p.getBloczki().get(0).getLicznik() == p.getInstrukcje().size()) {
                p.zmienne.wypisz();
            }
            if (p.getBloczki().get(0).getLicznik() > p.getInstrukcje().size()) {
                System.out.println("Program się wykonał.");
                return;
            } else {
                ile--;
            }
        }
        if (p.getBloczki().get(0).getLicznik() < p.getInstrukcje().size()) {
            Blok teraz = p.getBloczki().get(0).Znajdz_pozycje(p.getBloczki().get(0));
            System.out.print("Wejdz w instrukcje: ");
            teraz.getInstrukcje().get(teraz.getLicznik()).nazwa_instrukcji();
        }
    }
    public void Continue(Program p) {
        if (p.getBloczki().get(0).getLicznik() >= p.getInstrukcje().size()) {
            System.out.println("Program się wykonał.");
            return;
        }
        int czyWykonano = 0;
        while (czyWykonano != 1) {
            czyWykonano = p.getBloczki().get(0).WykonajJedno(p.getBloczki().get(0));
        }
        if (p.getBloczki().get(0).getLicznik() >= p.getInstrukcje().size()) {
            System.out.println("Program się wykonał.");
            return;
        } else {
            for (int i = p.getBloczki().get(0).getLicznik(); i < p.getInstrukcje().size(); i++) {
                p.getBloczki().get(0).instrukcje.get(i).Wykonaj(p.getBloczki().get(0));
            }
        }

    }
    public void Display(Program p) {
        Scanner sc = new Scanner(System.in);
        int ile = sc.nextInt();
        Blok teraz = p.getBloczki().get(0).Znajdz_pozycje(p.getBloczki().get(0));
        teraz.zmienne().wypisz();
    }
}
