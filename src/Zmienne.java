import java.util.ArrayList;

public class Zmienne {
    private ArrayList<Zmienna> zmienne;
    public Zmienne(ArrayList<Zmienna> zmienne) {
        this.zmienne = zmienne;
    }
    public Zmienne() {
        this.zmienne = new ArrayList<>();
    }

    public ArrayList<Zmienna> zmienne() {
        return this.zmienne;
    }
    public boolean czyNalezy(Zmienna z){
        if(zmienne.contains(z)) return true;
        return false;
    }
    public int zwrocWartosc(char z) throws BrakZmiennej{
        for (Zmienna i: zmienne) {
            if(i.nazwa()==z) return i.wartosc();
        }
        throw new BrakZmiennej("Brak zmiennej: "+z);
    }
    public void dodaj(char z, int wartosc){
        for (Zmienna i: this.zmienne) {
            if(i.nazwa()==z) {
                zmienne.remove(i);
                break;
            }
        }
        zmienne.add(new Zmienna(z, wartosc));
    }
    public void zmienWartosc(char z, int w) throws BrakZmiennej{
        for (Zmienna i: this.zmienne) {
            if(i.nazwa()==z) {
                i.zmienWartosc(w);
                return;
            }
        }throw new BrakZmiennej("Brak zmiennej: "+z);
    }
    public void rzutuj(Zmienne b){
        this.zmienne.clear();
        this.zmienne.addAll(b.zmienne());
    }
    public void wypisz(){
        for (Zmienna zmienna: zmienne) {
            System.out.print(zmienna.nazwa());
            System.out.print("=");
            System.out.println(zmienna.wartosc());
        }
    }
}
