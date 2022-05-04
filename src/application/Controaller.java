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
        for (int i = 0; i < Driver.virtexies.size(); i++) {
            printCity(Driver.virtexies.get(i).getName(), Driver.virtexies.get(i).getX(), Driver.virtexies.get(i).getY());
            from.getItems().add(Driver.virtexies.get(i));
            target.getItems().add(Driver.virtexies.get(i));
        }
    }


    public void printCity(String name, int x, int y) {


        Label label = new Label(name);
        label.setLayoutX(x);
        label.setLayoutY(y);

        Circle circle = new Circle(x, y, 3);

        circle.setFill(Color.BLUE);

        map.getChildren().addAll(circle, label);
        map.setDisable(true);

    }

    @FXML
    void Find(ActionEvent event) {
        //int count = 0;

        PriorityQueue<QueuNodeee> queuee = new PriorityQueue<>();
        boolean teargetDone = true;
        fromA = from.getValue();
        toB = target.getValue();
        setheursticValue();


        Vertix minV = fromA;
//        System.out.println("X for fromA is = "+fromA.getX()+" Y for fromA is = "+fromA.getY());
//        System.out.println("X for toB is = "+toB.getX()+" Y for toB is = "+toB.getY());
        int disCounter=0;
        int totalee=0;
        while (teargetDone) {
            //System.out.println(minV.adjacencies.toString());
            Edge x = minimumEdge(minV);
            disCounter+= x.getCost();
            x.setCost(+disCounter);

            //System.out.println("Targeeeeet "+ minimumEdge(minV).getTarget().getName());
            //System.out.println("To B testtttt = "+toB.getName());
            System.out.println(" ---> " + minimumEdge(minV));
            System.out.println("The Cost From "+x.getFrom() +" is = "+x.getCost());
            if (minimumEdge(minV).getTarget().getName().equalsIgnoreCase(toB.getName())){
                teargetDone=false;

                break;
            }

            totalee=  disCounter+ minV.getH_scores();
            QueuNodeee m = new QueuNodeee(minV,totalee);
            queuee.add(m);



            for (int i = 0; i < Driver.virtexies.size(); i++) {

                // System.out.println("disCount ===== "+disCounter);
                if (Driver.virtexies.get(i).getName().equals(x.getTarget().getName())) {
                    for (int j = 0; j < Driver.virtexies.get(i).adjacencies.size(); j++) {
                        if (!(Driver.virtexies.get(i).adjacencies.get(j).getTarget().getName()).equalsIgnoreCase(Driver.virtexies.get(i).getName()))
                            minV = Driver.virtexies.get(i);

                        break;
                    }
                }
            }
        }//end While
        System.out.println(queuee.toString());


    }

    //Find The Minimum Edge
    public Edge minimumEdge(Vertix x) {
        Edge min = null;
        int max = 900000;
        for (int i = 0; i < x.adjacencies.size(); i++) {
//            System.out.println("herostic = "+(x.adjacencies.get(i).getCost()+x.adjacencies.get(i).getTarget().getH_scores()) +" and Edge = "+
//                    x.adjacencies.get(i).getTarget().getName());
            if ((x.adjacencies.get(i).getCost()+x.adjacencies.get(i).getTarget().getH_scores()) < max) {
                max = (int) (x.adjacencies.get(i).getCost()+x.adjacencies.get(i).getTarget().getH_scores());
                min = x.adjacencies.get(i);
            }
        }
        return min;
    }



    public static int heuristic(int x1, int y1, int x2, int y2) {
        int x = Math.abs(x1 - x2);
        int y = Math.abs(y1 - y2);

        return x + y;
    }

    public void setheursticValue() {
        for (int i = 0; i < Driver.virtexies.size(); i++) {
            int heuristic = heuristic(Driver.virtexies.get(i).getX(), Driver.virtexies.get(i).getY(), toB.getX(), toB.getY());
            Driver.virtexies.get(i).setH_scores(heuristic);

        }
    }


}


