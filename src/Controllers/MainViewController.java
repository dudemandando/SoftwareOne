package Controllers;

import Model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableObjectValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
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

    private boolean partFound = false;
    private boolean productFound = false;

    private int searchPartID;
    private int searchProductID;

    Alert confirmDelete = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to Delete?", ButtonType.YES, ButtonType.CANCEL);


    @FXML
    private Button exit;

    @FXML protected void partSearchMain(ActionEvent event){

        if(Inventory.isInteger(partSearchInputText.getText()) == true){
            if(Inventory.findPartByID(Integer.parseInt(partSearchInputText.getText())) != null){
                AlertBox.display("Part Search Error", "WORKED.");
            }else{
                AlertBox.display("Part Search Error", "Search failed. Please enter new terms to search.");
            }
        }

        if(Inventory.isInteger(partSearchInputText.getText()) == false){
            if(Inventory.findPartByName(partSearchInputText.getText()) != null){
                AlertBox.display("Part Search Error", "WORKED.");
            }else{
                AlertBox.display("Part Search Error", "Search failed. Please enter new terms to search.");
            }
        }



    }

    @ FXML protected void productSearchMain(ActionEvent event){
//        productFound = false;
//        if(productSearchInputText.getText().length() > 0){
//            //Search Names
//            if(Inventory.findProductByName(productSearchInputText.getText()) != null){
//                //product found
//                searchProductID = Inventory.findPartByID(Integer.parseInt(partSearchInputText.getText())).getPartID();
//                AlertBox.display("Part Search Error", "WORKED.");
//            }else{
//                //product name not found
//                if(Inventory.findProductByID(Integer.parseInt(productSearchInputText.getText())) != null){
//                    //product found by ID
//                    searchProductID = Inventory.findPartByID(Integer.parseInt(partSearchInputText.getText())).getPartID();
//                    AlertBox.display("Part Search Error", "WORKED.");
//
//                }else{
//                    //give alert to user
//                    AlertBox.display("Product Search Error", "Search failed. Please enter new terms to search.");
//                }
//            }
//
//        }
    }



    @FXML
    protected void partAddMain(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Views/addPart.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    protected void productAddMain(ActionEvent event) throws IOException{
        if(Inventory.getPartLength() <1){
            AlertBox.display("Part Error", "There are no parts in Inventory, please add a part before creating Products");
        }else{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../Views/addProduct.fxml"));
            rootPane.getChildren().setAll(pane);
        }

    }

    @FXML
    protected void partModifyMain(ActionEvent event) throws IOException{
        if(Inventory.getPartLength() < 1){
            AlertBox.display("Part Error", "There are no parts. Please add a part");
        }else{
            if(partTable.getSelectionModel().getSelectedItem() != null){
                Inventory.setModifyPartIdx(((Part) partTable.getSelectionModel().getSelectedItem()).getPartID());
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../Views/modifyPart.fxml"));
                ModifyPartViewController modifyControl = loader.getController();
                AnchorPane pane = FXMLLoader.load(getClass().getResource("../Views/modifyPart.fxml"));
                rootPane.getChildren().setAll(pane);
            }else{
                AlertBox.display("Part Error", "Please select a part to modify. If there are no parts listed, please add a part");
            }
        }

    }

    @FXML
    protected void productModifyMain(ActionEvent event) throws IOException{
        if(Inventory.getProductLength() < 1){
            AlertBox.display("Product Error", "There are no products. Please add a product");
        }else{
            if(productTable.getSelectionModel().getSelectedItem() != null){
                Inventory.setModifyProductId(((Product) productTable.getSelectionModel().getSelectedItem()).getProductID()) ;
                AnchorPane pane = FXMLLoader.load(getClass().getResource("../Views/modifyProduct.fxml"));
                rootPane.getChildren().setAll(pane);
            }else{
                AlertBox.display("Product Error", "Please select a product to modify. If there are no products listed, please add a product");
            }
        }

    }

    @FXML
    protected void partDeleteMain(ActionEvent event){
        if(Inventory.getPartLength() < 1){
            AlertBox.display("Part Error", "There are no parts. Please add a part");
        }else{
            if(partTable.getSelectionModel().getSelectedItem() != null){
                confirmDelete.showAndWait();
                if(confirmDelete.getResult() == ButtonType.YES){
                    partTable.getItems().removeAll(partTable.getSelectionModel().getSelectedItem());
                }
            }else{
                AlertBox.display("Part Error", "Please select a part to remove. If there are no parts listed, please add a part");
            }
        }
    }

    @FXML
    protected void productDeleteMain(ActionEvent event){
        if(Inventory.getProductLength() < 1){
            AlertBox.display("Product Error", "There are no products. Please add a product");
        }else{
            if(productTable.getSelectionModel().getSelectedItem() != null){
                confirmDelete.showAndWait();
                if(confirmDelete.getResult() == ButtonType.YES){
                    productTable.getItems().removeAll(productTable.getSelectionModel().getSelectedItem());
                }

            }else{
                AlertBox.display("Product Error", "Please select a product to remove. If there are no products listed, please add a product");
            }
        }
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
