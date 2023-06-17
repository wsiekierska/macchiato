import java.util.*;
import static java.util.List.*;

public class Main {
    public static void main(String[] args) {
        var program = new ProgramBuilder()
                .deklaracja('x', Literal.of(101))
                .deklaracja('y', Literal.of(1))
                .deklaracjaProcedury("out", new ArrayList<Character>(List.of('a')), new BlokBuilder()
                        .newPrint(Dodawanie.of(Zmienna.oNazwie('a'), Zmienna.oNazwie('x')))
                        .build()
                )
                .przypisanieWartosci('x', Odejmowanie.of(Zmienna.oNazwie('x'), Zmienna.oNazwie('y')))
                .wywolanieProcedury("out", new ArrayList<Wyrazenie>(List.of(Zmienna.oNazwie('x'))))
                .wywolanieProcedury("out", new ArrayList<Wyrazenie>(List.of(Literal.of(100))))
                .blok(new BlokBuilder()
                        .deklaracja('x', Literal.of(10))
                        .wywolanieProcedury("out", new ArrayList<Wyrazenie>(of(Literal.of(100))))
                        .build()
                )
                .build();
//        program.uruchom();
        program.debug();
    }
}

//Krótka notatka na temat tego programu:
//-debugger teoretyczne powinien działać, natomiast nie mogę też tego w 100% POtwierdzić,
// bo mogą być tam błędy jeszcze z pierwszego zadania, gdzie on nie działał kompletnie.
//
//-zdecydowanie odradzałabym używanie polecenia continue, gdyż może stać się wówczas
// coś bardzo, bardzo złego.
//
//-polecenie step POwinno być OK, należy w terminalu wpisać s -> enter(!) -> podać liczbę kroków.
//
//-dump działa.