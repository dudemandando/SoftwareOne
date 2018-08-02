package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Cell;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyPartViewController implements Initializable{

    @FXML
    private RadioButton inHouse;
    @FXML private RadioButton outSourced;

    @FXML  private TextField modifypartID;
    @FXML  private TextField modifypartName;
    @FXML  private TextField modifypartInv;
    @FXML  private TextField modifypartPrice;
    @FXML  private TextField modifypartMax;
    @FXML  private TextField modifypartMin;
    @FXML  private TextField modifypartCompanyName;

    @FXML private TextField modifypartSearchInput;

    @FXML
    private AnchorPane rootPane;

    @FXML
    public void modifyPartSave(){
        System.out.println("Modify part save clicked");
    }




    @FXML
    public void modifyPartCancel() throws IOException {

        System.out.println("Modify part Cancel Clicked");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("mainView.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){

    }
}
