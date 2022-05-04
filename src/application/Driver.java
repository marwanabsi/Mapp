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

    public static void ReadFiles2(){
        try {
            Scanner inScanner = new Scanner(new File("src/Roads.txt"));

            while (inScanner.hasNext()) {
                String[] loc = inScanner.nextLine().split("#");
                for (int i=0;i<virtexies.size();i++){
                    if (loc[0].equalsIgnoreCase(virtexies.get(i).getName())){
                        Vertix k=null;
                        for (int j=0;j<virtexies.size();j++){
                            if (loc[1].equals(virtexies.get(j).getName())){
                                k=virtexies.get(j);
                            }
                        }
                        Edge y = new Edge(virtexies.get(i),k,Integer.parseInt(loc[2]));
                        virtexies.get(i).adjacencies.add(y) ;
                    }
                    else
                        continue;
                }

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
        //System.out.println(virtexies.size());
        ReadFiles();
        ReadFiles2();
        //System.out.println(virtexies.toString());
        launch(args);
    }
}
