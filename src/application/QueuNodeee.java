package application;

public class QueuNodeee {
    private Vertix x;
    private int total;

    public QueuNodeee(Vertix x, int total) {
        this.x = x;
        this.total = total;
    }

    public Vertix getX() {
        return x;
    }

    public void setX(Vertix x) {
        this.x = x;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "QueuNode{" +
                "x=" + x +
                ", total=" + total +
                '}';
    }
}
