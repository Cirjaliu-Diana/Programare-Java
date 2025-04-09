package lucrareLab;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainApp {

//    public static void scriere(List<Persoana> lista)
//    {
//        try
//        {
//            ObjectMapper mapper = new ObjectMapper();
//            File file = new File("src/main/java/lucrareLab/persoane.json");
//            mapper.writeValue(file,lista);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    public static List<Persoana> citire()
//    {
//        try
//        {
//            File file = new File("src/main/java/lucrareLab/persoane.json");
//            ObjectMapper mapper = new ObjectMapper();
//            List<Persoana> persoane = mapper.readValue(file, new TypeReference<List<Persoana>>() {});
//            return persoane;
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

    public static void scriere(List<PerecheNumere> lista)
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/java/lucrareLab/perechenumere.json");
            mapper.writeValue(file,lista);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static List<PerecheNumere> citire()
    {
        try
        {
            File file = new File("src/main/java/lucrareLab/perechenumere.json");
            ObjectMapper mapper = new ObjectMapper();
            List<PerecheNumere> perecheNumere = mapper.readValue(file, new TypeReference<List<PerecheNumere>>() {});
            return perecheNumere;
        }
        catch (IOException e)
            {e.printStackTrace();}

        return null;
    }


    public static void main(String[] args) {
        //modelul din laborator
//        List<Persoana> persoane = citire();
//        System.out.println(persoane);
//
//        for(Persoana p : persoane)
//            System.out.println(p);
//
//        persoane.add(new Persoana("Maria",33));
//        scriere(persoane);

    }

}
