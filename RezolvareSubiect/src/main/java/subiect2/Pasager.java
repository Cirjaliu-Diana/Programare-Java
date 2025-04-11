package subiect2;

public class Pasager {
    private String nume;
    private int varsta;

    public Pasager(String nume,int varsta)
    {
        this.nume=nume;
        this.varsta=varsta;
    }

    public Pasager(){}

    //getere
    public String getNume(){ return nume;}
    public int getVarsta(){ return varsta;}

    //setere
    public void setNume(String nume){ this.nume=nume;}
    public void setVarsta(int varsta){ this.varsta=varsta;}

    @Override
    public String toString() {
        return "Pasager{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                '}';
    }
}
