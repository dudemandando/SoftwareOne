package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Cell;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.layout.AnchorPane;
import sample.Part;


public class addPartViewController implements Initializable {

    private Part partToAdd;

    @FXML private RadioButton inHouse;
    @FXML private RadioButton outSourced;

    @FXML  private TextField addPartID;
    @FXML  private TextField addPartName;
    @FXML  private TextField addPartInv;
    @FXML  private TextField addPartPrice;
    @FXML  private TextField addPartMax;
    @FXML  private TextField addPartMin;
    @FXML  private TextField addPartCompanyName;

    @FXML
    private AnchorPane rootPane;

    @FXML
    public void addPartSave(){

        System.out.println("Add part Save Button Clicked --" + addPartName.getText());

        partToAdd = new Part(
                addPartName.toString(),
                Double.parseDouble(addPartPrice.toString()),
                Integer.parseInt(addPartInv.toString()),
                Integer.parseInt(addPartMin.toString()),
                Integer.parseInt(addPartMax.toString())
        );
    }

    @FXML
    public void addPartCancel() throws IOException {

        System.out.println("Add part Cancel Clicked");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("mainView.fxml"));
        rootPane.getChildren().setAll(pane);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources){

    }
}
