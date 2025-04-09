package firmaEchipamenteElectronice;

public class Copiator extends Echipament {
    private int p_ton;  //nr de pagini/toner
    private FormatDeCopiere format_copiere;

    //constructor
    public Copiator(String denumire, int nr_inv, float pret, String zona_mag, String situatie,int p_ton,String format_copiere) {
        super(denumire, nr_inv, pret, zona_mag, situatie);
        this.p_ton = p_ton;
        this.format_copiere = FormatDeCopiere.valueOf(format_copiere);
    }

    //getere
    public int getP_ton() {
        return p_ton;
    }
    public FormatDeCopiere getFormat_copiere() {
        return format_copiere;
    }

    //setere
    public void setP_ton(int p_ton) {
        this.p_ton = p_ton;
    }
    public void setFormat_copiere(String format_copiere) {
        this.format_copiere = FormatDeCopiere.valueOf(format_copiere);
    }

    @Override
    public String toString() {
        return super.toString()+"Copiator{" +
                "p_ton=" + p_ton +
                ", format_copiere=" + format_copiere +
                '}';
    }
}
