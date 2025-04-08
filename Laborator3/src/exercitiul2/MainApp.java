package exercitiul2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/exercitiul2/produse.csv"));
        List<Produs> produse = new ArrayList<Produs>();

        //citirea din fisier
        while (sc.hasNextLine()) {
            String[] detalii_produs = sc.nextLine().split(",");
            String denumire_produs = detalii_produs[0];
            float pret = Float.parseFloat(detalii_produs[1]);
            int cantitate = Integer.parseInt(detalii_produs[2]);
            LocalDate data_expirare = LocalDate.parse(detalii_produs[3]);
            Produs p = new Produs(denumire_produs, pret, cantitate, data_expirare);
            produse.add(p);
        }

        //resetam scannerul
        sc = new Scanner(System.in);
        boolean meniu = true;

        while (meniu) {
            System.out.println("\n1.Afisare produse");
            System.out.println("2.Afisarea produselor expirate");
            System.out.println("3.Vanzarea unui produs");
            System.out.println("4.Afisarea produselor cu pret minim");
            System.out.println("5.Salvarea produselor cu o cantitate mai mica decat cea data intr-un fisier");
            System.out.println("6.Iesire");

            System.out.println("Dati optiunea dorita:");
            int optiune = sc.nextInt();

            switch (optiune) {
                case 1:
                    //afisarea produselor
                    for (Produs p : produse) {

                        System.out.println(p.toString());
                    }
                    break;
                case 2:
                    //afisarea produselor expirate
                    System.out.println("Produsele expirate sunt:");
                    for (Produs p : produse) {
                        if (p.getData_expirare().isBefore(LocalDate.now())) {
                            System.out.println(p.toString());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Introduceti denumirea produsului pe care doriti sa-l cumparati:");
                    String denumire_produs = sc.next();
                    System.out.println("Introduceti cantitatea produsului pe care doriti sa-l cumparati:");
                    int cantitate = sc.nextInt();
                    boolean produsGasit = false;

                    for (Produs p : produse) {
                        if (p.getDenumire_produs().equals(denumire_produs)) {
                            p.vinde(cantitate);
                            produsGasit = true;

                            if (p.getCantitate() == 0)
                                produse.remove(p);

                            break;
                        }

                        if (!produsGasit)
                            System.out.println("Produsul introdus nu exista!");
                    }
                    break;
                case 4:
                    Produs produsMin = produse.get(0);
                    List<Produs> produseMinime = new ArrayList<Produs>();
                    produseMinime.add(produsMin);

                    for (Produs p : produse) {
                        if (p.getPret() < produsMin.getPret()) {
                            produsMin = p;
                            produseMinime.clear();  // Dacă găsim un preț mai mic, resetăm lista
                            produseMinime.add(p);  // Adăugăm acest produs în lista de produse minime
                        } else if (p.getPret() == produsMin.getPret()) {
                            produseMinime.add(p);  // Dacă prețul este egal cu cel mai mic, adăugăm produsul în listă
                        }
                    }

                    System.out.println("Produsele cu cel mai mic pret sunt:");
                    for (Produs p : produseMinime) {
                        System.out.println(p);  // Presupunând că ai implementat un `toString` corespunzător în clasa `Produs`
                    }
                    break;
                case 5:
                    PrintStream out = new PrintStream("src/exercitiul2/out.txt");
                    System.out.println("Dati cantitatea maxima a produselor care doriti sa fie salvate:");
                    int cantitateMax = sc.nextInt();

                    for (Produs p : produse) {
                        if (p.getCantitate() < cantitateMax) {
                            out.println(p.toString());
                        }
                    }

                    out.close();
                    break;
                case 6:
                    meniu = false;
                    break;
                default:
                    System.out.println("Optiunea introdusa este invalida!");
                    break;
            }
        }

        sc.close();
    }
}
