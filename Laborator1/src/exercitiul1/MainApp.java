package exercitiul1;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.println("Introduceti lungimea:");
        int lungime = sc1.nextInt();

        System.out.println("Introduceti latimea:");
        int latime = sc2.nextInt();

        System.out.println("Perimetru este:" + (lungime + latime) * 2);
        System.out.println("Aria este: " + lungime * latime);

        sc1.close();
        sc2.close();
    }
}
