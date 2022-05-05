package application;

public class QueNode implements Comparable<QueNode>{
    private Vertix x;
    private int total;

    public QueNode(Vertix x, int total) {
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

    @Override
    public int compareTo(QueNode o) {
        return this.total - o.getTotal();
    }
}
