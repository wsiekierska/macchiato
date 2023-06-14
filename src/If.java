import java.util.ArrayList;

public class If extends Blok {
    public void nazwa_instrukcji(){
        System.out.println("new If, operator: "+this.operator);
    }
    protected Wyrazenie a, b;
    protected String operator;
    static protected int w1;
    static protected int w2;
    private Boolean wykonano;

    public Boolean getWykonano() {
        return wykonano;
    }

    public If(Wyrazenie a, String operator, Wyrazenie b, ArrayList<Instrukcja> d) {
        this.a = a;
        this.b = b;
        this.operator = operator;
        this.instrukcje = d;
        this.licznik = 0;
        this.jestBlokiem = true;
        this.stanWykonania = 0;
        this.wykonano = false;
        this.zmienne = new ArrayList<>();
    }


    public void Wykonaj(Blok x) throws IstniejacaZmienna{
        try {
            zmienne.addAll(x.zmienne);
            w1 = a.Wylicz(x);
            w2 = b.Wylicz(x);
            switch (operator) {
                case "=" -> {
                    if (w1 == w2) {
                        for (Instrukcja instrukcja : instrukcje) {
                            instrukcja.Wykonaj(x);
                            Aktualizacja(x);
                        }
                        wykonano = true;
                    }
                }
                case "<>" -> {
                    if (w1 != w2) {
                        for (Instrukcja instrukcja : instrukcje) {
                            instrukcja.Wykonaj(x);
                            Aktualizacja(x);
                        }
                        wykonano = true;
                    }
                }
                case ">" -> {
                    if (w1 > w2) {
                        for (Instrukcja instrukcja : instrukcje) {
                            instrukcja.Wykonaj(x);
                            Aktualizacja(x);
                        }
                        wykonano = true;
                    }
                }
                case "<" -> {
                    if (w1 < w2) {
                        for (Instrukcja instrukcja : instrukcje) {
                            instrukcja.Wykonaj(x);
                            Aktualizacja(x);
                        }
                        wykonano = true;
                    }
                }
                case ">=" -> {
                    if (w1 >= w2) {
                        for (Instrukcja instrukcja : instrukcje) {
                            instrukcja.Wykonaj(x);
                            Aktualizacja(x);
                        }
                        wykonano = true;
                    }
                }
                case "<=" -> {
                    if (w1 <= w2) {
                        for (Instrukcja instrukcja : instrukcje) {
                            instrukcja.Wykonaj(x);
                            Aktualizacja(x);
                        }
                        wykonano = true;
                    }
                }
            }
        }catch(DzieleniePrzezZero e){
            System.out.println("Dzielenie przez zero");
            e.printStackTrace();
        }catch(BrakZmiennej e){
            System.out.println("Brak zmiennej");
            e.printStackTrace();
        }
    }
}
