package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Cell;
import javafx.scene.control.Button;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyProductController implements Initializable {

    @FXML private RadioButton inHouse;
    @FXML private RadioButton outSourced;

    @FXML  private TextField modifyProductID;
    @FXML  private TextField modifyProductName;
    @FXML  private TextField modifyProductInv;
    @FXML  private TextField modifyProductPrice;
    @FXML  private TextField modifyProductMax;
    @FXML  private TextField modifyProductMin;
    @FXML  private TextField modifyProductCompanyName;

    @FXML private TextField modifyProductSearchInput;


    @FXML
    public void modifyProductAdd(){
        System.out.println("Modify product Add Button Clicked --" );
    }

    @FXML
    public void modifyProductSave(){
        System.out.println("Modify product save clicked");
    }

    @FXML
    public void modifyProductDelete(){
        System.out.println("Modify product delete clicked");
    }

    @FXML
    public void modifyProductSearch(){
        System.out.println("Modify product Search clicked");
    }


    @FXML
    public void modifyProductCancel(){
        System.out.println("Modify product Cancel Clicked");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){

    }
}
