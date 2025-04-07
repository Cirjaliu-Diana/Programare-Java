package exercitul5;

import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(21);

        System.out.println("Nr: " + n);

        //un nr apartine sirul fibonacci daca
        //5n^2+4 sau 5n^2-4 e patrat perfect

        int exp1 = 5*n*n + 4;
        int exp2 = 5*n*n - 4;

        int sqrt1= (int) Math.sqrt(exp1);
        int sqrt2= (int) Math.sqrt(exp2);

        if(sqrt1*sqrt1==exp1 || sqrt2*sqrt2==exp2)
            System.out.println("Numarul este un nr in sirul fibonacci");
        else
            System.out.println("Numarul nu este un nr in sirul fibonacci");

    }
}
