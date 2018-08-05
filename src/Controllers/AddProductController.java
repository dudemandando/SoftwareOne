package Controllers;

import Model.Inventory;
import Model.Part;
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

public class AddProductController implements Initializable {

    private Part partToAdd;

    @FXML private TableView allPartsTable;
    @FXML private TableView productPartsTable;

    @FXML private TableColumn<Part,Integer> colAddPartID;
    @FXML private TableColumn<Part,String> colAddPartName;
    @FXML private TableColumn<Part,Integer> colAddPartInv;
    @FXML private TableColumn<Part,Double> colAddPartPrice;

    @FXML private TextField addProductID;
    @FXML private TextField addProductName;
    @FXML private TextField addProductInv;
    @FXML private TextField addProductPrice;
    @FXML private TextField addProductMin;
    @FXML private TextField addProductMax;

    @FXML
    private AnchorPane rootPane;

    @FXML
    protected void addProduct(ActionEvent event){
        System.out.println("add Product button -- " + addProductID.getText());


    }

    @FXML
    protected void deleteProduct(ActionEvent event){

        System.out.println("delete Product button");
    }

    @FXML
    protected void saveProduct(ActionEvent event){

        System.out.println("save product button");
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
        populatePartTable();

    }

    @FXML
    public void populatePartTable(){

        System.out.println("Populating Parts Table");
        colAddPartID.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        colAddPartName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        colAddPartInv.setCellValueFactory(new PropertyValueFactory<Part, Integer>("inStock"));
        colAddPartPrice.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));

       allPartsTable.setItems(Inventory.allParts);
    }
}
