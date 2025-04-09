package lucrareLab;

import java.io.Serializable;

public class PerecheNumere implements Serializable {
    private int a;
    private int b;

    public PerecheNumere(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public PerecheNumere(){}

    //getere
    public int getA() { return a; }
    public int getB() { return b; }

    //setere
    public void setA(int a) { this.a = a; }
    public void setB(int b) { this.b = b; }

    @Override
    public String toString() {
        return "PerecheNumere{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public boolean suntNrConsecutiveInFib()
    {
        if(a>b)
        {
            int temp = a;
            a = b;
            b = temp;
        }

        int x=0,y=1;
        while(b<=y)
        {
            if(x==a || y==b) return true;
            int z = x+y;
            x=y;
            y=z;
        }

        return false;
    }

    //cel mai mare divizor comun
    public static int cmmdc(int a, int b)
    {
        while(b!=0)
        {
            int r = a%b;
            a=b;
            b=r;
        }

        return a;
    }

    //cel mai mic multiplu acum
    public int cmmc()
    {
        return a*b/cmmdc(a,b);
    }

    //metoda care calculeaza suma cifrelor unui nr
    public static int sumaCrife(int n)
    {
        n=Math.abs(n);
         int suma=0;
         while(n>0)
         {
             suma+=n%10;
             n/=10;
         }

         return suma;
    }

    //verifica daca cele 2 nr au aceeasi suma a cifrelor
    public boolean suntCuAcelasiSumaCifre()
    {
        return sumaCrife(a)==sumaCrife(b);
    }

    //metoda are returneaza nr de cifre pare
    public static int nrCifrePare(int n)
    {
        n=Math.abs(n);
        int nr=0;
        while(n>0)
        {
            if(n%10%2==0) nr++;
            n/=10;
        }

        return nr;
    }

    //verificam daca ambele nr au nr de cifre pare egal
    public boolean suntCuNrCifrePare()
    {
        return nrCifrePare(a)==nrCifrePare(b);
    }



}
