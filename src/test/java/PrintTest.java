import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    void testWykonaj() {

        Program program = new ProgramBuilder()
                .deklaracja('c', Literal.of(10))
                .newPrint(Zmienna.oNazwie('c'))
                .build();
        program.Uruchom();
        assertEquals("10\nc=10", outputStreamCaptor.toString().trim());
    }
}
