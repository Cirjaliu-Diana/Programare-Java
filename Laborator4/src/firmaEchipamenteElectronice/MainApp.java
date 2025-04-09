package firmaEchipamenteElectronice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    //metoda statica de serializare
    static void scrie(Object o, String fis)
    {
        try {
            FileOutputStream f = new FileOutputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    static Object citeste(String fis)
    {
        try{
            FileInputStream f = new FileInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o =ois.readObject();
            ois.close();
            f.close();
            return o;
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return null;
    }


    public static void main(String[] args) throws FileNotFoundException {
        List<Echipament> listaEchipamente = new ArrayList<Echipament>();
        Scanner sc = new Scanner(new File("src/firmaEchipamenteElectronice/electronice.txt"));

        //citim prima oara din fisier si adaugam in lista
        while(sc.hasNextLine()) {
            String[] detaliiEchipament = sc.nextLine().split(";");
            String denumire = detaliiEchipament[0];
            int nr_inv = Integer.parseInt(detaliiEchipament[1]);
            float pret = Float.parseFloat(detaliiEchipament[2]);
            String zona_mag= detaliiEchipament[3];
            String situatie = detaliiEchipament[4].toLowerCase();
            String tip_echipament = detaliiEchipament[5].toLowerCase();

            if(tip_echipament.equals("imprimanta"))
            {
                int ppm = Integer.parseInt(detaliiEchipament[6]);
                String rezolutie = detaliiEchipament[7];
                int p_car=Integer.parseInt(detaliiEchipament[8]);
                String mod_tiparire = detaliiEchipament[9].toLowerCase();
                Imprimanta imprimanta = new Imprimanta(denumire,nr_inv,pret,zona_mag,situatie,ppm,rezolutie,p_car,mod_tiparire);
                listaEchipamente.add(imprimanta);
            }
            else if(tip_echipament.equals("copiator"))
            {
                int p_ton = Integer.parseInt(detaliiEchipament[6]);
                String format_copiere= detaliiEchipament[7];
                Copiator copiator = new Copiator(denumire,nr_inv,pret,zona_mag,situatie,p_ton,format_copiere);
                listaEchipamente.add(copiator);
            }
            else if(tip_echipament.equals("sistem de calcul"))
            {
                String tip_mon=detaliiEchipament[6];
                float vit_proc=Float.parseFloat(detaliiEchipament[7]);
                int c_hdd=Integer.parseInt(detaliiEchipament[8]);
                String sistem_operare=detaliiEchipament[9].toLowerCase();
                SistemDeCalcul sistemDeCalcul = new SistemDeCalcul(denumire,nr_inv,pret,zona_mag,situatie,tip_mon,vit_proc,c_hdd,sistem_operare);
                listaEchipamente.add(sistemDeCalcul);
            }
        }

        //resetam scanerul
        sc = new Scanner(System.in);

        boolean meniu = true;

        while (meniu)
        {
            System.out.println("\n1.Afisarea tuturor echipamentelor");
            System.out.println("2.Afisarea imprimantelor");
            System.out.println("3.Afisarea copiatoarelor");
            System.out.println("4.Afisarea sistemelor de calcul");
            System.out.println("5.Modificarea starii unui echipament");
            System.out.println("6.Setarea unui format de copiere pentru copiatoare");
            System.out.println("7.Instalarea unui sistem de operare pe un sistem de calcul");
            System.out.println("8.Afisarea echipamanetelor vandute");
            System.out.println("9.Serializare colectiei de obiecte");
            System.out.println("10.Dezserializare colectiei de obiecte");
            System.out.println("11.Iesire");

            System.out.println("Introduceti o optiune: ");
            String optiune = sc.nextLine();
            int opt = Integer.parseInt(optiune);

            switch (opt)
            {
                case 1:
                    //afisarea tuturor echipamentelor
                    for(Echipament echipament : listaEchipamente)
                        System.out.println(echipament.toString());
                    break;
                case 2:
                    //afiasrea imprimantelor
                    System.out.println("Imprimantele:");
                    for(Echipament echipament : listaEchipamente)
                    {
                        if(echipament instanceof Imprimanta)
                            System.out.println(echipament.toString());;
                    }
                    break;
                case 3:
                    //afisarea copiatoarelor
                    System.out.println("Copiatoarele:");
                    for(Echipament echipament : listaEchipamente)
                    {
                        if(echipament instanceof Copiator)
                            System.out.println(echipament.toString());;
                    }
                    break;
                case 4:
                    //afisarea sistemelor de calcul
                    System.out.println("Sistemele de calcul:");
                    for(Echipament echipament : listaEchipamente)
                    {
                        if(echipament instanceof SistemDeCalcul)
                            System.out.println(echipament.toString());;
                    }
                    break;
                case 5:
                    //modificarea starii in care se afla un echipament
                    System.out.println("Introduceti denumirea echipamentului caruia doriti sa ii modificati situatia:");
                    String denumire_echipament = sc.nextLine();
                    System.out.println("Introduceti noua situatie: ");
                    String situatie_echipament = sc.nextLine();
                    boolean gasit=false;

                    //verificam daca situatia e valida
                    Situatie situatieNoua;
                    try {
                        situatieNoua = Situatie.valueOf(situatie_echipament.toLowerCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Situatia introdusa este invalida!");
                        break;
                    }


                    for(Echipament echipament : listaEchipamente)
                    {
                        if(echipament.getDenumire().equals(denumire_echipament))
                        {
                            echipament.setSituatie(situatie_echipament);
                            gasit=true;
                        }
                    }

                    if(!gasit)
                        System.out.println("Echipamentul introdus nu exista!");
                    else
                        System.out.println("Situatia e modificata cu succes!");
                    break;
                case 6:
                    //setarea unui format de copiere pt copiatoare
                    System.out.println("Introduceti formatul de copiere pe care doriti sa il setati:");
                    String format_copiere = sc.nextLine().toUpperCase();
                    boolean gasitCopiator =false;

                    //verificam daca formatul este valid
                    FormatDeCopiere formatDeCopiere;
                    try
                    {
                        formatDeCopiere = FormatDeCopiere.valueOf(format_copiere);
                    } catch (IllegalArgumentException e)
                    {
                        System.out.println("Formatul introdus este invalid!");
                        break;
                    }

                    for(Echipament echipament : listaEchipamente)
                    {
                        if(echipament instanceof Copiator)
                        {
                            //downcast la tipul copiator
                            Copiator copiator =(Copiator) echipament;
                            copiator.setFormat_copiere(format_copiere);
                            gasitCopiator =true;
                            System.out.println("Formatul de copiere a fost setat cu succes pentru " + copiator.getDenumire());
                        }
                    }

                    if(!gasitCopiator)
                        System.out.println("Nu exista niciun copaitor in lista");
                    break;
                case 7:
                    //instalarea unui sistem de operare pe un sistem de calcul
                    System.out.println("Introduceti denumirea sistemului de calcul pe care doriti sa instalati sistemul de operare:");
                    String denumire_sistem_de_calcul = sc.nextLine();
                    System.out.println("Introduceti sistemul de operare pe care doriti sa il instalati:");
                    String sistem_operare = sc.nextLine().toLowerCase();
                    boolean gasitSistemDeCalcul=false;

                    //verificam daca este un sistem valid
                    SistemeDeOperare sistemDeOperare;
                    try
                    {
                        sistemDeOperare = SistemeDeOperare.valueOf(sistem_operare);
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out.println("Sistemul introdus este invalid!");
                        break;
                    }

                    for(Echipament echipament : listaEchipamente)
                    {
                        if(echipament.getDenumire().equals(denumire_sistem_de_calcul) && echipament instanceof SistemDeCalcul)
                        {
                            SistemDeCalcul sistemDeCalcul = (SistemDeCalcul) echipament;
                            sistemDeCalcul.setSistemDeOperare(sistem_operare);
                            gasitSistemDeCalcul=true;
                            System.out.println("Sistemul de operare a fost instalat cu succes pentru " + sistemDeCalcul.getDenumire());
                        }
                    }

                    if(!gasitSistemDeCalcul)
                        System.out.println("Nu exista niciun sistem de calcul in lista");
                    break;
                case 8:
                    //afisarea echipamentelor vandute
                    System.out.println("Echipamentele vandute sunt:");
                    for (Echipament echipament : listaEchipamente)
                    {
                        if(echipament.getSituatie().equals(Situatie.vandut))
                            System.out.println(echipament.toString());
                    }
                    break;
                case 9:
                    //serializarea colectiei de obiecte intr-un fisier echip.bin
                    scrie(listaEchipamente, "src/firmaEchipamenteElectronice/echip.bin");
                    break;
                case 10:
                    //deserializarea colectiei de obiecte
                    listaEchipamente = (List<Echipament>) citeste("src/firmaEchipamenteElectronice/echip.bin");
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
