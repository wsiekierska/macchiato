import java.util.ArrayList;
public class Procedury {
    private ArrayList<DeklaracjaProcedury> procedury;
    public ArrayList<DeklaracjaProcedury> procedury(){return procedury;}
    public Procedury(ArrayList<DeklaracjaProcedury> procedury) {
        this.procedury = procedury;
    }
    public Procedury() {
        this.procedury = new ArrayList<>();
    }

    public void dodaj(DeklaracjaProcedury d){
        for (DeklaracjaProcedury i: this.procedury) {
            if(i.nazwa()==d.nazwa()) {
                procedury.remove(i);
                break;
            }
        }
        procedury.add(d);
    }
    public void rzutuj(Procedury b){
        this.procedury.clear();
        this.procedury.addAll(b.procedury());
    }
    public DeklaracjaProcedury znajdz(String nazwa) throws BrakProcedury{
        for (DeklaracjaProcedury i: this.procedury) {
            if(i.nazwa()==nazwa) {
                return i;
            }
        }
        throw new BrakProcedury("Brak zadeklarowanej procedury");
    }
}
