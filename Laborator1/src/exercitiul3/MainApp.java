package exercitiul3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dati n:");
        int n = sc.nextInt();
        int contor=0;

        //parcrgem toate nr pana la n
        for(int i=1; i<=n; i++)
        {
            //verificam daca sunt divizori si ii afisam
            if(n%i==0)
            {
                contor++;
                System.out.println(i);
            }
        }

        if(contor==2)
        {
            System.out.println("Nr "+n +" este prim");
        }

        sc.close();
    }
}
