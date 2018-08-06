package Controllers;

import Model.InHouse;
import Model.OutSourced;
import Model.Part;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyPartViewController implements Initializable{

    private InHouse inPartToModify;
    private OutSourced outPartToModify;
    private boolean isOutSourced;
    private ToggleGroup group;

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

    public InHouse getInPartToModify() {
        return inPartToModify;
    }

    public void setInPartToModify(InHouse inPartToModify) {
        this.inPartToModify = inPartToModify;
    }

    public OutSourced getOutPartToModify() {
        return outPartToModify;
    }

    public void setOutPartToModify(OutSourced outPartToModify) {
        this.outPartToModify = outPartToModify;
    }

    @FXML
    public void modifyPartSave(){
        System.out.println("Modify part save clicked");
    }




    @FXML
    public void modifyPartCancel() throws IOException {

        System.out.println("Modify part Cancel Clicked");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Views/mainView.fxml"));
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
