package firmaMobilier;

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
    public static void scriere(List<Mobilier> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/mobilier.json");
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Mobilier> citire() {
        try {
            File file=new File("src/main/resources/mobilier.json");
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Mobilier> mobiliere = mapper
                    .readValue(file, new TypeReference<List<Mobilier>>(){});
            return mobiliere;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        List<Placa> placiBirou=new ArrayList<Placa>();
//        placiBirou.add(new Placa("blat",1200,600,"lungime",new boolean[]{true,true,false,false},1));
//        placiBirou.add(new Placa("picior lateral",720,500,"latime",new boolean[]{true,false,false,true},2));
//
//        List<Placa> placiEtajera= new ArrayList<Placa>();
//        placiEtajera.add(new Placa("raft fix",800,300,"lungime",new boolean[]{true,true,false,false},4));
//        placiEtajera.add(new Placa("laterala",1800,300,"latime",new boolean[]{false,true,true,false},2));
//
//        List<Placa> placiDulap = new ArrayList<Placa>();
//        placiDulap.add(new Placa("usa",2000,500,"lungime",new boolean[]{true,true,true,true},2));
//        placiDulap.add(new Placa("capac",1000,600,"oricare",new boolean[]{true,false,true,false},1));
//        placiDulap.add(new Placa("raft mobil",900,500,"latime",new boolean[]{true,true,false,false},3));
//
//        List<Mobilier> mobiliere = new ArrayList<Mobilier>();
//        mobiliere.add(new Mobilier("Birou",placiBirou, LocalDate.of(2024, 4, 20)));
//        mobiliere.add(new Mobilier("Etajera",placiEtajera,LocalDate.of(2023, 7, 1)));
//        mobiliere.add(new Mobilier("Dulap", placiDulap, LocalDate.of(2024, 3, 16)));
//
//        scriere(mobiliere);

        List<Mobilier> listaMobilier = citire();
        Scanner scanner = new Scanner(System.in);

        boolean meniu = true;
        while(meniu)
        {
            System.out.println("\n1");
            System.out.println("2");
            System.out.println("3");
            System.out.println("4");
            System.out.println("5");
            System.out.println("6");
            System.out.println("7");
            System.out.println("8");
            System.out.println("9");
            System.out.println("10");

            System.out.println("Dati optiune: ");
            String optiune = scanner.nextLine();
            int opt = Integer.parseInt(optiune);

            switch (opt)
            {
                case 1:
                    //afisare utilizand referinte la metode
                    listaMobilier.forEach(System.out::println);
                    break;
                case 2:
                    //afisam piesele de mobilie care au cel putin o placa de pal cu aria>2500.000
                    List<Mobilier> mobilierPlaciMari = listaMobilier
                            .stream()
                            .filter(mobilier -> mobilier.getPlaci().stream().anyMatch(placa -> placa.suprafata()>25000))
                            .collect(Collectors.toList());

                    mobilierPlaciMari.forEach(System.out::println);
                    break;
                case 3:
                    //cream o lista cu toate piesele de mobilier care contine in descriere capac sau usa
                    //si care au fost adagate intr-o anumita luna din an
                    List<Mobilier> listaCapacUsa = listaMobilier
                            .stream()
                            .filter(mobilier -> mobilier.getPlaci().stream().anyMatch(placa -> placa.getDescriere().contains("usa") ||
                                    placa.getDescriere().contains("capac")) &&
                                    mobilier.getData_adaugare().getMonth()== Month.MARCH)
                            .collect(Collectors.toList());
                    listaCapacUsa.forEach(System.out::println);
                    break;
                case 4:
                    //sa se afiseze placile de pla, fara canturi pe nicio latura, in ordine descrescatoare a suprafetei
                    listaMobilier
                            .stream()
                            .filter(mobilier -> mobilier.getPlaci().stream().anyMatch(placa -> Arrays.equals(placa.getCanturi(),new boolean[]{false,false,false,false})))
                            .sorted(Comparator.comparing((Mobilier m)->m.getPlaci().size()).reversed())
                            .forEach(System.out::println);
                    break;
                case 5:
                    listaMobilier
                            .stream()
                            .flatMap(mobilier -> mobilier.getPlaci().stream().map(placa -> placa.getDescriere().toUpperCase()))
                            .forEach(System.out::println);
                    break;
                case 6:
                    // sa se afiseze doar suprafetele placilor cu o suprafata mai mica de 300000
                    listaMobilier
                            .stream()
                            .flatMap(mobilier -> mobilier.getPlaci().stream().filter(placa -> placa.suprafata()<300000))
                            .forEach(System.out::println);
                    break;
                case 7:
                    Optional<Mobilier> ceaMaiMicaSuprafata= listaMobilier
                            .stream()
                            .min(Comparator.comparing( mobilier ->
                                    mobilier.getPlaci().stream()
                                            .mapToInt(Placa::suprafata)
                                            .min()
                                            .orElse(Integer.MAX_VALUE)));

                   if(ceaMaiMicaSuprafata.isPresent())
                       System.out.println(ceaMaiMicaSuprafata.get());
                    break;
                case 8:
                    //statistica suprafetei placilor
                    DoubleSummaryStatistics statistics = listaMobilier
                            .stream()
                            .flatMap(mobilier -> mobilier.getPlaci().stream())
                                    .collect(Collectors.summarizingDouble(Placa::suprafata));

                    System.out.println(statistics.getMax());
                    System.out.println(statistics.getMin());
                    System.out.println(statistics.getAverage());
                    break;
                case 9:
                    //verificam daca exista cel putin o placa cu descriere raft mobil
                    Optional<Mobilier> raftMobil = listaMobilier
                            .stream()
                            .filter(mobilier -> mobilier.getPlaci().stream().anyMatch(placa -> placa.getDescriere().equals("raft mobil")))
                            .findAny();

                    raftMobil.ifPresentOrElse(mobilier -> System.out.println("Mobiier gasit" + mobilier),()
                    -> System.out.println());
                    break;
                case 10:
                    int pieseMobilieradaugateAnulTrecutVara = (int) listaMobilier
                            .stream()
                            .filter(mobilier -> mobilier.getData_adaugare().getYear()==LocalDate.now().getYear()-1 &&
                                    (mobilier.getData_adaugare().getMonth() == Month.AUGUST ||
                                            mobilier.getData_adaugare().getMonth()==Month.JUNE ||
                                            mobilier.getData_adaugare().getMonth()==Month.JULY))
                            .count();
                    break;
            }
        }
    }
}
