package Controllers;

import Model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableObjectValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML private AnchorPane rootPane;
    @FXML private TableView partTable;
    @FXML private TableView productTable;

    @FXML private TableColumn<Part,Integer> colpartID;
    @FXML private TableColumn<Part,String> colPartName;
    @FXML private TableColumn<Part,Integer> colPartInv;
    @FXML private TableColumn<Part,Double> colPartPrice;

    @FXML private TableColumn<Part,Integer> colProductID;
    @FXML private TableColumn<Part,String> colProductName;
    @FXML private TableColumn<Part,Integer> colProductInv;
    @FXML private TableColumn<Part,Double> colProductPrice;


    @FXML private TextField partSearchInputText;
    @FXML private TextField productSearchInputText;

    @FXML
    private Button exit;



    @FXML protected void partSearchMain(ActionEvent event){

        System.out.println("Part Search Main Clicked --" + partSearchInputText.getText());
    }

    @FXML
    protected void productSearchMain(ActionEvent event){

        System.out.println("Product Search Main Clicked--" + productSearchInputText.getText());
    }

    @FXML
    protected void partAddMain(ActionEvent event) throws IOException {

        System.out.println("Part Add Main Clicked");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Views/addPart.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    protected void productAddMain(ActionEvent event) throws IOException{

        System.out.println("Product Add Main Clicked");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Views/addProduct.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    protected void partModifyMain(ActionEvent event) throws IOException{

        System.out.println("Part Modify Main Clicked");
        Inventory.setModifyPartIdx(((Part) partTable.getSelectionModel().getSelectedItem()).getPartID());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Views/modifyPart.fxml"));
        ModifyPartViewController modifyControl = loader.getController();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Views/modifyPart.fxml"));
        rootPane.getChildren().setAll(pane);


    }

    @FXML
    protected void productModifyMain(ActionEvent event) throws IOException{

        System.out.println("Product Modify Main Clicked");
        Inventory.setModifyProductId(((Product) productTable.getSelectionModel().getSelectedItem()).getProductID()) ;
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Views/modifyProduct.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    protected void partDeleteMain(ActionEvent event){

        System.out.println("Part Delete Main Clicked");
        partTable.getItems().removeAll(partTable.getSelectionModel().getSelectedItem());
    }

    @FXML
    protected void productDeleteMain(ActionEvent event){

        System.out.println("Product Delete Main Clicked");
    }

    @FXML
    protected void exit(ActionEvent event){
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources){

            populatePartTable();
            populateProductTable();
    }

    @FXML
    public void populatePartTable(){

        colpartID.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        colPartName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        colPartInv.setCellValueFactory(new PropertyValueFactory<Part, Integer>("inStock"));
        colPartPrice.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
        partTable.refresh();
        partTable.setItems(Inventory.getAllParts());
    }

    @FXML
    public void populateProductTable(){

        colProductID.setCellValueFactory(new PropertyValueFactory<Part, Integer>("productID"));
        colProductName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        colProductInv.setCellValueFactory(new PropertyValueFactory<Part, Integer>("inStock"));
        colProductPrice.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
        productTable.refresh();
        productTable.setItems(Inventory.getProducts());
    }




}
