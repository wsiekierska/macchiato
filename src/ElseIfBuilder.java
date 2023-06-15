import java.util.ArrayList;

public class ElseIfBuilder extends IfBuilder{
    private ArrayList<Instrukcja> instrukcjePozytywne;
    public ElseIfBuilder(Wyrazenie a, String operator, Wyrazenie b){
        super(a, operator, b);
        instrukcjePozytywne=new ArrayList<>();
    }
    public void Else(){
        instrukcjePozytywne.addAll(instrukcje);
        instrukcje.clear();
    }
    public ElseIf build(){
        return new ElseIf(a, operator, b, instrukcjePozytywne, instrukcje, zmienne, procedury);
    }

}
