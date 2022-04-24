package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.*;

public class Controaller {
    public static Vertix fromA;
    public static Vertix toB;
    @FXML
    private Button exit;

    @FXML
    private Button filesBtn;

    @FXML
    private Button find;

    @FXML
    private ChoiceBox<Vertix> from;

    @FXML
    private TextField maxwidth;

    @FXML
    private TextField path;

    @FXML
    private ChoiceBox<Vertix> target;

    @FXML
    private TextField time;

    @FXML
    private Pane map;

    @FXML
    void Exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void FilesUploud(ActionEvent event) {
       for(int i=0;i<Driver.virtexies.size();i++){
           printCity(Driver.virtexies.get(i).getName(),Driver.virtexies.get(i).getX(),Driver.virtexies.get(i).getY());
           from.getItems().add(Driver.virtexies.get(i));
           target.getItems().add(Driver.virtexies.get(i));
       }
    }


    public void printCity(String name, int x, int y) {
        Label label = new Label(name);
        label.setLayoutX(x);
        label.setLayoutY(y);

        Circle circle = new Circle(x , y , 3);

        circle.setFill(Color.BLUE);

        map.getChildren().addAll(circle, label);
        map.setDisable(true);

    }

    @FXML
    void Find(ActionEvent event) {
        fromA = from.getValue();
        toB = target.getValue();

        float heuristic = heuristic(fromA.getX(), fromA.getY(), toB.getX(), toB.getY());
        fromA.h_scores=heuristic;
       System.out.println(fromA.adjacencies.toString());
        //boolean targetDone=true;
        int count =0;
        //PriorityQueue<Vertix> queuee = new PriorityQueue<>();

        Vertix minV=fromA;

       while (count!=6){
           Edge x = minimumEdge(minV);
           if (x==null) {
               count=3;
               break;
           }
           System.out.println(" ---> "+minimumEdge(minV));
           for (int i =0;i<Driver.virtexies.size();i++){
                   if (Driver.virtexies.get(i).getName().equalsIgnoreCase(x.getTarget())) {
                       minV = Driver.virtexies.get(i);
                       break;
                   }
               }
           count++;
           //targetDone=false;

       }

        //#################################################################################
        //#################################################################################
        //#################################################################################


        //find minimum adgasint
        // do the correct path cost = mimom adjasmint + heroustic and add it in queue
        // every time add to queue compar the minimum value and go to it


        //#################################################################################
        //#################################################################################
        //#################################################################################
    }

    //Find The Minimum Edge
    public Edge minimumEdge(Vertix x){
        Edge min =null;
        int max=1000;
        for (int i =0;i<x.adjacencies.size();i++){
            if (x.adjacencies.get(i).getCost() < max){
                max=x.adjacencies.get(i).getCost();
                min =x.adjacencies.get(i);
            }
        }
        return min;
    }

    public static float heuristic(int x1,int y1,int x2,int y2){
        float x = (float) Math.abs(x1 - x2);
        float y = (float) Math.abs(y1 - y2);

        return x + y;
    }



}


