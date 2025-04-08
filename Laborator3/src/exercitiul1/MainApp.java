package exercitiul1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        List<Parabola> parabole = new ArrayList<Parabola>();
        Scanner sc = new Scanner(new File("src/exercitiul1/int.txt"));

        while(sc.hasNextLine())
        {
            String[] valori = sc.nextLine().split(" ");
            Parabola p = new Parabola(Integer.parseInt(valori[0]),Integer.parseInt(valori[1]),Integer.parseInt(valori[2]));
            parabole.add(p);
        }

        //afisarea parabolelor sub forma de functie + varf
        for(Parabola p : parabole)
        {
            System.out.println(p.toString());
            System.out.println(p.varfulParabolei());
        }

        //calculam pt primele 2 parabole citite
        for(int i = 0; i <2; i++)
        {
            for (int j = i + 1; j <2; j++)
            {
                Parabola p1 = parabole.get(i);
                Parabola p2 = parabole.get(j);

                System.out.println("Parabola 1: " + p1.toString());
                System.out.println("Parabola 2: " + p2.toString());
                System.out.println("Coordonatele mijlocului segmentului: " + Parabola.coordMijSeg(p1,p2));
                System.out.println("Lungimea segmentului care le uneste varfurile: " + Parabola.lungSegVarf(p1,p2));
            }
        }

        sc.close();
    }
}
