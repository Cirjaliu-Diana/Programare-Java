package exercitiul2;

import java.time.LocalDate;

public class Produs {
    private String denumire_produs;
    private float pret;
    private int cantitate;
    private LocalDate data_expirare;
    private int incasari =0;

    public Produs(String denumire_produs, float pret, int cantitate, LocalDate data_expirare) {
        super();
        this.denumire_produs = denumire_produs;
        this.pret = pret;
        this.cantitate = cantitate;
        this.data_expirare = data_expirare;
    }

    public String getDenumire_produs() { return denumire_produs;}
    public float getPret() { return pret;}
    public int getCantitate() { return cantitate;}
    public LocalDate getData_expirare() { return data_expirare;}

    public void setDenumire_produs(String denumire_produs) { this.denumire_produs = denumire_produs;}
    public void setPret(float pret) { this.pret = pret;}
    public void setCantitate(int cantitate) { this.cantitate = cantitate;}
    public void setData_expirare(LocalDate data_expirare) { this.data_expirare = data_expirare;}

    public void vinde(int cantitate_vanduta)
    {
        if(cantitate_vanduta <= cantitate)
        {
            cantitate -= cantitate_vanduta;
            incasari += cantitate_vanduta;
        }

        if(cantitate == 0)
        {
            System.out.println("Produsul " + denumire_produs + " a ajuns la cantitate 0 si va fi eliminat din lista!");
        }
        else
        {
            System.out.println("Nu exista suficient stoc pentru a vinde " + cantitate_vanduta + " unitati de produs " + denumire_produs);
        }
    }

    @Override
    public String toString() {
        return "Produs [denumire_produs=" + denumire_produs + ", pret=" + pret + ", cantitate=" + cantitate
                + ", data_expirare=" + data_expirare + "]";
    }


}
