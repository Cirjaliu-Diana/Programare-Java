package subiect2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainApp {
    public static void scriere(List<Vapor> lista){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            File file = new File("src/main/resources/vapoare.json");
            mapper.writeValue(file,lista);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static List<Vapor> citire()
    {
        try{
            File file = new File("src/main/resources/vapoare.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Vapor> vapoare = mapper. readValue(file, new TypeReference<List<Vapor>>(){});
            return vapoare;
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args)
    {
//        //prima oara cream lista ca sa scrie in fisier
//        Pasager pasager1 = new Pasager("Ion Popescu", 25);
//        Pasager pasager2 = new Pasager("Maria Ionescu", 34);
//        Pasager pasager3 = new Pasager("Andrei Georgescu", 28);
//        Pasager pasager4 = new Pasager("Elena Vasilescu", 42);
//        Pasager pasager5 = new Pasager("Vasile Dumitru", 55);
//
//        // Creăm lista de pasageri pentru fiecare vapor
//        List<Pasager> pasageri= new ArrayList<Pasager>();
//        pasageri.add(pasager1);
//        pasageri.add(pasager2);
//        pasageri.add(pasager3);
//        pasageri.add(pasager4);
//        pasageri.add(pasager5);
//
//        //cream lista Vapor
//        List<Vapor> listaVapoare = new ArrayList<>();
//        Vapor vapor1 = new Vapor("Vapor 1", 50, LocalDate.of(2023, 5, 15), "mare", pasageri);
//        Vapor vapor2 = new Vapor("Vapor 2", 60, LocalDate.of(2022, 7, 10), "medie", pasageri);
//        Vapor vapor3 = new Vapor("Vapor 3", 20, LocalDate.of(2024, 1, 22), "mare", pasageri);
//        Vapor vapor4 = new Vapor("Vapor 4", 30, LocalDate.of(2023, 3, 5), "mica", pasageri);
//        Vapor vapor5 = new Vapor("Vapor 5", 25, LocalDate.of(2021, 8, 30), "medie", pasageri);
//        listaVapoare.add(vapor1);
//        listaVapoare.add(vapor2);
//        listaVapoare.add(vapor3);
//        listaVapoare.add(vapor4);
//        listaVapoare.add(vapor5);
//
//
//        scriere(listaVapoare);

        Scanner scanner = new Scanner(System.in);
        List<Vapor> listaVapoare = citire();
        System.out.println(listaVapoare);
        boolean meniu=true;

        while (meniu)
        {
            System.out.println("\n1.Afisare colectie folosind referinta la metode");
            System.out.println("2.Cati ani au trecut de la lansarea vapoarelor");
            System.out.println("3.Afisarea vapoarelor cu un anumit nr de pasageri, care au fost lansati in ultimii nr_ani");
            System.out.println("4.Iesire");

            System.out.println("Introduceti o optiune: ");
            String optiune = scanner.nextLine();
            int opt = Integer.parseInt(optiune);

            switch (opt)
            {
                case 1:
                    listaVapoare.forEach(System.out::println);
                    break;
                case 2:
                    for(Vapor v : listaVapoare)
                    {
                        System.out.println(v.getNume() + " " + v.nrAniDeLaLansare());
                    }
                    break;
                case 3:
                    int an_curent = LocalDate.now().getYear();
                    List<Vapor> vapors =
                            listaVapoare
                                    .stream()
                                    .filter(vapor -> vapor.nrPasageri()==5 &&
                                            vapor.nrAniDeLaLansare()<=2)
                                    .collect(Collectors.toList());
                    for(Vapor v : vapors)
                        System.out.println(v.toString());
                    break;
                case 4:
                    meniu=false;
                    break;
            }

        }
    }




}
