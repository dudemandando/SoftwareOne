package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import java.awt.*;
import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.Inventory;
import sample.Part;



public class addPartController implements Initializable {

    private Main main;
    private OutSourced partToAddOut;
    private Inhouse partToAddIn;
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
    @FXML  private TextField companyOrMachineID;
    @FXML private javafx.scene.control.Label machineOrCompany;


    @FXML
    private AnchorPane rootPane;

    @FXML
    public void addPartSave(ActionEvent event) throws IOException{

        System.out.println("Add part Save Button Clicked --" );

        if(isOutSourced == true){
            partToAddOut = new OutSourced(
                    addPartName.toString(),
                    Double.parseDouble(addPartPrice.getText()),
                    Integer.parseInt(addPartInv.getText()),
                    Integer.parseInt(addPartMin.getText()),
                    Integer.parseInt(addPartMax.getText()),
                    companyOrMachineID.toString());

            Inventory.addPart(partToAddOut);
            loadMain();

        }else{
            partToAddIn = new Inhouse(
                    Inventory.getPartLength(),
                    addPartName.toString(),
                    Double.parseDouble(addPartPrice.getText()),
                    Integer.parseInt(addPartInv.getText()),
                    Integer.parseInt(addPartMin.getText()),
                    Integer.parseInt(addPartMax.getText()),
                    Integer.parseInt(companyOrMachineID.getText())
                    );

            Inventory.addPart(partToAddIn);
            loadMain();
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

    }

    private void loadMain() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("mainView.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
