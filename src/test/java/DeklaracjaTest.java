import org.junit.jupiter.api.Test;
import java.util.*;
import static java.util.List.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeklaracjaTest {
    @Test
    public void testWykonaj(){
        Program program = new ProgramBuilder()
                .deklaracja('c', Literal.of(10))
                .build();
        program.Uruchom();
        try {
            assertEquals(10, Zmienna.oNazwie('c').Wylicz(program));
        }catch(BrakZmiennej e){e.printStackTrace();}
    }
}
