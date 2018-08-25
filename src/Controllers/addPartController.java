package Controllers;
import Model.InHouse;
import Model.Inventory;
import Model.OutSourced;
import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.RadioButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class addPartController implements Initializable {


    private OutSourced partToAddOut;
    private InHouse partToAddIn;
    private boolean isOutSourced;
    private ToggleGroup group;

    private String errorMessage;

    @FXML private RadioButton inHouse;
    @FXML private RadioButton outSourced;

    @FXML  private TextField addPartID;
    @FXML  private TextField addPartName;
    @FXML  private TextField addPartInv;
    @FXML  private TextField addPartPrice;
    @FXML  private TextField addPartMax;
    @FXML  private TextField addPartMin;
    @FXML  private TextField companyOrMachineID;
    @FXML private javafx.scene.control.Label machineOrCompany;


    @FXML
    private AnchorPane rootPane;

    @FXML
    public void addPartSave(ActionEvent event) throws IOException{
       if(validateFields()){
           addPartToInventory();
       }
    }


    @FXML
    public void addPartCancel(ActionEvent event) throws IOException {

        System.out.println("Add part Cancel Clicked");
        loadMain();

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
        inHouse.setSelected(true);
        isOutSourced = false;
        machineOrCompany.setText("Machine ID");
        addPartID.setDisable(true);

    }

    private void loadMain() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Views/mainView.fxml"));
        rootPane.getChildren().setAll(pane);
        addPartID.setText(Integer.toString(Inventory.getPartLength()+1));
    }

    private void addPartToInventory()throws IOException{
        if(isOutSourced == true){
            partToAddOut = new OutSourced();
            partToAddOut.setPartID(Inventory.getPartLength()+1);
            partToAddOut.setName(addPartName.getText());
            partToAddOut.setInStock(Integer.parseInt(addPartInv.getText()));
            partToAddOut.setPrice(Double.parseDouble(addPartPrice.getText()));
            partToAddOut.setMax(Integer.parseInt(addPartMax.getText()));
            partToAddOut.setMin(Integer.parseInt(addPartMin.getText()));
            partToAddOut.setCompanyName(companyOrMachineID.toString());

            Inventory.addPart(partToAddOut);
            loadMain();

        }else{
            partToAddIn = new InHouse();
            partToAddIn.setPartID(Inventory.getPartLength()+1);
            partToAddIn.setName(addPartName.getText());
            partToAddIn.setInStock(Integer.parseInt(addPartInv.getText()));
            partToAddIn.setPrice(Double.parseDouble(addPartPrice.getText()));
            partToAddIn.setMax(Integer.parseInt(addPartMax.getText()));
            partToAddIn.setMin(Integer.parseInt(addPartMin.getText()));
            partToAddIn.setMachineID(Integer.parseInt(companyOrMachineID.getText()));

            Inventory.addPart(partToAddIn);
            loadMain();
        }
    }



    private Boolean validateFields(){
        if( addPartName.getText().isEmpty() == true || addPartInv.getText().isEmpty() == true || addPartPrice.getText().isEmpty() == true || addPartMax.getText().isEmpty() == true || addPartMin.getText().isEmpty() | companyOrMachineID.getText().isEmpty()){
            System.out.println("empty");
            AlertBox.display("Add Part Error", "Please complete all Text Fields.");
            return false;
        }else{
            if(Integer.parseInt(addPartMax.getText()) < Integer.parseInt(addPartMin.getText()) || Integer.parseInt(addPartMax.getText()) > Integer.parseInt(addPartInv.getText())){
                AlertBox.display("Part Error", "Please ensure that Inventory does not exceed Part Maximum and Part Minimum is less than Part Maximum");
                return false;
            }else{
                return true;
            }

        }
    }
}
