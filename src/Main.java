import java.util.*;
import static java.util.List.*;

public class Main {
    public static void main(String[] args) {
        var program = new ProgramBuilder()
                .deklaracja('x', Literal.of(101))
                .deklaracja('y', Literal.of(1))
//                .newPrint(Zmienna.oNazwie('x'))
//                .newPrint(Zmienna.oNazwie('y'))
                .deklaracjaProcedury("out", new ArrayList<Character>(List.of('a')), new BlokBuilder()
                        .newPrint(Dodawanie.of(Zmienna.oNazwie('a'), Zmienna.oNazwie('x')))
                        .build()
                )
                .przypisanieWartosci('x', Odejmowanie.of(Zmienna.oNazwie('x'), Zmienna.oNazwie('y')))
//                .newPrint(Zmienna.oNazwie('x'))
                .wywolanieProcedury("out", new ArrayList<Wyrazenie>(List.of(Zmienna.oNazwie('x'))))
                .wywolanieProcedury("out", new ArrayList<Wyrazenie>(List.of(Literal.of(100))))
                .blok(new BlokBuilder()
                        .deklaracja('x', Literal.of(10))
                        .wywolanieProcedury("out", new ArrayList<Wyrazenie>(of(Literal.of(100))))
                        .build()
                )
                .build();
        program.Uruchom();
        //program.Debug();
    }
}