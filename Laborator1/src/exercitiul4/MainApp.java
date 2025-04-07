package exercitiul4;

import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        Random rand = new Random();
        int n1 = rand.nextInt(31);
        int n2 = rand.nextInt(31);
        System.out.println("Nr 1: " + n1 + " Nr 2: " + n2);

        int minDiv=-1;
        for(int i=2;i<=Math.min(n1,n2);i++)
        {
            if(n1%i==0 & n2%i==0)
            {
                minDiv=i;
                break;
            }
        }

        if(minDiv==-1)
        {
            System.out.println("Cele 2 nr nu au niciun divizor comun");
        }
        else
        {
            System.out.println("CMMDC al celor 2 nr este: " + minDiv);
        }
    }
}
