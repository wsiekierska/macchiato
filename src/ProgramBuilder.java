import java.util.ArrayList;
public class ProgramBuilder extends BlokBuilder{
    private ArrayList<Blok> bloczki;
    public ProgramBuilder(){
        super();
        this.bloczki=new ArrayList<>();
    }

    public ProgramBuilder blok(Blok d){
        instrukcje.add(d);
        bloczki.add(d);
        return this;
    }
    public Program build(){
        return new Program(instrukcje, bloczki, zmienne, procedury);
    }
}
