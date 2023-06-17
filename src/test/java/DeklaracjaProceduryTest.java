import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeklaracjaProceduryTest {
    @Test
    public void testWykonaj(){
        Program program = new ProgramBuilder()
                .deklaracjaProcedury("beer", new ArrayList<Character>(List.of('c','r','a','f','t')),
                        new BlokBuilder().build())
                .build();
        program.Uruchom();
        assertEquals("beer(c, r, a, f, t)\n", program.procedury().wyjscie(program.procedury().procedury().get(0)));
    }
}
