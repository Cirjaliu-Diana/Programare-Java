package exercitiul1;

public class Parabola {
    private int a;
    private int b;
    private int c;

    //constructor
    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //o metoda care calculeaza si returneaza varful parabolei
    public Punct varfulParabolei()
    {
        int x = -b / (2 * a);
        int y = (-b * b + 4 * a * c) / (4 * a);
        Punct p = new Punct(x,y);
        return p;
    }

    //redefinire toString ca sa se returneze
    //sub forma de f(x)= a*x^2 + bx +c
    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + b + "x + " + c;
    }

    public Punct coordonateleMijSeg(Parabola p)
    {
        Punct[] coordonate = new Punct[2];
        coordonate[0] = this.varfulParabolei();
        coordonate[1] = p.varfulParabolei();
        int x = (coordonate[0].getX() + coordonate[1].getX())/2;
        int y = (coordonate[0].getY() + coordonate[1].getY())/2;

        return new Punct(x,y);
    }

    //la fel ca metoda anterioara, doar ca statica si cu 2 parametri de intrare
    public static Punct coordMijSeg(Parabola p1, Parabola p2)
    {
        Punct[] coordonate = new Punct[2];
        coordonate[0] = p1.varfulParabolei();
        coordonate[1] = p2.varfulParabolei();
        int x = (coordonate[0].getX() + coordonate[1].getX())/2;
        int y = (coordonate[0].getY() + coordonate[1].getY())/2;

        return new Punct(x,y);
    }

    public int lungimeSegVarf(Parabola p)
    {
        Punct[] coordonate = new Punct[2];
        coordonate[0] = this.varfulParabolei();
        coordonate[1] = p.varfulParabolei();

        return (int) Math.hypot(coordonate[0].getX() - coordonate[1].getX(), coordonate[0].getY() - coordonate[1].getY());
    }

    public static int lungSegVarf (Parabola p1, Parabola p2)
    {
        Punct[] coordonate = new Punct[2];
        coordonate[0] = p1.varfulParabolei();
        coordonate[1] = p2.varfulParabolei();

        return (int) Math.hypot(coordonate[0].getX() - coordonate[1].getX(), coordonate[0].getY() - coordonate[1].getY());
    }



}
