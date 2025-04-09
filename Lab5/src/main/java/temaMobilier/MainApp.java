package temaMobilier;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void scriere (List<Mobilier> lista)
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/java/temaMobilier/mobilier.json");
            mapper.writeValue(file,lista);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static List<Mobilier> citire()
    {
        try
        {
            File file = new File("src/main/java/temaMobilier/mobilier.json");
            ObjectMapper mapper = new ObjectMapper();
            List<Mobilier> mobiliere = mapper.readValue(file, new TypeReference<List<Mobilier>>() {});
            return mobiliere;
        }
        catch (IOException e)
            {e.printStackTrace();}

        return null;
    }

    public static void main(String[] args) {
        //citim datele
        List<Mobilier> piese_mobilier = citire();

        //afisam elementele de mobilier din colectie si placile care le compun
        System.out.println("Elementele de mobilier din colectie");
        for(Mobilier m : piese_mobilier)
        {
            System.out.println(m.toString());
            for(Placi p : m.getPlaci())
                System.out.println(p.toString());
        }
        System.out.println("---------------------------------");

        //afiseaza caracteristicile placilor care compun o anumita piesa de mobilier
        System.out.println("Placile care compun mobilierul corp 1");
        for(Mobilier m : piese_mobilier)
        {
            if(m.getNume().equals("mobilier corp 1"))
            {
                System.out.println("mobilier corp 1");
                for(Placi p : m.getPlaci())
                {
                    //afisam detaliile
                    System.out.println(p.toString());
                }
            }
        }
        System.out.println("---------------------------------");

        //afiseaza estimativ nr colilor de pal necesare pt realizarea
        //unui anumit corp, stiind ca o coala de pal are dimensiunea
        //2800x2070 mm (pt simplitatea se va tine cont doar de arie, nu si de posibilitatea
        // de a reliza taieturile)
        System.out.println("Estimativ nr colilor de pal necesare pt realizarea unui corp");
        int lungimeCoala = 2800;
        int latimeCoala = 2070;
        int arieCoala = lungimeCoala*latimeCoala;

        for(Mobilier m : piese_mobilier)
        {
            int arieTotalaPlaci = 0;

            //calculam aria totala necesara pt mobilerul curent
            for(Placi p:m.getPlaci())
            {
                int ariePlaca = p.getLungime()*p.getLatime();
                arieTotalaPlaci += ariePlaca * p.getNr_bucati();
            }

            //calculam nr estimativ de colii de pal necesare
            double nrColile = (double)arieTotalaPlaci / arieCoala;
            int nrColiiEstimativ = (int)Math.ceil(nrColile);

            System.out.println(m.getNume() + " " + nrColiiEstimativ);
        }



    }
}
