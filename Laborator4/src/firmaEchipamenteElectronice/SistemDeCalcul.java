package firmaEchipamenteElectronice;

public class SistemDeCalcul extends Echipament{
    private String tip_mon;
    private float vit_proc;
    private int c_hdd;
    private SistemeDeOperare sistemDeOperare;

    //constructor

    public SistemDeCalcul(String denumire, int nr_inv, float pret, String zona_mag, String situatie,String tip_mon,float vit_proc,int c_hdd,String sistemDeOperare) {
        super(denumire, nr_inv, pret, zona_mag, situatie);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistemDeOperare = SistemeDeOperare.valueOf(sistemDeOperare);
    }

    //getere
    public String getTip_mon() {
        return tip_mon;
    }
    public float getVit_proc() {
        return vit_proc;
    }
    public int getC_hdd() {
        return c_hdd;
    }

    public SistemeDeOperare getSistemDeOperare() {
        return sistemDeOperare;
    }

    //setere
    public void setTip_mon(String tip_mon) {
        this.tip_mon = tip_mon;
    }
    public void setVit_proc(float vit_proc) {
        this.vit_proc = vit_proc;
    }
    public void setC_hdd(int c_hdd) {
        this.c_hdd = c_hdd;
    }

    public void setSistemDeOperare(String sistemDeOperare) {
        this.sistemDeOperare = SistemeDeOperare.valueOf(sistemDeOperare);
    }

    @Override
    public String toString() {
        return super.toString()+"SistemDeCalcul{" +
                "tip_mon='" + tip_mon + '\'' +
                ", vit_proc=" + vit_proc +
                ", c_hdd=" + c_hdd +
                ", sistemDeOperare=" + sistemDeOperare +
                '}';
    }
}
