package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class Driver extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            Scene scene =  new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void ReadFiles(){
        try {
            Scanner inScanner = new Scanner(new File("vectors.txt"));

            while (inScanner.hasNext()) {
                String[] loc = inScanner.nextLine().split("#");
                System.out.println(Integer.valueOf(loc[1].trim()));
            }
            inScanner.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReadFiles();

       // launch(args);
    }
}
