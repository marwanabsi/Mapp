package application;

import java.util.ArrayList;

public class Vertix {
    public float h_scores;
    private String Name;
    private int x;
    private int y;

    ArrayList<Edge> adjacencies = new ArrayList();

    public Vertix parent;
    public Vertix(String name, int x, int y) {
        Name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return Name;
    }


}