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

public class Controaller {

    @FXML
    private Button exit;

    @FXML
    private Button filesBtn;

    @FXML
    private Button find;

    @FXML
    private ChoiceBox<?> from;

    @FXML
    private TextField maxwidth;

    @FXML
    private TextField path;

    @FXML
    private ChoiceBox<?> target;

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

    }


}
