package exercitiul1;

public class Punct {
    private final int x;
    private final int y;
    public Punct(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int getX() { return x;}
    public int getY() { return y;}


    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
