import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlokTest {
    @Test
    public void testWykonaj(){
        Program program = new ProgramBuilder()
                .deklaracja('b', Literal.of(1))
                .deklaracja('e', Literal.of(2))
                .deklaracja('r', Literal.of(3))
                .blok(new BlokBuilder()
                        .przypisanieWartosci('b', Literal.of(10))
                        .przypisanieWartosci('e', Literal.of(100))
                        .przypisanieWartosci('e', Zmienna.oNazwie('r'))
                        .przypisanieWartosci('r', Literal.of(100))
                        .build()
                )
                .build();
        program.uruchom();
        try {
            assertEquals(10, Zmienna.oNazwie('b').wylicz(program));
            assertEquals(3, Zmienna.oNazwie('e').wylicz(program));
            assertEquals(100, Zmienna.oNazwie('r').wylicz(program));
        }catch(BrakZmiennej e){e.printStackTrace();}
    }
}
