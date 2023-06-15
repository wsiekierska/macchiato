import java.util.ArrayList;

public class Zmienne {
    public ArrayList<Zmienna> zmienne;
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
    public boolean czyNalezy(char z){
        for (Zmienna i: this.zmienne) {
            if(i.nazwa()==z) return true;
        }
        return false;
    }
    public void dodaj(Zmienna z){
        for (Zmienna i: this.zmienne) {
            if(i.nazwa()==z.nazwa()) {
                zmienne.remove(i);
                break;
            }
        }
        zmienne.add(new Zmienna(z.nazwa(), z.wartosc()));
    }
//    public void dodaj(char z){
//        for (Zmienna i: this.zmienne) {
//            if(i.nazwa()==z) {
//                zmienne.remove(i);
//                break;
//            }
//        }
//        zmienne.add(new Zmienna(z));
//    }
    public void dodaj(char z, int wartosc){
        for (Zmienna i: this.zmienne) {
            if(i.nazwa()==z) {
                zmienne.remove(i);
                break;
            }
        }
        zmienne.add(new Zmienna(z, wartosc));
    }
    public void zmienWartosc(Zmienna z, int w){
        for (Zmienna i: this.zmienne) {
            if(i.nazwa()==z.nazwa()) {
                i.zmienWartosc(w);
                return;
            }
        }
    }
    public void zmienWartosc(char z, int w) throws BrakZmiennej{
//        boolean istnieje=false;
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
            System.out.println(zmienna.nazwa());
            System.out.print("=");
            System.out.print(zmienna.wartosc());
        }
    }
}
