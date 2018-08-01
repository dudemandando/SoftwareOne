package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML private TextField partSearchInputText;
    @FXML private TextField productSearchInputText;

    @FXML
    protected void partSearchMain(ActionEvent event){

        System.out.println("Part Search Main Clicked --" + partSearchInputText.getText());
    }

    @FXML
    protected void productSearchMain(ActionEvent event){

        System.out.println("Product Search Main Clicked--" + productSearchInputText.getText());
    }

    @FXML
    protected void partAddMain(ActionEvent event) throws IOException {

        System.out.println("Part Add Main Clicked");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("addPart.fxml"));
        rootPane.getChildren().setAll(pane);

    }

    @FXML
    protected void productAddMain(ActionEvent event){

        System.out.println("Product Add Main Clicked");
    }

    @FXML
    protected void partModifyMain(ActionEvent event){

        System.out.println("Part Modify Main Clicked");
    }

    @FXML
    protected void productModifyMain(ActionEvent event){

        System.out.println("Product Modify Main Clicked");
    }

    @FXML
    protected void partDeleteMain(ActionEvent event){

        System.out.println("Part Delete Main Clicked");
    }

    @FXML
    protected void productDeleteMain(ActionEvent event){

        System.out.println("Product Delete Main Clicked");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources){

    }


}
