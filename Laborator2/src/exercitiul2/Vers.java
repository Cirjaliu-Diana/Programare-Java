package exercitiul2;

public class Vers {
    String vers;

    public Vers(String vers) {
        this.vers = vers;
    }

    public int nrVocale(String cuvant) {
        int nrVocale = 0;
        for (int i = 0; i < cuvant.length(); i++) {
            char c = cuvant.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                nrVocale++;
            }
        }
        return nrVocale;
    }

    public int numaraCuvinte(String rand)
    {
        String[] cuvinte = rand.split("\\s+ ");

        return cuvinte.length;
    }

    public boolean seIncheieCuGrupare(String rand, String grupare)
    {
        String[] cuvinte = rand.split("\\s+ ");

        if(cuvinte[cuvinte.length-1].equals(grupare))
            return true;

        return false;
    }

}
