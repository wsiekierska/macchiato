import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeklaracjaTest {
    @Test
    public void testWykonaj(){
        Program program = new ProgramBuilder()
                .deklaracja('c', Literal.of(10))
                .build();
        program.uruchom();
        try {
            assertEquals(10, Zmienna.oNazwie('c').wylicz(program));
        }catch(BrakZmiennej e){e.printStackTrace();}
    }
}
