package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

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

    }

    @FXML
    void Find(ActionEvent event) {

    }


}
