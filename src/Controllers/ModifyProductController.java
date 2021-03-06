package Controllers;

import Model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyProductController implements Initializable {

    private Product productToModify;

    @FXML private TableView allPartsTable;
    @FXML private TableView productPartsTable;

    @FXML private TableColumn<Part,Integer> colAddPartID;
    @FXML private TableColumn<Part,String> colAddPartName;
    @FXML private TableColumn<Part,Integer> colAddPartInv;
    @FXML private TableColumn<Part,Double> colAddPartPrice;

    @FXML private TableColumn<Part,Integer> colCurrPartID;
    @FXML private TableColumn<Part,String> colCurrPartName;
    @FXML private TableColumn<Part,Integer> colCurrPartInv;
    @FXML private TableColumn<Part,Double> colCurrPartPrice;


    @FXML private TextField addProductID;
    @FXML private TextField addProductName;
    @FXML private TextField addProductInv;
    @FXML private TextField addProductPrice;
    @FXML private TextField addProductMin;
    @FXML private TextField addProductMax;

    @FXML private TextField modifyProductSearchInput;

    Alert confirmDelete = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to Delete?", ButtonType.YES, ButtonType.CANCEL);
    Alert cancelConfirm = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to Cancel? ", ButtonType.YES, ButtonType.CANCEL);

    @FXML
    private AnchorPane rootPane;

    @FXML private TextField partSearchInputText;
    private int searchPartID;
    private boolean partFound = false;


    @FXML
    public void modifyProductAdd(){
        productToModify.addAssociatedPart(((Part) allPartsTable.getSelectionModel().getSelectedItem()).getPartID());
    }

    @FXML
    public void modifyProductSave() throws IOException{
        if(validateFields()){
            saveModifyProduct();
        }

    }

    private void saveModifyProduct() throws IOException{
        productToModify.setName(addProductName.getText());
        productToModify.setInStock(Integer.parseInt(addProductInv.getText()));
        productToModify.setPrice(Double.parseDouble(addProductPrice.getText()));
        productToModify.setMax(Integer.parseInt(addProductMax.getText()));
        productToModify.setMin(Integer.parseInt(addProductMin.getText()));
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Views/mainView.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    public void modifyProductDelete(){
        confirmDelete.showAndWait();
        if(confirmDelete.getResult() == ButtonType.YES){
            productPartsTable.getItems().remove(productPartsTable.getSelectionModel().getSelectedItem());
        }

    }

    @FXML
    public void modifyProductSearch()
    {
        System.out.println("Modify product Search clicked");
    }


    @FXML
    public void modifyProductCancel() throws IOException {
        cancelConfirm.showAndWait();
        if(cancelConfirm.getResult() == ButtonType.YES){
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../Views/mainView.fxml"));
            rootPane.getChildren().setAll(pane);
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        productToModify = new Product();
        productToModify = Inventory.findProductByID(Inventory.getModifyProductId());
        populateTextFields(productToModify);
        populatePartTable();

    }

    private void populatePartTable(){

        colAddPartID.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        colAddPartName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        colAddPartInv.setCellValueFactory(new PropertyValueFactory<Part, Integer>("inStock"));
        colAddPartPrice.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
        allPartsTable.refresh();
        allPartsTable.setItems(Inventory.getAllParts());

        colCurrPartID.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        colCurrPartName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        colCurrPartInv.setCellValueFactory(new PropertyValueFactory<Part, Integer>("inStock"));
        colCurrPartPrice.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
        productPartsTable.refresh();
        productPartsTable.setItems(productToModify.getAssociatedParts());


    }

    private void populateTextFields(Product prod){
        addProductID.setDisable(true);
        addProductName.setText(prod.getName());
        addProductInv.setText(Integer.toString(prod.getInStock()));
        addProductPrice.setText(Double.toString(prod.getPrice()));
        addProductMax.setText(Integer.toString(prod.getMax()));
        addProductMin.setText(Integer.toString(prod.getMin()));
    }

    private Boolean validateFields(){
        if(addProductName.getText().isEmpty() == true || addProductInv.getText().isEmpty() == true || addProductMax.getText().isEmpty() == true || addProductMin.getText().isEmpty() == true || addProductPrice.getText().isEmpty() == true){
            AlertBox.display("Modify Product Error", "Please Complete All Fields");
            return false;
        }else{
            if(Integer.parseInt(addProductMax.getText()) < Integer.parseInt(addProductMin.getText()) || Integer.parseInt(addProductMax.getText()) > Integer.parseInt(addProductInv.getText())){
                AlertBox.display("Modify Product Error", "Please ensure that Product Min does not exceed Product Min and that Product Inventory Does not Exceed Product Max.");
                return false;
            }else{
                if(productToModify.getAssociatedParts().size() < 1 ){
                    AlertBox.display("Modify Product Error", "Please Add Parts to the Product");
                    return false;
                }else{
                    if(Double.parseDouble(addProductPrice.getText()) < productToModify.getCostOfParts()){
                        AlertBox.display("Modify Product Error", "Please enter a Price greater than the cost of parts which is: " + productToModify.getCostOfParts());
                        return false;
                    }else{

                        return true;
                    }
                }

            }
        }
    }

    @FXML protected void searchAddProduct(javafx.event.ActionEvent event){
        partFound = false;
        if(Inventory.isInteger(partSearchInputText.getText()) == true){
            if(Inventory.findPartByID(Integer.parseInt(partSearchInputText.getText())) != null){
                searchPartID = Integer.parseInt(partSearchInputText.getText());
                partFound = true;
                highlightRowFromSearch();
            }else{
                AlertBox.display("Part Search Error", "Search failed. Please enter new terms to search.");
                partFound = false;
            }
        }

        if(Inventory.isInteger(partSearchInputText.getText()) == false){
            if(Inventory.findPartByName(partSearchInputText.getText()) != null){
                searchPartID = Inventory.findPartByName(partSearchInputText.getText()).getPartID();
                partFound = true;
                highlightRowFromSearch();
            }else{
                AlertBox.display("Part Search Error", "Search failed. Please enter new terms to search.");
                partFound = false;
            }
        }
    }

    private void highlightRowFromSearch(){
        if(partFound == true){
            for(int i = 0; i < allPartsTable.getItems().size(); i++){

                Part allPartHightlight = ((Part) allPartsTable.getItems().get(i));

                if(searchPartID == allPartHightlight.getPartID()){
                    allPartsTable.getSelectionModel().select(i);
                }

            }
            if(productPartsTable.getItems().size() > 0){
                for(int x = 0; x <productPartsTable.getItems().size(); x++){
                    Part addedPartHighlight = (Part) productPartsTable.getItems().get(x);
                    if(searchPartID == addedPartHighlight.getPartID()){
                        productPartsTable.getSelectionModel().select(x);
                    }
                }
            }

        }
    }

}
