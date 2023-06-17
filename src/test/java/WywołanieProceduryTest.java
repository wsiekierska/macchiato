import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WywołanieProceduryTest {
    @Test
    public void testWykonaj(){
        Program program = new ProgramBuilder()
                .deklaracjaProcedury("beer", new ArrayList<Character>(List.of('c','r')),
                        new BlokBuilder()
                                .przypisanieWartosci('r', Dodawanie.of(Zmienna.oNazwie('r'), Zmienna.oNazwie('c')))
                                .build())
                .wywolanieProcedury("beer", new ArrayList<Wyrazenie>(List.of(Literal.of(1), Literal.of(5))))
                .build();
        program.uruchom();
        try {
            assertEquals(1, Zmienna.oNazwie('c').wylicz(program.procedury().procedury().get(0).blok()));
            assertEquals(6, Zmienna.oNazwie('r').wylicz(program.procedury().procedury().get(0).blok()));
        }catch(BrakZmiennej e){e.printStackTrace();}    }
}
