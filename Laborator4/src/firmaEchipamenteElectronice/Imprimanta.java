package firmaEchipamenteElectronice;

public class Imprimanta extends Echipament {
    private int ppm;    //nr de pagini scrise pe minut
    private String rezolutie;   //nr de puncte per inch dpi
    private int p_car;  //nr de pagini/cartus
    private ModTiparire mod_tiparire;

    public Imprimanta(String denumire, int nr_inv, float pret, String zona_mag, String situatie, int ppm, String rezolutie, int p_car, String mod_tiparire) {
        super(denumire, nr_inv, pret, zona_mag, situatie);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.mod_tiparire = ModTiparire.valueOf(mod_tiparire);
    }

    //getere
    public int getPpm() {
        return ppm;
    }
    public String getRezolutie() {
        return rezolutie;
    }
    public int getP_car() {
        return p_car;
    }

    public ModTiparire getMod_tiparire() {
        return mod_tiparire;
    }

    //setere
    public void setPpm(int ppm) {
        this.ppm = ppm;
    }
    public void setRezolutie(String rezolutie) {
        this.rezolutie = rezolutie;
    }
    public void setP_car(int p_car) {
        this.p_car = p_car;
    }

    public void setMod_tiparire(String mod_tiparire) {
        this.mod_tiparire = ModTiparire.valueOf(mod_tiparire);
    }

    @Override
    public String toString() {
        return super.toString()+"Imprimanta{" +
                "ppm=" + ppm +
                ", rezolutie='" + rezolutie + '\'' +
                ", p_car=" + p_car +
                ", mod_tiparire=" + mod_tiparire +
                '}';
    }
}
