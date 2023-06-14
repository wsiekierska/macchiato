import java.util.*;
public class Main {
    public static void main(String args[]) {

//            ArrayList<Instrukcja> Program1 = new ArrayList<Instrukcja>();
//            ArrayList<Blok> Bloczki = new ArrayList<Blok>();
//            Program1.add(new Deklaracja('n', new Literal(30)));
//                ArrayList<Instrukcja> For1 = new ArrayList<Instrukcja>();
//                    ArrayList<Instrukcja> Blok2 = new ArrayList<Instrukcja>();
//                    Blok2.add(new Deklaracja('p', new Literal(1)));
//                    Blok2.add(new Przypisanie_wartosci('k', new Dodawanie(new Zmienna('k'), new Literal(2))));
//                        ArrayList<Instrukcja> For2 = new ArrayList<Instrukcja>();
//                        For2.add(new Przypisanie_wartosci('i', new Dodawanie(new Zmienna('i'), new Literal(2))));
//                            ArrayList<Instrukcja> If1 = new ArrayList<Instrukcja>();
//                            If1.add(new Przypisanie_wartosci('p', new Literal(0)));
//                            For2.add(new Print(new Zmienna('k')));
//                            For2.add(new Print(new Zmienna('i')));
//                        For2.add(new If(new Modulo(new Zmienna('k'), new Zmienna('i')), "=", new Literal(0), If1));
//                        For2.add(new Przypisanie_wartosci('i', new Odejmowanie(new Zmienna('i'), new Literal(2))));
//
//                        For For_2= new For('i',new Odejmowanie(new Zmienna('k'), new Literal(2)) ,For2);
//                        Blok2.add(new For('i',new Odejmowanie(new Zmienna('k'), new Literal(2)), For2));
//                        ArrayList<Instrukcja> If2 = new ArrayList<Instrukcja>();
//                        If2.add(new Print(new Zmienna('k')));
//                    Blok2.add(new If(new Zmienna('p'), "=", new Literal(1), If2));
//                    Bloczki.add(0, new If(new Zmienna('p'), "=", new Literal(1), If2));
//
//        Blok2.add(new Przypisanie_wartosci('k', new Odejmowanie(new Zmienna('k'), new Literal(2))));
//
//        For1.add(new Blok(Blok2));
//        Bloczki.add(0, new Blok(Blok2));
//        Program1.add(new Print(new Odejmowanie(new Zmienna('n'), new Literal(1))));
//            Program1.add(new For('k',new Odejmowanie(new Zmienna('n'), new Literal(1)), For1));
//        Program Program=new Program(Program1, Bloczki);
//        Program.Wykonaj(Program);

        //Powyższy program wyrzuca wyjątek "Brak Zmiennej",
        //bo istnieje jakiś błąd w implementacji Fora (zapewne),
        //którego niestety nie potrafię zlokalizować.


        ArrayList<Instrukcja> program2 = new ArrayList<Instrukcja>();
        ArrayList<Blok> bloczki2 =new ArrayList<Blok>();
        ArrayList<Instrukcja> instr1 = new ArrayList<Instrukcja>();
        instr1.add(new Deklaracja('g', new Literal(99)));
        instr1.add(new Print(new Zmienna('g')));
        instr1.add(new Print(new Zmienna('c')));
        program2.add(new Deklaracja('c', new Literal(2137)));
        program2.add(new Blok(instr1));
        bloczki2.add(0, new Blok(instr1));

        Program Program2 = new Program(program2, bloczki2);
        Program2.Wykonaj(Program2);
    }
}