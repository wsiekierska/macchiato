import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    public void dodaj(DeklaracjaProcedury d) throws IstniejacaProcedura{
        for (DeklaracjaProcedury i: this.procedury) {
            if(i.nazwa()==d.nazwa()) {
                throw new IstniejacaProcedura("Procedura "+d.nazwa()+" już istnieje.");
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
    public void zapisz(FileWriter sciezka){
        String zapis;
        try {
            for (DeklaracjaProcedury procedura : procedury) {
                zapis=wyjscie(procedura);
                sciezka.write(zapis);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String wyjscie(DeklaracjaProcedury procedura){
        String zapis;
        zapis = procedura.nazwa()+'(';
        for(char arg: procedura.argumenty()){
            zapis+=arg+", ";
        }
        zapis=zapis.substring(0, zapis.length()-2);
        zapis+=")\n";
        return zapis;
    }
}
