package lucrareLab;

import java.io.Serializable;

public class Persoana implements Serializable {
    private String nume;
    private int varsta;

    public Persoana(String nume, int varsta) {
        super();
        this.nume = nume;
        this.varsta = varsta;
    }

    public Persoana(){}

    public String getNume() {  return nume; }
    public int getVarsta() { return varsta; }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                '}';
    }
}
