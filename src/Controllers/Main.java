package Controllers;

import Model.Inventory;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

//        //instantiating the Inventory Class
//        inventory = new Inventory();

        //Loading the Main View
        Parent root = FXMLLoader.load(getClass().getResource("../Views/mainView.fxml"));
        primaryStage.setTitle("Dan Burke | Software One");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
