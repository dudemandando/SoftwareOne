package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    private static ObservableList<Product> products = FXCollections.observableArrayList();
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();

    public Inventory() {


    }

    public static void addProduct(Product item){
        products.add(item);
    }

    public boolean removeProduct(int idx){
        try{
            products.remove(idx);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public static void addPart(Part item){

        allParts.add(item);
        System.out.println(allParts.size());
    }

    public boolean deletePart(int idx){
        try{
            allParts.remove(idx);
            return true;
        }catch(Exception e){
            return false;
        }

    }

    public Product lookupProduct(int idx){

        return products.get(idx);
    }

    public Part lookupPart(int idx){

        return allParts.get(idx);
    }

    public void updateProduct(int idx, Product updatedProduct){
       products.set(idx, updatedProduct);
    }

    public void updatePart(int idx, Part updatedPart){

        allParts.set(idx, updatedPart);
    }

    public static int getPartLength(){
        return allParts.size();
    }

}
