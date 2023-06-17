import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForTest {
    @Test
    public void testWykonaj(){
        Program program = new ProgramBuilder()
                .deklaracja('b', Literal.of(1))
                .deklaracja('e', Literal.of(2))
                .newFor(new ForBuilder('i', Literal.of(5))
                        .przypisanieWartosci('b', Dodawanie.of(Zmienna.oNazwie('i'), Zmienna.oNazwie('b')))
                        .przypisanieWartosci('e', Dodawanie.of(Zmienna.oNazwie('e'), Literal.of(1)))
                        .build()
                )
                .build();
        program.uruchom();
        try {
            assertEquals(11, Zmienna.oNazwie('b').wylicz(program));
            assertEquals(7, Zmienna.oNazwie('e').wylicz(program));
        }catch(BrakZmiennej e){e.printStackTrace();}
    }
}
