package application;

public class Edge {
    private int cost;
    private Vertix target;

    private Vertix from;


    Edge(Vertix from, Vertix targetNode, int costVal) {
        target = targetNode;
        cost = costVal;
        this.from = from;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {

        this.cost = cost;
    }

    public Vertix getTarget() {
        return target;
    }

    public void setTarget(Vertix target) {
        this.target = target;
    }

    public Vertix getFrom() {
        return from;
    }

    public void setFrom(Vertix from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "cost=" + cost +
                ", from='" + from + '\'' +
                ", target=" + target +
                '}';
    }
}