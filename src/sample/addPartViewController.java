package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.Part;


public class addPartViewController implements Initializable {

    private Part partToAdd;
    private boolean isOutSourced;
    private ToggleGroup group;

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
    public void addPartSave(ActionEvent event){

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
    public void addPartCancel(ActionEvent event) throws IOException {

        System.out.println("Add part Cancel Clicked");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("mainView.fxml"));
        rootPane.getChildren().setAll(pane);

    }

    @FXML
    public void inHouseDial(ActionEvent event){

        isOutSourced = false;
        System.out.println("Set to In house");
    }

    @FXML
    public void outSourceDial(ActionEvent event){

        isOutSourced = true;
        System.out.println("Set to Outsourced");

    }


    @Override
    public void initialize(URL location, ResourceBundle resources){

        group = new ToggleGroup();
        inHouse.setToggleGroup(group);
        outSourced.setToggleGroup(group);

    }
}
