package firmaMobilier;

import java.util.Arrays;

public class Placa {
    private String descriere;
    private int lungime_mm;
    private int latime_mm;
    private Orientare orientare;
    boolean[] canturi = new boolean[4];
    private int nr_bucati;


    public Placa() {
    }

    public Placa(String descriere,int lungime_mm,int latime_mm,String orientare,boolean[] canturi,int nr_bucati) {

        this.descriere=descriere;
        this.lungime_mm=lungime_mm;
        this.latime_mm=latime_mm;

        try{
            this.orientare=Orientare.valueOf(orientare.toUpperCase());
        }catch (IllegalArgumentException e)
        {
            System.out.println("Valoare incorecta pentru orientare");
        }

        this.canturi = canturi;
        this.nr_bucati=nr_bucati;
    }

    //getere

    public String getDescriere() {
        return descriere;
    }

    public int getLungime_mm() {
        return lungime_mm;
    }

    public int getLatime_mm() {
        return latime_mm;
    }

    public Orientare getOrientare() {
        return orientare;
    }

    public boolean[] getCanturi() {
        return canturi;
    }

    public int getNr_bucati() {
        return nr_bucati;
    }

    //setere

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setLungime_mm(int lungime_mm) {
        this.lungime_mm = lungime_mm;
    }

    public void setLatime_mm(int latime_mm) {
        this.latime_mm = latime_mm;
    }

    public void setOrientare(String orientare) {
        try{
            this.orientare=Orientare.valueOf(orientare.toUpperCase());
        }catch (IllegalArgumentException e)
        {
            System.out.println("Valoare incorecta pentru orientare");
        }
    }

    public void setCanturi(boolean[] canturi) {
        this.canturi = canturi;
    }

    public void setNr_bucati(int nr_bucati) {
        this.nr_bucati = nr_bucati;
    }

    @Override
    public String toString() {
        return "Placa{" +
                "descriere='" + descriere + '\'' +
                ", lungime_mm=" + lungime_mm +
                ", latime_mm=" + latime_mm +
                ", orientare=" + orientare +
                ", canturi=" + Arrays.toString(canturi) +
                ", nr_bucati=" + nr_bucati +
                '}';
    }

    public int suprafata()
    {
        return lungime_mm*latime_mm;
    }

}
