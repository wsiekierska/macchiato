import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IfTest {
    @Test
    public void testWykonaj(){
        Program program = new ProgramBuilder()
                .deklaracja('b', Literal.of(1))
                .deklaracja('e', Literal.of(2))
                .newif(new IfBuilder(Zmienna.oNazwie('b'), "<", Zmienna.oNazwie('e'))
                        .przypisanieWartosci('e', Zmienna.oNazwie('b'))
                        .build()
                )
                .build();
        program.uruchom();
        try {
            assertEquals(1, Zmienna.oNazwie('e').wylicz(program));
        }catch(BrakZmiennej e){e.printStackTrace();}
    }
    @Test
    public void testWykonaj2(){
        Program program = new ProgramBuilder()
                .deklaracja('b', Literal.of(1))
                .deklaracja('e', Literal.of(2))
                .newif(new IfBuilder(Zmienna.oNazwie('b'), ">=", Zmienna.oNazwie('e'))
                        .przypisanieWartosci('e', Zmienna.oNazwie('b'))
                        .build()
                )
                .build();
        program.uruchom();
        try {
            assertEquals(2, Zmienna.oNazwie('e').wylicz(program));
        }catch(BrakZmiennej e){e.printStackTrace();}
    }
}
