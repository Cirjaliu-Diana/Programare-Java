package exercitiul3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dati primul sir de caractere: ");
        StringBuilder sir = new StringBuilder(sc.nextLine());
        System.out.println("Dati sirul de caractere pe care doriti sa-l inserati: ");
        String sirDeInserati = sc.nextLine();

        //citim pozitia de la care vrem sa inseram
        System.out.println("Dati pozitia de la care vreti sa inserati sirul: ");
        int poz= sc.nextInt();
        sir.insert(poz,sirDeInserati);
        System.out.println("Sirul cu inserari: " + sir);

        System.out.println("Dati poztia de incepu stergerea:");
        int pozStergere = sc.nextInt();
        System.out.println("Introduceti nr de caractere pe care doriti sa le stergeti: ");
        int nrCaractere = sc.nextInt();
        sir.delete(pozStergere,pozStergere+nrCaractere);
        System.out.println("Sirul cu stergerea: " + sir);

        sc.close();
    }
}
