package exercitiul2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.Stream;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("src/exercitiul2/in.txt"));
        PrintStream out = new PrintStream("src/exercitiul2/out.txt");
        int suma = 0;
        float medie_aritmectica =0;
        int valMin=0;
        int valMax=0;
        int contor=0;

        //citirea din fisier
        while(sc1.hasNext())
        {
            int val = sc1.nextInt();
            contor++;
            suma += val;

            if(valMin==0 || val<=valMin)
                valMin=val;

            if(valMax==0 || val>=valMax)
                valMax=val;
        }

        medie_aritmectica = suma/contor;

        System.out.println("Suma este: " + suma);
        System.out.println("Medie aritmetica este: " + medie_aritmectica);
        System.out.println("Valoarea minim a numarului este: " + valMin);
        System.out.println("Valoarea maxim a numarului este: " + valMax);

        //scriem in fisier
        out.println("Suma este " +suma);
        out.println("Medie aritmetica este " +medie_aritmectica);
        out.println("Valoarea minim a numarului este " +valMin);
        out.println("Valoarea maxim a numarului este " +valMax);

        sc1.close();
        out.close();
    }
}
