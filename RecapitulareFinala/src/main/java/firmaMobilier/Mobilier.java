package firmaMobilier;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Mobilier implements Serializable {
    private String nume;
    private List<Placa> placi;
    private LocalDate data_adaugare;

    public Mobilier(String nume, List<Placa> placi, LocalDate data_adaugare) {
        this.nume = nume;
        this.placi = placi;
        this.data_adaugare = data_adaugare;
    }

    public Mobilier(){}

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<Placa> getPlaci() {
        return placi;
    }

    public void setPlaci(List<Placa> placi) {
        this.placi = placi;
    }

    public LocalDate getData_adaugare() {
        return data_adaugare;
    }

    public void setData_adaugare(LocalDate data_adaugare) {
        this.data_adaugare = data_adaugare;
    }

    @Override
    public String toString() {
        return "Mobilier{" +
                "nume='" + nume + '\'' +
                ", placi=" + placi +
                ", data_adaugare=" + data_adaugare +
                '}';
    }
}
