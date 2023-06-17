import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeklaracjaProceduryTest {
    @Test
    public void testWykonaj(){
        Program program = new ProgramBuilder()
                .deklaracjaProcedury("beer", new ArrayList<Character>(List.of('c','r','a','f','t')),
                        new BlokBuilder()
//                                .przypisanieWartosci('c', Literal.of(5))
//                                .przypisanieWartosci('r', Dodawanie.of(Zmienna.oNazwie('c'), Literal.of(1)))
//                                .przypisanieWartosci('a', Dodawanie.of(Zmienna.oNazwie('r'), Literal.of(1)))
//                                .przypisanieWartosci('f', Odejmowanie.of(Zmienna.oNazwie('a'), Literal.of(1)))
//                                .przypisanieWartosci('t', Mnozenie.of(Zmienna.oNazwie('f'), Zmienna.oNazwie('a')))
                                .build())
                .build();
        program.Uruchom();
        assertEquals("beer(c, r, a, f, t)\n", program.procedury().wyjscie(program.procedury().procedury().get(0)));
    }
}
