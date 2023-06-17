import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrzypisanieWartosciTest {
    @Test
    public void testWykonaj(){
        Program program = new ProgramBuilder()
                .deklaracja('c', Literal.of(10))
                .przypisanieWartosci('c', Literal.of(47))
                .build();
        program.Uruchom();
        try {
            assertEquals(47, Zmienna.oNazwie('c').Wylicz(program));
        }catch(BrakZmiennej e){e.printStackTrace();}
    }
}
