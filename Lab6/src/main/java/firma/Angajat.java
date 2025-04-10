package firma;

import java.io.Serializable;
import java.time.LocalDate;

public class Angajat implements Serializable {
    private String nume;
    private String post;
    private LocalDate data_angajarii;
    private float salariul;

    //constructor cu parametrii
    public Angajat(String nume, String post, LocalDate data_angajarii, float salariul) {
        this.nume = nume;
        this.post = post;
        this.data_angajarii = data_angajarii;
        this.salariul = salariul;
    }

    //constructor fara parametrii
    public Angajat() {}

    //getere
    public String getNume() {
        return nume;
    }
    public String getPost() {
        return post;
    }
    public LocalDate getData_angajarii() {
        return data_angajarii;
    }
    public float getSalariul() {
        return salariul;
    }

    //setere
    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public void setData_angajarii(LocalDate data_angajarii) {
        this.data_angajarii = data_angajarii;
    }
    public void setSalariul(float salariul) {
        this.salariul = salariul;
    }

    @Override
    public String toString() {
        return "Angajat{" + "nume=" + nume + ", post=" + post + ", data_angajarii=" + data_angajarii + ", salariul=" + salariul + '}';
    }
}
