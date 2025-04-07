package exercitiul1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("src/exercitiul1/judete_in.txt"));
        Scanner sc2 = new Scanner(System.in);

        //numaram cate linii sunt in fisier
        int nrLinii = 0;
        while(sc1.hasNextLine()) {
            nrLinii++;
            sc1.nextLine();
        }

        //reinitializam scannerul
        sc1 = new Scanner(new File("src/exercitiul1/judete_in.txt"));

        //cream tabloul de stringuri
        String[] judete = new String[nrLinii];

        //citim efectiv judetele si le stocam in tablou
        int index=0;
        while(sc1.hasNextLine())
        {
            judete[index] = sc1.nextLine();
            index++;
        }

        //sortam judetele cu metoda sort din clasa Arrays
        sort(judete);

        System.out.println("Introduceti judetul dorit:");
        String judet = sc2.nextLine();

        System.out.println("Judetul dorit este: " + judet + " si se afla pe pozitia: " + binarySearch(judete, judet));

        sc1.close();
        sc2.close();
    }
}
