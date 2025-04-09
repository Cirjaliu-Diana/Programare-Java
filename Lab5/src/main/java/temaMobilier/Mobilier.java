package temaMobilier;

import java.io.Serializable;
import java.util.List;

public class Mobilier implements Serializable {

    private String nume;
    private List<Placi> placi;

    public Mobilier(String nume, List<Placi> placi) {
        this.nume = nume;
        this.placi = placi;
    }

    public Mobilier(){}

    //getere
    public String getNume() { return nume; }
    public List<Placi> getPlaci() { return placi; }

    //setere
    public void setNume(String nume) { this.nume = nume; }
    public void setPlaci(List<Placi> placi) { this.placi = placi; }

    @Override
    public String toString() {
        return "Mobilier{" +
                "nume='" + nume + '\'' +
                ", placi=" + placi +
                '}';
    }
}
