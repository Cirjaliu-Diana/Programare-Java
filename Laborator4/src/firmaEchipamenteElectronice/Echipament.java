package firmaEchipamenteElectronice;

public class Echipament {
    private String denumire;
    private int nr_inv; //nr inventar
    private float pret;
    private String zona_mag;    //zona magazin
    private Situatie situatie;

    public Echipament(String denumire, int nr_inv, float pret, String zona_mag, String situatie) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.situatie = Situatie.valueOf(situatie);
    }

    //getere
    public String getDenumire() {
        return denumire;
    }
    public int getNr_inv() {
        return nr_inv;
    }
    public float getPret() {
        return pret;
    }

    public String getZona_mag() {
        return zona_mag;
    }

    public Situatie getSituatie() {
        return situatie;
    }

    //setere
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
    public void setNr_inv(int nr_inv) {
        this.nr_inv = nr_inv;
    }
    public void setPret(float pret) {
        this.pret = pret;
    }

    public void setZona_mag(String zona_mag) {
        this.zona_mag = zona_mag;
    }

    public void setSituatie(String situatie) {
        this.situatie = Situatie.valueOf(situatie);
    }

    @Override
    public String toString() {
        return "Echipament [denumire=" + denumire + ", nr_inv=" + nr_inv + ", pret=" + pret + ", zona_mag="
                + zona_mag + ", situatie=" + situatie + "]";
    }
}
