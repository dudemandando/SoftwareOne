package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {


    @FXML
    protected void partSearchMain(ActionEvent event){
        System.out.println("Part Search Main Clicked");
    }

    @FXML
    protected void productSearchMain(ActionEvent event){
        System.out.println("Product Search Main Clicked");
    }

    @FXML
    protected void partAddMain(ActionEvent event){

        System.out.println("Part Add Main Clicked");
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
