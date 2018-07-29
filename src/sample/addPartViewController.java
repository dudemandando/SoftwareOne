package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Cell;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;


public class addPartViewController implements Initializable {

    @FXML private RadioButton inHouse;
    @FXML private RadioButton outSourced;

    @FXML  private TextField addPartID;
    @FXML  private TextField addPartName;
    @FXML  private TextField addPartInv;
    @FXML  private TextField addPartPrice;
    @FXML  private TextField addParttMax;
    @FXML  private TextField addPartMin;
    @FXML  private TextField addPartCompanyName;


    @FXML
    public void addPartSave(){
        System.out.println("Add part Save Button Clicked --" + addPartName.getText());
    }

    @FXML
    public void addPartCancel(){
        System.out.println("Add part Cancel Clicked");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources){

    }
}
