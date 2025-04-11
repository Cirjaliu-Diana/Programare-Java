package subiect2;


import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Vapor implements Serializable {
    private String nume;
    private int numar_membrii_echipaj;
    private LocalDate data_lansarii_la_apa;
    private VitezeDeDeplasare viteza_deplasare;
    private List<Pasager> pasageri;

    //constructor
    public Vapor(String nume,int nr,LocalDate data,String vit,List<Pasager> pasageri)
    {
        this.nume=nume;
        this.numar_membrii_echipaj=nr;
        this.data_lansarii_la_apa=data;

        try
        {
            this.viteza_deplasare=VitezeDeDeplasare.valueOf(vit.toUpperCase());
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Valoare invalidă pentru viteza de deplasare: " + vit);
        }

        this.pasageri= pasageri;
    }

    public Vapor(){}

    //getere
    public String getNume(){ return nume;}
    public int getNrMembriiEchipaj(){ return numar_membrii_echipaj;}
    public LocalDate getDataLansariiLaApa(){ return data_lansarii_la_apa;}
    public VitezeDeDeplasare getVitDeplasare(){ return viteza_deplasare;}
    public List<Pasager> getPasageri(){ return pasageri;}

    //setere
    public void setNume(String nume){ this.nume=nume;}
    public void setNrMembriiEchipaj(int nr){ this.numar_membrii_echipaj=nr;}
    public void setDataLansariiLaApa(LocalDate data){ this.data_lansarii_la_apa=data;}
    public void setVitDeplasare(String vit){
        try
        {
            this.viteza_deplasare=VitezeDeDeplasare.valueOf(vit.toUpperCase());
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Valoare invalidă pentru viteza de deplasare: " + vit);
        }
    }
    public void setPasageri(List<Pasager> pasageri){ this.pasageri=pasageri;}

    @Override
    public String toString() {
        return "Vapor{" +
                "nume='" + nume + '\'' +
                ", numar_membrii_echipaj=" + numar_membrii_echipaj +
                ", data_lansarii_la_apa=" + data_lansarii_la_apa +
                ", viteza_deplasare=" + viteza_deplasare +
                ", pasageri=" + pasageri +
                '}';
    }

    public int nrAniDeLaLansare()
    {
        int an_curent = LocalDate.now().getYear();
        int an_lansare = data_lansarii_la_apa.getYear();
        return an_curent-an_lansare;
    }

    public int nrPasageri()
    {
        return pasageri.size();
    }

}
