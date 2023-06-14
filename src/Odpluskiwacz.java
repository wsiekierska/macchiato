import java.util.Scanner;

public class Odpluskiwacz {
    public Odpluskiwacz() {
    }
    public void Step(Program p) {
        try {
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
                    for (Para<Character, Integer> zmienna : p.getZmienne()) {
                        System.out.print(zmienna.pierwszy());
                        System.out.print("=");
                        System.out.print(zmienna.drugi());
                    }
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
        }catch (IstniejacaZmienna e) {
            System.out.println("Taka zmienna juz istnieje");
            e.printStackTrace();
        }
    }

    public void Continue(Program p) {
        try {
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
        catch (IstniejacaZmienna e) {
            System.out.println("Taka zmienna juz istnieje");
            e.printStackTrace();
        }
    }

    public void Display(Program p) {
        Scanner sc = new Scanner(System.in);
        int ile = sc.nextInt();
        Blok teraz = p.getBloczki().get(0).Znajdz_pozycje(p.getBloczki().get(0));
        for (Para<Character, Integer> zmienna : teraz.zmienne) {
            System.out.print(zmienna.pierwszy());
            System.out.print("=");
            System.out.print(zmienna.drugi());
        }
    }
}
