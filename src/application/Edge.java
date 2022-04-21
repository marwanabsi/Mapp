package application;

public class Edge {
    double cost;
    String start;
    String end;
    public Edge( String start, String end,double cost2) {
        super();
        this.cost = cost2;
        this.start = start;
        this.end = end;
    }
    public Edge() {
        super();
        // TODO Auto-generated constructor stub
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    @Override
    public String toString() {
        return "Edge [cost=" + cost + ", start=" + start + ", end=" + end + "]";
    }

}