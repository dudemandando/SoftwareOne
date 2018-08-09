package Controllers;

import Model.InHouse;
import Model.Inventory;
import Model.OutSourced;
import Model.Part;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.DataOutput;
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
    @FXML  private TextField modifyPartName;
    @FXML  private TextField modifyPartInv;
    @FXML  private TextField modifyPartPrice;
    @FXML  private TextField modifyPartMax;
    @FXML  private TextField modifyPartMin;
    @FXML  private TextField modifyPartCompanyName;

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

        if (Inventory.findPartByID(Inventory.getModifyPartIdx()).getClass().getName() == "Model.InHouse") {
           inPartToModify =  (InHouse)Inventory.findPartByID(Inventory.getModifyPartIdx());
           isOutSourced = false;
           inHouse.setSelected(true);
           modifyPartName.setText(inPartToModify.getName());
           modifyPartInv.setText(Integer.toString(inPartToModify.getInStock()));
           modifyPartPrice.setText(Double.toString(inPartToModify.getPrice()));
           modifyPartMax.setText(Integer.toString(inPartToModify.getMax()));
           modifyPartMin.setText(Integer.toString(inPartToModify.getMin()));

        }else{

            outPartToModify = (OutSourced)Inventory.findPartByID(Inventory.getModifyPartIdx());
            System.out.println(outPartToModify.getName() + "The name of the part");
            isOutSourced = true;
            outSourced.setSelected(true);
            modifyPartName.setText(outPartToModify.getName());
            modifyPartInv.setText(Integer.toString(outPartToModify.getInStock()));
            modifyPartPrice.setText(Double.toString(outPartToModify.getPrice()));
            modifyPartMax.setText(Integer.toString(outPartToModify.getMax()));
            modifyPartMin.setText(Integer.toString(outPartToModify.getMin()));

        }


    }

}
