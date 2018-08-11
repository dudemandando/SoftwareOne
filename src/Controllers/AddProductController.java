package Controllers;

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;

public class AddProductController implements Initializable {

    private Part partToAdd;
    private Product productToAdd;

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

    @FXML
    private AnchorPane rootPane;

    @FXML
    protected void addPart(ActionEvent event){

        partToAdd = (Part)allPartsTable.getSelectionModel().getSelectedItem();

    }

    @FXML
    protected void saveProduct(ActionEvent event) throws IOException{

        System.out.println("save product button");
        productToAdd = new Product();
        productToAdd.setProductID(Inventory.getProductLength()+1);
        productToAdd.setName(addProductName.getText());
        productToAdd.setInStock(Integer.parseInt(addProductInv.getText()));
        productToAdd.setPrice(Double.parseDouble(addProductPrice.getText()));
        productToAdd.setMax(Integer.parseInt(addProductMax.getText()));
        productToAdd.setMin(Integer.parseInt(addProductMin.getText()));

        Inventory.addProduct(productToAdd);

        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Views/mainView.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    protected void deleteProduct(ActionEvent event){

        System.out.println("delete Product button");
    }



    @FXML
    protected void cancelProduct(ActionEvent event) throws IOException {

        System.out.println("cancel add product");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Views/mainView.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    protected void searchAddProduct(ActionEvent event){

        System.out.println(" search add product");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        addProductID.setDisable(true);
        populatePartTable();

    }

    @FXML
    public void populatePartTable(){


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


    }
}
