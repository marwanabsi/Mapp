package application;

public class Edge {
    private  int cost;
    public String target;

    Edge(String targetNode, int costVal){
        target = targetNode;
        cost = costVal;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "cost=" + cost +
                ", target='" + target + '\'' +
                '}';
    }
}