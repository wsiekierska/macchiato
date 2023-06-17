import java.util.ArrayList;

public class If extends Blok {
    public void nazwa_instrukcji(){
        System.out.println("If, operator: "+this.operator);
    }
    protected Wyrazenie a, b;
    protected String operator;
    static protected int w1;
    static protected int w2;
    public If(Wyrazenie a, String operator, Wyrazenie b, ArrayList<Instrukcja> instrukcje, Zmienne zmienne, Procedury procedury) {
        super(instrukcje, zmienne, procedury);
        this.a = a;
        this.b = b;
        this.operator = operator;
    }

    public void wykonaj(Blok x){
        try {
            zmienne.rzutuj(x.zmienne());
            procedury.rzutuj(x.procedury());
            w1 = a.wylicz(x);
            w2 = b.wylicz(x);
            switch (operator) {
                case "=" -> {
                    if (w1 == w2) {
                        for (Instrukcja instrukcja : instrukcje) {
                            instrukcja.wykonaj(x);
                        }
                        stanWykonania = 1;
                    }
                }
                case "<>" -> {
                    if (w1 != w2) {
                        for (Instrukcja instrukcja : instrukcje) {
                            instrukcja.wykonaj(x);
                        }
                        stanWykonania = 1;
                    }
                }
                case ">" -> {
                    if (w1 > w2) {
                        for (Instrukcja instrukcja : instrukcje) {
                            instrukcja.wykonaj(x);
                        }
                        stanWykonania = 1;
                    }
                }
                case "<" -> {
                    if (w1 < w2) {
                        for (Instrukcja instrukcja : instrukcje) {
                            instrukcja.wykonaj(x);
                        }
                        stanWykonania = 1;
                    }
                }
                case ">=" -> {
                    if (w1 >= w2) {
                        for (Instrukcja instrukcja : instrukcje) {
                            instrukcja.wykonaj(x);
                        }
                        stanWykonania = 1;
                    }
                }
                case "<=" -> {
                    if (w1 <= w2) {
                        for (Instrukcja instrukcja : instrukcje) {
                            instrukcja.wykonaj(x);
                        }
                        stanWykonania = 1;
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
