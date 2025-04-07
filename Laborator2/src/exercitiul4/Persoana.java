package exercitiul4;

import java.time.LocalDate;
import java.time.Period;

public class Persoana {
    private String nume;
    private String cnp;
    private int varsta;

    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }
    public String getCnp() {
        return cnp;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    //metoda care calculeaza varsta pe baza cnp-uluo
    public int getVarsta() {
        //extragem data nasterii din cnp
        String cnpAn = cnp.substring(1, 3); // Anul nasterii (2 caractere)
        String cnpLuna = cnp.substring(3, 5); // Luna nasterii (2 caractere)
        String cnpZi = cnp.substring(5, 7); // Ziua nasterii (2 caractere)

        System.out.println("Luna extrasă: " + cnpLuna);

        //calculam anul nasterii
        int an = Integer.parseInt(cnpAn);
        int luna = Integer.parseInt(cnpLuna);
        int zi = Integer.parseInt(cnpZi);

        // Determinam secolul in functie de prima cifra a CNP-ului
        if (cnp.charAt(0) == '1' || cnp.charAt(0) == '2') {
            an += 1900;
        } else if (cnp.charAt(0) == '3' || cnp.charAt(0) == '4') {
            an += 1800;
        } else if (cnp.charAt(0) == '5' || cnp.charAt(0) == '6') {
            an += 2000;
        }

        //cream un obiect LocalDate pt data nasterii
        LocalDate dataNasterii = LocalDate.of(an,zi,luna);

        //obtinem data curenta
        LocalDate dataCurenta = LocalDate.now();

        //calculam varsta
        Period perioada = Period.between(dataNasterii, dataCurenta);
        return perioada.getYears();
    }

    @Override
    public String toString() {
        return nume + ", " + cnp + ", " + getVarsta();
    }
}
