package firma;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {
    public static void scriere(List<Angajat> lista)
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            File file = new File("src/main/resources/angajati.json");
            mapper.writeValue(file,lista);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static List<Angajat> citire()
    {
        try
        {
            File file = new File("src/main/resources/angajati.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Angajat> angajati = mapper.readValue(file, new TypeReference<List<Angajat>>() {});
            return angajati;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
//        List<Angajat> lista = new ArrayList<Angajat>();
//        lista.add(new Angajat("Maria Popescu", "Contabil", LocalDate.of(2020, 5, 10), 1000));
//        lista.add(new Angajat("Ion Ionescu", "Director Programator", LocalDate.of(2019, 3, 15), 7500));
//        lista.add(new Angajat("Andreea Georgescu", "Manager", LocalDate.of(2018, 1, 20), 9500));
//        lista.add(new Angajat("George Petrescu", "Tehnician", LocalDate.of(2021, 7, 1), 2400));
//        lista.add(new Angajat("Ana Marinescu", "Sef Resurse Umane", LocalDate.of(2024, 4, 5), 4200));
//        scriere(lista);
//        System.out.println(citire());

        Scanner sc = new Scanner(System.in);
        List<Angajat> angajati = citire();
        for(Angajat angajat: angajati)
        {
            System.out.println(angajat.toString());
        }

        boolean meniu = true;
        while(meniu)
        {
            System.out.println("\n1.Afisarea listei de angajati folosind referinte la metode");
            System.out.println("2.Afisarea angajatilor care au salariul peste 2500");
            System.out.println("3.Crearea unei liste cu angajatii din luna aprilie, a anului trecut, care au functie de conducere");
            System.out.println("4.Afisarea angajatilor care nu au functie de conducere");
            System.out.println("5.Extragerea unei liste de String-uri care contine numele angajatilor scrise cu MAJUSCULE");
            System.out.println("6.Afisarea salariilor mai mici de 3000");
            System.out.println("7.Afisareaa datelor primului angajat al firmei");
            System.out.println("8.Afisarea de statistici referitoare la salariul angajatilor");
            System.out.println("9.Mesaje referitoare la Ion");
            System.out.println("10.Afisarea nr persoane care s-au angajat in vara anul precedent");
            System.out.println("11.Iesire");

            System.out.println("Introduceti o optiune: ");
            String optiune = sc.nextLine();
            int opt = Integer.parseInt(optiune);

            switch(opt)
            {
                case 1:
                    //afisarea listei de angajati folosind referinte la metode
                    angajati.forEach(System.out::println);
                    break;
                case 2:
                    //afisarea angajatilor care au salariul peste 2500
                    //vom utiliza stream-uri si interfata functionala Predicate,
                    //care este parametrul metodei de filtrare va di implemenetata printr-o functie Lambda
                    angajati
                            .stream()
                            .filter((a) -> a.getSalariul() > 2500)
                            .forEach(System.out::println);
                    break;
                case 3:
                    //crearea unei liste cu angajatii din luna aprilie, a anului trecut
                    //care au functie de conducere
                    //pt crearea unei liste dintr-un stream se va utiliza operatia
                    //terminala collect (Collectors,toList())
                    //Se vor utiliza stream-uri si expresii lamda. Noua lista va fi apoi
                    //afisata. Anul curent se va citi din ssitem

                    int anul_trecut = LocalDate.now().getYear() - 1;
                    List<Angajat> angajati_luna_aprilie = angajati
                            .stream()
                            .filter(a -> a.getData_angajarii().getYear()==anul_trecut &&
                                    a.getData_angajarii().getMonth()== Month.APRIL)
                            .collect(Collectors.toList());

                    System.out.println("Angajatii din luna aprilie, a anului trecut,care au functie de conducere, extrasi din lista angajatilor sunt:");
                    angajati_luna_aprilie.forEach(System.out::println);
                    break;
                case 4:
                    //afisarea angajatiilor care nu au functie de conducere
                    //in ordine descrescatoare a salariilor, folosind
                    //stream-uri si  expresii lambda
                    angajati
                            .stream()
                            .filter(a -> !a.getPost().contains("Sef") &&
                                    !a.getPost().contains("Director"))
                            .sorted(Comparator.comparing(Angajat::getSalariul).reversed())
                            .forEach(System.out::println);
                    break;
                case 5:
                    //extragere din lista de angajati a unei liste de Stringuri
                    //care contine numele angajatilor scrise cu majuscule
                    //rezolvarea va utiliza stream-uri, metoda map()
                    //si operatia terminala collect()
                    //lista de stringuri va fi afisata
                    List<String> angajatiMajuscule =
                            angajati.stream()
                                    .map(a -> a.getNume().toUpperCase())
                            .collect(Collectors.toList());

                    angajatiMajuscule.forEach(System.out::println);
                    break;
                case 6:
                    //afisarea salariilor <3000, folosind stream-uri
                    //expresii lambda, referinte la metode si map()
                    angajati
                            .stream()
                            .filter(a -> a.getSalariul() < 3000)
                            .map(Angajat::getSalariul)
                            .forEach(System.out::println);
                    break;
                case 7:
                    //afisarea datelor primului angajat al firmei
                    //minimul stream furnizand comparatorul adecvat
                    //printr-o expresie Lambda. Daca containerul Optional
                    //returnat de functia min() contine o valoare, atunci se
                    //va afisa acea valoare, altfel se va afisa un mesaj corespunzator
                    Optional<Angajat> primulAngajat =
                            angajati
                                    .stream()
                                    .min(Comparator.comparing(Angajat::getSalariul));

                    if(primulAngajat.isPresent())
                        System.out.println(primulAngajat.get());
                    else
                        System.out.println("Angajatul primului al firmei nu exista!");
                    break;
                case 8:
                    //afisarea de statistici referitoare la salariul angajatilor
                    //se va afisa salariul mediu, minimi si maxim
                    //rezolvarea va utiliza stream-uri si operatia terminala
                    //collect(Collectors. summarizingDouble())
                    DoubleSummaryStatistics statAngajati = angajati.stream()
                            .collect(Collectors.summarizingDouble(Angajat::getSalariul));

                    System.out.println("Salariul mediu este: " + statAngajati.getAverage());
                    System.out.println("Salariul minim este: " + statAngajati.getMin());
                    System.out.println("Salariul maxim este: " + statAngajati.getMax());
                    break;
                case 9:
                    //afisarea unor mesaje care indica daca printe angajati exista cel putin un Ion
                    //Rezolvarea va utiliza stream-uri si metoda findAny() care va returna
                    //un container Optional care poate sa contina un element sau nu
                    //metoda ifPresentOrElse din clasa Optional se va utiliza pt afisarea mesajelor
                    Optional<Angajat> ion = angajati.stream()
                            .filter(a -> a.getNume().contains("Ion"))
                            .findAny();

                    ion.ifPresentOrElse(
                            a -> System.out.println("Firma are cel putin un Ion angajat"),
                            ()-> System.out.println("Firma nu are niciun Ion angajat")
                    );
                    break;
                case 10:
                    //afisarea nr de persoane care s-au angajat in vara anului trecut
                    //se va utiliza metoda count() din intrefata stream
                    int anulTrecut = LocalDate.now().getYear() - 1;
                    int nrPersoane = (int) angajati
                            .stream()
                            .filter(a -> a.getData_angajarii().getYear()==anulTrecut &&
                                    (a.getData_angajarii().getMonth()==Month.JUNE ||
                                    a.getData_angajarii().getMonth()==Month.JULY ||
                                    a.getData_angajarii().getMonth()==Month.AUGUST))
                            .count();

                    System.out.println("Nr persoane angajate in vara anului trecut: " + nrPersoane);
                    break;
                case 11:
                    meniu = false;
                    break;
                default:
                    System.out.println("Optiune incorecta!");
                    break;
            }
        }
    }
}
