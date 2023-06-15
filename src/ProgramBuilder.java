import java.util.ArrayList;
public class ProgramBuilder extends BlokBuilder{
    private ArrayList<Blok> bloczki;
    public ProgramBuilder(){
        super();
        this.bloczki=new ArrayList<>();
    }
    public void Blok(Blok d){
        instrukcje.add(d);
        bloczki.add(d);
    }
    public Program build(){
        return new Program(instrukcje, bloczki, zmienne, procedury);
    }
}
