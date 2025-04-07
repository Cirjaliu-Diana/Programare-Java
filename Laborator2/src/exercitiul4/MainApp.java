package exercitiul4;

import java.util.Scanner;

public class MainApp {
    public static boolean cnpValid(String cnp)
    {
        //verificam daca are 13 caractere
        if(cnp.length()!=13)
            return false;

        //verificam daca toate caracterele sunt cifre
        if(!cnp.matches("[0-9]+"))
            return false;

        //verificam ca prima cifra sa fie 1,2,5,6
        if(cnp.charAt(0)!='1' && cnp.charAt(0)!='2' && cnp.charAt(0)!='5' && cnp.charAt(0)!='6')
            return false;

        //verificam cifra judetului
        if (Integer.parseInt(cnp.substring(7, 9)) <= 0 || Integer.parseInt(cnp.substring(7, 9)) > 52) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dati nr de persoane pe care doriti sa le introduceti: ");
        int n= sc.nextInt();
        sc.nextLine();

        int index=0;
        while(index<n)
        {
            System.out.println("Dati nume");
            String nume = sc.nextLine();
            System.out.println("Dati cnp");
            String cnp = sc.nextLine();

            if(cnpValid(cnp))
            {
                Persoana p = new Persoana(nume,cnp);
                p.toString();
                System.out.println(p);
                index++;
            }
            else {
                System.out.println("CNP incorect!");
                continue;
            }
        }
    }
}
