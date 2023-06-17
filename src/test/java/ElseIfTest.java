import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElseIfTest {
    @Test
    public void testWykonaj(){
        Program program = new ProgramBuilder()
                .deklaracja('b', Literal.of(1))
                .deklaracja('e', Literal.of(2))
                .newif(new ElseIfBuilder(Zmienna.oNazwie('b'), "<", Zmienna.oNazwie('e'))
                        .przypisanieWartosci('e', Zmienna.oNazwie('b'))
                        .butElse()
                        .przypisanieWartosci('e', Literal.of(100))
                        .build()
                )
                .build();
        program.uruchom();
        try {
            assertEquals(1, Zmienna.oNazwie('e').wylicz(program));
        }catch(BrakZmiennej e){e.printStackTrace();}
    }
    @Test
    public void testWykonaj2(){Program program = new ProgramBuilder()
            .deklaracja('b', Literal.of(1))
            .deklaracja('e', Literal.of(2))
            .newif(new ElseIfBuilder(Zmienna.oNazwie('b'), ">=", Zmienna.oNazwie('e'))
                    .przypisanieWartosci('e', Zmienna.oNazwie('b'))
                    .butElse()
                    .przypisanieWartosci('e', Literal.of(100))
                    .build()
            )
            .build();
        program.uruchom();
        try {
            assertEquals(100, Zmienna.oNazwie('e').wylicz(program));
        }catch(BrakZmiennej e){e.printStackTrace();}
    }
}
