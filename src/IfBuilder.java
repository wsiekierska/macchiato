public class IfBuilder extends BlokBuilder{
    protected Wyrazenie a, b;
    protected String operator;
    public IfBuilder(Wyrazenie a, String operator, Wyrazenie b){
        super();
        this.a=a;
        this.operator=operator;
        this.b=b;
    }
    public If build(){
        return new If(a,operator,b,instrukcje, zmienne);
    }
}
