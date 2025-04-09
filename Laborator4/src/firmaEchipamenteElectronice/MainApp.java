package firmaEchipamenteElectronice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        List<Echipament> listaEchipamente = new ArrayList<Echipament>();
        Scanner sc = new Scanner(new File("src/firmaEchipamenteElectronice/electronice.txt"));

        //citim prima oara din fisier si adaugam in lista
        while(sc.hasNextLine()) {
            
        }
    }
}
