public abstract class Instrukcja {
    protected int stanWykonania;
    protected Boolean jestBlokiem;
    protected Boolean jestProcedura;

    public Boolean getJestProcedura() {
        return jestProcedura;
    }
    public Boolean getJestBlokiem() {
        return this.jestBlokiem;
    }

    public int getStanWykonania() {
        return stanWykonania;
    }
    public abstract void nazwa_instrukcji();

    public abstract void wykonaj(Blok x);

    public abstract int wykonajJedno(Blok x);

}
