public abstract class Instrukcja {
    protected int stanWykonania;
    protected Boolean jestBlokiem;

    public Boolean getJestBlokiem() {
        return this.jestBlokiem;
    }

    public int getStanWykonania() {
        return stanWykonania;
    }
    public abstract void nazwa_instrukcji();


    public abstract void Wykonaj(Blok x) throws IstniejacaZmienna;

    public abstract int WykonajJedno(Blok x) throws IstniejacaZmienna;


}
