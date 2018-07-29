package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {

    @FXML
    protected void addProduct(ActionEvent event){
        System.out.println("add Product button");
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
    protected void cancelProduct(ActionEvent event){
        System.out.println("cancel product");
    }

    @FXML
    protected void searchAddProduct(ActionEvent event){
        System.out.println(" search add product");
    }




    @Override
    public void initialize(URL location, ResourceBundle resources){

    }
}
