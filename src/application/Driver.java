package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class Driver extends Application {
    static ArrayList<Vertix> virtexies = new ArrayList();
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
            Scanner inScanner = new Scanner(new File("src/vectors.txt"));

            while (inScanner.hasNext()) {
                String[] loc = inScanner.nextLine().split("#");
                Vertix x = new Vertix(loc[0], Integer.valueOf(loc[1].trim()), Integer.valueOf(loc[2].trim()));
                virtexies.add(x);
            }
            inScanner.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        File file = new File(".");
//        for(String fileNames : file.list()) System.out.println(fileNames);
        System.out.println(virtexies.size());
        ReadFiles();
        System.out.println(virtexies.toString());

        launch(args);
    }
}
