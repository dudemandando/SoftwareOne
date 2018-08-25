package Controllers;

import Model.InHouse;
import Model.Inventory;
import Model.OutSourced;
import Model.Part;
import com.sun.jdi.IntegerType;
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

    private Integer modifyPartId;
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
    @FXML  private TextField modifyPartCompanyOrMachineID;
    @FXML private javafx.scene.control.Label machineOrCompany;

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
    public void modifyPartSave(ActionEvent event) throws IOException{

        if(validateFields()){
            if(isOutSourced == false){
                System.out.println("Modify part save clicked -- inhouse");
                inPartToModify = new InHouse();
                inPartToModify.setPartID(modifyPartId);
                inPartToModify.setName(modifyPartName.getText());
                inPartToModify.setInStock(Integer.parseInt(modifyPartInv.getText()));
                inPartToModify.setPrice(Double.parseDouble(modifyPartPrice.getText()));
                inPartToModify.setMax(Integer.parseInt(modifyPartMax.getText()));
                inPartToModify.setMin(Integer.parseInt(modifyPartMin.getText()));
                inPartToModify.setMachineID(Integer.parseInt(modifyPartCompanyOrMachineID.getText()));


                Inventory.replacePart(inPartToModify);


            }else{
                System.out.println("Modify part save clicked -- outsourced");
                outPartToModify = new OutSourced();
                outPartToModify.setPartID(modifyPartId);
                outPartToModify.setName(modifyPartName.getText());
                outPartToModify.setInStock(Integer.parseInt(modifyPartInv.getText()));
                outPartToModify.setPrice(Double.parseDouble(modifyPartPrice.getText()));
                outPartToModify.setMax(Integer.parseInt(modifyPartMax.getText()));
                outPartToModify.setMin(Integer.parseInt(modifyPartMin.getText()));
                outPartToModify.setCompanyName(modifyPartCompanyOrMachineID.getText());

                Inventory.replacePart(outPartToModify);

            }

            AnchorPane pane = FXMLLoader.load(getClass().getResource("../Views/mainView.fxml"));
            rootPane.getChildren().setAll(pane);
        }

    }




    @FXML
    public void modifyPartCancel(ActionEvent event) throws IOException {

        System.out.println("Modify part Cancel Clicked");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Views/mainView.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    public void inHouseDial(ActionEvent event){

        isOutSourced = false;
        System.out.println("Set to In house");
        machineOrCompany.setText("Machine ID");
    }

    @FXML
    public void outSourceDial(ActionEvent event){

        isOutSourced = true;
        System.out.println("Set to Outsourced");
        machineOrCompany.setText("Company Name");

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
           modifyPartId = inPartToModify.getPartID();
           modifyPartName.setText(inPartToModify.getName());
           modifyPartInv.setText(Integer.toString(inPartToModify.getInStock()));
           modifyPartPrice.setText(Double.toString(inPartToModify.getPrice()));
           modifyPartMax.setText(Integer.toString(inPartToModify.getMax()));
           modifyPartMin.setText(Integer.toString(inPartToModify.getMin()));
           modifyPartCompanyOrMachineID.setText(Integer.toString(inPartToModify.getMachineID()));
           machineOrCompany.setText("Machine ID");

        }else{

            outPartToModify = (OutSourced)Inventory.findPartByID(Inventory.getModifyPartIdx());
            isOutSourced = true;
            outSourced.setSelected(true);
            modifyPartId = outPartToModify.getPartID();
            modifyPartName.setText(outPartToModify.getName());
            modifyPartInv.setText(Integer.toString(outPartToModify.getInStock()));
            modifyPartPrice.setText(Double.toString(outPartToModify.getPrice()));
            modifyPartMax.setText(Integer.toString(outPartToModify.getMax()));
            modifyPartMin.setText(Integer.toString(outPartToModify.getMin()));
            modifyPartCompanyOrMachineID.setText(outPartToModify.getCompanyName().toString());
            machineOrCompany.setText("Company Name");

        }
        Inventory.getAllParts().remove(Inventory.getModifyPartIdx());

    }

    private Boolean validateFields(){
        if( modifyPartName.getText().isEmpty() == true || modifyPartInv.getText().isEmpty() == true || modifyPartPrice.getText().isEmpty() == true || modifyPartMax.getText().isEmpty() == true || modifyPartMin.getText().isEmpty() | modifyPartCompanyOrMachineID.getText().isEmpty()){
            AlertBox.display("Add Part Error", "Please complete all Text Fields.");
            return false;
        }else{
            if(Integer.parseInt(modifyPartMax.getText()) < Integer.parseInt(modifyPartMin.getText()) || Integer.parseInt(modifyPartMax.getText()) > Integer.parseInt(modifyPartInv.getText())){
                AlertBox.display("Part Error", "Please ensure that Inventory does not exceed Part Maximum and Part Minimum is less than Part Maximum");
                return false;
            }else{
                return true;
            }

        }
    }

}
