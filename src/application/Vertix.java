package application;

import java.util.ArrayList;

public class Vertix {
    public Vertix() {
        super();
        // TODO Auto-generated constructor stub
    }
    String name= new String();
    ArrayList<String> adj= new ArrayList<String>();
    int x,y;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<String> getAdj() {
        return adj;
    }
    public void setAdj(ArrayList<String> adj) {
        this.adj = adj;
    }
    public Vertix(String name, ArrayList<String> adj) {
        super();
        this.name = name;
        this.adj = adj;
    }
    public Vertix(String name) {
        super();
        this.name = name;
    }

    public Vertix(String name,int x,int y) {
        super();
        this.name = name;
        this.x=x;
        this.y=y;
    }
    @Override
    public String toString() {
        return "Vertix [name=" + name + ", adj=" + adj + "]";
    }

}