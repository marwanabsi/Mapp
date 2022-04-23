package application;

import java.util.ArrayList;

public class AStar {
    private ArrayList<Vertix> virtexies;
    private ArrayList<Double> distance;
    private ArrayList<String> path;
    private ArrayList<Boolean> known;
    private ArrayList<Edge> via = new ArrayList<Edge>();
    int size;


    public AStar() {
        // TODO Auto-generated constructor stub
        this.distance = new ArrayList<Double>();
        this.path = new ArrayList<String>();
        this.virtexies = new ArrayList<Vertix>();
        this.known = new ArrayList<Boolean>();

    }

    public AStar(ArrayList<Vertix> virtex, ArrayList<Double> distance, ArrayList<String> path,
                    ArrayList<Boolean> known) {
        super();
        this.virtexies = virtex;
        this.distance = distance;
        this.path = path;
        this.size = virtex.size();
        this.known = known;
    }

    public ArrayList<Vertix> getVirtex() {
        return virtexies;
    }

    public void setVirtex(ArrayList<Vertix> virtex) {
        this.virtexies = virtex;
    }

    public ArrayList<Double> getDistance() {
        return distance;
    }

    public void setDistance(ArrayList<Double> distance) {
        this.distance = distance;
    }

    public ArrayList<String> getPath() {
        return path;
    }

    public void setPath(ArrayList<String> path) {
        this.path = path;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return " virtex=" + virtexies + "\n distance=" + distance + "\n path=" + path + "\n size=" + size;
    }

    public int returnIndexOfString(String str) {
        for (int i = 0; i < virtexies.size(); i++) {
            if (((Vertix) virtexies.get(i)).getName().compareTo(str) == 0)
                return i;
        }
        return -1;
    }

    public void insertAdj(String str1, String str2, double cost) {
//
//        int index = returnIndexOfString(str1);
//        if (index != -1) {
//            virtexies.get(index).adj.add(str2);
//            via.add(new Edge(str1, str2, cost));
//        }
    }

    public int returnIndexOfEdge(String start, String end) {
        for (int i = 0; i < via.size(); i++) {
            if (((Edge) via.get(i)).start.compareTo(start) == 0 && ((Edge) via.get(i)).end.compareTo(end) == 0)
                return i;
        }
        return -1;
    }
}
