package exercitiul2;

import javax.print.attribute.standard.RequestingUserName;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        //cream fisierul cantec_out.txt
        PrintStream out = new PrintStream("src/exercitiul2/cantec_out.txt");
        Scanner sc1 = new Scanner(new File("src/exercitiul2/cantec_in.txt"));

        int contor=0;
        while(sc1.hasNextLine())
        {
            contor++;
            sc1.nextLine();
        }

        Vers[] versuri = new Vers[contor];
        int index=0;
        //resetam sc1
        sc1 = new Scanner(new File("src/exercitiul2/cantec_in.txt"));
        while(sc1.hasNextLine())
        {
            String rand = sc1.nextLine();
            versuri[index] = new Vers(rand);
            index++;
        }

        Random random = new Random();

        //citim si procesam fiecare vers
        for(int i=0; i<index; i++)
        {
            Vers vers = versuri[i];
            String versText = vers.vers;

            //numaram cuvintele si vocalele
            int nrCuvinte = vers.numaraCuvinte(versText);
            int nrVocale=0;
            for(String cuvant: versText.split("\\s+"))
            {
                nrVocale += vers.nrVocale(cuvant);
            }

            String grupare = "star,";
            String versIncheiat = vers.seIncheieCuGrupare(versText,grupare)?"*":"";

            //generam un nr aleator inree 0 si 1
            double nrRandom = random.nextDouble();

            if(nrRandom<0.1)
            {
                versText = versText.toUpperCase();
            }

            //scriem versul
            out.println(versText + " (" + nrCuvinte + " cuvinte, " + nrVocale + " vocale) " + versIncheiat);
        }

        sc1.close();
        out.close();
    }
}
