package Model;

import javafx.beans.value.ObservableObjectValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    private static ObservableList<Product> products = FXCollections.observableArrayList();
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }
    public static ObservableList<Product> getProducts(){
        return products;
    }

    public static Integer getModifyPartIdx() {
        return modifyPartIdx;
    }

    public static void setModifyPartIdx(Integer modifyPartIdx) {
        Inventory.modifyPartIdx = modifyPartIdx;
    }

    private static Integer modifyPartIdx;

    public Inventory() {


    }

    public static void addProduct(Product item){
        products.add(item);
    }

    public static boolean removeProduct(int idx){
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

    public static boolean deletePart(int idx){
        try{
            allParts.remove(idx);
            return true;
        }catch(Exception e){
            return false;
        }

    }

    public static Product lookupProduct(int idx){

        return products.get(idx);
    }

    public static Part lookupPart(int idx){

        return allParts.get(idx);
    }

    public static void updateProduct(int idx, Product updatedProduct){

        products.set(idx, updatedProduct);
    }

    public static void updatePart(int idx, Part updatedPart){

        allParts.set(idx, updatedPart);
    }

    public static int getPartLength(){

        return allParts.size();
    }

    public static int getProductLength(){
        return products.size();
    }

    public static Part findPartByID(int id){

        for (Part part : allParts) {
            if (part.getPartID() == id){
                return part;
            }
        }
        return null;
    }


    public static void replacePart(Integer idx, Part part){
        allParts.set(modifyPartIdx-1, part);



    }


}
